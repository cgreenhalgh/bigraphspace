package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;

public class AddPlaceCommand extends Command
{
	private final PlaceContainer parent;
	private final Place newChild;
	private final Place afterChild;

	public AddPlaceCommand(final PlaceContainer parent, final Place child, final Place after)
	{
		this.parent = parent;
		this.newChild = child;
		this.afterChild = after;
	}

	@Override
	public boolean canExecute()
	{
		return parent.canAdd(newChild);
	}

	@Override
	public void execute()
	{
		int index = parent.getPlaces().size();
		if (afterChild != null)
		{
			index = parent.indexOf(afterChild);
			if (index < 0 || index > parent.getPlaces().size())
			{
				index = parent.getPlaces().size();
				// or exception
			}
		}
		parent.add(index, newChild);
	}

	@Override
	public void undo()
	{
		parent.remove(newChild);
	}
}