/**
 * 
 */
package bigraphspace.model;

/** Abstract Port interface. Implementation-independent.
 * 
 * @author cmg
 *
 */
public interface Port {
	/** get port name (if it has one; index is list may be only identity). 
	 * @return port name, or null if undefined.
	 */
	public String getName();
	/** set name (if allowed. */
	public void setName(String portName);
	/** get name/ID of link (if any) connected to this port.
	 * Note that this abstract model follows the ReactiveXML ideas of XML encoding/
	 * encodability of bigraphs. So this name/ID may correspond to a global link to 
	 * constant value (equivalent to a constant value itself). Or it may identify 
	 * (globally, hopefully) a name (outer) or edge.
	 * 
	 * @return "ID" of link, or null if port is unconnected.
	 */
	public String getLinkName();
	/** set link name/ID (if allowed). */
	public void setLinkName(String linkName);
	/** clear link (set to null) (if allowed) */
	public void clearLinkName();
	
	/** default port name prefix */
	public static final String DEFAULT_PORT_NAME_PREFIX = "unnamed_";
}
