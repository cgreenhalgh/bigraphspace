/**
 * 
 */
package bigraphspace.model.xml;

import java.io.IOException;
import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.xml.sax.SAXException;

import org.apache.log4j.Logger;

import bigraphspace.model.BasicSignature;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Control;
import bigraphspace.model.Place;
import bigraphspace.model.Port;
import bigraphspace.model.VariableDefinition;
import bigraphspace.model.VariableConstraint;
import bigraphspace.model.VariableConstraintType;
import bigraphspace.model.VariableType;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;


/** XML/Dom-based implementation of Bigraph interface = Document.
 * 
 * @author cmg
 *
 */
public class DomBigraph implements Bigraph {
	/** logger */
	static Logger logger = Logger.getLogger(DomBigraph.class);
	
	/** common factory */
	protected static DocumentBuilder builder;
	
	/** document */
	protected Document document;
	
	/** root element of bigraph - may not be document root element */
	protected Element bigraphElement;
	
	/** signature */
	protected BasicSignature signature;
	
	/** cons, new empty document - local */
	public DomBigraph(BasicSignature signature) throws ParserConfigurationException {
		this.signature = signature;
		synchronized(DomBigraph.class) {
			if (builder==null) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				builder = factory.newDocumentBuilder();
			}
		}
		document = builder.newDocument();
		bigraphElement = document.createElement(Constants.BIGRAPH_ELEMENT_NAME);
		document.appendChild(bigraphElement);
	}
	/** cons - local */
	public DomBigraph(BasicSignature signature, Document document) {
		this.signature = signature;
		this.document = document;
		this.bigraphElement = document.getDocumentElement();
	}
	/** cons with explicit document root (bigraph) element - local */
	public DomBigraph(BasicSignature signature, Document document, Element bigraphElement) {
		this.signature = signature;
		this.document = document;
		this.bigraphElement = bigraphElement;
	}
	/** new bigraph model */
	public static Bigraph newBigraph(BasicSignature signature) throws ParserConfigurationException {
		return new DomBigraph(signature);
	}
	/** read from XML file */
	public static Bigraph read(BasicSignature signature, File inputFile)throws ParserConfigurationException, SAXException, IOException {
		Document document = XmlUtils.readFile(inputFile);
		return new DomBigraph(signature, document);
	}
	/** write to XML file */
	public void write(File outputFile) throws TransformerConfigurationException, TransformerException {
		XmlUtils.writeFile(document, outputFile);
	}
	/** get document */
	public Document getDocument() {
		return document;
	}
	/** get bigraph root element */
	public Element getBigraphElement() {
		return bigraphElement;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#addRoot(bigraphspace.model.Place)
	 */
	//@Override
	public void addRoot(Place root) {
		if (!root.isRoot())
			throw new IllegalArgumentException("addRoot("+root+") - not root");
		if (root instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)root;
			bigraphElement.appendChild(domPlace.getElement());
		}
		else
			throw new IllegalArgumentException("addRoot("+root+") - not DomPlace");
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#clear()
	 */
	//@Override
	public void clear() {
		while(bigraphElement.hasChildNodes()) {
			Node child = bigraphElement.getFirstChild();
			bigraphElement.removeChild(child);
		}
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#createNode(java.lang.String)
	 */
	//@Override
	public Place createNode(String controlName) {
		Element nodeEl = document.createElement(controlName);
		return new DomPlace(nodeEl);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#createNode(java.lang.String)
	 */
	//@Override
	public Place createNode(Control control) {
		Element nodeEl = document.createElement(control.getName());
		return new DomPlace(nodeEl);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#createRoot()
	 */
	//@Override
	public Place createRoot() {
		return createNode(Constants.ROOT_ELEMENT_NAME);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#createSite()
	 */
	//@Override
	public Place createSite() {
		return createNode(Constants.SITE_ELEMENT_NAME);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#getControl(bigraphspace.model.Place)
	 */
	//@Override
	public Control getControl(Place node) {
		return signature.getControl(node.getControlName());
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#getRoots()
	 */
	@Override
	public List<Place> getRoots() {
		NodeList rootEls = XmlUtils.getChildElementsByTagName(bigraphElement, Constants.ROOT_ELEMENT_NAME);
		LinkedList<Place> roots = new LinkedList<Place>();
		for (int i=0; i<rootEls.getLength(); i++) {
			Element rootEl = (Element)rootEls.item(i);
			roots.add(new DomPlace(rootEl));
		}
		return roots;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#getSignature()
	 */
	//@Override
	public BasicSignature getSignature() {
		return signature;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#setSignature(bigraphspace.model.BasicSignature)
	 */
	//@Override
	public void setSignature(BasicSignature signature) {
		this.signature = signature;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#insertRoot(bigraphspace.model.Place, int)
	 */
	//@Override
	public void insertRoot(Place root, int atIndex) {
		if (!root.isRoot())
			throw new IllegalArgumentException("insertRoot("+root+") - not root");
		if (root instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)root;
			NodeList rootEls = XmlUtils.getChildElementsByTagName(bigraphElement,Constants.ROOT_ELEMENT_NAME);
			Node refChild = (atIndex>=0 && atIndex<rootEls.getLength()) ? rootEls.item(atIndex) : null;
			bigraphElement.insertBefore(domPlace.getElement(), refChild);
		}
		else
			throw new IllegalArgumentException("insertRoot("+root+") - not DomPlace");
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#removeRoot(bigraphspace.model.Place)
	 */
	@Override
	public void removeRoot(Place root) {
		if (!root.isRoot())
			throw new IllegalArgumentException("removeRoot("+root+") - not root");
		if (root instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)root;
			bigraphElement.removeChild(domPlace.getElement());
		}
		else
			throw new IllegalArgumentException("removeRoot("+root+") - not DomPlace");
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#getEdgeNames()
	 */
	//@Override
	public Set<String> getEdgeNames() {
		return getSpecialNames(Constants.EDGE_ELEMENT_NAME);
	}
	/** get edge/hidden names */
	protected Set<String> getSpecialNames(String elementName) {
		TreeSet<String> names = new TreeSet<String>();
		NodeList nodes = XmlUtils.getChildElementsByTagName(this.bigraphElement,elementName);
		for (int i=0; i<nodes.getLength(); i++) {
			Element node = (Element)nodes.item(i);
			String id = node.getAttribute(Constants.LINK_NAME_ATTRIBUTE_NAME);
			if (id!=null && id.length()>0)
				names.add(id);
			else
				logger.warn("Bigraph has "+elementName+" with no "+Constants.LINK_NAME_ATTRIBUTE_NAME+" attribute");
		}
		return names;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#getHiddenNames()
	 */
	//@Override
	public Set<String> getHiddenNames() {
		return getSpecialNames(Constants.HIDE_ELEMENT_NAME);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#addEdge(java.lang.String)
	 */
	//@Override
	public void addEdge(String name) {
		addSpecialName(Constants.EDGE_ELEMENT_NAME, name);
	}
	protected void addSpecialName(String elementName, String name) {
		NodeList nodes = XmlUtils.getChildElementsByTagName(this.bigraphElement,elementName);
		for (int i=0; i<nodes.getLength(); i++) {
			Element node = (Element)nodes.item(i);
			String id = node.getAttribute(Constants.LINK_NAME_ATTRIBUTE_NAME);
			if (id!=null && id.length()>0 && id.equals(name))
				// already there
				return;
		}
		// add
		Element el = this.document.createElement(elementName);
		el.setAttribute(Constants.LINK_NAME_ATTRIBUTE_NAME, name);
		this.bigraphElement.appendChild(el);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#addHidden(java.lang.String)
	 */
	//@Override
	public void addHidden(String name) {
		addSpecialName(Constants.HIDE_ELEMENT_NAME, name);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#removeEdge(java.lang.String)
	 */
	//@Override
	public void removeEdge(String name) {
		removeSpecialName(Constants.EDGE_ELEMENT_NAME, name);
	}
	protected void removeSpecialName(String elementName, String name) {
		NodeList nodes = XmlUtils.getChildElementsByTagName(this.bigraphElement,elementName);
		for (int i=0; i<nodes.getLength(); i++) {
			Element node = (Element)nodes.item(i);
			String id = node.getAttribute(Constants.LINK_NAME_ATTRIBUTE_NAME);
			if (id!=null && id.length()>0 && id.equals(name)) {
				// already there
				bigraphElement.removeChild(node);
				return;
			}
		}
		// not there - nop
		return;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#removeHidden(java.lang.String)
	 */
	//@Override
	public void removeHidden(String name) {
		removeSpecialName(Constants.HIDE_ELEMENT_NAME, name);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#addInnerNameMapping(java.lang.String, java.lang.String)
	 */
	//@Override
	public void addInnerNameMapping(String innerName, String edge) {
		// already here?
		NodeList nodes = XmlUtils.getChildElementsByTagName(this.bigraphElement, Constants.INNERNAME_ELEMENT_NAME);
		for (int i=0; i<nodes.getLength(); i++) {
			Element el = (Element)nodes.item(i);
			String name = el.getAttribute(Constants.INNERNAME_NAME_ATTRIBUTE_NAME);
			if (name!=null && name.equals(innerName)) {
				el.setAttribute(Constants.LINK_NAME_ATTRIBUTE_NAME, edge);
				return;
			}
		}
		// new
		Element el = this.document.createElement(Constants.INNERNAME_ELEMENT_NAME);
		el.setAttribute(Constants.INNERNAME_NAME_ATTRIBUTE_NAME, innerName);
		el.setAttribute(Constants.LINK_NAME_ATTRIBUTE_NAME, edge);		
		this.bigraphElement.appendChild(el);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#getInnerNameMap()
	 */
	//@Override
	public Map<String, String> getInnerNameMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		NodeList nodes = XmlUtils.getChildElementsByTagName(this.bigraphElement, Constants.INNERNAME_ELEMENT_NAME);
		for (int i=0; i<nodes.getLength(); i++) {
			Element el = (Element)nodes.item(i);
			String id = el.getAttribute(Constants.LINK_NAME_ATTRIBUTE_NAME);
			if (id==null || id.length()==0)
				id = Bigraph.UNSPECIFIED_EDGE_NAME;
			String name = el.getAttribute(Constants.INNERNAME_NAME_ATTRIBUTE_NAME);
			if (name!=null && name.length()>0)
				map.put(name, id);
		}
		return map;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#removeInnerNameMapping(java.lang.String, java.lang.String)
	 */
	//@Override
	public void removeInnerNameMapping(String innerName) {
		// already here?
		NodeList nodes = XmlUtils.getChildElementsByTagName(this.bigraphElement, Constants.INNERNAME_ELEMENT_NAME);
		for (int i=0; i<nodes.getLength(); i++) {
			Element el = (Element)nodes.item(i);
			String name = el.getAttribute(Constants.INNERNAME_NAME_ATTRIBUTE_NAME);
			if (name!=null && name.equals(innerName)) {
				this.bigraphElement.removeChild(el);
			}
		}
		// noop
	}
	/** dump - debug */
	public void dump(PrintStream ps) {
		List<Place> roots = this.getRoots();
		ps.println("XML Bigraph, "+roots.size()+" roots:");
		for (Place root : roots) {
			dump(ps, root, 1);
		}
		Set<String> edges = this.getEdgeNames();
		Set<String> hiddens = this.getHiddenNames();
		ps.print(edges.size()+" edges: ");
		for (String edge : edges)
			ps.print(edge+" ");
		ps.println();
		ps.print(hiddens.size()+" hidden names (non-inner names): ");
		for (String hidden: hiddens)
			ps.print(hidden+" ");
		ps.println();
		Map<String,String> innerNameMap = this.getInnerNameMap();
		ps.println(innerNameMap.size()+" inner name mappings: "+innerNameMap);
		dumpVariables(ps);
	}
	/** dump debug */
	public void dumpVariables(PrintStream ps) {
		Map<String,VariableDefinition> variables = this.getVariables();
		ps.println(variables.size()+" variables:");
		if (variables.size()==0)
			return;
		for (String name : variables.keySet()) {
			VariableDefinition definition = variables.get(name);
			ps.print("where "+name+":"+definition.getBaseType());
			List<VariableConstraint> constraints = definition.getConstraints();
			for (VariableConstraint constraint : constraints) {
				ps.print(" and "+name+" "+constraint.getConstraintType());
				if (constraint.getVariableName()!=null)
					ps.print(" "+constraint.getVariableName());
				for (Object value : constraint.getValues()) {
					ps.print(" "+value);
				}
			}
			ps.println();
		}
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#addVariable(java.lang.String, bigraphspace.model.VariableDefinition)
	 */
	//@Override
	public void addVariable(String name, VariableDefinition definition) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Unimplemented: DomBigraph.addVariable");
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#getVariables()
	 */
	//@Override
	public Map<String, VariableDefinition> getVariables() {
		NodeList variableEls = XmlUtils.getChildElementsByTagName(this.bigraphElement, Constants.VARIABLE_ELEMENT_NAME);
		//logger.debug(variableEls.getLength()+" <variable> elements");
		Map<String, VariableDefinition> variables = new HashMap<String, VariableDefinition> ();
		for (int i=0; i<variableEls.getLength(); i++) {
			Element variableEl = (Element)variableEls.item(i);
			String name = variableEl.getAttribute(Constants.VARIABLE_NAME_ATTRIBUTE_NAME);
			if (name==null || name.length()==0) {
				logger.warn("<variable> with no name");
				continue;
			}
			VariableDefinition definition = new VariableDefinition();
			String baseType = variableEl.getAttribute(Constants.VARIABLE_BASE_TYPE_ATTRIBUTE_NAME);
			if (baseType==null || baseType.length()==0) {
				logger.warn("<variable name=\""+name+"\"> with no "+Constants.VARIABLE_BASE_TYPE_ATTRIBUTE_NAME);
				continue;
			}
			definition.setBaseType(VariableType.valueOf(baseType));
			List<VariableConstraint> constraints = definition.getConstraints();
			NodeList constraintEls = variableEl.getChildNodes();
			for (int ci=0; ci<constraintEls.getLength(); ci++) {
				if (constraintEls.item(ci) instanceof Element) {
					Element constraintEl = (Element)constraintEls.item(ci);
					String constraintName = constraintEl.getNodeName();
					VariableConstraint constraint = new VariableConstraint();
					constraint.setConstraintType(VariableConstraintType.valueOf(constraintName));
					String variableName = constraintEl.getAttribute(Constants.DIFFERENCE_VARIABLE_ATTRIBUTE_NAME);
					if (variableName!=null && variableName.length()>0)
						constraint.setVariableName(variableName);
					List<Object> values = constraint.getValues();
					if (constraintName.equals(Constants.ONEOF_ELEMENT_NAME) || constraintName.equals(Constants.NOTONEOF_ELEMENT_NAME)) {
						NodeList valueEls = XmlUtils.getChildElementsByTagName(constraintEl, Constants.VALUE_ELEMENT_NAME);
						for (int vi=0; vi<valueEls.getLength(); vi++) {
							Element valueEl = (Element)valueEls.item(vi);
							values.add(valueEl.getTextContent());
						}							
					}
					else {
						// single valued
						values.add(constraintEl.getTextContent().trim());
					}
					constraints.add(constraint);
				}
			}
			variables.put(name, definition);
		}
		return variables;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#isExpression()
	 */
	//@Override
	public boolean isExpression() {
		NodeList variableEls = XmlUtils.getChildElementsByTagName(this.bigraphElement,Constants.VALUE_ELEMENT_NAME);
		return variableEls.getLength()>0;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Bigraph#removeVariable(java.lang.String)
	 */
	//@Override
	public void removeVariable(String name) {
		throw new RuntimeException("Unimplemented: DomBigraph.removeVariable");
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#addControlIndex(java.lang.Object)
	 */
	//@Override
	public void addControlIndex(Place place, Object value) {
		if (place instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)place;
			Element indexEl = this.document.createElement(Constants.INDEX_ELEMENT_NAME);
			indexEl.appendChild(document.createTextNode(normalizeControlIndexValue(value)));			
			domPlace.element.appendChild(indexEl);
		}
		else
			throw new IllegalArgumentException("addControlIndex("+place+") - not DomPlace");
	}
	/** coerce value object to XML representation - just tostring for now.
	 */
	public static String normalizeControlIndexValue(Object value) {
		if (value==null)
			return "";
		// TODO normalise 
		return value.toString();
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#insertControlIndex(java.lang.Object, int)
	 */
	//@Override
	public void insertControlIndex(Place place, Object value, int atIndex) {
		if (place instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)place;
			Element indexEl = this.document.createElement(Constants.INDEX_ELEMENT_NAME);
			indexEl.appendChild(document.createTextNode(normalizeControlIndexValue(value)));			
			NodeList indexEls = XmlUtils.getChildElementsByTagName(domPlace.element, Constants.INDEX_ELEMENT_NAME);
			if (atIndex<indexEls.getLength())
				domPlace.element.insertBefore(indexEl, indexEls.item(atIndex));
			else
				domPlace.element.appendChild(indexEl);
		}
		else
			throw new IllegalArgumentException("insertControlIndex("+place+") - not DomPlace");
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#removeControlIndex(java.lang.Object)
	 */
	//@Override
	public void removeControlIndex(Place place, Object value) {
		if (place instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)place;
			// hope the same thing happens
			String svalue = normalizeControlIndexValue(value);
			NodeList indexEls = XmlUtils.getChildElementsByTagName(domPlace.element, Constants.INDEX_ELEMENT_NAME);
			for (int ii=0; ii<indexEls.getLength(); ii++) {
				Element indexEl = (Element)indexEls.item(ii);
				String ival = indexEl.getTextContent();
				if (ival.equals(svalue)) {
					// found
					domPlace.element.removeChild(indexEl);
					return;
				}
			}
			logger.warn("removeControlIndex could not find index="+value);
		}
		else
			throw new IllegalArgumentException("removeControlIndex("+place+") - not DomPlace");		
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Place#setControlIndex(java.lang.Object, int)
	 */
	//@Override
	public void setControlIndex(Place place, Object value, int atIndex) {
		if (place instanceof DomPlace) {
			DomPlace domPlace = (DomPlace)place;
			Element newIndexEl = this.document.createElement(Constants.INDEX_ELEMENT_NAME);
			newIndexEl.appendChild(document.createTextNode(normalizeControlIndexValue(value)));			
			NodeList indexEls = XmlUtils.getChildElementsByTagName(domPlace.element, Constants.INDEX_ELEMENT_NAME);
			if (atIndex<indexEls.getLength()) {
				Element indexEl = (Element)indexEls.item(atIndex);
				domPlace.element.replaceChild(newIndexEl, indexEl);
			}
			else if (atIndex==indexEls.getLength())
				domPlace.element.appendChild(newIndexEl);
			else
				throw new IllegalArgumentException("setControlIndex("+place+","+value+","+atIndex+") with only "+indexEls.getLength()+" indexes so far");
		}
		else
			throw new IllegalArgumentException("setControlIndex("+place+") - not DomPlace");
	}
	/** dump an element, recursively */
	public void dump(PrintStream ps, Place place, int indent) {
		String support = place.getSupport()!=null ? place.getSupport()+":" : "";
		if (place.isSite())
			ps.println(XmlUtils.getIndent(indent)+support+"_");
		else if (place.isRoot())
			ps.println(XmlUtils.getIndent(indent)+support+"root");
		else {
			ps.print(XmlUtils.getIndent(indent)+support+place.getControlName());
			if (place.isIndexed()) {
				ps.print("<");
				List<Object> indexes = place.getControlIndexes();
				for (int i=0; i<indexes.size(); i++) {
					if (i>0)
						ps.print(",");
					ps.print(indexes.get(i));
				}
				ps.print(">");
			}
			ps.println();
		}
		List<Port> ports = place.getPorts();
		if (ports.size()>0) {
			ps.println(XmlUtils.getIndent(indent)+"{");
			for (Port port : ports) {
				String portName = port.getName();
				String value = port.getLinkName();
				ps.println(XmlUtils.getIndent(indent+1)+portName+"="+value);
			}
			ps.println(XmlUtils.getIndent(indent)+"}");
		}
		List<Place> children = place.getChildren();
		if (children.size()>0) {
			ps.println(XmlUtils.getIndent(indent)+"(");
			for (Place child : children) {
				dump(ps, child, indent+1);
			}
			ps.println(XmlUtils.getIndent(indent)+")");
		}
	}

}
