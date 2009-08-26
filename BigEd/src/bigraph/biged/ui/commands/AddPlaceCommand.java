package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;

public class AddPlaceCommand extends Command
{
	private final PlaceContainer parent;
	private final Place child;
	private final Place before;

	public AddPlaceCommand(final PlaceContainer parent, final Place child, final Place after)
	{
		this.parent = parent;
		this.child = child;
		this.before = after;
	}

	@Override
	public boolean canExecute()
	{
		return parent.canAdd(child);
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}
	
	@Override
	public void execute()
	{
		int index = parent.indexOf(before);
		System.out.println("Insert at " + index);
		
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
		parent.remove(child);
	}
}