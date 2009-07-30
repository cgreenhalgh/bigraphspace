package bigraphspace.parser.antlr;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.antlr.runtime.tree.Tree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import bigraphspace.model.VariableType;
import bigraphspace.model.VariableConstraintType;
import bigraphspace.model.xml.XmlUtils;
import bigraphspace.model.xml.Constants;
import bigraphspace.parser.antlr.BigraphTermParser;

import org.apache.log4j.Logger;


/** BigraphTerm language utils.
 * 
 * @author cmg
 *
 */
public class BigraphTermUtils {
	/** logger */
	static Logger logger = Logger.getLogger(BigraphTermUtils.class);
	/** Parse CommonTree from BigraphTerm language to XML document form (DOM) */
	public static Document toDocument(Tree tree) throws ParserConfigurationException, ParseException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		// TODO: support for rule ?!
		// root should be 'bigraph'
		if (tree.getType()!=BigraphTermParser.BIGRAPH)
			throw new ParseException("tree root node is not BIGRAPH ("+tree.getType()+"/"+tree.getText()+")");
		// root element
		doc.appendChild(doc.createElement(Constants.BIGRAPH_ELEMENT_NAME));
		Element docEl = doc.getDocumentElement();
		// children should be ROOTs
		for (int ri=0; ri<tree.getChildCount(); ri++) {
			Tree root = tree.getChild(ri);
			if (root.getType()==BigraphTermParser.EOF)
				// ignore EOF
				continue;
			if (root.getType()==BigraphTermParser.ROOT) {
				Element rootEl = doc.createElement(Constants.ROOT_ELEMENT_NAME);
				docEl.appendChild(rootEl);
				// children should be primes/nodes
				processPrimeChildren(doc, rootEl, root);
			}
			else if (root.getType()==BigraphTermParser.WHERE) {
				processVariables(doc, docEl, root);
			}
			else
				throw new ParseException("tree child node "+ri+" is not ROOT or WHERE ("+root.getType()+"/"+root.getText()+")");
		}
		return doc;
	}
	/** recursively convert children (primes/nodes) to elements */
	static void processPrimeChildren(Document doc, Element el, Tree parent) throws ParseException {
		for (int ci=0; ci<parent.getChildCount(); ci++) {
			Tree child = parent.getChild(ci);
			if (child.getType()==BigraphTermParser.EMPTY)
				// ignore empty
				continue;
			// hole?
			if (child.getType()==BigraphTermParser.UNDERSCORE) {
				// may have number as child
				Element nodeEl = doc.createElement(Constants.SITE_ELEMENT_NAME);
				el.appendChild(nodeEl);
				if (child.getChildCount()==0) {
					// unnamed
				}
				else if (child.getChildCount()==1) {
					// name?!
					Tree index = child.getChild(0);
					if (index.getType()!=BigraphTermParser.NUMBER)
						throw new ParseException("Hole had non-NUMBER child ("+index.getType()+"/"+index.getText()+")");
					nodeEl.setAttribute(Constants.SITE_INDEX_ATTRIBUTE_NAME, index.getText());
				}
				else
					throw new ParseException("Hole had "+child.getChildCount()+" children; should be 0 or 1 (optional index)");				
				continue;
			}
			// should be node (node control)
			if (child.getType()!=BigraphTermParser.NODE)
				throw new ParseException("Expected node NODE ("+child.getType()+"/"+child.getText()+")");
			// first child should be CONTROL
			if (child.getChildCount()<1) 
				throw new ParseException("Node NODE had no children");
			Tree control = child.getChild(0);
			if (control.getType()!=BigraphTermParser.CONTROL)
				throw new ParseException("Expected node CONTROL ("+control.getType()+"/"+control.getText()+")");
			// first child should control name; any further children should be index values/variables
			if (control.getChildCount()<1)
				throw new ParseException("Node CONTROL had no children");
			
			Element nodeEl = doc.createElement(control.getChild(0).getText());
			el.appendChild(nodeEl);
			for (int ii=1; ii<control.getChildCount(); ii++) {
				Tree indexnode = control.getChild(ii);
				String index = indexnode.getText();
				Element indexEl = doc.createElement(Constants.INDEX_ELEMENT_NAME);
				if (index.startsWith("$")) {
					indexEl.setAttribute(Constants.INDEX_VARIABLE_ATTRIBUTE_NAME, index.substring(1));
					// infer type from signature?
				}
				else
					indexEl.appendChild(doc.createTextNode(index));
				nodeEl.appendChild(indexEl);
			}
			
			for (int si=1; si<child.getChildCount(); si++) {
				Tree subnode = child.getChild(si);
				if (subnode.getType()==BigraphTermParser.PORTS) {
					// ports => attributes...
					for (int pi=0; pi<subnode.getChildCount(); pi++) {
						Tree port = subnode.getChild(pi);
						String portName = "port"+(pi+1);
						if (port.getType()==BigraphTermParser.UNNAMED) {
							// unnamed port
							// take default name?!
							System.err.println("Warning: unnamed port - using "+portName);
						}
						else if (port.getType()==BigraphTermParser.IDENTIFIER) {
							// named port
							portName = port.getText();
						}
						else
							throw new ParseException("Port name not UNNAMED or IDENTIFIER ("+port.getType()+"/"+port.getText()+")");
						if (port.getChildCount()!=1) 
							throw new ParseException("Port name node "+portName+" has "+port.getChildCount()+" children; should be 1");
						Tree link = port.getChild(0);
						if (link.getType()!=BigraphTermParser.IDENTIFIER && link.getType()!=BigraphTermParser.STRING &&
								link.getType()!=BigraphTermParser.NUMBER && link.getType()!=BigraphTermParser.NUMERAL)
							throw new ParseException("Port link value not IDENTIFIER/STRING/NUMBERAL/NUMBER ("+link.getType()+"/"+link.getText()+")");
						String portValue = link.getText();
						
						nodeEl.setAttribute(portName, portValue);
					}
				}
				else if (subnode.getType()==BigraphTermParser.CHILDREN) {
					// children => recurse...
					processPrimeChildren(doc, nodeEl, subnode);
				}
				else 
					throw new ParseException("Unexpected node child (not PORTS or CHILDREN) ("+subnode.getType()+"/"+subnode.getText()+")");
			}
			
		}
	}
	/** convert children (constraints) to elements */
	static void processVariables(Document doc, Element docEl, Tree parent) throws ParseException {
		for (int ci=0; ci<parent.getChildCount(); ci++) {
			Tree tconstraint = parent.getChild(ci);
			if (tconstraint.getType()!=BigraphTermParser.CONSTRAINT) 
				throw new ParseException("Unexpected WHERE node child (not CONSTRAINT) ("+tconstraint.getType()+"/"+tconstraint.getText()+")");
			if (tconstraint.getChildCount()<3)
				throw new ParseException("CONSTRAINT node wih only "+tconstraint.getChildCount()+" children - should be >=3");
			String variableName = tconstraint.getChild(0).getText();
			if (!variableName.startsWith("$"))
				throw new ParseException("Found where CONSTRAINT with non-variable identifier "+variableName);
			variableName = variableName.substring(1);
			Element variableEl = null;
			NodeList variableEls = XmlUtils.getChildElementsByTagName(docEl, Constants.VARIABLE_ELEMENT_NAME);
			logger.debug("Found "+variableEls.getLength()+" exising variables");
			for (int vi=0; vi<variableEls.getLength(); vi++) {
				Element vEl = (Element)variableEls.item(vi);
				if (vEl.getAttribute(Constants.VARIABLE_NAME_ATTRIBUTE_NAME).equals(variableName)) {
					variableEl= vEl;
					break;
				}
				else
					logger.debug("Found variable "+vEl.getAttribute(Constants.VARIABLE_NAME_ATTRIBUTE_NAME)+" (looking for "+variableName+")");
			}
			String constraintType = tconstraint.getChild(1).getText().toLowerCase();
			if (constraintType.equals(":")) {
				// introduce type
				if (variableEl!=null)
					throw new ParseException("Found more than one type declaration for variable "+variableName);
				variableEl = doc.createElement(Constants.VARIABLE_ELEMENT_NAME);
				variableEl.setAttribute(Constants.VARIABLE_NAME_ATTRIBUTE_NAME, variableName);
				variableEl.setAttribute(Constants.VARIABLE_BASE_TYPE_ATTRIBUTE_NAME, tconstraint.getChild(2).getText());
				docEl.appendChild(variableEl);
				logger.debug("declared variable "+variableName);
				NodeList variableEls2 = XmlUtils.getChildElementsByTagName(docEl, Constants.VARIABLE_ELEMENT_NAME);
				logger.debug("-> "+variableEls2.getLength()+" variables");
			}
			else if (constraintType.equals(VariableConstraintType.maxlength.name()) ||
					constraintType.equals(VariableConstraintType.minlength.name()) ||
					constraintType.equals(VariableConstraintType.minvalue.name()) ||
					constraintType.equals(VariableConstraintType.maxvalue.name()) ||
					constraintType.equals(VariableConstraintType.regexp.name())) {
				if (variableEl==null)
					throw new ParseException("Found constraint "+constraintType+" for undeclared variable "+variableName);
				Element constraintEl = doc.createElement(Constants.CONSTRAINT_ELEMENT_NAME);
				constraintEl.setAttribute(Constants.CONSTRAINT_TYPE_ATTRIBUTE_NAME, constraintType);
				constraintEl.appendChild(doc.createTextNode(tconstraint.getChild(2).getText()));
				variableEl.appendChild(constraintEl);
			} else if (constraintType.equals(VariableConstraintType.oneof.name()) ||
					constraintType.equals(VariableConstraintType.notoneof.name())) {
				if (variableEl==null)
					throw new ParseException("Found constraint for undeclared variable "+variableName);
				Element constraintEl = doc.createElement(Constants.CONSTRAINT_ELEMENT_NAME);
				constraintEl.setAttribute(Constants.CONSTRAINT_TYPE_ATTRIBUTE_NAME, constraintType);
				for (int vi=2; vi<tconstraint.getChildCount(); vi++) {
					Element valueEl = doc.createElement(Constants.VALUE_ELEMENT_NAME);
					valueEl.appendChild(doc.createTextNode(tconstraint.getChild(vi).getText()));
					constraintEl.appendChild(valueEl);
				}
			} else if (constraintType.equals("+") || constraintType.equals("-")) {
				//VariableConstraintType.difference.name())) {
				if (variableEl==null)
					throw new ParseException("Found difference constraint for undeclared variable "+variableName);
				Element constraintEl = doc.createElement(Constants.CONSTRAINT_ELEMENT_NAME);
				constraintEl.setAttribute(Constants.CONSTRAINT_TYPE_ATTRIBUTE_NAME, VariableConstraintType.difference.name());
				String otherVariableName = tconstraint.getChild(2).getText();
				if (!otherVariableName.startsWith("$"))
					throw new ParseException("Found difference CONSTRAINT with non-variable other identifier "+otherVariableName);
				otherVariableName = otherVariableName.substring(1);
				constraintEl.setAttribute(Constants.CONSTRAINT_VARIABLE_ATTRIBUTE_NAME, otherVariableName);
				constraintEl.appendChild(doc.createTextNode((constraintType.equals("-") ? "-" : "")+tconstraint.getChild(3).getText()));
				variableEl.appendChild(constraintEl);				
			}
			else
				throw new ParseException("Found unknown CONSTRAINT type "+constraintType);
		}
	}
}
