/**
 * 
 */
package bigraphspace.model.xml;


import javax.xml.parsers.ParserConfigurationException;


import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

import bigraphspace.api.BigraphChangedEvent;
import bigraphspace.api.BigraphChangedListener;
import bigraphspace.api.BigraphRuntimeException;
import bigraphspace.api.BigraphSession;
import bigraphspace.api.BigraphSessionHandler;
import bigraphspace.api.ReactionRule;
import bigraphspace.api.ReactiveBigraph;
import bigraphspace.api.RuleCondition;
import bigraphspace.api.RuleFiredEvent;
import bigraphspace.api.BigraphSession.Mode;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Match;

/** Dom-based implementation of ReactiveBigraph.
 * 
 * @author cmg
 *
 */
public class DomReactiveBigraph implements ReactiveBigraph, BigraphSessionHandler {
	/** logger */
	static Logger logger = Logger.getLogger(DomReactiveBigraph.class);
	/** the bigraph */
	protected DomBigraph bigraph;
	/** if we are a sub-bigraph, this is the master */
	protected DomBigraph rootBigraph;
	/** if we are a sub-bigraph, this is the name of the control which is our root */
	protected String rootControlName;
	/** if we are a sub-bigraph this is the optional name of the support of the node which is our root */
	protected String rootSupport;
	
	/** listeners */
	protected LinkedList<BigraphChangedListener> changeListeners = new LinkedList<BigraphChangedListener>();

	/** reaction rules */
	protected LinkedList<ReactionRule> reactionRules = new LinkedList<ReactionRule>();

	/** current active session */
	protected DomBigraphSession currentSession = null;
	
	/** queue of sessions beginning */
	protected LinkedList<DomBigraphSession> newSessionQueue =  new LinkedList<DomBigraphSession>();
	
	/** callback thread */
	protected class CallbackThread extends Thread {
		boolean stopped = false;
		/** listeners */
		LinkedList<BigraphChangedListener> changeListenersToCall = new LinkedList<BigraphChangedListener>();
		/** schedule change listeners to be called */
		protected synchronized void scheduleChangeListeners() {
			synchronized(changeListeners) {
				for (BigraphChangedListener cl : changeListeners) {
					if (!changeListenersToCall.contains(cl))
						changeListenersToCall.add(cl);
				}
			}
			if (!changeListenersToCall.isEmpty())
				notify();
		}
		/** schedule rule runner change listener to be called */
		protected synchronized void scheduleRuleRunner() {
			synchronized(changeListeners) {
				if (ruleRunner!=null && !changeListenersToCall.contains(ruleRunner))
					changeListenersToCall.add(ruleRunner);
			}
			if (!changeListenersToCall.isEmpty())
				notify();
		}
		public void run() {
			try {
				BigraphChangedEvent bce = new BigraphChangedEvent(DomReactiveBigraph.this);
				LinkedList<BigraphChangedListener> changeListeners = null;
				while(!stopped) {
					synchronized (this) {
						// copy
						changeListeners = changeListenersToCall;
						changeListenersToCall = new LinkedList<BigraphChangedListener>();
						if (changeListeners.isEmpty()) {
							logger.debug("Waiting for a change listener");
							wait();
						}
					}
					while(!changeListeners.isEmpty()) {
						BigraphChangedListener listener = changeListeners.removeFirst();
						try {
							listener.bigraphChanged(bce);
						}
						catch (Exception e) {
							logger.error("in callback "+listener, e);
						}
						catch (ThreadDeath e) {
							logger.error("in callback "+listener, e);
							// rethrow
							throw e;
						}
						catch (Error e) {
							logger.error("in callback "+listener, e);
						}
					}
				}
			}
			catch (InterruptedException e) {
				logger.error("Callback thread interrupted", e);
			}
		}
		public void stopCallbacks() {
			synchronized (this) {
				stopped = true;
				this.notify();
			}
		}
	}
	/** call back thread */
	protected CallbackThread callbackThread;
	/** start callbacks */
	public synchronized void startCallbacks() 
	{
		if (callbackThread==null) {
			callbackThread = new CallbackThread();
			callbackThread.start();
			// conservatively run initial callbacks?!
			callbackThread.scheduleChangeListeners();
		}
	}
	/** stop callback */
	public synchronized void stopCallbacks() {
		if (callbackThread!=null) {
			callbackThread.stopCallbacks();
			callbackThread = null;
		}
	}
	/** rule runner singleton */
	protected RuleRunner ruleRunner;
	/**
	 * 
	 */
	public DomReactiveBigraph(BasicSignature signature) {
		logger.debug("Created DomReactiveBigraph");
		// simple cons
		try {
			bigraph = new DomBigraph(signature);

		}
		catch (ParserConfigurationException e) {
			throw new BigraphRuntimeException("Creating new bigraph", e);
		}
		ruleRunner = new RuleRunner();
		// add rule-handling callback 
		this.addBigraphChangedListener(ruleRunner);
		// start listeners by default?!
		startCallbacks();
	}
	/* (non-Javadoc)
	 * @see bigraphspace.api.ReactiveBigraph#addBigraphChangedListener(bigraphspace.api.BigraphChangedListener)
	 */
	@Override
	public void addBigraphChangedListener(BigraphChangedListener listener) {
		synchronized(changeListeners) {
			if (!changeListeners.contains(listener))
				changeListeners.add(listener);
		}
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.ReactiveBigraph#addReactionRule(bigraphspace.api.ReactionRule)
	 */
	@Override
	public void addReactionRule(ReactionRule rule) {
		synchronized(reactionRules) {
			if (!reactionRules.contains(rule))
				reactionRules.add(rule);
		}
		// run straight off?!
		synchronized(this) {
			if (this.callbackThread!=null)
				callbackThread.scheduleRuleRunner();
		}
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.ReactiveBigraph#getSession()
	 */
	@Override
	public BigraphSession getSession() {
		return new DomBigraphSession(this);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.ReactiveBigraph#removeBigraphChangedListener(bigraphspace.api.BigraphChangedListener)
	 */
	@Override
	public void removeBigraphChangedListener(BigraphChangedListener listener) {
		synchronized(changeListeners) {
			changeListeners.remove(listener);
		}
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.ReactiveBigraph#removeReactionRule(bigraphspace.api.ReactionRule)
	 */
	@Override
	public void removeReactionRule(ReactionRule rule) {
		synchronized(reactionRules) {
			reactionRules.remove(rule);
		}
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSessionHandler#handleBegin(bigraphspace.api.BigraphSession, bigraphspace.api.BigraphSession.Mode)
	 */
	@Override
	public Bigraph handleBegin(BigraphSession session, Mode mode) {
		if (!(session instanceof DomBigraphSession)) 
			throw new IllegalArgumentException("DomReactiveBigraph requires DomBigraphSession as session ("+session+")");
		DomBigraphSession domSession = (DomBigraphSession)session;
		if (session.getReactiveBigraph()!=this)
			throw new IllegalArgumentException("DomReactiveBigraph received session for another bigraph ("+session+" for "+session.getReactiveBigraph()+")");

		synchronized(this) {
			if (this.currentSession==null) 
			{
				this.currentSession = domSession;
				domSession.waitingForBegin = false;
			}
			else
			{
				this.newSessionQueue.add(domSession);
				domSession.waitingForBegin = true;
			}
		}
		// only get past here when we are in control!
		while(domSession.waitingForBegin)
			try {
				// should have been called with session locked
				session.wait();
			}
			catch (InterruptedException ie) {
				throw new BigraphRuntimeException("handleBegin wait interrupted", ie);
			}
		
		return this.bigraph;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSessionHandler#handleEnd(bigraphspace.api.BigraphSession, boolean)
	 */
	@Override
	public void handleEnd(BigraphSession session, Bigraph value, boolean commit) {
		if (!(session instanceof DomBigraphSession)) 
			throw new IllegalArgumentException("DomReactiveBigraph requires DomBigraphSession as session ("+session+")");
		DomBigraphSession domSession = (DomBigraphSession)session;
		if (session.getReactiveBigraph()!=this)
			throw new IllegalArgumentException("DomReactiveBigraph received session for another bigraph ("+session+" for "+session.getReactiveBigraph()+")");
		if (session!=currentSession)
			throw new IllegalArgumentException("DomReactiveBigraph.handleEnd received non-current session ("+session+")");
		if (commit && value==null)
			throw new IllegalArgumentException("DomReactiveBigraph.handleEnd received null bigraph for commit");
		if (value!=null && !(value instanceof DomBigraph))
			throw new IllegalArgumentException("DomReactiveBigraph.handleEnd requires DomBigraph as value ("+value+")");
		DomBigraph domBigraph = (DomBigraph)value;
		
		if (commit) {
			// TODO 
			// check if the result is equivalent to the initial value and suppress change if so.
			
			if (rootBigraph!=null)
				throw new BigraphRuntimeException("Unimplemented: update of sub-reactive bigraph");
			
			// simple case - local graph
			this.bigraph = domBigraph;
			
			synchronized(this) {
				if (callbackThread!=null)
					callbackThread.scheduleChangeListeners();
			}
		}
		// kick off next/waiting thread
		synchronized (this) {
			this.currentSession = null;
			if (!this.newSessionQueue.isEmpty()) {
				DomBigraphSession nextSession = this.newSessionQueue.removeFirst();
				nextSession.waitingForBegin = false;
				this.currentSession = nextSession;
				// we cannot be the thread blocked in handleBegin
				synchronized(nextSession) {
					nextSession.notify();
				}
			}
		}
	}
	/** rule runner - run rules in bigraph change listener */
	class RuleRunner implements BigraphChangedListener {

		/* (non-Javadoc)
		 * @see bigraphspace.api.BigraphChangedListener#bigraphChanged(bigraphspace.api.BigraphChangedEvent)
		 */
		@Override
		public void bigraphChanged(BigraphChangedEvent bce) {
			logger.info("RuleRunner.bigraphChanged...");
			// all current rules?!
			LinkedList<ReactionRule> rulesToRun = null;
			synchronized(this) {
				rulesToRun = new LinkedList<ReactionRule>(DomReactiveBigraph.this.reactionRules);
			}
			while (!rulesToRun.isEmpty()) {
				ReactionRule rule = rulesToRun.removeFirst();
				runRule(rule);
			}
		}		
	}
	/** called from rule runner from BigraphChangedListener */
	protected void runRule(ReactionRule rule) {
		logger.debug("runRule("+rule+")");
		// session 
		BigraphSession session = this.getSession();
		session.begin(rule.getSessionMode());
		try {
			// possible event 
			RuleFiredEvent rfe = new RuleFiredEvent();
			rfe.setBigraph(this);
			rfe.setRule(rule);
			LinkedList<List<Match>> preconditionMatches = rfe.getPreconditionMatches();
			for (RuleCondition condition: rule.getPreconditions()) {
				List<Match> matches = checkCondition(session, condition);
				preconditionMatches.add(matches);
				
				if (!conditionSatisfied(condition, matches)) {
					// nope
					logger.debug("Rule precondition fails on "+matches.size()+" (min="+condition.getMinOccurs()+", max="+condition.getMaxOccurs()+")");
					return;
				}
			}
			RuleCondition condition = rule.getRedex();
			// no redex, no go
			if (condition==null) {
				logger.debug("Rule with null regex");
				return;
			}
			List<Match> matches = checkCondition(session, condition);
			rfe.setRedexMatches(matches);
			if (!conditionSatisfied(condition, matches)) {
				// nope
				logger.debug("Rule regex fails on "+matches.size()+" (min="+condition.getMinOccurs()+", max="+condition.getMaxOccurs()+")");
				return;
			}
			// redex match & reactum?
			if (matches.size()>0 && rule.getReactum()!=null) {
				logger.debug("Applying rule!");
				session.update(matches.get(0), rule.getReactum());
			}
			// callbacks
			rule.ruleFired(rfe, session);
			
			// done - commit
			session.end();
		}
		catch (Exception e) {
			logger.error("Running rule", e);
		}
		finally {
			if (session.getState()!=BigraphSession.State.idle)
				session.abort();
		}
	}
	/** do "enough" matches for a condition */
	List<Match> checkCondition(BigraphSession session, RuleCondition condition) {
		int maxMatches = (condition.getMaxOccurs()==RuleCondition.UNLIMITED) ? condition.getMinOccurs() : condition.getMaxOccurs()+1;
		logger.debug("Looking for up to "+maxMatches+" for condition with minOccurs="+condition.getMinOccurs()+" and maxOccurs="+condition.getMaxOccurs());
		return session.match(condition.getPattern(), maxMatches);
	}
	/** condition satisfied? */
	boolean conditionSatisfied(RuleCondition condition, List<Match> matches) {
		if (condition.getMinOccurs()>condition.getMaxOccurs() && condition.getMaxOccurs()!=RuleCondition.UNLIMITED) {
			logger.warn("Impossible condition with minOccurs="+condition.getMinOccurs()+" and maxOccurs="+condition.getMaxOccurs());
			return false;
		}
		if (matches.size()<condition.getMinOccurs() || (condition.getMaxOccurs()!=RuleCondition.UNLIMITED && matches.size()>condition.getMaxOccurs())) {
			logger.debug("Found "+matches.size()+" matches for condition with minOccurs="+condition.getMinOccurs()+" and maxOccurs="+condition.getMaxOccurs()+" - rejected");
			return false;
		}
		logger.debug("Found "+matches.size()+" matches for condition with minOccurs="+condition.getMinOccurs()+" and maxOccurs="+condition.getMaxOccurs()+" - OK");
		if (condition.isActiveContext())
			logger.warn("RuleCondition.isActiveContext test not implemented - assuming satisfied");
		// TODO check active
		return true;
	}
}
