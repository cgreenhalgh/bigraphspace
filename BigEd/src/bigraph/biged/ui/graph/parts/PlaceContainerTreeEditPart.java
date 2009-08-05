package bigraph.biged.ui.graph.parts;

import java.util.List;

import org.eclipse.gef.editparts.AbstractTreeEditPart;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;
import bigraph.biged.model.PlaceEvent;
import bigraph.biged.model.PlaceEventListener;

public class PlaceContainerTreeEditPart extends AbstractTreeEditPart implements PlaceEventListener
{
	protected PlaceContainer getContainer()
	{
		return (PlaceContainer) getModel();
	}
	
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
	
	@Override
	protected List<Place> getModelChildren()
	{
		return getContainer().getPlaces();
	}	
	

	@Override
	public void onPlaceEvent(PlaceEvent event)
	{
		if(getParent() != null)
		{
			refreshChildren();
		}
	}	
}
