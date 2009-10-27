package bigraph.biged.ui.commands;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.signaturexml.Definitions;

public abstract class SignatureCommand extends Command
{
	protected final Definitions definitions;

	public SignatureCommand(final Definitions definitions, final String label)
	{
		super(label);
		this.definitions = definitions;
	}

	@Override
	public boolean canExecute()
	{
		return true;
	}

	@Override
	public boolean canUndo()
	{
		return true;
	}

	@Override
	public void execute()
	{
		doExecute();
		//bigraph.fireEvent(new BigraphEvent(this));
	}

	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = new HashSet<Object>();
		//result.addAll(bigraph.getEdges());
		return result;
	}

	public abstract Type getType(final boolean undo);

	@Override
	public String toString()
	{
		return getLabel();
	}

	@Override
	public void undo()
	{
		doUndo();
		//bigraph.fireEvent(new BigraphEvent(this, true));
	}

	protected abstract void doExecute();

	protected abstract void doUndo();
}
