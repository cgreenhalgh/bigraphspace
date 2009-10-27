package bigraph.biged.ui.widget;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

public abstract class LabelledText extends LabelledWidget
{
	private int lines = 1;
	protected boolean modified;
	protected Text textField;

	public LabelledText(final Composite parent, final FormToolkit formToolkit)
	{
		super(parent, formToolkit, 0);
	}
	
	public LabelledText(final Composite parent, final FormToolkit formToolkit, final int style)
	{
		super(parent, formToolkit, style);
	}
	

	@Override
	public void addHyperlinkListeners(final IHyperlinkListener hyperlinkListener)
	{
		textLabel.addHyperlinkListener(hyperlinkListener);
	}

	public void addVerifyListener(final VerifyListener verifyListener)
	{
		textField.addVerifyListener(verifyListener);
	}

	@Override
	public Object getValue()
	{
		return textField.getText();
	}
	
	public void setHeight(final int lines)
	{
		this.lines = lines;
		refreshLayout();
	}

	@Override
	public void setCommandStack(final CommandStack commandStack)
	{
		this.commandStack = commandStack;
	}

	@Override
	public void setEnabled(final boolean enabled)
	{
		super.setEnabled(enabled);
		if (!enabled)
		{
			setText(null);
		}
		textField.setEnabled(enabled);
	}

	public void setText(final String text)
	{
		if (textField.isDisposed()) { return; }
		if (text == null)
		{
			textField.setText("");
		}
		else
		{
			if (!textField.getText().equals(text))
			{
				textField.setText(text);
				setEnabled(true);
			}
		}
		modified = false;
	}

	@Override
	protected void createControls(final FormToolkit formToolkit, final int style)
	{
		super.createControls(formToolkit, style);
		textField = formToolkit.createText(this, "", style);
		textField.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(final FocusEvent e)
			{
				execute();
			}
		});
		textField.addModifyListener(new ModifyListener()
		{
			public void modifyText(final ModifyEvent e)
			{
				modified = true;
			}
		});
		textField.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetDefaultSelected(final SelectionEvent e)
			{
				execute();
			}
		});
	}

	@Override
	protected void refreshLayout()
	{
		FormData data = new FormData();
		data.left = new FormAttachment(0, margins);
		data.top = new FormAttachment(textField, 3, SWT.TOP);
		data.width = org.eclipse.ui.views.properties.tabbed.AbstractPropertySection.STANDARD_LABEL_WIDTH;
		textLabel.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(textLabel, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, -margins);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		if(lines > 1)
		{
			GC gc = new GC(textField);
			FontMetrics fm = gc.getFontMetrics();
			data.height = fm.getHeight() * lines;
		}		
		textField.setLayoutData(data);
	}
}
