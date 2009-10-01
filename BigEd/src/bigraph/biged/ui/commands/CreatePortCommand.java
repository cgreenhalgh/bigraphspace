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
		int index = 1;
		String name;
		final Collection<Port> ports = place.getPorts();
		while (true)
		{
			name = Port.DEFAULT_PORT_NAME_PREFIX + "port" + index;
			if (contains(name, ports))
			{
				index++;
			}
			else
			{
				break;
			}
		}

		port = bigraph.getBigraph().createPort(name);
		place.addPort(port);
		bigraph.addPort(place, port);
	}

	@Override
	protected void doUndo()
	{
		place.removePort(port);
		bigraph.removePort(place, port);
	}

	private boolean contains(final String name, final Collection<Port> ports)
	{
		for (final Port port : ports)
		{
			if (port.getName().equals(name)) { return true; }
		}
		return false;
	}
}