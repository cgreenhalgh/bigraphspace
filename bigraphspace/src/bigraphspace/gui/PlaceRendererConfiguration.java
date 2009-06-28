/**
 * 
 */
package bigraphspace.gui;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.w3c.dom.Element;

import bigraphspace.model.Control;
import reactivexml.model.Constants;

/**
 * @author cmg
 *
 */
public class PlaceRendererConfiguration {
	/** singleton root renderer */
	protected RootRenderer rootRenderer = new RootRenderer();
	/** singleton site renderer */
	protected SiteRenderer siteRenderer = new SiteRenderer();
	/** singleton default node renderer */
	protected RectangleRenderer defaultNodeRenderer = new RectangleRenderer();
	/** control renderers */
	protected Map<String,PlaceRenderer> controlRenderers = new HashMap<String,PlaceRenderer>();
	/** get place renderer */
	protected PlaceRenderer getRenderer(Element place) {
		if (Constants.ROOT_ELEMENT_NAME.equals(place.getNodeName()))
			return rootRenderer;
		if (Constants.SITE_ELEMENT_NAME.equals(place.getNodeName()))
			return siteRenderer;
		if (controlRenderers.containsKey(place.getNodeName()))
			return controlRenderers.get(place.getNodeName());
		return defaultNodeRenderer;
	}

	/** initialisation property names */
	public static final String PROPERTY_RENDERER_CLASS = "renderer";
	/** initialise from parsed Json */
	public void initialiseFromJsonObject(Object o, java.awt.image.ImageObserver imageObserver) {
		if (!(o instanceof Object[])) 
			throw new RuntimeException("Outer object should be an array (of controls); found "+o);
		Object cs [] = (Object[])o;
		for (int ci=0; ci<cs.length; ci++) {
			Object co = cs[ci];
			if (!(co instanceof Hashtable))
				throw new RuntimeException("Configuration for control "+ci+" should be an object; found "+co);
			Hashtable c = (Hashtable)co;
			if (!c.containsKey(jbigraph.signature.BasicSignature.PROPERTY_NAME))
				throw new RuntimeException("Configuration for control "+ci+" must have 'name' property; found "+co);
			String name = c.get(jbigraph.signature.BasicSignature.PROPERTY_NAME).toString();
			//
			if (c.containsKey(PROPERTY_RENDERER_CLASS)) {
				String rendererClass = c.get(PROPERTY_RENDERER_CLASS).toString();
				PlaceRenderer renderer = null;
				try {
					renderer = (PlaceRenderer)Class.forName(rendererClass).newInstance();
				}
				catch (Exception e) {
					throw new RuntimeException("Could not create renderer "+rendererClass+" for control "+name, e);
				}
				controlRenderers.put(name, renderer);
				// Renderer configuration
				renderer.setImageObserver(imageObserver);
				renderer.initialiseFromJsonObject(c);
			}
		}
	}
}
