package bigraph.biged.ui.properties;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import bigraph.biged.model.PlaceEvent;

public abstract class AbstractPlaceStringPropertySection extends AbstractPlaceSinglePropertySection implements ModifyListener
{
	protected Text labelText;
	private boolean modified;
	
	protected Control createControl(final Composite parent)
	{
		labelText = getWidgetFactory().createText(parent, ""); //$NON-NLS-1$
		final FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH * 2);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		labelText.setLayoutData(data);
		labelText.addModifyListener(this);
		labelText.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetDefaultSelected(final SelectionEvent e)
			{
				modified = false;				
				setValue(labelText.getText());
			}

		});
		labelText.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(final FocusEvent e)
			{
				modified = false;				
				setValue(labelText.getText());
			}
		});
		return labelText;
	}
	
	public void modifyText(final ModifyEvent e)
	{
		modified = true;
	}	

	@Override
	public void refresh()
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			public void run()
			{
				setText(getValue());
			}
		});
	}
	
	public void onPlaceEvent(PlaceEvent event)
	{
		if(!modified)
		{
			refresh();
		}
	}

	private void setText(final String text)
	{
		if (labelText.isDisposed()) { return; }
		if (text != null)
		{
			if (!labelText.getText().equals(text))
			{
				labelText.setText(text);
			}
		}
		else
		{
			labelText.setText("");
		}
		modified = false;		
	}

	protected abstract String getValue();
	
	protected abstract void setValue(final String value);
}
