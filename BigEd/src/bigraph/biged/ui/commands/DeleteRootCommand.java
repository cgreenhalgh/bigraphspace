package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.Place;

public class DeleteRootCommand extends AbstractBigraphCommand
{
	private final Place child;
	private int index;

	public DeleteRootCommand(final Bigraph bigraph, final Place child)
	{
		super(bigraph, "Delete Root");
		this.child = child;
	}

	@Override
	public void execute()
	{
		index = bigraph.getBigraph().getRoots().indexOf(child);
		bigraph.getBigraph().removeRoot(child);
		bigraph.fireEvent(new BigraphEvent(bigraph, child, Type.REMOVE));
	}

	@Override
	public void undo()
	{
		bigraph.getBigraph().insertRoot(child, index);
		bigraph.fireEvent(new BigraphEvent(bigraph, child, Type.ADD));
	}
}