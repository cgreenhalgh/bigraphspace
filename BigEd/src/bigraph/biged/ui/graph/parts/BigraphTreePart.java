package bigraph.biged.ui.graph.parts;

import java.util.List;

import bigraph.biged.model.Bigraph;
import bigraphspace.model.Place;

public class BigraphTreePart extends AbstractBigraphTreeEditPart
{
	public BigraphTreePart(final Bigraph bigraph)
	{
		super(bigraph);
	}

	@Override
	protected List<Place> getModelChildren()
	{
		return getBigraph().getBigraph().getRoots();
	}
}