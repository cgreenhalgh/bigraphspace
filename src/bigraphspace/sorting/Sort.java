/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.Control;

/** A sort. 
 * 
 * @author cmg
 *
 */
public class Sort implements Comparable {
	/** name */
	protected String name;
	/** description */
	protected String description;
	/** cons */
	public Sort() {		
	}
	/**
	 * @param name
	 * @param description
	 */
	public Sort(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/** hashcode - on name only */
	public int hashCode() {
		return name!=null ? name.hashCode() : 0;
	}
	/** equals - on name only */
	public boolean equals(Object o) {
		if (o instanceof Control) {
			Sort s = (Sort)o;
			if (name==s.name)
				return true;
			else if (name==null || s.name==null)
				return false;
			else
				return name.equals(s.name);
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(Object o) {
		if (o instanceof Sort) {
			Sort c = (Sort)o;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+":Sort";
	}
	
}
