package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.Port;

public class SetPortNameCommand extends BigraphCommand
{
	private final Place place;
	private final Port port;
	private final String newName;
	private String oldName;

	public SetPortNameCommand(final Bigraph bigraph, final Place place, final Port port, final String newName)
	{
		super(bigraph, "Set " + BigraphLabelProvider.text(port) + " to " + newName);
		this.port = port;
		this.place = place;
		if (newName == null || newName.equals(""))
		{
			this.newName = null;
		}
		else
		{
			this.newName = newName;
		}
		this.oldName = port.getName();
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
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(place);
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
		oldName = port.getName();
		port.setName(newName);
	}

	@Override
	protected void doUndo()
	{
		port.setName(oldName);
	}
}