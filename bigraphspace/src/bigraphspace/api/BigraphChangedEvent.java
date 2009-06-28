/**
 * 
 */
package bigraphspace.api;

/** Simple notification of change to Bigraph.
 * 
 * @author cmg
 *
 */
public class BigraphChangedEvent {
	/** bigraph */
	protected ReactiveBigraph bigraph;
	/** cons */
	public BigraphChangedEvent() {		
	}
	/**
	 * @param bigraph
	 */
	public BigraphChangedEvent(ReactiveBigraph bigraph) {
		super();
		this.bigraph = bigraph;
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

}
