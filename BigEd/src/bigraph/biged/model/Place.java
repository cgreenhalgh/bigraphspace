package bigraph.biged.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import bigraphspace.model.PlaceType;

public class Place extends PlaceContainer
{
	private final Bigraph bigraph;
	final bigraphspace.model.Place place;
	private final List<Port> ports;
	private final Map<String, Link> edges;

	private int position;

	public Place(final Bigraph bigraph, final bigraphspace.model.Place place, final Map<String, Link> edgeMap)
	{
		this.bigraph = bigraph;
		this.place = place;
		this.edges = edgeMap;

		final List<Place> places = getPlaces();
		for (final bigraphspace.model.Place child : place.getChildren())
		{
			places.add(new Place(bigraph, child, edges));
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
		for (final Place place : getPlaces())
		{
			position = place.calculatePosition(position);
		}
		return position;
	}

	public boolean remove(final Place child)
	{
		place.removeChild(child.place);
		return super.remove(child);
	}

	@Override
	public boolean removeAll(Collection<? extends Place> collection)
	{
		for(final Place child: collection)
		{
			place.removeChild(child.place);
		}
		return super.removeAll(collection);
	}

	public boolean add(final Place child)
	{
		place.addChild(child.place);
		return super.add(child);
	}
	
	public void add(final int index, final Place child)
	{
		place.insertChild(child.place, index);
		super.add(index, child);
	}
}