/**
 * 
 */
package bigraphspace.model.xml;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintStream;
import java.io.PrintWriter;

import bigraphspace.io.BigraphWriter;
import bigraphspace.io.IOConstants;
import bigraphspace.model.Bigraph;

/**
 * @author cmg
 *
 */
public class DomBtlBigraphWriter extends BigraphWriter {

	/** cons */
	DomBtlBigraphWriter() {
		super(IOConstants.FORMAT_BTL);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.io.BigraphWriter#write(java.io.Writer)
	 */
	//@Override
	public void write(Bigraph bigraph, Writer writer) throws IOException {
		PrintWriter pw = new PrintWriter(writer);
		bigraph.dump(pw);
		pw.flush();
	}

}
