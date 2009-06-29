/**
 * 
 */
package bigraphspace.model.xml;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import bigraphspace.model.Match;
import bigraphspace.model.xml.DomBigraph;
import bigraphspace.model.xml.DomMatch;
import bigraphspace.model.xml.DomMatcher;
import bigraphspace.model.xml.XmlUtils;
import bigraphspace.sorting.Sorting;

import java.io.File;
import java.util.List;
/** Test DomMatch
 * @author cmg
 *
 */
public class TestMatch {
	/** lgoger */
	static Logger logger =Logger.getLogger(TestMatch.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=3) {
			System.err.println("Usage: "+TestMatch.class.getName()+" <sig.xml> <pattern.xml> <target.xml>");
			System.exit(0);
		}
		try {
			logger.info("Read Signature/Sorting from "+args[0]);
			Sorting sorting = Sorting.readSorting(new File(args[0]));
			logger.info("Read pattern from "+args[1]);
			Document patternDoc = XmlUtils.readFile(new File(args[1]));
			DomBigraph pattern = new DomBigraph(sorting.getSignature(), patternDoc);
			logger.info("Read target from "+args[1]);
			Document targetDoc = XmlUtils.readFile(new File(args[2]));
			DomBigraph target = new DomBigraph(sorting.getSignature(), targetDoc);
			logger.info("Try matching");
			DomMatcher matcher = new DomMatcher();
			List<DomMatch> matches = matcher.match(pattern, target, DomMatcher.UNLIMITED);
			logger.info("Get "+matches.size()+" matches:");
			for (DomMatch match : matches) {
				match.dump(System.out);
			}
			// TODO
		}
		catch (Exception e) {
			logger.error("Error", e);
		}
		// TODO Auto-generated method stub

	}

}
