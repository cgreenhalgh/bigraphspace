package bigraph.biged.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public abstract class AbstractPlaceSinglePropertySection extends AbstractPlacePropertySection
{

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		super.createControls(parent, aTabbedPropertySheetPage);
		
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Control control = createControl(composite);

		final CLabel labelLabel = getWidgetFactory().createCLabel(composite, getLabel()); //$NON-NLS-1$
		final FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(control, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(control, 0, SWT.TOP);
		labelLabel.setLayoutData(data);
	}

	protected abstract String getLabel();
	
	protected abstract Control createControl(Composite parent);
}
