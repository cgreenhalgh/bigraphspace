package bigraph.biged.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bigraphspace.model.PlaceType;

public class Place
{
	private final Place parent;
	private final bigraphspace.model.Place place;
	private final List<Place> children;
	private final List<Port> ports;
	private final Map<String, Link> edges;
	
	public Place(final bigraphspace.model.Place place, final Place parent, final Map<String, Link> edgeMap)
	{
		this.place = place;
		this.parent = parent;
		this.edges = edgeMap;
		
		children = new ArrayList<Place>();
		for(final bigraphspace.model.Place child: place.getChildren())
		{
			children.add(new Place(child, this, edges));
		}

		ports = new ArrayList<Port>();
		if(getType() != PlaceType.site)
		{
			for(final bigraphspace.model.Port child: place.getPorts())
			{
				ports.add(new Port(child, this, edges));
			}
		}
	}
	
	public PlaceType getType()
	{
		return place.getType();
	}
	
	public Place getParent()
	{
		return parent;
	}
	
	public String getControlName()
	{
		return place.getControlName();
	}
	
	public String getSupport()
	{
		return place.getSupport();
	}
	
	void getParents(List<Place> parents)
	{
		if(parent != null)
		{
			parent.getParents(parents);			
		}
		parents.add(this);		
	}
	
	public List<Place> getChildren()
	{
		return children;
	}

	public List<Port> getPorts()
	{
		return ports;		
	}
	
	public List<LinkSegment> getLinkSegments(final boolean source, final boolean target)
	{
		final List<LinkSegment> segments = new ArrayList<LinkSegment>();
		for(final Port port: ports)
		{
			segments.addAll(port.getLinkSegments(source, target));
		}
		return segments;
	}
}