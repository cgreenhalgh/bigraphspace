package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import bigraph.biged.model.BigraphEvent;

public abstract class AbstractStringPropertySection extends AbstractSinglePropertySection
{
	protected TextCommandHandler text;

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

	protected abstract Command createCommand(final String text);

	@Override
	protected Control createControl(final Composite parent)
	{
		final Text textField = getWidgetFactory().createText(parent, ""); //$NON-NLS-1$
		final FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH + 20);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		textField.setLayoutData(data);
		text = new TextCommandHandler(textField)
		{
			@Override
			protected Command getCommand(final String textValue)
			{
				return createCommand(textValue);
			}
		};
		return textField;
	}

	@Override
	protected abstract String getLabel();

	protected abstract String getValue();
}
