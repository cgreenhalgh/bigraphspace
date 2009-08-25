package bigraph.biged.ui.commands;

import java.util.Collection;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;

public class DeletePlacesCommand extends Command
{
	private final PlaceContainer parent;
	private final Collection<? extends Place> children;

	public DeletePlacesCommand(final PlaceContainer parent, final Collection<? extends Place> children)
	{
		this.parent = parent;
		this.children = children;
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
		parent.removeAll(children);
	}

	@Override
	public String getLabel()
	{
		return super.getLabel();
	}

	@Override
	public void undo()
	{
		parent.addAll(children);
	}
}