/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.Place;

/** A control is named in a model but not defined.
 * 
 * @author cmg
 *
 */
public class UndefinedControlException extends SignatureException {
	/** the control name give */
	protected String controlName;
	/** the Place referring to it (optional) */
	protected Place place;
	/**
	 * 
	 */
	public UndefinedControlException(String controlName, Place place) {
		this.controlName= controlName;
		this.place = place;
	}

	/**
	 * @param arg0
	 */
	public UndefinedControlException(String arg0, String controlName, Place place) {
		super(arg0);
		this.controlName= controlName;
		this.place = place;
	}

	/**
	 * @param arg0
	 */
	public UndefinedControlException(String controlName, Place place, Throwable arg0) {
		super(arg0);
		this.controlName= controlName;
		this.place = place;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public UndefinedControlException(String arg0, String controlName, Place place, Throwable arg1) {
		super(arg0, arg1);
		this.controlName= controlName;
		this.place = place;
	}

	/**
	 * @return the controlName
	 */
	public String getControlName() {
		return controlName;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+" (controlName="+controlName+", place="+place+")";
	}
	
}
