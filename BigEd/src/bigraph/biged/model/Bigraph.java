package bigraph.biged.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraph.biged.ui.graph.figures.BasicPlaceFigure;
import bigraph.biged.ui.graph.figures.RootFigure;
import bigraph.biged.ui.graph.figures.SiteFigure;
import bigraphspace.model.Place;
import bigraphspace.model.Port;
import bigraphspace.model.signaturexml.Definitions;

public class Bigraph
{
	private String name;
	private final bigraphspace.model.Bigraph bigraph;
	private Definitions definitions;

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
	
	public PlaceFigure getRenderer(final Place place)
	{
		if(place.isRoot())
		{
			return new RootFigure(place);
		}
		else if(place.isSite())
		{
			return new SiteFigure(place);
		}
		return new BasicPlaceFigure(place);
	}
	
	public void addPort(final Place place, final Port port)
	{
		Edge edge = edges.get(port.getLinkName());
		if (edge == null)
		{
			edge = new Edge(port.getLinkName());
			edges.put(port.getLinkName(), edge);
		}
		edge.addPort(port, place);
	}

	public void fireEvent(final BigraphEvent event)
	{
		System.out.println(event);
		// for(final Edge edge: edges.values())
		// {
		// fireEvent(listeners.get(edge), event);
		// }
		for (final Object object : event.getAffectedObjects())
		{
			fireEvent(listeners.get(object), event);
		}
	}

	public bigraphspace.model.Bigraph getBigraph()
	{
		return bigraph;
	}

	public Edge getEdge(final String linkName)
	{
		return edges.get(linkName);
	}

	public Collection<Edge> getEdges()
	{
		return edges.values();
	}

	public List<Edge> getEdges(final Place place)
	{
		final List<Edge> edgeList = new ArrayList<Edge>();
		for (final Port port : place.getPorts())
		{
			final Edge edge = edges.get(port.getLinkName());
			if (edge != null)
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

	public void removePort(final Place place, final Port port)
	{
		final Edge edge = edges.get(port.getLinkName());
		if (edge != null)
		{
			edge.removePort(port);
			if (edge.getPorts().isEmpty())
			{
				edges.remove(edge.getName());
			}
		}
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}

	private void fireEvent(final Collection<BigraphEventListener> listenerList, final BigraphEvent event)
	{
		if (listenerList == null) { return; }
		final Collection<BigraphEventListener> list = new HashSet<BigraphEventListener>(listenerList);
		for (final BigraphEventListener listener : list)
		{
			listener.onPlaceEvent(event);
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