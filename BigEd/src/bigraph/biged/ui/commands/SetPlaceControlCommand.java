package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.PlaceEvent;
import bigraphspace.model.Place;

public class SetPlaceControlCommand extends Command
{
	private final Place place;
	private final String newName;
	private String oldName;

	public SetPlaceControlCommand(final Place place, final String newName)
	{
		this.place = place;
		if(newName == null || newName.equals(""))
		{
			this.newName = null;
		}
		else
		{
			this.newName = newName;
		}		
		this.oldName = place.getControlName();
	}

	@Override
	public boolean canExecute()
	{
		return oldName != newName && (oldName == null || !oldName.equals(newName));
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		oldName = place.getControlName();
		place.setControlName(newName);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}

	@Override
	public void undo()
	{
		place.setControlName(oldName);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}
}