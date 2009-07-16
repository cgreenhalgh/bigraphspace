package bigraph.biged.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class BigraphModel
{
	private final Bigraph bigraph;
	private final Map<String, Edge> edges = new HashMap<String, Edge>();
	private final Map<Port, PortDetails> ports = new HashMap<Port, PortDetails>();
	
	public BigraphModel(final Bigraph bigraph)
	{
		this.bigraph = bigraph;
	}
	
	public Edge getEdge(final String edgeName)
	{
		return edges.get(edgeName);
	}
	
	public void updateEdges()
	{
		final Stack<Place> parents = new Stack<Place>();		
		for(final Place place: getRoots())
		{
			addEdges(place, parents);
		}
	}
	
	private void addEdges(final Place place, final Stack<Place> parents)
	{
		parents.push(place);
		for(final Place child: place.getChildren())
		{
			addEdges(child, parents);
		}
		
		for(final Port port: place.getPorts())
		{
			Edge edge = null;
			final String linkName = port.getLinkName();
			if(linkName != null && !linkName.equals(""))
			{
				edge = edges.get(linkName);
				if(edge == null)
				{
					edge = new Edge(linkName);
					edges.put(linkName, edge);
				}
				
			}
			
			PortDetails portDetails = ports.get(port);
			if(portDetails == null)
			{
				portDetails = new PortDetails(port);
				ports.put(port, portDetails);
			}
			portDetails.updatePosition(parents);
			portDetails.setEdge(edge);
		}
		parents.pop();
	}
	
	public List<Place> getRoots()
	{
		return bigraph.getRoots();
	}
}