package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.ui.commands.CreateControlIndexCommand;
import bigraph.biged.ui.commands.DeleteControlIndexCommand;
import bigraph.biged.ui.commands.SetControlIndexCommand;
import bigraph.biged.ui.widget.LabelledText;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class PlaceIndexesSection extends AbstractListPropertySection
{
	private LabelledText indexValue;

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection)
	{
		super.setInput(part, selection);
		indexValue.setCommandStack(getCommandStack());
	}

	@Override
	protected void createDetailsPanel(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		indexValue = new LabelledText(parent, getWidgetFactory())
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetControlIndexCommand(getBigraph(), (Place) getModel(), (IndexValue) selection, textValue);
			}
		};
		indexValue.setLabel("Index Value:");
	}

	@Override
	protected Command getAddCommand()
	{
		return new CreateControlIndexCommand(getBigraph(), (Place) getModel());
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
				if (inputElement instanceof Place) { return ((Place) inputElement).getControlIndexes().toArray(); }
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
		return new DeleteControlIndexCommand(getBigraph(), (Place) getModel(), (IndexValue) item);
	}

	@Override
	protected String getDetailsTitle()
	{
		return "Control Index Details";
	}

	@Override
	protected String getListTitle()
	{
		return "Control Indexes";
	}

	@Override
	protected void updateSelection()
	{
		super.updateSelection();
		final Object selection = getSelectedObject();
		if (selection == null)
		{
			indexValue.setEnabled(false);
		}
		else
		{
			indexValue.setEnabled(true);
			indexValue.setText(((IndexValue) selection).getValue().toString());
		}
	}
}