/**
 * 
 */
package bigraphspace.gui;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;

/** Default Root renderer 
 * 
 * @author cmg
 *
 */
public class RootRenderer extends RectangleRenderer {
	/** cons */
	public RootRenderer() {
		dash = new float[] { 1.0f };
	}
	/** render */
	public void render(PlaceView placeView, Graphics2D graphics, Selection selection) {
		// clear
		graphics.clearRect((int)0, (int)0, (int)placeView.getBounds().getWidth(), (int)placeView.getBounds().getHeight());
		super.render(placeView, graphics, selection);
	}
}
