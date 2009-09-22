package bigraph.biged.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class Bigraph
{
	private final bigraphspace.model.Bigraph bigraph;

	private final Map<String, Edge> edges = new HashMap<String, Edge>();

	private final Map<Object, Collection<BigraphEventListener>> listeners = new HashMap<Object, Collection<BigraphEventListener>>();

	public Bigraph(final bigraphspace.model.Bigraph bigraph)
	{
		this.bigraph = bigraph;
		updateEdges();
	}

	public void addListener(final Object source, final BigraphEventListener listener)
	{
		if (source == null) { return; }
		if (listener == null) { return; }
		// System.out.println("Add Listener for " + BigraphLabelProvider.text(place));
		Collection<BigraphEventListener> listenerList = listeners.get(source);
		if (listenerList == null)
		{
			listenerList = new HashSet<BigraphEventListener>();
			listeners.put(source, listenerList);
		}
		listenerList.add(listener);
	}
	
	private void fireEvent(final Collection<BigraphEventListener> listenerList, final BigraphEvent event)
	{
		if(listenerList == null) { return; }
		final Collection<BigraphEventListener> list = new HashSet<BigraphEventListener>(listenerList);		
		for (final BigraphEventListener listener : list)
		{
			listener.onPlaceEvent(event);
		}		
	}

	public void fireEvent(final BigraphEvent event)
	{
		//System.out.println(event);
		for(final Edge edge: edges.values())
		{
			fireEvent(listeners.get(edge), event);
		}
		fireEvent(listeners.get(event.getSource()), event);
	}

	public bigraphspace.model.Bigraph getBigraph()
	{
		return bigraph;
	}

	public Edge getEdge(final String linkName)
	{
		return edges.get(linkName);
	}

	public List<Edge> getEdges(final Place place)
	{
		final List<Edge> edgeList = new ArrayList<Edge>();
		for (final Port port : place.getPorts())
		{
			final Edge edge = edges.get(port.getLinkName());
			if(edge != null)
			{
				edgeList.add(edge);
			}
		}

		return edgeList;
	}

	public void removeListener(final Object source, final BigraphEventListener listener)
	{
		if (source == null) { return; }
		if (listener == null) { return; }
		final Collection<BigraphEventListener> listenerList = listeners.get(source);
		if (listenerList == null) { return; }
		listenerList.remove(listener);
		if (listenerList.isEmpty())
		{
			listeners.remove(source);
		}
	}

	private void updateEdges()
	{
		final Map<String, Edge> newEdges = new HashMap<String, Edge>();
		for (final Place place : getBigraph().getRoots())
		{
			Edge.findEdges(place, newEdges);
		}

		for (final Edge edge : newEdges.values())
		{
			if (edges.get(edge.getName()) == null)
			{
				edges.put(edge.getName(), edge);
			}
			else
			{
				// TODO
				// edges.get(edge.getName()).updatePorts(edge.getPorts());
			}
		}
	}
}