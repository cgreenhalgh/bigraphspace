/**
 * 
 */
package bigraphspace.model.xml;

import bigraphspace.io.BigraphReader;
import bigraphspace.io.BigraphWriter;
import bigraphspace.io.IOConstants;
import bigraphspace.io.IOFactory;
import bigraphspace.io.UnsupportedFormatException;
import bigraphspace.model.BasicSignature;

/** XML Bigraph implementation of IOFactory methods.
 * 
 * @author cmg
 *
 */
public class XmlIOFactory {

	/* (non-Javadoc)
	 * @see bigraphspace.io.IOFactory#getReader()
	 */
	//@Override
	public static BigraphReader getReader(BasicSignature signature)  throws UnsupportedFormatException{
		return getReader(IOConstants.FORMAT_XML, signature);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.io.IOFactory#getReader(java.lang.String)
	 */
	//@Override
	public static BigraphReader getReader(String format, BasicSignature signature) throws UnsupportedFormatException {
		if (IOConstants.FORMAT_XML.equals(format))
			return new DomXmlBigraphReader(signature);
		if (IOConstants.FORMAT_BTL.equals(format))
			return new DomBtlBigraphReader(signature);
		throw new UnsupportedFormatException("BigraphReader for '"+format+"'");
	}

	/* (non-Javadoc)
	 * @see bigraphspace.io.IOFactory#getWriter()
	 */
	//@Override
	public static BigraphWriter getWriter()  throws UnsupportedFormatException{
		// TODO Auto-generated method stub
		return getWriter(IOConstants.FORMAT_XML);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.io.IOFactory#getWriter(java.lang.String)
	 */
	//@Override
	public static BigraphWriter getWriter(String format)  throws UnsupportedFormatException{
		if (IOConstants.FORMAT_XML.equals(format))
			return new DomXmlBigraphWriter();
		if (IOConstants.FORMAT_BTL.equals(format))
			return new DomBtlBigraphWriter();
		throw new UnsupportedFormatException("BigraphWriter for '"+format+"'");
	}

}
