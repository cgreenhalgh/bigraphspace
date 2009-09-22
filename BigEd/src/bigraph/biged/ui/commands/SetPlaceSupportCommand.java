package bigraph.biged.ui.commands;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraphspace.model.Place;

public class SetPlaceSupportCommand extends AbstractBigraphCommand
{
	private final Place place;
	private final String newName;
	private String oldName;

	public SetPlaceSupportCommand(final Bigraph bigraph, final Place place, final String newName)
	{
		super(bigraph, "Set Place Support Name to " + newName);
		this.place = place;
		if (newName == null || newName.equals(""))
		{
			this.newName = null;
		}
		else
		{
			this.newName = newName;
		}
		oldName = place.getSupport();
	}

	@Override
	public boolean canExecute()
	{
		return oldName != newName && (oldName == null || !oldName.equals(newName));
	}

	@Override
	public void execute()
	{
		oldName = place.getSupport();
		place.setSupport(newName);
		bigraph.fireEvent(new BigraphEvent(place, newName, BigraphEvent.Type.CHANGE));
		// TODO Update edges
	}

	@Override
	public void undo()
	{
		place.setSupport(oldName);
		bigraph.fireEvent(new BigraphEvent(place, oldName, BigraphEvent.Type.CHANGE));
		// TODO Update edges
	}
}