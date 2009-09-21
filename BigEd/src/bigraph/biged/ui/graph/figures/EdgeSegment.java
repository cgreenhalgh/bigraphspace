package bigraph.biged.ui.graph.figures;

import bigraph.biged.model.Edge;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class EdgeSegment
{
	private final Edge edge;
	private final Port source;
	private final Port target;

	public EdgeSegment(final Edge edge, final Port source, final Port target)
	{
		this.edge = edge;
		this.source = source;
		this.target = target;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (!(obj instanceof EdgeSegment)) { return false; }
		final EdgeSegment segment = (EdgeSegment) obj;
		return (segment.getSource().equals(source) && segment.getTarget().equals(target))
				|| (segment.getSource().equals(target) && segment.getTarget().equals(source));
	}

	public Edge getEdge()
	{
		return edge;
	}

	public Port getSource()
	{
		return source;
	}

	public Place getSourcePlace()
	{
		return edge.getPlace(source);
	}

	public Port getTarget()
	{
		return target;
	}

	public Place getTargetPlace()
	{
		return edge.getPlace(target);
	}

	@Override
	public int hashCode()
	{
		return source.hashCode() ^ target.hashCode();
	}
}