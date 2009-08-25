package bigraph.biged.ui.graph.parts;

import java.util.List;

import org.eclipse.gef.editparts.AbstractTreeEditPart;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;
import bigraph.biged.model.PlaceEvent;
import bigraph.biged.model.PlaceEventListener;

public class PlaceContainerTreeEditPart extends AbstractTreeEditPart implements PlaceEventListener
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