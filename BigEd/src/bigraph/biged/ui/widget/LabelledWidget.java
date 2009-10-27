package bigraph.biged.ui.widget;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;

public abstract class LabelledWidget extends Composite
{
	protected CommandStack commandStack;
	protected boolean modified;
	protected FormText textLabel;
	protected int margins = 0;

	private final LabelHyperlinkSettings settings;

	public LabelledWidget(final Composite parent, final FormToolkit formToolkit, final int style)
	{
		super(parent, 0);
		setLayout(new FormLayout());
		formToolkit.adapt(this);
		settings = new LabelHyperlinkSettings(getDisplay(), formToolkit.getHyperlinkGroup());
		settings.setActiveForeground(formToolkit.getHyperlinkGroup().getActiveForeground());

		createControls(formToolkit, style);
		refreshLayout();
	}

	public void addHyperlinkListeners(final IHyperlinkListener hyperlinkListener)
	{
		textLabel.addHyperlinkListener(hyperlinkListener);
	}

	public abstract Object getValue();

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
			settings.setEnabled(false);
			textLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		}
		else
		{
			settings.setEnabled(true);
			textLabel.setForeground(ColorConstants.black);
		}
	}

	public void setLabel(final String label)
	{
		this.textLabel.setText("<form><p>" + label + "</p></form>", true, false);
	}

	public void setMargins(final int margins)
	{
		this.margins = margins;
		refreshLayout();
	}

	protected void createControls(final FormToolkit formToolkit, final int style)
	{
		textLabel = formToolkit.createFormText(this, true);
		textLabel.setHyperlinkSettings(settings);
	}

	protected void execute()
	{
		if (modified)
		{
			final Command command = getCommand(getValue());
			if (command != null)
			{
				commandStack.execute(command);
			}
		}
	}

	protected abstract Command getCommand(final Object value);

	protected abstract void refreshLayout();
}