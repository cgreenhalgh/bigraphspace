package bigraph.biged.ui.properties;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

import bigraph.biged.model.Place;
import bigraph.biged.model.PlaceEventListener;

public abstract class AbstractPlacePropertySection extends AbstractPropertySection implements PlaceEventListener
{
	protected Place place;
	
	private void setPlace(final Place place)
	{
		if(this.place != null)
		{
			this.place.removePlaceEventListener(this);
		}
		this.place = place;
		if(place != null)
		{
			place.addPlaceEventListener(this);
		}
	}

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
	public void setInput(IWorkbenchPart part, ISelection selection)
	{
		super.setInput(part, selection);
		setPlace((Place) TypeMapper.getModelObject(selection));
	}
}
