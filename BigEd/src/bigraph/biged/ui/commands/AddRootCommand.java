package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

public class AddRootCommand extends Command
{
	private final Bigraph parent;
	private final Place child;
	private final Place before;

	public AddRootCommand(final Bigraph parent, final Place child, final Place after)
	{
		this.parent = parent;
		this.child = child;
		this.before = after;
	}

	@Override
	public boolean canExecute()
	{
		return child.getType() == PlaceType.root;
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		final int index = parent.getRoots().indexOf(before);
		System.out.println("Insert at " + index);

		if (index < 0 || index >= parent.getRoots().size())
		{
			parent.addRoot(child);		
		}
		else
		{
			parent.insertRoot(child, index);
		}
	}

	@Override
	public String getLabel()
	{
		return "Add Place";
	}

	@Override
	public void undo()
	{
		parent.removeRoot(child);
	}
}