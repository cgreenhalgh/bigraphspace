/**
 * 
 */
package bigraphspace.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import jbigraph.model.*;

/** View of a Link
 * 
 * @author cmg
 *
 */
public class LinkView {
	/** logger */
	static Logger logger = Logger.getLogger(LinkView.class);
	/** link */
	protected Link link;
	/** colour */
	protected Color color;
	/** font */
	protected Font font;
	/** font */
	protected static Font defaultFont = new Font("SansSerif", 0, 11);
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
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}
	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}
	/**
	 * @return the link
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(Link link) {
		this.link = link;
	}
	
	/** point info */
	protected static class PointInfo {
		Point point;
		Point2D location;
		Point2D normal;		
		String label;
	}
	
	/** link rendering not pluggable (at least for now) - one style. */
	public void render(Graphics2D graphics, Bigraph bigraph, LinkedList<PlaceView> rootViews) {
		logger.debug("Render link "+link.getIdentifier());
		int letterHeight = PlaceRenderer.getLetterHeight(font!=null ? font : defaultFont);
		int letterOffset = PlaceRenderer.getLetterOffset(font!=null ? font : defaultFont);
		int width = 0, height = 0;
		for (PlaceView placeView : rootViews) {
			if (placeView.getBounds().getX()+placeView.getBounds().getWidth()>width)
				width = (int)(placeView.getBounds().getX()+placeView.getBounds().getWidth());
			if (placeView.getBounds().getY()+placeView.getBounds().getHeight()>height)
				height = (int)(placeView.getBounds().getY()+placeView.getBounds().getHeight());
		}
		LinkedList<PointInfo> pointInfos = new LinkedList<PointInfo>();
		// outer name as point
		if (link instanceof OuterName) {
			OuterName outerName = (OuterName)link;
			PointInfo pi = new PointInfo();
			pi.normal = new java.awt.Point(0, 1);
			// TODO location?
			int index = bigraph.getOuterNames().indexOf(outerName);
			pi.location = new java.awt.Point(width*index/bigraph.getOuterNames().size(), letterHeight);
			pi.label = outerName.getIdentifier().getText();
			pointInfos.add(pi);
		}
		// find points...
		for (Point point : link.getPoints()) {
			PointInfo pi = new PointInfo();
			pi.point = point;
			if (point instanceof InnerName) {
				InnerName innerName = (InnerName)point;
				pi.normal = new java.awt.Point(0, -1);
				// TODO location?
				pi.location = new java.awt.Point(0, height);
				pi.label = innerName.getIdentifier().getText();
			}
			else if (point instanceof Port) {
				Port port = (Port)point;
				pi.location = new java.awt.Point();
				pi.normal = new java.awt.Point();
				if (!findPort(pi, rootViews)) {
					logger.error("Could not find port "+port+" in PlaceViews");
					continue;
				}
			}
			pointInfos.add(pi);
		}
		if (pointInfos.size()==0) {
			logger.debug("Link "+link+" found no Points");
			return;
		}
		
		if (color!=null)
			graphics.setColor(color);
		else
			graphics.setColor(getDefaultForeground(graphics));
		graphics.setFont(font!=null ? font : defaultFont);
		
		PointInfo pi1 = pointInfos.get(0);		
		if (pi1.label!=null) {
			graphics.drawString(pi1.label, (int) pi1.location.getX(), (int)pi1.location.getY()+letterOffset-(pi1.point==null ? letterHeight : 0));
		}
		if (pointInfos.size()==1) {
			logger.debug("Link "+link+" found only one Point");
			return;
		}
		// TODO draw better :-)
		for (int i=1; i<pointInfos.size(); i++) {
			PointInfo pi = pointInfos.get(i);
			// from pi1 to pi
			graphics.drawLine((int)pi1.location.getX(), (int)pi1.location.getY(), (int)pi.location.getX(), (int)pi.location.getY());
			if (pi.label!=null)
				graphics.drawString(pi.label, (int) pi.location.getX(), (int)pi.location.getY()+letterOffset);				
		}
	}
	/** find Port and position */
	protected boolean findPort(PointInfo pi, LinkedList<PlaceView> rootViews) {
		java.awt.Point origin = new java.awt.Point();
		for (PlaceView rootView : rootViews)
			if (findPort(pi, rootView, origin))
				return true;
		return false;
	}
	/** find Port and position */
	protected boolean findPort(PointInfo pi, PlaceView view, Point2D origin) {
		java.awt.Point localOrigin = new java.awt.Point();
		Rectangle2D outerBounds = view.getBounds();
		localOrigin.setLocation(origin.getX()+outerBounds.getX(), origin.getY()+outerBounds.getY());
		Place place = view.getPlace();
		if (place instanceof Node) {
			Node node = (Node)place;
			List<Port> ports = node.getPorts();
			for (Port port : ports) {
				// object identity?!
				if (pi.point==port) {
					PlaceRenderer renderer = view.getPlaceRenderer();
					renderer.getPortLocation(view.getBounds(), port.getIndex(), view.getArity(), pi.location);
					renderer.getPortNormal(view.getBounds(), port.getIndex(), view.getArity(), pi.normal);
					pi.location.setLocation(pi.location.getX()+localOrigin.getX(), pi.location.getY()+localOrigin.getY());
					pi.normal.setLocation(pi.normal.getX()+localOrigin.getX(), pi.normal.getY()+localOrigin.getY());
					return true;
				}
			}
		}
		// inner bound offset scopes child position
		Rectangle2D innerBounds = view.getPlaceRenderer().getInnerBounds(outerBounds, null);
		localOrigin.setLocation(origin.getX()+innerBounds.getX(), origin.getY()+innerBounds.getY());
		// children
		for (PlaceView childView : view.getChildren()) {
			if (findPort(pi, childView, localOrigin))
				return true;
		}
		return false;
	}
}
