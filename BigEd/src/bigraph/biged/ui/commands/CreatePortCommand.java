package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class CreatePortCommand extends Command
{
	private final Bigraph bigraph;
	private final Place place;
	private Port port;

	public CreatePortCommand(final Bigraph bigraph, final Place place)
	{
		this.bigraph = bigraph;
		this.place = place;
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
		//port = bigraph.createPort(); 
		place.addPort(port);
		// TODO PlaceEvent.fireEvent(new PlaceEvent(parent, child, PlaceEvent.Type.ADD));
	}

	@Override
	public String getLabel()
	{
		return "Add Place";
	}

	@Override
	public void undo()
	{
		place.removePort(port);
		// TODO PlaceEvent.fireEvent(new PlaceEvent(parent, child, PlaceEvent.Type.REMOVE));
	}
}