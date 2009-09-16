package bigraph.biged.model;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import bigraphspace.model.Bigraph;
import bigraphspace.model.xml.DomBigraph;

public class XMLModelSaver
{
	public void saveModel(final Bigraph bigraph, final OutputStream outputStream) throws IOException
	{
		try
		{
			if (bigraph instanceof DomBigraph)
			{
				final DomBigraph domgraph = (DomBigraph) bigraph;

				final DOMSource source = new DOMSource(domgraph.getDocument());
				final StreamResult result = new StreamResult(outputStream);

				final TransformerFactory transformerFactory = TransformerFactory.newInstance();
				final Transformer transformer = transformerFactory.newTransformer();
				transformer.transform(source, result);

				outputStream.flush();
				outputStream.close();
			}
			else
			{
				throw new Exception("Not a DomBigraph");
			}
		}
		catch (final Exception e)
		{
			throw new IOException(e);
		}
	}
}
