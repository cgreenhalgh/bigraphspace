package bigraph.biged.ui.graph.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;

import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;

public class SiteFigure extends PlaceFigure
{
	private static final int lineWidth = 2;
	private static final int arcLength = 16;
	private static final int margin = 15;

	private final Label name;
	private final RoundedRectangle container;

	public SiteFigure(final Place place)
	{
		super(place);
		name = new Label(BigraphLabelProvider.text(place));
		name.setLabelAlignment(PositionConstants.LEFT);

		container = new RoundedRectangle();
		container.setAntialias(SWT.ON);
		// container.setBorder(new RoundedLineBorder(Graphics.LINE_DASH, true));
		container.setBackgroundColor(ColorConstants.gray);
		container.setLineWidth(lineWidth);
		container.setLineStyle(Graphics.LINE_DASH);
		container.setCornerDimensions(new Dimension(arcLength, arcLength));
		container.setForegroundColor(ColorConstants.black);

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