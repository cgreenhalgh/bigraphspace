package bigraph.biged.ui.graph.parts;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.LinkSegment;
import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;
import bigraph.biged.model.Port;
import bigraph.biged.ui.commands.AddPlaceCommand;
import bigraph.biged.ui.commands.DeletePlacesCommand;
import bigraph.biged.ui.commands.MovePlaceCommand;
import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraph.biged.ui.graph.figures.PortConnectionAnchor;

public class PlacePart extends PlaceContainerEditPart implements NodeEditPart
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
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy()
		{
			@SuppressWarnings("unchecked")
			@Override
			protected Command createDeleteCommand(final GroupRequest request)
			{
				final PlaceContainer parent = (PlaceContainer) getHost().getParent().getModel();
				final Collection<EditPart> parts = request.getEditParts();
				final Collection<Place> places = new HashSet<Place>();
				for(final EditPart part: parts)
				{
					if(!(part.getModel() instanceof Place))
					{
						return null;
					}
					places.add((Place) part.getModel());
				}
				final DeletePlacesCommand deleteCommand = new DeletePlacesCommand(parent, places);
				return deleteCommand;
			}			
		});
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new FlowLayoutEditPolicy()
		{
			@Override
			protected Command getCreateCommand(CreateRequest request)
			{
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Command getCommand(Request request)
			{
				System.err.println("Request " + request.getType());
				return super.getCommand(request);
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Command getOrphanChildrenCommand(Request request)
			{
				final Collection<EditPart> parts = ((GroupRequest)request).getEditParts();
				final Collection<Place> places = new HashSet<Place>();
				for(final EditPart part: parts)
				{
					if(!(part.getModel() instanceof Place))
					{
						return null;
					}
					places.add((Place) part.getModel());
				}
				final DeletePlacesCommand deleteCommand = new DeletePlacesCommand(getContainer(), places);
				return deleteCommand;
			}

			@Override
			protected Command createMoveChildCommand(EditPart child, EditPart after)
			{
				if(child.getModel() instanceof Place && after != null && after.getModel() instanceof Place)
				{
					return new MovePlaceCommand(getContainer(), (Place)child.getModel(), (Place)after.getModel());						
				}
				
				return null;
			}
			
			@Override
			protected Command createAddCommand(EditPart child, EditPart after)
			{
				if(child.getModel() instanceof Place)
				{
					if(after == null)
					{
						return new AddPlaceCommand(getContainer(), (Place)child.getModel(), null);						
					}
					else if(after.getModel() instanceof Place)
					{
						return new AddPlaceCommand(getContainer(), (Place)child.getModel(), (Place)after.getModel());						
					}
				}
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