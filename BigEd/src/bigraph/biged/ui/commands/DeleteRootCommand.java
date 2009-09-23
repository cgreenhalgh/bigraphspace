package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.Place;

public class DeleteRootCommand extends BigraphCommand
{
	private final Place child;
	private int index;

	public DeleteRootCommand(final Bigraph bigraph, final Place child)
	{
		super(bigraph, "Delete Root");
		this.child = child;
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
		if (undo)
		{
			return Type.ADD;
		}
		else
		{
			return Type.REMOVE;
		}
	}

	@Override
	protected void doExecute()
	{
		index = bigraph.getBigraph().getRoots().indexOf(child);
		bigraph.getBigraph().removeRoot(child);
	}

	@Override
	protected void doUndo()
	{
		bigraph.getBigraph().insertRoot(child, index);
	}
}