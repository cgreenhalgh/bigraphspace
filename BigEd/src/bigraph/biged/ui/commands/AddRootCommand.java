package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

public class AddRootCommand extends BigraphCommand
{
	private final Place child;
	private final Place before;

	public AddRootCommand(final Bigraph bigraph, final Place child, final Place after)
	{
		super(bigraph, "Add " + BigraphLabelProvider.text(child) + " to bigraph");
		this.child = child;
		this.before = after;
	}

	@Override
	public boolean canExecute()
	{
		return child.getType() == PlaceType.root;
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
			return Type.REMOVE;
		}
		else
		{
			return Type.ADD;
		}
	}

	@Override
	protected void doExecute()
	{
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
	}

	@Override
	protected void doUndo()
	{
		bigraph.getBigraph().removeRoot(child);
	}
}