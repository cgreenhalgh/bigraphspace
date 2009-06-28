/**
 * 
 */
package bigraphspace.model;

import java.util.List;

/** Abstract Place interface (root, node or site). Implementation-independent.
 * Tries to follow the terminology in the 2009 book.
 * 
 * Qn: should it have access to parent? That would break reusability of nodes...
 * 
 * @author cmg
 *
 */
public interface Place {
	/** get place type */
	public PlaceType getType();
	/** set place type (if allowed) */
	public void setType(PlaceType type);
	/** is root? getType()==PlaceType.root */
	public boolean isRoot();
	/** is node? getType()==PlaceType.node */
	public boolean isNode();
	/** is site? getType()==PlaceType.site*/
	public boolean isSite();
	/** control name */
	public String getControlName();
	/** set control name (if allowed) */
	public void setControlName(String controlName);
	/** get arity, i.e. number of ports */
	public int getArity();
	/** get ports */
	public List<Port> getPorts();
	/** add port, at end (if allowed) */
	public void addPort(Port port);
	/** remove port (if allowed) */
	public void removePort(Port port);
	/** children */
	public List<Place> getChildren();
	/** add child */
	public void addChild(Place place);
	/** remove child */
	public void removeChild(Place place);
	/** insert child */
	public void insertChild(Place place, int atIndex);
	/** remove all children */
	public void clearChildren();
	/** get support (if uniquely identifiable); may be null */
	public String getSupport();
	/** set support (if uniquely identifiable and allowed); may be null */
	public void setSupport(String support);
	/** TODO: 
	 * needs elaboration for indexed Controls */
}
