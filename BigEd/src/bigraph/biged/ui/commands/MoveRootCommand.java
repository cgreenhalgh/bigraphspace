package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.Place;

public class MoveRootCommand extends AbstractBigraphCommand
{
	private final Place child;
	private final Place before;
	private int oldIndex;

	public MoveRootCommand(final Bigraph bigraph, final Place child, final Place before)
	{
		super(bigraph, "Move Root");
		this.child = child;
		this.before = before;
	}

	@Override
	public void execute()
	{
		oldIndex = bigraph.getBigraph().getRoots().indexOf(child);
		bigraph.getBigraph().removeRoot(child);
		final int index = bigraph.getBigraph().getRoots().indexOf(before);

		if (index < 0 || index >= bigraph.getBigraph().getRoots().size())
		{
			bigraph.getBigraph().addRoot(child);
		}
		else
		{	
			bigraph.getBigraph().insertRoot(child, index);
		}
		bigraph.fireEvent(new BigraphEvent(bigraph, child, Type.ADD));
	}

	@Override
	public void undo()
	{
		bigraph.getBigraph().removeRoot(child);
		if (oldIndex < 0 || oldIndex >= bigraph.getBigraph().getRoots().size())
		{
			bigraph.getBigraph().addRoot(child);
		}
		else
		{
			bigraph.getBigraph().insertRoot(child, oldIndex);
		}
		bigraph.fireEvent(new BigraphEvent(bigraph, child, Type.ADD));
	}
}