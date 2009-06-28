/**
 * 
 */
package bigraphspace.gui;

import org.w3c.dom.Element;
import java.util.LinkedList;
import java.util.List;
import java.awt.geom.Rectangle2D;

import reactivexml.model.XmlModel;

import org.apache.log4j.Logger;

import bigraphspace.model.Control;

/** view of a Place
 * 
 * @author cmg
 *
 */
public class PlaceView {
	/** logger */
	static Logger logger = Logger.getLogger(PlaceView.class);
	/** bigraph */
	protected XmlModel bigraph;
	/** place */
	protected Element place;
	/** children */
	protected List<PlaceView> children;
	/** bounds - position and size*/
	protected Rectangle2D bounds;
	/** place renderer */
	protected PlaceRenderer placeRenderer;
	
	/** cons */
	public PlaceView() {
		children = new LinkedList<PlaceView>();
	}
	/**
	 * @return the place
	 */
	public Element getPlace() {
		return place;
	}
	/**
	 * @return the bigraph
	 */
	public XmlModel getBigraph() {
		return bigraph;
	}
	/**
	 * @param bigraph the bigraph to set
	 */
	public void setBigraph(XmlModel bigraph) {
		this.bigraph = bigraph;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(Element place) {
		this.place = place;
	}
	/**
	 * @return the children
	 */
	public List<PlaceView> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<PlaceView> children) {
		this.children = children;
	}
	/**
	 * @return the bounds
	 */
	public Rectangle2D getBounds() {
		return bounds;
	}
	/**
	 * @param bounds the bounds to set
	 */
	public void setBounds(Rectangle2D bounds) {
		this.bounds = bounds;
	}
	
	/**
	 * @return the placeRenderer
	 */
	public PlaceRenderer getPlaceRenderer() {
		return placeRenderer;
	}
	/**
	 * @param placeRenderer the placeRenderer to set
	 */
	public void setPlaceRenderer(PlaceRenderer placeRenderer) {
		this.placeRenderer = placeRenderer;
	}
	/** get label */
	public String getLabel() {
		if (bigraph.isRoot(place)) {
			List<Element> roots = bigraph.getRoots();
			if (roots.contains(place))
				return ""+roots.indexOf(place);
			return null;
		}
		if (bigraph.isHole(place)) {
			return ""+bigraph.getHoleIndex(place);
		}
		StringBuffer sb = new StringBuffer();
		sb.append(place.getNodeName());
		// control?
		return sb.toString();
	}
	/** get arity */
	public int getArity() {
		if (bigraph.isHole(place) || bigraph.isRoot(place))
			return 0;
		Control control = bigraph.getControl(place);
		if (control!=null)
			return control.getArity();
		logger.warn("Control not found for node "+place);
		return 0;
	}
}
