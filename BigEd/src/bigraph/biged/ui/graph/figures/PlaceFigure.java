package bigraph.biged.ui.graph.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;

import bigraphspace.model.Place;

public abstract class PlaceFigure extends Figure
{
	protected final Place place;

	public PlaceFigure(final Place place)
	{
		this.place = place;
	}
	
	public abstract IFigure getContainer();
	
	public abstract void refresh();
}