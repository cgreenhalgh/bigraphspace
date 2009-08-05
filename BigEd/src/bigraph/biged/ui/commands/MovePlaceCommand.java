package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceContainer;

public class MovePlaceCommand extends Command
{
	private final PlaceContainer parent;
	private final Place child;
	private final Place afterChild;
	
	public MovePlaceCommand(final PlaceContainer parent, final Place child, final Place after)
	{
		this.parent = parent;
		this.child = child;
		this.afterChild = after;
	}

	@Override
	public boolean canExecute()
	{
		// TODO Auto-generated method stub
		return super.canExecute();
	}

	@Override
	public boolean canUndo()
	{
		// TODO Auto-generated method stub
		return super.canUndo();
	}

	@Override
	public void execute()
	{
		parent.remove(child);
    	int index = parent.getPlaces().size();
    	if(afterChild != null)
    	{
    		index = parent.indexOf(afterChild);
    		if(index < 0 || index > parent.getPlaces().size())
    		{
    			index = parent.getPlaces().size();
    			// or exception
    		}
    	}
    	parent.add(index, child);
	}

	@Override
	public void undo()
	{
	}
} 