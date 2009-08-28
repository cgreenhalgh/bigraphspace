/**
 * 
 */
package bigraphspace.api;

import bigraphspace.model.BasicSignature;
import bigraphspace.model.signaturexml.SignatureFactory;
import bigraphspace.sorting.Sorting;
import java.io.IOException;
import java.io.File;

/** Some utility methods.
 * 
 * @author cmg
 *
 */
public class BigraphUtils {
	/** IO utility - often needed at bootstrap */
	public static Sorting readSignatureXml(File file) throws IOException {
		// term lang
		try {
			BasicSignature sig = null;
			Sorting sorting = null;

			sorting = Sorting.readSorting(file);
			if (sorting!=null)
				sig = sorting.getSignature();
			else
				sig = SignatureFactory.readSignature(file);
			return sorting;
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (Exception e) {
			throw new IOException(e.getMessage(), e);
		}
	}

}
