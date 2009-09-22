package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class DeleteControlIndexCommand extends AbstractBigraphCommand
{
	private final Place place;
	private int index;
	private final IndexValue value;

	public DeleteControlIndexCommand(final Bigraph bigraph, final Place place, final IndexValue value)
	{
		super(bigraph, "Delete Control Index " + BigraphLabelProvider.text(value) + " from " + BigraphLabelProvider.text(place));
		this.place = place;
		this.value = value;
	}

	@Override
	public void execute()
	{
		index = place.getControlIndexes().indexOf(value);
		place.removeControlIndex(value);
		bigraph.fireEvent(new BigraphEvent(place, value, BigraphEvent.Type.CHANGE));
	}

	@Override
	public void undo()
	{
		place.insertControlIndex(value, index);
		bigraph.fireEvent(new BigraphEvent(place, value, BigraphEvent.Type.CHANGE));
	}
}