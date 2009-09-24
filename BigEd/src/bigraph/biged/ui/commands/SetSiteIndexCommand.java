package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.Place;

public class SetSiteIndexCommand extends BigraphCommand
{
	private final Place place;
	private final String newIndex;
	private final Integer oldName;

	public SetSiteIndexCommand(final Bigraph bigraph, final Place place, final String newIndex)
	{
		super(bigraph, "Set site index to " + newIndex);
		this.place = place;
		if (newIndex == null || newIndex.equals(""))
		{
			this.newIndex = null;
		}
		else
		{
			this.newIndex = newIndex;
		}
		oldName = place.getSiteIndex();
	}

	@Override
	public boolean canExecute()
	{
		if (newIndex == null) { return true; }
		try
		{
			Integer.parseInt(newIndex);
			return true;
		}
		catch (final NumberFormatException nfe)
		{
			return false;
		}
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
		if (newIndex != null)
		{
			place.setSiteIndex(Integer.parseInt(newIndex));
		}
		else
		{
			place.setSiteIndex(null);
		}
	}

	@Override
	protected void doUndo()
	{
		place.setSiteIndex(oldName);
	}
}