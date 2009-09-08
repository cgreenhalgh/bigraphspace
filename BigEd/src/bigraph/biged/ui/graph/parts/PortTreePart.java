package bigraph.biged.ui.graph.parts;

import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.graphics.Image;

import bigraph.biged.ui.BigraphLabelProvider;

public class PortTreePart extends AbstractTreeEditPart
{
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
