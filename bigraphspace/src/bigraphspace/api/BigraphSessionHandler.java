/**
 * 
 */
package bigraphspace.api;

import bigraphspace.model.Bigraph;

/** Interface (for ReactiveBigraph implementations) to respond to Session activities. 
 * 
 * @author cmg
 *
 */
public interface BigraphSessionHandler {
	/** begin. Call with session locked!
	 * @return initial value. */
	public Bigraph handleBegin(BigraphSession session, BigraphSession.Mode mode);
	/** end */
	public void handleEnd(BigraphSession session, Bigraph value, boolean commit);
}
