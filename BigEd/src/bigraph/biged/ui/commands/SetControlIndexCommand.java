package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class SetControlIndexCommand extends AbstractBigraphCommand
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
	}

	@Override
	public void execute()
	{
		index = place.getControlIndexes().indexOf(oldValue);
		final IndexValue indexValue = bigraph.getBigraph().createIndexValue(newValue);
		place.setControlIndex(indexValue, index);
		bigraph.fireEvent(new BigraphEvent(place, indexValue, BigraphEvent.Type.CHANGE));
	}

	@Override
	public void undo()
	{
		place.setControlIndex(oldValue, index);
		bigraph.fireEvent(new BigraphEvent(place, oldValue, BigraphEvent.Type.CHANGE));
	}
}