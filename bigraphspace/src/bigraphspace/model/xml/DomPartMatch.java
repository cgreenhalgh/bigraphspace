/**
 * 
 */
package bigraphspace.model.xml;

import org.w3c.dom.Element;

import java.util.LinkedList;

/** Partial match between pattern and (ground) bigraph.
 * @author cmg
 *
 */
class DomPartMatch {
	/** pattern */
	DomBigraph pattern;
	/** target */
	DomBigraph target;
	/** unmatched node(s) (or roots at start) */
	LinkedList<Element> unmatchedPlaces = new LinkedList<Element>();
	/** list of initial matches for a pattern node */
	static class NodeMatch {
		Element patternEl;
		LinkedList<Element> targetEls = new LinkedList<Element>();
		// depends on this... (if not null)
		NodeMatch parentNodeMatch;
		// direct root match
		boolean directRootMatch = false;
	}
	/** part matches */
	LinkedList<NodeMatch> nodeMatches = new LinkedList<NodeMatch>();
	/** cons */
	public DomPartMatch() {		
	}
}
