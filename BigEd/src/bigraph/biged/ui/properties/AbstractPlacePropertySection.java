package bigraph.biged.ui.properties;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceEventListener;

public abstract class AbstractPlacePropertySection extends AbstractPropertySection implements PlaceEventListener
{
	protected Place place;
	protected CommandStack commandStack;

	@Override
	public void dispose()
	{
		if (place != null)
		{
			place.removePlaceEventListener(this);
		}
		super.dispose();
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection)
	{
		super.setInput(part, selection);
		this.commandStack = (CommandStack) part.getAdapter(CommandStack.class);
		setPlace((Place) TypeMapper.getModelObject(selection));
	}

	private void setPlace(final Place place)
	{
		if (this.place != null)
		{
			this.place.removePlaceEventListener(this);
		}
		this.place = place;
		if (place != null)
		{
			place.addPlaceEventListener(this);
		}
	}
}
