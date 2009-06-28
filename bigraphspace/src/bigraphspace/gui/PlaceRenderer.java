/**
 * 
 */
package bigraphspace.gui;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.BasicStroke;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import org.apache.log4j.Logger;
import java.util.Map;
/**
 * @author cmg
 *
 */
public abstract class PlaceRenderer {
	/** logger */
	static Logger logger = Logger.getLogger(PlaceRenderer.class);
	/** line width */
	protected double lineWidth;
	/** dash pattern */
	protected float dash[];
	/** default dash pattern - continuous */
	protected static final float defaultDash [] = new float[] { 1.0f, 0.0f };
	/** colour */
	protected Color color;
	/** fill colour */
	protected Color fill;
	/** font */
	protected Font font;
	/** font */
	protected static Font defaultFont = new Font("SansSerif", 0, 11);
	/** font render context */
	protected static FontRenderContext fontRenderContext;
	/** port width */
	protected int portWidth = 3;
	/** label */
	protected String label;
	/**
	 * @return the lineWidth
	 */
	public double getLineWidth() {
		return lineWidth;
	}
	/**
	 * @param lineWidth the lineWidth to set
	 */
	public void setLineWidth(double lineWidth) {
		this.lineWidth = lineWidth;
	}
	
	/**
	 * @return the dash pattern
	 */
	public float[] getDashPattern() {
		return dash;
	}
	/**
	 * @param dash the dash pattern to set
	 */
	public void setDashPattern(float[] dash) {
		this.dash = dash;
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/** get default foreground color */
	public Color getDefaultForeground(Graphics2D graphics) {
		Color background = graphics.getBackground();
		if (background.getGreen()+background.getRed()+background.getBlue()>3*255/2)
			return Color.BLACK;
		return Color.WHITE;
	}
	
	/**
	 * @return the fill
	 */
	public Color getFill() {
		return fill;
	}
	/**
	 * @param fill the fill to set
	 */
	public void setFill(Color fill) {
		this.fill = fill;
	}
	
	/** property names */
	public static final String PROPERTY_LINE_WIDTH = "width";
	/** property names */
	public static final String PROPERTY_COLOR = "color";
	/** property names */
	public static final String PROPERTY_LABEL = "label";
	
	/** initialise from parsed Json */
	public void initialiseFromJsonObject(Map properties) {
		// TODO
		if (properties.containsKey(PROPERTY_LINE_WIDTH))
			setLineWidth((Integer)properties.get(PROPERTY_LINE_WIDTH));
		// TODO color
	}

	/**
	 * @param fontRenderContext the fontRenderContext to set
	 */
	public static void setFontRenderContext(FontRenderContext fontRenderContext) {
		PlaceRenderer.fontRenderContext = fontRenderContext;
	}
	/** get letter height */
	protected int getLetterHeight() {
		if (font!=null)
			return getLetterHeight(font);
		return getLetterHeight(defaultFont);
	}
	/** get letter height */
	public static int getLetterHeight(Font font) {
		if (fontRenderContext==null) {
			return 20;
		}
		return (int)font.getMaxCharBounds(fontRenderContext).getHeight()+2;
	}
	/** get letter offset*/
	protected int getLetterOffset() {
		if (font!=null)
			return getLetterOffset(font);
		return getLetterOffset(defaultFont);
	}
	/** get letter offset*/
	public static int getLetterOffset(Font font) {
		if (fontRenderContext==null)
			return 17;
		return -(int)font.getMaxCharBounds(fontRenderContext).getY();
	}
	/**
	 * @return the portWidth
	 */
	public int getPortWidth() {
		return portWidth;
	}
	/**
	 * @param portWidth the portWidth to set
	 */
	public void setPortWidth(int portWidth) {
		this.portWidth = portWidth;
	}
	/** render. Called with graphics context with 0,0 at top left to render */
	public void render(PlaceView placeView, Graphics2D graphics, Selection selection) {
		// clear
		graphics.clearRect(0, 0, (int)placeView.getBounds().getWidth(), (int)placeView.getBounds().getHeight());
		if (selection.isSelected(placeView.getPlace())) {
			graphics.setColor(Color.RED);
			graphics.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, defaultDash, 0f));
			graphics.drawRect(0, 0, (int)placeView.getBounds().getWidth()-1, (int)placeView.getBounds().getHeight()-1);
		}
		renderPorts(placeView, graphics, selection);
	}
	/** render ports. Called with graphics context with 0,0 at top left to render */
	public void renderPorts(PlaceView placeView, Graphics2D graphics, Selection selection) {
		int arity = placeView.getArity();
		if (color!=null)
			graphics.setColor(color);
		else
			graphics.setColor(getDefaultForeground(graphics));
		logger.debug("renderPorts "+placeView.getPlace()+" arity="+arity);
		for (int i=0; i<arity; i++) {
			Point2D portLocation = getPortLocation(placeView.getBounds(), i, arity, new Point());
			logger.debug("renderPorts port "+i+" at ("+portLocation.getX()+","+portLocation.getY()+")");
			graphics.fillOval((int)portLocation.getX()-getPortWidth()/2, (int)portLocation.getY()-getPortWidth()/2, getPortWidth(), getPortWidth());
		}
	}
	protected double minimumWidth[] = new double[] {  3, 3, 3, 3 };
	protected double widthScaleFactor[] = new double[] { 0, 0, 0, 0 };
	protected final int LEFT = 0;
	protected final int RIGHT = 1;
	protected final int TOP = 2;
	protected final int BOTTOM = 3;
	/** from inner bounds get outer bounds */
	public Rectangle2D getOuterBounds(Rectangle2D innerBounds, Rectangle2D outerBounds) {
		if (outerBounds==null)
			outerBounds = new Rectangle();
		double width[] = new double[4];
		for (int i=0; i<4; i++) 
			width[i] = lineWidth+minimumWidth[i]+getPortWidth()+((i==LEFT || i==RIGHT) ? innerBounds.getWidth() : innerBounds.getHeight())*widthScaleFactor[i];
		width[TOP] += getLetterHeight();
		outerBounds.setRect(innerBounds.getX()-width[LEFT], innerBounds.getY()-width[TOP],
				innerBounds.getWidth()+width[LEFT]+width[RIGHT],
				innerBounds.getHeight()+width[TOP]+width[BOTTOM]);
		logger.debug(this+" outer("+outerBounds.getX()+","+outerBounds.getY()+","+outerBounds.getWidth()+","+outerBounds.getHeight()+")<-("+
				innerBounds.getX()+","+innerBounds.getY()+","+innerBounds.getWidth()+","+innerBounds.getHeight()+"), text="+this.getLetterOffset()+"/"+this.getLetterHeight());
		return outerBounds;
	}
	/** from outer bounds get inner bounds */
	public Rectangle2D getInnerBounds(Rectangle2D outerBounds, Rectangle2D innerBounds) {
		if (innerBounds==null)
			innerBounds = new Rectangle();
		double innerWidth = (outerBounds.getWidth()-(2*lineWidth)-
				minimumWidth[LEFT]-minimumWidth[RIGHT]-2*getPortWidth())/
				(1+widthScaleFactor[LEFT]+widthScaleFactor[RIGHT]);
		double innerHeight = (outerBounds.getHeight()-(2*lineWidth)-
				getLetterHeight()-
				minimumWidth[TOP]-minimumWidth[BOTTOM]-2*getPortWidth())/
				(1+widthScaleFactor[TOP]+widthScaleFactor[BOTTOM]);
		innerBounds.setRect(
				outerBounds.getX()+lineWidth+minimumWidth[LEFT]+getPortWidth()+innerWidth*widthScaleFactor[LEFT],
				outerBounds.getY()+lineWidth+minimumWidth[TOP]+getPortWidth()+getLetterHeight()+innerHeight*widthScaleFactor[TOP],
				innerWidth, innerHeight);
		logger.debug(this+" outer("+outerBounds.getX()+","+outerBounds.getY()+","+outerBounds.getWidth()+","+outerBounds.getHeight()+")->("+
				innerBounds.getX()+","+innerBounds.getY()+","+innerBounds.getWidth()+","+innerBounds.getHeight()+"), text="+this.getLetterOffset()+"/"+this.getLetterHeight());
		return innerBounds;
	}
	/** get port location in local coordinates - default is along top edge. */
	public Point2D getPortLocation(Rectangle2D outerBounds, int index, int arity, Point2D portLocation) {
		if(portLocation==null)
			portLocation = new Point();
		double ratio = (index+0.5)/arity;
		portLocation.setLocation(getPortWidth()+(outerBounds.getWidth()-2*getPortWidth())*ratio, this.getLetterHeight()+getPortWidth()/2);
		return portLocation;
	}
	/** get port wire default (away) direction. Default: up. */
	public Point2D getPortNormal(Rectangle2D outerBounds, int index, int arity, Point2D portNormal) {
		if(portNormal==null)
			portNormal = new Point();
		portNormal.setLocation(0, -1);
		return portNormal;
	}
	/** external image observer callback -> refresh view - for subclass(es) */
	protected java.awt.image.ImageObserver  imageObserver;
	
	/**
	 * @return the imageObserver
	 */
	public java.awt.image.ImageObserver getImageObserver() {
		return imageObserver;
	}
	/**
	 * @param imageObserver the imageObserver to set
	 */
	public void setImageObserver(java.awt.image.ImageObserver imageObserver) {
		this.imageObserver = imageObserver;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}	
}
