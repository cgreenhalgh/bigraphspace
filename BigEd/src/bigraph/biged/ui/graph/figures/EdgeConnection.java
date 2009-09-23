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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

import bigraph.biged.BigEdPlugin;
import bigraph.biged.model.Edge;
import bigraphspace.model.Port;

public class EdgeConnection extends PolylineConnection implements Connection
{
	private static Point getCenter(final IFigure figure)
	{
		Point point;
		if (figure instanceof PlaceFigure)
		{
			point = ((PlaceFigure) figure).getContainer().getBounds().getCenter();
		}
		else
		{
			point = figure.getBounds().getCenter();
		}
		return point;
	}

	private final Edge edge;
	private final static int radius = 3;

	private final EditPartViewer viewer;

	private Port sourcePort;
	private Port targetPort;

	private final Map<Port, PortConnectionAnchor> portAnchors = new HashMap<Port, PortConnectionAnchor>();

	private final Collection<EdgeSegment> segments = new HashSet<EdgeSegment>();

	public EdgeConnection(final Edge edge, final EditPartViewer viewer)
	{
		this.edge = edge;
		this.viewer = viewer;
		setLineWidth(2);
		setAntialias(SWT.ON);
		setForegroundColor(ColorConstants.titleBackground);
		setConnectionRouter(new AbstractRouter()
		{
			@Override
			public void invalidate(final Connection connection)
			{
				super.invalidate(connection);
				segments.clear();
				sourcePort = null;
				targetPort = null;
				portAnchors.clear();
			}

			@Override
			public void route(final Connection connection)
			{
				//if (segments.isEmpty())
				{
					createSegments();
					
					final PointList points = getPoints();
					points.removeAllPoints();
					for (final Port port : edge.getPorts())
					{
						final Point point = getLocation(port);
						getAnchor(port).setLocation(point);
						points.addPoint(point);
					}
					setPoints(points);					
				}
			}

			// http://en.wikipedia.org/wiki/Prim's_algorithm
			private void createSegments()
			{
				final Collection<Port> ports = edge.getPorts();
				final Collection<EdgeSegment> edges = new HashSet<EdgeSegment>(ports.size() * (ports.size() - 1) / 2);

				for (final Port sourcePort : edge.getPorts())
				{
					for (final Port targetPort : edge.getPorts())
					{
						if (sourcePort.equals(targetPort))
						{
							continue;
						}
						edges.add(new EdgeSegment(edge, sourcePort, targetPort));
					}
				}

				final Collection<Port> addedPorts = new HashSet<Port>(ports.size());
				final Collection<Port> remainingPorts = new HashSet<Port>(ports);

				// priority queue capacity >=1
				final PriorityQueue<EdgeSegment> currentSegments = new PriorityQueue<EdgeSegment>(
						edges.size() > 0 ? edges.size() : 1, new Comparator<EdgeSegment>()
						{
							public int compare(final EdgeSegment o1, final EdgeSegment o2)
							{
								return getLength(o1) - getLength(o2);
							}
						});

				final Port currentPort = ports.iterator().next();
				getEdges(currentPort, edges, addedPorts, currentSegments);
				addedPorts.add(currentPort);
				remainingPorts.remove(currentPort);

				while (!remainingPorts.isEmpty())
				{
					EdgeSegment segment;
					while (true)
					{
						segment = currentSegments.poll();
						if (!addedPorts.contains(segment.getSource()))
						{
							segments.add(segment);
							remainingPorts.remove(segment.getSource());
							addedPorts.add(segment.getSource());
							getEdges(segment.getSource(), edges, addedPorts, currentSegments);
							break;
						}
						else if (!addedPorts.contains(segment.getTarget()))
						{
							segments.add(segment);
							remainingPorts.remove(segment.getTarget());
							addedPorts.add(segment.getTarget());
							getEdges(segment.getTarget(), edges, addedPorts, currentSegments);
							break;
						}
						edges.remove(segment);
					}
				}
			}

			private void getEdges(final Port port, final Collection<EdgeSegment> edges,
					final Collection<Port> addedPorts, final Collection<EdgeSegment> segments)
			{
				for (final EdgeSegment edge : edges)
				{
					if (edge.getSource().equals(port))
					{
						if (!addedPorts.contains(edge.getTarget()))
						{
							segments.add(edge);
						}
					}
					else if (edge.getTarget().equals(port))
					{
						if (!addedPorts.contains(edge.getSource()))
						{
							segments.add(edge);
						}
					}
				}
			}

			private int getLength(final EdgeSegment edgeSegment)
			{
				final IFigure targetFigure = getFigure(edgeSegment.getTarget());
				final IFigure sourceFigure = getFigure(edgeSegment.getSource());
				return targetFigure.getBounds().getCenter().getDistance2(sourceFigure.getBounds().getCenter());
			}
		});
	}

	@Override
	public Rectangle getBounds()
	{
		if (bounds == null)
		{
			super.getBounds();
			for (int i = 0; i < getChildren().size(); i++)
			{
				final IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}
			bounds.expand(radius, radius);
		}
		return bounds;
	}

	public Edge getEdge()
	{
		return edge;
	}

	@Override
	public Object getRoutingConstraint()
	{
		final List<Bendpoint> bendpoints = new ArrayList<Bendpoint>();
		for (final Port port : edge.getPorts())
		{
			bendpoints.add(new AbsoluteBendpoint(portAnchors.get(port).getLocation(null)));
		}
		return bendpoints;
	}

	@Override
	public ConnectionAnchor getSourceAnchor()
	{
		if (sourcePort == null)
		{
			final Iterator<Port> iterator = edge.getPorts().iterator();
			if (!iterator.hasNext()) { return null; }
			sourcePort = iterator.next();
		}
		return getAnchor(sourcePort);
	}

	@Override
	public ConnectionAnchor getTargetAnchor()
	{
		if (targetPort == null)
		{
			final Iterator<Port> iterator = edge.getPorts().iterator();
			if (!iterator.hasNext()) { return null; }
			iterator.next();
			if (!iterator.hasNext()) { return null; }
			targetPort = iterator.next();
		}
		return getAnchor(targetPort);
	}

	@Override
	public void layout()
	{
		getConnectionRouter().route(this);

		final Rectangle oldBounds = bounds;
		bounds = null;

		if (!getBounds().contains(oldBounds))
		{
			getParent().translateToParent(oldBounds);
			getUpdateManager().addDirtyRegion(getParent(), oldBounds);
		}

		repaint();
	}

	@Override
	protected void outlineShape(final Graphics g)
	{
		g.setAntialias(getAntialias());
		g.setLineWidth(getLineWidth());
		g.setForegroundColor(ColorConstants.titleBackground);
		g.setBackgroundColor(ColorConstants.titleBackground);
		for (final EdgeSegment segment : segments)
		{
			final Point source = getAnchor(segment.getSource()).getLocation(null);
			final Point target = getAnchor(segment.getTarget()).getLocation(null);
			g.drawLine(source, target);
		}

		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(ColorConstants.black);
		final Image image = BigEdPlugin.getImage("portx");
		for (final Port port : edge.getPorts())
		{
			final Point location = getAnchor(port).getLocation(null);
			// g.fillOval(location.x - radius, location.y - radius, radius * 2, radius * 2);
			g.drawImage(image, location.x - (image.getImageData().width / 2), location.y
					- (image.getImageData().height / 2));
		}
	}

	@Override
	protected boolean shapeContainsPoint(final int x, final int y)
	{
		if (!bounds.contains(x, y)) { return false; }
		for (final EdgeSegment segment : segments)
		{
			if (segmentContainsPoint(segment, x, y)) { return true; }
		}
		return false;
	}

	private PortConnectionAnchor getAnchor(final Port port)
	{
		if (port == null) { return null; }
		PortConnectionAnchor anchor = portAnchors.get(port);
		if (anchor == null)
		{
			anchor = new PortConnectionAnchor(this, port);
			portAnchors.put(port, anchor);
		}
		return anchor;
	}

	private IFigure getFigure(final Port port)
	{
		final EditPart part = (EditPart) viewer.getEditPartRegistry().get(edge.getPlace(port));
		if (part instanceof GraphicalEditPart) { return ((GraphicalEditPart) part).getFigure(); }
		return null;
	}

	private Point getLocation(final Port port)
	{
		final Point point = getCenter(getFigure(port));
		int count = 1;

		for (final EdgeSegment segment : getSegments(port))
		{
			IFigure figure = null;
			if (segment.getSource().equals(port))
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

	private Collection<EdgeSegment> getSegments(final Port port)
	{
		final Collection<EdgeSegment> result = new HashSet<EdgeSegment>();
		for (final EdgeSegment linkSegment : segments)
		{
			if (linkSegment.getSource().equals(port))
			{
				result.add(linkSegment);
			}
			else if (linkSegment.getTarget().equals(port))
			{
				result.add(linkSegment);
			}
		}
		return result;
	}

	private boolean segmentContainsPoint(final EdgeSegment segment, final int x, final int y)
	{
		final int tolerance = 2;
		final Point source = getAnchor(segment.getSource()).getLocation(null);
		final Point target = getAnchor(segment.getTarget()).getLocation(null);

		/*
		 * Point should be located inside Rectangle(x1 -+ tolerance, y1 -+ tolerance, x2 +-
		 * tolerance, y2 +- tolerance)
		 */
		final Rectangle lineBounds = Rectangle.SINGLETON;
		lineBounds.setSize(0, 0);
		lineBounds.setLocation(source.x, source.y);
		lineBounds.union(target.x, target.y);
		lineBounds.expand(tolerance, tolerance);
		if (!lineBounds.contains(x, y)) { return false; }

		/*
		 * If this is horizontal, vertical line or dot then the distance between specified point and
		 * segment is not more then tolerance (due to the lineBounds check above)
		 */
		if (source.x == target.x || source.y == target.y) { return true; }

		/*
		 * Calculating square distance from specified point to this segment using formula for Dot
		 * product of two vectors.
		 */
		final int v1x = target.x - source.x;
		final int v1y = target.y - source.y;
		final int v2x = x - source.x;
		final int v2y = y - source.y;
		final int numerator = v2x * v1y - v1x * v2y;
		final int denominator = v1x * v1x + v1y * v1y;
		final int squareDistance = (int) ((long) numerator * numerator / denominator);
		return squareDistance <= tolerance * tolerance;
	}
}