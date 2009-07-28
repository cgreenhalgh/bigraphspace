/**
 * 
 */
package bigraphspace.sorting;

import bigraphspace.model.signaturexml.DefinitionException;
import bigraphspace.model.signaturexml.SignatureFactory;
import bigraphspace.model.signaturexml.Utils;
//import bigraphspace.model.signaturexml.Sort;
//import bigraphspace.model.signaturexml.Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import bigraphspace.model.BasicSignature;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Control;
import bigraphspace.model.Place;
import bigraphspace.model.Port;
import bigraphspace.model.VariableDefinition;
import bigraphspace.model.signaturexml.ControlRef;
import bigraphspace.model.signaturexml.ControlRefs;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.SortRef;
import bigraphspace.model.signaturexml.SortRefs;
import bigraphspace.model.signaturexml.Sorts;

/** Place-holder for (basic? abstract?) sorting.
 * 
 * @author cmg
 *
 */
public class Sorting {
	/** logger */
	static Logger logger = Logger.getLogger(Sorting.class);
	/** signature */
	protected BasicSignature signature;
	/** sorts */
	protected TreeSet<Sort> sorts = new TreeSet<Sort>();
	/** sort map */		
	protected HashMap<String,Sort> sortMap = new HashMap<String,Sort>();
	/** assignment of Sorts to controls */
	protected HashMap<Control,Sort> controlSorts = new HashMap<Control,Sort>();
	/** assignment of possible child sorts to sorts */
	protected HashMap<Sort,TreeSet<Sort>> childSorts = new HashMap<Sort,TreeSet<Sort>>();
	/** cons */
	public Sorting() {
	}
	/**
	 * @return the sorts
	 */
	public TreeSet<Sort> getSorts() {
		return sorts;
	}
	/**
	 * @param sorts the sorts to set
	 */
	public void setSorts(TreeSet<Sort> sorts) {
		this.sorts = sorts;
	}
	/**
	 * @return the controlSorts
	 */
	public HashMap<Control, Sort> getControlSorts() {
		return controlSorts;
	}
	/**
	 * @param controlSorts the controlSorts to set
	 */
	public void setControlSorts(HashMap<Control, Sort> controlSorts) {
		this.controlSorts = controlSorts;
	}

	/**
	 * @return the signature
	 */
	public BasicSignature getSignature() {
		return signature;
	}
	/** Create sorting from signature XML. */
	public static Sorting createSorting(BasicSignature signature, Definitions xdefinitions) throws DefinitionException {
		Sorting sorting = new Sorting();
		sorting.signature = signature;
		Sorts xsortsEl = xdefinitions.getSorts();
		if (xsortsEl==null) {
			logger.warn("No <sorts> found");
			return null;
		}
		List<bigraphspace.model.signaturexml.Sort> xsorts = xsortsEl.getSort();
		if (xsorts.size()==0) {
			logger.warn("No <sort>s found");
			return sorting;			
		}
		// list and controls, first
		for (bigraphspace.model.signaturexml.Sort xsort : xsorts) {
			String sortName = xsort.getName();
			if (sortName==null) 
				throw new DefinitionException("<sort> with no name attribute");
			if (sorting.sortMap.containsKey(sortName))
				throw new DefinitionException("duplication definition of sort "+sortName);
			Sort sort = new Sort(sortName, xsort.getDescription());
			sorting.sorts.add(sort);
			sorting.sortMap.put(sortName, sort);
			// controls
			ControlRefs xcontrols = xsort.getControls();
			if (xcontrols==null) {
				// default control ?!
				Control defaultControl = signature.getControl(sortName);
				if (defaultControl!=null)
					sorting.controlSorts.put(defaultControl, sort);					
			}
			else {
				for (ControlRef xcontrol : xcontrols.getControl()) {
					if (xcontrol.getName()==null)
						throw new DefinitionException("<sort><controls><control> with no name attribute");
					Control control = signature.getControl(xcontrol.getName());
					if (control==null)
						throw new DefinitionException("Unknown control "+xcontrol.getName()+" in signature");
					sorting.controlSorts.put(control, sort);
				}
			}
		}
		// all controls sorted?
		for (Control control: signature.getControls()) {
			Sort sort = sorting.controlSorts.get(control);
			if (sort==null) {
				logger.warn("No Sort specified for Control "+control.getName()+" - creating default");
				sort = new Sort(control.getName(), "default control sort");
				sorting.sortMap.put(control.getName(), sort);
				sorting.sorts.add(sort);
				sorting.controlSorts.put(control, sort);
			}
		}
		// child sorts
		for (bigraphspace.model.signaturexml.Sort xsort : xsorts) {
			String sortName = xsort.getName();
			Sort sort = sorting.sortMap.get(sortName);
			SortRefs xchildsortsEl = xsort.getChildsorts();
			TreeSet<Sort> childSorts = new TreeSet<Sort>();
			sorting.childSorts.put(sort, childSorts);
			for (SortRef xchildsort: xchildsortsEl.getSort()) {
				if (xchildsort.getName()==null)
					throw new DefinitionException("<sort><childsorts><sort> with no name attribute");
				Sort childsort = sorting.sortMap.get(xchildsort.getName());
				if (childsort==null)
					throw new DefinitionException("Unknown child sort "+xchildsort.getName());
				childSorts.add(childsort);
			}
		}
		// TODO
		// parent sorts, descendents, ancestors, anything else
		return sorting;
	}	
	/** read sorting from signature XML file */
	public static Sorting readSorting(File file) throws JAXBException, FileNotFoundException, DefinitionException {
		Definitions defs = Utils.readDefinitions(file);
		BasicSignature signature = SignatureFactory.createSignature(defs);
		return createSorting(signature, defs);
	}
	/** validate a model against this Sorting (only) */
	public void validate(Bigraph bigraph) throws UndefinedPortException, UndefinedControlException, AtomicControlException, PlaceTypeException, ChildSortException, ControlIndexException   {
		signature.validate(bigraph);
		validate(bigraph.getRoots(), null, null);
	}
	/** validate a set of Places against this signature - recurse */
	protected void validate(List<Place> places, Place parent, Sort parentSort) throws UndefinedPortException, UndefinedControlException, AtomicControlException, PlaceTypeException, ChildSortException, ControlIndexException  {
		for (Place place : places) {
			// just check childSorts - atomic etc done by signature check
			Sort sort = null;
			if (place.isNode()) {
				String controlName = place.getControlName();
				Control control = signature.getControl(controlName);
				if (control==null)
					throw new UndefinedControlException(controlName, place);
				sort = this.controlSorts.get(control);
				if (sort==null)
					throw new UndefinedControlException("No Sort specified for control", controlName, place);
				if (parentSort!=null && (!this.childSorts.containsKey(parentSort) || !this.childSorts.get(parentSort).contains(sort)))
					throw new ChildSortException(parentSort, sort, parent, place);
			}
			// recurse (not root)
			validate(place.getChildren(), place, sort);
		}
	}
}
