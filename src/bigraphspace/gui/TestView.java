/**
 * 
 */
package bigraphspace.gui;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JDialog;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import jbigraph.model.*;
import jbigraph.parser.ScriptNode;
import jbigraph.parser.NameNode;
import jbigraph.parser.AssignmentNode;
import jbigraph.parser.CompositionNode;
import jbigraph.parser.SimpleParser;
import jbigraph.signature.BasicSignature;
import jbigraph.signature.JsonParser;

/**
 * @author cmg
 *
 */
public class TestView implements java.awt.image.ImageObserver, MouseListener {
	/** logger */
	static Logger logger = Logger.getLogger(TestView.class);

	protected static final int ROOT_BORDER_WIDTH = 10;
	protected static final int NODE_BORDER_WIDTH = 7;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TestView().doMain(args);	
	}
	/** frame */
	protected JFrame frame;
	protected JTextArea console;
	protected JPanel canvas;
	/** root views */
	protected LinkedList<PlaceView> rootViews = new LinkedList<PlaceView>();
	/** link views */
	protected LinkedList<LinkView> linkViews = new LinkedList<LinkView>();
	/** selection */
	protected Selection selection = new Selection();
	/** instance main */
	protected void doMain(String[] args) {
		try {
			//File f = new File(args[0]);
			//System.out.println("Parsing file "+f);
			//String script = SimpleParser.readFile(f);

			canvas = new JPanel() {
				@Override
				public void paint(Graphics graphics) {
					// TODO Auto-generated method stub
					super.paint(graphics);
					paintBigraph((Graphics2D)graphics);
				}				
			};
			canvas.addMouseListener(this);
			JScrollPane scrollPane = new JScrollPane(canvas);
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("TestView");
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			JMenu fileMenu = new JMenu("File");
			menuBar.add(fileMenu);
			JMenuItem loadSignature = new JMenuItem(new AbstractAction("Load signature...") {
				public void actionPerformed(ActionEvent ae) {
					loadSignature();
				}
			});
			fileMenu.add(loadSignature);
			JMenuItem exit = new JMenuItem(new AbstractAction("Exit") {
				public void actionPerformed(ActionEvent ae) {
					System.exit(0);
				}
			});
			fileMenu.add(exit);
			JMenu insertMenu = new JMenu("Insert");
			menuBar.add(insertMenu);
			JMenuItem insertRoot = new JMenuItem(new AbstractAction("Root") {
				public void actionPerformed(ActionEvent ae) {
					insertRoot();
				}
			});
			insertMenu.add(insertRoot);
			JMenuItem insertSite = new JMenuItem(new AbstractAction("Site") {
				public void actionPerformed(ActionEvent ae) {
					insertSite();
				}
			});
			insertMenu.add(insertSite);
			JMenuItem insertNode = new JMenuItem(new AbstractAction("Node") {
				public void actionPerformed(ActionEvent ae) {
					insertNode();
				}
			});
			insertMenu.add(insertNode);
			frame.getContentPane().setLayout(new BorderLayout());
			JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			frame.getContentPane().add(splitPane, BorderLayout.CENTER);
			splitPane.setTopComponent(scrollPane);
			JPanel bottom = new JPanel();
			splitPane.setBottomComponent(bottom);
			bottom.setLayout(new BorderLayout());
			console = new JTextArea();
			console.setEditable(false);
			bottom.add(new JScrollPane(console), BorderLayout.CENTER);
			final JTextField text = new JTextField();
			text.addActionListener(new AbstractAction() {
				public void actionPerformed(ActionEvent ae) {
					String program = text.getText();
					if (viewProgram(program, canvas))
						// ok -> clear
						text.setText("");
				}
			});
			bottom.add(text, BorderLayout.SOUTH);
			/*
			JPanel buttons = new JPanel();
			buttons.setLayout(new FlowLayout());
			bottom.add(text, BorderLayout.CENTER);
			bottom.add(buttons, BorderLayout.SOUTH);
			buttons.add(new JButton(new AbstractAction("View") {
				public void actionPerformed(ActionEvent ae) {
					String program = text.getText();
					viewProgram(program, canvas);
				}
			} ));
			*/
			frame.getContentPane().setPreferredSize(new Dimension(600,600));
			frame.pack();
			splitPane.setDividerLocation(0.5);
			frame.setVisible(true);

			PlaceRenderer.setFontRenderContext(((Graphics2D)canvas.getGraphics()).getFontRenderContext());
		}
		catch (Exception e) {
			System.err.println("Error: "+e);
			e.printStackTrace(System.err);
		}
	}
	/** insert room - swing */
	protected void insertRoot() {
		Root root = new Root();
		PlaceView rootView = new PlaceView();
		rootView.setPlace(root);
		rootView.setPlaceRenderer(getRenderer(root));
		// lay out new Root view
		packView(rootView);
		int x=0, y=0;
		for (PlaceView view : rootViews) {
			if (view.getBounds().getX()+view.getBounds().getWidth()+ROOT_BORDER_WIDTH>x)
				x = (int)(view.getBounds().getX()+view.getBounds().getWidth()+ROOT_BORDER_WIDTH);
		}
		rootViews.add(rootView);
		bigraph.getRoots().add(root);
		rootView.getBounds().setRect(x, y, rootView.getBounds().getWidth(), rootView.getBounds().getHeight());
		repaint();
	}
	/** insert site - swing */
	protected void insertSite() {
		Site site = new Site();
		Place parent = this.getSelectedPlace();
		if (parent==null)
			return;
		insertPlace(parent, site);
	}
	/** insert node - swing */
	protected void insertNode() {
		Place parent = this.getSelectedPlace();
		if (parent==null)
			return;
		List<Control> controls = basicSignature.getControls();
		logger.debug("Found "+controls.size()+" controls in signature");
		if (controls.size()==0) {
			JOptionPane.showMessageDialog(frame, "Please load a signature to be able to insert a node", "No controls", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		JList controlList = new JList(controls.toArray());
		controlList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		final JDialog dialog = new JDialog(frame, "Controls", true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(new JScrollPane(controlList), BorderLayout.CENTER);
		JButton okButton = new JButton(new AbstractAction("OK") {
			public void actionPerformed(ActionEvent ae) {
				dialog.setVisible(false);
			}
		});
		panel.add(okButton, BorderLayout.SOUTH);
		dialog.setPreferredSize(new Dimension(200,400));
		dialog.pack();
		dialog.setVisible(true);
		Control control = (Control)controlList.getSelectedValue();
		if (control==null)
			return;
		logger.debug("Inserting "+control);
		Node node = new Node();
		node.setControl(control);
		// TODO arity?
		insertPlace(parent, node);
	}
	/** insert place */
	protected void insertPlace(Place parent, Place newChild) {
		if (newChild instanceof Node) {
			bigraph.getNodes().add((Node)newChild);
		} else if (newChild instanceof Site) {
			bigraph.getSites().add((Site)newChild);
		}
		else {
			logger.error("Cannot insert "+newChild);
		}
		newChild.setParent(parent);
		
		// refresh?!
		updateCanvas();
	}
	/** place in which to insert */
	protected Place getSelectedPlace() {
		// selected place?!
		List<Object> selections = selection.getSelections();
		if (selections.size()!=1) {
			JOptionPane.showMessageDialog(frame, "Select exactly one place", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if (selections.get(0) instanceof Place) {
			return (Place)selections.get(0);
		}
		JOptionPane.showMessageDialog(frame, "Select exactly one place", "Error", JOptionPane.ERROR_MESSAGE);
		return null;
	}
	/** bigraph */
	Bigraph bigraph = new Bigraph();
	/** interpreter state */
	protected HashMap<String,Bigraph> interpreterVariables = new HashMap<String,Bigraph>();
	/** evaluate script node */
	protected Bigraph evaluateScriptNode(ScriptNode scriptNode) {
		Bigraph bigraph = null;
		if (scriptNode instanceof AssignmentNode) {
			AssignmentNode assignmentNode = (AssignmentNode)scriptNode;
			bigraph = evaluateScriptNode(assignmentNode.getValueNode());
			interpreterVariables.put(assignmentNode.getName(), bigraph);
		}
		else if (scriptNode instanceof CompositionNode) {
			CompositionNode compositionNode = (CompositionNode)scriptNode;
			NameNode nameNode = new NameNode(compositionNode);
			
			Bigraph bigraph1 = evaluateScriptNode(compositionNode.getLhs());
			Bigraph bigraph2 = evaluateScriptNode(compositionNode.getRhs());
						
			bigraph = Operations.compose(bigraph1, bigraph2);
		}
		else if (scriptNode instanceof NameNode) {
			NameNode nameNode = (NameNode)scriptNode;
			if (interpreterVariables.containsKey(nameNode.getName()))
				bigraph = interpreterVariables.get(nameNode.getName());
			else
			{
				console.append("Undefined: "+nameNode.getName()+"\n");
			}
		}
		else if (scriptNode.getModelNode() instanceof Bigraph) {
			bigraph = (Bigraph)scriptNode.getModelNode();
		}
		else {
			logger.error("Unexpected script node "+scriptNode);
		}
		return bigraph;
	}
	/** view program */
	protected boolean viewProgram(String script, JComponent canvas) {
		SimpleParser parser = new SimpleParser();
		try {
			console.append(script);
			if (!script.endsWith("\n"))
				console.append("\n");
			
			ScriptNode scriptNode = parser.parse(script);
			bigraph = evaluateScriptNode(scriptNode);
			if (bigraph==null)
				return false;
			return updateCanvas();
		}
		catch (Exception e) {
			logger.error("Viewing", e);
			console.append("Error: "+e.toString());
			JOptionPane.showMessageDialog(frame, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
    protected boolean updateCanvas() {
    	try {
    		console.append("Bigraph: "+bigraph+"\n");

    		int textHeight = PlaceRenderer.getLetterHeight(LinkView.defaultFont);
			
			rootViews = new LinkedList<PlaceView>();

			double width = 0, height = 0;
			for (Root root : bigraph.getRoots()) {
				PlaceView view = makeView(root);
				packView(view);
				view.getBounds().setRect(width, textHeight, view.getBounds().getWidth(), view.getBounds().getHeight());
				rootViews.add(view);
				if (view.getBounds().getHeight() > height)
					height = view.getBounds().getHeight();
				if (width>0)
					width += ROOT_BORDER_WIDTH;
				width += view.getBounds().getWidth();
			}
			
			linkViews = new LinkedList<LinkView>();
			for (Edge edge : bigraph.getEdges()) {
				logger.debug("Edge "+edge.getIdentifier());
				LinkedList<Point> points = edge.getPoints();
				for (Point point : points) {
					if (point instanceof Port) {
						Port port = (Port)point;
						logger.debug(" -> Port "+port.getIndex()+" on "+port.getNode());
					}
					else if (point instanceof InnerName) {
						InnerName innerName = (InnerName)point;
						logger.debug(" -> InnerName "+innerName.getIdentifier());
					}
				}
				LinkView linkView = new LinkView();
				linkView.setLink(edge);
				linkViews.add(linkView);
			}
			for (OuterName outerName : bigraph.getOuterNames()) {
				logger.debug("OuterName "+outerName.getIdentifier());
				LinkedList<Point> points = outerName.getPoints();
				for (Point point : points) {
					if (point instanceof Port) {
						Port port = (Port)point;
						logger.debug(" -> Port "+port.getIndex()+" on "+port.getNode());
					}
					else if (point instanceof InnerName) {
						InnerName innerName = (InnerName)point;
						logger.debug(" -> InnerName "+innerName.getIdentifier());
					}
				}
				LinkView linkView = new LinkView();
				linkView.setLink(outerName);
				linkViews.add(linkView);
			}
			
			canvas.setPreferredSize(new Dimension((int)width, (int)height+2*textHeight));
			canvas.setSize(new Dimension((int)width, (int)height+2*textHeight));
			canvas.revalidate();
			return true;
		}
		catch (Exception e) {
			logger.error("Viewing", e);
			console.append("Error: "+e.toString());
			JOptionPane.showMessageDialog(frame, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	/** make view, recurse */
	protected PlaceView makeView(Place place) {
		List<Place> children = place.getChildren();
		PlaceView view = new PlaceView();
		view.setPlace(place);
		view.setPlaceRenderer(getRenderer(place));
		
		double innerWidth=0, innerHeight=0;
		for (Place child : children) {
			PlaceView childView = makeView(child);
			view.getChildren().add(childView);
		}

		return view;
	}
	/** pack/position view, recurse */
	protected void packView(PlaceView view) {
		List<PlaceView> children = view.getChildren();
		PlaceRenderer renderer = view.getPlaceRenderer();
		
		Rectangle innerBounds = new Rectangle();
		for (PlaceView child : children) {
			packView(child);
			Rectangle2D childBounds = child.getBounds();
			// child position relative to inner bounds
			childBounds.setRect(innerBounds.width, 0, childBounds.getWidth(), childBounds.getHeight());
			innerBounds.width += childBounds.getWidth()+NODE_BORDER_WIDTH;
			if (childBounds.getHeight()>innerBounds.getHeight())
				innerBounds.height = (int)childBounds.getHeight();
		}
		Rectangle outerBounds = new Rectangle();
		renderer.getOuterBounds(innerBounds, outerBounds);
		outerBounds.setLocation(0, 0);
		view.setBounds(outerBounds);
	}
	/** paint bigraph */
	protected void paintBigraph(Graphics2D graphics) {
		for (PlaceView rootView : rootViews) {			
			Rectangle2D bounds = rootView.getBounds();
			paintView((Graphics2D)graphics.create((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth()+1, (int)bounds.getHeight()+1), rootView);
		}
		for (LinkView linkView : linkViews) {
			linkView.render(graphics, bigraph, rootViews);
		}
	}
	/** paint view, recurse */
	protected void paintView(Graphics2D graphics, PlaceView view) {
		List<PlaceView> children = view.getChildren();
		PlaceRenderer renderer = view.getPlaceRenderer();
		renderer.render(view, graphics, selection);
		
		Rectangle innerBounds = new Rectangle();
		renderer.getInnerBounds(view.getBounds(), innerBounds);
		Graphics innerGraphics = graphics.create((int)(innerBounds.getX()-view.getBounds().getX()),
				(int)(innerBounds.getY()-view.getBounds().getY()),
				(int)innerBounds.getWidth(), (int)innerBounds.getHeight());
				
		for (PlaceView child : children) {
			Rectangle2D childBounds = child.getBounds();
			Graphics2D childGraphics = (Graphics2D)innerGraphics.create((int)childBounds.getX(), (int)childBounds.getY(), (int)childBounds.getWidth()+1, (int)childBounds.getHeight()+1);
			paintView(childGraphics, child);
			innerBounds.x += childBounds.getWidth()+NODE_BORDER_WIDTH;
		}
	}
	/** place renderer configuration */
	protected PlaceRendererConfiguration placeRendererConfiguration = new PlaceRendererConfiguration();
	/** get place renderer */
	protected PlaceRenderer getRenderer(Place place) {
		return placeRendererConfiguration.getRenderer(place);
	}
	/** signature */
	protected BasicSignature basicSignature = new BasicSignature();
	/** load signature (swing thread) */
	protected void loadSignature() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Load signature");
		int returnVal = chooser.showOpenDialog(frame);
	    if(returnVal != JFileChooser.APPROVE_OPTION) 
	    	return;
	    try {
	    	File f = chooser.getSelectedFile();
	    	logger.debug("Reading signature file "+f);
	    	String config = SimpleParser.readFile(f);
	    	JsonParser parser = new JsonParser();
	    	Object o = parser.parse(config);
	    	basicSignature.initialiseFromJsonObject(o);
	    	placeRendererConfiguration.initialiseFromJsonObject(o, this);
	    }
	    catch (Exception e) {
	    	logger.error("Reading signature", e);
	    	JOptionPane.showMessageDialog(frame, e.toString(), "Error reading signature", JOptionPane.ERROR_MESSAGE);
	    }
	}
	/** image update e.g. from renderer -> refresh */
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		logger.debug("image update");
		repaint();
		return false;
	}
	protected void repaint() {
		if (canvas!=null) 
		{
			canvas.repaint();	
		}
	}
	/** canvas interaction mouse event */
	public void mouseClicked(MouseEvent me) {
		if (me.getButton()==me.BUTTON1) {
			if (!me.isShiftDown())
				selection.clear();
			Object object = getBigraphElementAt(me.getX(), me.getY());
			if (object!=null) 
			{
				logger.debug("Selected "+object);
				selection.add(object);
			}
			repaint();
		}
	}
	/** find a bigraph element at/near a mouse location */
	protected Object getBigraphElementAt(int x, int y) {
		Object object = null;
		for (PlaceView rootView : rootViews) {
			Rectangle2D bounds = rootView.getBounds();
			object = getBigraphElementAt(rootView, x, y, object);
			if (object!=null)
				return object;
		}
		return object;
	}
	/** find a bigraph element at/near a mouse location starting at a PlaceView origin */
	protected Object getBigraphElementAt(PlaceView placeView, int x, int y, Object bestSoFar) {
		Rectangle2D bounds = placeView.getBounds();
		logger.debug("getBigraphElementAt ("+x+","+y+") vs ("+bounds.getX()+","+bounds.getY()+","+bounds.getWidth()+","+bounds.getHeight()+")");
		// offset
		x -= bounds.getX();
		y -= bounds.getY();
		// inner bounds
		
		if (x<0 || y<0)
			// nope
			return bestSoFar;
		// are we a candidate?
		if (x<bounds.getWidth() && y<bounds.getHeight()) {
			bestSoFar = placeView.getPlace();
			logger.debug("- made best so far: "+bestSoFar);
		}
		Rectangle2D innerBounds = placeView.getPlaceRenderer().getInnerBounds(bounds, null);
		x -= innerBounds.getX()-bounds.getX();
		y -= innerBounds.getY()-bounds.getY();
		// children? 
		for (PlaceView childView : placeView.getChildren()) {
			bestSoFar = getBigraphElementAt(childView, x, y, bestSoFar);
		}
		// TODO ports?
		return bestSoFar;
	}
	
	/** canvas interaction mouse event */
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/** canvas interaction mouse event */
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/** canvas interaction mouse event */
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/** canvas interaction mouse event */
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
//	/** singleton root renderer */
//	protected RootRenderer rootRenderer = new RootRenderer();
//	/** singleton site renderer */
//	protected SiteRenderer siteRenderer = new SiteRenderer();
//	/** singleton default node renderer */
//	protected RectangleRenderer defaultNodeRenderer = new RectangleRenderer();
//	/** control renderers */
//	protected Map<String,PlaceRenderer> controlRenderers = new HashMap<String,PlaceRenderer>();
//	/** get place renderer */
//	protected PlaceRenderer getRenderer(Place place) {
//		if (place instanceof Root)
//			return rootRenderer;
//		if (place instanceof Site)
//			return siteRenderer;
//		if (place instanceof Node) {
//			Node node = (Node)place;
//			Control control = node.getControl();
//			if (control!=null) {
//				if (controlRenderers.containsKey(control.getName()))
//					return controlRenderers.get(control.getName());
//			}
//		}
//		return defaultNodeRenderer;
//	}

}
