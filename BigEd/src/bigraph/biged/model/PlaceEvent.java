package bigraph.biged.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;

public class PlaceEvent
{
	public enum Type
	{
		ADD, REMOVE, CHANGE
	}

	private static final Map<Place, Collection<PlaceEventListener>> listeners = new HashMap<Place, Collection<PlaceEventListener>>();

	public static void addListener(final Place place, final PlaceEventListener listener)
	{
		if (place == null) { return; }
		if (listener == null) { return; }
		//System.out.println("Add Listener for " + BigraphLabelProvider.text(place));		
		Collection<PlaceEventListener> listenerList = listeners.get(place);
		if (listenerList == null)
		{
			listenerList = new HashSet<PlaceEventListener>();
			listeners.put(place, listenerList);
		}
		listenerList.add(listener);
	}

	public static void fireEvent(final PlaceEvent event)
	{
		System.out.println(event);
		final Collection<PlaceEventListener> listenerList = listeners.get(event.getPlace());
		if (listenerList == null) { return; }
		final Collection<PlaceEventListener> list = new HashSet<PlaceEventListener>(listenerList);
		for (final PlaceEventListener listener : list)
		{
			listener.onPlaceEvent(event);
		}
	}

	public synchronized static void removeListener(final Place place, final PlaceEventListener listener)
	{
		if (place == null) { return; }
		if (listener == null) { return; }
		//System.out.println("Remove Listener for " + BigraphLabelProvider.text(place));		
		final Collection<PlaceEventListener> listenerList = listeners.get(place);
		if (listenerList == null) { return; }
		listenerList.remove(listener);
		if (listenerList.isEmpty())
		{
			listeners.remove(place);
		}
	}

	private final Place place;
	private final Collection<? extends Place> places;
	private final Type type;

	public PlaceEvent(final Place place, final Collection<? extends Place> places, final Type type)
	{
		this.place = place;
		this.places = places;
		this.type = type;
	}

	public PlaceEvent(final Place place, final Place child, final Type type)
	{
		this.place = place;
		this.places = Collections.singleton(child);
		this.type = type;
	}

	public PlaceEvent(final Place place, final Type type)
	{
		this.place = place;
		this.places = null;
		this.type = Type.CHANGE;
	}

	public Place getPlace()
	{
		return place;
	}

	public Iterable<? extends Place> getPlaces()
	{
		return places;
	}

	public Type getType()
	{
		return type;
	}
	
	@Override
	public String toString()
	{
		return "Event " + BigraphLabelProvider.text(place) + ": " +  type;
	}
}
