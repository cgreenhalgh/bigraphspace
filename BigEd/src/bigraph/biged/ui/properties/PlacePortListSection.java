package bigraph.biged.ui.properties;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.Bigraph;
import bigraph.biged.ui.commands.CreatePortCommand;
import bigraph.biged.ui.commands.DeletePortCommand;
import bigraph.biged.ui.commands.SetPortEdgeNameCommand;
import bigraph.biged.ui.commands.SetPortNameCommand;
import bigraph.biged.ui.widget.LabelledText;
import bigraph.biged.ui.widget.LabelledTextSelect;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class PlacePortListSection extends AbstractListPropertySection
{
	private LabelledText portName;
	private LabelledText edgeName;

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
		portName = new LabelledText(parent, getWidgetFactory())
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetPortNameCommand(getBigraph(), (Place) getModel(), (Port) selection, textValue.toString());
			}
		};
		portName.setLabel("Port Name:");

		edgeName = new LabelledTextSelect(parent, getWidgetFactory())
		{
			@Override
			protected Command getCommand(final Object textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetPortEdgeNameCommand(getBigraph(), (Place) getModel(), (Port) selection, textValue.toString());
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
						return getBigraph().getEdges().toArray();
					}

					public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
					{
					}
				};
			}
		};
		edgeName.setLabel("<a>Edge</a>:");
		edgeName.addHyperlinkListeners(new HyperlinkAdapter()
		{
			@Override
			public void linkActivated(final HyperlinkEvent e)
			{
				final Port port = (Port) getSelectedObject();
				final Bigraph bigraph = getBigraph();
				final EditPartViewer viewer = getViewer();
				if (viewer != null)
				{
					viewer.select((EditPart) viewer.getEditPartRegistry().get(bigraph.getEdge(port.getLinkName())));
					getPart().getSite().getPage().activate(getPart());
				}
			}
		});
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
		return new DeletePortCommand(getBigraph(), (Place) getModel(), port);
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
			portName.setEnabled(false);
			edgeName.setEnabled(false);
		}
		else
		{
			final Port port = (Port) selection;
			portName.setEnabled(true);
			edgeName.setEnabled(true);
			portName.setText(port.getName());
			edgeName.setText(port.getLinkName());
			if (port.getLinkName() != null)
			{
				edgeName.setLabel("<a>Edge</a>:");
			}
			else
			{
				edgeName.setLabel("Edge:");
			}
		}
	}
}