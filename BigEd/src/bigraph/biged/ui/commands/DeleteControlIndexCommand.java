package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.PlaceEvent;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class DeleteControlIndexCommand extends Command
{
	private final Place place;
	private int index;
	private final IndexValue value;

	public DeleteControlIndexCommand(final Place place, final IndexValue value)
	{
		this.place = place;
		this.value = value;
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
		index = place.getControlIndexes().indexOf(value);
		place.removeControlIndex(value);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}

	@Override
	public String getLabel()
	{
		return "Delete Control Index";
	}

	@Override
	public void undo()
	{
		place.insertControlIndex(value, index);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}
}