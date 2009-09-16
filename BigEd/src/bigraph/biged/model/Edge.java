package bigraph.biged.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class Edge
{
	private final String name;
	private Port sourcePort;
	private Port targetPort;
	private final Map<Port, Position> ports = new HashMap<Port, Position>();
	private final Collection<EdgeSegment> segments = new HashSet<EdgeSegment>();

	static class Position
	{
		final Place place;
		final int position;
		
		Position(final Place place, final int position)
		{
			this.place = place;
			this.position = position;
		}
	}
	
	public Edge(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public Iterable<EdgeSegment> getSegments()
	{
		return segments;
	}

	public Collection<EdgeSegment> getSegments(final Port port, final boolean source, final boolean target)
	{
		final Collection<EdgeSegment> result = new HashSet<EdgeSegment>();
		for (final EdgeSegment linkSegment : segments)
		{
			if (source && linkSegment.getSource() == port)
			{
				result.add(linkSegment);
			}
			else if (target && linkSegment.getTarget() == port)
			{
				result.add(linkSegment);
			}
		}
		return result;
	}

	private boolean edgeExists(final Collection<EdgeSegment> edges, final Port sourcePort, final Port targetPort)
	{
		for (final EdgeSegment edge : edges)
		{
			if (edge.getSource() == sourcePort && edge.getTarget() == targetPort) { return true; }
			if (edge.getTarget() == sourcePort && edge.getSource() == targetPort) { return true; }
		}
		return false;
	}

	private void getEdges(final Port port, final Collection<EdgeSegment> edges, final Collection<Port> addedPorts,
			final Collection<EdgeSegment> segments)
	{
		for (final EdgeSegment edge : edges)
		{
			if (edge.getSource() == port)
			{
				if (!addedPorts.contains(edge.getTarget()))
				{
					segments.add(edge);
				}
			}
			else if (edge.getTarget() == port)
			{
				if (!addedPorts.contains(edge.getSource()))
				{
					segments.add(edge);
				}
			}
		}
	}

	private void addPort(final Port port, final Position position)
	{
		ports.put(port, position);
		if(sourcePort == null || position.position < ports.get(sourcePort).position)
		{
			sourcePort = port;
		}
		
		if(targetPort == null || position.position > ports.get(targetPort).position)
		{
			targetPort = port;
		}
	}

	// http://en.wikipedia.org/wiki/Prim's_algorithm
	public void update()
	{
		final Collection<EdgeSegment> edges = new HashSet<EdgeSegment>(ports.size() * (ports.size() - 1) / 2);

		for (final Port sourcePort : ports.keySet())
		{						
			for (final Port targetPort : ports.keySet())
			{
				if (sourcePort == targetPort)
				{
					continue;
				}
				if (edgeExists(edges, sourcePort, targetPort))
				{
					continue;
				}
				edges.add(new EdgeSegment(this, sourcePort, targetPort));
			}
		}

		final Collection<Port> addedPorts = new HashSet<Port>(ports.size());
		final Collection<Port> remainingPorts = new HashSet<Port>(ports.keySet());

		// priority queue capacity >=1
		final PriorityQueue<EdgeSegment> currentSegments = new PriorityQueue<EdgeSegment>(edges.size() > 0 ? edges
				.size() : 1, new Comparator<EdgeSegment>()
		{
			public int compare(final EdgeSegment o1, final EdgeSegment o2)
			{
				return (ports.get(o1.getTarget()).position - ports.get(o1.getSource()).position) - (ports.get(o2.getTarget()).position - ports.get(o2.getSource()).position);
			}
		});

		final Port currentPort = ports.keySet().iterator().next();
		getEdges(currentPort, edges, addedPorts, currentSegments);
		addedPorts.add(currentPort);
		remainingPorts.remove(currentPort);

		while (!remainingPorts.isEmpty())
		{			
			EdgeSegment segment;
			while (true)
			{
				segment = currentSegments.poll();
				if (!addedPorts.contains(segment.getSource()))
				{
					segments.add(segment);
					remainingPorts.remove(segment.getSource());
					addedPorts.add(segment.getSource());
					getEdges(segment.getSource(), edges, addedPorts, currentSegments);
					break;
				}
				else if (!addedPorts.contains(segment.getTarget()))
				{
					segments.add(segment);
					remainingPorts.remove(segment.getTarget());
					addedPorts.add(segment.getTarget());
					getEdges(segment.getTarget(), edges, addedPorts, currentSegments);
					break;
				}
				edges.remove(segment);
			}
		}
	}
	
	public Port getSource()
	{
		return sourcePort;
	}
	
	public Port getTarget()
	{
		return targetPort;
	}
	
	public Place getPlace(final Port port)
	{
		return ports.get(port).place;
	}
	
	public static int findEdges(final Place place, final Map<String, Edge> edges, final int currentPosition)
	{
		int position = currentPosition + 1;
		final Position thisPosition = new Position(place,position);
		for(final Port port: place.getPorts())
		{
			Edge edge = edges.get(port.getLinkName());
			if(edge == null)
			{
				edge = new Edge(port.getLinkName());
				edges.put(edge.getName(), edge);
			}
			edge.addPort(port, thisPosition);
		}		
		
		for(final Place child: place.getChildren())
		{
			position = findEdges(child, edges, position);
		}		
		
		return position;
	}	

	public Iterable<Port> getPorts()
	{
		return ports.keySet();
	}

	public void updatePorts(Iterable<Port> portList)
	{
		// TODO
	}
}
