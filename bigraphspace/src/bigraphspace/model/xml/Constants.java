/**
 * 
 */
package bigraphspace.model.xml;

/** XML model constants
 * 
 * @author cmg
 *
 */
public class Constants {
	/** root element name, e.g. wide bigraph (bigraph) */
	public static final String BIGRAPH_ELEMENT_NAME = "bigraph";
	/** region (prime) element name (region) */
	public static final String ROOT_ELEMENT_NAME = "root";
	/** site element name (hole) */
	public static final String SITE_ELEMENT_NAME = "site";
	/** site index attribute name (index) */
	public static final String SITE_INDEX_ATTRIBUTE_NAME = "index";
	/** site index attribute name (index) */
	public static final String NODE_SUPPORT_ATTRIBUTE_NAME = "_support";
	/** edge element name */
	public static final String EDGE_ELEMENT_NAME = "edge";
	/** hide element name */
	public static final String HIDE_ELEMENT_NAME = "hide";
	/** inner name element name */
	public static final String INNERNAME_ELEMENT_NAME = "innername";
	/** edge/hide/innername link name attribute, id */
	public static final String LINK_NAME_ATTRIBUTE_NAME = "id";
	/** innername link name attribute, name */
	public static final String INNERNAME_NAME_ATTRIBUTE_NAME = "name";
	/** index element name */
	public static final String INDEX_ELEMENT_NAME = "index";
	/** index variable name attribute, variable */
	public static final String INDEX_VARIABLE_ATTRIBUTE_NAME = "variable";
	/** variable node element name, node */
	public static final String VARIABLE_NODE_ELEMENT_NAME = "node";
	/** variable node control name attribute name, _control */
	public static final String VARIABLE_NODE_CONTROL_ATTRIBUTE_NAME = "_control";
	/** variable node control variable name attribute name, _control */
	public static final String VARIABLE_NODE_VARIABLE_ATTRIBUTE_NAME = "_variable";
	/** variable element name */
	public static final String VARIABLE_ELEMENT_NAME = "variable";
	/** variable base type attribute name, type */
	public static final String VARIABLE_BASE_TYPE_ATTRIBUTE_NAME = "type";
	/** variable name attribute name, name */
	public static final String VARIABLE_NAME_ATTRIBUTE_NAME = "name";
	/** constraint element name, constraint */
	public static final String CONSTRAINT_ELEMENT_NAME = "constraint";
	/** constraint type attribute name, type */
	public static final String CONSTRAINT_TYPE_ATTRIBUTE_NAME = "type";
	/** constraint oneof element name, oneof */
	public static final String ONEOF_ATTRIBUTE_VALUE = "oneof";
	/** constraint notoneof element name, notoneof */
	public static final String NOTONEOF_ATTRIBUTE_VALUE = "notoneof";
	/** constraint value element name, value */
	public static final String VALUE_ELEMENT_NAME = "value";
	/** constraint minvalue element name, minvalue */
	public static final String MINVALUE_ATTRIBUTE_VALUE = "minvalue";
	/** constraint maxvalue element name, maxvalue */
	public static final String MAXVALUE_ATTRIBUTE_VALUE = "maxvalue";
	/** constraint minlength element name, minlength */
	public static final String MINLENGTH_ATTRIBUTE_VALUE = "minlength";
	/** constraint maxlength element name, maxlength */
	public static final String MAXLENGTH_ATTRIBUTE_VALUE = "maxlength";
	/** constraint difference element name, difference */
	public static final String DIFFERENCE_ATTRIBUTE_VALUE = "difference";
	/** constraint difference variable attribute name, variable */
	public static final String CONSTRAINT_VARIABLE_ATTRIBUTE_NAME = "variable";
	/** constraint regexp element name, regexp*/
	public static final String REGEXP_ATTRIBUTE_VALUE = "regexp";
}
