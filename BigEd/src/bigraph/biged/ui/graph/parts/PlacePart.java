package bigraph.biged.ui.graph.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEventListener;
import bigraph.biged.model.Edge;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.commands.AddPlaceCommand;
import bigraph.biged.ui.commands.DeletePlaceCommand;
import bigraph.biged.ui.commands.DeleteRootCommand;
import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

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
					return new AddPlaceCommand(getBigraph(), getPlace(), childPlace);
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
					return new AddPlaceCommand(getBigraph(), getPlace(), childPlace);
				}
				return null;
			}

			private int getIndexFor(final Place place)
			{
				if(place.getType() == PlaceType.root) { return -1; }
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
			
			@Override
			protected int getFeedbackIndexFor(final Request request)
			{
				if (request instanceof GroupRequest)
				{
					final GroupRequest groupRequest = ((GroupRequest) request);
					if (groupRequest.getEditParts().size() == 1)
					{
						final EditPart part = (EditPart) groupRequest.getEditParts().get(0);
						if (part.getModel() instanceof Place)
						{
							return getIndexFor((Place) part.getModel());
						}
					}
				}
				else if(request instanceof CreateRequest)
				{
					final CreateRequest createRequest = (CreateRequest)request;
					Object newObject = createRequest.getNewObject();
					if(newObject instanceof Place)
					{
						return getIndexFor((Place) newObject);				
					}
				}
				return super.getFeedbackIndexFor(request);
			}

			/**
			 * @see OrderedLayoutEditPolicy#getInsertionReference(Request)
			 */
			@Override
			protected EditPart getInsertionReference(final Request request)
			{
				final int index = getFeedbackIndexFor(request);
				if (index >= getHost().getChildren().size()) { return null; }
				return super.getInsertionReference(request);
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Command getOrphanChildrenCommand(final Request request)
			{
				final Collection<EditPart> parts = ((GroupRequest) request).getEditParts();
				if (parts.size() == 0) { return null; }

				final CompoundCommand command = new CompoundCommand("Orphan Children");
				for (final EditPart part : parts)
				{
					final Object model = part.getModel();
					if (model instanceof Place)
					{
						final DeletePlaceCommand deleteCommand = new DeletePlaceCommand(getBigraph(), getPlace(),
								(Place) model);
						command.add(deleteCommand);
					}
				}
				if (command.isEmpty()) { return null; }
				return command;
			}

			@Override
			protected void showLayoutTargetFeedback(final Request request)
			{
				if (getHost().getChildren().size() == 0) { return; }
				int epIndex = getFeedbackIndexFor(request);
				if (epIndex == -1) { return; }
				final Polyline fb = getLineFeedback();
				final Transposer transposer = new Transposer();
				transposer.setEnabled(!isHorizontal());

				boolean before = true;
				Rectangle r = null;
				if (epIndex >= getHost().getChildren().size())
				{
					before = false;
					epIndex--;
				}
				final EditPart editPart = (EditPart) getHost().getChildren().get(epIndex);
				r = transposer.t(getAbsoluteBounds((GraphicalEditPart) editPart));

				int x = Integer.MIN_VALUE;
				if (before)
				{
					/*
					 * Want the line to be halfway between the end of the previous and the beginning
					 * of this one. If at the begining of a line, then start halfway between the
					 * left edge of the parent and the beginning of the box, but no more than 5
					 * pixels (it would be too far and be confusing otherwise).
					 */
					if (epIndex > 0)
					{
						// Need to determine if a line break.
						final Rectangle boxPrev = transposer.t(getAbsoluteBounds((GraphicalEditPart) getHost()
								.getChildren().get(epIndex - 1)));
						final int prevRight = boxPrev.right();
						if (prevRight < r.x)
						{
							// Not a line break
							x = prevRight + (r.x - prevRight) / 2;
						}
						else if (prevRight == r.x)
						{
							x = prevRight + 1;
						}
					}
					if (x == Integer.MIN_VALUE)
					{
						// It is a line break.
						final Rectangle parentBox = transposer.t(getAbsoluteBounds((GraphicalEditPart) getHost()));
						x = r.x - 5;
						if (x < parentBox.x)
						{
							x = parentBox.x + (r.x - parentBox.x) / 2;
						}
					}
				}
				else
				{
					/*
					 * We only have before==false if we are at the end of a line, so go halfway
					 * between the right edge and the right edge of the parent, but no more than 5
					 * pixels.
					 */
					final Rectangle parentBox = transposer.t(getAbsoluteBounds((GraphicalEditPart) getHost()));
					final int rRight = r.x + r.width;
					final int pRight = parentBox.x + parentBox.width;
					x = rRight + 5;
					if (x > pRight)
					{
						x = rRight + (pRight - rRight) / 2;
					}
				}
				Point p1 = new Point(x, r.y - 4);
				p1 = transposer.t(p1);
				fb.translateToRelative(p1);
				Point p2 = new Point(x, r.y + r.height + 4);
				p2 = transposer.t(p2);
				fb.translateToRelative(p2);
				fb.setPoint(p1, 0);
				fb.setPoint(p2, 1);
			}

			private Rectangle getAbsoluteBounds(final GraphicalEditPart ep)
			{
				final Rectangle bounds = ep.getFigure().getBounds().getCopy();
				ep.getFigure().translateToAbsolute(bounds);
				return bounds;
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
	protected List<Edge> getModelSourceConnections()
	{
		return getBigraph().getEdges(getPlace());
	}

	@Override
	protected List<Edge> getModelTargetConnections()
	{
		return getBigraph().getEdges(getPlace());
	}

	private Place getPlace()
	{
		return (Place) getModel();
	}
}