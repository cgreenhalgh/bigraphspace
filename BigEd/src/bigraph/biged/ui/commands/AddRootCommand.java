package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

public class AddRootCommand extends AbstractBigraphCommand
{
	private final Place child;
	private final Place before;

	public AddRootCommand(final Bigraph bigraph, final Place child, final Place after)
	{
		super(bigraph, "Add " + BigraphLabelProvider.text(child) + " to bigraph");		
		this.child = child;
		this.before = after;
	}

	@Override
	public boolean canExecute()
	{
		return child.getType() == PlaceType.root;
	}

	@Override
	public void execute()
	{
		final int index = bigraph.getBigraph().getRoots().indexOf(before);
		System.out.println("Insert at " + index);

		if (index < 0 || index >= bigraph.getBigraph().getRoots().size())
		{
			bigraph.getBigraph().addRoot(child);
		}
		else
		{
			bigraph.getBigraph().insertRoot(child, index);
		}
		bigraph.fireEvent(new BigraphEvent(bigraph, child, BigraphEvent.Type.ADD));
	}

	@Override
	public void undo()
	{
		bigraph.getBigraph().removeRoot(child);
		bigraph.fireEvent(new BigraphEvent(bigraph, child, BigraphEvent.Type.REMOVE));
	}
}