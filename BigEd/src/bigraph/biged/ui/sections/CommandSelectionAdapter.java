package bigraph.biged.ui.sections;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public abstract class CommandSelectionAdapter extends SelectionAdapter
{
	private CommandStack commandStack;

	public void setCommandStack(final CommandStack commandStack)
	{
		this.commandStack = commandStack;
	}

	@Override
	public void widgetSelected(final SelectionEvent e)
	{
		commandStack.execute(getCommand());
	}

	protected abstract Command getCommand();
}
