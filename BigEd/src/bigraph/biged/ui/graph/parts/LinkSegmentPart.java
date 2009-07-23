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
package bigraph.biged.ui.graph.parts;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.swt.SWT;

import bigraph.biged.model.Link;

/**
 * @author <a href="ktg@cs.nott.ac.uk">Kevin Glover</a>
 */
public class LinkSegmentPart extends AbstractConnectionEditPart
{
	class EllipseDecoration extends Ellipse implements RotatableDecoration
	{
		public EllipseDecoration()
		{
			setSize(10, 10);
			setAntialias(SWT.ON);
			setFill(true);
		}

		@Override
		public void setReferencePoint(final Point ref)
		{
			final Point pt = Point.SINGLETON;
			pt.setLocation(ref);
			pt.negate().translate(getLocation());
			// setRotation(Math.atan2(pt.y, pt.x));
		}

	}

	public LinkSegmentPart()
	{
	}

	public Link getEdge()
	{
		return (Link) getModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies()
	{
		// installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new
		// ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy()
		{
			@Override
			protected Command getDeleteCommand(final GroupRequest request)
			{
				// final Resource resource = getResource();
				// final StatementListCommand command = new
				// StatementListCommand(resource.getModel(), ECTEvent.Type.REMOVED);
				// command.add(resource.listProperties());
				// command.setLabel("Delete Connection " + ModelLabelProvider.text(resource));
				// return command;
				return null;
			}
		});
	}

	@Override
	protected IFigure createFigure()
	{
		final PolylineConnection connection = (PolylineConnection) super.createFigure();
		connection.setAntialias(SWT.ON);

		connection.setTargetDecoration(new EllipseDecoration());
		connection.setSourceDecoration(new EllipseDecoration());
		// connection.setConnectionRouter(new ManhattanConnectionRouter());
		return connection;
	}

	@Override
	protected void fireSelectionChanged()
	{
		super.fireSelectionChanged();
		final PolylineConnection figure = (PolylineConnection) getFigure();
		if (getSelected() == 2)
		{
			figure.setLineWidth(2);
		}
		else
		{
			figure.setLineWidth(1);
		}
	}
}