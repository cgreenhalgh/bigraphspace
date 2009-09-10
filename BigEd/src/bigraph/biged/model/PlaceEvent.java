package bigraph.biged.model;

import java.util.Collection;
import java.util.Collections;

public class PlaceEvent
{
	public enum Type
	{
		ADD, REMOVE, CHANGE
	}

	private final PlaceContainer parent;
	private final Collection<? extends Place> places;
	private final Type type;

	public PlaceEvent(final Place place)
	{
		parent = null;
		places = Collections.singleton(place);
		type = Type.CHANGE;
	}

	public PlaceEvent(final PlaceContainer parent, final Collection<? extends Place> places, final Type type)
	{
		this.parent = parent;
		this.places = places;
		this.type = type;
	}

	public PlaceEvent(final PlaceContainer parent, final Place place, final Type type)
	{
		this.parent = parent;
		this.places = Collections.singleton(place);
		this.type = type;
	}

	public PlaceContainer getParent()
	{
		return parent;
	}

	public Iterable<? extends Place> getPlaces()
	{
		return places;
	}

	public Type getType()
	{
		return type;
	}
}
