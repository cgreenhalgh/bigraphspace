package bigraph.biged.model;

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

	public Edge getEdge()
	{
		return edge;
	}

	public Port getSource()
	{
		return source;
	}

	public Port getTarget()
	{
		return target;
	}
}