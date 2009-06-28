/**
 * 
 */
package bigraphspace.api;

/** ReactionRule applied.
 * 
 * @author cmg
 *
 */
public interface RuleFiredListener {
	/** rule fired; if ruleSession is non-null then the callback has the chance to do more stuff within
	 * the rule session.
	 * 
	 * @param ruleSession the open BigraphSession in which the rule has/is being executed. else null.
	 */
	public void ruleFired(RuleFiredEvent rfe, BigraphSession ruleSession);
}
