/**
 * 
 */
package bigraphspace.api;

/** Simple ReactiveBigraph change listener.
 * 
 * @author cmg
 *
 */
public interface BigraphChangedListener {
	/** changed */
	public void bigraphChanged(BigraphChangedEvent bce);
}
