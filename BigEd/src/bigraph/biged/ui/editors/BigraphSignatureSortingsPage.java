package bigraph.biged.ui.editors;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
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
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.widget.LabelledText;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Sort;

public class BigraphSignatureSortingsPage extends FormPage
{
	private TreeViewer viewer;

	public BigraphSignatureSortingsPage(final FormEditor editor, final String id, final String title)
	{
		super(editor, id, title);
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
		form.setText("Sortings");
		toolkit.decorateFormHeading(form.getForm());
		final ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		form.getBody().setLayout(layout);

		createTableSection(managedForm);
		createDetailSection(managedForm);
	}

	private Section createDetailSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		section.setText("Control Details");
		final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new FillLayout(SWT.VERTICAL));

		final LabelledText text = new LabelledText(client, toolkit)
		{

			@Override
			protected Command getCommand(final String textValue)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
		text.setLabel("Name:");

		final LabelledText combo = new LabelledText(client, toolkit)
		{

			@Override
			protected Command getCommand(final String textValue)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
		combo.setLabel("Status:");

		return section;
	}

	private Section createSection(final IManagedForm managedForm)
	{
		final FormToolkit toolkit = managedForm.getToolkit();
		final ScrolledForm form = managedForm.getForm();
		final Section section = toolkit.createSection(form.getBody(), ExpandableComposite.TITLE_BAR);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
		section.setExpanded(true);
		section.addExpansionListener(new ExpansionAdapter()
		{
			@Override
			public void expansionStateChanged(final ExpansionEvent e)
			{
				form.reflow(false);
			}
		});

		final Composite client = toolkit.createComposite(section, SWT.WRAP);
		section.setClient(client);
		toolkit.paintBordersFor(client);

		return section;
	}

	private Section createTableSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		section.setText("Defined Sortings");
		final FormToolkit toolkit = managedForm.getToolkit();

		final GridLayout grlayout = new GridLayout();
		grlayout.numColumns = 2;

		client.setLayout(grlayout);
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
				if (parentElement instanceof Sort) { return ((Sort) parentElement).getChildsorts().getSort().toArray(); }
				return null;
			}

			public Object[] getElements(final Object inputElement)
			{
				final Definitions definitions = getDefinitions();
				if (definitions != null && definitions.getSorts() != null) { return definitions.getSorts().getSort()
						.toArray(); }
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
				if (element instanceof Sort) { return !((Sort) element).getChildsorts().getSort().isEmpty(); }
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
				// TODO Auto-generated method stub
			}
		});
		viewer.setInput(getDefinitions());
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 200;
		gd.widthHint = 100;
		t.setLayoutData(gd);
		final Button b = toolkit.createButton(client, "Add...", SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		b.setLayoutData(gd);

		return section;
	}

	private Definitions getDefinitions()
	{
		return ((BigraphSignatureEditor) getEditor()).getDefinitions();
	}
}
