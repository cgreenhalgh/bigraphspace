package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraphspace.model.IndexValue;

public class SetControlIndexCommand extends Command
{
	private final Place place;
	private final Object newValue;
	private final int index;
	private IndexValue oldValue;

	public SetControlIndexCommand(final Place place, final Object newValue, final int index)
	{
		this.place = place;
		this.newValue = newValue;
		this.index = index;
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
		oldValue = place.getControlIndexes().get(index);
		place.setControlIndex(newValue, index);
	}

	@Override
	public String getLabel()
	{
		return "Set Control Index";
	}

	@Override
	public void undo()
	{
		place.setControlIndex(oldValue.getValue(), index);
	}
}