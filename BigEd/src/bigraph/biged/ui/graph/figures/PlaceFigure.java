package bigraph.biged.ui.graph.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.SWT;

import bigraph.biged.model.Place;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.PlaceType;

public class PlaceFigure extends Figure
{
	private class RoundedLineBorder extends LineBorder
	{
		private int arcLength = 16;
		private final int margin = 5;

		public RoundedLineBorder(final int style, final boolean rounded)
		{
			super(null, 2, style);
			if (rounded)
			{
				arcLength = 16;
			}
			else
			{
				arcLength = 0;
			}
		}

		@Override
		public Insets getInsets(final IFigure figure)
		{
			// TODO Auto-generated method stub
			return new Insets(getWidth()+margin);
		}

		/**
		 * @see org.eclipse.draw2d.Border#paint(IFigure, Graphics, Insets)
		 */
		@Override
		public void paint(final IFigure figure, final Graphics graphics, final Insets insets)
		{
			tempRect.setBounds(getPaintRectangle(figure, insets));
			if (getWidth() % 2 == 1)
			{
				tempRect.width--;
				tempRect.height--;
			}
			tempRect.shrink(getWidth() / 2, getWidth() / 2);
			graphics.setLineWidth(getWidth());
			graphics.setLineStyle(getStyle());
			if (getColor() != null)
			{
				graphics.setForegroundColor(getColor());
			}
			graphics.setAntialias(SWT.ON);
			if(getBackgroundColor() != null)
			{
				graphics.setBackgroundColor(getBackgroundColor());
				//graphics.fillRoundRectangle(tempRect, arcLength, arcLength);				
			}
			graphics.drawRoundRectangle(tempRect, arcLength, arcLength);
		}
	}

	private final Label name;
	private final IFigure container;

	public PlaceFigure(final Place place)
	{
		name = new Label(BigraphLabelProvider.text(place));
		name.setLabelAlignment(PositionConstants.LEFT);

		container = new Figure();
		if (place.getType() == PlaceType.root)
		{
			container.setBorder(new RoundedLineBorder(Graphics.LINE_DASH, true));
			setBackgroundColor(null);				
		}
		else if(place.getType() == PlaceType.site)
		{
			container.setBorder(new RoundedLineBorder(Graphics.LINE_DASH, true));			
			setBackgroundColor(ColorConstants.gray);			
		}
		else
		{
			container.setBorder(new RoundedLineBorder(Graphics.LINE_SOLID, false));
			setBackgroundColor(null);			
		}

		
		setBorder(new MarginBorder(10));
		container.setLayoutManager(new ToolbarLayout());

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
}