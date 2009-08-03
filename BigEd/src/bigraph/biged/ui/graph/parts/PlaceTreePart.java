package bigraph.biged.ui.graph.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import bigraph.biged.model.Place;
import bigraphspace.model.PlaceType;

public class PlaceTreePart extends PlaceContainerTreeEditPart
{
	private Place getPlace()
	{
		return (Place) getModel();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getModelChildren()
	{
		final List children = new ArrayList();
		children.addAll(getPlace().getPorts());
		children.addAll(getPlace().getPlaces());
		return children;
	}

	@Override
	protected Image getImage()
	{
		return super.getImage();
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