package bigraph.biged.ui.graph.parts;

import java.util.List;

import org.eclipse.gef.editparts.AbstractTreeEditPart;

import bigraph.biged.model.Place;
import bigraphspace.model.PlaceType;

public class PlaceTreePart extends AbstractTreeEditPart
{
	private Place getPlace()
	{
		return (Place) getModel();
	}

	@Override
	protected List<Place> getModelChildren()
	{
		return getPlace().getChildren();
	}

	@Override
	protected String getText()
	{
		final Place place = getPlace();
		if (place.getType() == PlaceType.root)
		{
			return "root";
		}
		else if (place.getType() == PlaceType.site) { return "site"; }
		return place.getControlName() + " " + place.getSupport();
	}
}
