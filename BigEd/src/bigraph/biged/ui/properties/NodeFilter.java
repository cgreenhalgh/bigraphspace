package bigraph.biged.ui.properties;

import org.eclipse.jface.viewers.IFilter;

import bigraph.biged.model.Place;
import bigraphspace.model.PlaceType;

public class NodeFilter implements IFilter
{
	public boolean select(final Object toTest)
	{
		final Object modelObject = TypeMapper.getModelObject(toTest);
		return modelObject instanceof Place && ((Place) modelObject).getType() == PlaceType.node;
	}
}
