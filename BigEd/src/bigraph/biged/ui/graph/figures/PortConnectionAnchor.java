package bigraph.biged.ui.graph.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

import bigraphspace.model.Port;

public class PortConnectionAnchor extends AbstractConnectionAnchor
{
	private final Port port;
	private final Point point = new Point();

	public PortConnectionAnchor(final IFigure figure, final Port port)
	{
		super(figure);
		this.port = port;
	}

	public Point getLocation(final Point reference)
	{
		return point;
	}

	public Port getPort()
	{
		return port;
	}

	public void setLocation(final Point point)
	{
		this.point.setLocation(point);
	}
}