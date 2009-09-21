package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.Edge;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class DeletePortCommand extends AbstractBigraphCommand
{
	private final Place place;
	private final Port port;
	private final Edge edge;

	public DeletePortCommand(final Bigraph bigraph, final Place place, final Port port, final Edge edge)
	{
		super(bigraph);
		this.place = place;
		this.port = port;
		this.edge = edge;
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
		edge.removePort(port);
		bigraph.fireEvent(new BigraphEvent(place, port, BigraphEvent.Type.REMOVE));
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
		edge.addPort(port, place);
		bigraph.fireEvent(new BigraphEvent(place, port, BigraphEvent.Type.ADD));
	}
}