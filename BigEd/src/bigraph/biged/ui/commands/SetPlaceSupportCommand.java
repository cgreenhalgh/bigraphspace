package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.PlaceEvent;
import bigraphspace.model.Place;

public class SetPlaceSupportCommand extends Command
{
	private final Place place;
	private final String newName;
	private String oldName;

	public SetPlaceSupportCommand(final Place place, final String newName)
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
		oldName = place.getSupport();
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
		oldName = place.getSupport();
		place.setSupport(newName);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}

	@Override
	public void undo()
	{
		place.setSupport(oldName);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}
}