/**
 * 
 */
package bigraphspace.model.signaturexml;

import java.util.List;
import java.util.LinkedList;
import bigraphspace.model.VariableConstraint;
import bigraphspace.model.VariableConstraintType;

/** A single constraint on a control/bigraph expression variable.
 * 
 * @author cmg
 *
 */
public class SigVariableConstraint implements VariableConstraint {
	/** type of constraint */
	protected VariableConstraintType constraintType;
	/** value (set), e.g. min, max, oneof, notoneof */
	protected List<Object> values = new LinkedList<Object>();
	/** other parameter name (difference) */
	protected String variableName;
	/** cons */
	public SigVariableConstraint() {
	}
	/**
	 * @return the constraintType
	 */
	public VariableConstraintType getConstraintType() {
		return constraintType;
	}
	/**
	 * @param constraintType the constraintType to set
	 */
	public void setConstraintType(VariableConstraintType constraintType) {
		this.constraintType = constraintType;
	}
	/**
	 * @return the values
	 */
	public List<Object> getValues() {
		return values;
	}
	/**
	 * @param values the values to set
	 */
	public void setValues(List<Object> values) {
		this.values = values;
	}
	/**
	 * @return the variableName
	 */
	public String getVariableName() {
		return variableName;
	}
	/**
	 * @param variableName the variableName to set
	 */
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	
}
