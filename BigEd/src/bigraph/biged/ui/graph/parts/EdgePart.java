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
import java.util.List;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.handles.ConnectionHandle;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.requests.GroupRequest;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEventListener;
import bigraph.biged.model.Edge;
import bigraph.biged.ui.graph.figures.EdgeConnection;
import bigraph.biged.ui.graph.figures.EdgeConnectionHandle;

/**
 * @author <a href="ktg@cs.nott.ac.uk">Kevin Glover</a>
 */
public class EdgePart extends AbstractConnectionEditPart implements BigraphEventListener
{
	private final Bigraph bigraph;

	public EdgePart(final Bigraph bigraph)
	{
		this.bigraph = bigraph;
	}

	@Override
	public void activate()
	{
		if (isActive()) { return; }
		getBigraph().addListener(getModel(), this);
		super.activate();
	}

	@Override
	public void deactivate()
	{
		if (!isActive()) { return; }
		getBigraph().removeListener(getModel(), this);
		super.deactivate();
	}

	public Bigraph getBigraph()
	{
		return bigraph;
	}

	public Edge getEdge()
	{
		return (Edge) getModel();
	}

	@Override
	public void onPlaceEvent(final BigraphEvent event)
	{
		getFigure().revalidate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new BendpointEditPolicy()
		{
			@SuppressWarnings("unchecked")
			@Override
			protected List<ConnectionHandle> createSelectionHandles()
			{
				final List<ConnectionHandle> list = new ArrayList<ConnectionHandle>();
				final List<Bendpoint> bendpoints = (List<Bendpoint>) getConnection().getRoutingConstraint();
				final ConnectionEditPart connEP = (ConnectionEditPart) getHost();
				for (int index = 0; index < bendpoints.size(); index++)
				{
					list.add(new EdgeConnectionHandle(connEP, index));
				}
				return list;
			}

			@Override
			protected Command getCreateBendpointCommand(final BendpointRequest request)
			{
				return null;
			}

			@Override
			protected Command getDeleteBendpointCommand(final BendpointRequest request)
			{
				return null;
			}

			@Override
			protected Command getMoveBendpointCommand(final BendpointRequest request)
			{
				return null;
			}
		});
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
		return new EdgeConnection(getEdge(), getViewer());
	}

	@Override
	protected void fireSelectionChanged()
	{
		super.fireSelectionChanged();
		final PolylineConnection figure = (PolylineConnection) getFigure();
		if (getSelected() == 2)
		{
			figure.setLineWidth(3);
		}
		else
		{
			figure.setLineWidth(2);
		}
	}
}