package bigraph.biged.model;

import java.io.IOException;
import java.io.InputStream;

public interface ModelLoader
{
	public Bigraph loadModel(final InputStream inputStream) throws IOException;
}
