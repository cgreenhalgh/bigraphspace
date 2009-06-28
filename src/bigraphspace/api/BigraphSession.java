/**
 * 
 */
package bigraphspace.api;

import java.util.List;

import bigraphspace.model.Bigraph;
import bigraphspace.model.Match;

/** Abstract super-class of BigraphSession (aka transaction), within which bigraph can be used.
 * Essentially the synchronous API of the bigraph.
 * 
 * Obtained from ReactiveBigraph.
 * 
 * @author cmg
 *
 */
public abstract class BigraphSession {
	/** start action/transaction - read/write (sync. API) */
	public abstract void begin();
	/** possible mode(s) */
	public static enum Mode { readonly, readwrite }; 
	/** mode */
	protected Mode mode = Mode.readwrite;
	/** start action/transaction (sync. API) */
	public abstract void begin(Mode mode);
	/** get mode */
	public Mode getMode() {
		return mode;
	}
	/** state type */
	public static enum State { idle, closed, active, changed }
	/** state */
	protected State state = State.idle;
	/** get state */
	public State getState() {
		return state;
	}
	/** helper - check state for update, else throw exception */
	protected void checkStateForUpdate(String operation) {
		if (state!=State.active && state!=State.changed)
			throw new BigraphRuntimeException("Cannot perform "+operation+" in state "+state);
		if (mode!=Mode.readwrite)
			throw new BigraphRuntimeException("Cannot perform "+operation+" in "+mode+" mode");
	}
	/** helper - check state for update, else throw exception */
	protected void checkStateForRead(String operation) {
		if (state!=State.active && state!=State.changed)
			throw new BigraphRuntimeException("Cannot perform "+operation+" in state "+state);
	}
	/** get whole bigraph current state (sync. API) */
	public abstract Bigraph getAll();
	/** set whole bigraph state (sync API) */
	public abstract void setAll(Bigraph bigraph);
	/** end/commit (sync. API) */
	public abstract void end();
	/** end/abort (sync. API) */
	public abstract void abort();
	/** get match(es) (sync. API) */
	public abstract List<Match> match(Bigraph pattern, int maxMatches);
	/** rewrite (sync. API) */
	public abstract void update(Match match, Bigraph reactum);
	/** explicit releae of session (do not use again) */
	public abstract void close();
	/** get reactive bigraph with which this is associated */
	public abstract ReactiveBigraph getReactiveBigraph();
}
