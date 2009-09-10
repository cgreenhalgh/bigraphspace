package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;

public class MovePlaceCommand extends Command
{
	private final PlaceContainer parent;
	private final Place child;
	private final Place before;

	public MovePlaceCommand(final PlaceContainer parent, final Place child, final Place before)
	{
		this.parent = parent;
		this.child = child;
		this.before = before;
	}

	@Override
	public boolean canExecute()
	{
		return super.canExecute();
	}

	@Override
	public boolean canUndo()
	{
		return super.canUndo();
	}

	@Override
	public void execute()
	{
		parent.remove(child);
		final int index = parent.indexOf(before);

		if (index < 0 || index >= parent.getPlaces().size())
		{
			parent.add(child);
		}
		else
		{
			parent.add(index, child);
		}
	}

	@Override
	public void undo()
	{
	}
}