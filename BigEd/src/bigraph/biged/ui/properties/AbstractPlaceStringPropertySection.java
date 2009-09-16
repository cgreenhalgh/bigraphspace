package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import bigraph.biged.model.PlaceEvent;

public abstract class AbstractPlaceStringPropertySection extends AbstractPlaceSinglePropertySection
{
	protected TextCommandHandler text;

	public void onPlaceEvent(final PlaceEvent event)
	{
		refresh();
	}

	@Override
	protected void setCommandStack(CommandStack commandStack)
	{
		super.setCommandStack(commandStack);
		text.setCommandStack(commandStack);
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

	protected abstract String getValue();
}
