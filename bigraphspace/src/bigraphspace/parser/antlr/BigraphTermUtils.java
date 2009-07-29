package bigraphspace.parser.antlr;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.antlr.runtime.tree.Tree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import bigraphspace.model.xml.Constants;
import bigraphspace.parser.antlr.BigraphTermParser;

/** BigraphTerm language utils.
 * 
 * @author cmg
 *
 */
public class BigraphTermUtils {
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
			if (root.getType()!=BigraphTermParser.ROOT)
				throw new ParseException("tree child node "+ri+" is not ROOT ("+root.getType()+"/"+root.getText()+")");
			Element rootEl = doc.createElement(Constants.ROOT_ELEMENT_NAME);
			docEl.appendChild(rootEl);
			// children should be primes/nodes
			processPrimeChildren(doc, rootEl, root);
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
					if (index.getType()!=BigraphTermParser.NUMERAL)
						throw new ParseException("Hole had non-NUMERAL child ("+index.getType()+"/"+index.getText()+")");
					// TODO 
					System.out.println("Warning: hole name ignored ("+index.getText()+")");
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
				if (index.startsWith("$"))
					indexEl.setAttribute(Constants.INDEX_VARIABLE_ATTRIBUTE_NAME, index);
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
}
