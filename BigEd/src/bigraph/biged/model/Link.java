package bigraph.biged.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Link
{
	private final String name;
	private final Collection<Port> ports = new HashSet<Port>();
	private final Collection<LinkSegment> segments = new HashSet<LinkSegment>();

	public Link(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public Collection<LinkSegment> getSegments()
	{
		return segments;
	}

	public Collection<LinkSegment> getSegments(final Port port, final boolean source, final boolean target)
	{
		final Collection<LinkSegment> result = new HashSet<LinkSegment>();
		for (final LinkSegment linkSegment : segments)
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

	private boolean edgeExists(final Collection<LinkSegment> edges, final Port sourcePort, final Port targetPort)
	{
		for (final LinkSegment edge : edges)
		{
			if (edge.getSource() == sourcePort && edge.getTarget() == targetPort) { return true; }
			if (edge.getTarget() == sourcePort && edge.getSource() == targetPort) { return true; }
		}
		return false;
	}

	private void getEdges(final Port port, final Collection<LinkSegment> edges, final Collection<Port> addedPorts,
			final Collection<LinkSegment> segments)
	{
		for (final LinkSegment edge : edges)
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

	void addPort(final Port port)
	{
		ports.add(port);
	}

	// http://en.wikipedia.org/wiki/Prim's_algorithm
	void segment()
	{
		final Collection<LinkSegment> edges = new HashSet<LinkSegment>(ports.size() * (ports.size() - 1) / 2);

		for (final Port sourcePort : ports)
		{
			for (final Port targetPort : ports)
			{
				if (sourcePort == targetPort)
				{
					continue;
				}
				if (edgeExists(edges, sourcePort, targetPort))
				{
					continue;
				}
				edges.add(new LinkSegment(this, sourcePort, targetPort));
			}
		}

		final Collection<Port> addedPorts = new HashSet<Port>(ports.size());
		final Collection<Port> remainingPorts = new HashSet<Port>(ports);

		final PriorityQueue<LinkSegment> currentSegments = new PriorityQueue<LinkSegment>(edges.size(),
				new Comparator<LinkSegment>()
				{
					public int compare(final LinkSegment o1, final LinkSegment o2)
					{
						return o1.getLength() - o2.getLength();
					}
				});

		final Port currentPort = ports.iterator().next();
		getEdges(currentPort, edges, addedPorts, currentSegments);
		addedPorts.add(currentPort);
		remainingPorts.remove(currentPort);

		while (!remainingPorts.isEmpty())
		{
			LinkSegment segment;
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
}
