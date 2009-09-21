package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraphspace.model.Place;

public class MoveRootCommand extends AbstractBigraphCommand
{
	private final Place child;
	private final Place before;

	public MoveRootCommand(final Bigraph bigraph, final Place child, final Place before)
	{
		super(bigraph);
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
		bigraph.getBigraph().removeRoot(child);
		final int index = bigraph.getBigraph().getRoots().indexOf(before);
		System.out.println("Insert at " + index);

		if (index < 0 || index >= bigraph.getBigraph().getRoots().size())
		{
			bigraph.getBigraph().addRoot(child);
		}
		else
		{
			bigraph.getBigraph().insertRoot(child, index);
		}
		// TODO Fire event
	}

	@Override
	public void undo()
	{
		// TODO
	}
}