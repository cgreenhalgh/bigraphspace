/**
 * 
 */
package bigraphspace.model.xml;

import java.util.List;
import java.util.LinkedList;

import bigraphspace.model.VariableConstraint;
import bigraphspace.model.VariableDefinition;
import bigraphspace.model.VariableType;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author cmg
 *
 */
public class DomVariableDefinition extends VariableDefinition {
	/** element */
	protected Element element;
	/** cons */
	DomVariableDefinition(Element element) {
		this.element = element;
	}
	
	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.VariableDefinition#getBaseType()
	 */
	//@Override
	public VariableType getBaseType() {
		return VariableType.valueOf(element.getAttribute(Constants.VARIABLE_BASE_TYPE_ATTRIBUTE_NAME));
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.VariableDefinition#getConstraints()
	 */
	//@Override
	public List<VariableConstraint> getConstraints() {
		LinkedList<VariableConstraint> constraints = new LinkedList<VariableConstraint>();
		NodeList constraintEls = XmlUtils.getChildElementsByTagName(element, Constants.CONSTRAINT_ELEMENT_NAME);
		for ( int i=0; i<constraintEls.getLength(); i++) {
			Element constraintEl = (Element)constraintEls.item(i);
			constraints.add(new DomVariableConstraint(constraintEl));
		}
		return constraints;
	}

	/* (non-Javadoc)
	 * @see bigraphspace.model.VariableDefinition#setConstraints(java.util.List)
	 */
	//@Override
	public void setConstraints(List<VariableConstraint> constraints) {
		// TODO Auto-generated method stub
		NodeList constraintEls = XmlUtils.getChildElementsByTagName(element, Constants.CONSTRAINT_ELEMENT_NAME);
		for ( int i=0; i<constraintEls.getLength(); i++) {
			element.removeChild(constraintEls.item(i));
		}
		for (VariableConstraint constraint : constraints) {
			if (constraint instanceof DomVariableConstraint) {
				DomVariableConstraint domConstraint = (DomVariableConstraint)constraint;
				element.appendChild(domConstraint.getElement());
			}
			else
				throw new IllegalArgumentException("setConstraints called with non-DomVariableConstraint: "+constraint);
		}
	}

}
