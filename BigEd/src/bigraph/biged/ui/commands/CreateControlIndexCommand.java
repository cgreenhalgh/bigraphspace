package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;


import bigraph.biged.model.PlaceEvent;
import bigraphspace.model.Bigraph;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class CreateControlIndexCommand extends Command
{
	private final Bigraph bigraph; 
	private final Place place;
	private IndexValue indexValue;

	public CreateControlIndexCommand(final Bigraph bigraph, final Place place)
	{
		this.bigraph = bigraph;
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
		indexValue = bigraph.createIndexValue("\"\"");
		place.addControlIndex(indexValue);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));
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
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));
	}
}