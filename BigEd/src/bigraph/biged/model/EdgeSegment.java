package bigraph.biged.model;

public class EdgeSegment
{
	private final Edge edge;
	private final PortDetails source;
	private final PortDetails target;
	
	public EdgeSegment(final Edge edge, final PortDetails source, final PortDetails target)
	{
		this.edge = edge;
		this.source = source;
		this.target = target;
	}

	public PortDetails getSource()
	{
		return source;
	}

	public PortDetails getTarget()
	{
		return target;
	}
}