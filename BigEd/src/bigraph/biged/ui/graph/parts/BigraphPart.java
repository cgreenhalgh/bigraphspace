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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Edge;
import bigraph.biged.model.EdgeSegment;
import bigraph.biged.model.PlaceEvent;
import bigraph.biged.model.PlaceEventListener;
import bigraph.biged.model.PlaceEvent.Type;
import bigraph.biged.ui.commands.AddRootCommand;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

/**
 * @author <a href="ktg@cs.nott.ac.uk">Kevin Glover</a>
 */
public class BigraphPart extends AbstractGraphicalEditPart implements PlaceEventListener
{
	private final Map<String, Edge> edges = new HashMap<String, Edge>();
	
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
		final ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(new ShortestPathConnectionRouter(f));

		return f;
	}
	
	@Override
	public void activate()
	{
		if (!isActive())
		{
			super.activate();
			// TODO getContainer().addPlaceEventListener(this);
		}
	}

	@Override
	public void deactivate()
	{
		if (isActive())
		{
			super.deactivate();
			// TODO getContainer().addPlaceEventListener(this);
		}
	}

	public void onPlaceEvent(final PlaceEvent event)
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
					else if (after.getModel() instanceof Place) { return new AddRootCommand(getBigraph(),
							childPlace, (Place) after.getModel()); }
				}
				return null;
			}

			protected Command createCloneCommand(final EditPart child, final EditPart after)
			{
//				if (child.getModel() instanceof Place)
//				{
//					final Place childPlace = (Place) child.getModel();
//					if (!getContainer().canAdd(childPlace)) { return null; }
//					if (after == null)
//					{
//						return new AddPlaceCommand(getContainer(), childPlace.clone(), null);
//					}
//					else if (after.getModel() instanceof Place) { return new AddPlaceCommand(getContainer(), childPlace
//							.clone(), (Place) after.getModel()); }
//				}
				return null;
			}

			@Override
			protected Command createMoveChildCommand(final EditPart child, final EditPart after)
			{
				if (child.getModel() instanceof Place)
				{
					if (after != null && after.getModel() instanceof Place)
					{
						//return new MovePlaceCommand(getModel(), (Place) child.getModel(), (Place) after.getModel());
					}
					else
					{
						//return new MovePlaceCommand(getModel(), (Place) child.getModel(), null);
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
					else if (after.getModel() instanceof Place) { return new AddRootCommand(getBigraph(),
							childPlace, (Place) after.getModel()); }
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
				//final DeletePlaceCommand deleteCommand = new DeleteRootCommand(getBigraph(), places);
				return null;
			}
		});
	}
	
	public List<Edge> getEdges(final Place place)
	{
		final List<Edge> edgeList = new ArrayList<Edge>();
		for(final Port port: place.getPorts())
		{
			edgeList.add(edges.get(port.getLinkName()));
		}
		
		return edgeList;
	}
	
	public List<EdgeSegment> getEdgeSegments(final Place place, final boolean source, final boolean target)
	{
		final List<EdgeSegment> edgeSegments = new ArrayList<EdgeSegment>();
		for(final Port port: place.getPorts())
		{
			final Edge edge = edges.get(port.getLinkName());
			edgeSegments.addAll(edge.getSegments(port, source, target));
		}		
		return edgeSegments;
	}
	
	public void updateEdges()
	{
		final Map<String, Edge> newEdges = new HashMap<String, Edge>();
		int position = 0;
		for(final Place place: getBigraph().getRoots())
		{
			position = Edge.findEdges(place, newEdges, position);
		}
		
		for(final Edge edge: newEdges.values())
		{
			if(edges.get(edge.getName()) == null)
			{
				edges.put(edge.getName(), edge);
			}
			else
			{
				edges.get(edge.getName()).updatePorts(edge.getPorts());
			}
		}
		
		for(final Edge edge: edges.values())
		{
			if(newEdges.get(edge.getName()) == null)
			{
				edges.remove(edge.getName());
			}
			else
			{
				edge.update();
			}
		}
	}
	
	@Override
	public void setModel(Object model)
	{
		super.setModel(model);
		updateEdges();
	}

	public Bigraph getBigraph()
	{
		return (Bigraph)getModel();
	}
	
	@Override
	protected List<Place> getModelChildren()
	{
		return getBigraph().getRoots();
	}	
}