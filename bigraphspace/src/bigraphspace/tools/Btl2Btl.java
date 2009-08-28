/**
 * 
 */
package bigraphspace.tools;

import bigraphspace.api.ReactiveBigraph;
import bigraphspace.io.IOConstants;
import java.io.File;
import org.apache.log4j.Logger;

/** Read BTL bigraph and write Btl bigraph
 * @author cmg
 *
 */
public class Btl2Btl {
	/** logger */
	static Logger logger = Logger.getLogger(Btl2Btl.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=2 && args.length!=3) {
			System.err.println("Usage: "+Btl2Btl.class.getName()+" infile.btl outfile.btl [signature.xml]");
			System.exit(-1);
		}
		try {
			FileUtils.convertFile(args.length>2 ? new File(args[2]) : null, new File(args[0]), IOConstants.FORMAT_BTL, new File(args[1]), IOConstants.FORMAT_BTL);
			System.out.println("Converted BTL "+args[0]+" to BTL "+args[1]+(args.length>2 ? " with signature "+args[2] : ""));
			
		}
		catch (Exception e) {
			logger.error("Converting BTL "+args[0]+" to BTL "+args[1]+(args.length>2 ? " with signature "+args[2] : ""), e);
			System.exit(-1);
		}
	}

}
