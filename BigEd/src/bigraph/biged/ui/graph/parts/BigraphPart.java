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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEventListener;
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
		refresh();
	}

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BigraphLayoutEditPolicy()
		{
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

			@Override
			protected Command createCloneCommand(final EditPart child, final EditPart after)
			{
				return null;
			}

			@Override
			protected Command createMoveChildCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					if (after != null && after.getModel() instanceof Place)
					{
						return new MoveRootCommand(getBigraph(), (Place) child.getModel(), (Place) after.getModel());
					}
					else
					{
						return new MoveRootCommand(getBigraph(), (Place) child.getModel(), null);
					}
				}

				return null;
			}

			@Override
			protected Command createOrphanChildCommand(final EditPart child)
			{
				return null;
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

			@Override
			protected int getFeedbackIndexFor(final Request request)
			{
				if (request instanceof GroupRequest)
				{
					final GroupRequest groupRequest = ((GroupRequest) request);
					if (groupRequest.getEditParts().size() >= 1)
					{
						final EditPart part = (EditPart) groupRequest.getEditParts().get(0);
						if (part.getModel() instanceof Place)
						{
							final Place place = (Place) part.getModel();
							if (place.isRoot())
							{
								int index = super.getFeedbackIndexFor(request);
								if (index == -1)
								{
									return Integer.MAX_VALUE;
								}
								else
								{
									return index;
								}
							}
						}
					}
				}
				else if (request instanceof CreateRequest)
				{
					final CreateRequest createRequest = (CreateRequest) request;
					final Object newObject = createRequest.getNewObject();
					if (newObject instanceof Place)
					{
						final Place place = (Place) newObject;
						if (place.isRoot())
						{
							int index = super.getFeedbackIndexFor(request);
							if (index == -1)
							{
								return Integer.MAX_VALUE;
							}
							else
							{
								return index;
							}
						}
					}

				}
				return -1;
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