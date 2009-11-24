package bigraph.biged.ui.graph.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEventListener;
import bigraph.biged.model.Edge;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.commands.AddPlaceCommand;
import bigraph.biged.ui.commands.CreatePortCommand;
import bigraph.biged.ui.commands.DeletePlaceCommand;
import bigraph.biged.ui.commands.DeleteRootCommand;
import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;
import bigraphspace.model.Port;

public class PlacePart extends AbstractBigraphEditPart implements BigraphEventListener, NodeEditPart
{
	public PlacePart(final Bigraph bigraph)
	{
		super(bigraph);
	}

	public BigraphPart getBigraphPart()
	{
		return (BigraphPart) getRoot().getContents();
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
		return ((Connection) connection.getFigure()).getSourceAnchor();
	}

	public ConnectionAnchor getSourceConnectionAnchor(final Request request)
	{
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(final ConnectionEditPart connection)
	{
		return ((Connection) connection.getFigure()).getTargetAnchor();
	}

	public ConnectionAnchor getTargetConnectionAnchor(final Request request)
	{
		return null;
	}

	public void onPlaceEvent(final BigraphEvent event)
	{
		if (getParent() != null)
		{
			if (event.getType() == Type.CHANGE)
			{
				getParent().refresh();
			}
		}
		refresh();
	}

	@Override
	public void refreshVisuals()
	{
		((PlaceFigure) getFigure()).refresh();
	}

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BigraphLayoutEditPolicy()
		{
			@Override
			protected Command createAddCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					final Place childPlace = (Place) child.getModel();
					return new AddPlaceCommand(getBigraph(), getPlace(), childPlace);
				}
				return null;
			}

			@Override
			protected Command createCloneCommand(final EditPart child, final EditPart after)
			{
				return null;
			}

			@Override
			protected Command createMoveChildCommand(final EditPart child, final EditPart after)
			{
				return null;
			}

			@Override
			protected Command createOrphanChildCommand(final EditPart child)
			{
				if (child.getModel() instanceof Place) { return new DeletePlaceCommand(getBigraph(), getPlace(),
						(Place) child.getModel()); }
				return null;
			}

			@Override
			protected Command getCreateCommand(final CreateRequest request)
			{
				if (request.getNewObject() instanceof Place)
				{
					final Place childPlace = (Place) request.getNewObject();
					return new AddPlaceCommand(getBigraph(), getPlace(), childPlace);
				}
				else if (request.getNewObjectType().equals(Port.class) && getPlace().getType() == PlaceType.node) { return new CreatePortCommand(
						getBigraph(), getPlace()); }
				return null;
			}

			@Override
			protected int getFeedbackIndexFor(final Request request)
			{
				if (request instanceof GroupRequest)
				{
					final GroupRequest groupRequest = ((GroupRequest) request);
					if (groupRequest.getEditParts().size() >= 1)
					{
						final EditPart part = (EditPart) groupRequest.getEditParts().get(0);
						return getIndexFor(part.getModel());
					}
				}
				else if (request instanceof CreateRequest)
				{
					final CreateRequest createRequest = (CreateRequest) request;
					final Object newObject = createRequest.getNewObject();
					return getIndexFor(newObject);
				}
				return -1;
			}

			private int getIndexFor(final Object object)
			{
				if (object instanceof Place)
				{
					final Place place = (Place) object;
					if (place.getType() == PlaceType.root) { return -1; }
					if (place.equals(getPlace())) { return -1; }
					final List<Place> list = new ArrayList<Place>(getPlace().getChildren());
					if (list.isEmpty() || list.contains(place)) { return -1; }
					list.add(place);
					Collections.sort(list, new Comparator<Place>()
					{
						public int compare(final Place o1, final Place o2)
						{
							final String s1 = BigraphLabelProvider.text(o1);
							final String s2 = BigraphLabelProvider.text(o2);
							return s1.compareTo(s2);
						}
					});
					return list.indexOf(place);
				}
				return -1;
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
					final DeletePlaceCommand deleteCommand = new DeletePlaceCommand(getBigraph(), (Place) parent,
							getPlace());
					return deleteCommand;
				}
				else if (parent instanceof Bigraph)
				{
					final DeleteRootCommand deleteCommand = new DeleteRootCommand(getBigraph(), getPlace());
					return deleteCommand;
				}
				return null;
			}
		});
	}

	@Override
	protected IFigure createFigure()
	{
		return getBigraph().getRenderer(getPlace());
		//return new PlaceFigure(getPlace());
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
	protected List<Edge> getModelSourceConnections()
	{
		return getBigraph().getEdges(getPlace());
	}

	@Override
	protected List<Edge> getModelTargetConnections()
	{
		return getBigraph().getEdges(getPlace());
	}

	public Place getPlace()
	{
		return (Place) getModel();
	}
}