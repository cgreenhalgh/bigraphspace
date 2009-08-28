/**
 * 
 */
package bigraphspace.model.xml;

import java.io.IOException;
import java.io.Writer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import bigraphspace.io.BigraphWriter;
import bigraphspace.io.IOConstants;
import bigraphspace.model.Bigraph;

/**
 * @author cmg
 *
 */
public class DomXmlBigraphWriter extends BigraphWriter {
	/** cons */
	DomXmlBigraphWriter() {
		super(IOConstants.FORMAT_XML);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.io.BigraphWriter#write(java.io.Writer)
	 */
	//@Override
	public void write(Bigraph bigraph, Writer writer) throws IOException {
		if (!(bigraph instanceof DomBigraph))
			throw new IllegalArgumentException("write("+bigraph+") - not DomBigraph");
		try {
			DomBigraph domBigraph = (DomBigraph)bigraph;
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			StreamResult result = new StreamResult(writer);
			transformer.transform(new DOMSource(domBigraph.getBigraphElement()), result);
		}
		// not thrown
		//catch (IOException ioe) {
		//	throw ioe;
		//}
		catch (Exception e) {
			throw new IOException("Writing bigraph", e);
		}
	}

}
