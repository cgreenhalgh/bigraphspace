package bigraph.biged.ui.graph.figures;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;

import bigraphspace.model.Place;

public class HiddenPlaceFigure extends PlaceFigure
{

	public HiddenPlaceFigure(final Place place)
	{
		super(place);
		
		final FlowLayout containerLayout = new FlowLayout();
		containerLayout.setMajorSpacing(15);
		containerLayout.setMinorSpacing(15);
		setLayoutManager(containerLayout);
	}

	@Override
	public IFigure getContainer()
	{
		return this;
	}

	@Override
	public void refresh()
	{
	}
}