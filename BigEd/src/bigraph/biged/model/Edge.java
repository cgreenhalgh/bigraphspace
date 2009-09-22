package bigraph.biged.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class Edge
{
	public static void findEdges(final Place place, final Map<String, Edge> edges)
	{
		for (final Port port : place.getPorts())
		{
			Edge edge = edges.get(port.getLinkName());
			if (edge == null)
			{
				edge = new Edge(port.getLinkName());
				edges.put(edge.getName(), edge);
			}
			edge.internalAddPort(port, place);
		}

		for (final Place child : place.getChildren())
		{
			findEdges(child, edges);
		}
	}

	private final String name;
	private final Map<Port, Place> ports = new HashMap<Port, Place>();

	public Edge(final String name)
	{
		this.name = name;
	}

	public void addPort(final Port port, final Place place)
	{
		ports.put(port, place);
	}

	public String getName()
	{
		return name;
	}

	public Place getPlace(final Port port)
	{
		return ports.get(port);
	}

	public Collection<Port> getPorts()
	{
		return ports.keySet();
	}

	public void removePort(final Port port)
	{
		ports.remove(port);
	}

	private void internalAddPort(final Port port, final Place place)
	{
		ports.put(port, place);
	}

	//
	// public void updatePorts(final Iterable<Port> portList)
	// {
	// // TODO
	// }
}