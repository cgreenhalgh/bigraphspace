package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraphspace.model.IndexValue;

public class AddControlIndexCommand extends Command
{
	private final Place place;
	private final Object value;
	private IndexValue indexValue;

	public AddControlIndexCommand(final Place place, final Object value)
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
		indexValue = place.addControlIndex(value);
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
	}
}