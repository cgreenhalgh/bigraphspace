/**
 * 
 */
package bigraphspace.model.xml;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.apache.log4j.Logger;

/** Find match(es) between pattern and target bigraph.
 * 
 * @author cmg
 *
 */
public class DomMatcher {
	/** logger */
	static Logger logger = Logger.getLogger(DomMatcher.class);
	/** cons */
	public DomMatcher() {
	}
	/** unlimited match constnat */
	public static final int UNLIMITED = 0;
	/** match.
	 * @param maxMatches max number of matches to return; 0 => unlimited */
	public List<DomMatch> match(DomBigraph pattern, DomBigraph target, int maxMatches) {
		// make initial part-match
		DomPartMatch partMatch = new DomPartMatch();
		Element patternBigraphEl = pattern.getBigraphElement();
		Element targetBigraphEl = target.getBigraphElement();
		// add pattern roots
		NodeList patternRootEls = patternBigraphEl.getElementsByTagName(Constants.ROOT_ELEMENT_NAME);
		for (int ri=0; ri<patternRootEls.getLength(); ri++)
			partMatch.unmatchedPlaces.add((Element)patternRootEls.item(ri));
		while(!partMatch.unmatchedPlaces.isEmpty()) {
			Element patternEl = partMatch.unmatchedPlaces.removeFirst();
			// add children to list
			NodeList patternChildEls = patternEl.getChildNodes();
			boolean hasNodeChildren = false;
			for (int pci=0; pci<patternChildEls.getLength(); pci++) {
				Node patternChildEl = patternChildEls.item(pci);
				if (patternChildEl instanceof Element) {
					if (!Constants.SITE_ELEMENT_NAME.equals(patternChildEl.getNodeName()))
						hasNodeChildren = true;
					partMatch.unmatchedPlaces.add((Element)patternChildEl);				
				}
			}
			if (Constants.ROOT_ELEMENT_NAME.equals(patternEl.getNodeName()) && !hasNodeChildren) {
				logger.error("Cannot match degenerate pattern with root containing no nodes");
				return new LinkedList<DomMatch>();
			}
			if (Constants.ROOT_ELEMENT_NAME.equals(patternEl.getNodeName()) ||
					Constants.SITE_ELEMENT_NAME.equals(patternEl.getNodeName())) {
				// roots are not matched explicitly in the first instance,
				// but populated from first child to help with resolving root child sibs
				// (if required).
				// Sites are derived from node matching.
				logger.debug("Skipping "+patternEl.getNodeName()+" during initial match generation");
				continue;
			}
			// do we already have a parent part matched? (not a root so should be element parent)
			DomPartMatch.NodeMatch parentNodeMatch = null;
			DomPartMatch.NodeMatch siblingNodeMatch = null;
			Element patternParentEl = (Element)patternEl.getParentNode();
			for (DomPartMatch.NodeMatch pm : partMatch.nodeMatches) {
				if (patternParentEl==pm.patternEl) {
					parentNodeMatch = pm;
					break;
				}
				if (pm.patternEl.getParentNode()==patternParentEl)
					siblingNodeMatch = pm;
			}
			// no parent but sibling => create parent match (should be root)
			if (parentNodeMatch==null && siblingNodeMatch!=null) {
				parentNodeMatch = new DomPartMatch.NodeMatch();
				parentNodeMatch.patternEl = patternParentEl;
				for (Element targetSiblingEl : siblingNodeMatch.targetEls) {
					// eliminate duplicates
					Element targetParentEl = (Element)targetSiblingEl.getParentNode();
					boolean found = false;
					for (Element e : parentNodeMatch.targetEls)
						if (e==targetParentEl) {
							found = true;
							break;
						}
					if (!found)
						parentNodeMatch.targetEls.add(targetParentEl);
				}
				partMatch.nodeMatches.add(parentNodeMatch);
				logger.debug("Generated parent match for sibling "+siblingNodeMatch.patternEl+" "+siblingNodeMatch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME));
			}
			DomPartMatch.NodeMatch nodeMatch = null;
			if (parentNodeMatch!=null) {
				logger.debug("Using existing parent match "+parentNodeMatch.patternEl+" "+parentNodeMatch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME));
				// based on parent...
				nodeMatch = new DomPartMatch.NodeMatch();
				nodeMatch.patternEl = patternEl;
				nodeMatch.parentNodeMatch = parentNodeMatch;
				// clone this because we are going to potentially remove items from it as we go
				List<Element> targetParentEls = new LinkedList<Element>(parentNodeMatch.targetEls);
				for (Element targetParentEl : targetParentEls) {
					// all candidate children
					boolean possible = false;
					NodeList targetNodes = targetParentEl.getChildNodes();
					for (int ti=0; ti<targetNodes.getLength(); ti++) {
						Node targetNode = targetNodes.item(ti);
						if (!(targetNode instanceof Element))
							continue;
						Element targetEl = (Element)targetNode;
						if (possibleMatch(patternEl, targetEl)) {
							possible = true;
							nodeMatch.targetEls.add(targetEl);
						}
					}
					// if there are NO matches for that parent then eliminate the 
					// parent (cascade potentially to other dependents and ancestors)
					if (!possible) {
						eliminateParentOption(partMatch, parentNodeMatch, targetParentEl, nodeMatch);
					}
				}
			} else {
				logger.debug("Generating initial matches for "+patternEl+" "+patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME));
				// no parent node match - start with all matching controls
				nodeMatch = new DomPartMatch.NodeMatch();
				nodeMatch.patternEl = patternEl;
				nodeMatch.parentNodeMatch = null;
				addInitialMatches(nodeMatch, targetBigraphEl);
			}
			partMatch.nodeMatches.add(nodeMatch);
			logger.debug("Found "+nodeMatch.targetEls.size()+" possible matches for "+nodeMatch.patternEl+" "+nodeMatch.patternEl.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME));
			for (Element el : nodeMatch.targetEls)
				logger.debug("- "+el+" "+el.getAttribute(Constants.NODE_SUPPORT_ATTRIBUTE_NAME));
		}
		// remove any root matches (generated as parent matches for siblings in root) 
		for (int ni=0; ni<partMatch.nodeMatches.size(); ) {
			if (Constants.ROOT_ELEMENT_NAME.equals(partMatch.nodeMatches.get(ni).patternEl.getNodeName()))
				partMatch.nodeMatches.remove(ni);
			else
				ni++;
		}
		// generate candidate matches...
		LinkedList<DomMatch> matches = new LinkedList<DomMatch>();
		int targetIxs [] = new int[partMatch.nodeMatches.size()];
		int matchCount = 0;
		complete:
		while(true) {
			DomMatch match = new DomMatch();
			match.pattern = pattern;
			match.target = target;
			for (int i=0; i<partMatch.nodeMatches.size(); i++) {
				DomPartMatch.NodeMatch partNodeMatch = partMatch.nodeMatches.get(i);
				if (targetIxs[i]>=partNodeMatch.targetEls.size())
					// impossible/done
					break complete;
				DomMatch.ElementMatch nodeMatch = new DomMatch.ElementMatch();
				nodeMatch.patternEl = partNodeMatch.patternEl;
				nodeMatch.targetEl = partNodeMatch.targetEls.get(targetIxs[i]);
				// check respects parent(s) (parent should be already done because
				// of top-down generation)
				Element parentPatternEl = (Element)nodeMatch.patternEl.getParentNode();
				if (!Constants.ROOT_ELEMENT_NAME.equals(parentPatternEl.getNodeName())) {
					boolean found = false;
					for (int di=0; di<i && !found; di++) {
						DomMatch.ElementMatch parentMatch = match.nodeMatches.get(di);
						if (parentMatch.patternEl==parentPatternEl) {
							if (parentMatch.targetEl!=nodeMatch.targetEl.getParentNode()) {
								// nope
								nextMatch(partMatch, targetIxs);
								continue complete;
							}
							// yes
							found = true;
						}
					}
					if (!found) 
						logger.error("Did not find parent match for match "+nodeMatch.patternEl+"->"+nodeMatch.targetEl);
				} else {
					// check respects siblings of root
					for (int di=0; di<i; di++) {
						DomMatch.ElementMatch siblingMatch = match.nodeMatches.get(di);
						Element siblingParentPatternEl = (Element)siblingMatch.patternEl.getParentNode();
						if (siblingParentPatternEl==parentPatternEl) {
							if (siblingMatch.targetEl.getParentNode()!=nodeMatch.targetEl.getParentNode()) {
								// nope
								nextMatch(partMatch, targetIxs);
								continue complete;
							}
						}
					}	
					// also check that the parent Root is not under the image of some other root of the pattern
					// (can just check the ones done so far). I.e. no ancestor of the new target node is
					// already in the match target
					Element targetAncestorEl = (Element)nodeMatch.targetEl.getParentNode();
					while (targetAncestorEl!=null && !Constants.ROOT_ELEMENT_NAME.equals(targetAncestorEl.getNodeName())) {
						for (int di=0; di<i; di++) {
							DomMatch.ElementMatch ancestorMatch = match.nodeMatches.get(di);
							if (ancestorMatch.targetEl==targetAncestorEl) {
								// nope
								nextMatch(partMatch, targetIxs);
								continue complete;								
							}
						}
						targetAncestorEl = (Element)targetAncestorEl.getParentNode();
					}
				}
				// check non-duplicate
				for (int di=0; di<i; di++) 
					if (match.nodeMatches.get(di).targetEl==nodeMatch.targetEl) {
						nextMatch(partMatch, targetIxs);
						continue complete;
					}
				match.nodeMatches.add(nodeMatch);
			}
			// TODO 
			// check links
			// determine the link matches, checking as you go along...
			for (DomMatch.ElementMatch nodeMatch : match.nodeMatches) {
				NamedNodeMap patternAttributes = nodeMatch.patternEl.getAttributes();
				for (int pai=0; pai<patternAttributes.getLength(); pai++) {
					Attr patternAttr = (Attr)patternAttributes.item(pai);
					String portName = patternAttr.getName();
					if (Constants.NODE_SUPPORT_ATTRIBUTE_NAME.equals(portName))
						// skip support
						continue;
					String patternLink = patternAttr.getValue();
					if (linkIsConstant(patternLink))
						// skip constants
						continue;
					String targetLink = nodeMatch.targetEl.getAttribute(portName);
					// if it is unnamed in the pattern then do we assume it is an outer name,
					// or do we assume it is unlinked? Outer name - use explicit non-outer/non-inner to 
					// force unlinked. 
					if (patternLink==null || patternLink.length()==0)
						// matches anything, and there's nothing much we can record about it
						continue;
					// if the target link is unnamed then it can't connect anywhere in the target.
					// this would only work if this is a unique occurrence of this link in the pattern.
					if (targetLink==null || targetLink.length()==0) {
						if (countLinkOccurrences(pattern.getBigraphElement(), patternLink)!=1)
						{
							nextMatch(partMatch, targetIxs);
							continue complete;
						}
					}
					// both are named so (a) check that this pattern link is not already mapped to another 
					// target link, and (b) merge (if links to already linked to target)/create with mappings
					boolean handled = false;
					for (DomMatch.LinkMatch linkMatch : match.linkMatches) {
						if (linkMatch.patternLinks.contains(patternLink)) {
							if (!linkMatch.targetLink.equals(targetLink)) 
							{
								// error
								nextMatch(partMatch, targetIxs);
								continue complete;
							}
							handled = true;
						}
						else if (linkMatch.targetLink.equals(targetLink)) {
							// merge
							linkMatch.patternLinks.add(patternLink);
							handled = true;
						}
					}
					if (!handled) {
						// new match
						DomMatch.LinkMatch linkMatch = new DomMatch.LinkMatch();
						linkMatch.patternLinks.add(patternLink);
						linkMatch.targetLink = targetLink;
						match.linkMatches.add(linkMatch);
					}
				}
			}

			// check non-outer names, i.e. edges
			Set<String> patternEdgeNames = pattern.getEdgeNames();
			// map to target
			Set<String> targetEdgeNames = mapLinkNames(patternEdgeNames, match);
			// if the target of the edge occurs in the target bigraph "above" the match then that is
			// disallowed. So we recurse the target bigraph from the root, giving up at each image
			// of a node in the pattern, looking for the edge names.
			if (targetEdgeNames.size()>0 && findEdgeOccurrence(targetBigraphEl, targetEdgeNames, match))
			{
				nextMatch(partMatch, targetIxs);
				continue complete;
			}

			// check non-inner names, i.e. hidden
			Set<String> patternHiddenNames = pattern.getHiddenNames();
			// map to target
			Set<String> targetHiddenNames = mapLinkNames(patternHiddenNames, match);
			// if the target of the edge occurs in the target bigraph "below" the match then it is disallowed,
			// i.e. in a node that MUST be part of the parameter, i.e. a descendent of a matched node that is
			// not itself part of the image of the pattern.
			if (targetHiddenNames.size()>0 && findHiddenOccurrence(targetBigraphEl, targetHiddenNames, match, true))
			{
				nextMatch(partMatch, targetIxs);
				continue complete;
			}
			
			// TODO
			// fill in remaining correspondences: holes and sites
			match.inferHolesAndSites();
			
			// OK
			matches.add(match);
			matchCount++;
			if (maxMatches>0 && matchCount>=maxMatches)
				// "enough"
				break;
			
			// iterate
			nextMatch(partMatch, targetIxs);
		}
		return matches;
	}
	/** map link names to target link names */
	private Set<String> mapLinkNames(Set<String> patternLinkNames, DomMatch match) {
		// map to target
		TreeSet<String> targetLinkNames = new TreeSet<String>();
		for (DomMatch.LinkMatch linkMatch : match.linkMatches) {
			for (String patternLink : linkMatch.patternLinks) {
				if (patternLinkNames.contains(patternLink))
					targetLinkNames.add(linkMatch.targetLink);
				break;
			}
		}
		return targetLinkNames;
	}
	/** cound link occurances */
	private int countLinkOccurrences(Element element, String patternLink) {
		int count = 0;
		NamedNodeMap attributes = element.getAttributes();
		for (int ai=0; ai<attributes.getLength(); ai++) {
			String value = attributes.item(ai).getNodeValue();
			if (value.equals(patternLink))
				count++;
		}
		NodeList children = element.getChildNodes();
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (child instanceof Element) {
				count += countLinkOccurrences((Element)child, patternLink);
			}
		}
		return count;
	}
	/** find edge occurrence above match */
	private boolean findEdgeOccurrence(Element element, Set<String> edgeNames, DomMatch match) {
		for (DomMatch.ElementMatch nodeMatch : match.nodeMatches) {
			if (nodeMatch.targetEl==element)
				// ignore/stop
				return false;
		}
		NamedNodeMap attributes = element.getAttributes();
		for (int ai=0; ai<attributes.getLength(); ai++) {
			String value = attributes.item(ai).getNodeValue();
			if (edgeNames.contains(value))
				return true;
		}
		NodeList children = element.getChildNodes();
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (child instanceof Element) {
				// recurse
				if (findEdgeOccurrence((Element)child, edgeNames, match))
					return true;
			}
		}
		return false;
	}
	/** find hidden occurrence below match */
	private boolean findHiddenOccurrence(Element element, Set<String> hiddenNames, DomMatch match, boolean above) {
		boolean inPatternImage = false;
		for (DomMatch.ElementMatch nodeMatch : match.nodeMatches) {
			if (nodeMatch.targetEl==element) {
				// in image
				inPatternImage = true;
				break;
			}
		}
		if (!above && !inPatternImage) {
			// check for name
			NamedNodeMap attributes = element.getAttributes();
			for (int ai=0; ai<attributes.getLength(); ai++) {
				String value = attributes.item(ai).getNodeValue();
				if (hiddenNames.contains(value))
					return true;
			}
		}
		// recurse anyway
		NodeList children = element.getChildNodes();
		for (int ci=0; ci<children.getLength(); ci++) {
			Node child = children.item(ci);
			if (child instanceof Element) {
				// recurse, updating "above"ness
				if (findHiddenOccurrence((Element)child, hiddenNames, match, above && !inPatternImage))
					return true;
			}
		}
		return false;
	}
	/** update index(es) in match generation loop */
	private void nextMatch(DomPartMatch partMatch, int targetIxs []) {
		// next
		for (int i=0; i<partMatch.nodeMatches.size(); i++) {
			targetIxs[i]++;
			DomPartMatch.NodeMatch partNodeMatch = partMatch.nodeMatches.get(i);
			if (targetIxs[i]>=partNodeMatch.targetEls.size()) {
				if (i+1<partMatch.nodeMatches.size())
					targetIxs[i] = 0;
			}
			else
				break;	
		}
	}
	/** eliminate parent option found unviable - recursive */
	void eliminateParentOption(DomPartMatch partMatch, DomPartMatch.NodeMatch parentNodeMatch, Element targetParentEl, DomPartMatch.NodeMatch causingNodeMatch) {
		// TODO check which item is removed??
		parentNodeMatch.targetEls.remove(targetParentEl);
		// TODO
		// recurse or something...
	}

	/** add initial possible matches - recursive */
	void addInitialMatches(DomPartMatch.NodeMatch nodeMatch, Element targetEl) {
		if (possibleMatch(nodeMatch.patternEl, targetEl))
			nodeMatch.targetEls.add(targetEl);
		// recurse
		NodeList childNodes = targetEl.getChildNodes();
		for (int ci=0; ci<childNodes.getLength(); ci++) {
			Node childNode = childNodes.item(ci);
			if (childNode instanceof Element) 
				addInitialMatches(nodeMatch, (Element)childNode);
		}
	}
	/** initial filter on pattern/node compatibility - control, constant ports */
	boolean possibleMatch(Element patternEl, Element targetEl) {
		if (!patternEl.getNodeName().equals(targetEl.getNodeName()))
			return false;
		NamedNodeMap attributes = patternEl.getAttributes();
		for (int ai=0; ai<attributes.getLength(); ai++) {
			Attr attribute = (Attr)attributes.item(ai);
			String portName = attribute.getName();
			String patternValue = attribute.getValue();
			if (linkIsConstant(patternValue)) {
				// constant 
				String targetValue = targetEl.getAttribute(portName);
				if (targetValue==null)
					return false;
				if (!patternValue.equals(targetValue))
					return false;
			}
		}
		return true;
	}
	/** link value is constant 
	 */
	public static boolean linkIsConstant(String patternValue) {
		if (patternValue.length()>0 && (patternValue.charAt(0)=='"' || patternValue.charAt(0)=='~' ||patternValue.charAt(0)=='-' || Character.isDigit(patternValue.charAt(0)))) 
			return true;
		return false;
	}
}
