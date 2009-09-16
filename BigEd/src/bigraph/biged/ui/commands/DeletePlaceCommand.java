package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.PlaceEvent;
import bigraphspace.model.Place;

public class DeletePlaceCommand extends Command
{
	private final Place parent;
	private final Place child;
	private int index;

	public DeletePlaceCommand(final Place parent, final Place child)
	{
		this.parent = parent;
		this.child = child;
	}

	@Override
	public boolean canExecute()
	{
		return true;
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		index = parent.getChildren().indexOf(child);
		parent.removeChild(child);
		PlaceEvent.fireEvent(new PlaceEvent(parent, child, PlaceEvent.Type.REMOVE));		
	}

	@Override
	public String getLabel()
	{
		return "Delete Place";
	}

	@Override
	public void undo()
	{
		parent.insertChild(child, index);		
		PlaceEvent.fireEvent(new PlaceEvent(parent, child, PlaceEvent.Type.ADD));		
	}
}