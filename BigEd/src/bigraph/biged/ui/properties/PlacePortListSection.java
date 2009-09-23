package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.ui.commands.CreatePortCommand;
import bigraph.biged.ui.commands.DeletePortCommand;
import bigraph.biged.ui.commands.SetPortEdgeNameCommand;
import bigraph.biged.ui.commands.SetPortNameCommand;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class PlacePortListSection extends AbstractListPropertySection
{
	private TextCommandHandler portName;
	private TextCommandHandler edgeName;

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
		final Text portNameText = getWidgetFactory().createText(parent, "");
		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		portNameText.setLayoutData(data);
		portName = new TextCommandHandler(portNameText)
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetPortNameCommand(getBigraph(), (Place)getModel(), (Port) selection, textValue);
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
		edgeName = new TextCommandHandler(edgeNameText, false)
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetPortEdgeNameCommand(getBigraph(), (Place)getModel(), (Port) selection, textValue);
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
		return new CreatePortCommand(getBigraph(), (Place) getModel());
	}

	@Override
	protected IStructuredContentProvider getContentProvider()
	{
		return new IStructuredContentProvider()
		{
			public void dispose()
			{
			}

			public Object[] getElements(final Object inputElement)
			{
				if (inputElement instanceof Place) { return ((Place) inputElement).getPorts().toArray(); }
				return null;
			}

			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
			{
			}
		};
	}

	@Override
	protected Command getDeleteCommand(final Object item)
	{
		if (item == null) { return null; }
		final Port port = (Port) item;
		return new DeletePortCommand(getBigraph(), (Place) getModel(), port, getBigraph().getEdge(port.getLinkName()));
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
	protected void updateSelection()
	{
		super.updateSelection();
		final Object selection = getSelectedObject();
		if (selection == null)
		{
			portName.setText(null);
			edgeName.setText(null);
		}
		else
		{
			portName.setText(((Port) selection).getName());
			edgeName.setText(((Port) selection).getLinkName());
		}
	}
}