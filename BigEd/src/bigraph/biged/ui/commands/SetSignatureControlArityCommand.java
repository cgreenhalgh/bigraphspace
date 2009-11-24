package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;

public class SetSignatureControlArityCommand extends SignatureCommand
{
	private final Control control;
	private final Integer newName;
	private Integer oldName;

	public SetSignatureControlArityCommand(final Definitions definitions, final Control control, final Integer newName)
	{
		super(definitions, "Set Signature Control Arity to " + newName);
		this.control = control;
		if (newName == null || newName.equals(""))
		{
			this.newName = null;
		}
		else
		{
			this.newName = newName;
		}
		this.oldName = control.getArity();
	}

	@Override
	public boolean canExecute()
	{
		return oldName != newName && (oldName == null || !oldName.equals(newName));
	}

	@Override
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(control);
		return result;
	}

	@Override
	public Type getType(final boolean undo)
	{
		return Type.CHANGE;
	}

	@Override
	protected void doExecute()
	{
		oldName = control.getArity();
		control.setArity(newName);
	}

	@Override
	protected void doUndo()
	{
		control.setArity(oldName);
	}
}