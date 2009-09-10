package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraphspace.model.IndexValue;

public class DeleteControlIndexCommand extends Command
{
	private final Place place;
	private final int index;
	private final IndexValue value;

	public DeleteControlIndexCommand(final Place place, final int index, final IndexValue value)
	{
		this.place = place;
		this.index = index;
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
		place.removeControlIndex(value);
	}

	@Override
	public String getLabel()
	{
		return "Delete Control Index";
	}

	@Override
	public void undo()
	{
		place.addControlIndex(value, index);
	}
}