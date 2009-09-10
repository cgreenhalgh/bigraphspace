package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;

public class SetControlCommand extends Command
{
	private final Place place;
	private final String newName;
	private String oldName;

	public SetControlCommand(final Place place, final String newName)
	{
		this.place = place;
		this.newName = newName;
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
		oldName = place.getControlName();
		place.setControlName(newName);
	}

	@Override
	public void undo()
	{
		place.setControlName(oldName);
	}
}