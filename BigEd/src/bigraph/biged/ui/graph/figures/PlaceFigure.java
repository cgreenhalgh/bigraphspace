package bigraph.biged.ui.graph.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;

import bigraph.biged.model.Place;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.PlaceType;

public class PlaceFigure extends Figure
{
	private static final int lineWidth = 2;
	private static final int arcLength = 16;
	private static final int margin = 15;

	private final Label name;
	private final IFigure container;
	private final Place place;

	public PlaceFigure(final Place place)
	{
		this.place = place;
		name = new Label(BigraphLabelProvider.text(place));
		name.setLabelAlignment(PositionConstants.LEFT);

		if (place.getType() == PlaceType.root)
		{
			final RoundedRectangle rect = new RoundedRectangle();
			rect.setAntialias(SWT.ON);
			rect.setLineWidth(lineWidth);
			rect.setLineStyle(Graphics.LINE_DASH);
			rect.setCornerDimensions(new Dimension(arcLength, arcLength));
			rect.setForegroundColor(ColorConstants.black);

			container = rect;
		}
		else if (place.getType() == PlaceType.site)
		{
			final RoundedRectangle rect = new RoundedRectangle();
			rect.setAntialias(SWT.ON);
			// container.setBorder(new RoundedLineBorder(Graphics.LINE_DASH, true));
			rect.setBackgroundColor(ColorConstants.gray);
			rect.setLineWidth(lineWidth);
			rect.setLineStyle(Graphics.LINE_DASH);
			rect.setCornerDimensions(new Dimension(arcLength, arcLength));
			rect.setForegroundColor(ColorConstants.black);
			container = rect;
		}
		else
		{
			final RectangleFigure rect = new RectangleFigure();
			rect.setLineWidth(lineWidth);
			rect.setForegroundColor(ColorConstants.black);
			container = rect;
		}

		final FlowLayout containerLayout = new FlowLayout();
		containerLayout.setMajorSpacing(margin);
		containerLayout.setMinorSpacing(margin);

		container.setBorder(new MarginBorder(margin));
		container.setLayoutManager(containerLayout);

		final ToolbarLayout layout = new ToolbarLayout();
		layout.setVertical(true);
		layout.setStretchMinorAxis(true);
		layout.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);
		setForegroundColor(ColorConstants.black);
		setLayoutManager(layout);
		setOpaque(false);

		add(name);
		add(container);
	}

	public IFigure getContainer()
	{
		return container;
	}

	public void refresh()
	{
		name.setText(BigraphLabelProvider.text(place));
		
	}
}