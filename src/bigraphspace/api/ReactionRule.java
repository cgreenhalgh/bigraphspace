/**
 * 
 */
package bigraphspace.api;

import java.util.List;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import bigraphspace.api.BigraphSession.Mode;
import bigraphspace.model.Bigraph;

/** ReactionRule for ReactiveBigraph - more hooks into code than a simple ReactionRule.
 * FOr example, a null reactum implies the rule itself won't do anything, but the listener(s) might.
 * 
 * @author cmg
 *
 */
public class ReactionRule {
	/** logger */
	static Logger logger = Logger.getLogger(ReactionRule.class);
	/** pre-conditions */
	protected LinkedList<RuleCondition> preconditions = new LinkedList<RuleCondition>();
	/** redex. Note that it is stupid to have a redex with maxOccurs<1, or rather nothing will actually
	 * happen, although if there are preconditions then the listener will still fire (with a null match) */
	protected RuleCondition redex;
	/** reactum - may be null if nothing to be changed */
	protected Bigraph reactum;
	/** readonly? readwrite by default. Note that a readonly only makes sense if there is no reactum. */
	protected BigraphSession.Mode sessionMode = BigraphSession.Mode.readwrite;
	/** reaction rule listeners */
	protected LinkedList<RuleFiredListener> ruleFiredListeners = new LinkedList<RuleFiredListener>(); 
	/** cons */
	public ReactionRule() {
	}
	/**
	 * @param preconditions
	 * @param redex
	 * @param reactum
	 */
	public ReactionRule(LinkedList<RuleCondition> preconditions,
			RuleCondition redex, Bigraph reactum) {
		super();
		this.preconditions = preconditions;
		this.redex = redex;
		this.reactum = reactum;
	}
	/**
	 * @param preconditions
	 * @param redex
	 * @param reactum
	 * @param sessionMode
	 */
	public ReactionRule(LinkedList<RuleCondition> preconditions,
			RuleCondition redex, Bigraph reactum, Mode sessionMode) {
		super();
		this.preconditions = preconditions;
		this.redex = redex;
		this.reactum = reactum;
		this.sessionMode = sessionMode;
	}
	/**
	 * @return the preconditions
	 */
	public LinkedList<RuleCondition> getPreconditions() {
		return preconditions;
	}
	/**
	 * @param preconditions the preconditions to set
	 */
	public void setPreconditions(LinkedList<RuleCondition> preconditions) {
		this.preconditions = preconditions;
	}
	/**
	 * @return the redex
	 */
	public RuleCondition getRedex() {
		return redex;
	}
	/**
	 * @param redex the redex to set
	 */
	public void setRedex(RuleCondition redex) {
		this.redex = redex;
	}
	/**
	 * @return the reactum
	 */
	public Bigraph getReactum() {
		return reactum;
	}
	/**
	 * @param reactum the reactum to set
	 */
	public void setReactum(Bigraph reactum) {
		this.reactum = reactum;
	}
	/**
	 * @return the sessionMode
	 */
	public BigraphSession.Mode getSessionMode() {
		return sessionMode;
	}
	/**
	 * @param sessionMode the sessionMode to set
	 */
	public void setSessionMode(BigraphSession.Mode sessionMode) {
		this.sessionMode = sessionMode;
	}
	/**
	 * @return the ruleFiredListeners
	 */
	public LinkedList<RuleFiredListener> getRuleFiredListeners() {
		return ruleFiredListeners;
	}
	/** add listener */
	public synchronized void addRuleFiredListener(RuleFiredListener listener) {
		if (!this.ruleFiredListeners.contains(listener))
			this.ruleFiredListeners.add(listener);
	}
	/** remove listener */
	public synchronized void removeRuleFiredListener(RuleFiredListener listener) {
		this.ruleFiredListeners.remove(listener);
	}
	/** fire listener */
	public void ruleFired(RuleFiredEvent rfe, BigraphSession ruleSession) {
		List<RuleFiredListener> listeners = null;
		synchronized(this) {
			listeners = new LinkedList<RuleFiredListener>(this.ruleFiredListeners);
		}
		for (RuleFiredListener listener : listeners) {
			try {
				listener.ruleFired(rfe, ruleSession);
			}
			catch (Exception e) {
				logger.error("Calling ruleFiredListener "+listener, e);
			}
			catch (ThreadDeath e) {
				logger.error("Calling ruleFiredListener "+listener, e);
				// must rethrow
				throw e;
			}
			catch (Error e) {
				logger.error("Calling ruleFiredListener "+listener, e);
			}
		}
	}
}
