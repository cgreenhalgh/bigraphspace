package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class DeletePortCommand extends Command
{
	private final Place place;
	private final Port port;

	public DeletePortCommand(final Place place, final Port port)
	{
		this.place = place;
		this.port = port;
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
		place.removePort(port);
		// TODO PlaceEvent.fireEvent(new PlaceEvent(place, port, PlaceEvent.Type.REMOVE));		
	}

	@Override
	public String getLabel()
	{
		return "Delete Place";
	}

	@Override
	public void undo()
	{
		place.addPort(port);		
		//TODO PlaceEvent.fireEvent(new PlaceEvent(place, port, PlaceEvent.Type.ADD));		
	}
}