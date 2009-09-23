package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.Place;

public class MoveRootCommand extends BigraphCommand
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
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(bigraph);
		return result;
	}

	@Override
	public Type getType(final boolean undo)
	{
		return Type.CHANGE;
	}

	@Override
	protected void doExecute()
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
	}

	@Override
	protected void doUndo()
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
	}
}