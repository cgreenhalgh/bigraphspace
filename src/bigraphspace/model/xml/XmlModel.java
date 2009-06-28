/**
 * 
 */
package bigraphspace.model.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

import java.io.PrintStream;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;

import bigraphspace.model.BasicSignature;
import bigraphspace.model.Control;

/** Wrapper around XML document bigraph model - old implementation; see DomBigraph, etc..
 * 
 * @author cmg
 *
 */
public class XmlModel {
	/** logger */
	static Logger logger = Logger.getLogger(XmlModel.class);
	/** document */
	protected Document document;
	/** bigraph element */
	protected Element bigraphEl;
	/** signature */
	protected BasicSignature signature;
	/** cons */
	public XmlModel() {				
	}
	/** new empty model */
	public static XmlModel newModel(BasicSignature signature) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		Element bigraphEl = document.createElement(Constants.BIGRAPH_ELEMENT_NAME);
		document.appendChild(bigraphEl);
		return new XmlModel(document, bigraphEl, signature);
	}
	/**
	 * @param bigraphEl
	 */
	public XmlModel(Document document, Element bigraphEl, BasicSignature signature) {
		super();
		this.document = document;
		this.bigraphEl = bigraphEl;
		this.signature = signature;
	}
	/**
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}
	/**
	 * @return the bigraphEl
	 */
	public Element getBigraphEl() {
		return bigraphEl;
	}
	/**
	 * @return the signature
	 */
	public BasicSignature getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(BasicSignature signature) {
		this.signature = signature;
	}
	/** 
	 * @return the regions/roots 
	 */
	public List<Element> getRoots() {
		LinkedList<Element> rootEls = new LinkedList<Element>();
		NodeList children = bigraphEl.getChildNodes();
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (child instanceof Element) {
				Element childEl = (Element)child;
				if (Constants.ROOT_ELEMENT_NAME.equals(childEl.getNodeName()))
					rootEls.add(childEl);
				else
					logger.warn("getRoots() found child "+childEl);
			}
		}
		return rootEls;
	}
	/** create root */
	public Element createRoot() {
		Element rootEl = document.createElement(Constants.ROOT_ELEMENT_NAME);
		return rootEl;
	}
	/** add root */
	public Element addRoot() {
		Element rootEl = createRoot();
		bigraphEl.appendChild(rootEl);
		return rootEl;
	}
	/** create node */
	public Element createNode(Control control) {
		Element nodeEl = document.createElement(control.getName());
		return nodeEl;
	}
	/** 
	 * @return the children (Elements)
	 */
	public List<Element> getChildren(Element parent) {
		LinkedList<Element> childEls = new LinkedList<Element>();
		NodeList children = parent.getChildNodes();
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (child instanceof Element) {
				Element childEl = (Element)child;
				childEls.add(childEl);
			}
		}
		return childEls;
	}
	/** is hole?
	 * 
	 */
	public boolean isHole(Element node) {
		return Constants.SITE_ELEMENT_NAME.equals(node.getNodeName());
	}
	/** get hole index */
	public int getHoleIndex(Element hole) {
		String index = hole.getAttribute(Constants.SITE_INDEX_ATTRIBUTE_NAME);
		if (index!=null) {
			try {
				return Integer.parseInt(index);
			}
			catch (NumberFormatException nfe) {
				logger.error("Invalid hole index "+index, nfe);
			}
		}
		// deduce index by walking tree depth-first and counting holes
		int pindex[] = new int[1];
		if (findHoleIndex(hole, this.bigraphEl, pindex))
			return pindex[0];
		logger.error("Did not find hole "+hole+" in bigraph (getHoleIndex)");
		return 0;
	}
	/** deduce index by walking tree depth-first and counting holes */
	protected boolean findHoleIndex(Element hole, Element node, int nextIndex[]) {
		if (hole==node)
			return true;
		if (this.isHole(node))
			nextIndex[0]++;
		List<Element> childEls = this.getChildren(node);
		for (Element childEl : childEls) {
			// depth first
			if (findHoleIndex(hole, childEl, nextIndex))
				return true;			
		}
		return false;
	}
	/** is root?
	 * 
	 */
	public boolean isRoot(Element node) {
		return Constants.ROOT_ELEMENT_NAME.equals(node.getNodeName());
	}
	/** get control name */
	public String getControlName(Element node) {
		return node.getNodeName();
	}
	/** get control from signature */
	public Control getControl(Element node) {
		String controlName = getControlName(node);
		for (Control control : signature.getControls()) {
			if (controlName.equals(control.getName()))
				return control;
		}
		logger.warn("Unknown control for "+node);
		return null;
	}
	/**
	 * @return the ports (Attributes) as Map
	 */
	public HashMap<String,String> getPorts(Element node) {
		HashMap<String,String> ports = new HashMap<String,String>();
		NamedNodeMap attributes = node.getAttributes();
		for(int ai=0; ai<attributes.getLength(); ai++) {
			Node attribute = attributes.item(ai);
			ports.put(attribute.getNodeName(), attribute.getNodeValue());
		}
		return ports;
	}
	/** dump - debug */
	public void dump(PrintStream ps) {
		List<Element> rootEls = this.getRoots();
		ps.println("XML Bigraph, "+rootEls.size()+" roots:");
		for (Element rootEl : rootEls) {
			dump(ps, rootEl, 1);
		}
	}
	/** dump an element, recursively */
	public void dump(PrintStream ps, Element el, int indent) {
		if (this.isHole(el))
			ps.println(XmlUtils.getIndent(indent)+"_");
		else
			ps.println(XmlUtils.getIndent(indent)+getControlName(el));
		Map<String,String> ports = this.getPorts(el);
		if (ports.size()>0) {
			ps.println(XmlUtils.getIndent(indent)+"{");
			for (String portName : ports.keySet()) {
				String value = ports.get(portName);
				ps.println(XmlUtils.getIndent(indent+1)+portName+"="+value);
			}
			ps.println(XmlUtils.getIndent(indent)+"}");
		}
		List<Element> childEls = this.getChildren(el);
		if (childEls.size()>0) {
			ps.println(XmlUtils.getIndent(indent)+"(");
			for (Element childEl : childEls) {
				dump(ps, childEl, indent+1);
			}
			ps.println(XmlUtils.getIndent(indent)+")");
		}
	}
}
