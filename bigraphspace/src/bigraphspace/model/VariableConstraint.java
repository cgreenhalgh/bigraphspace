/**
 * 
 */
package bigraphspace.model;

import java.util.List;
import java.util.LinkedList;

/** A single constraint on a control/bigraph expression variable.
 * 
 * @author cmg
 *
 */
public interface VariableConstraint {
	/**
	 * @return the constraintType
	 */
	public VariableConstraintType getConstraintType();
	/**
	 * @return the values
	 */
	public List<Object> getValues();
	/**
	 * @return the variableName
	 */
	public String getVariableName();
}
