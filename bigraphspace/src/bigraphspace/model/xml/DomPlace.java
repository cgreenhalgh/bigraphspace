/**
 * 
 */
package bigraphspace.model.xml;

import java.util.List;
import java.util.LinkedList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Attr;

import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;
import bigraphspace.model.Port;

/** DOM implementation of abstract Place.
 * 
 * @author cmg
 *
 */
public class DomPlace implements Place {
	/** element = place */
	protected Element element;
	/** cons - local */
	DomPlace(Element element) {
		this.element = element;
	}
	/** local */
	Element getElement() {
		return element;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#addPort(bigraphspace.model.Port)
	 */
	//@Override
	public void addPort(Port port) {
		if (port instanceof DomPort) {
			DomPort domPort = (DomPort)port;
			element.appendChild(domPort.getAttribute());			
		}
		else
			throw new IllegalArgumentException("addPort called with non-DomPort: "+port);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#getArity()
	 */
	//@Override
	public int getArity() {
		if (element.hasAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME))
			return element.getAttributes().getLength()-1;
		else
			return element.getAttributes().getLength();
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#getControlName()
	 */
	//@Override
	public String getControlName() {
		if (getType()==PlaceType.node)
			return element.getNodeName();
		return null;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#getPorts()
	 */
	//@Override
	public List<Port> getPorts() {
		LinkedList<Port> ports = new LinkedList<Port>();
		NamedNodeMap attributes = element.getAttributes();
		for(int ai=0; ai<attributes.getLength(); ai++) {
			Node attribute = attributes.item(ai);
			// not _support
			if (!attribute.getNodeName().equals(Constants.NODE_SUPPORT_ATTRIBUTE_NAME))
				ports.add(new DomPort((Attr)attribute));
		}
		return ports;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#getType()
	 */
	//@Override
	public PlaceType getType() {
		String nodeName = element.getNodeName();
		if (Constants.ROOT_ELEMENT_NAME.equals(nodeName))
			return PlaceType.root;
		else if (Constants.SITE_ELEMENT_NAME.equals(nodeName))
			return PlaceType.site;
		else
			return PlaceType.node;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#isNode()
	 */
	//@Override
	public boolean isNode() {
		return getType()==PlaceType.node;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#isRoot()
	 */
	//@Override
	public boolean isRoot() {
		return getType()==PlaceType.root;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#isSite()
	 */
	//@Override
	public boolean isSite() {
		return getType()==PlaceType.site;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#removePort(bigraphspace.model.Port)
	 */
	//@Override
	public void removePort(Port port) {
		if (port instanceof DomPort) {
			element.removeAttribute(port.getName());
		}
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#setControlName(java.lang.String)
	 */
	//@Override
	public void setControlName(String controlName) {
		element.getOwnerDocument().renameNode(element, null, controlName);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#setType(bigraphspace.model.PlaceType)
	 */
	//@Override
	public void setType(PlaceType type) {
		switch(type) {
		case root:
			setControlName(Constants.ROOT_ELEMENT_NAME);
			break;
		case site:
			setControlName(Constants.SITE_ELEMENT_NAME);
			break;
		case node:
			throw new UnsupportedOperationException("Cannot setType(node) - unknown control");
		}
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#addChild(bigraphspace.model.Place)
	 */
	//@Override
	public void addChild(Place place) {
		if (place.isRoot())
			throw new IllegalArgumentException("addChild("+place+") - root");
		if (place instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)place;
			element.appendChild(domPlace.getElement());
		}
		else
			throw new IllegalArgumentException("addChild("+place+") - not DomPlace");
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#getChildren()
	 */
	//@Override
	public List<Place> getChildren() {
		NodeList childEls = element.getChildNodes();
		LinkedList<Place> children = new LinkedList<Place>();
		for (int i=0; i<childEls.getLength(); i++) {
			Node node = childEls.item(i);
			if (node instanceof Element) {
				children.add(new DomPlace((Element)node));
			}
		}
		return children;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#insertChild(bigraphspace.model.Place, int)
	 */
	//@Override
	public void insertChild(Place place, int atIndex) {
		if (place.isRoot())
			throw new IllegalArgumentException("insertChild("+place+") - root");
		if (place instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)place;
			NodeList childEls = element.getChildNodes();
			Node refChild = null;
			for (int i=0; i<childEls.getLength() && i<atIndex; i++) {
				Node node = childEls.item(i);
				if (!(node instanceof Element))
					atIndex++;
				else
					refChild = node;
			}
			element.insertBefore(domPlace.getElement(), refChild);
		}
		else
			throw new IllegalArgumentException("insertRoot("+place+") - not DomPlace");
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#removeAllChildren()
	 */
	//@Override
	public void clearChildren() {
		while(element.hasChildNodes()) {
			Node child = element.getFirstChild();
			element.removeChild(child);
		}
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#removeChild(bigraphspace.model.Place)
	 */
	//@Override
	public void removeChild(Place place) {
		if (place instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)place;
			element.removeChild(domPlace.getElement());
		}
		else
			throw new IllegalArgumentException("removeChild("+place+") - not DomPlace");
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#getSupport()
	 */
	//@Override
	public String getSupport() {
		// TODO Auto-generated method stub
		if (element.hasAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME))
			return element.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME);
		else
			return null;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#setSupport(java.lang.String)
	 */
	//@Override
	public void setSupport(String support) {
		if (support==null) {
			element.removeAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME);
		}
		else
			element.setAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME, support);
	}

}
