package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Place;

public class DeletePlaceCommand extends AbstractBigraphCommand
{
	private final Place parent;
	private final Place child;
	private int index;

	public DeletePlaceCommand(final Bigraph bigraph, final Place parent, final Place child)
	{
		super(bigraph, "Delete " + BigraphLabelProvider.text(child) + " from " + BigraphLabelProvider.text(parent));
		this.parent = parent;
		this.child = child;
	}

	@Override
	public void execute()
	{
		index = parent.getChildren().indexOf(child);
		parent.removeChild(child);
		bigraph.fireEvent(new BigraphEvent(parent, child, BigraphEvent.Type.REMOVE));
	}

	@Override
	public void undo()
	{
		parent.insertChild(child, index);
		bigraph.fireEvent(new BigraphEvent(parent, child, BigraphEvent.Type.ADD));
	}
}