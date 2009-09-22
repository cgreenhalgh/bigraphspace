package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class CreatePortCommand extends AbstractBigraphCommand
{
	private final Place place;
	private Port port;

	public CreatePortCommand(final Bigraph bigraph, final Place place)
	{
		super(bigraph, "Create new Port on " + BigraphLabelProvider.text(place));
		this.place = place;
	}

	@Override
	public void execute()
	{
		port = bigraph.getBigraph().createPort(Port.DEFAULT_PORT_NAME_PREFIX);
		place.addPort(port);
		bigraph.fireEvent(new BigraphEvent(place, port, BigraphEvent.Type.ADD));
	}

	@Override
	public void undo()
	{
		place.removePort(port);
		bigraph.fireEvent(new BigraphEvent(place, port, BigraphEvent.Type.REMOVE));
	}
}