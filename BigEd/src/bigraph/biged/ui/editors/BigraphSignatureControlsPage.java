package bigraph.biged.ui.editors;

import java.util.Collection;
import java.util.HashSet;

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

import bigraph.biged.BigEdPlugin;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.widget.LabelledText;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;

public class BigraphSignatureControlsPage extends FormPage
{
	private TreeViewer viewer;

	public BigraphSignatureControlsPage(final FormEditor editor, final String id, final String title)
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
		form.setText("Controls");
		form.setImage(BigEdPlugin.getImage("control"));
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
		section.setText("Defined Controls");
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
				// TODO Auto-generated method stub
			}
		});
		viewer.setInput(getDefinitions());
		final GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 200;
		gd.widthHint = 100;
		t.setLayoutData(gd);

		final Composite buttonComposite = toolkit.createComposite(client);
		buttonComposite.setLayout(new FillLayout(SWT.VERTICAL));

		toolkit.createButton(buttonComposite, "Add Control", SWT.PUSH);
		toolkit.createButton(buttonComposite, "Add Port", SWT.PUSH);
		toolkit.createButton(buttonComposite, "Add Index", SWT.PUSH);

		return section;
	}

	private Definitions getDefinitions()
	{
		return ((BigraphSignatureEditor) getEditor()).getDefinitions();
	}
}
