package bigraph.biged.ui.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import bigraphspace.model.signaturexml.Definitions;

public abstract class SignatureSection
{
	protected Definitions definitions;
	protected Section section;
	protected Object input;
	
	public SignatureSection(final Definitions definitions)
	{
		this.definitions = definitions;
	}
	
	public void setInput(final Object input)
	{
		this.input = input;
	}
	
	public void createSection(final Composite parent, final FormToolkit toolkit, final boolean collapsable)
	{
		int style = ExpandableComposite.TITLE_BAR;
		if (collapsable)
		{
			style = ExpandableComposite.TITLE_BAR | ExpandableComposite.TWISTIE;
		}
		section = toolkit.createSection(parent, style);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(IFormColors.SEPARATOR));
		section.setExpanded(true);

		final Composite client = toolkit.createComposite(section, SWT.WRAP);
		section.setClient(client);
		toolkit.paintBordersFor(client);
	}
	
	public Section getSection()
	{
		return section;
	}

	public void setLayoutData(final Object data)
	{
		section.setLayoutData(data);
	}
}
