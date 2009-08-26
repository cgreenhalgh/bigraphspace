package bigraph.biged.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import bigraphspace.model.PlaceType;

public abstract class PlaceContainer
{
	private final List<Place> places = new ArrayList<Place>();
	private final Collection<PlaceEventListener> listeners = new HashSet<PlaceEventListener>();

	public void add(final int index, final Place child)
	{
		places.add(index, child);
		firePlaceEvent(new PlaceEvent(this, child, PlaceEvent.Type.ADD));
	}

	public boolean add(final Place child)
	{
		places.add(child);
		firePlaceEvent(new PlaceEvent(this, child, PlaceEvent.Type.ADD));
		return true;
	}

	public boolean addAll(final Collection<? extends Place> children)
	{
		final boolean added = places.addAll(children);
		if (added)
		{
			firePlaceEvent(new PlaceEvent(this, children, PlaceEvent.Type.ADD));
		}
		return added;
	}

	public void addPlaceEventListener(final PlaceEventListener listener)
	{
		listeners.add(listener);
	}

	public boolean canAdd(final Place place)
	{
		return place.getType() != PlaceType.root;
	}

	public List<Place> getPlaces()
	{
		return places;
	}

	public int indexOf(final Place child)
	{
		return places.indexOf(child);
	}

	public boolean remove(final Place child)
	{
		final boolean removed = places.remove(child);
		if (removed)
		{
			firePlaceEvent(new PlaceEvent(this, child, PlaceEvent.Type.REMOVE));
		}
		return removed;
	}

	public boolean removeAll(final Collection<? extends Place> collection)
	{
		final boolean removed = places.removeAll(collection);
		firePlaceEvent(new PlaceEvent(this, collection, PlaceEvent.Type.REMOVE));
		return removed;
	}

	public void removePlaceEventListener(final PlaceEventListener listener)
	{
		listeners.remove(listener);
	}

	protected void firePlaceEvent(final PlaceEvent event)
	{
		for (final PlaceEventListener listener : listeners)
		{
			listener.onPlaceEvent(event);
		}		
	}
}
