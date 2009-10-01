package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class BigraphSignatureSection extends AbstractStringSelectPropertySection
{
	@Override
	protected Command createCommand(final String text)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getLabel()
	{
		return "Signature";
	}

	@Override
	protected IStructuredContentProvider getSelectionContentProvider()
	{
		return new IStructuredContentProvider()
		{

			@Override
			public void dispose()
			{
				// TODO Auto-generated method stub

			}

			@Override
			public Object[] getElements(final Object inputElement)
			{
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput)
			{
				// TODO Auto-generated method stub

			}
		};
	}

	@Override
	protected String getValue()
	{
		return null;
	}
}
