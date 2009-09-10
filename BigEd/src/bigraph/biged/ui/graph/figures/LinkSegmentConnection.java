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

import java.awt.geom.GeneralPath;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;

public class LinkSegmentConnection extends PolylineConnection
{
	private Path path;
	private final int radius = 3;

	// private final static int defaultControlOffsetX = 40;
	// private final static int defaultControlOffsetY = 0;

	@Override
	public Rectangle getBounds()
	{
		if (bounds == null)
		{
			final PointList pointList = getPoints();
			if (pointList.size() == 0) { return new Rectangle(); }
			final Point source = pointList.getFirstPoint();
			final Point target = pointList.getLastPoint();

			final GeneralPath gp = new GeneralPath();
			gp.moveTo(source.x, source.y);
			// gp.lineTo(source.x + 10, source.y);
			// gp.curveTo(source.x + defaultControlOffsetX, source.y, target.x -
			// defaultControlOffsetX, target.y,
			// target.x - 10, target.y);
			gp.lineTo(target.x, target.y);

			bounds = new Rectangle(gp.getBounds().x, gp.getBounds().y, gp.getBounds().width, gp.getBounds().height);

			for (int i = 0; i < getChildren().size(); i++)
			{
				final IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}

			for (int i = 0; i < pointList.size(); i++)
			{
				bounds.union(pointList.getPoint(i));
			}

			bounds.union(source.x + radius, source.y + radius);
			bounds.union(source.x - radius, source.y - radius);
			bounds.union(target.x + radius, target.y + radius);
			bounds.union(target.x - radius, target.y - radius);
		}
		return bounds;
	}

	private Path getPath()
	{
		// if (path == null)
		// {
		final PointList pointList = getPoints();
		final Point source = pointList.getFirstPoint();
		final Point target = pointList.getLastPoint();

		path = new Path(Display.getCurrent());
		path.moveTo(source.x, source.y);
		// path.lineTo(source.x + 10, source.y);
		// path.cubicTo(source.x + defaultControlOffsetX, source.y, target.x -
		// defaultControlOffsetX, target.y,
		// target.x - 10, target.y);
		path.lineTo(target.x, target.y);
		// }
		return path;
	}

	@Override
	protected void outlineShape(final Graphics g)
	{
		final PointList pointList = getPoints();
		final Point startPoint = pointList.getFirstPoint();
		final Point endPoint = pointList.getLastPoint();

		g.setAntialias(SWT.ON);
		g.setLineWidth(2);
		g.drawPath(getPath());
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(ColorConstants.black);
		g.fillOval(startPoint.x - radius, startPoint.y - radius, radius * 2, radius * 2);
		g.fillOval(endPoint.x - radius, endPoint.y - radius, radius * 2, radius * 2);
	}

	// @Override
	// protected boolean shapeContainsPoint(final int x, final int y)
	// {
	// final PointList pointList = getPoints();
	// if (pointList.size() == 0) { return false; }
	// final Point source = pointList.getFirstPoint();
	// final Point target = pointList.getLastPoint();
	//
	// final GeneralPath gp = new GeneralPath();
	// gp.moveTo(source.x, source.y);
	// // gp.lineTo(source.x + 10, source.y);
	// // gp.curveTo(source.x + defaultControlOffsetX, source.y, target.x - defaultControlOffsetX,
	// // target.y,
	// // target.x - 10, target.y);
	// gp.lineTo(target.x, target.y);
	//
	// return gp.contains(x, y);
	// // return super.shapeContainsPoint(x, y);
	// }
}