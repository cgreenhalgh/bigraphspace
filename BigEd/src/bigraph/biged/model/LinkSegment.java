package bigraph.biged.model;

import java.util.List;

public class LinkSegment
{
	private final Link link;
	private final Port source;
	private final Port target;
	private int length;
	
	public LinkSegment(final Link link, final Port source, final Port target)
	{
		this.link = link;
		this.source = source;
		this.target = target;
		this.length =  calculateLength();
	}
	
	private int calculateLength()
	{
		final List<Place> sourceParents = source.getParents();
		final List<Place> targetParents = target.getParents();
				
		final int minLength = Math.min(sourceParents.size(), targetParents.size());
		int depth ;
		for(depth = 0; depth < minLength; depth++)
		{
			if(sourceParents.get(depth) != targetParents.get(depth))
			{
				break;
			}
		}
		
		return (sourceParents.size() - depth) + (targetParents.size() - depth);		
	}

	public Port getSource()
	{
		return source;
	}

	public Port getTarget()
	{
		return target;
	}
	
	public int getLength()
	{
		return length;
	}

	public Link getLink()
	{
		return link;
	}
}