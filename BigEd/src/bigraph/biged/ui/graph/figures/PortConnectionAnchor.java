package bigraph.biged.ui.graph.figures;

import java.util.Map;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

import bigraph.biged.model.LinkSegment;
import bigraph.biged.model.Port;

public class PortConnectionAnchor extends AbstractConnectionAnchor
{
	private final Port port;
	private final Map<Object, EditPart> registry;

	public PortConnectionAnchor(final IFigure figure, final Port port, final Map<Object, EditPart> registry)
	{
		super(figure);
		this.port = port;
		this.registry = registry;
	}

	@Override
	public Point getLocation(final Point reference)
	{
		final Point point = new Point(getCenter(getOwner()));
		int count = 1;

		for (final LinkSegment segment : port.getLinkSegments(true, true))
		{
			IFigure figure = null;
			if (segment.getSource() == port)
			{
				final EditPart part = registry.get(segment.getTarget().getPlace());
				if (part instanceof GraphicalEditPart)
				{
					figure = ((GraphicalEditPart) part).getFigure();
				}
			}
			else
			{
				final EditPart part = registry.get(segment.getSource().getPlace());
				if (part instanceof GraphicalEditPart)
				{
					figure = ((GraphicalEditPart) part).getFigure();
				}
			}

			if (figure != null)
			{
				count++;

				point.translate(getCenter(figure));
			}
		}
		point.x /= count;
		point.y /= count;

		final Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getOwner().getBounds());
		r.translate(-1, -1);
		r.resize(1, 1);

		getOwner().translateToAbsolute(r);
		float centerX = r.x + 0.5f * r.width;
		float centerY = r.y + 0.5f * r.height;

		if (r.isEmpty() || (point.x == (int) centerX && point.y == (int) centerY)) { return new Point((int) centerX,
				(int) centerY); // This avoids divide-by-zero
		}

		float dx = point.x - centerX;
		float dy = point.y - centerY;

		// r.width, r.height, dx, and dy are guaranteed to be non-zero.
		final float scale = 0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy) / r.height);

		dx *= scale;
		dy *= scale;
		centerX += dx;
		centerY += dy;

		return new Point(Math.round(centerX), Math.round(centerY));
	}

	private Point getCenter(final IFigure figure)
	{
		if (figure instanceof PlaceFigure)
		{
			return ((PlaceFigure) figure).getContainer().getBounds().getCenter();
		}
		else
		{
			return figure.getBounds().getCenter();
		}
	}

}
