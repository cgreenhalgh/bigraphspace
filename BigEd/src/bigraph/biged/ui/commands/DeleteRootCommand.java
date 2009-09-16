package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;

public class DeleteRootCommand extends Command
{
	private final Bigraph parent;
	private final Place child;
	private int index;

	public DeleteRootCommand(final Bigraph parent, final Place child)
	{
		this.parent = parent;
		this.child = child;
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
		index = parent.getRoots().indexOf(child);
		parent.removeRoot(child);
	}

	@Override
	public String getLabel()
	{
		return "Delete Place";
	}

	@Override
	public void undo()
	{
		parent.insertRoot(child, index);
	}
}