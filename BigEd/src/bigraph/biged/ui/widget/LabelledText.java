package bigraph.biged.ui.widget;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public abstract class LabelledText extends Composite
{
	protected CommandStack commandStack;
	protected boolean modified;
	protected final Text textField;
	protected final FormText textLabel;
	protected int margins = 0;
	
	private final LabelHyperlinkSettings settings;

	public LabelledText(final Composite parent, final TabbedPropertySheetWidgetFactory widgetFactory)
	{
		super(parent, 0);
		setLayout(new FormLayout());
		widgetFactory.adapt(this);
		settings = new LabelHyperlinkSettings(getDisplay(), widgetFactory.getHyperlinkGroup());
		settings.setActiveForeground(widgetFactory.getHyperlinkGroup().getActiveForeground());
		textLabel = widgetFactory.createFormText(this, true);
		textLabel.setHyperlinkSettings(settings);
		textField = widgetFactory.createText(this, "");
		textField.addFocusListener(new FocusAdapter()
		{
			public void focusLost(final FocusEvent e)
			{
				execute();
			}			
		});
		textField.addModifyListener(new ModifyListener()
		{
			
			@Override
			public void modifyText(ModifyEvent e)
			{
				modified = true;	
			}
		});
		textField.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetDefaultSelected(SelectionEvent e)
			{
				execute();
			}
		});
		updateLayout();
	}

	public void addHyperlinkListeners(final IHyperlinkListener hyperlinkListener)
	{
		textLabel.addHyperlinkListener(hyperlinkListener);
	}

	public void addVerifyListener(final VerifyListener verifyListener)
	{
		textField.addVerifyListener(verifyListener);
	}

	public void setCommandStack(final CommandStack commandStack)
	{
		this.commandStack = commandStack;
	}

	@Override
	public void setEnabled(final boolean enabled)
	{
		super.setEnabled(enabled);
		if (!enabled)
		{
			setText(null);
			settings.setEnabled(false);
			textLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));			
		}
		else
		{
			settings.setEnabled(true);	
			textLabel.setForeground(ColorConstants.black);
		}
		textField.setEnabled(enabled);
	}

	public void setLabel(final String label)
	{
		this.textLabel.setText("<form><p>" + label + "</p></form>", true, false);
	}

	public void setMargins(final int margins)
	{
		this.margins = margins;
		refreshLayout();
	}

	public void setText(final String text)
	{
		if (textField.isDisposed()) { return; }
		if (text == null)
		{
			textField.setText("");
		}
		else
		{
			if (!textField.getText().equals(text))
			{
				textField.setText(text);
				setEnabled(true);
			}
		}
		modified = false;
	}

	protected abstract Command getCommand(final String textValue);

	protected void refreshLayout()
	{
		updateLayout();
	}
	
	private void updateLayout()
	{
		FormData data = new FormData();
		data.left = new FormAttachment(0, margins);
		data.top = new FormAttachment(textField, 3, SWT.TOP);
		data.width = org.eclipse.ui.views.properties.tabbed.AbstractPropertySection.STANDARD_LABEL_WIDTH;
		textLabel.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(textLabel, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -margins);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		textField.setLayoutData(data);
	}

	private void execute()
	{
		if (modified)
		{
			final Command command = getCommand(textField.getText());
			if (command != null)
			{
				commandStack.execute(command);
			}
		}
	}
}
