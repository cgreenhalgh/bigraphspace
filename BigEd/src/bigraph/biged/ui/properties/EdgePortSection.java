package bigraph.biged.ui.properties;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.Edge;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.commands.DeletePortCommand;
import bigraph.biged.ui.commands.SetPortEdgeNameCommand;
import bigraph.biged.ui.commands.SetPortNameCommand;
import bigraph.biged.ui.widget.LabelledText;
import bigraph.biged.ui.widget.LabelledTextSelect;
import bigraphspace.model.Port;

public class EdgePortSection extends AbstractListPropertySection
{
	private LabelledText portName;
	private LabelledText edgeName;
	private FormText link;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		super.createControls(parent, aTabbedPropertySheetPage);
		viewer.setLabelProvider(new BigraphLabelProvider()
		{

			@Override
			public String getText(final Object object)
			{
				final Object modelObject = TypeMapper.getModelObject(object);
				if (modelObject instanceof Port)
				{
					final Port port = (Port) modelObject;
					final Edge edge = (Edge) getModel();

					return getText(edge.getPlace(port)) + " { " + port.getName() + " }";
				}
				return super.getText(object);
			}
		});
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection)
	{
		super.setInput(part, selection);
		portName.setCommandStack(getCommandStack());
		edgeName.setCommandStack(getCommandStack());
	}

	@Override
	protected void createDetailsPanel(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		
		link = getWidgetFactory().createFormText(composite, true);
		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		link.setLayoutData(data);
		link.addHyperlinkListener(new HyperlinkAdapter()
		{
			@Override
			public void linkActivated(final HyperlinkEvent e)
			{
				final Port port = (Port) getSelectedObject();
				final Edge edge = (Edge) getModel();
				final EditPartViewer viewer = getViewer();
				if (viewer != null)
				{
					viewer.select((EditPart) viewer.getEditPartRegistry().get(edge.getPlace(port)));
					getPart().getSite().getPage().activate(getPart());
				}
			}
		});

		portName = new LabelledText(parent, getWidgetFactory())
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				final Port port = (Port) selection;
				return new SetPortNameCommand(getBigraph(), ((Edge) getModel()).getPlace(port), port, textValue);
			}
		};
		portName.setLabel("Port Name:");
		portName.setMargins(0);

		edgeName = new LabelledTextSelect(parent, getWidgetFactory())
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				final Port port = (Port) selection;
				return new SetPortEdgeNameCommand(getBigraph(), ((Edge) getModel()).getPlace(port), port, textValue);
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
						return getBigraph().getEdges().toArray();
					}
				};
			}
		};
		edgeName.setLabel("Edge:");
		edgeName.setMargins(0);		
	}

	@Override
	protected Command getAddCommand()
	{
		return null;
	}

	@Override
	protected IStructuredContentProvider getContentProvider()
	{
		return new IStructuredContentProvider()
		{
			@Override
			public void dispose()
			{
			}

			@Override
			public Object[] getElements(final Object inputElement)
			{
				if (inputElement instanceof Edge) { return ((Edge) inputElement).getPorts().toArray(); }
				return null;
			}

			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
			{
			}
		};
	}

	@Override
	protected Command getDeleteCommand(final Object item)
	{
		final Edge edge = (Edge) getModel();
		final Port port = (Port) item;
		return new DeletePortCommand(getBigraph(), edge.getPlace(port), port);
	}

	@Override
	protected String getDetailsTitle()
	{
		return "Port Details";
	}

	@Override
	protected String getListTitle()
	{
		return "Ports";
	}

	@Override
	protected void setViewerFormData(final FormData data)
	{
		data.height = 80;
		data.bottom = null;
	}

	@Override
	protected void updateSelection()
	{
		super.updateSelection();
		final Object selection = getSelectedObject();
		if (selection == null)
		{
			link.setText("", false, false);
			portName.setEnabled(false);
			edgeName.setEnabled(false);
		}
		else
		{
			final Edge edge = (Edge) getModel();
			link.setText("<form><p><a>" + BigraphLabelProvider.text(edge.getPlace((Port) selection)) + "</a></p></form>", true, false);
			portName.setText(((Port) selection).getName());
			edgeName.setText(((Port) selection).getLinkName());
		}
	}
}
