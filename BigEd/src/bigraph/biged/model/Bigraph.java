package bigraph.biged.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bigraphspace.api.BigraphChangedEvent;
import bigraphspace.api.BigraphChangedListener;
import bigraphspace.api.ReactiveBigraph;

public class Bigraph extends PlaceContainer
{
	private final bigraphspace.model.Bigraph bigraph;
	private final Map<String, Link> edges = new HashMap<String, Link>();

	public Bigraph(final bigraphspace.model.Bigraph bigraph)
	{
		this.bigraph = bigraph;
		if(bigraph instanceof ReactiveBigraph)
		{
			((ReactiveBigraph)bigraph).addBigraphChangedListener(new BigraphChangedListener()
			{
				
				@Override
				public void bigraphChanged(BigraphChangedEvent bce)
				{
					// TODO Auto-generated method stub
					
				}
			});
		}
		final List<Place> places = getPlaces();
		for (final bigraphspace.model.Place place : bigraph.getRoots())
		{
			places.add(new Place(this, place, edges));
		}

		calculatePositions();

		for (final Link edge : edges.values())
		{
			edge.segment();
		}

	}

	private void calculatePositions()
	{
		int position = 1;
		for (final Place root : getPlaces())
		{
			position = root.calculatePosition(position);
		}
	}

	@Override
	public boolean remove(final Place child)
	{
		bigraph.removeRoot(child.place);
		return super.remove(child);
	}

	@Override
	public boolean add(final Place child)
	{
		bigraph.addRoot(child.place);	
		return super.add(child);
	}
}