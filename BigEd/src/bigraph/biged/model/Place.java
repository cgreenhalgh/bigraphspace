package bigraph.biged.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bigraphspace.model.IndexValue;
import bigraphspace.model.PlaceType;

public class Place extends PlaceContainer
{
	final Bigraph bigraph;
	final bigraphspace.model.Place place;
	private final List<Port> ports = new ArrayList<Port>();

	private int position;

	public Place(final Bigraph bigraph, final bigraphspace.model.Place place)
	{
		this.bigraph = bigraph;
		this.place = place;

		final List<Place> places = getPlaces();
		for (final bigraphspace.model.Place child : place.getChildren())
		{
			places.add(new Place(bigraph, child));
		}

		if (getType() != PlaceType.site)
		{
			for (final bigraphspace.model.Port child : place.getPorts())
			{
				ports.add(new Port(child, this, bigraph.edges));
			}
		}
	}

	public Place(final Bigraph bigraph, final PlaceType type)
	{
		this.bigraph = bigraph;
		if (type == PlaceType.root)
		{
			this.place = bigraph.bigraph.createRoot();
		}
		else if (type == PlaceType.site)
		{
			this.place = bigraph.bigraph.createSite();
		}
		else
		{
			this.place = bigraph.bigraph.createNode("node");
		}
	}

	@Override
	public void add(final int index, final Place child)
	{
		System.out.println("Insert child at " + index);
		place.insertChild(child.place, index + 1);
		super.add(index, child);
	}

	@Override
	public boolean add(final Place child)
	{
		place.addChild(child.place);
		return super.add(child);
	}

	@Override
	public Place clone()
	{
		// TODO Fix clone
		return new Place(bigraph, place);
	}

	public Bigraph getBigraph()
	{
		return bigraph;
	}

	public String getControlName()
	{
		return place.getControlName();
	}
	
	public void setControlName(final String name)
	{
		place.setControlName(name);
		firePlaceEvent(new PlaceEvent(this));		
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
	
	public List<IndexValue> getControlIndexes()
	{
		return place.getControlIndexes();
	}

	public Integer getSiteIndex()
	{
		return place.getSiteIndex();
	}

	public String getSupport()
	{
		return place.getSupport();
	}

	public PlaceType getType()
	{
		return place.getType();
	}

	@Override
	public boolean remove(final Place child)
	{
		place.removeChild(child.place);
		return super.remove(child);
	}

	@Override
	public boolean removeAll(final Collection<? extends Place> collection)
	{
		for (final Place child : collection)
		{
			place.removeChild(child.place);
		}
		return super.removeAll(collection);
	}

	int calculatePosition(int position)
	{
		System.err.println(getSupport() + "@" + position);
		this.position = position;
		position++;
		for (final Place place : getPlaces())
		{
			position = place.calculatePosition(position);
		}
		return position;
	}

	public void setSupport(final String value)
	{
		place.setSupport(value);
		firePlaceEvent(new PlaceEvent(this));
	}
}