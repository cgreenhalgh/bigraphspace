package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;

public class DeletePlaceCommand extends BigraphCommand
{
	private final Place parent;
	private final Place child;
	private int index;

	public DeletePlaceCommand(final Bigraph bigraph, final Place parent, final Place child)
	{
		super(bigraph, "Delete " + BigraphLabelProvider.text(child) + " from " + BigraphLabelProvider.text(parent));
		this.parent = parent;
		this.child = child;
	}

	@Override
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(parent);
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
		index = parent.getChildren().indexOf(child);
		parent.removeChild(child);
	}

	@Override
	protected void doUndo()
	{
		parent.insertChild(child, index);
	}
}