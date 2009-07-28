/**
 * 
 */
package bigraphspace.model;

import java.util.List;
import java.util.LinkedList;

/** Description/definition of a Control.
 * Generalised for (infinite) families of indexed controls, e.g. corresponding to the integers, cartesian coordinates, etc.
 * Controls are assumed to be equal if their names are equal.
 * At some point it might make sense to add namespaces!
 * 
 * @author cmg
 *
 */
public class Control implements Comparable {
	/** name */
	protected String name;
	/** description (optional) */
	protected String description;
	/** index type(s), for Controls which are actually (potentially) infinitie families of controls, such as numbers or points */
	protected List<VariableDefinition> indexTypes = new LinkedList<VariableDefinition>();
	/** status type. nonatomic is effectively unknown active/passive (or not relevant). */
	public enum Status { active, passive, atomic };
	/** status */
	protected Status status;
	/** arity, i.e. no. ports */
	protected int arity;
	/** port names (optional?!) */
	protected String portNames[];
	
	/** no-arg cons */
	public Control() {		
	}
	/** cons.
	 * @param status
	 * @param arity
	 * @param portNames
	 */
	public Control(String name, String description, List<VariableDefinition> indexTypes, Status status, int arity, String[] portNames) {
		super();
		this.name = name;
		this.description = description;
		this.indexTypes = indexTypes;
		this.status = status;
		this.arity = arity;
		this.portNames = portNames;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/** indexed?
	 */
	public boolean isIndexed() {
		return getIndexCount()>0;
	}
	/**
	 * @return the indexTypes
	 */
	public List<VariableDefinition> getIndexTypes() {
		return indexTypes;
	}
	/**
	 * @param indexTypes the indexTypes to set
	 */
	public void setIndexTypes(List<VariableDefinition> indexTypes) {
		this.indexTypes = indexTypes;
	}
	/**
	 * @return the indexCount
	 */
	public int getIndexCount() {
		return (indexTypes!=null ? indexTypes.size() : 0);
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/** is atomic - status = atomic, only */
	public boolean isAtomic() {
		return status==Status.atomic;
	}
	/**
	 * @return the arity
	 */
	public int getArity() {
		return arity;
	}
	/**
	 * @param arity the arity to set
	 */
	public void setArity(int arity) {
		this.arity = arity;
	}
	/**
	 * @return the portNames
	 */
	public String[] getPortNames() {
		return portNames;
	}
	/** get port name for given port (if specified, else default name) */
	public String getPortName(int i) {
		if (i<0 || i>=arity) 
			throw new IllegalArgumentException("getPortName("+i+") out of bounds (arity="+arity+")");
		if (portNames!=null && i<portNames.length && portNames[i]!=null)
			return portNames[i];
		return Port.DEFAULT_PORT_NAME_PREFIX+i;
	}
	/**
	 * @param portNames the portNames to set
	 */
	public void setPortNames(String[] portNames) {
		this.portNames = portNames;
	}
	/** hashcode - on name only */
	public int hashCode() {
		return name!=null ? name.hashCode() : 0;
	}
	/** equals - on name only */
	public boolean equals(Object o) {
		if (o instanceof Control) {
			Control c = (Control)o;
			if (name==c.name)
				return true;
			else if (name==null || c.name==null)
				return false;
			else
				return name.equals(c.name);
		}
		return false;
	}
	//@Override
	public int compareTo(Object o) {
		if (o instanceof Control) {
			Control c = (Control)o;
			if (name==c.name)
				return 0;
			else if (name==null)
				return -1;
			else if (c.name==null)
				return 1;
			else 
				return name.compareTo(c.name);
		}
		return -1;
	}
}
