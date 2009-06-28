/**
 * 
 */
package bigraphspace.model.xml;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import bigraphspace.api.BigraphChangedEvent;
import bigraphspace.api.BigraphChangedListener;
import bigraphspace.api.BigraphSession;
import bigraphspace.api.ReactionRule;
import bigraphspace.api.ReactiveBigraph;
import bigraphspace.api.RuleCondition;
import bigraphspace.api.RuleFiredEvent;
import bigraphspace.api.RuleFiredListener;
import bigraphspace.model.Bigraph;
import bigraphspace.sorting.Sorting;

/** Tests of DomReactiveBigraph.
 * <tests>
 *  <test>
 *   <condition minOccurs="N" maxOccurs="N" isActiveContext="true">
 *    <bigraph>...</bigraph>
 *   </condition>
 *   ...
 *   <redex minOccurs="N" maxOccurs="N" isActiveContext="true">
 *    <bigraph>...</bigraph>
 *   <reactum><bigraph>...</bigraph></reactum>
 *   <target><bigraph>...</bigraph></target>
 *   <result><bigraph>...</bigraph></result>
 *  </test>
 * </tests>
 * 
 * @author cmg
 *
 */
public class RunReactiveBigraphTests {
	/** lgoger */
	static Logger logger =Logger.getLogger(RunReactiveBigraphTests.class);
	/** xml constant */
	static final String TEST_ELEMENT_NAME = "test";
	/** xml constant */
	static final String RULE_ELEMENT_NAME = "rule";
	/** xml constant */
	static final String CONDITION_ELEMENT_NAME = "condition";
	/** xml constant */
	static final String MIN_OCCURS_ATTRIBUTE_NAME = "minOccurs";
	/** xml constant */
	static final String MAX_OCCURS_ATTRIBUTE_NAME = "maxOccurs";
	/** xml constant */
	static final String IS_ACTIVE_CONTEXT_ATTRIBUTE_NAME = "isActiveContext";
	/** xml constant */
	static final String REDEX_ELEMENT_NAME = "redex";
	/** xml constant */
	static final String REACTUM_ELEMENT_NAME = "reactum";
	/** xml constant */
	static final String TARGET_ELEMENT_NAME = "target";
	/** xml constant */
	static final String RESULT_ELEMENT_NAME = "result";

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
			nexttest:
			for (int ti=0; ti<testEls.getLength(); ti++) {
				logger.info("Test "+ti);
				
				ReactiveBigraph reactiveBigraph = new DomReactiveBigraph(sorting.getSignature());
				
				Element testEl = (Element)testEls.item(ti);
				NodeList ruleEls = testEl.getElementsByTagName(RULE_ELEMENT_NAME);
				for (int ri=0; ri<ruleEls.getLength(); ri++) {
					Element ruleEl = (Element)ruleEls.item(ri);
					NodeList conditionEls = ruleEl.getElementsByTagName(CONDITION_ELEMENT_NAME);
					Element redexConditionEl = RunTransformerTests.getOnlyElement(ruleEl, ti, REDEX_ELEMENT_NAME);
					Element redexEl = RunTransformerTests.getOnlyBigraphElement(ruleEl, ti, REDEX_ELEMENT_NAME);
					Element reactumEl = RunTransformerTests.getOnlyBigraphElement(ruleEl, ti, REACTUM_ELEMENT_NAME);
					if (redexConditionEl==null || redexEl==null || reactumEl==null) {
						failed = true;
						continue nexttest;					
					}
					ReactionRule rule = new ReactionRule();
					DomBigraph redex = new DomBigraph(sorting.getSignature(), testDoc, redexEl);
					RuleCondition redexCondition = new RuleCondition();
					rule.setRedex(redexCondition);
					redexCondition.setPattern(redex);
					if (!readConditionAttributes(redexCondition, redexConditionEl)) {
						failed = true;
						continue nexttest; 
					}
					DomBigraph reactum = new DomBigraph(sorting.getSignature(), testDoc, reactumEl);
					rule.setReactum(reactum);
					
					for (int ci=0; ci<conditionEls.getLength(); ci++) {
						Element conditionEl = (Element)conditionEls.item(ci);
						Element patternEl = RunTransformerTests.getOnlyElement(conditionEl, ti, Constants.BIGRAPH_ELEMENT_NAME);
						if (patternEl==null) {
							logger.warn("In condition "+ci);
							failed = true;
							continue nexttest;
						}
						DomBigraph pattern = new DomBigraph(sorting.getSignature(), testDoc, patternEl);
						RuleCondition precondition = new RuleCondition();
						precondition.setPattern(pattern);
						if (!readConditionAttributes(precondition, conditionEl)) {
							failed = true;
							continue nexttest; 
						}
						rule.getPreconditions().add(precondition);
					}
					rule.addRuleFiredListener(new RuleFiredListener() {

						/* (non-Javadoc)
						 * @see bigraphspace.api.RuleFiredListener#ruleFired(bigraphspace.api.RuleFiredEvent, bigraphspace.api.BigraphSession)
						 */
						@Override
						public void ruleFired(RuleFiredEvent rfe,
								BigraphSession ruleSession) {
							// TODO Auto-generated method stub
							logger.debug("Rule fired");
							if (ruleSession!=null)
							{
								Bigraph bigraph = ruleSession.getAll();
								bigraph.dump(System.out);
							}
						}
						
					});
					
					reactiveBigraph.addReactionRule(rule);
				}
				
				Element targetEl = RunTransformerTests.getOnlyBigraphElement(testEl, ti, TARGET_ELEMENT_NAME);
				Element resultEl = RunTransformerTests.getOnlyBigraphElement(testEl, ti, RESULT_ELEMENT_NAME);
				if (targetEl==null || resultEl==null) {
					failed = true;
					continue;					
				}
				DomBigraph target = new DomBigraph(sorting.getSignature(), testDoc, targetEl);
				DomBigraph intendedResult = new DomBigraph(sorting.getSignature(), testDoc, resultEl);

				reactiveBigraph.addBigraphChangedListener(new BigraphChangedListener() {

					/* (non-Javadoc)
					 * @see bigraphspace.api.BigraphChangedListener#bigraphChanged(bigraphspace.api.BigraphChangedEvent)
					 */
					@Override
					public void bigraphChanged(BigraphChangedEvent bce) {
						// TODO Auto-generated method stub
						logger.debug("Bigraph changed");
					}
					
				});
				logger.info("Set initial value...");
				target.dump(System.out);
				BigraphSession session = reactiveBigraph.getSession();
				session.begin();
				session.setAll(target);
				session.end();
				logger.info("waiting...");
				
				Thread.sleep(1000);
				
				logger.info("Check value");
				session.begin(BigraphSession.Mode.readonly);
				Bigraph result = session.getAll();
				session.end();
				result.dump(System.out);
				
				// see if it matches the result. Have to try them all 
				// as we would like to check support(s) aswell
				// which are not matched for, so they may be wrong, but it is a start
				
				List<DomMatch> resultMatches = matcher.match(intendedResult, (DomBigraph) result, 0);
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
				
				reactiveBigraph.stopCallbacks();
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
	/** read condition attributes */
	static boolean readConditionAttributes(RuleCondition condition, Element conditionEl) {
		if (conditionEl.getAttribute(MIN_OCCURS_ATTRIBUTE_NAME).length()>0) {
			try {
				condition.setMinOccurs(Integer.parseInt(conditionEl.getAttribute(MIN_OCCURS_ATTRIBUTE_NAME)));				
			}
			catch (NumberFormatException e) {
				logger.error("in minOccurs="+conditionEl.getAttribute(MIN_OCCURS_ATTRIBUTE_NAME));
				return false;				
			}
		}
		if (conditionEl.getAttribute(MAX_OCCURS_ATTRIBUTE_NAME).length()>0) {
			try {
				condition.setMaxOccurs(Integer.parseInt(conditionEl.getAttribute(MAX_OCCURS_ATTRIBUTE_NAME)));	
				if (condition.getMaxOccurs()==0 && !conditionEl.hasAttribute(MIN_OCCURS_ATTRIBUTE_NAME))
					// default to 0
					condition.setMinOccurs(0);
			}
			catch (NumberFormatException e) {
				logger.error("in minOccurs="+conditionEl.getAttribute(MAX_OCCURS_ATTRIBUTE_NAME));
				return false;				
			}
		}
		if (conditionEl.getAttribute(IS_ACTIVE_CONTEXT_ATTRIBUTE_NAME).length()>0) {
			char c = conditionEl.getAttribute(MIN_OCCURS_ATTRIBUTE_NAME).charAt(0);
			if (c=='t' || c=='T' || c=='1' || c=='y' || c=='Y')
				condition.setActiveContext(true);
		}
		return true;
	}
}
