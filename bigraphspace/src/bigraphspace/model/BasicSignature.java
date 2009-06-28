/**
 * 
 */
package bigraphspace.model;

import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;

import bigraphspace.sorting.AtomicControlException;
import bigraphspace.sorting.PlaceTypeException;
import bigraphspace.sorting.UndefinedControlException;
import bigraphspace.sorting.UndefinedPortException;

/** A basic signature is essentially just a set of Controls, each with its 
 * status and arity (as given in the Control itself).
 * 
 * @author cmg
 *
 */
public class BasicSignature  {
	/** control */
	protected TreeSet<Control> controls = new TreeSet<Control>();
	/** cons */
	public BasicSignature() {
	}
	/**
	 * @return the controls
	 */
	public TreeSet<Control> getControls() {
		return controls;
	}
	/**
	 * @param controls the controls to set
	 */
	public void setControls(TreeSet<Control> controls) {
		this.controls = controls;
	}
	/** get control by name *
	 */
	public Control getControl(String controlName) {
		if (controlName==null)
			return null;
		for(Control control : controls) {
			if (controlName.equals(control.getName()))
				return control;
		}
		return null;
	}
	/** validate a model against this Signature (only) */
	public void validate(Bigraph bigraph) throws UndefinedPortException, UndefinedControlException, AtomicControlException, PlaceTypeException {
		validate(bigraph.getRoots(), true);
	}
	/** validate a set of Places against this signature - recurse */
	protected void validate(List<Place> places, boolean rootFlag) throws UndefinedPortException, UndefinedControlException, AtomicControlException, PlaceTypeException  {
		for (Place place : places) {
			// check for atomic Control later in code path
			boolean atomic = place.isSite();
			Control control = null;
			if (place.isRoot()) {
				if (!rootFlag)
					throw new PlaceTypeException("Root found at non-root", place.getType(), place);
			}
			if (place.isNode()) {
				String controlName = place.getControlName();
				control = getControl(controlName);
				if (control==null)
					throw new UndefinedControlException(controlName, place);
				atomic = control.isAtomic();
				// TODO 
				// ports
				List<Port> ports = place.getPorts();
				// ports may be differently ordered in place, so make list of unseen names to check
				TreeSet<String> unseenPortNames = new TreeSet<String>();
				for (int pi=0; pi<control.getArity(); pi++) 
					unseenPortNames.add(control.getPortName(pi));
				for (Port port : ports) {
					if (unseenPortNames.contains(port.getName())) {
						unseenPortNames.remove(port.getName());
					}
					else
						throw new UndefinedPortException(port.getName(), control, place);
				}
			}
			else {
				// non-node - should have no ports?!
				if (place.getPorts().size()!=0)
					throw new PlaceTypeException("Non-node has "+place.getPorts().size()+" ports", place.getType(), place);
			}
			if (atomic) {
				if (place.getChildren().size()!=0)
					throw new AtomicControlException(control, place, place.getChildren().get(0));
			}
			else {
				// recurse (not root)
				validate(place.getChildren(), false);
			}
		}
	}
}
