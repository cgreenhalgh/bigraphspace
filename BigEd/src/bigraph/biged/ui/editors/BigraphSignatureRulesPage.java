package bigraph.biged.ui.editors;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
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
import bigraph.biged.ui.graph.parts.BigraphEditPartFactory;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Rule;
import bigraphspace.model.xml.DomBigraph;

public class BigraphSignatureRulesPage extends FormPage
{
	private TableViewer viewer;
	private GraphicalViewer redexGraph;
	private GraphicalViewer reactumGraph;

	public BigraphSignatureRulesPage(final FormEditor editor, final String id, final String title)
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
		form.setText("Rules");
		form.setImage(BigEdPlugin.getImage("rule"));
		toolkit.decorateFormHeading(form.getForm());
		form.getBody().setLayout(new FormLayout());		

		Section section1 = createTableSection(managedForm);
		Section section2 = createRedexSection(managedForm);
		Section section3 = createReactumSection(managedForm);
		
		FormData data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HMARGIN);
		data.height = 100;
		section1.setLayoutData(data);
		
		data = new FormData();
		data.top = new FormAttachment(section1, ITabbedPropertyConstants.VSPACE, SWT.BOTTOM);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(50, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);
		section2.setLayoutData(data);
		
		data = new FormData();
		data.top = new FormAttachment(section1, ITabbedPropertyConstants.VSPACE, SWT.BOTTOM);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.bottom = new FormAttachment(100, -ITabbedPropertyConstants.VMARGIN);		
		section3.setLayoutData(data);
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

	private GraphicalViewer createGraphicalViewer(final Composite parent)
	{
		GraphicalViewer graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setEditPartFactory(new BigraphEditPartFactory());		
		graphicalViewer.setRootEditPart(new ScalableRootEditPart());		
		graphicalViewer.createControl(parent);
		graphicalViewer.getControl().setBackground(ColorConstants.listBackground);		
		//getViewer().setEditDomain(getEditDomain());
		
		return graphicalViewer;
	}
	
	private Section createRedexSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		client.setLayout(new FillLayout());		
		section.setText("Redex");

		redexGraph = createGraphicalViewer(client);
	
		return section;
	}

	private Section createReactumSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		client.setLayout(new FillLayout());
		section.setText("Reactum");

		reactumGraph = createGraphicalViewer(client);
		
		return section;
	}
	
	private Section createTableSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm);
		final Composite client = (Composite) section.getClient();
		section.setText("Defined Rules");
		final FormToolkit toolkit = managedForm.getToolkit();

		final GridLayout grlayout = new GridLayout();
		grlayout.numColumns = 2;

		client.setLayout(grlayout);
		final Table t = toolkit.createTable(client, SWT.NULL);

		viewer = new TableViewer(t);
		viewer.setLabelProvider(new BigraphLabelProvider());
		viewer.setContentProvider(new ITreeContentProvider()
		{
			public void dispose()
			{
			}

			@Override
			public Object[] getChildren(final Object parentElement)
			{
				return null;
			}

			public Object[] getElements(final Object inputElement)
			{
				final Definitions definitions = getDefinitions();
				if (definitions != null && definitions.getSorts() != null) { return definitions.getRules().getRule()
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
				if (selection instanceof Rule)
				{
					Rule rule = (Rule)selection;
					try
					{
						redexGraph.setContents(new DomBigraph(new BasicSignature(), rule.getRedex().getAny().getOwnerDocument(), rule.getRedex().getAny()));
						reactumGraph.setContents(new DomBigraph(new BasicSignature(), rule.getReactum().getAny().getOwnerDocument(), rule.getReactum().getAny()));						
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		viewer.setInput(getDefinitions());
		GridData gd = new GridData(GridData.FILL_BOTH);
		t.setLayoutData(gd);
		final Button b = toolkit.createButton(client, "Add...", SWT.PUSH);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		b.setLayoutData(gd);

		return section;
	}
	
	private Object getViewerSelection()
	{
		if (viewer.getSelection().isEmpty()) { return null; }
		return ((IStructuredSelection) viewer.getSelection()).getFirstElement();
	}	

	private Definitions getDefinitions()
	{
		return ((BigraphSignatureEditor) getEditor()).getDefinitions();
	}
}
