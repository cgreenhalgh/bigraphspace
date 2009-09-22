package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.ui.BigraphLabelProvider;
import bigraphspace.model.Port;

public class SetPortNameCommand extends AbstractBigraphCommand
{
	private final Port port;
	private final String newName;
	private String oldName;

	public SetPortNameCommand(final Bigraph bigraph, final Port port, final String newName)
	{
		super(bigraph, "Set " + BigraphLabelProvider.text(port) + " to " + newName);
		this.port = port;
		if (newName == null || newName.equals(""))
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
		bigraph.fireEvent(new BigraphEvent(port, newName, BigraphEvent.Type.CHANGE));
	}

	@Override
	public void undo()
	{
		port.setName(oldName);
		bigraph.fireEvent(new BigraphEvent(port, oldName, BigraphEvent.Type.CHANGE));
	}
}