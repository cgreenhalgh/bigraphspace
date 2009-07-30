/**
 * 
 */
package bigraphspace.model.xml;

import java.util.List;
import java.util.LinkedList;

import bigraphspace.model.VariableConstraint;
import bigraphspace.model.VariableConstraintType;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 * @author cmg
 *
 */
public class DomVariableConstraint implements VariableConstraint {
	/** element */
	protected Element element;
	/** cons - from bigraph */
	DomVariableConstraint(Element element) {
		this.element = element;
	}
	
	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.VariableConstraint#getConstraintType()
	 */
	//@Override
	public VariableConstraintType getConstraintType() {
		return VariableConstraintType.valueOf(element.getAttribute(Constants.CONSTRAINT_TYPE_ATTRIBUTE_NAME));
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.VariableConstraint#getValues()
	 */
	//@Override
	public List<Object> getValues() {
		LinkedList<Object> values = new LinkedList<Object>();
		switch(getConstraintType()) {
		case oneof:
		case notoneof:
		{
			NodeList valueEls = XmlUtils.getChildElementsByTagName(element, Constants.VALUE_ELEMENT_NAME);
			for (int i=0; i<valueEls.getLength(); i++) {
				values.add(((Element)valueEls.item(i)).getTextContent());
			}
			break;
		}
		default:
			values.add(element.getTextContent());
			break;
		}
		return values;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.VariableConstraint#getVariableName()
	 */
	//@Override
	public String getVariableName() {
		String name = element.getAttribute(Constants.CONSTRAINT_VARIABLE_ATTRIBUTE_NAME);
		if (name==null || name.length()==0)
			return null;
		return name;
	}

}
