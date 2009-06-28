/**
 * 
 */
package bigraphspace.model.signaturexml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import bigraphspace.model.BasicSignature;

import bigraphspace.model.signaturexml.DefinitionException;
import bigraphspace.model.signaturexml.Definitions;

/** SignatureXML utilities.
 * 
 * @author cmg
 *
 */
public class Utils {
	/** read Definitions (JAXB) from signature XML file */
	public static Definitions readDefinitions(File file) throws JAXBException, FileNotFoundException, DefinitionException {
        // create a JAXBContext capable of handling classes 
		JAXBContext jc = JAXBContext.newInstance( "bigraphspace.model.signaturexml" );

		// create an Unmarshaller
		Unmarshaller u = jc.createUnmarshaller();

		// unmarshal an instance document into a tree of Java content
		// objects composed of classes from the package.
		JAXBElement<?> element = (JAXBElement<?>)u.unmarshal( new FileInputStream( file ) );
		Definitions defs = (Definitions)element.getValue();
		return defs;
	}

}
