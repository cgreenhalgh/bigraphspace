package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraphspace.model.Place;

public class DeletePlaceCommand extends AbstractBigraphCommand
{
	private final Place parent;
	private final Place child;
	private int index;

	public DeletePlaceCommand(final Bigraph bigraph, final Place parent, final Place child)
	{
		super(bigraph);
		this.parent = parent;
		this.child = child;
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
		index = parent.getChildren().indexOf(child);
		parent.removeChild(child);
		bigraph.fireEvent(new BigraphEvent(parent, child, BigraphEvent.Type.REMOVE));
	}

	@Override
	public String getLabel()
	{
		return "Delete Place";
	}

	@Override
	public void undo()
	{
		parent.insertChild(child, index);
		bigraph.fireEvent(new BigraphEvent(parent, child, BigraphEvent.Type.ADD));
	}
}