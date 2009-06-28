/**
 * 
 */
package bigraphspace.api;

import java.util.LinkedList;
import java.util.List;

import bigraphspace.model.Match;

/** ReactionRule fired event.
 * 
 * @author cmg
 *
 */
public class RuleFiredEvent {
	/** the bigraph */
	protected ReactiveBigraph bigraph;
	/** the rule */
	protected ReactionRule rule;
	/** the match(es) found for the pre-conditions (if any) */
	protected LinkedList<List<Match>> preconditionMatches = new LinkedList<List<Match>>();
	/** the redex match (may be null if maxOccurs is zero). If rule has reactum the first redex match is used. */
	protected List<Match> redexMatches = new LinkedList<Match>();
	/** cons */
	public RuleFiredEvent() {		
	}
	/**
	 * @param bigraph
	 * @param rule
	 * @param preconditionMatches
	 * @param redexMatch
	 */
	public RuleFiredEvent(ReactiveBigraph bigraph, ReactionRule rule,
			LinkedList<List<Match>> preconditionMatches, List<Match> redexMatches) {
		super();
		this.bigraph = bigraph;
		this.rule = rule;
		this.preconditionMatches = preconditionMatches;
		this.redexMatches = redexMatches;
	}
	/**
	 * @return the bigraph
	 */
	public ReactiveBigraph getBigraph() {
		return bigraph;
	}
	/**
	 * @param bigraph the bigraph to set
	 */
	public void setBigraph(ReactiveBigraph bigraph) {
		this.bigraph = bigraph;
	}
	/**
	 * @return the rule
	 */
	public ReactionRule getRule() {
		return rule;
	}
	/**
	 * @param rule the rule to set
	 */
	public void setRule(ReactionRule rule) {
		this.rule = rule;
	}
	/**
	 * @return the preconditionMatches
	 */
	public LinkedList<List<Match>> getPreconditionMatches() {
		return preconditionMatches;
	}
	/**
	 * @param preconditionMatches the preconditionMatches to set
	 */
	public void setPreconditionMatches(LinkedList<List<Match>> preconditionMatches) {
		this.preconditionMatches = preconditionMatches;
	}
	/**
	 * @return the redexMatch
	 */
	public List<Match> getRedexMatches() {
		return redexMatches;
	}
	/**
	 * @param redexMatch the redexMatch to set
	 */
	public void setRedexMatches(List<Match> redexMatches) {
		this.redexMatches = redexMatches;
	}
	
}
