package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class DeletePortCommand extends BigraphCommand
{
	private final Place place;
	private final Port port;

	public DeletePortCommand(final Bigraph bigraph, final Place place, final Port port)
	{
		super(bigraph, "Delete " + BigraphLabelProvider.text(port) + " port on " + BigraphLabelProvider.text(place));
		this.place = place;
		this.port = port;
	}

	@Override
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(place);
		result.add(bigraph.getEdge(port.getLinkName()));
		return result;
	}

	@Override
	public Type getType(final boolean undo)
	{
		if (undo)
		{
			return Type.ADD;
		}
		else
		{
			return Type.REMOVE;
		}
	}

	@Override
	protected void doExecute()
	{
		place.removePort(port);
		bigraph.removePort(place, port);
	}

	@Override
	protected void doUndo()
	{
		place.addPort(port);
		bigraph.addPort(place, port);
	}
}