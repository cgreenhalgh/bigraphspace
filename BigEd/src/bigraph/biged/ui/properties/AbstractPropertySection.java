package bigraph.biged.ui.properties;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

import bigraph.biged.model.Bigraph;
import bigraph.biged.model.BigraphEventListener;

public abstract class AbstractPropertySection extends org.eclipse.ui.views.properties.tabbed.AbstractPropertySection
		implements BigraphEventListener
{
	private Object model;
	private Bigraph bigraph;
	private CommandStack commandStack;

	@Override
	public void dispose()
	{
		getBigraph().removeListener(getModel(), this);
		super.dispose();
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection)
	{
		if (getBigraph() != null)
		{
			getBigraph().removeListener(model, this);
		}
		model = null;
		bigraph = null;
		super.setInput(part, selection);
		if (getBigraph() != null)
		{
			getBigraph().addListener(getModel(), this);
		}
	}

	protected Bigraph getBigraph()
	{
		if (bigraph == null)
		{
			final EditPartViewer viewer = getViewer();
			if (viewer != null)
			{
				bigraph = (Bigraph) viewer.getRootEditPart().getContents().getModel();
			}
		}
		return bigraph;
	}

	protected CommandStack getCommandStack()
	{
		if (commandStack == null)
		{
			final EditPartViewer viewer = getViewer();
			if (viewer != null)
			{
				commandStack = viewer.getEditDomain().getCommandStack();
			}
		}

		return commandStack;
	}

	protected Object getModel()
	{
		if (model == null)
		{
			model = TypeMapper.getModelObject(getSelection());
		}
		return model;
	}

	protected EditPartViewer getViewer()
	{
		Object result = getSelection();
		if (result instanceof IStructuredSelection)
		{
			result = ((IStructuredSelection) result).getFirstElement();
		}

		if (result instanceof EditPart) { return ((EditPart) result).getViewer(); }
		return null;
	}
}