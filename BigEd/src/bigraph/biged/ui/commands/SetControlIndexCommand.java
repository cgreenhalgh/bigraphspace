package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class SetControlIndexCommand extends BigraphCommand
{
	private final Place place;
	private final Object newValue;
	private int index;
	private final IndexValue oldValue;

	public SetControlIndexCommand(final Bigraph bigraph, final Place place, final IndexValue oldValue,
			final Object newValue)
	{
		super(bigraph, "Set Control Index value to " + newValue);
		this.place = place;
		this.newValue = newValue;
		this.oldValue = oldValue;
		index = place.getControlIndexes().indexOf(oldValue);
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
		index = place.getControlIndexes().indexOf(oldValue);
		final IndexValue indexValue = bigraph.getBigraph().createIndexValue(newValue);
		place.setControlIndex(indexValue, index);
	}

	@Override
	protected void doUndo()
	{
		place.setControlIndex(oldValue, index);
	}
}