package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraphspace.model.Port;

public class SetPortEdgeNameCommand extends Command
{
	private final Port port;
	private final String newEdge;
	private String oldEdge;

	public SetPortEdgeNameCommand(final Port port, final String newEdge)
	{
		this.port = port;
		if(newEdge == null || newEdge.equals(""))
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
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		oldEdge = port.getLinkName();
		port.setLinkName(newEdge);
		// TODO PlaceEvent.fireEvent(new PlaceEvent(port, PlaceEvent.Type.CHANGE));		
	}

	@Override
	public void undo()
	{
		port.setLinkName(oldEdge);
		// TODO PlaceEvent.fireEvent(new PlaceEvent(port, PlaceEvent.Type.CHANGE));		
	}
}