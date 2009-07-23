package bigraph.biged.ui.editors;

import java.util.EventObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.ModelLoader;
import bigraph.biged.model.XMLModelLoader;
import bigraph.biged.ui.graph.parts.BigraphEditPartFactory;
import bigraph.biged.ui.graph.parts.BigraphTreeEditPartFactory;

public class BigraphEditor extends GraphicalEditorWithFlyoutPalette
{
	public class BigraphOutlinePage extends ContentOutlinePage
	{
		/**
		 * Create a new outline page for the shapes editor.
		 * 
		 * @param viewer
		 *            a viewer (TreeViewer instance) used for this outline page
		 * @throws IllegalArgumentException
		 *             if editor is null
		 */
		public BigraphOutlinePage()
		{
			super(new TreeViewer());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		public void createControl(final Composite parent)
		{
			// create outline viewer page
			getViewer().createControl(parent);
			// configure outline viewer
			getViewer().setEditDomain(getEditDomain());
			getViewer().setEditPartFactory(new BigraphTreeEditPartFactory());
			// configure & add context menu to viewer
			// final ContextMenuProvider cmProvider = new
			// ShapesEditorContextMenuProvider(getViewer(),
			// getActionRegistry());
			// getViewer().setContextMenu(cmProvider);
			// getSite().registerContextMenu("org.eclipse.gef.examples.shapes.outline.contextmenu",
			// cmProvider,
			// getSite().getSelectionProvider());
			// hook outline viewer
			getSelectionSynchronizer().addViewer(getViewer());
			// initialize outline viewer with model
			getViewer().setContents(getModel());
			// show outline viewer
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#dispose()
		 */
		@Override
		public void dispose()
		{
			// unhook outline viewer
			getSelectionSynchronizer().removeViewer(getViewer());
			// dispose
			super.dispose();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#getControl()
		 */
		@Override
		public Control getControl()
		{
			return getViewer().getControl();
		}

		/**
		 * @see org.eclipse.ui.part.IPageBookViewPage#init(org.eclipse.ui.part.IPageSite)
		 */
		@Override
		public void init(final IPageSite pageSite)
		{
			super.init(pageSite);
			final ActionRegistry registry = getActionRegistry();
			final IActionBars bars = pageSite.getActionBars();
			String id = ActionFactory.UNDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.REDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.DELETE.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
		}
	}

	private Bigraph bigraph;
	private BigraphOutlinePage outlinePage;

	public BigraphEditor()
	{
		setEditDomain(new DefaultEditDomain(this));
	}

	@Override
	public void commandStackChanged(final EventObject event)
	{
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	@Override
	public void doSave(final IProgressMonitor monitor)
	{
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(final Class type)
	{
		// returns the content outline page for this editor
		if (type == IContentOutlinePage.class)
		{
			if (outlinePage == null)
			{
				outlinePage = new BigraphOutlinePage();
			}
			return outlinePage;
		}
		return super.getAdapter(type);
	}

	@Override
	protected void configureGraphicalViewer()
	{
		super.configureGraphicalViewer();

		final GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new BigraphEditPartFactory());
		viewer.setRootEditPart(new ScalableRootEditPart());
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));

		// final ContextMenuProvider cmProvider = new ShapesEditorContextMenuProvider(viewer,
		// getActionRegistry());
		// viewer.setContextMenu(cmProvider);
		// getSite().registerContextMenu(cmProvider, viewer);
	}

	@Override
	protected PaletteRoot getPaletteRoot()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initializeGraphicalViewer()
	{
		super.initializeGraphicalViewer();

		final GraphicalViewer graphicalViewer = getGraphicalViewer();
		graphicalViewer.setContents(getModel());
		// graphicalViewer.addDropTargetListener(createTransferDropTargetListener());
	}

	@Override
	protected void setInput(final IEditorInput input)
	{
		super.setInput(input);
		try
		{
			final IFile file = ((IFileEditorInput) input).getFile();

			final ModelLoader loader = new XMLModelLoader();
			bigraph = loader.loadModel(file.getContents());

			setPartName(file.getName());
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	Bigraph getModel()
	{
		return bigraph;
	}
}