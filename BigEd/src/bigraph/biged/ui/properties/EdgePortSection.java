package bigraph.biged.ui.properties;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.Edge;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraph.biged.ui.commands.DeletePortCommand;
import bigraph.biged.ui.commands.SetPortEdgeNameCommand;
import bigraph.biged.ui.commands.SetPortNameCommand;
import bigraphspace.model.Port;

public class EdgePortSection extends AbstractListPropertySection
{
	private TextCommandHandler portName;
	private TextCommandHandler edgeName;
	private Hyperlink link;

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
	protected void createDetailsPanel(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		link = getWidgetFactory().createHyperlink(parent, "", 0);
		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		link.setLayoutData(data);
		link.addHyperlinkListener(new IHyperlinkListener()
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

			@Override
			public void linkEntered(final HyperlinkEvent e)
			{
			}

			@Override
			public void linkExited(final HyperlinkEvent e)
			{
			}
		});

		final Label linkLabel = getWidgetFactory().createLabel(parent, "Place:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(link, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(link, 0, SWT.TOP);
		linkLabel.setLayoutData(data);

		final Text portNameText = getWidgetFactory().createText(parent, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(link, ITabbedPropertyConstants.VSPACE);
		portNameText.setLayoutData(data);
		portName = new TextCommandHandler(portNameText)
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetPortNameCommand(getBigraph(), (Port) selection, textValue);
			}
		};

		final Label portLabel = getWidgetFactory().createLabel(parent, "Port Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(portNameText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(portNameText, 0, SWT.TOP);
		portLabel.setLayoutData(data);

		final Text edgeNameText = getWidgetFactory().createText(parent, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(portNameText, ITabbedPropertyConstants.VSPACE);
		edgeNameText.setLayoutData(data);
		edgeName = new TextCommandHandler(edgeNameText)
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetPortEdgeNameCommand(getBigraph(), (Port) selection, textValue);
			}
		};

		final Label edgeLabel = getWidgetFactory().createLabel(parent, "Edge Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(edgeNameText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(edgeNameText, 0, SWT.TOP);
		edgeLabel.setLayoutData(data);

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
		return new DeletePortCommand(getBigraph(), edge.getPlace(port), port, edge);
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
			link.setText("");
			portName.setText(null);
			edgeName.setText(null);
		}
		else
		{
			final Edge edge = (Edge) getModel();
			link.setText(BigraphLabelProvider.text(edge.getPlace((Port) selection)));
			portName.setText(((Port) selection).getName());
			edgeName.setText(((Port) selection).getLinkName());
		}
	}
}
