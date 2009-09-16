/**
 * 
 */
package bigraphspace.model.xml;

import org.w3c.dom.Attr;

import bigraphspace.model.Port;

/**
 * @author cmg
 *
 */
public class DomPort implements Port {
	/** attribute */
	protected Attr attribute;
	/** cons - local */
	DomPort(Attr attribute) {
		this.attribute = attribute;
	}
	/** local */
	Attr getAttribute() {
		return attribute;
	}
	/* (non-Javadoc)
	 * @see bigraphspace.model.Port#clearLinkName()
	 */
	//@Override
	public void clearLinkName() {
		setLinkName(null);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Port#getLinkName()
	 */
	//@Override
	public String getLinkName() {
		String value = attribute.getValue();
		if (value==null || value.length()==0)
			return null;
		return value;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Port#getName()
	 */
	//@Override
	public String getName() {
		return attribute.getName();
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Port#setLinkName(java.lang.String)
	 */
	//@Override
	public void setLinkName(String linkName) {
		// null -> ""?!
		if (linkName==null)
			attribute.setValue("");
		else
			attribute.setValue(linkName);
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.Port#setName(java.lang.String)
	 */
	//@Override
	public void setName(String portName) {
		throw new UnsupportedOperationException(DomPort.class.getName()+".setName(String)");
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof DomPort)
		{
			return attribute.equals(((DomPort)obj).attribute);
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return attribute.hashCode();
	}
}
