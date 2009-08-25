package bigraph.biged.ui.editors;

import org.eclipse.gef.requests.CreationFactory;

import bigraph.biged.model.Place;
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
		return new Place(editor.bigraph, type);
	}

	public Object getObjectType()
	{
		return Place.class;
	}
}
