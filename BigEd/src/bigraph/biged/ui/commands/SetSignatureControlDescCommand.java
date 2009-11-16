package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;

public class SetSignatureControlDescCommand extends SignatureCommand
{
	private final Control control;
	private final String newDesc;
	private String oldDesc;

	public SetSignatureControlDescCommand(final Definitions definitions, final Control control, final String newDesc)
	{
		super(definitions, "Set Signature Control Description to " + newDesc);
		this.control = control;
		if (newDesc == null || newDesc.equals(""))
		{
			this.newDesc = null;
		}
		else
		{
			this.newDesc = newDesc;
		}
		this.oldDesc = control.getDescription();
	}

	@Override
	public boolean canExecute()
	{
		return oldDesc != newDesc && (oldDesc == null || !oldDesc.equals(newDesc));
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
		oldDesc = control.getName();
		control.setDescription(newDesc);
	}

	@Override
	protected void doUndo()
	{
		control.setDescription(oldDesc);
	}
}