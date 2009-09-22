package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Port;

public class SetPortEdgeNameCommand extends AbstractBigraphCommand
{
	private final Port port;
	private final String newEdge;
	private String oldEdge;

	public SetPortEdgeNameCommand(final Bigraph bigraph, final Port port, final String newEdge)
	{
		super(bigraph, "Set " + BigraphLabelProvider.text(port) + " to " + newEdge);
		this.port = port;
		if (newEdge == null || newEdge.equals(""))
		{
			this.newEdge = null;
		}
		else
		{
			this.newEdge = newEdge;
		}
		this.oldEdge = port.getLinkName();
	}

	@Override
	public boolean canExecute()
	{
		return oldEdge != newEdge && (oldEdge == null || !oldEdge.equals(newEdge));
	}

	@Override
	public void execute()
	{
		oldEdge = port.getLinkName();
		port.setLinkName(newEdge);
		bigraph.fireEvent(new BigraphEvent(port, newEdge, BigraphEvent.Type.CHANGE));
	}

	@Override
	public void undo()
	{
		port.setLinkName(oldEdge);
		bigraph.fireEvent(new BigraphEvent(port, oldEdge, BigraphEvent.Type.CHANGE));
	}
}