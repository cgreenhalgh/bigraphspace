package bigraph.biged.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class Edge
{
	public static void findEdges(final Bigraph bigraph, final Place place, final Map<String, Edge> edges)
	{
		for (final Port port : place.getPorts())
		{
			Edge edge = edges.get(port.getLinkName());
			if (edge == null)
			{
				edge = new Edge(bigraph, port.getLinkName());
				edges.put(edge.getName(), edge);
			}
			edge.internalAddPort(port, place);
		}

		for (final Place child : place.getChildren())
		{
			findEdges(bigraph, child, edges);
		}
	}

	private final String name;
	private final Bigraph bigraph;
	private final Map<Port, Place> ports = new HashMap<Port, Place>();

	public Edge(final Bigraph bigraph, final String name)
	{
		this.bigraph = bigraph;
		this.name = name;
	}

	public void addPort(final Port port, final Place place)
	{
		ports.put(port, place);
		bigraph.fireEvent(new BigraphEvent(this, port, BigraphEvent.Type.ADD));
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
		bigraph.fireEvent(new BigraphEvent(this, port, BigraphEvent.Type.REMOVE));
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