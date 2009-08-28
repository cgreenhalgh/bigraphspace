/**
 * 
 */
package bigraphspace.tools;

import bigraphspace.api.ReactiveBigraph;
import bigraphspace.io.IOConstants;
import java.io.File;
import org.apache.log4j.Logger;

/** Read XML bigraph and write BTL bigraph
 * @author cmg
 *
 */
public class Xml2Btl {
	/** logger */
	static Logger logger = Logger.getLogger(Xml2Btl.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=2 && args.length!=3) {
			System.err.println("Usage: "+Xml2Btl.class.getName()+" infile.xml outfile.btl [signature.xml]");
			System.exit(-1);
		}
		try {
			FileUtils.convertFile(args.length>2 ? new File(args[2]) : null, new File(args[0]), IOConstants.FORMAT_XML, new File(args[1]), IOConstants.FORMAT_BTL);
			System.out.println("Converted XML "+args[0]+" to BTL "+args[1]+(args.length>2 ? " with signature "+args[2] : ""));
			
		}
		catch (Exception e) {
			logger.error("Converting XML "+args[0]+" to BTL"+args[1]+(args.length>2 ? " with signature "+args[2] : ""), e);
			System.exit(-1);
		}
	}

}
