package bigraph.biged.ui.editors;

import org.eclipse.gef.requests.CreationFactory;

import bigraphspace.model.Port;

public class PortFactory implements CreationFactory
{
	private final BigraphEditor editor;

	public PortFactory(final BigraphEditor editor)
	{
		this.editor = editor;
	}

	public Object getNewObject()
	{
		return editor.getBigraph().getBigraph().createPort(Port.DEFAULT_PORT_NAME_PREFIX);
	}

	public Object getObjectType()
	{
		return Port.class;
	}
}
