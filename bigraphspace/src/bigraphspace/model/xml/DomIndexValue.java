/**
 * 
 */
package bigraphspace.model.xml;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import bigraphspace.model.IndexValue;

/**
 * @author cmg
 *
 */
public class DomIndexValue implements IndexValue {
	/** logger */
	static Logger logger = Logger.getLogger(DomIndexValue.class);
	/** element = place */
	protected Element element;
	/** cons - local */
	DomIndexValue(Element element) {
		this.element = element;
	}
	/** local */
	Element getElement() {
		return element;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.IndexValue#getValue()
	 */
	//@Override
	public Object getValue() {
		// TODO; coerce?
		if (getVariableName()!=null)
			return null;
		String svalue = element.getTextContent();
		if (svalue==null || svalue.length()==0)
			return "";
		return svalue;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.IndexValue#getVariableName()
	 */
	//@Override
	public String getVariableName() {
		String name = element.getAttribute(Constants.INDEX_VARIABLE_ATTRIBUTE_NAME);
		if (name==null || name.length()==0)
			return null;
		return name;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.IndexValue#isVariable()
	 */
	@Override
	public boolean isVariable() {
		return getVariableName()!=null;
	}

}
