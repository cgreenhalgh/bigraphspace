package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

public class AddPlaceCommand extends BigraphCommand
{
	private final Place parent;
	private final Place child;

	public AddPlaceCommand(final Bigraph bigraph, final Place parent, final Place child)
	{
		super(bigraph, "Add " + BigraphLabelProvider.text(child) + " to " + BigraphLabelProvider.text(parent));
		this.parent = parent;
		this.child = child;
	}

	@Override
	public boolean canExecute()
	{
		return child.getType() != PlaceType.root;
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
		parent.addChild(child);
	}

	@Override
	protected void doUndo()
	{
		parent.removeChild(child);
	}
}