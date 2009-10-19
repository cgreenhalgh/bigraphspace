package bigraph.biged.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.ide.IDE;

import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Utils;

/**
 * An example showing how to create a multi-page editor. This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class BigraphSignatureEditor extends FormEditor implements IResourceChangeListener
{
	// private BasicSignature signature;
	private Definitions definitions;

	/**
	 * Creates a multi-page editor example.
	 */
	public BigraphSignatureEditor()
	{
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IWorkbenchPart</code>
	 * method disposes all nested editors. Subclasses may extend.
	 */
	@Override
	public void dispose()
	{
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}

	/**
	 * Saves the multi-page editor's document.
	 */
	@Override
	public void doSave(final IProgressMonitor monitor)
	{
		getEditor(0).doSave(monitor);
	}

	/**
	 * Saves the multi-page editor's document as another file. Also updates the text for page 0's
	 * tab, and updates this multi-page editor's input to correspond to the nested editor's.
	 */
	@Override
	public void doSaveAs()
	{
		final IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}

	public Definitions getDefinitions()
	{
		return definitions;
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart
	 */
	public void gotoMarker(final IMarker marker)
	{
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}

	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method checks that the input
	 * is an instance of <code>IFileEditorInput</code>.
	 */
	@Override
	public void init(final IEditorSite site, final IEditorInput editorInput) throws PartInitException
	{
		if (!(editorInput instanceof IFileEditorInput)) { throw new PartInitException(
				"Invalid Input: Must be IFileEditorInput"); }
		super.init(site, editorInput);
		try
		{
			final IFile file = ((IFileEditorInput) editorInput).getFile();
			setPartName(file.getName());
			definitions = Utils.readDefinitions(file.getLocation().toFile());
			// signature = SignatureFactory.createSignature(definitions);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart.
	 */
	@Override
	public boolean isSaveAsAllowed()
	{
		return true;
	}

	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event)
	{
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE)
		{
			Display.getDefault().asyncExec(new Runnable()
			{
				public void run()
				{
					// final IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					// for (final IWorkbenchPage page : pages)
					// {
					// if (((FileEditorInput) editor.getEditorInput()).getFile().getProject()
					// .equals(event.getResource()))
					// {
					// final IEditorPart editorPart = page.findEditor(editor.getEditorInput());
					// page.closeEditor(editorPart, true);
					// }
					// }
				}
			});
		}
	}

	@Override
	protected void addPages()
	{
		try
		{
			addPage(new BigraphSignatureControlsPage(this, "1", "Controls"));
			addPage(new BigraphSignatureSortingsPage(this, "2", "Sortings"));
			addPage(new BigraphSignatureRulesPage(this, "3", "Rules"));
			addPage(new BigraphSignatureRenderersPage(this, "3", "Renderers"));
		}
		catch (final PartInitException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}