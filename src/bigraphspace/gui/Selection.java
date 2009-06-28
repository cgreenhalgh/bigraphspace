/**
 * 
 */
package bigraphspace.gui;

//import jbigraph.model.*;

import java.util.LinkedList;

/** The elements of the bigraph currently selected.
 * @author cmg
 *
 */
public class Selection {
	/** selected */
	protected LinkedList<Object> selections = new LinkedList<Object>();

	/** check selected */	
	public boolean isSelected(Object object) {
		return selections.contains(object);
	}
	/** select */
	public void add(Object object) {
		if (!isSelected(object))
			selections.add(object);		
	}
	/** clear */
	public void clear() {
		selections.clear();
	}
	/**
	 * @return the selections
	 */
	public LinkedList<Object> getSelections() {
		return selections;
	}
	
}
