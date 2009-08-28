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

import bigraphspace.model.Match;
import bigraphspace.sorting.Sorting;

import java.io.File;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
/** Test DomMatch. RUn test matches: example test format:
 * <tests>
 * 	<test>
 * 	 <pattern><bigraph.../></pattern>
 *   <target><bigraph.../></target>
 *   <match>
 *    <nodematch pattern="SUPPORT" target="SUPPORT"/>
 *    <linkmatch pattern="LINK" target="LINK"/>
 *   </match>
 *  </test>
 * </tests>
 * 
 * @author cmg
 *
 */
public class RunMatchTests {
	/** lgoger */
	static Logger logger =Logger.getLogger(RunMatchTests.class);
	/** xml constant */
	static final String TEST_ELEMENT_NAME = "test";
	/** xml constant */
	static final String PATTERN_ELEMENT_NAME = "pattern";
	/** xml constant */
	static final String TARGET_ELEMENT_NAME = "target";
	/** xml constant */
	static final String MATCH_ELEMENT_NAME = "match";
	/** xml constant */
	static final String NODEMATCH_ELEMENT_NAME = "nodematch";
	/** xml constant */
	static final String LINKMATCH_ELEMENT_NAME = "linkmatch";
	/** xml constant */
	static final String PATTERN_ATTRIBUTE_NAME = "pattern";
	/** xml constant */
	static final String TARGET_ATTRIBUTE_NAME = "target";
	/** xml constant */
	static final String VARIABLE_ELEMENT_NAME = "variable";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=2) {
			System.err.println("Usage: "+RunMatchTests.class.getName()+" <sig.xml> <match_test.xml>");
			System.exit(0);
		}
		try {
			boolean failed = false;
			logger.info("Read Signature/Sorting from "+args[0]);
			Sorting sorting = Sorting.readSorting(new File(args[0]));
			logger.info("Read tests from "+args[1]);
			Document testDoc = XmlUtils.readFile(new File(args[1]));
			DomMatcher matcher = new DomMatcher();
			NodeList testEls = XmlUtils.getChildElementsByTagName(testDoc.getDocumentElement(),TEST_ELEMENT_NAME);
			if (testEls.getLength()==0)
				logger.warn("No tests found");
			for (int ti=0; ti<testEls.getLength(); ti++) {
				logger.info("Test "+ti);
				Element testEl = (Element)testEls.item(ti);
				Element patternEl = RunTransformerTests.getOnlyBigraphElement(testEl, ti, PATTERN_ELEMENT_NAME); 
				Element targetEl = RunTransformerTests.getOnlyBigraphElement(testEl, ti, TARGET_ELEMENT_NAME); 
				if (patternEl==null || targetEl==null) {
					logger.error("No pattern or target in test "+ti);
					failed = true;
					continue;					
				}
				NodeList matchEls = XmlUtils.getChildElementsByTagName(testEl,MATCH_ELEMENT_NAME);
				
				DomBigraph pattern = new DomBigraph(sorting.getSignature(), testDoc, patternEl);
				DomBigraph target = new DomBigraph(sorting.getSignature(), testDoc, targetEl);
				logger.info("Validate");
				try {
					sorting.validate(pattern);
				} catch (Exception e) {
					pattern.dump(System.out);
					throw e;
				}
				try {
					sorting.validate(target);
				} catch (Exception e) {
					target.dump(System.out);
					throw e;
				}
				logger.info("Try matching");
				List<DomMatch> matches = matcher.match(pattern, target, DomMatcher.UNLIMITED);
				if (matches.size()!=matchEls.getLength()) {
					logger.error("Get "+matches.size()+" matches (expected "+matchEls.getLength()+"):");
					failed = true;
				}
				else
					logger.info("Get "+matches.size()+" matches as expected");
				int mi = 0;
				for (DomMatch match : matches) {
					match.dump(System.out);
					if (mi<matchEls.getLength()) {
						Element matchEl = (Element)matchEls.item(mi++);
						NodeList nodematchEls = XmlUtils.getChildElementsByTagName(matchEl,NODEMATCH_ELEMENT_NAME);
						// remember which matches that were found are ok
						boolean matched [] = new boolean[match.nodeMatches.size()];
						for (int nmi=0; nmi<nodematchEls.getLength(); nmi++) {
							boolean nodematchMatched = false;
							Element nodematchEl = (Element)nodematchEls.item(nmi);
							String patternSupport = nodematchEl.getAttribute(PATTERN_ATTRIBUTE_NAME);
							String targetSupport = nodematchEl.getAttribute(TARGET_ATTRIBUTE_NAME);
							if (patternSupport.equals("")) {
								logger.error("Test "+ti+" nodematch "+nmi+" has no pattern attribute");
								failed = true;
								continue;
							}
							if (targetSupport.equals("")) {
								logger.error("Test "+ti+" nodematch "+nmi+" has no target attribute");
								failed = true;
								continue;
							}

							int mnmi=0;
							for (DomMatch.ElementMatch nodematch : match.nodeMatches) {
								if (patternSupport.equals(nodematch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME)) &&
										targetSupport.equals(nodematch.targetEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME))) {
									nodematchMatched = true;
									matched[mnmi] = true;
									break;
								}
								mnmi++;
							}
							if (!nodematchMatched) {
								logger.error("No match found for "+patternSupport+"->"+targetSupport);
								failed = true;
							}
						}
						int mnmi=0;
						for (DomMatch.ElementMatch nodematch : match.nodeMatches) {
							if (!matched[mnmi]) {
								logger.error("Found erroneous match "+mnmi+": "+nodematch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME)+"->"+nodematch.targetEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME));
								failed = true;
							}					
							else 
								mnmi++;
						}
						// ----------------
						// links 
						NodeList linkmatchEls = XmlUtils.getChildElementsByTagName(matchEl,LINKMATCH_ELEMENT_NAME);
						for (int nmi=0; nmi<linkmatchEls.getLength(); nmi++) {
							boolean linkmatchMatched = false;
							Element linkmatchEl = (Element)linkmatchEls.item(nmi);
							String patternLink = linkmatchEl.getAttribute(PATTERN_ATTRIBUTE_NAME);
							String targetLink = linkmatchEl.getAttribute(TARGET_ATTRIBUTE_NAME);
							if (patternLink.equals("")) {
								logger.error("Test "+ti+" linkmatch "+nmi+" has no pattern attribute");
								failed = true;
								continue;
							}
							if (targetLink.equals("")) {
								logger.error("Test "+ti+" linkmatch "+nmi+" has no target attribute");
								failed = true;
								continue;
							}

							for (DomMatch.LinkMatch linkmatch : match.linkMatches) {
								if (linkmatch.patternLinks.contains(patternLink) && 
										linkmatch.targetLink.equals(targetLink)) {
									linkmatchMatched = true;
									break;
								}
							}
							if (!linkmatchMatched) {
								logger.error("No link match found for "+patternLink+"->"+targetLink);
								failed = true;
							}
						}
						// check the other way
						for (DomMatch.LinkMatch linkmatch : match.linkMatches) {
							for (String foundPatternLink : linkmatch.patternLinks) {
								boolean linkmatchMatched = false;
								for (int nmi=0; nmi<linkmatchEls.getLength() && !linkmatchMatched; nmi++) {
									Element linkmatchEl = (Element)linkmatchEls.item(nmi);
									String patternLink = linkmatchEl.getAttribute(PATTERN_ATTRIBUTE_NAME);
									String targetLink = linkmatchEl.getAttribute(TARGET_ATTRIBUTE_NAME);
									if (linkmatch.targetLink.equals(targetLink) && foundPatternLink.equals(patternLink))
										linkmatchMatched = true;
								}
								if (!linkmatchMatched) {
									logger.error("Found incorrect link "+foundPatternLink+"->"+linkmatch.targetLink);
									failed = true;
								}
							}
						}
						// ----------------
						// variables 
						LinkedList<String> variableNames = new LinkedList<String>();
						for (Map.Entry<String,Object> variableValue: match.getVariableValues().entrySet()) {
							variableNames.add(variableValue.getKey());
						}
						NodeList variableEls = XmlUtils.getChildElementsByTagName(matchEl,VARIABLE_ELEMENT_NAME);
						for (int nmi=0; nmi<variableEls.getLength(); nmi++) {
							boolean variableMatched = false;
							Element variableEl = (Element)variableEls.item(nmi);
							String patternName = variableEl.getAttribute(PATTERN_ATTRIBUTE_NAME);
							String targetValue = variableEl.getAttribute(TARGET_ATTRIBUTE_NAME);
							if (patternName.equals("")) {
								logger.error("Test "+ti+" variable "+nmi+" has no pattern attribute");
								failed = true;
								continue;
							}
							if (targetValue.equals("")) {
								logger.error("Test "+ti+" variable "+nmi+" has no target attribute");
								failed = true;
								continue;
							}
							if (!targetValue.equals(match.getVariableValues().get(patternName)))
							{
								logger.error("No/incorrect value for variable "+patternName+": "+match.getVariableValues().get(patternName)+" vs "+targetValue);
								failed = true;
							}
							variableNames.remove(patternName);
						}
						for (String variableName : variableNames) {
							logger.warn("No test specified for variable "+variableName+", value "+match.getVariableValues().get(variableName));
						}
					}
					else {
						logger.error("No match to check against");
						failed = true;
					}
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
		}
		
	}

}
