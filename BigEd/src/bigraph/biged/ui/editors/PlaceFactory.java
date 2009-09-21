package bigraph.biged.ui.editors;

import org.eclipse.gef.requests.CreationFactory;

import bigraphspace.model.Place;
import bigraphspace.model.PlaceType;

public class PlaceFactory implements CreationFactory
{
	private final BigraphEditor editor;
	private final PlaceType type;

	public PlaceFactory(final BigraphEditor editor, final PlaceType type)
	{
		this.editor = editor;
		this.type = type;
	}

	public Object getNewObject()
	{
		switch (type)
		{
			case node:
				return editor.getBigraph().getBigraph().createNode("node");

			case site:
				return editor.getBigraph().getBigraph().createSite();

			case root:
				return editor.getBigraph().getBigraph().createRoot();
		}
		return null;
	}

	public Object getObjectType()
	{
		return Place.class;
	}
}
