package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.Place;

public class SetPlaceSupportCommand extends BigraphCommand
{
	private final Place place;
	private final String newName;
	private String oldName;

	public SetPlaceSupportCommand(final Bigraph bigraph, final Place place, final String newName)
	{
		super(bigraph, "Set Place Support Name to " + newName);
		this.place = place;
		if (newName == null || newName.equals(""))
		{
			this.newName = null;
		}
		else
		{
			this.newName = newName;
		}
		oldName = place.getSupport();
	}

	@Override
	public boolean canExecute()
	{
		return oldName != newName && (oldName == null || !oldName.equals(newName));
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
		oldName = place.getSupport();
		place.setSupport(newName);
	}

	@Override
	protected void doUndo()
	{
		place.setSupport(oldName);
	}
}