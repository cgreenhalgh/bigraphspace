/**
 * 
 */
package bigraphspace.api;

import bigraphspace.io.IOFactory;
import bigraphspace.model.Bigraph;

/** Abstract interface of "reactive" bigraph, c.f. Dataspace/tuplespace.
 * Can be equipped with callbacks and rules to apply. See bigraphspace.io.IOFactory
 * for compatible IO operations.
 * 
 * Obtained from BigraphFinder.
 * 
 * @author cmg
 *
 */
public interface ReactiveBigraph extends IOFactory {
	/** get a "session" through which the bigraph can be manipulated - synchronous API */
	public BigraphSession getSession();
	/** add bigraph changed listener */
	public void addBigraphChangedListener(BigraphChangedListener listener);
	/** remove bigraph changed listener */
	public void removeBigraphChangedListener(BigraphChangedListener listener);
	/** add reaction rule (which may include listener) */
	public void addReactionRule(ReactionRule rule);
	/** remove reaction rule */
	public void removeReactionRule(ReactionRule rule);
	/** stop callbacks, e.g. kill internal thread (clean up) */
	public void stopCallbacks();
	/** create a "compatible" empty bigraph (with the same signature) */
	public Bigraph createBigraph();
}
