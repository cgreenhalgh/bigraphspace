package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class CreatePortCommand extends BigraphCommand
{
	private final Place place;
	private Port port;

	public CreatePortCommand(final Bigraph bigraph, final Place place)
	{
		super(bigraph, "Create new Port on " + BigraphLabelProvider.text(place));
		this.place = place;
	}

	@Override
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(place);
		return result;
	}

	@Override
	public Type getType(final boolean undo)
	{
		if (undo)
		{
			return Type.REMOVE;
		}
		else
		{
			return Type.ADD;
		}
	}

	@Override
	protected void doExecute()
	{
		port = bigraph.getBigraph().createPort(Port.DEFAULT_PORT_NAME_PREFIX);
		place.addPort(port);
	}

	@Override
	protected void doUndo()
	{
		place.removePort(port);
	}
}