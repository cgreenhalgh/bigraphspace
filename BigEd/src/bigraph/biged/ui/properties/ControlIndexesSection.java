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

import bigraph.biged.ui.commands.CreateControlIndexCommand;
import bigraph.biged.ui.commands.DeleteControlIndexCommand;
import bigraph.biged.ui.commands.SetControlIndexCommand;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class ControlIndexesSection extends AbstractListPropertySection
{
	private TextCommandHandler indexValue;

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection)
	{
		super.setInput(part, selection);
		indexValue.setCommandStack(getCommandStack());
	}

	@Override
	protected void createDetailsPanel(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		final Text indexText = getWidgetFactory().createText(parent, "");
		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		indexText.setLayoutData(data);
		indexValue = new TextCommandHandler(indexText)
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				final Object selection = getSelectedObject();
				if (selection == null) { return null; }
				return new SetControlIndexCommand(getBigraph(), (Place) getModel(), (IndexValue) selection, textValue);
			}
		};

		final Label valueLabel = getWidgetFactory().createLabel(parent, "Index Value:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(indexText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(indexText, 0, SWT.TOP);
		valueLabel.setLayoutData(data);
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
			indexValue.setText(null);
		}
		else
		{
			indexValue.setText(((IndexValue) selection).getValue().toString());
		}
	}
}