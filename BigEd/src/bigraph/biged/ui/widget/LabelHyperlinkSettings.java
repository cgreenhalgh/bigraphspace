package bigraph.biged.ui.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.HyperlinkSettings;

public class LabelHyperlinkSettings extends HyperlinkSettings
{
	private boolean enabled = true;
	private final Display display;

	public LabelHyperlinkSettings(final Display display, final HyperlinkSettings settings)
	{
		super(display);
		this.display = display;
		setActiveForeground(settings.getActiveForeground());
		setForeground(settings.getForeground());
		setHyperlinkUnderlineMode(settings.getHyperlinkUnderlineMode());
	}

	@Override
	public Color getActiveForeground()
	{
		if (!enabled) { return display.getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW); }
		return super.getActiveForeground();
	}

	@Override
	public Color getForeground()
	{
		if (!enabled) { return display.getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW); }
		return super.getForeground();
	}

	@Override
	public Cursor getHyperlinkCursor()
	{
		if (!enabled) { return getTextCursor(); }
		return super.getHyperlinkCursor();
	}

	@Override
	public int getHyperlinkUnderlineMode()
	{
		if (!enabled) { return UNDERLINE_NEVER; }
		return super.getHyperlinkUnderlineMode();
	}

	public void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
	}

}
