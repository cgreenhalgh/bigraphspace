package bigraph.biged.ui.commands;

import org.eclipse.gef.commands.Command;

import bigraph.biged.model.Bigraph;

public abstract class AbstractBigraphCommand extends Command
{
	protected final Bigraph bigraph;

	public AbstractBigraphCommand(final Bigraph bigraph)
	{
		this.bigraph = bigraph;
	}
}
