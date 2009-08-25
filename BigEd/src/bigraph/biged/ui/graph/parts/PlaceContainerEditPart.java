package bigraph.biged.ui.graph.parts;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;
import bigraph.biged.model.PlaceEvent;
import bigraph.biged.model.PlaceEventListener;
import bigraph.biged.ui.commands.AddPlaceCommand;
import bigraph.biged.ui.commands.DeletePlacesCommand;
import bigraph.biged.ui.commands.MovePlaceCommand;

public abstract class PlaceContainerEditPart extends AbstractGraphicalEditPart implements PlaceEventListener
{
	@Override
	public void activate()
	{
		if (!isActive())
		{
			super.activate();
			getContainer().addPlaceEventListener(this);
		}
	}

	@Override
	public void deactivate()
	{
		if (isActive())
		{
			super.deactivate();
			getContainer().addPlaceEventListener(this);
		}
	}

	public void onPlaceEvent(final PlaceEvent event)
	{
		if (getParent() != null)
		{
			refreshChildren();
		}
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
					if (!getContainer().canAdd(childPlace)) { return null; }
					if (after == null)
					{
						return new AddPlaceCommand(getContainer(), childPlace, null);
					}
					else if (after.getModel() instanceof Place) { return new AddPlaceCommand(getContainer(),
							childPlace, (Place) after.getModel()); }
				}
				return null;
			}

			protected Command createCloneCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					final Place childPlace = (Place) child.getModel();
					if (!getContainer().canAdd(childPlace)) { return null; }
					if (after == null)
					{
						return new AddPlaceCommand(getContainer(), childPlace.clone(), null);
					}
					else if (after.getModel() instanceof Place) { return new AddPlaceCommand(getContainer(), childPlace
							.clone(), (Place) after.getModel()); }
				}
				return null;
			}

			@Override
			protected Command createMoveChildCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					if (after != null && after.getModel() instanceof Place)
					{
						return new MovePlaceCommand(getContainer(), (Place) child.getModel(), (Place) after.getModel());
					}
					else
					{
						return new MovePlaceCommand(getContainer(), (Place) child.getModel(), null);
					}
				}

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
				final EditPart after = getInsertionReference(request);
				if (request.getNewObject() instanceof Place)
				{
					final Place childPlace = (Place) request.getNewObject();
					if (!getContainer().canAdd(childPlace)) { return null; }
					if (after == null)
					{
						return new AddPlaceCommand(getContainer(), childPlace, null);
					}
					else if (after.getModel() instanceof Place) { return new AddPlaceCommand(getContainer(),
							childPlace, (Place) after.getModel()); }
				}
				return null;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Command getOrphanChildrenCommand(final Request request)
			{
				final Collection<EditPart> parts = ((GroupRequest) request).getEditParts();
				final Collection<Place> places = new HashSet<Place>();
				for (final EditPart part : parts)
				{
					if (!(part.getModel() instanceof Place)) { return null; }
					places.add((Place) part.getModel());
				}
				final DeletePlacesCommand deleteCommand = new DeletePlacesCommand(getContainer(), places);
				return deleteCommand;
			}
		});
	}

	protected PlaceContainer getContainer()
	{
		return (PlaceContainer) getModel();
	}

	@Override
	protected List<Place> getModelChildren()
	{
		return getContainer().getPlaces();
	}
}