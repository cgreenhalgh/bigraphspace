/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.Place;
import bigraphspace.model.Control;

/** Error in control / place indexes (or otherwise)
 * 
 * @author cmg
 *
 */
public class ControlIndexException extends SignatureException {
	/** place */
	protected Place place;
	/** control */
	protected Control control;
	/** index of index :-) */
	protected int indexNumber;
	/** index value (if any) */
	protected Object value;
	/** cons */
	public ControlIndexException(Place place, Control control, int indexNumber,
			Object value) {
		super();
		this.place = place;
		this.control = control;
		this.indexNumber = indexNumber;
		this.value = value;
	}
	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}
	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
	}
	/**
	 * @return the indexIndex
	 */
	public int getIndexNumber() {
		return indexNumber;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" (place="+place+", control="+control+", indexNumber="+indexNumber+", value="+value+")";
	}
	
}
