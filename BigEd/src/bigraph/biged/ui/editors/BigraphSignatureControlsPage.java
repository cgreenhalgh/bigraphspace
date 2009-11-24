package bigraph.biged.ui.editors;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import bigraph.biged.BigEdPlugin;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.sections.ControlSection;
import bigraph.biged.ui.sections.IndexSection;
import bigraph.biged.ui.sections.PortSection;
import bigraph.biged.ui.sections.RendererSection;
import bigraph.biged.ui.sections.SignatureSection;
import bigraph.biged.ui.sections.SortingSection;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;

public class BigraphSignatureControlsPage extends FormPage
{
	private final Definitions definitions;
	private final Collection<SignatureSection> sections = new HashSet<SignatureSection>();
	private TreeViewer viewer;

	public BigraphSignatureControlsPage(final Definitions definitions, final FormEditor editor, final String id, final String title)
	{
		super(editor, id, title);
		this.definitions = definitions;
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input)
	{
		super.init(site, input);
		if (viewer != null)
		{
			viewer.setInput(getDefinitions());
		}
	}

	@Override
	protected void createFormContent(final IManagedForm managedForm)
	{
		super.createFormContent(managedForm);
		final FormToolkit toolkit = managedForm.getToolkit();
		final ScrolledForm form = managedForm.getForm();
		form.setText("Controls");
		form.setImage(BigEdPlugin.getImage("control"));
		toolkit.decorateFormHeading(form.getForm());

		form.getBody().setLayout(new FormLayout());

		final Section tableSection = createTableSection(managedForm);
		
		SignatureSection controlSection = new ControlSection(definitions);
		controlSection.createSection(managedForm.getForm().getBody(), managedForm.getToolkit(), false);
		sections.add(controlSection);

		SignatureSection sortingSection = new SortingSection(definitions);
		sortingSection.createSection(managedForm.getForm().getBody(), managedForm.getToolkit(), true);
		sections.add(sortingSection);		
		
		SignatureSection rendererSection = new RendererSection(definitions);
		rendererSection.createSection(managedForm.getForm().getBody(), managedForm.getToolkit(), true);
		sections.add(rendererSection);		

		SignatureSection portSection = new PortSection(definitions);
		portSection.createSection(managedForm.getForm().getBody(), managedForm.getToolkit(), false);
		portSection.getSection().setVisible(false);
		sections.add(portSection);
		
		SignatureSection indexSection = new IndexSection(definitions);
		indexSection.createSection(managedForm.getForm().getBody(), managedForm.getToolkit(), false);
		indexSection.getSection().setVisible(false);
		sections.add(indexSection);	
		
		FormData data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(50, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		tableSection.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		portSection.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		controlSection.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(controlSection.getSection(), ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		sortingSection.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(sortingSection.getSection(), ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		rendererSection.setLayoutData(data);
		
		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		indexSection.setLayoutData(data);		
	}

	private Section createSection(final IManagedForm managedForm, final boolean collapsable)
	{
		final FormToolkit toolkit = managedForm.getToolkit();
		final ScrolledForm form = managedForm.getForm();
		int style = ExpandableComposite.TITLE_BAR;
		if (collapsable)
		{
			style = ExpandableComposite.TITLE_BAR | ExpandableComposite.TWISTIE;
		}
		final Section section = toolkit.createSection(form.getBody(), style);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
		section.setExpanded(true);

		final Composite client = toolkit.createComposite(section, SWT.WRAP);
		section.setClient(client);
		toolkit.paintBordersFor(client);

		return section;
	}

	private Section createTableSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm, false);
		final Composite client = (Composite) section.getClient();
		section.setText("Defined Controls");
		final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new FormLayout());
		final Tree t = toolkit.createTree(client, SWT.NULL);

		viewer = new TreeViewer(t);
		viewer.setLabelProvider(new BigraphLabelProvider());
		viewer.setContentProvider(new ITreeContentProvider()
		{
			public void dispose()
			{
			}

			@Override
			public Object[] getChildren(final Object parentElement)
			{
				if (parentElement instanceof Control)
				{
					final Collection<Object> objects = new HashSet<Object>();
					final Control control = (Control) parentElement;
					objects.addAll(control.getPort());
					objects.addAll(control.getIndex());
					return objects.toArray();
				}
				return null;
			}

			public Object[] getElements(final Object inputElement)
			{
				final Definitions definitions = getDefinitions();
				if (definitions != null && definitions.getSorts() != null) { return definitions.getControls()
						.getControl().toArray(); }
				return new Object[] {};
			}

			@Override
			public Object getParent(final Object element)
			{
				return null;
			}

			@Override
			public boolean hasChildren(final Object element)
			{
				if (element instanceof Control)
				{
					final Control control = (Control) element;
					return (!control.getPort().isEmpty()) || (!control.getIndex().isEmpty());
				}
				return false;
			}

			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
			{
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			@Override
			public void selectionChanged(final SelectionChangedEvent event)
			{
				final Object selection = getViewerSelection();
				for(SignatureSection section: sections)
				{
					section.setInput(selection);
				}
			}
		});
		viewer.setInput(getDefinitions());

		final Composite buttonComposite = toolkit.createComposite(client);
		final GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		buttonComposite.setLayout(gridLayout);

		FormData data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.right = new FormAttachment(buttonComposite, -ITabbedPropertyConstants.HSPACE, SWT.LEFT);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		t.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		buttonComposite.setLayoutData(data);

		final Button button1 = toolkit.createButton(buttonComposite, "Add Control", SWT.PUSH);
		button1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		final Button button2 = toolkit.createButton(buttonComposite, "Add Port", SWT.PUSH);
		button2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		final Button button3 = toolkit.createButton(buttonComposite, "Add Index", SWT.PUSH);
		button3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		return section;
	}

	private Definitions getDefinitions()
	{
		return ((BigraphSignatureEditor) getEditor()).getDefinitions();
	}

	private Object getViewerSelection()
	{
		if (viewer.getSelection().isEmpty()) { return null; }
		return ((IStructuredSelection) viewer.getSelection()).getFirstElement();
	}
}