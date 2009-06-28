/**
 * 
 */
package bigraphspace.model;

import bigraphspace.model.xml.DomBigraph;

/** Abstract (technology independent) view of a Bigraph match.
 * TODO: add methods for getting abstracted views of match mappings.
 * 
 * @author cmg
 *
 */
public interface Match {
	/**
	 * @return the pattern
	 */
	public Bigraph getPattern();

	/**
	 * @return the target
	 */
	public Bigraph getTarget();
}
