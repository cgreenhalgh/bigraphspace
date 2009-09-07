package bigraph.biged.ui.graph.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import bigraph.biged.model.Place;
import bigraph.biged.ui.BigraphLabelProvider;

public class PlaceTreePart extends PlaceContainerTreeEditPart
{
	private Place getPlace()
	{
		return (Place) getModel();
	}

	@Override
	protected Image getImage()
	{
		return super.getImage();
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
	protected String getText()
	{
		return BigraphLabelProvider.text(this);
	}
}