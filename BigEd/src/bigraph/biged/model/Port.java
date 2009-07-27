package bigraph.biged.model;

import java.util.Collection;
import java.util.Map;

public class Port
{
	private final bigraphspace.model.Port port;
	private final Place parent;
	private final Map<String, Link> linkMap;

	public Port(final bigraphspace.model.Port port, final Place parent, final Map<String, Link> edges)
	{
		this.port = port;
		this.parent = parent;
		this.linkMap = edges;

		if (port.getLinkName() != null && !port.getLinkName().equals(""))
		{
			Link link = linkMap.get(port.getLinkName());
			if (link == null)
			{
				link = new Link(port.getLinkName());
				linkMap.put(port.getLinkName(), link);
			}
			link.addPort(this);
		}
	}

	public Link getLink()
	{
		return linkMap.get(port.getLinkName());
	}

	public Collection<LinkSegment> getLinkSegments(final boolean source, final boolean target)
	{
		final Link link = getLink();
		if (link != null) { return link.getSegments(this, source, target); }
		return null;
	}

	public Place getPlace()
	{
		return parent;
	}

	@Override
	public String toString()
	{
		return port.getName();
	}
}