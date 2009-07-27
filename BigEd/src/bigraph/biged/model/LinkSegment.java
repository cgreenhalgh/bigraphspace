package bigraph.biged.model;

public class LinkSegment
{
	private final Link link;
	private final Port source;
	private final Port target;
	private final int length;

	public LinkSegment(final Link link, final Port source, final Port target)
	{
		this.link = link;
		this.source = source;
		this.target = target;
		this.length = calculateLength();
		System.err.println("LinkSegment: " + source.getPlace().getSupport() + "-" + target.getPlace().getSupport()
				+ " " + length);
	}

	public int getLength()
	{
		return length;
	}

	public Link getLink()
	{
		return link;
	}

	public Port getSource()
	{
		return source;
	}

	public Port getTarget()
	{
		return target;
	}

	private int calculateLength()
	{
		return Math.abs(source.getPlace().getPosition() - target.getPlace().getPosition());
	}
}