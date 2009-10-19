package bigraph.biged.ui.widget;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import bigraph.biged.ui.BigraphLabelProvider;

public abstract class LabelledTextSelect extends LabelledText
{
	protected final Button button;

	public LabelledTextSelect(final Composite parent, final FormToolkit formToolkit)
	{
		super(parent, formToolkit);
		button = formToolkit.createButton(this, "Select...", SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(final SelectionEvent e)
			{
				final ListDialog dialog = new ListDialog(getShell());
				dialog.setContentProvider(getContentProvider());
				dialog.setInput("");
				dialog.setLabelProvider(new BigraphLabelProvider());
				dialog.setHelpAvailable(false);
				dialog.setTitle("");
				if (dialog.open() == Window.OK)
				{
					// TODO
				}
			}
		});
		updateLayout();
	}

	@Override
	public void setEnabled(final boolean enabled)
	{
		super.setEnabled(enabled);
		button.setEnabled(enabled);
	}

	protected abstract IStructuredContentProvider getContentProvider();

	@Override
	protected void refreshLayout()
	{
		updateLayout();
	}

	private void updateLayout()
	{
		FormData data = new FormData();
		data.right = new FormAttachment(100, -margins);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		button.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, margins);
		data.top = new FormAttachment(textField, 3, SWT.TOP);
		data.width = org.eclipse.ui.views.properties.tabbed.AbstractPropertySection.STANDARD_LABEL_WIDTH;
		textLabel.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(textLabel, ITabbedPropertyConstants.HSPACE, SWT.RIGHT);
		data.right = new FormAttachment(button, -ITabbedPropertyConstants.HSPACE, SWT.LEFT);
		data.top = new FormAttachment(button, 2, SWT.TOP);
		textField.setLayoutData(data);
	}
}