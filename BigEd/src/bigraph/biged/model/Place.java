package bigraph.biged.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bigraphspace.model.PlaceType;

public class Place
{
	private final Bigraph bigraph;
	private final bigraphspace.model.Place place;
	private final List<Place> children;
	private final List<Port> ports;
	private final Map<String, Link> edges;

	private int position;

	public Place(final Bigraph bigraph, final bigraphspace.model.Place place, final Map<String, Link> edgeMap)
	{
		this.bigraph = bigraph;
		this.place = place;
		this.edges = edgeMap;

		children = new ArrayList<Place>();
		for (final bigraphspace.model.Place child : place.getChildren())
		{
			children.add(new Place(bigraph, child, edges));
		}

		ports = new ArrayList<Port>();
		if (getType() != PlaceType.site)
		{
			for (final bigraphspace.model.Port child : place.getPorts())
			{
				ports.add(new Port(child, this, edges));
			}
		}
	}

	public Bigraph getBigraph()
	{
		return bigraph;
	}

	public List<Place> getChildren()
	{
		return children;
	}

	public String getControlName()
	{
		return place.getControlName();
	}

	public List<LinkSegment> getLinkSegments(final boolean source, final boolean target)
	{
		final List<LinkSegment> segments = new ArrayList<LinkSegment>();
		for (final Port port : ports)
		{
			segments.addAll(port.getLinkSegments(source, target));
		}
		return segments;
	}

	public List<Port> getPorts()
	{
		return ports;
	}

	public int getPosition()
	{
		return position;
	}

	public String getSupport()
	{
		return place.getSupport();
	}

	public PlaceType getType()
	{
		return place.getType();
	}

	int calculatePosition(int position)
	{
		System.err.println(getSupport() + ":" + position);
		this.position = position;
		position++;
		for (final Place place : children)
		{
			position = place.calculatePosition(position);
		}
		return position;
	}
}