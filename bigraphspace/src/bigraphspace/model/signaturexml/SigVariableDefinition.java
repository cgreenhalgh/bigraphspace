/**
 * 
 */
package bigraphspace.model.signaturexml;

import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import org.apache.log4j.Logger;

import bigraphspace.model.VariableConstraint;
import bigraphspace.model.VariableType;
import bigraphspace.model.VariableDefinition;

/** The definition of a control/bigraph expression variable, including any constraints.
 * 
 * @author cmg
 *
 */
public class SigVariableDefinition extends VariableDefinition {
	/** logger */
	static Logger logger = Logger.getLogger(SigVariableDefinition.class);
	/** Base type */
	protected VariableType baseType;
	/** constraints */
	protected List<VariableConstraint> constraints = new LinkedList<VariableConstraint>();
	/** cons */
	public SigVariableDefinition() {
	}
	/**
	 * @return the baseType
	 */
	public VariableType getBaseType() {
		return baseType;
	}
	/**
	 * @param baseType the baseType to set
	 */
	public void setBaseType(VariableType baseType) {
		this.baseType = baseType;
	}
	/**
	 * @return the constraints
	 */
	public List<VariableConstraint> getConstraints() {
		return constraints;
	}
	/**
	 * @param constraints the constraints to set
	 */
	public void setConstraints(List<VariableConstraint> constraints) {
		this.constraints = constraints;
	}
}
