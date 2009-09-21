package bigraph.biged.ui.graph.parts;

import org.eclipse.gef.editparts.AbstractTreeEditPart;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEvent;
import bigraph.biged.model.BigraphEventListener;

public abstract class AbstractBigraphTreeEditPart extends AbstractTreeEditPart implements BigraphEventListener
{
	private final Bigraph bigraph;

	public AbstractBigraphTreeEditPart(final Bigraph bigraph)
	{
		this.bigraph = bigraph;
	}

	@Override
	public void activate()
	{
		if (isActive()) { return; }
		bigraph.addListener(getModel(), this);
		super.activate();
	}

	@Override
	public void deactivate()
	{
		if (!isActive()) { return; }
		bigraph.removeListener(getModel(), this);
		super.deactivate();
	}

	public Bigraph getBigraph()
	{
		return bigraph;
	}

	@Override
	public void onPlaceEvent(final BigraphEvent event)
	{
		refresh();
	}
}
