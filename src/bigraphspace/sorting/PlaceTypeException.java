/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

/** A control is atomic but has a child place.
 * 
 * @author cmg
 *
 */
public class PlaceTypeException extends SignatureException {
	/** place type */
	protected PlaceType type;
	/** the Place (optional) */
	protected Place place;
	/**
	 * 
	 */
	public PlaceTypeException(PlaceType type, Place place) {
		this.type = type;
		this.place = place;
	}

	/**
	 * @param arg0
	 */
	public PlaceTypeException(String arg0, PlaceType type, Place place) {
		super(arg0);
		this.type = type;
		this.place = place;
	}

	/**
	 * @param arg0
	 */
	public PlaceTypeException(PlaceType type, Place place, Throwable arg0) {
		super(arg0);
		this.type = type;
		this.place = place;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public PlaceTypeException(String arg0, PlaceType type, Place place, Throwable arg1) {
		super(arg0, arg1);
		this.type = type;
		this.place = place;
	}


	/**
	 * @return the type
	 */
	public PlaceType getPlaceType() {
		return type;
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
		return super.toString()+" (placeType="+type+", place="+place+")";
	}
	
}
