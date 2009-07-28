/**
 * 
 */
package bigraphspace.model;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

import bigraphspace.model.xml.DomBigraph;

/** Abstract (technology independent) view of a Bigraph match.
 * TODO: add methods for getting abstracted views of match mappings.
 * 
 * @author cmg
 *
 */
public interface Match {
	/** (variable) link matches from pattern to target (not constants).
	 * Can be derived from nodeMatches, pattern and target bigraphs.
	 * Note that different link variables in the pattern may correspond to the same
	 * link in the target provided that all the link variables are outer names
	 * (so could be joined in context; inner names cannot be joined in parameter;
	 * if one is an inner name then the combination can be).
	 * One link in the pattern can NOT map to two links in the target as this would
	 * imply that they were not in fact connected in the target.
	 *  */
	public static class LinkMatch {
		public Set<String> patternLinks = new HashSet<String>();
		//String mergePatternLink;
		public String targetLink;
	}

	/**
	 * @return the pattern
	 */
	public Bigraph getPattern();

	/**
	 * @return the target
	 */
	public Bigraph getTarget();
	
	/**
	 * @return the linkMatches
	 */
	public List<LinkMatch> getLinkMatches();

	/** bigraph expressions contain variables; in a match these will all have exact values */
	public Map<String,Object> getVariableValues();
}
