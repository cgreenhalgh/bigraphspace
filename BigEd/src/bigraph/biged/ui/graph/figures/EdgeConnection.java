/*
 <COPYRIGHT>

 Copyright (c) 2006-2009, University of Nottingham
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 - Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer.

 - Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.

 - Neither the name of the University of Nottingham
 nor the names of its contributors may be used to endorse or promote products
 derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 </COPYRIGHT>

 Created by: Kevin Glover (University of Nottingham)
 */
package bigraph.biged.ui.graph.figures;

import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.SWT;

import bigraph.biged.model.Edge;
import bigraph.biged.model.EdgeSegment;
import bigraphspace.model.Port;

public class EdgeConnection extends PolylineConnection implements Connection
{
	private final Edge edge;
	private final static int radius = 3;
	private final Map<Object, EditPart> registry;

	public EdgeConnection(final Edge edge, final Map<Object, EditPart> registry)
	{
		this.edge = edge;
		this.registry = registry;
		setLineWidth(2);
		setAntialias(SWT.ON);
		setForegroundColor(ColorConstants.titleBackground);
	}
	
	private IFigure getFigure(final Port port)
	{
		final EditPart part = registry.get(edge.getPlace(port));
		if (part instanceof GraphicalEditPart)
		{
			return ((GraphicalEditPart) part).getFigure();
		}		
		return null;
	}
	
	@Override
	public void layout()
	{
		updateBounds();
		super.layout();
	}

	public Point getLocation(final Port port)
	{
		
		final Point point = new Point(getCenter(getFigure(port)));
		int count = 1;

		for (final EdgeSegment segment : edge.getSegments(port, true, true))
		{
			IFigure figure = null;
			if (segment.getSource() == port)
			{
				figure = getFigure(segment.getTarget());
			}
			else
			{
				figure = getFigure(segment.getSource());
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
		r.setBounds(getFigure(port).getBounds());
		r.translate(-1, -1);
		r.resize(1, 1);

		getFigure(port).translateToAbsolute(r);
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
	
	private static Point getCenter(final IFigure figure)
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
	
	
	@Override
	protected void outlineShape(final Graphics g)
	{
		System.out.println("Draw Edge");
		g.setAntialias(getAntialias());
		g.setLineWidth(getLineWidth());
		g.setForegroundColor(getForegroundColor());
		g.setBackgroundColor(getBackgroundColor());
		for(final EdgeSegment segment: edge.getSegments())
		{
			final Point source = getLocation(segment.getSource());
			final Point target = getLocation(segment.getTarget());			
			g.drawLine(source, target);
		}
		
		for(final Port port: edge.getPorts())
		{
			final Point location = getLocation(port);
			g.fillOval(location.x - radius, location.y - radius, radius * 2, radius * 2);			
		}
	}

	@Override
	protected void fillShape(Graphics graphics)
	{
		outlineShape(graphics);		
	}

	public ConnectionAnchor getSourceAnchor()
	{
		System.out.println("Get source anchor");
		return PortConnectionAnchor.getAnchor(edge.getSource());
	}

	public ConnectionAnchor getTargetAnchor()
	{
		System.out.println("Get target anchor");
		return PortConnectionAnchor.getAnchor(edge.getTarget());
	}
//
//	public void setConnectionRouter(ConnectionRouter router)
//	{
//	}
//
//	public void setPoints(PointList list)
//	{
//	}
//
//	public void setRoutingConstraint(Object cons)
//	{
//	}

	public void setSourceAnchor(ConnectionAnchor anchor)
	{
		if(anchor instanceof PortConnectionAnchor)
		{
			PortConnectionAnchor.addAnchor(((PortConnectionAnchor)anchor).getPort(), (PortConnectionAnchor) anchor);
		}
	}

	public void setTargetAnchor(ConnectionAnchor anchor)
	{
		if(anchor instanceof PortConnectionAnchor)
		{
			PortConnectionAnchor.addAnchor(((PortConnectionAnchor)anchor).getPort(), (PortConnectionAnchor) anchor);
		}		
	}

	// Updates the bounding box, and port positions.
	public void updateBounds()
	{
		Rectangle rect = null;		
		for(final Port port: edge.getPorts())
		{
			final Point location = getLocation(port);
			if(rect == null)
			{
				rect = new Rectangle(location, new Dimension(0, 0));
			}
			else
			{
				rect.union(location.x - radius, location.y - radius, radius * 2, radius * 2);
			}
		}
		
		System.out.println("Bounds:" + rect);
		setBounds(rect);
	}
	
	@Override
	public boolean containsPoint(int x, int y)
	{
		// TODO Auto-generated method stub
		return super.containsPoint(x, y);
	}
}