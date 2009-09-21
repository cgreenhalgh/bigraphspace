package bigraph.biged.ui.graph.figures;

import org.eclipse.draw2d.BendpointLocator;
import org.eclipse.draw2d.Connection;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.handles.ConnectionHandle;

public class EdgeConnectionHandle extends ConnectionHandle
{

	public EdgeConnectionHandle(final ConnectionEditPart connectionPart, final int index)
	{
		super();
		// setFixed(true);
		setOwner(connectionPart);
		setLocator(new BendpointLocator((Connection) connectionPart.getFigure(), index));
	}

	@Override
	protected DragTracker createDragTracker()
	{
		return null;
	}
}
