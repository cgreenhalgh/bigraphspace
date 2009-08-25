package bigraph.biged.ui.properties;

import org.eclipse.jface.viewers.IFilter;

import bigraph.biged.model.Place;
import bigraphspace.model.PlaceType;

public class NodeFilter implements IFilter
{
	public boolean select(Object toTest)
	{
		return toTest instanceof Place && ((Place)toTest).getType() == PlaceType.node;
	}
}
