/**
 * 
 */
package bigraphspace.model.xml;

import java.util.List;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger; 

import bigraphspace.api.BigraphRuntimeException;
import bigraphspace.api.BigraphSession;
import bigraphspace.api.ReactiveBigraph;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Match;
/** Dom-based implementation of BigraphSession.
 * 
 * @author cmg
 *
 */
public class DomBigraphSession extends BigraphSession {
	/** logger */
	static Logger logger = Logger.getLogger(DomBigraphSession.class);
	/** bigraph */
	protected DomReactiveBigraph reactiveBigraph;
	/** current state */
	protected DomBigraph currentValue = null;
	/** waiting for handleBegin success? */
	boolean waitingForBegin = false;
	/** cons - from DomReactiveBigraph only
	 */
	DomBigraphSession(DomReactiveBigraph reactiveBigraph) {
		this.reactiveBigraph = reactiveBigraph;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#abort()
	 */
	@Override
	public synchronized void abort() {
		checkStateForRead("abort");
		this.state = State.idle;
		this.currentValue = null;
		reactiveBigraph.handleEnd(this, null, false);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#begin()
	 */
	@Override
	public synchronized void begin() {
		begin(Mode.readwrite);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#begin(bigraphspace.api.BigraphSession.Mode)
	 */
	@Override
	public synchronized void begin(Mode mode) {
		if (state==State.closed)
			throw new BigraphRuntimeException("Cannot do begin in state closed");
		if (state!=State.idle) {
			logger.error("begin in state "+state+" - forcing abort");
			abort();
		}
		Bigraph bigraph = reactiveBigraph.handleBegin(this, mode);
		if (!(bigraph instanceof DomBigraph))
			throw new BigraphRuntimeException("begin() did not get DomBigraph ("+bigraph+")");
		this.currentValue = (DomBigraph)bigraph;
		state = State.active;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#close()
	 */
	@Override
	public synchronized void close() {
		if (state==State.closed)
			return;
		if (state!=State.idle) {
			logger.error("close forces abort");
			abort();
		}
		state = State.closed;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#end()
	 */
	@Override
	public synchronized void end() {
		checkStateForRead("end");
		switch(mode) {
		case readonly:
			reactiveBigraph.handleEnd(this, currentValue, false);
			break;
		case readwrite:
			reactiveBigraph.handleEnd(this, currentValue, state==State.changed);
			break;
		}
		state = State.idle;
		currentValue = null;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#getAll()
	 */
	@Override
	public synchronized Bigraph getAll() {
		checkStateForRead("getAll");
		return this.currentValue;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#setAll()
	 */
	@Override
	public synchronized void setAll(Bigraph bigraph) {
		checkStateForUpdate("setAll");
		if (!(bigraph instanceof DomBigraph))
			throw new IllegalArgumentException("DomBigraphSession.setAll requires DomBigraph (not "+bigraph+")");
		this.currentValue = (DomBigraph)bigraph;
		this.state = State.changed;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#match(bigraphspace.model.Bigraph, int)
	 */
	@Override
	public synchronized List<Match> match(Bigraph pattern, int maxMatches) {
		checkStateForRead("match");
		if (!(pattern instanceof DomBigraph))
			throw new IllegalArgumentException("DomBigraphSession requires DomBigraph as match pattern (not "+pattern+")");
		DomMatcher matcher = new DomMatcher();
		List<DomMatch> domMatches = matcher.match((DomBigraph)pattern, currentValue, maxMatches);
		LinkedList<Match> matches = new LinkedList<Match>(domMatches);
		return matches;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.api.BigraphSession#update(bigraphspace.model.Match, bigraphspace.model.Bigraph)
	 */
	@Override
	public synchronized void update(Match match, Bigraph reactum) {
		checkStateForUpdate("update");
		if (!(reactum instanceof DomBigraph))
			throw new IllegalArgumentException("DomBigraphSession.update requires DomBigraph as reactum (not "+reactum+")");
		if (!(match instanceof DomMatch))
			throw new IllegalArgumentException("DomBigraphSession.update requires DomMatch (not "+match+")");
		DomTransformer transformer = new DomTransformer();
		try {
			DomBigraph result = transformer.transform((DomMatch)match, (DomBigraph)reactum);
			if (result==null)
				throw new BigraphRuntimeException("DomBigraphSession.update transform yeilded null result (ignored)");
			this.currentValue = (DomBigraph)result;
			this.state = State.changed;
		}
		catch (ParserConfigurationException e) {
			throw new BigraphRuntimeException("Doing update (transform)", e);			
		}
		catch (TransformException e) {
			throw new BigraphRuntimeException("Doing update (transform)", e);			
		}
	}
	/** get reactive bigraph with which this is associated */
	public ReactiveBigraph getReactiveBigraph() {
		return reactiveBigraph;
	}
}
