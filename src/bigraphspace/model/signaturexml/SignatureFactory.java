/**
 * 
 */
package bigraphspace.model.signaturexml;

import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.DefinitionException;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Port;
import bigraphspace.model.signaturexml.SignatureFactory;
import bigraphspace.model.signaturexml.Utils;

import org.apache.log4j.Logger;

import bigraphspace.model.BasicSignature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/** Create signature from signature XML.
 * @author cmg
 *
 */
public class SignatureFactory {
	/** logger */
	static Logger logger = Logger.getLogger(SignatureFactory.class);
	/** read signature from signature XML file */
	public static BasicSignature readSignature(File file) throws JAXBException, FileNotFoundException, DefinitionException {
		Definitions defs = Utils.readDefinitions(file);
		return SignatureFactory.createSignature(defs);
	}
	/** Create signature from signature XML. */
	public static BasicSignature createSignature(Definitions xdefinitions) throws DefinitionException {
		BasicSignature bs = new BasicSignature();
		for (Control xcontrol : xdefinitions.controls.getControl()) {
			bigraphspace.model.Control control = new bigraphspace.model.Control();
			if (xcontrol.getName()==null)
				throw new DefinitionException("<control> with no name attribute");
			control.setName(xcontrol.getName());
			control.setDescription(xcontrol.getDescription());
			List<Port> xports = xcontrol.getPort();
			if (xcontrol.getArity()!=null) {
				if (xports==null || xports.size()==0)
					// ok
					control.setArity(xcontrol.getArity());
				else if (xports.size()<xcontrol.getArity()) {
					logger.warn("Control "+xcontrol.getName()+" has only "+xports.size()+" of "+xcontrol.getArity()+" ports specified explicitly");
					control.setArity(xcontrol.getArity());					
				} 
				else {
					if (xports.size()>xcontrol.getArity() && xcontrol.getArity()!=0)
						logger.warn("Control "+xcontrol.getName()+" has "+xports.size()+" explicit ports; overriding arity "+xcontrol.getArity());
					control.setArity(xports.size());
				}
			}
			else if (xports!=null && xports.size()>0){
				control.setArity(xports.size());				
			}
			else {
				//logger.warn("Read control "+xcontrol.getName()+" with no arity and no explicit ports specified");
			}
			if (xcontrol.getStatus()!=null) 
				control.setStatus(bigraphspace.model.Control.Status.valueOf(xcontrol.getStatus()));
			else
				// default to active
				control.setStatus(bigraphspace.model.Control.Status.active);
			// port names
			String portNames [] = new String[control.getArity()];
			for (int pi=0; pi<portNames.length; pi++) {
				if (xports!=null && pi<xports.size())
					portNames[pi] = xports.get(pi).getName();
				if (portNames[pi]==null)
					portNames[pi] = bigraphspace.model.Port.DEFAULT_PORT_NAME_PREFIX+pi;				
			}
			control.setPortNames(portNames);
			// done
			bs.getControls().add(control);
		}
		return bs;
	}
}
