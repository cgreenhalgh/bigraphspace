/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.Control;
import bigraphspace.model.Place;

/** A port is named in a model but not defined.
 * 
 * @author cmg
 *
 */
public class UndefinedPortException extends SignatureException {
	/** the port name given */
	protected String portName;
	/** the control */
	protected Control control;
	/** the Place referring to it (optional) */
	protected Place place;
	/**
	 * 
	 */
	public UndefinedPortException(String portName, Control control, Place place) {
		this.portName= portName;
		this.control = control;
		this.place = place;
	}

	/**
	 * @param arg0
	 */
	public UndefinedPortException(String arg0, String portName, Control control, Place place) {
		super(arg0);
		this.portName= portName;
		this.control = control;
		this.place = place;
	}

	/**
	 * @param arg0
	 */
	public UndefinedPortException(String portName, Control control, Place place, Throwable arg0) {
		super(arg0);
		this.portName= portName;
		this.control = control;
		this.place = place;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public UndefinedPortException(String arg0, String portName, Control control, Place place, Throwable arg1) {
		super(arg0, arg1);
		this.portName= portName;
		this.control = control;
		this.place = place;
	}

	/**
	 * @return the portName
	 */
	public String getPortName() {
		return portName;
	}

	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
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
		return super.toString()+" (portName="+portName+", control="+control+", place="+place+")";
	}
	
}
