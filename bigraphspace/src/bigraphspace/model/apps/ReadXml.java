/**
 * 
 */
package bigraphspace.model.apps;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.File;
import org.apache.log4j.Logger;

import bigraphspace.model.xml.XmlModel;
import bigraphspace.model.xml.XmlUtils;


/** 
 * @author cmg
 *
 */
public class ReadXml {
	/** logger */
	static  Logger logger = Logger.getLogger(ReadXml.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length==0) {
			System.err.println("Usage: "+ReadXml.class.getName()+" <xmlmodelfile> ...");
			System.exit(0);			
		}
		try {
			for (int i=0; i<args.length; i++) {
				File inputFile = new File(args[i]);
				Document doc = XmlUtils.readFile(inputFile);
				logger.info("Read "+inputFile+": "+doc);
				XmlUtils.dump(System.out, doc);
				// no signature
				logger.info("as XmlModel:");
				XmlModel model = new XmlModel(doc, doc.getDocumentElement(), null);
				model.dump(System.out);
			}
		}
		catch (Exception e) {
			logger.error("Reading XML file(s)", e);			
		}
	}

}
