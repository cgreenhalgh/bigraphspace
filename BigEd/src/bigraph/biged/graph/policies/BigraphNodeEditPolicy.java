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
package bigraph.biged.graph.policies;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.swt.SWT;

public class BigraphNodeEditPolicy extends GraphicalNodeEditPolicy
{
	// private final Class<?> connectionClass;

	public BigraphNodeEditPolicy(final Class<?> connectionClass)
	{
		// this.connectionClass = connectionClass;
	}

	@Override
	protected Connection createDummyConnection(final Request req)
	{
		final PolylineConnection connection = new PolylineConnection();
		connection.setAntialias(SWT.ON);
		return connection;
	}

	/**
	 * @see GraphicalNodeEditPolicy#getConnectionCompleteCommand(CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCompleteCommand(final CreateConnectionRequest request)
	{
		// final CreateConnectionCommand cmd = (CreateConnectionCommand) request.getStartCommand();
		// if (cmd.setDestination((Resource) getHost().getModel())) { return cmd; }
		return null;
	}

	/**
	 * @see GraphicalNodeEditPolicy#getConnectionCreateCommand(CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCreateCommand(final CreateConnectionRequest request)
	{
		// final Resource source = (Resource) getHost().getModel();
		// final CreateConnectionCommand cmd = (CreateConnectionCommand) new
		// SimpleFactory(connectionClass).getNewObject();
		// if (cmd.setSource(source))
		// {
		// request.setStartCommand(cmd);
		// return cmd;
		// }
		return null;
	}

	/**
	 * @see GraphicalNodeEditPolicy#getReconnectSourceCommand(ReconnectRequest)
	 */
	@Override
	protected Command getReconnectSourceCommand(final ReconnectRequest request)
	{
		return null;
	}

	/**
	 * @see GraphicalNodeEditPolicy#getReconnectTargetCommand(ReconnectRequest)
	 */
	@Override
	protected Command getReconnectTargetCommand(final ReconnectRequest request)
	{
		return null;
	}
}