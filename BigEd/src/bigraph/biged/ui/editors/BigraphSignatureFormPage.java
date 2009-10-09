package bigraph.biged.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.signaturexml.SignatureFactory;

public class BigraphSignatureFormPage extends FormPage
{
	private BasicSignature signature;
	private TableViewer viewer;

	public BigraphSignatureFormPage(final FormEditor editor, final String id, final String title)
	{
		super(editor, id, title);
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input)
	{
		super.init(site, input);
		if(input instanceof IFileEditorInput)	
		{
			final IFile file = ((IFileEditorInput)input).getFile();
			try
			{
				signature = SignatureFactory.readSignature(file.getLocation().toFile());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		if(viewer != null)
		{
			viewer.setInput(signature);
		}
	}

	@Override
	protected void createFormContent(final IManagedForm managedForm)
	{
		super.createFormContent(managedForm);
		final FormToolkit toolkit = managedForm.getToolkit();
		final ScrolledForm form = managedForm.getForm();
		form.setText("Signature");
		toolkit.decorateFormHeading(form.getForm());
		final ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		form.getBody().setLayout(layout);
		final Section section = toolkit.createSection(form.getBody(), ExpandableComposite.TITLE_BAR);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
//		final FormText description = toolkit.createFormText(section, false);
//		description
//				.setText(
//							"<form><p>This description uses FormText widget and as a result can have <b>bold</b> text.</p></form>",
//							true, false);
//		section.setDescriptionControl(description);

		final Composite client = toolkit.createComposite(section, SWT.WRAP);
		final GridLayout grlayout = new GridLayout();
		grlayout.numColumns = 2;

		client.setLayout(grlayout);
		final Table t = toolkit.createTable(client, SWT.NULL);
		
		viewer = new TableViewer(t);
		viewer.setLabelProvider(new BigraphLabelProvider());
		viewer.setContentProvider(new IStructuredContentProvider()
		{
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
			{	
			}
			
			@Override
			public void dispose()
			{
			}
			
			@Override
			public Object[] getElements(Object inputElement)
			{
				if(signature != null)
				{
					return signature.getControls().toArray();
				}
				return null;
			}
		});
		viewer.setInput(signature);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 200;
		gd.widthHint = 100;
		t.setLayoutData(gd);
		toolkit.paintBordersFor(client);
		final Button b = toolkit.createButton(client, "Add...", SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		b.setLayoutData(gd);
		section.setText("Controls");
		section.setClient(client);
		section.setExpanded(true);
		section.addExpansionListener(new ExpansionAdapter()
		{
			@Override
			public void expansionStateChanged(final ExpansionEvent e)
			{
				form.reflow(false);
			}
		});
	}
}
