/**
 * 
 */
package bigraphspace.model;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.Map;
import bigraphspace.io.IOFactory;

/** Abstract bigraph interface. Implementation-independent.
 * See bigraphspace.io.IOFactory interface for IO methods.
 * 
 * @author cmg
 *
 */
public interface Bigraph extends IOFactory {
	/** get root(s) */
	public List<Place> getRoots();
	/** clear (roots) */
	public void clear();
	/** add root, at end (if allowed) */
	public void addRoot(Place root);
	/** remove root (if allowed) */
	public void removeRoot(Place root);
	/** insert root (if allowed) */
	public void insertRoot(Place root, int atIndex);

	/** signature associated with this bigraph */
	public BasicSignature getSignature();
	/** set/update signature (if allowed) */
	public void setSignature(BasicSignature signature);
	/** create a new root to be used with this bigraph */
	public Place createRoot();
	/** create a new node to be used with this bigraph */
	public Place createNode(String controlName);
	/** create a new node to be used with this bigraph */
	public Place createNode(Control control);
	/** create a new site to be used with this bigraph */
	public Place createSite();
	/** create a new port to be used with this bigraph */
	public Port createPort(final String name);	
	/** create variable definition */
	public VariableDefinition createVariableDefinition(String variableName, VariableType baseType);
	/** create variable constraint */
	public VariableConstraint createVariableConstraint(String otherVariable, VariableConstraintType constraintType, List<Object> values);
	/** create a new index value to be used with this bigraph */
	public IndexValue createIndexValue(Object value);
	/** create a new index variable value to be used with this bigraph */
	public IndexValue createIndexVariable(String variableName);
	/** convenience getter for Control (via Signature).
	 * 
	 * @return null for root or site.
	 * */
	public Control getControl(Place node);
	/** get edge names */
	public Set<String> getEdgeNames();
	/** add edge name (if allowed) */
	public void addEdge(String name);
	/** remove edge name (if allowed) */
	public void removeEdge(String name);
	/** get "hidden" names, i.e. non-inner names */
	public Set<String> getHiddenNames();
	/** add "hidden" name (if allowd) */
	public void addHidden(String name);
	/** remove edge name (if allowed) */
	public void removeHidden(String name);
	/** innername(s) (only) that should be mapped to another edge/outername.
	 * the rewriting occurs at the "bottom" of the graph, i.e. the inner name is
	 * not visible in the rest of the bigraph but the name it maps to is.
	 * If the name it maps to is "" then this corresponds to a new name. 
	 * The edge name IS visible as an inner name unless "hidden".
	 * Mainly useful in the reactum of a reaction rule. */
	public Map<String,String> getInnerNameMap();
	/** unspecified/new edge "name" */
	public static final String UNSPECIFIED_EDGE_NAME = "";
	/** add innername mapping */
	public void addInnerNameMapping(String innnerName, String edge);
	/** remove name from innername mapping */
	public void removeInnerNameMapping(String innnerName);

	/** variables, used in control and bigraph expressions.
	 * E.g. for pattern or reaction rules over place-encoded numbers or other
	 * indexed control sets.
	 */
	public Map<String,VariableDefinition> getVariables();
	/** add variable (if allowed) */
	public void addVariable(String name, VariableDefinition definition);
	/** remove variable (by name) (if allowed) */
	public void removeVariable(String name);
	/** is expression, i.e. has variables */
	public boolean isExpression();
	
	/** dump - debug */
	public void dump(PrintStream ps);
	/** dump - debug */
	public void dump(PrintWriter pw);
}
