package bigraph.biged.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Edge
{
	private final String name;
	private final Collection<PortDetails> ports = new HashSet<PortDetails>();
	private final Collection<EdgeSegment> segments = new HashSet<EdgeSegment>();

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

	private void getEdges(final PortDetails port, final Collection<EdgeSegment> segments)
	{
		// TODO Implement
	}

	void addPort(final PortDetails port)
	{
		ports.add(port);
	}

	// http://en.wikipedia.org/wiki/Prim's_algorithm
	void segment()
	{
		final Collection<PortDetails> addedPorts = new HashSet<PortDetails>();
		final Collection<PortDetails> remainingPorts = new HashSet<PortDetails>(ports);
		final Collection<EdgeSegment> minimumTree = new HashSet<EdgeSegment>();

		// TODO Comparator
		final PriorityQueue<EdgeSegment> currentSegments = new PriorityQueue<EdgeSegment>();

		final PortDetails currentPort = ports.iterator().next();
		getEdges(currentPort, currentSegments);
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
					minimumTree.add(segment);
					remainingPorts.remove(segment.getSource());
					addedPorts.add(segment.getSource());
					getEdges(segment.getSource(), currentSegments);
					break;
				}
				else if (!addedPorts.contains(segment.getTarget()))
				{
					minimumTree.add(segment);
					remainingPorts.remove(segment.getTarget());
					addedPorts.add(segment.getTarget());
					getEdges(segment.getTarget(), currentSegments);
					break;
				}
			}
		}
	}
}
