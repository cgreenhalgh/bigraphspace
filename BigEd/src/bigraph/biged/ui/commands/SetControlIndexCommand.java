package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.PlaceEvent;
import bigraphspace.model.Bigraph;
import bigraphspace.model.IndexValue;
import bigraphspace.model.Place;

public class SetControlIndexCommand extends Command
{
	private final Bigraph bigraph;
	private final Place place;
	private final Object newValue;
	private int index;
	private final IndexValue oldValue;

	public SetControlIndexCommand(final Bigraph bigraph, final Place place, final IndexValue oldValue, final Object newValue)
	{
		this.bigraph = bigraph;
		this.place = place;
		this.newValue = newValue;
		this.oldValue = oldValue;
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
		index = place.getControlIndexes().indexOf(oldValue);
		final IndexValue indexValue = bigraph.createIndexValue(newValue); 
		place.setControlIndex(indexValue, index);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}

	@Override
	public String getLabel()
	{
		return "Set Control Index";
	}

	@Override
	public void undo()
	{
		place.setControlIndex(oldValue, index);
		PlaceEvent.fireEvent(new PlaceEvent(place, PlaceEvent.Type.CHANGE));		
	}
}