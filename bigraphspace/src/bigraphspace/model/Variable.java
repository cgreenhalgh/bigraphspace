/**
 * 
 */
package bigraphspace.model;

/** A variable in a bigraph expression.
 * 
 * @author cmg
 *
 */
public class Variable {
	/** name */
	protected String name;
	/** definition */
	//protected VariableDefinition definition;
	/** cons */
	public Variable() {
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
//	/**
//	 * @return the definition
//	 */
//	public VariableDefinition getDefinition() {
//		return definition;
//	}
//	/**
//	 * @param definition the definition to set
//	 */
//	public void setDefinition(VariableDefinition definition) {
//		this.definition = definition;
//	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "$"+name;
	}
	
}
