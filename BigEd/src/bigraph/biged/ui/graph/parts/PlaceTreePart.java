package bigraph.biged.ui.graph.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import bigraph.biged.model.Bigraph;
import bigraph.biged.ui.BigraphLabelComparator;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;

public class PlaceTreePart extends AbstractBigraphTreeEditPart
{
	public PlaceTreePart(final Bigraph bigraph)
	{
		super(bigraph);
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
		
		final List ports = getPlace().getPorts();
		Collections.sort(ports, new BigraphLabelComparator());
		children.addAll(ports);
		final List places = getPlace().getChildren();
		Collections.sort(places, new BigraphLabelComparator());
		children.addAll(places);
		return children;
	}

	@Override
	protected String getText()
	{
		return BigraphLabelProvider.text(this);
	}

	private Place getPlace()
	{
		return (Place) getModel();
	}
}