/**
 * 
 */
package bigraphspace.model;

/** Index value (or variable)
 * @author cmg
 *
 */
public interface IndexValue {
	/** get value (or null) */
	public Object getValue();
	/** get variable name (or null) */
	public String getVariableName();
	/** is variable */
	public boolean isVariable();
}
