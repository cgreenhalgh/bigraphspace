package bigraph.biged.ui.graph.parts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import bigraph.biged.model.LinkSegment;
import bigraph.biged.model.Place;
import bigraph.biged.model.Port;
import bigraph.biged.ui.graph.figures.PlaceFigure;
import bigraph.biged.ui.graph.figures.PortConnectionAnchor;

public class PlacePart extends AbstractGraphicalEditPart implements NodeEditPart
{
	
	private Map<Port, ConnectionAnchor> portAnchors = new HashMap<Port, ConnectionAnchor>();
	
	/**
	 * @return the Content pane for adding or removing child figures
	 */
	@Override
	public IFigure getContentPane()
	{
		final PlaceFigure figure = (PlaceFigure) getFigure();
		return figure.getContainer();
	}

	private Place getPlace()
	{
		return (Place) getModel();
	}

	@Override
	protected void createEditPolicies()
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected List<LinkSegment> getModelSourceConnections()
	{
		return getPlace().getLinkSegments(true, false);
	}

	@Override
	protected List<LinkSegment> getModelTargetConnections()
	{
		return getPlace().getLinkSegments(false, true);
	}

	@Override
	protected IFigure createFigure()
	{
		return new PlaceFigure(getPlace());
	}

	@Override
	protected List<Place> getModelChildren()
	{
		return getPlace().getChildren();
	}
	
	@SuppressWarnings("unchecked")
	public ConnectionAnchor getConnectionAnchor(final Port port)
	{
		ConnectionAnchor anchor = portAnchors.get(port);
		if(anchor != null)
		{
			return anchor;
		}
		
		IFigure figure = getFigure();
		if(figure instanceof PlaceFigure)
		{
			figure = ((PlaceFigure)figure).getContainer(); 
		}
		
		anchor = new PortConnectionAnchor(figure, port, getViewer().getEditPartRegistry());
		
		portAnchors.put(port, anchor);
		
		return anchor;
	}
	
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
	{
		final Object model = connection.getModel();
		if(model instanceof LinkSegment)
		{
			final LinkSegment linkSegment = (LinkSegment)model;
			return getConnectionAnchor(linkSegment.getSource());
		}
		return null;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
	{
		final Object model = connection.getModel();
		if(model instanceof LinkSegment)
		{
			final LinkSegment linkSegment = (LinkSegment)model;
			return getConnectionAnchor(linkSegment.getTarget());
		}
		return null;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request)
	{
		// TODO Auto-generated method stub
		return null;
	}	
}