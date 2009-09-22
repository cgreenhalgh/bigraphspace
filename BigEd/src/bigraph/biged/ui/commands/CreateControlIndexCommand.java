package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class CreateControlIndexCommand extends AbstractBigraphCommand
{
	private final Place place;
	private IndexValue indexValue;

	public CreateControlIndexCommand(final Bigraph bigraph, final Place place)
	{
		super(bigraph, "Create new Control Index on " + BigraphLabelProvider.text(place));
		this.place = place;
	}

	@Override
	public void execute()
	{
		indexValue = bigraph.getBigraph().createIndexValue("\"\"");
		place.addControlIndex(indexValue);
		bigraph.fireEvent(new BigraphEvent(place, indexValue, BigraphEvent.Type.CHANGE));
	}

	@Override
	public void undo()
	{
		place.removeControlIndex(indexValue);
		bigraph.fireEvent(new BigraphEvent(place, indexValue, BigraphEvent.Type.CHANGE));
	}
}