/**
 * 
 */
package bigraphspace.gui;

import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;

/** Render as a basic rectangle
 * 
 * @author cmg
 *
 */
public class RectangleRenderer extends PlaceRenderer {

	/* (non-Javadoc)
	 * @see jbigraph.graphics.PlaceRenderer#render(jbigraph.graphics.PlaceView, java.awt.Graphics2D)
	 */
	@Override
	public void render(PlaceView placeView, Graphics2D graphics, Selection selection) {
		super.render(placeView, graphics, selection);
		if (fill!=null) {
			graphics.setColor(fill);
			graphics.fillRect((int)getPortWidth(), (int)this.getLetterHeight()+getPortWidth(), (int)placeView.getBounds().getWidth()-2*getPortWidth(), (int)placeView.getBounds().getHeight()-this.getLetterHeight()-2*getPortWidth());
		}
		graphics.setStroke(new BasicStroke((float)lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, this.dash!=null ? dash : defaultDash, 0f));
		if (color!=null)
			graphics.setColor(color);
		else
			graphics.setColor(getDefaultForeground(graphics));
		graphics.setFont(font!=null ? font : defaultFont);
		// override label
		String labelText = label;
		if (labelText==null)
			labelText = placeView.getLabel();
		if (labelText!=null)
			graphics.drawString(labelText, (int)getPortWidth(), (int)this.getLetterOffset());
		// TODO adjust for line width?
		graphics.drawRect((int)getPortWidth(), (int)this.getLetterHeight()+getPortWidth(), (int)placeView.getBounds().getWidth()-2*getPortWidth(), (int)placeView.getBounds().getHeight()-this.getLetterHeight()-2*getPortWidth());
	}

}
