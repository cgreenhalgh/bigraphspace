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

import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.Place;

/**
 * @author <a href="ktg@cs.nott.ac.uk">Kevin Glover</a>
 */
public class BigraphPart extends AbstractGraphicalEditPart
{
	@Override
	public void activate()
	{
		super.activate();
	}

	@Override
	public void deactivate()
	{
		super.deactivate();
	}

	private Bigraph getBigraph()
	{
		return (Bigraph) getModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ConstrainedLayoutEditPolicy()
		{
			@Override
			protected Command createChangeConstraintCommand(final EditPart child, final Object constraint)
			{
				// if (!(child instanceof ResourcePart)) { return null; }
				// if (!(constraint instanceof Point)) { return null; }
				//
				// final ResourcePart resourcePart = (ResourcePart) child;
				// final Figure figure = (Figure) resourcePart.getFigure();
				// final Point oldLocation = figure.getLocation();
				// final Point newLocation = ((Point) constraint).translate(getLayoutOrigin());
				//
				// return new MoveResourceCommand(resourcePart, oldLocation, newLocation);
				return null;
			}

			@Override
			protected EditPolicy createChildEditPolicy(final EditPart child)
			{
				return new NonResizableEditPolicy();
			}

			@Override
			protected Object getConstraintFor(final Point point)
			{
				return point.getCopy();
			}

			@Override
			protected Object getConstraintFor(final Rectangle rect)
			{
				return rect.getLocation();
			}

			@Override
			protected Command getCreateCommand(final CreateRequest request)
			{
				// Point constraint = ((Point)
				// getConstraintFor(request)).translate(getLayoutOrigin());
				// return new
				// CreateResourceCommand(PhysConfPlugin.getDefault().getModel(),
				// (CreateResourceRequest) request, constraint);
				return null;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure()
	{
		final Figure f = new FreeformLayer();
		f.setLayoutManager(new FlowLayout());
		f.setBorder(new MarginBorder(15));

		// Create the static router for the connection layer
		final ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(new ShortestPathConnectionRouter(f));

		return f;
	}

	@Override
	protected List<Place> getModelChildren()
	{
		return getBigraph().getRoots();
	}

	@Override
	protected void refreshChildren()
	{
		super.refreshChildren();
	}
}