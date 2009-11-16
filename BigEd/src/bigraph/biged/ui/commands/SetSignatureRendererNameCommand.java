package bigraph.biged.ui.commands;

import java.util.Collection;

import bigraph.biged.model.BigraphEvent.Type;
import bigraphspace.model.signaturexml.Control;
import bigraphspace.model.signaturexml.Definitions;
import bigraphspace.model.signaturexml.Renderer;
import bigraphspace.model.signaturexml.Renderers;

public class SetSignatureRendererNameCommand extends SignatureCommand
{
	private final Control control;
	private final String rendererClass;
	private Renderer renderer = null;
	private String oldClass = null;
	private boolean renderersExists;

	public SetSignatureRendererNameCommand(final Definitions definitions, final Control control, final String rendererClass)
	{
		super(definitions, "Set Renderer Class Name to " + rendererClass);
		this.control = control;
		if (rendererClass == null || rendererClass.equals(""))
		{
			this.rendererClass = null;
		}
		else
		{
			this.rendererClass = rendererClass;
		}
		renderersExists = definitions.getRenderers() != null;
		if(renderersExists)
		{
			//this.oldrenderer = definitions.getRenderers().g;
			for(Renderer render: definitions.getRenderers().getRenderer())
			{
				if(render.getControl().equals(control.getName()))
				{
					oldClass = render.getClazz();
					renderer = render;
				}
			}
		}
	}

	@Override
	public boolean canExecute()
	{
		return renderer == null || !renderer.getClazz().equals(rendererClass);
	}

	@Override
	public Collection<Object> getAffectedObjects()
	{
		final Collection<Object> result = super.getAffectedObjects();
		result.add(control);
		return result;
	}

	@Override
	public Type getType(final boolean undo)
	{
		return Type.CHANGE;
	}

	@Override
	protected void doExecute()
	{
		if(renderersExists)
		{
			definitions.setRenderers(new Renderers());
		}
		if(renderer == null)
		{
			renderer = new Renderer();
			renderer.setControl(control.getName());
		}
		else
		{
			oldClass = renderer.getClazz();
		}
		renderer.setClazz(rendererClass);		
	}

	@Override
	protected void doUndo()
	{
		if(!renderersExists)
		{
			definitions.setRenderers(null);
		}
		else if(oldClass != null)
		{
			renderer.setClazz(oldClass);
		}
		else
		{
			definitions.getRenderers().getRenderer().remove(renderer);
		}
	}
}