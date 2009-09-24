package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

public abstract class TextCommandHandler implements ModifyListener, SelectionListener, FocusListener
{
	private CommandStack commandStack;
	private boolean modified;
	private final Text textField;

	public TextCommandHandler(final Text textField)
	{
		this.textField = textField;
		textField.addModifyListener(this);
		textField.addSelectionListener(this);
		textField.addFocusListener(this);
	}

	public void addVerifyListener(final VerifyListener verifyListener)
	{
		textField.addVerifyListener(verifyListener);
	}

	public void focusGained(final FocusEvent e)
	{
	}

	public void focusLost(final FocusEvent e)
	{
		execute();
	}

	public void modifyText(final ModifyEvent e)
	{
		modified = true;
	}

	public void setCommandStack(final CommandStack commandStack)
	{
		this.commandStack = commandStack;
	}

	public void setEnabled(final boolean enabled)
	{
		if (!enabled)
		{
			setText(null);
		}
		textField.setEnabled(enabled);
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

	public void widgetDefaultSelected(final SelectionEvent e)
	{
		execute();
	}

	public void widgetSelected(final SelectionEvent e)
	{
	}

	protected abstract Command getCommand(final String textValue);

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
