package bigraph.biged.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.ide.IDE;

import bigraphspace.model.BasicSignature;

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
	private BigraphSignatureFormPage signaturePage;
	private Font font;
	private StyledText text;
	private BasicSignature signature;

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

	public BasicSignature getSignature()
	{
		return signature;
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
//					final IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
//					for (final IWorkbenchPage page : pages)
//					{
//						if (((FileEditorInput) editor.getEditorInput()).getFile().getProject()
//								.equals(event.getResource()))
//						{
//							final IEditorPart editorPart = page.findEditor(editor.getEditorInput());
//							page.closeEditor(editorPart, true);
//						}
//					}
				}
			});
		}
	}

	/**
	 * Sets the font related data to be applied to the text in page 2.
	 */
	void setFont()
	{
		final FontDialog fontDialog = new FontDialog(getSite().getShell());
		fontDialog.setFontList(text.getFont().getFontData());
		final FontData fontData = fontDialog.open();
		if (fontData != null)
		{
			if (font != null)
			{
				font.dispose();
			}
			font = new Font(text.getDisplay(), fontData);
			text.setFont(font);
		}
	}

	/**
	 * Creates the pages of the multi-page editor.
	 */
	@Override
	protected void createPages()
	{
		try
		{
			addPage(new BigraphSignatureFormPage(this, "id", "Signature"));
		}
		catch (PartInitException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Calculates the contents of page 2 when the it is activated.
	 */
	@Override
	protected void pageChange(final int newPageIndex)
	{
		super.pageChange(newPageIndex);
		if (newPageIndex == 2)
		{
			//sortWords();
		}
	}

	@Override
	protected void addPages()
	{
		// TODO Auto-generated method stub
		
	}
}
