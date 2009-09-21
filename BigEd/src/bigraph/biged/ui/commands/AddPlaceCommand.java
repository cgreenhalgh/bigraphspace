package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

public class AddPlaceCommand extends AbstractBigraphCommand
{
	private final Place parent;
	private final Place child;

	public AddPlaceCommand(final Bigraph bigraph, final Place parent, final Place child)
	{
		super(bigraph);
		this.parent = parent;
		this.child = child;
	}

	@Override
	public boolean canExecute()
	{
		return child.getType() != PlaceType.root;
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		parent.addChild(child);
		bigraph.fireEvent(new BigraphEvent(parent, child, BigraphEvent.Type.ADD));
	}

	@Override
	public String getLabel()
	{
		return "Add Place";
	}

	@Override
	public void undo()
	{
		(parent).removeChild(child);
		bigraph.fireEvent(new BigraphEvent(parent, child, BigraphEvent.Type.REMOVE));
	}
}