/**
 * 
 */
package bigraphspace.model.signaturexml;

import java.io.File;

import bigraphspace.model.BasicSignature;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;

import bigraphspace.model.signaturexml.SignatureFactory;
import bigraphspace.model.signaturexml.TestRead;

/** Test reading of signature.xsd XML using JAXB.
 * 
 * @author cmg
 *
 */
public class TestRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length==0) 
		{
			System.err.println("Usage: "+TestRead.class.getName()+" <sigxmlfile> ...");
			System.exit(0);
		}
        try {
            for (int i=0; i<args.length; i++) {
            	System.out.println("Read "+args[i]);
            	BasicSignature sig = SignatureFactory.readSignature(new File(args[i]));
            	System.out.println("Built signature with "+sig.getControls().size()+" controls:");
            	for (bigraphspace.model.Control control : sig.getControls())
            		System.out.println("  "+control.getName()+", "+control.getStatus()+", arity "+control.getArity());
            }
        } catch (Exception e) {
        	System.err.println("Error: "+e);
        	e.printStackTrace(System.err);
        }
	}

}
