package bigraph.biged.model;

import java.io.IOException;
import java.io.InputStream;

import bigraphspace.model.Bigraph;

public interface ModelLoader
{
	public Bigraph loadModel(final InputStream inputStream) throws IOException;
}
