package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class CreateControlIndexCommand extends AbstractBigraphCommand
{
	private final Place place;
	private IndexValue indexValue;

	public CreateControlIndexCommand(final Bigraph bigraph, final Place place)
	{
		super(bigraph);
		this.place = place;
	}

	@Override
	public boolean canExecute()
	{
		return true;
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		indexValue = bigraph.getBigraph().createIndexValue("\"\"");
		place.addControlIndex(indexValue);
		bigraph.fireEvent(new BigraphEvent(place, indexValue, BigraphEvent.Type.CHANGE));
	}

	@Override
	public String getLabel()
	{
		return "Add Control Index";
	}

	@Override
	public void undo()
	{
		place.removeControlIndex(indexValue);
		bigraph.fireEvent(new BigraphEvent(place, indexValue, BigraphEvent.Type.CHANGE));
	}
}