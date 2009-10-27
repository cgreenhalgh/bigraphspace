package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.widget.LabelledText;

public abstract class AbstractStringPropertySection extends AbstractPropertySection
{
	protected LabelledText text;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		super.createControls(parent, aTabbedPropertySheetPage);
		createControl(parent, aTabbedPropertySheetPage);
	}

	public void onPlaceEvent(final BigraphEvent event)
	{
		refresh();
	}

	@Override
	public void refresh()
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			public void run()
			{
				text.setText(getValue());
			}
		});
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection)
	{
		super.setInput(part, selection);
		text.setCommandStack(getCommandStack());
	}

	protected abstract Command createCommand(final Object text);

	protected void createControl(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		text = new LabelledText(parent, getWidgetFactory())
		{

			@Override
			protected Command getCommand(final Object textValue)
			{
				return createCommand(textValue);
			}
		};
		text.setLabel(getLabel());
		text.setMargins(ITabbedPropertyConstants.HMARGIN + ITabbedPropertyConstants.HSPACE);
	}

	protected abstract String getLabel();

	protected abstract String getValue();
}
