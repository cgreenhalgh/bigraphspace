package bigraph.biged.ui.graph.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import bigraph.biged.model.LinkSegment;
import bigraph.biged.model.Place;
import bigraph.biged.ui.graph.figures.PlaceFigure;

public class PlacePart extends AbstractGraphicalEditPart
{
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
}