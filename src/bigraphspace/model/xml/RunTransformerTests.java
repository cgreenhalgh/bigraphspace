/**
 * 
 */
package bigraphspace.model.xml;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import bigraphspace.model.xml.DomBigraph;
import bigraphspace.model.xml.DomMatch;
import bigraphspace.model.xml.DomMatcher;
import bigraphspace.model.xml.XmlUtils;
import bigraphspace.sorting.Sorting;

import java.io.File;
import java.util.List;
/** Test DomTransformer. RUn test matches: example test format:
 * <tests>
 * 	<test>
 * 	 <redex><bigraph.../></redex>
 * 	 <reactum><bigraph.../></reactum>
 *   <target><bigraph.../></target>
 *   <result><bigraph.../></result>
 *  </test>
 * </tests>
 * 
 * @author cmg
 *
 */
public class RunTransformerTests {
	/** lgoger */
	static Logger logger =Logger.getLogger(RunMatchTests.class);
	/** xml constant */
	static final String TEST_ELEMENT_NAME = "test";
	/** xml constant */
	static final String REDEX_ELEMENT_NAME = "redex";
	/** xml constant */
	static final String REACTUM_ELEMENT_NAME = "reactum";
	/** xml constant */
	static final String TARGET_ELEMENT_NAME = "target";
	/** xml constant */
	static final String RESULT_ELEMENT_NAME = "result";
	/**
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=2) {
			System.err.println("Usage: "+RunTransformerTests.class.getName()+" <sig.xml> <transformer_test.xml>");
			System.exit(0);
		}
		try {
			boolean failed = false;
			logger.info("Read Signature/Sorting from "+args[0]);
			Sorting sorting = Sorting.readSorting(new File(args[0]));
			logger.info("Read tests from "+args[1]);
			Document testDoc = XmlUtils.readFile(new File(args[1]));
			DomMatcher matcher = new DomMatcher();
			DomTransformer transformer = new DomTransformer();
			NodeList testEls = testDoc.getDocumentElement().getElementsByTagName(TEST_ELEMENT_NAME);
			if (testEls.getLength()==0)
				logger.warn("No tests found");
			for (int ti=0; ti<testEls.getLength(); ti++) {
				logger.info("Test "+ti);
				Element testEl = (Element)testEls.item(ti);
				Element redexEl = getOnlyBigraphElement(testEl, ti, REDEX_ELEMENT_NAME);
				Element reactumEl = getOnlyBigraphElement(testEl, ti, REACTUM_ELEMENT_NAME);
				Element targetEl = getOnlyBigraphElement(testEl, ti, TARGET_ELEMENT_NAME);
				Element resultEl = getOnlyBigraphElement(testEl, ti, RESULT_ELEMENT_NAME);
				if (redexEl==null || reactumEl==null || targetEl==null || resultEl==null) {
					failed = true;
					continue;					
				}

				DomBigraph redex = new DomBigraph(sorting.getSignature(), testDoc, redexEl);
				DomBigraph reactum = new DomBigraph(sorting.getSignature(), testDoc, reactumEl);
				DomBigraph target = new DomBigraph(sorting.getSignature(), testDoc, targetEl);
				DomBigraph intendedResult = new DomBigraph(sorting.getSignature(), testDoc, resultEl);

				logger.info("Try match");
				List<DomMatch> matches = matcher.match(redex, target, DomMatcher.UNLIMITED);
				if (matches.size()==0) {
					logger.error("No match");
					failed = true;
					continue;
				}
				if (matches.size()>1) {
					logger.warn("Found "+matches.size()+" matches; using first");
				}
				DomMatch match = matches.get(0);
				match.dump(System.out);
				
				logger.info("Try transform");
				DomBigraph result = transformer.transform(match, reactum);
				logger.info("=>");
				result.dump(System.out);
				
				// see if it matches the result. Have to try them all 
				// as we would like to check support(s) aswell
				// which are not matched for, so they may be wrong, but it is a start
				List<DomMatch> resultMatches = matcher.match(intendedResult, result, 0);
				if (resultMatches.size()==0) {
					logger.error("No match with intended result");
					failed = true;
				}
				else
					logger.info("Found "+resultMatches.size()+" possible matches; checking support");
				boolean succeeded = false;
				String anySupportError = null;
				for (DomMatch resultMatch : resultMatches) {
					// check support correspondence
					String supportError = null;
					for (DomMatch.ElementMatch nodeMatch : resultMatch.getNodeMatches()) {
						if (!nodeMatch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME).equals(nodeMatch.targetEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME))) {
							supportError = "Support mismatch, e.g. "+nodeMatch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME)+" vs "+nodeMatch.targetEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME);
						}
					}
					if (supportError==null)
					{
						succeeded = true;
						logger.info("OK!");
						break;
					}
					else
						anySupportError = supportError;
				}
				if (!succeeded) {
					logger.error(anySupportError);
					failed = true;
				}
			}
			if(failed) 
			{
				logger.error("Failed");
				System.exit(-1);
			}
		}
		catch (Exception e) {
			logger.error("Error", e);
			System.exit(-1);
		}
		
	}
	/** helper */
	static Element getOnlyBigraphElement(Element testEl, int ti, String name) {
		if (testEl==null)
			return null;
		NodeList redexEls = testEl.getElementsByTagName(name);
		if (redexEls.getLength()==0) {
			logger.error("No "+name+"+ in test "+ti);
			return null;					
		}
		Element redexEl = (Element)redexEls.item(0);
		if (redexEls.getLength()>1)
			logger.warn(redexEls.getLength()+" "+name+" in test "+ti+"; using first only");
		NodeList bigraphEls = redexEl.getElementsByTagName(Constants.BIGRAPH_ELEMENT_NAME);
		if (bigraphEls.getLength()==0) {
			logger.error("No bigraph in "+name+"+ in test "+ti);
			return null;					
		}
		Element bigraphEl = (Element)bigraphEls.item(0);
		if (bigraphEls.getLength()>1)
			logger.warn(bigraphEls.getLength()+" bigraphs in "+name+" in test "+ti+"; using first only");
		return bigraphEl;
	}

	/** helper */
	static Element getOnlyElement(Element testEl, int ti, String name) {
		if (testEl==null)
			return null;
		NodeList redexEls = testEl.getElementsByTagName(name);
		if (redexEls.getLength()==0) {
			logger.error("No "+name+"+ in test "+ti);
			return null;					
		}
		Element redexEl = (Element)redexEls.item(0);
		if (redexEls.getLength()>1)
			logger.warn(redexEls.getLength()+" "+name+" in test "+ti+"; using first only");
		return redexEl;
	}

}
