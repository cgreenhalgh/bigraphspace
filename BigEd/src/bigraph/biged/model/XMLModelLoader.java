package bigraph.biged.model;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import bigraphspace.model.BasicSignature;
import bigraphspace.model.xml.DomBigraph;

public class XMLModelLoader implements ModelLoader
{
	public Bigraph loadModel(final InputStream inputStream) throws IOException
	{
		try
		{
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setCoalescing(true);
			// avoids possible network lookups that are liable to fail, but prevents XML shorthand
			// using entity refs
			factory.setExpandEntityReferences(false);
			factory.setIgnoringComments(true);
			factory.setValidating(false);
			factory.setNamespaceAware(true);
			factory.setIgnoringElementContentWhitespace(false);
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document doc = builder.parse(inputStream);

			final DomBigraph bigraph = new DomBigraph(new BasicSignature(), doc);
			return new Bigraph(bigraph);
		}
		catch (final Exception e)
		{
			throw new IOException(e);
		}
	}

}
