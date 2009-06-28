/**
 * 
 */
package bigraphspace.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.Map;

/**
 * @author cmg
 *
 */
public class ImageRenderer extends RectangleRenderer implements java.awt.image.ImageObserver {
	/** cons */
	public ImageRenderer () {		
	}
	/** filename */
	protected String filename;
	/** image */
	protected Image image;
	/** image width */
	protected int imageWidth;
	/** image height */
	protected int imageHeight;
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
		try {
			logger.debug("Reading image "+image);
			image = java.awt.Toolkit.getDefaultToolkit().createImage(filename);
			// wait??
			imageWidth = image.getWidth(this);
			imageHeight = image.getHeight(this);
			updateBorders();
		}
		catch (Exception e) {
			logger.error("reading image "+image, e);
			throw new RuntimeException("Error reading image "+image+" for control renderer ("+e+")");
		}
	}
	/** property names */
	public static final String PROPERTY_IMAGE = "image";
	/* (non-Javadoc)
	 * @see jbigraph.graphics.PlaceRenderer#initialiseFromJsonObject(java.util.Map)
	 */
	@Override
	public void initialiseFromJsonObject(Map properties) {
		super.initialiseFromJsonObject(properties);

		if (!properties.containsKey(PROPERTY_IMAGE))
			throw new RuntimeException ("ImageRenderer must have image property in configuration");
		setFilename(properties.get(PROPERTY_IMAGE).toString());
	}
	/** calculate/set borders */
	protected void updateBorders() {
		minimumWidth[TOP] = 3+imageHeight+getLetterHeight();
		minimumWidth[LEFT] = minimumWidth[RIGHT] = 3+imageWidth/2;
	}
	/* (non-Javadoc)
	 * @see java.awt.image.ImageObserver#imageUpdate(java.awt.Image, int, int, int, int, int)
	 */
	//@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		logger.debug("Updating info for image "+filename+" to "+width+"x"+height+" image="+img);
		image = img;
		imageWidth = width;
		imageHeight = height;
		updateBorders();
		if (imageObserver!=null)
			imageObserver.imageUpdate(img, infoflags, x, y, width, height);
		return (infoflags & java.awt.image.ImageObserver.ALLBITS)==0 ||
		(infoflags & java.awt.image.ImageObserver.WIDTH)==0 ||
		(infoflags & java.awt.image.ImageObserver.WIDTH)==0;
	}
	/* (non-Javadoc)
	 * @see jbigraph.graphics.RectangleRenderer#render(jbigraph.graphics.PlaceView, java.awt.Graphics2D)
	 */
	@Override
	public void render(PlaceView placeView, Graphics2D graphics, Selection selection) {
		// TODO Auto-generated method stub
		super.render(placeView, graphics, selection);
		if (image!=null)
			graphics.drawImage(image, new AffineTransform(1f,0f,0f,1f,/*x*/3,/*y*/3+getLetterHeight()), null);
	}
	
}
