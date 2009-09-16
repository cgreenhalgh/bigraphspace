package bigraph.biged.ui.properties;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

import bigraph.biged.model.PlaceEvent;
import bigraph.biged.model.PlaceEventListener;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;

public abstract class AbstractPlacePropertySection extends AbstractPropertySection implements PlaceEventListener
{
	protected Bigraph bigraph;
	protected Place place;
	protected CommandStack commandStack;

	@Override
	public void dispose()
	{
		PlaceEvent.removeListener(place, this);
		super.dispose();
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection)
	{
		super.setInput(part, selection);
		bigraph = getBigraph(selection);
		setCommandStack(getCommandStack(selection));
		setPlace((Place) TypeMapper.getModelObject(selection));
	}
	
	protected void setCommandStack(final CommandStack commandStack)
	{
		this.commandStack = commandStack;
	}

	private Bigraph getBigraph(final Object object)
	{
		Object result = object;
		if (result instanceof IStructuredSelection)
		{
			result = ((IStructuredSelection) result).getFirstElement();
		}

		if (result instanceof EditPart)
		{
			final EditPart part = ((EditPart) result).getRoot().getContents();
			if (part.getModel() instanceof Bigraph) { return (Bigraph) part.getModel(); }
		}
		return null;
	}

	private CommandStack getCommandStack(final Object object)
	{
		Object result = object;
		if (result instanceof IStructuredSelection)
		{
			result = ((IStructuredSelection) result).getFirstElement();
		}

		if (result instanceof EditPart) { return ((EditPart) result).getViewer().getEditDomain().getCommandStack(); }

		return null;
	}

	private void setPlace(final Place place)
	{
		PlaceEvent.removeListener(this.place, this);
		this.place = place;
		PlaceEvent.addListener(this.place, this);
	}
}
