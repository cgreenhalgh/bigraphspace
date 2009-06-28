/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.Control;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

/** A control is atomic but has a child place.
 * 
 * @author cmg
 *
 */
public class AtomicControlException extends PlaceTypeException {
	/** control (or null if site) */
	protected Control control;
	/** the child Place (optional) */
	protected Place child;
	/**
	 * 
	 */
	public AtomicControlException(Control control, Place place, Place child) {
		super(PlaceType.node, place);
		this.control = control;
		this.child = child;
	}

	/**
	 * @param arg0
	 */
	public AtomicControlException(String arg0, Control control, Place place, Place child) {
		super(arg0, PlaceType.node, place);
		this.control = control;
		this.child = child;
	}

	/**
	 * @param arg0
	 */
	public AtomicControlException(Control control, Place place, Place child, Throwable arg0) {
		super(PlaceType.node, place, arg0);
		this.control = control;
		this.child = child;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AtomicControlException(String arg0, Control control, Place place, Place child, Throwable arg1) {
		super(arg0, PlaceType.node, place, arg1);
		this.control = control;
		this.child = child;
	}


	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
	}

	/**
	 * @return the child
	 */
	public Place getChild() {
		return child;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+" (control="+control+", child="+child+")";
	}
	
}
