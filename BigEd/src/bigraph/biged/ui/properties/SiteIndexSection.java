package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.Command;

import bigraph.biged.ui.commands.SetSiteIndexCommand;
import bigraphspace.model.Place;

public class SiteIndexSection extends AbstractIntegerPropertySection
{
	@Override
	protected Command createCommand(final String text)
	{
		return new SetSiteIndexCommand(getBigraph(), (Place) getModel(), text);
	}

	@Override
	protected String getLabel()
	{
		return "Site Index:";
	}

	@Override
	protected String getValue()
	{
		final Integer index = ((Place) getModel()).getSiteIndex();
		if (index == null) { return null; }
		return index.toString();
	}
}
