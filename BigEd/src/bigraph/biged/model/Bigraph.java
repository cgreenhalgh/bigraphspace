package bigraph.biged.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bigraph
{
	//private final bigraphspace.model.Bigraph bigraph;
	private final Map<String, Link> edges = new HashMap<String, Link>();
	
	private final List<Place> roots = new ArrayList<Place>();
	
	public Bigraph(final bigraphspace.model.Bigraph bigraph)
	{
		//this.bigraph = bigraph;
		for(final bigraphspace.model.Place place: bigraph.getRoots())
		{
			roots.add(new Place(place, null, edges));
		}		
		
		for(final Link edge: edges.values())
		{
			edge.segment();
		}
	}

	public List<Place> getRoots()
	{
		return roots;
	}
}