package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent.Type;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class CreateControlIndexCommand extends BigraphCommand
{
	private final Place place;
	private IndexValue indexValue;

	public CreateControlIndexCommand(final Bigraph bigraph, final Place place)
	{
		super(bigraph, "Create new Control Index on " + BigraphLabelProvider.text(place));
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
		indexValue = bigraph.getBigraph().createIndexValue("\"\"");
		place.addControlIndex(indexValue);
	}

	@Override
	protected void doUndo()
	{
		place.removeControlIndex(indexValue);
	}
}