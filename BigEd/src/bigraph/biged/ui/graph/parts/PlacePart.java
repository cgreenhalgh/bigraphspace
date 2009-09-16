package bigraph.biged.ui.graph.parts;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Edge;
import bigraph.biged.model.EdgeSegment;
import bigraph.biged.model.PlaceEvent;
import bigraph.biged.model.PlaceEventListener;
import bigraph.biged.model.PlaceEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.commands.AddPlaceCommand;
import bigraph.biged.ui.commands.DeletePlaceCommand;
import bigraph.biged.ui.commands.DeleteRootCommand;
import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraph.biged.ui.graph.figures.PortConnectionAnchor;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class PlacePart extends AbstractGraphicalEditPart implements PlaceEventListener, NodeEditPart
{
	@Override
	public void activate()
	{
		if (isActive()) { return; }
		System.out.println("Activate " + BigraphLabelProvider.text(getModel()));
		PlaceEvent.addListener(getPlace(), this);
		super.activate();
	}

	@Override
	public void deactivate()
	{
		if (!isActive()) { return; }
		System.out.println("Deactivate " + BigraphLabelProvider.text(getModel()));
		PlaceEvent.removeListener(getPlace(), this);
		super.deactivate();
	}

	public BigraphPart getBigraphPart()
	{
		return (BigraphPart) getRoot().getContents();
	}

	@SuppressWarnings("unchecked")
	public ConnectionAnchor getConnectionAnchor(final Port port)
	{
		PortConnectionAnchor anchor = PortConnectionAnchor.getAnchor(port);
		if (anchor != null) { return anchor; }

		IFigure figure = getFigure();
		if (figure instanceof PlaceFigure)
		{
			figure = ((PlaceFigure) figure).getContainer();
		}

		anchor = new PortConnectionAnchor(figure, port, getBigraphPart(), getViewer().getEditPartRegistry());

		PortConnectionAnchor.addAnchor(port, anchor);

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

	public ConnectionAnchor getSourceConnectionAnchor(final ConnectionEditPart connection)
	{
		final Object model = connection.getModel();
		if (model instanceof Edge)
		{
			final Edge linkSegment = (Edge) model;
			return getConnectionAnchor(linkSegment.getSource());
		}
		return null;
	}

	public ConnectionAnchor getSourceConnectionAnchor(final Request request)
	{
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(final ConnectionEditPart connection)
	{
		final Object model = connection.getModel();
		if (model instanceof Edge)
		{
			final Edge linkSegment = (Edge) model;
			return getConnectionAnchor(linkSegment.getTarget());
		}
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(final Request request)
	{
		return null;
	}

	public void onPlaceEvent(final PlaceEvent event)
	{
		if (getParent() != null)
		{
			if (event.getType() == Type.ADD || event.getType() == Type.REMOVE)
			{
				refreshChildren();
			}
			else if (event.getType() == Type.CHANGE)
			{
				getParent().refresh();
				refreshVisuals();
			}
		}
	}

	@Override
	public void refreshVisuals()
	{
		((PlaceFigure) getFigure()).refresh();
	}

	private Place getPlace()
	{
		return (Place) getModel();
	}

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new FlowLayoutEditPolicy()
		{
			@Override
			public Command getCommand(final Request request)
			{
				System.err.println("Request " + request.getType());
				return super.getCommand(request);
			}

			@Override
			protected Command createAddCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					final Place childPlace = (Place) child.getModel();
					return new AddPlaceCommand(getPlace(), childPlace);
				}
				return null;
			}

			protected Command createCloneCommand(final EditPart child, final EditPart after)
			{
				return null;
			}

			@Override
			protected Command createMoveChildCommand(final EditPart child, final EditPart after)
			{
				return null;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Command getCloneCommand(final ChangeBoundsRequest request)
			{
				final List<EditPart> editParts = request.getEditParts();
				final CompoundCommand command = new CompoundCommand();
				for (final EditPart child : editParts)
				{
					command.add(createCloneCommand(child, getInsertionReference(request)));
				}
				return command.unwrap();
			}

			@Override
			protected Command getCreateCommand(final CreateRequest request)
			{
				if (request.getNewObject() instanceof Place)
				{
					final Place childPlace = (Place) request.getNewObject();
					return new AddPlaceCommand(getPlace(), childPlace);
				}
				return null;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Command getOrphanChildrenCommand(final Request request)
			{
				final Collection<EditPart> parts = ((GroupRequest) request).getEditParts();
				if (parts.size() == 0) { return null; }
				if (parts.size() > 1)
				{
					System.err.println("Multiple delete requests!");
				}

				final EditPart part = parts.iterator().next();
				final Object model = part.getModel();
				if (model instanceof Place)
				{
					final DeletePlaceCommand deleteCommand = new DeletePlaceCommand(getPlace(), (Place) model);
					return deleteCommand;
				}
				return null;
			}
		});

		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy()
		{
			@Override
			protected Command createDeleteCommand(final GroupRequest request)
			{
				final Object parent = getParent().getModel();
				if (parent instanceof Place)
				{
					final DeletePlaceCommand deleteCommand = new DeletePlaceCommand((Place) parent, getPlace());
					return deleteCommand;
				}
				else if (parent instanceof Bigraph)
				{
					final DeleteRootCommand deleteCommand = new DeleteRootCommand((Bigraph) parent, getPlace());
					return deleteCommand;
				}
				return null;
			}
		});

		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DirectEditPolicy()
		{
			@Override
			protected Command getDirectEditCommand(final DirectEditRequest request)
			{
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected void showCurrentEditValue(final DirectEditRequest request)
			{

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
		final List<Place> list = getPlace().getChildren();
		Collections.sort(list, new Comparator<Place>()
		{
			public int compare(final Place o1, final Place o2)
			{
				final String s1 = BigraphLabelProvider.text(o1);
				final String s2 = BigraphLabelProvider.text(o2);
				return s1.compareTo(s2);
			}
		});
		return list;
	}

	@Override
	protected List<EdgeSegment> getModelSourceConnections()
	{
		return getBigraphPart().getEdgeSegments(getPlace(), true, false);
		//return getBigraphPart().getEdges(getPlace());
	}

	@Override
	protected List<EdgeSegment> getModelTargetConnections()
	{
		return getBigraphPart().getEdgeSegments(getPlace(), false, true);		
		//return getBigraphPart().getEdges(getPlace());
	}
}