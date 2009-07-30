/**
 * 
 */
package bigraphspace.model.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bigraphspace.model.Bigraph;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Match;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;

/** Match between bigraph pattern (e.g. redex) and ground bigraph.
 * 
 * @author cmg
 *
 */
public class DomMatch implements Match {
	/** logger */
	static Logger logger = Logger.getLogger(DomMatch.class);
	/** pattern */
	DomBigraph pattern;
	/** target */
	DomBigraph target;
	/** match for node from pattern Element to target Element */
	static class ElementMatch {
		Element patternEl;
		Element targetEl;
		int index; // for root
	}
	/** all node matches */
	ArrayList<ElementMatch> nodeMatches = new ArrayList<ElementMatch>();
	/** match for site from pattern Element to possibly empty bag of target node Element(s).
	 * Can be derived from nodeMatches and target bigraph. */
	static class ElementsMatch {
		Element patternEl;
		ArrayList<Element> targetEls = new ArrayList<Element>();
	}
	/** all site matches */
	ArrayList<ElementsMatch> siteMatches = new ArrayList<ElementsMatch>();
	/** match for root from pattern Element to a Root or Node or possibly null (empty prime)
	 * in the target bigraph. I.e. these are the nodes that mark the top level
	 * immediately above that which might be changed. */
	ArrayList<ElementMatch> rootMatches = new ArrayList<ElementMatch>();
	/** all link matches */
	ArrayList<LinkMatch> linkMatches = new ArrayList<LinkMatch>();
	/** variable exact value matches */
	Map<String,Object> variableValues = new HashMap<String,Object>();
	/** cons
	 */
	public DomMatch() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Match#getPattern()
	 */
	//@Override
	public Bigraph getPattern() {
		return pattern;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Match#getTarget()
	 */
	//@Override
	public Bigraph getTarget() {
		return target;
	}

	/**
	 * @return the pattern
	 */
	public DomBigraph getDomPattern() {
		return pattern;
	}

	/**
	 * @return the target
	 */
	public DomBigraph getDomTarget() {
		return target;
	}

	/**
	 * @return the nodeMatches
	 */
	public ArrayList<ElementMatch> getNodeMatches() {
		return nodeMatches;
	}

	/**
	 * @return the siteMatches
	 */
	public ArrayList<ElementsMatch> getSiteMatches() {
		return siteMatches;
	}

	/**
	 * @return the rootMatches
	 */
	public ArrayList<ElementMatch> getRootMatches() {
		return rootMatches;
	}

	/**
	 * @return the linkMatches
	 */
	public ArrayList<LinkMatch> getLinkMatches() {
		return linkMatches;
	}

	/** fill in remaining correspondences: holes and sites given node and link mappings */
	void inferHolesAndSites() {
		// holes are matched to parent of a match of a child
		NodeList rootEls = XmlUtils.getChildElementsByTagName(this.pattern.getBigraphElement(), Constants.ROOT_ELEMENT_NAME);
		for (int ri=0; ri<rootEls.getLength(); ri++) {
			Element rootEl = (Element)rootEls.item(ri);
			// check if root matched directly
			ElementMatch rootMatch = findNodeMatch(rootEl);
			if (rootMatch!=null) {
				// take out of node matches
				rootMatch.index = ri;
				this.nodeMatches.remove(rootMatch);
				this.rootMatches.add(rootMatch);
				logger.debug("Found root match "+rootMatch.patternEl+" -> "+rootMatch.toString());
				continue;
			}
			// infer as usual
			rootMatch = new ElementMatch();
			rootMatch.patternEl = rootEl;
			rootMatch.index = ri;
			
			// find a child that matched
			NodeList childEls = rootEl.getChildNodes();
			for (int ci=0; ci<childEls.getLength(); ci++) {
				Node child = childEls.item(ci);
				if (!(child instanceof Element))
					continue;
				if (Constants.SITE_ELEMENT_NAME.equals(child.getNodeName()))
					// no good
					continue;
				// ok
				ElementMatch childMatch = findNodeMatch((Element)child);
				rootMatch.targetEl = (Element)childMatch.targetEl.getParentNode();		
				break;
			}
			// if it had no child, or only site(s) as children then it trivial matches the empty prime
			// bigraph, which we just leave as a null target (watch out!)
			this.rootMatches.add(rootMatch);
		}
		// sites are matched greedily to children of their parent excluding only those 
		// already matched by nodes.
		// we also have to find the sites (by checking possible node parents or root parents)
		LinkedList<ElementMatch> nodeAndRootMatches = new LinkedList<ElementMatch>();
		nodeAndRootMatches.addAll(this.nodeMatches);
		nodeAndRootMatches.addAll(this.rootMatches);
		// NOTE: if this was DAGs, not trees, this may not work as you could get to the same
		// site more than one way and do it again
		while (!nodeAndRootMatches.isEmpty()) {
			ElementMatch nodeOrRootMatch = nodeAndRootMatches.removeFirst();
			NodeList children = nodeOrRootMatch.patternEl.getChildNodes();
			boolean doneSite = false;
			for (int ci=0; ci<children.getLength(); ci++) {
				Node child = children.item(ci);
				if (!(child instanceof Element))
					continue;
				if (!Constants.SITE_ELEMENT_NAME.equals(child.getNodeName()))
					continue;
				// found a site!
				ElementsMatch siteMatch = new ElementsMatch();
				siteMatch.patternEl = (Element)child;
				if (!doneSite) {
					// first site - greedy
					doneSite = true;
					// all possible children in target...
					NodeList targetChildren = nodeOrRootMatch.targetEl.getChildNodes();
					for (int tci=0; tci<targetChildren.getLength(); tci++) {
						Node targetChild = targetChildren.item(tci);
						if (!(targetChild instanceof Element))
							continue;
						// is it matched by a node? it would be a child of the parent pattern node
						// but there isn't an easy way to check/exploit that, so exhaustive for now...
						// (does it matter 
						boolean inPatternImage = false;
						for (DomMatch.ElementMatch nodeMatch : nodeMatches) {
							if (nodeMatch.targetEl==targetChild) {
								// in image
								inPatternImage = true;
								break;
							}
						}
						if (!inPatternImage)
							siteMatch.targetEls.add((Element)targetChild);						
					}
				}
				else {
					// we'll stick all the matches into the first possible site! so just tidy up any more 
					// with nothing left in them
				}
				this.siteMatches.add(siteMatch);
			}
		}
	}
	/** find a NodeMatch for an element in the pattern */
	ElementMatch findNodeMatch(Element patternEl) {
		for (ElementMatch nodeMatch : nodeMatches)
			if (nodeMatch.patternEl==patternEl)
				return nodeMatch;
		return null;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Match#getVariableValues()
	 */
	//@Override
	public Map<String, Object> getVariableValues() {
		return variableValues;
	}

	/** dump - debug */
	public void dump(PrintStream ps) {
		dump(ps, "Pattern", pattern);
		dump(ps, "Target", target);
		ps.println(linkMatches.size()+" link matches:");
		for (DomMatch.LinkMatch linkMatch : this.linkMatches) {
			ps.print("  { ");
			for (String patternLink : linkMatch.patternLinks)
				ps.print(patternLink+" ");
			ps.println("} -> "+linkMatch.targetLink);
		}
		ps.print(variableValues.size()+" variable values:");
		for(Map.Entry<String,Object> variableValue : variableValues.entrySet()) {
			ps.print(" "+variableValue.getKey()+"="+variableValue.getValue());
		}
		ps.println();
	}		
	/** dump - debug */
	protected void dump(PrintStream ps, String title, DomBigraph bigraph) {
		List<Place> roots = bigraph.getRoots();
		ps.println("XML Bigraph "+title+", "+roots.size()+" roots:");
		for (Place root : roots) {
			dump(ps, root, 1);
		}
		Set<String> edges = bigraph.getEdgeNames();
		Set<String> hiddens = bigraph.getHiddenNames();
		ps.print(edges.size()+" edges: ");
		for (String edge : edges)
			ps.print(edge+" ");
		ps.println();
		ps.print(hiddens.size()+" hidden names (non-inner names): ");
		for (String hidden: hiddens)
			ps.print(hidden+" ");
		ps.println();
		Map<String,String> innerNameMap = bigraph.getInnerNameMap();
		ps.println(innerNameMap.size()+" inner name mappings: "+innerNameMap);
		bigraph.dumpVariables(ps);
	}
	/** dump an element, recursively */
	public void dump(PrintStream ps, Place place, int indent) {
		String tag = "";
		// find in match?
		DomPlace domPlace = (DomPlace)place;
		int i=0;
		for (ElementMatch elm : this.rootMatches) {
			if (elm.patternEl==domPlace.getElement() || elm.targetEl==domPlace.getElement()) {
				tag = " [root:"+i+"]";
				break;
			}
			i++;
		}
		i=0;
		for (ElementMatch elm : this.nodeMatches) {
			if (elm.patternEl==domPlace.getElement() || elm.targetEl==domPlace.getElement()) {
				tag = " ["+i+"]";
				break;
			}
			i++;
		}
		for (ElementsMatch elm : this.siteMatches) {
			if (elm.patternEl==domPlace.getElement() || elm.targetEls.contains(domPlace.getElement())) {
				tag = " [_"+elm.patternEl.getAttribute(Constants.SITE_INDEX_ATTRIBUTE_NAME)+"]";
				break;
			}
		}
		String support = place.getSupport()!=null ? "/"+place.getSupport() : "";
		if (place.isSite())
			ps.println(XmlUtils.getIndent(indent)+support+"[]"+tag);
		else if (place.isRoot())
			ps.println(XmlUtils.getIndent(indent)+support+"root"+tag);
		else {
			if (place.isIndexed()) {
				ps.print(XmlUtils.getIndent(indent));
				//ps.print("<");
				List<IndexValue> indexes = place.getControlIndexes();
				for (int ii=0; ii<indexes.size(); ii++) {
					if (ii>0)
						ps.print(",");
					IndexValue index = indexes.get(ii);
					if (index.isVariable())
						ps.print("$"+index.getVariableName());
					else
						ps.print(index.getValue());
				}
				//ps.print(">");
				ps.println(":"+place.getControlName()+support+tag);
			}
			else 
				ps.println(XmlUtils.getIndent(indent)+place.getControlName()+support+tag);
		}
		List<Port> ports = place.getPorts();
		if (ports.size()>0) {
			ps.println(XmlUtils.getIndent(indent)+"{");
			for (Port port : ports) {
				String portName = port.getName();
				String value = port.getLinkName();
				ps.println(XmlUtils.getIndent(indent+1)+portName+"="+value);
			}
			ps.println(XmlUtils.getIndent(indent)+"}");
		}
		List<Place> children = place.getChildren();
		if (children.size()>0) {
			ps.println(XmlUtils.getIndent(indent)+"(");
			for (Place child : children) {
				dump(ps, child, indent+1);
			}
			ps.println(XmlUtils.getIndent(indent)+")");
		}
	}

}
