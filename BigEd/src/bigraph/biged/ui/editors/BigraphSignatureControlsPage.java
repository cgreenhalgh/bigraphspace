package bigraph.biged.ui.editors;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
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
import bigraph.biged.ui.widget.LabelledText;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Port;
import bigraphspace.model.signaturexml.Sort;

public class BigraphSignatureControlsPage extends FormPage
{
	private TreeViewer viewer;
	private Section controlSection;
	private Section portSection;
	private Section sortingSection;	
	private LabelledText controlName;
	private LabelledText controlDesc;
	private LabelledText controlArity;
	private TableViewer sortings;

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

		form.getBody().setLayout(new FormLayout());

		Section tableSection = createTableSection(managedForm);
		controlSection = createControlSection(managedForm);
		sortingSection = createSortingSection(managedForm);
		portSection = createPortSection(managedForm);
		
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
		data.top = new FormAttachment(controlSection, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);		
		sortingSection.setLayoutData(data);
	}

	private Section createPortSection(IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		section.setText("Sorting");
		//final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new FillLayout(SWT.VERTICAL));		
	
		return section;
	}

	private Section createSortingSection(IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		section.setText("Allowed Children");
		final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new FillLayout(SWT.VERTICAL));		
		
		final Table table = toolkit.createTable(client, SWT.NULL);
		sortings = new TableViewer(table);
		sortings.setContentProvider(new IStructuredContentProvider()
		{
			private Sort sort;
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
			{
				if(newInput instanceof Sort)
				{
					sort = (Sort)newInput; 
				}
				else
				{
					sort = null;
				}
			}
			
			@Override
			public void dispose()
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Object[] getElements(Object inputElement)
			{
				if(sort != null)
				{
					return sort.getChildsorts().getSort().toArray();
				}
				return new Object[] {};
			}
		});
		sortings.setLabelProvider(new BigraphLabelProvider());
		
		return section;
	}

	private Section createControlSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		section.setText("Control Details");
		final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new GridLayout(1, true));

		controlName = new LabelledText(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
				//return new SetSignatureControlCommand();
			}
		};
		controlName.setLabel("Name:");
		controlName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		controlDesc = new LabelledText(client, toolkit, SWT.MULTI)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
		controlDesc.setLabel("Description:");
		controlDesc.setHeight(4);
		controlDesc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		controlArity = new LabelledText(client, toolkit)
		{

			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
		controlArity.setLabel("Arity:");
		controlArity.addVerifyListener(new VerifyListener()
		{
			public void verifyText(final VerifyEvent e)
			{
				if (!"".equals(e.text))
				{
					try
					{
						Integer.parseInt(e.text);
					}
					catch (final NumberFormatException nfe)
					{
						e.doit = false;
						return;
					}
				}
			}
		});
		controlArity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button button1 = toolkit.createButton(client, "Active", SWT.RADIO);
		button1.setLayoutData(new GridData());
		Button button2 = toolkit.createButton(client, "Passive", SWT.RADIO);
		button2.setLayoutData(new GridData());		
		Button button3 = toolkit.createButton(client, "Atomic", SWT.RADIO);
		button3.setLayoutData(new GridData());		

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
				if (selection instanceof Port)
				{
					portSection.setVisible(true);
				}
				else
				{
					portSection.setVisible(false);
				}
				if (selection instanceof Control)
				{
					final Control control = (Control) selection;
					controlSection.setVisible(true);
					sortingSection.setVisible(true);					
					controlName.setText(control.getName());
					controlDesc.setText(control.getDescription());
					if (control.getArity() != null)
					{
						controlArity.setText(control.getArity().toString());
					}
					else
					{
						controlArity.setText(null);
					}
					
					sortings.setInput(getSort(control));
				}
				else
				{
					sortingSection.setVisible(false);
					controlSection.setVisible(false);
				}
			}
		});
		viewer.setInput(getDefinitions());

		final Composite buttonComposite = toolkit.createComposite(client);
		buttonComposite.setLayout(new FormLayout());

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
		data = new FormData();
		data.top = new FormAttachment(0);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		button1.setLayoutData(data);

		final Button button2 = toolkit.createButton(buttonComposite, "Add Port", SWT.PUSH);
		data = new FormData();
		data.top = new FormAttachment(button1, ITabbedPropertyConstants.VSPACE, SWT.BOTTOM);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		button2.setLayoutData(data);

		final Button button3 = toolkit.createButton(buttonComposite, "Add Index", SWT.PUSH);
		data = new FormData();
		data.top = new FormAttachment(button2, ITabbedPropertyConstants.VSPACE, SWT.BOTTOM);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		button3.setLayoutData(data);

		return section;
	}

	private Sort getSort(final Control control)
	{
		List<Sort> sorts = getDefinitions().getSorts().getSort();
		for(Sort sort: sorts)
		{
			if(sort.getName().equals(control.getName()))
			{
				return sort;
			}
		}
		return null;
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