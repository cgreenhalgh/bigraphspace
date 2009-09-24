package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

public abstract class AbstractStringSelectPropertySection extends AbstractStringPropertySection
{
	protected SelectionDialog dialog;
	
	@Override
	protected Control createControl(final Composite parent)
	{
		dialog = new SelectionDialog(parent.getShell())
		{
		};
		
		final Button browse = getWidgetFactory().createButton(parent, "Browse...", SWT.PUSH);
		FormData data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		browse.setLayoutData(data);
		browse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetDefaultSelected(SelectionEvent e)
			{
				
			}	
		});
		
		final Text textField = getWidgetFactory().createText(parent, ""); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH + 20);
		data.right = new FormAttachment(browse, ITabbedPropertyConstants.HSPACE);
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
}