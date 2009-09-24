package bigraph.biged.model;

import java.util.Collection;

import bigraph.biged.ui.commands.BigraphCommand;

public class BigraphEvent
{
	public enum Type
	{
		ADD, REMOVE, CHANGE
	}

	private final boolean undo;
	private final BigraphCommand command;

	public BigraphEvent(final BigraphCommand command)
	{
		this.command = command;
		this.undo = false;
	}

	public BigraphEvent(final BigraphCommand command, final boolean undo)
	{
		this.command = command;
		this.undo = undo;
	}

	public Collection<?> getAffectedObjects()
	{
		return command.getAffectedObjects();
	}

	public Type getType()
	{
		return command.getType(undo);
	}

	@Override
	public String toString()
	{
		if (undo) { return "Bigraph Event: Undo " + command.toString(); }
		return "Bigraph Event: " + command.toString();
	}
}
