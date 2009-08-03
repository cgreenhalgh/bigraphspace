package bigraph.biged.ui.graph.parts;

import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.graphics.Image;

public class PortTreePart extends AbstractTreeEditPart
{
	@Override
	protected Image getImage()
	{
		return super.getImage();
	}

	@Override
	protected String getText()
	{
		return getModel().toString();
	}
}
