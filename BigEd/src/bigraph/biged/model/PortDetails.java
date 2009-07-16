package bigraph.biged.model;

import java.util.ArrayList;
import java.util.List;

import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class PortDetails
{
	private final Port port;
	private Edge edge;
	private final List<Place> parents = new ArrayList<Place>();
	
	public PortDetails(final Port port)
	{
		this.port = port;
	}
	
	int getDistance(final PortDetails destinationPort)
	{
		final int minLength = Math.min(parents.size(), destinationPort.parents.size());
		int depth ;
		for(depth = 0; depth < minLength; depth++)
		{
			if(parents.get(depth) != destinationPort.parents.get(depth))
			{
				break;
			}
		}
		
		return (parents.size() - depth) + (destinationPort.parents.size() - depth);
	}
	
	void updatePosition(final List<Place> parents)
	{
		this.parents.clear();
		this.parents.addAll(parents);
	}
	
	void setEdge(final Edge edge)
	{
		this.edge = edge;
	}
}
