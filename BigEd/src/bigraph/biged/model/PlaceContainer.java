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
	
	public boolean remove(final Place child)
	{
		final boolean removed = places.remove(child);
		if(removed)
		{
			firePlaceEvent(this, child, PlaceEvent.Type.REMOVE);
		}
		return removed;
	}
	
	public List<Place> getPlaces()
	{
		return places;
	}
	
	public boolean add(final Place child)
	{
		places.add(child);
		firePlaceEvent(this, child, PlaceEvent.Type.ADD);		
		return true;
	}
	
	public boolean canAdd(final Place place)
	{
		return place.getType() != PlaceType.root;
	}
	
	public void add(final int index, final Place child)
	{
		places.add(index, child);
		firePlaceEvent(this, child, PlaceEvent.Type.ADD);
	}
	
	public boolean removeAll(final Collection<? extends Place> collection)
	{
		final boolean removed = places.removeAll(collection);
		firePlaceEvent(this, collection, PlaceEvent.Type.REMOVE);
		return removed;
	}
	
	public int indexOf(final Place child)
	{
		return places.indexOf(child);
	}
	
	public void addPlaceEventListener(final PlaceEventListener listener)
	{
		listeners.add(listener);
	}

	public void removePlaceEventListener(final PlaceEventListener listener)
	{
		listeners.remove(listener);
	}	
	
	protected void firePlaceEvent(final PlaceContainer parent, final Place place, final PlaceEvent.Type type)
	{
		final PlaceEvent event = new PlaceEvent(parent, place, type);
		for(final PlaceEventListener listener: listeners)
		{
			listener.onPlaceEvent(event);
		}
	}

	protected void firePlaceEvent(final PlaceContainer parent, final Collection<? extends Place> places, final PlaceEvent.Type type)
	{
		final PlaceEvent event = new PlaceEvent(parent, places, type);
		for(final PlaceEventListener listener: listeners)
		{
			listener.onPlaceEvent(event);
		}
	}
	
	public boolean addAll(Collection<? extends Place> children)
	{
		final boolean added = places.addAll(children);
		if(added)
		{
			firePlaceEvent(this, children, PlaceEvent.Type.ADD);
		}
		return added;	
	}
}
