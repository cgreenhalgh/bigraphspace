package bigraph.biged.ui.graph.parts;

import org.eclipse.swt.graphics.Image;

import bigraph.biged.model.Bigraph;
import bigraph.biged.ui.BigraphLabelProvider;

public class PortTreePart extends AbstractBigraphTreeEditPart
{
	public PortTreePart(final Bigraph bigraph)
	{
		super(bigraph);
	}

	@Override
	protected Image getImage()
	{
		return BigraphLabelProvider.image(this);
	}

	@Override
	protected String getText()
	{
		return BigraphLabelProvider.text(this);
	}
}
