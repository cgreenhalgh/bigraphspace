/**
 * 
 */
package bigraphspace.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.CharArrayWriter;

import bigraphspace.model.Bigraph;

/** Bigraph writer - abstract (format-independent) base class. Obtained (compatibly implementation)
 * from ReactiveBigraph or Bigraph.
 * 
 * @author cmg
 *
 */
public abstract class BigraphWriter {
	/** charset - defaults to IOConstants.DEFAULT_CHARSET; not used if reading from Reader */
	protected String charset;
	/** format - fixed on creation/by implementation */
	protected String format;
	/** cons */
	protected BigraphWriter(String format) {
		this.format = format;
	}
	/**
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}
	/**
	 * @param charset the charset to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/** write to string buffer */
	public String writeToString(Bigraph bigraph) throws IOException {
		CharArrayWriter caw = new CharArrayWriter();
		write(bigraph, caw);
		caw.flush();
		return caw.toString();
	}
	/** write to file */
	public void write(Bigraph bigraph, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		write(bigraph, fos);
		fos.close();
	}
	/** write to IO stream */
	public void write(Bigraph bigraph, OutputStream os) throws IOException {
		write(bigraph, new OutputStreamWriter(os, charset!=null ? charset : IOConstants.DEFAULT_CHARSET));
	}
	/** write to Writer */
	public abstract void write(Bigraph bigraph, Writer writer) throws IOException;
}
