package bigraph.biged.ui.graph.parts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import bigraph.biged.model.LinkSegment;
import bigraph.biged.model.Place;
import bigraph.biged.model.Port;
import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraph.biged.ui.graph.figures.PortConnectionAnchor;

public class PlacePart extends AbstractGraphicalEditPart implements NodeEditPart
{

	private final Map<Port, ConnectionAnchor> portAnchors = new HashMap<Port, ConnectionAnchor>();

	@SuppressWarnings("unchecked")
	public ConnectionAnchor getConnectionAnchor(final Port port)
	{
		ConnectionAnchor anchor = portAnchors.get(port);
		if (anchor != null) { return anchor; }

		IFigure figure = getFigure();
		if (figure instanceof PlaceFigure)
		{
			figure = ((PlaceFigure) figure).getContainer();
		}

		anchor = new PortConnectionAnchor(figure, port, getViewer().getEditPartRegistry());

		portAnchors.put(port, anchor);

		return anchor;
	}

	/**
	 * @return the Content pane for adding or removing child figures
	 */
	@Override
	public IFigure getContentPane()
	{
		final PlaceFigure figure = (PlaceFigure) getFigure();
		return figure.getContainer();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(final ConnectionEditPart connection)
	{
		final Object model = connection.getModel();
		if (model instanceof LinkSegment)
		{
			final LinkSegment linkSegment = (LinkSegment) model;
			return getConnectionAnchor(linkSegment.getSource());
		}
		return null;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(final Request request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(final ConnectionEditPart connection)
	{
		final Object model = connection.getModel();
		if (model instanceof LinkSegment)
		{
			final LinkSegment linkSegment = (LinkSegment) model;
			return getConnectionAnchor(linkSegment.getTarget());
		}
		return null;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(final Request request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Place getPlace()
	{
		return (Place) getModel();
	}

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ConstrainedLayoutEditPolicy()
		{
			@Override
			protected Command createChangeConstraintCommand(final EditPart child, final Object constraint)
			{
				// if (!(child instanceof ResourcePart)) { return null; }
				// if (!(constraint instanceof Point)) { return null; }
				//
				// final ResourcePart resourcePart = (ResourcePart) child;
				// final Figure figure = (Figure) resourcePart.getFigure();
				// final Point oldLocation = figure.getLocation();
				// final Point newLocation = ((Point) constraint).translate(getLayoutOrigin());
				//
				// return new MoveResourceCommand(resourcePart, oldLocation, newLocation);
				return null;
			}

			@Override
			protected EditPolicy createChildEditPolicy(final EditPart child)
			{
				return new NonResizableEditPolicy();
			}

			@Override
			protected Object getConstraintFor(final Point point)
			{
				return point.getCopy();
			}

			@Override
			protected Object getConstraintFor(final Rectangle rect)
			{
				return rect.getLocation();
			}

			@Override
			protected Command getCreateCommand(final CreateRequest request)
			{
				// Point constraint = ((Point)
				// getConstraintFor(request)).translate(getLayoutOrigin());
				// return new
				// CreateResourceCommand(PhysConfPlugin.getDefault().getModel(),
				// (CreateResourceRequest) request, constraint);
				return null;
			}
		});
	}

	@Override
	protected IFigure createFigure()
	{
		return new PlaceFigure(getPlace());
	}

	@Override
	protected List<Place> getModelChildren()
	{
		return getPlace().getChildren();
	}

	@Override
	protected List<LinkSegment> getModelSourceConnections()
	{
		return getPlace().getLinkSegments(true, false);
	}

	@Override
	protected List<LinkSegment> getModelTargetConnections()
	{
		return getPlace().getLinkSegments(false, true);
	}
}