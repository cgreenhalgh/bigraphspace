package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.PlaceEvent;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

public class AddPlaceCommand extends Command
{
	private final Place parent;
	private final Place child;

	public AddPlaceCommand(final Place parent, final Place child)
	{
		this.parent = parent;
		this.child = child;
	}

	@Override
	public boolean canExecute()
	{
		return child.getType() != PlaceType.root;
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		parent.addChild(child);
		PlaceEvent.fireEvent(new PlaceEvent(parent, child, PlaceEvent.Type.ADD));
	}

	@Override
	public String getLabel()
	{
		return "Add Place";
	}

	@Override
	public void undo()
	{
		(parent).removeChild(child);
		PlaceEvent.fireEvent(new PlaceEvent(parent, child, PlaceEvent.Type.REMOVE));
	}
}