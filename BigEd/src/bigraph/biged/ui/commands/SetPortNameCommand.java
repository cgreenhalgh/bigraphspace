package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraphspace.model.Port;

public class SetPortNameCommand extends Command
{
	private final Port port;
	private final String newName;
	private String oldName;

	public SetPortNameCommand(final Port port, final String newName)
	{
		this.port = port;
		if(newName == null || newName.equals(""))
		{
			this.newName = null;
		}
		else
		{
			this.newName = newName;
		}		
		this.oldName = port.getName();
	}

	@Override
	public boolean canExecute()
	{
		return oldName != newName && (oldName == null || !oldName.equals(newName));
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		oldName = port.getName();
		port.setName(newName);
		// TODO PlaceEvent.fireEvent(new PlaceEvent(port, PlaceEvent.Type.CHANGE));		
	}

	@Override
	public void undo()
	{
		port.setName(oldName);
		// TODO PlaceEvent.fireEvent(new PlaceEvent(port, PlaceEvent.Type.CHANGE));		
	}
}