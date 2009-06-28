/**
 * 
 */
package bigraphspace.model.xml;
import java.io.File;
import java.io.PrintStream;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

/** Some XML utilities.
 * 
 * @author cmg
 *
 */
public class XmlUtils {
	/** read XML file */
	public static Document readFile(File inputFile) throws ParserConfigurationException, SAXException, IOException {
		// JAXP standard code to red
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setCoalescing(true);
		// avoids possible network lookups that are liable to fail, but prevents XML shorthand using entity refs
		factory.setExpandEntityReferences(false);
		factory.setIgnoringComments(true);
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		factory.setIgnoringElementContentWhitespace(false);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputFile);
		return doc;
	}
	/** write XML file */
	public static void writeFile(Document document, File outputFile) throws TransformerConfigurationException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		StreamResult result = new StreamResult(outputFile);
		transformer.transform(new DOMSource(document), result);
	}
	/** write XML file */
	public static void write(Document document, Writer writer) throws TransformerConfigurationException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		StreamResult result = new StreamResult(writer);
		transformer.transform(new DOMSource(document), result);
	}
	/** dump a text structure view of the document (debug) */
	public static void dump(PrintStream ps, Document doc) {
		ps.println("Document "+doc.getDocumentURI());
		dump(ps, doc.getDocumentElement(), 1);
	}
	/** dump an element, recursively */
	public static void dump(PrintStream ps, Element el, int indent) {
		ps.println(getIndent(indent)+el);
		NamedNodeMap attributes = el.getAttributes();
		for(int ai=0; ai<attributes.getLength(); ai++) {
			Node attribute = attributes.item(ai);
			ps.println(getIndent(indent+1)+attribute);
		}
		NodeList children = el.getChildNodes();		
		for(int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (child instanceof Element)
				dump(ps, (Element)child, indent+1);
			else
				ps.println(getIndent(indent+1)+child);
		}
	}
	/** indent text */
	public static String getIndent(int indent) {
		StringBuffer buf = new StringBuffer();
		for (int i=0; i<indent; i++)
			buf.append(INDENT_TEXT);
		return buf.toString();
	}
	/** default indent text - 2 spaces */
	public static final String INDENT_TEXT = "  ";
}
