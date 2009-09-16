package bigraph.biged.ui.graph.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.graphics.Image;

import bigraph.biged.model.PlaceEvent;
import bigraph.biged.model.PlaceEventListener;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;

public class PlaceTreePart extends AbstractTreeEditPart implements PlaceEventListener
{
	@Override
	public void activate()
	{
		if (!isActive())
		{
			super.activate();
			//getContainer().addPlaceEventListener(this);
		}
	}

	@Override
	public void deactivate()
	{
		if (isActive())
		{
			super.deactivate();
			//getContainer().addPlaceEventListener(this);
		}
	}	
	
	private Place getPlace()
	{
		return (Place) getModel();
	}

	@Override
	protected Image getImage()
	{
		return BigraphLabelProvider.image(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getModelChildren()
	{
		final List children = new ArrayList();
		children.addAll(getPlace().getPorts());
		children.addAll(getPlace().getChildren());
		return children;
	}

	@Override
	protected String getText()
	{
		return BigraphLabelProvider.text(this);
	}

	public void onPlaceEvent(PlaceEvent event)
	{
		if (getParent() != null)
		{
			refreshChildren();
		}		
	}
}