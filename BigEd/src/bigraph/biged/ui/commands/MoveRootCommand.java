package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;

public class MoveRootCommand extends Command
{
	private final Bigraph parent;
	private final Place child;
	private final Place before;

	public MoveRootCommand(final Bigraph parent, final Place child, final Place before)
	{
		this.parent = parent;
		this.child = child;
		this.before = before;
	}

	@Override
	public boolean canExecute()
	{
		return true;
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		parent.removeRoot(child);
		final int index = parent.getRoots().indexOf(before);
		System.out.println("Insert at " + index);

		if (index < 0 || index >= parent.getRoots().size())
		{
			parent.addRoot(child);
		}
		else
		{
			parent.insertRoot(child, index);
		}
	}

	@Override
	public void undo()
	{
	}
}