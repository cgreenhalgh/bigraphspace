package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class CreatePortCommand extends AbstractBigraphCommand
{
	private final Place place;
	private Port port;

	public CreatePortCommand(final Bigraph bigraph, final Place place)
	{
		super(bigraph);
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
		port = bigraph.getBigraph().createPort(Port.DEFAULT_PORT_NAME_PREFIX);
		place.addPort(port);
		bigraph.fireEvent(new BigraphEvent(place, port, BigraphEvent.Type.ADD));
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
		bigraph.fireEvent(new BigraphEvent(place, port, BigraphEvent.Type.REMOVE));
	}
}