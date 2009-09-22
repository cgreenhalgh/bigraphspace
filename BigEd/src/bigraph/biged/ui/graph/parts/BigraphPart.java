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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEventListener;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.commands.AddRootCommand;
import bigraph.biged.ui.commands.MoveRootCommand;
import bigraphspace.model.Place;

/**
 * @author <a href="ktg@cs.nott.ac.uk">Kevin Glover</a>
 */
public class BigraphPart extends AbstractBigraphEditPart implements BigraphEventListener
{
	public BigraphPart(final Bigraph bigraph)
	{
		super(bigraph);
	}

	public void onPlaceEvent(final BigraphEvent event)
	{
		if (getParent() != null)
		{
			if (event.getType() == Type.ADD || event.getType() == Type.REMOVE)
			{
				refreshChildren();
			}
			else if (event.getType() == Type.CHANGE)
			{
				refreshVisuals();
			}
		}
	}

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new FlowLayoutEditPolicy()
		{
			@Override
			public Command getCommand(final Request request)
			{
				System.err.println("Request " + request.getType());
				return super.getCommand(request);
			}

			@Override
			protected Command createAddCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					final Place childPlace = (Place) child.getModel();
					if (after == null)
					{
						return new AddRootCommand(getBigraph(), childPlace, null);
					}
					else if (after.getModel() instanceof Place) { return new AddRootCommand(getBigraph(), childPlace,
							(Place) after.getModel()); }
				}
				return null;
			}

			protected Command createCloneCommand(final EditPart child, final EditPart after)
			{
				// if (child.getModel() instanceof Place)
				// {
				// final Place childPlace = (Place) child.getModel();
				// if (!getContainer().canAdd(childPlace)) { return null; }
				// if (after == null)
				// {
				// return new AddPlaceCommand(getContainer(), childPlace.clone(), null);
				// }
				// else if (after.getModel() instanceof Place) { return new
				// AddPlaceCommand(getContainer(), childPlace
				// .clone(), (Place) after.getModel()); }
				// }
				return null;
			}

			@Override
			protected Command createMoveChildCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					if (after != null && after.getModel() instanceof Place)
					{
						return new MoveRootCommand(getBigraph(), (Place) child.getModel(), (Place)
						 after.getModel());
					}
					else
					{
						return new MoveRootCommand(getBigraph(), (Place) child.getModel(), null);
					}
				}

				return null;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Command getCloneCommand(final ChangeBoundsRequest request)
			{
				final List<EditPart> editParts = request.getEditParts();
				final CompoundCommand command = new CompoundCommand();
				for (final EditPart child : editParts)
				{
					command.add(createCloneCommand(child, getInsertionReference(request)));
				}
				return command.unwrap();
			}

			@Override
			protected Command getCreateCommand(final CreateRequest request)
			{
				final EditPart after = getInsertionReference(request);
				if (request.getNewObject() instanceof Place)
				{
					final Place childPlace = (Place) request.getNewObject();
					if (after == null)
					{
						return new AddRootCommand(getBigraph(), childPlace, null);
					}
					else if (after.getModel() instanceof Place) { return new AddRootCommand(getBigraph(), childPlace,
							(Place) after.getModel()); }
				}
				return null;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Command getOrphanChildrenCommand(final Request request)
			{
				final Collection<EditPart> parts = ((GroupRequest) request).getEditParts();
				final Collection<Place> places = new HashSet<Place>();
				for (final EditPart part : parts)
				{
					if (!(part.getModel() instanceof Place)) { return null; }
					places.add((Place) part.getModel());
				}
				// final DeletePlaceCommand deleteCommand = new DeleteRootCommand(getBigraph(),
				// places);
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
		final FlowLayout layout = new FlowLayout();
		layout.setMajorSpacing(15);
		layout.setMinorSpacing(15);
		f.setLayoutManager(layout);
		f.setBorder(new MarginBorder(15));

		// Create the static router for the connection layer
		// final ConnectionLayer connLayer = (ConnectionLayer)
		// getLayer(LayerConstants.CONNECTION_LAYER);
		// connLayer.setConnectionRouter(new ShortestPathConnectionRouter(f));

		return f;
	}

	@Override
	protected List<Place> getModelChildren()
	{
		return getBigraph().getBigraph().getRoots();
	}
}