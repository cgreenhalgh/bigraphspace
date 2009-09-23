package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class DeleteControlIndexCommand extends BigraphCommand
{
	private final Place place;
	private int index;
	private final IndexValue value;

	public DeleteControlIndexCommand(final Bigraph bigraph, final Place place, final IndexValue value)
	{
		super(bigraph, "Delete Control Index " + BigraphLabelProvider.text(value) + " from "
				+ BigraphLabelProvider.text(place));
		this.place = place;
		this.value = value;
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
		index = place.getControlIndexes().indexOf(value);
		place.removeControlIndex(value);
	}

	@Override
	protected void doUndo()
	{
		place.insertControlIndex(value, index);
	}
}