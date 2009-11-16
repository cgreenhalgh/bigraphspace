package bigraph.biged.ui.editors;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
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
import org.eclipse.swt.widgets.Label;
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
import bigraph.biged.model.Bigraph;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.commands.SetSignatureControlDescCommand;
import bigraph.biged.ui.commands.SetSignatureControlNameCommand;
import bigraph.biged.ui.commands.SetSignatureRendererNameCommand;
import bigraph.biged.ui.graph.parts.BigraphEditPartFactory;
import bigraph.biged.ui.graph.parts.PlacePart;
import bigraph.biged.ui.widget.LabelledText;
import bigraph.biged.ui.widget.LabelledTextSelect;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.Place;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Port;
import bigraphspace.model.signaturexml.Renderer;
import bigraphspace.model.signaturexml.Sort;
import bigraphspace.model.xml.DomBigraph;

public class BigraphSignatureControlsPage extends FormPage
{
	private final Definitions definitions;
	private TreeViewer viewer;
	private Section controlSection;
	private Section portSection;
	private Section sortingSection;
	private Section renderingSection;
	private LabelledText controlName;
	private LabelledTextSelect rendererName;
	private LabelledText controlDesc;
	private LabelledText controlArity;
	private TableViewer sortings;
	private PlacePart exampleNode;
	private LabelledTextSelect imageName;
	private LabelledTextSelect colourName;

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
		controlSection = createControlSection(managedForm);
		sortingSection = createSortingSection(managedForm);
		renderingSection = createRenderingSection(managedForm);
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
		sortingSection.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(sortingSection, ITabbedPropertyConstants.VSPACE);
		data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		renderingSection.setLayoutData(data);
	}

	private Section createControlSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm, false);
		final Composite client = (Composite) section.getClient();
		section.setText("Control Details");
		final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new GridLayout(1, true));

		controlName = new LabelledText(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				if(getViewerSelection() instanceof Control)
				{
					return new SetSignatureControlNameCommand(definitions, (Control)getViewerSelection(), textValue.toString());
				}
				return null;
			}
		};
		controlName.setLabel("Name:");
		controlName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		controlDesc = new LabelledText(client, toolkit, SWT.MULTI)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				if(getViewerSelection() instanceof Control)
				{
					return new SetSignatureControlDescCommand(definitions, (Control)getViewerSelection(), textValue.toString());
				}
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

		final Composite radioComposite = toolkit.createComposite(client);
		final GridLayout layout = new GridLayout(4, false);
		layout.marginLeft = 0;
		radioComposite.setLayout(layout);

		final Label label = toolkit.createLabel(radioComposite, "Status:");
		final GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
		data.widthHint = org.eclipse.ui.views.properties.tabbed.AbstractPropertySection.STANDARD_LABEL_WIDTH;
		label.setLayoutData(data);

		final Button button1 = toolkit.createButton(radioComposite, "Active", SWT.RADIO);
		button1.setLayoutData(new GridData());
		final Button button2 = toolkit.createButton(radioComposite, "Passive", SWT.RADIO);
		button2.setLayoutData(new GridData());
		final Button button3 = toolkit.createButton(radioComposite, "Atomic", SWT.RADIO);
		button3.setLayoutData(new GridData());

		return section;
	}

	private GraphicalViewer createGraphicalViewer(final Composite parent)
	{
		final GraphicalViewer graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setEditPartFactory(new BigraphEditPartFactory());
		graphicalViewer.setRootEditPart(new ScalableRootEditPart());
		graphicalViewer.createControl(parent);
		graphicalViewer.getControl().setBackground(ColorConstants.listBackground);
		// getViewer().setEditDomain(getEditDomain());

		return graphicalViewer;
	}

	private Section createPortSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm, false);
		final Composite client = (Composite) section.getClient();
		section.setText("Sorting");
		// final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new FillLayout(SWT.VERTICAL));

		return section;
	}

	private Section createRenderingSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm, true);
		final Composite client = (Composite) section.getClient();
		section.setText("Control Rendering");
		final FormToolkit toolkit = managedForm.getToolkit();

		client.setLayout(new FormLayout());

		rendererName = new LabelledTextSelect(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				final Object selection = getViewerSelection();
				if(selection instanceof Control)
				{
					return new SetSignatureRendererNameCommand(definitions, (Control)getViewerSelection(), textValue.toString());
				}
				return null;
			}

			@Override
			protected IStructuredContentProvider getContentProvider()
			{
				return new IStructuredContentProvider()
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
						// TODO Auto-generated method stub
						return null;
					}
				};
			}
		};
		rendererName.setLabel("Renderer:");
		rendererName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		colourName = new LabelledTextSelect(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
				// return new SetSignatureControlCommand();
			}

			@Override
			protected IStructuredContentProvider getContentProvider()
			{
				return new IStructuredContentProvider()
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
						// TODO Auto-generated method stub
						return null;
					}
				};
			}
		};
		colourName.setLabel("Colour:");
		colourName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		imageName = new LabelledTextSelect(client, toolkit)
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				// TODO Auto-generated method stub
				return null;
				// return new SetSignatureControlCommand();
			}

			@Override
			protected IStructuredContentProvider getContentProvider()
			{
				return new IStructuredContentProvider()
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
						// TODO Auto-generated method stub
						return null;
					}
				};
			}
		};
		imageName.setLabel("Image:");
		imageName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));		

		GraphicalViewer rendererExample = createGraphicalViewer(client);
		try
		{
			Bigraph bigraph = new Bigraph(new DomBigraph(new BasicSignature()));
			Place root = bigraph.getBigraph().createRoot();
			bigraph.getBigraph().addRoot(root);
			Place examplePlace = bigraph.getBigraph().createNode("Example");
			root.addChild(examplePlace);
				
			rendererExample.setContents(bigraph);
			
			exampleNode = (PlacePart) rendererExample.getEditPartRegistry().get(examplePlace);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		FormData data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		rendererExample.getControl().setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(rendererExample.getControl(), -ITabbedPropertyConstants.HSPACE);
		rendererName.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(rendererName, 3);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(rendererExample.getControl(), -ITabbedPropertyConstants.HSPACE);
		colourName.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(colourName, 3);
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HMARGIN);
		data.right = new FormAttachment(rendererExample.getControl(), -ITabbedPropertyConstants.HSPACE);
		imageName.setLayoutData(data);		
		
		return section;
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

	private Section createSortingSection(final IManagedForm managedForm)
	{
		final Section section = createSection(managedForm, true);
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
			public void dispose()
			{
				// TODO Auto-generated method stub

			}

			@Override
			public Object[] getElements(final Object inputElement)
			{
				if (sort != null) { return sort.getChildsorts().getSort().toArray(); }
				return new Object[] {};
			}

			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
			{
				if (newInput instanceof Sort)
				{
					sort = (Sort) newInput;
				}
				else
				{
					sort = null;
				}
			}
		});
		sortings.setLabelProvider(new BigraphLabelProvider());

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
					renderingSection.setVisible(true);
					controlName.setText(control.getName());
					controlDesc.setText(control.getDescription());
					exampleNode.getPlace().setControlName(control.getName());
					if (control.getArity() != null)
					{
						controlArity.setText(control.getArity().toString());
					}
					else
					{
						controlArity.setText(null);
					}

					sortings.setInput(getSort(control));
					
					Renderer renderer = getRenderer(control);
					if(renderer != null)
					{
						rendererName.setText(renderer.getClazz());						
					}
					else
					{
						rendererName.setText(null);
					}
					
					exampleNode.refresh();
					renderingSection.layout();
					sortingSection.layout();
					
				}
				else
				{
					sortingSection.setVisible(false);
					controlSection.setVisible(false);
					renderingSection.setVisible(false);
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

	private Definitions getDefinitions()
	{
		return ((BigraphSignatureEditor) getEditor()).getDefinitions();
	}

	private Renderer getRenderer(final Control control)
	{
		if(getDefinitions().getRenderers() == null)
		{
			return null;
		}
		final List<Renderer> renderers = getDefinitions().getRenderers().getRenderer();
		for (final Renderer renderer : renderers)
		{
			if (renderer.getControl().equals(control.getName())) { return renderer; }
		}
		return null;

	}

	private Sort getSort(final Control control)
	{
		final List<Sort> sorts = getDefinitions().getSorts().getSort();
		for (final Sort sort : sorts)
		{
			if (sort.getName().equals(control.getName())) { return sort; }
		}
		return null;
	}

	private Object getViewerSelection()
	{
		if (viewer.getSelection().isEmpty()) { return null; }
		return ((IStructuredSelection) viewer.getSelection()).getFirstElement();
	}
}