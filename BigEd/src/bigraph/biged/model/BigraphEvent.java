package bigraph.biged.model;

import bigraph.biged.ui.BigraphLabelProvider;

public class BigraphEvent
{
	public enum Type
	{
		ADD, REMOVE, CHANGE
	}

	private final Object source;
	private final Object changes;
	private final Type type;

	public BigraphEvent(final Object source, final Object changes, final Type type)
	{
		this.source = source;
		this.changes = changes;
		this.type = type;
	}

	public Object getChanges()
	{
		return changes;
	}

	public Object getSource()
	{
		return source;
	}

	public Type getType()
	{
		return type;
	}

	@Override
	public String toString()
	{
		return "Event " + BigraphLabelProvider.text(source) + ": " + type;
	}
}
