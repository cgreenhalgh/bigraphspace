/**
 * 
 */
package bigraphspace.api;

/** Registry/factory (specifically ambiguous) for ReactiveBigraphs.
 * So the same code running in a simulator or on a device can use this and
 * get (a) a fragment of the simulation bigraph or (b) a primary local bigraph.
 * 
 * @author cmg
 *
 */
public class BigraphFinder {
	/** get "default" bigraph for calling code */
	public static ReactiveBigraph getDefaultBigraph() throws BigraphNotFoundException {
		// TODO - classloader-specific default bigraph
		if (defaultBigraph==null)
			throw new BigraphNotFoundException("No default bigraph set");
		return defaultBigraph;
	}
	/** global default? */
	protected static ReactiveBigraph defaultBigraph = null;
	/** set global default - system use only */
	public static void setDefaultBigraph(ReactiveBigraph defaultBigraph) {
		BigraphFinder.defaultBigraph = defaultBigraph;
	}
}
