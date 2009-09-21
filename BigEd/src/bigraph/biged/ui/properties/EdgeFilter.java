package bigraph.biged.ui.properties;

import org.eclipse.jface.viewers.IFilter;

import bigraph.biged.model.Edge;

public class EdgeFilter implements IFilter
{
	public boolean select(final Object toTest)
	{
		final Object modelObject = TypeMapper.getModelObject(toTest);
		return modelObject instanceof Edge;
	}
}
