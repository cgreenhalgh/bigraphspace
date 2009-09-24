package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class SetPortEdgeNameCommand extends BigraphCommand
{
	private final Place place;
	private final Port port;
	private final String newEdge;
	private String oldEdge;

	public SetPortEdgeNameCommand(final Bigraph bigraph, final Place place, final Port port, final String newEdge)
	{
		super(bigraph, "Set " + BigraphLabelProvider.text(port) + " to " + newEdge);
		this.place = place;
		this.port = port;
		if (newEdge == null || newEdge.equals(""))
		{
			this.newEdge = null;
		}
		else
		{
			this.newEdge = newEdge;
		}
		this.oldEdge = port.getLinkName();
	}

	@Override
	public boolean canExecute()
	{
		return oldEdge != newEdge && (oldEdge == null || !oldEdge.equals(newEdge));
	}

	@Override
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(place);
		result.add(bigraph.getEdge(newEdge));
		result.add(bigraph.getEdge(oldEdge));
		return result;
	}

	@Override
	public Type getType(final boolean undo)
	{
		return Type.CHANGE;
	}

	@Override
	protected void doExecute()
	{
		oldEdge = port.getLinkName();
		bigraph.removePort(place, port);
		port.setLinkName(newEdge);
		bigraph.addPort(place, port);
	}

	@Override
	protected void doUndo()
	{
		bigraph.removePort(place, port);
		port.setLinkName(oldEdge);
		bigraph.addPort(place, port);
	}
}