package bigraph.biged.ui.editors;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.EventObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.content.IContentType;
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
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.Bigraph;
import bigraph.biged.ui.graph.parts.BigraphEditPartFactory;
import bigraph.biged.ui.graph.parts.BigraphTreeEditPartFactory;
import bigraphspace.io.BigraphReader;
import bigraphspace.io.BigraphWriter;
import bigraphspace.io.IOConstants;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.xml.XmlIOFactory;

public class BigraphEditor extends GraphicalEditorWithFlyoutPalette implements ITabbedPropertySheetPageContributor
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
			getViewer().createControl(parent);
			getViewer().setEditDomain(getEditDomain());
			getViewer().setEditPartFactory(new BigraphTreeEditPartFactory());
			getSelectionSynchronizer().addViewer(getViewer());
			getViewer().setContents(getBigraph());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#dispose()
		 */
		@Override
		public void dispose()
		{
			getSelectionSynchronizer().removeViewer(getViewer());
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

	protected Bigraph bigraph;

	private BigraphOutlinePage outlinePage;
	private String format;

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
		try
		{
			final StringWriter string = new StringWriter();
			final BigraphWriter writer = XmlIOFactory.getWriter(format);
			writer.write(bigraph.getBigraph(), string);

			final IFile file = ((IFileEditorInput) getEditorInput()).getFile();
			file.setContents(new ByteArrayInputStream(string.toString().getBytes()), true, true, monitor);
			getCommandStack().markSaveLocation();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
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
		else if (type == IPropertySheetPage.class) { return new TabbedPropertySheetPage(this); }
		return super.getAdapter(type);
	}

	public Bigraph getBigraph()
	{
		return bigraph;
	}

	public String getContributorId()
	{
		return "bigraph.biged.ui.properties.contributor";
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
		return BigraphEditorPaletteFactory.createPalette(this);
	}

	@Override
	protected void initializeGraphicalViewer()
	{
		super.initializeGraphicalViewer();

		final GraphicalViewer graphicalViewer = getGraphicalViewer();
		graphicalViewer.setContents(getBigraph());
		// graphicalViewer.addDropTargetListener(createTransferDropTargetListener());
	}

	@Override
	protected void setInput(final IEditorInput input)
	{
		super.setInput(input);
		try
		{
			final IFile file = ((IFileEditorInput) input).getFile();
			final IContentType contentType = IDE.getContentType(file);
			if (contentType.getId().equals("bigraph.biged.bigraphBTL"))
			{
				format = IOConstants.FORMAT_BTL;
			}
			else
			{
				format = IOConstants.FORMAT_XML;
			}
			final BigraphReader reader = XmlIOFactory.getReader(format, new BasicSignature());
			bigraph = new Bigraph(reader.read(file.getContents()));
			bigraph.setName(file.getName());
			setPartName(file.getName());
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
}