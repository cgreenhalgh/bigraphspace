/**
 * 
 */
package bigraphspace.model;

import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import org.apache.log4j.Logger;

/** The definition of a control/bigraph expression variable, including any constraints.
 * 
 * @author cmg
 *
 */
public class VariableDefinition {
	/** logger */
	static Logger logger = Logger.getLogger(VariableDefinition.class);
	/** Base type */
	protected VariableType baseType;
	/** constraints */
	protected List<VariableConstraint> constraints = new LinkedList<VariableConstraint>();
	/** cons */
	public VariableDefinition() {
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
	/** matches a value? 
	 * If a value which it depends on is undefined then it is considered to (possibly) match. */
	public boolean matches(Object value, Map<String,VariableDefinition> variables, Map<String,Object> variableValues) {
		switch(baseType) {
		case control:
			// TODO
			logger.warn("matches not implemented for control variable");
			return false;
		case support:
			// TODO
			logger.warn("matches not implemented for support variable");
			return false;
		case integer:
			if (value instanceof Integer)
				return checkInteger((Integer)value, variables, variableValues);
			else if (value instanceof Short)
				return checkInteger((Short)value, variables, variableValues);
			else if (value instanceof Byte)
				return checkInteger((Byte)value, variables, variableValues);
			else if (value instanceof Long)
				return checkInteger((Long)value, variables, variableValues);
			else if (value instanceof String) {				
				try {
					return checkInteger(Long.valueOf((String)value), variables, variableValues);
				}
				catch (NumberFormatException nfe) {
					logger.warn("matches integer failed against "+value, nfe);
					return false;
				}
			}
			logger.warn("matches integer failed for unhandled type "+value);
			return false;
		case real:
		{
			Double dvalue = getDoubleValue(value);
			if (dvalue==null)
				return false;
			return checkReal(dvalue, variables, variableValues);		
		}
		case string:
			if (value!=null)
				return checkString(value.toString(), variables, variableValues);
			return false;
		}
		// not reached
		return false;
	}
	/** check constraints on Integer */
	protected boolean checkInteger(long value, Map<String,VariableDefinition> variables, Map<String,Object> variableValues) {
		// TODO: long-only version?!
		return checkReal((double)value, variables, variableValues);
	}
	protected Double getDoubleValue(Object value) {
		if (value instanceof Number)
			return ((Number)value).doubleValue();
		else if (value instanceof String) {
			try {
				return Double.valueOf(((String)(value)).trim());
			}
			catch (NumberFormatException nfe) {
				//logger.warn("non-double value "+value);
				return null;
			}	
		}
		//logger.warn("non-double value "+value);
		return null;
	}
	/** check constraints on Real */
	protected boolean checkReal(double value, Map<String,VariableDefinition> variables, Map<String,Object> variableValues) {
		for (VariableConstraint constraint : this.constraints) {
			List<Object> values = constraint.getValues();
			switch(constraint.getConstraintType()) {
			case minvalue: {
				if(values.size()!=1) {
					logger.warn("minvalue Constraint has "+values.size()+" values");
					return false;
				}
				Double cvalue = getDoubleValue(values.get(0));
				if (cvalue==null) {
					logger.warn("minvalue constraint has non-number value "+values.get(0));
					return false;
				}
				if (cvalue > value)
					return false;
				break;
			}
			case maxvalue: {
				if(values.size()!=1) {
					logger.warn("maxvalue Constraint has "+values.size()+" values");
					return false;
				}
				Double cvalue = getDoubleValue(values.get(0));
				if (cvalue==null) {
					logger.warn("maxvalue constraint has non-number value "+values.get(0));
					return false;
				}
				if (cvalue < value)
					return false;
				break;
			}
			case minlength:
				logger.warn("number has minlength constraint");
				return false;
			case maxlength:
				logger.warn("number has maxlength constraint");
				return false;
			case regexp:
				logger.warn("number has regexp constraint");
				return false;
			case oneof: {
				boolean ok = false;
				for (Object val : values) {
					Double cvalue = getDoubleValue(val);
					if (cvalue==null) {
						logger.warn("oneof constraint has non-number value "+val);
						return false;
					}
					if (cvalue == value) {
						ok = true;
						break;
					}
				}
				if (!ok)
					return false;
				break;
			}
			case notoneof: {
				for (Object val : values) {
					Double cvalue = getDoubleValue(val);
					if (cvalue==null) {
						logger.warn("notoneof constraint has non-number value "+val);
						return false;
					}
					if (cvalue == value) {
						return false;
					}
				}
				break;
			}
			case difference:
				if(values.size()!=1) {
					logger.warn("difference Constraint has "+values.size()+" values");
					return false;
				}
				Double cvalue = getDoubleValue(values.get(0));
				if (cvalue==null) {
					logger.warn("difference constraint has non-number value "+values.get(0));
					return false;
				}
				if (variableValues==null) {
					// assume it could match
					//logger.warn("difference constraint with no environment");
					break;
				}
				String variableName = constraint.getVariableName();
				if (variableName==null)
				{
					logger.warn("difference constraint with no variable name");
					return false;
				}
				//VariableDefinition definition = variables.get(variableName);
				//logger.warn("difference constraint not implemented");
				Object variableValue = variableValues.get(variableName);
				if (variableValue==null) {
					// assume it could match
					break;
				}
				Double vvalue = getDoubleValue(variableValue);
				if (vvalue==null) {
					logger.warn("difference constraint variable "+variableName+" has non-number value "+variableValue);
					return false;
				}
				if (!(value-vvalue == cvalue)) {
					logger.debug("Failed difference constraint "+value+"-"+vvalue+"="+(value-vvalue)+" vs "+cvalue);
					return false;
				}
				break;
			}
		}
		return true;
	}
	/** check constraints on String */
	protected boolean checkString(String value, Map<String,VariableDefinition> variables, Map<String,Object> variableValues) {
		if (value==null)
			return false;
		for (VariableConstraint constraint : this.constraints) {
			List<Object> values = constraint.getValues();
			switch(constraint.getConstraintType()) {
			case minvalue:
				logger.warn("string has regexp constraint");
				return false;
			case maxvalue:
				logger.warn("string has regexp constraint");
				return false;
			case minlength:
			{
				if(values.size()!=1) {
					logger.warn("minlength Constraint has "+values.size()+" values");
					return false;
				}
				Double cvalue = getDoubleValue(values.get(0));
				if (cvalue==null) {
					logger.warn("minlength constraint has non-number value "+values.get(0));
					return false;
				}
				if (value.length() < cvalue)
					return false;
				break;
			}
			case maxlength:
			{
				if(values.size()!=1) {
					logger.warn("maxlength Constraint has "+values.size()+" values");
					return false;
				}
				Double cvalue = getDoubleValue(values.get(0));
				if (cvalue==null) {
					logger.warn("maxlength constraint has non-number value "+values.get(0));
					return false;
				}
				if (value.length() > cvalue)
					return false;
				break;
			}
			case regexp:
			{
				if(values.size()!=1) {
					logger.warn("regexp Constraint has "+values.size()+" values");
					return false;
				}
				if (values.get(0)==null)
					return false;
				String regexp = (String)values.get(0);
				java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regexp);
				if (!pattern.matcher(value).matches())
					return false;
				break;
			}
			case oneof: {
				boolean ok = false;
				for (Object val : values) {
					if (val==null) {
						logger.warn("oneof constraint has null value");
						return false;
					}
					if (val.toString().equals(value)) {
						ok = true;
						break;
					}
				}
				if (!ok)
					return false;
				break;
			}
			case notoneof: {
				for (Object val : values) {
					if (val==null) {
						logger.warn("notoneof constraint has null value");
						return false;
					}
					if (val.toString().equals(value)) {
						return false;
					}
				}
				break;
			}
			case difference:
				logger.warn("string has difference constraint");
				return false;
			}
		}
		return true;
	}
}
