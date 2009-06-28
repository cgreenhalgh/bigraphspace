package bigraphspace.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class SiteRenderer extends RectangleRenderer {
	/* (non-Javadoc)
	 * @see jbigraph.graphics.PlaceRenderer#render(jbigraph.graphics.PlaceView, java.awt.Graphics2D)
	 */
	@Override
	public void render(PlaceView placeView, Graphics2D graphics, Selection selection) {
		Color background = graphics.getBackground();
		fill = background.brighter();
		if (background.getGreen()+background.getRed()+background.getBlue()>3*255/2)
			fill = background.darker();
		
		super.render(placeView, graphics, selection);
	}

}
