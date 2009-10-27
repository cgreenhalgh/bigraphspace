package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import bigraph.biged.ui.widget.LabelledTextSelect;

public abstract class AbstractStringSelectPropertySection extends AbstractStringPropertySection
{
	@Override
	protected void createControl(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		text = new LabelledTextSelect(parent, getWidgetFactory())
		{

			@Override
			protected Command getCommand(final Object textValue)
			{
				return createCommand(textValue);
			}

			@Override
			protected IStructuredContentProvider getContentProvider()
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
		text.setLabel(getLabel());
		text.setMargins(ITabbedPropertyConstants.HMARGIN + ITabbedPropertyConstants.HSPACE);
	}

	protected abstract IStructuredContentProvider getSelectionContentProvider();
}