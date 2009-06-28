/**
 * 
 */
package bigraphspace.api;

import bigraphspace.model.Bigraph;

/** pre-condition for rule, namely match (or not) a pattern.
 * 
 * @author cmg
 *
 */
public class RuleCondition {
	/** pattern */
	protected Bigraph pattern;
	/** min cardinality of matches, defaults to 1 */
	protected int minOccurs = 1;
	/** max cardinatily of matches, defaults to UNLIMITED */
	protected int maxOccurs = UNLIMITED;
	/** root of match must be (transitively) active?, defaults to false */
	protected boolean activeContext;
	/** special occurs value indicating unlimited */
	public static final int UNLIMITED = -1;
	/** cons */
	public RuleCondition() {		
	}
	/**
	 * @param pattern
	 * @param minOccurs
	 * @param maxOccurs
	 */
	public RuleCondition(Bigraph pattern, int minOccurs, int maxOccurs, boolean activeContext) {
		super();
		this.pattern = pattern;
		this.minOccurs = minOccurs;
		this.maxOccurs = maxOccurs;
		this.activeContext = activeContext;
	}
	/**
	 * @return the pattern
	 */
	public Bigraph getPattern() {
		return pattern;
	}
	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(Bigraph pattern) {
		this.pattern = pattern;
	}
	/**
	 * @return the minOccurs
	 */
	public int getMinOccurs() {
		return minOccurs;
	}
	/**
	 * @param minOccurs the minOccurs to set
	 */
	public void setMinOccurs(int minOccurs) {
		this.minOccurs = minOccurs;
	}
	/**
	 * @return the maxOccurs
	 */
	public int getMaxOccurs() {
		return maxOccurs;
	}
	/**
	 * @param maxOccurs the maxOccurs to set
	 */
	public void setMaxOccurs(int maxOccurs) {
		this.maxOccurs = maxOccurs;
	}
	/**
	 * @return the activeContext
	 */
	public boolean isActiveContext() {
		return activeContext;
	}
	/**
	 * @param activeContext the activeContext to set
	 */
	public void setActiveContext(boolean activeContext) {
		this.activeContext = activeContext;
	}
	
}
