/**
 * 
 */
package bigraphspace.model.xml;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

/** Transform a (DOM) Bigraph by taking a (Dom) Match with a Redex and rewriting with the 
 * given reactum.
 * 
 * @author cmg
 *
 */
public class DomTransformer {
	static Logger logger = Logger.getLogger(DomTransformer.class);
	/** cons */
	public DomTransformer() {		
	}
	/** transform - this version returns a new/independent result bigraph without changing the redex/target/reactum */
	public DomBigraph transform(DomMatch match, DomBigraph reactum) throws ParserConfigurationException, TransformException {
		DomBigraph target = match.getDomTarget();
		DomBigraph result = new DomBigraph(match.getDomTarget().getSignature());
		DomBigraph redex = match.getDomPattern();
		if (redex.getRoots().size()!=reactum.getRoots().size())
			throw new TransformException("Redex has "+redex.getRoots().size()+" roots, reactum has "+reactum.getRoots().size());
		if (redex.getRoots().size()==0) {
			// no op
			logger.warn("transform for rule with no roots");
			return target;
		}
		// we build the result by:
		// - copying nodes "above" the match to the result
		// - adding the nodes in the reactum subject to the same mapping of links as derived for the redex
		// - copying the subtrees matched by the sites into redex into the place(s) in the result 
		//   corresponding to the sites in the reactum,
		//   performing link renaming in subtrees according to any inner name mapping.
		
		// the roots of the result are the same as the roots of the target
		NodeList rootEls = XmlUtils.getChildElementsByTagName(target.getBigraphElement(),Constants.ROOT_ELEMENT_NAME);
		// new links (reactum name -> new name to use)
		HashMap<String,String> newLinks = new HashMap<String,String>();
		// the inner name mapping should be of the name in the target to the (new) name in the target
		Map<String,String> reactumInnerNameMap = reactum.getInnerNameMap();
		HashMap<String,String> innerNameMap = new HashMap<String,String>();
		for (Map.Entry<String, String> e : reactumInnerNameMap.entrySet()) {
			innerNameMap.put(mapLink(match, e.getKey(), e.getKey()), mapLink(match, e.getValue(), e.getKey()));
		}
		for (int ri=0; ri<rootEls.getLength(); ri++) 
		{
			result.getBigraphElement().appendChild(copyThenTransform(match, reactum, result, newLinks, innerNameMap, (Element)rootEls.item(ri)));
		}
		
		return result;
	}
	/** map link */
	String mapLink(DomMatch match, String value, String defaultPrefix) {
		if (value==null || value=="")
			return newLinkName(defaultPrefix);
		if (DomMatcher.linkIsConstant(value))
			return value;
		for (DomMatch.LinkMatch linkMatch : match.linkMatches) {
			if (linkMatch.patternLinks.contains(value)) {
				return linkMatch.targetLink;
			}
		}
		logger.warn("No mapping found for link "+value);
		return value;
	}
	/** copying up to root match, then transform, recurse */
	Element copyThenTransform(DomMatch match, DomBigraph reactum, DomBigraph result, HashMap<String,String> newLinks, HashMap<String,String> innerNameMap, Element targetEl) throws TransformException {
		for (DomMatch.ElementMatch rootMatch : match.rootMatches) {
			if (rootMatch.targetEl==targetEl) {
				return transformRoot(match, reactum, result, newLinks, innerNameMap, rootMatch);
			}
		}
		// still here -> trivial copy
		Element resultEl = (Element)result.getDocument().importNode(targetEl, false);
		// trivial recurse
		NodeList children = targetEl.getChildNodes();
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (child instanceof Element) {
				Element resultChild = copyThenTransform(match, reactum, result, newLinks, innerNameMap, (Element)child);
				if (resultChild!=null)
					resultEl.appendChild(resultChild);
			}
		}
		return resultEl;
	}
	/** (start) transform node matched by redex */
	Element transformRoot(DomMatch match, DomBigraph reactum, DomBigraph result, HashMap<String,String> newLinks, HashMap<String,String> innerNameMap, DomMatch.ElementMatch rootMatch) throws TransformException {
		// the root match node itself is ok
		// still here -> trivial copy
		Element resultEl = (Element)result.getDocument().importNode(rootMatch.targetEl, false);
		NodeList children = rootMatch.targetEl.getChildNodes();
		nextchild:
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (!(child instanceof Element))
				continue;
			// copy any unmatched child trees (non-site and non-node matches)
			for (DomMatch.ElementMatch nodeMatch : match.nodeMatches)
				if (nodeMatch.targetEl==child)
					continue nextchild;
			for (DomMatch.ElementsMatch siteMatch : match.siteMatches)
				for (Element siteEl : siteMatch.targetEls)
					if (siteEl==child)
						continue nextchild;
			resultEl.appendChild(copyThenTransform(match, reactum, result, newLinks, innerNameMap, (Element)child));
		}
		// now put in the stuff in the corresponding reactum root...
		NodeList reactumRoots = XmlUtils.getChildElementsByTagName(reactum.getBigraphElement(),Constants.ROOT_ELEMENT_NAME);
		Element reactumRootEl = (Element)reactumRoots.item(rootMatch.index);
		// insert children of root, substituting sites with matched subtrees
		insertMappedChildren(match, reactum, result, newLinks, innerNameMap, resultEl, reactumRootEl);
		return resultEl;
	}
	/** insert children of reactum node into result with mapping (and site replacement) */
	void insertMappedChildren(DomMatch match, DomBigraph reactum, DomBigraph result, HashMap<String,String> newLinks, HashMap<String,String> innerNameMap, Element resultEl, Element reactumEl) throws TransformException {
		NodeList reactumChildren = reactumEl.getChildNodes();
		for (int rci=0; rci<reactumChildren.getLength(); rci++) {
			Node reactumChild = reactumChildren.item(rci);
			if (!(reactumChild instanceof Element))
				continue;
			Element reactumChildEl = (Element)reactumChild;
			if (Constants.SITE_ELEMENT_NAME.equals(reactumChild.getNodeName())) {
				// map site.
				// insert subtree rooted at each node matched by site, remapping attribute values according to reactum innerNameMap
				// corresponding site in redex...
				String index = reactumChildEl.getAttribute(Constants.SITE_INDEX_ATTRIBUTE_NAME);
				DomMatch.ElementsMatch bestSiteMatch = null;
				for (DomMatch.ElementsMatch siteMatch : match.siteMatches) {
					if (siteMatch.patternEl.getAttribute(Constants.SITE_INDEX_ATTRIBUTE_NAME).equals(index))
					{
						bestSiteMatch = siteMatch;
						break;
					}
				}
				if (bestSiteMatch==null) {
					throw new TransformException("Could not find site index '"+index+"' in redex");
				}
				for (Element targetEl : bestSiteMatch.targetEls) {
					resultEl.appendChild(mapSiteNode(result, newLinks, innerNameMap, targetEl));
				}
			}
			else 
			{
				// map node
				Element resultChildEl = result.getDocument().createElement(reactumChildEl.getNodeName());
				resultEl.appendChild(resultChildEl);
				// TODO map attributes
				NamedNodeMap reactumAttributes = reactumChildEl.getAttributes();
				nextattribute:
				for (int rai=0; rai<reactumAttributes.getLength(); rai++) {
					Attr reactumAttribute = (Attr)reactumAttributes.item(rai);
					String portName = reactumAttribute.getName();
					String value = reactumAttribute.getValue();
					logger.debug("Map reactum node "+reactumChildEl+" port "+portName+"="+value);
					// map support
					if (Constants.NODE_SUPPORT_ATTRIBUTE_NAME.equals(portName)) {
						if (value==null || value.length()==0)
							// no op
							continue;
						// should be same support as corresponding node in reactum
						boolean found = false;
						for (DomMatch.ElementMatch nodeMatch : match.nodeMatches) {
							if (value.equals(nodeMatch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME))) {
								// match
								String support = nodeMatch.targetEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME);
								if (support!=null && support.length()>0)
									resultChildEl.setAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME, support);
								// copy any link values which are in redex target but null in reactum and redex to target as defaults
								NamedNodeMap redexTargetAttributes = nodeMatch.targetEl.getAttributes();
								for (int rtai=0; rtai<redexTargetAttributes.getLength(); rtai++) {
									Attr redexTargetAttribute = (Attr)redexTargetAttributes.item(rtai);
									String rtPortName = redexTargetAttribute.getName();
									if (Constants.NODE_SUPPORT_ATTRIBUTE_NAME.equals(rtPortName))
										continue;
									String rtValue = redexTargetAttribute.getValue();
									if (rtValue.length()==0)
										continue;
									if (!reactumChildEl.hasAttribute(rtPortName) && !nodeMatch.patternEl.hasAttribute(rtPortName) && !resultChildEl.hasAttribute(rtPortName)) {
										// map default
										resultChildEl.setAttribute(rtPortName, rtValue);
										logger.debug("Map default port value "+rtPortName+"="+rtValue);
									}
								}
								found = true;
								break;
							}
						}
						if (!found)
							logger.warn("Reactum support "+value+" not found in redex");
						continue;
					}
					// empty -> Leave alone (default(s) may be copied on support match)
					if (value==null || value.length()==0) {
						continue;
					}
					// constant 
					if (DomMatcher.linkIsConstant(value)) {
						resultChildEl.setAttribute(portName, value);
						continue;
					}
					// variable - use link mapping
					for (DomMatch.LinkMatch linkMatch : match.linkMatches) {
						if (linkMatch.patternLinks.contains(value)) {
							resultChildEl.setAttribute(portName, linkMatch.targetLink);
							continue nextattribute;
						}
					}
					// unknown variable mapping -> new name
					// (note that inner name map may put mapping(s) in here for other (known) links)
					String newValue = newLinks.get(value);
					if (newValue!=null)
					{
						resultChildEl.setAttribute(portName, newValue);
						continue;
					}
					newValue = newLinkName(value);
					newLinks.put(value, newValue);
					resultChildEl.setAttribute(portName, newValue);					
				} // attributes
				
				// children of node? - recurse
				insertMappedChildren(match, reactum, result, newLinks, innerNameMap, resultChildEl, reactumChildEl);
			}
		}
	}
	static int newLinkIndex = 0;
	/** new link name */
	String newLinkName(String oldValue) {
		synchronized (DomTransformer.class) {
			// not globally unique but hey-ho
			return oldValue+":"+(newLinkIndex++)+":"+System.currentTimeMillis();
		}
	}
	/** copy/map site node(s) with inner name map */
	Element mapSiteNode(DomBigraph result, HashMap<String,String> newLinkMap, Map<String,String> innerNameMap, Element targetEl) {
		Element resultEl = result.getDocument().createElement(targetEl.getNodeName());
		NamedNodeMap attributes = targetEl.getAttributes();
		for (int ai=0; ai<attributes.getLength(); ai++) {
			Attr attribute = (Attr)attributes.item(ai);
			String portName = attribute.getName();
			String value = attribute.getValue();
			if (value==null || value.length()==0)
				; // no op
			else if (Constants.NODE_SUPPORT_ATTRIBUTE_NAME.equals(portName)) 
				// leave support the same for now (?!) 
				// TODO think more about copying 
				resultEl.setAttribute(portName, value);
			else if (DomMatcher.linkIsConstant(value))
				// copy values
				resultEl.setAttribute(portName, value);
			else if (!innerNameMap.containsKey(value))
				// copy unchanged values
				resultEl.setAttribute(portName, value);
			else {
				// map
				String newValue = innerNameMap.get(value);
				if (newValue==null) {
					newValue = newLinkMap.get(value);
					if (newValue==null) {
						// new link
						newValue = newLinkName(value);
						newLinkMap.put(value, newValue);
					}
				}
				resultEl.setAttribute(portName, newValue);
			}
		}
		// recurse
		NodeList children = targetEl.getChildNodes();
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (!(child instanceof Element))
				continue;
			resultEl.appendChild(mapSiteNode(result, newLinkMap, innerNameMap, (Element)child));
		}
		return resultEl;
	}

}
