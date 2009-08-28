/**
 * 
 */
package bigraphspace.io;

import bigraphspace.model.BasicSignature;
import bigraphspace.model.Bigraph;
import bigraphspace.sorting.Sorting;
import bigraphspace.sorting.SortingException;
import java.io.InputStream;
import java.io.Reader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

/** Reads bigraph(s). Concrete implementations are obtained from ReactiveBigraph or existing
 * bigraph to ensure underlying compatibility.
 * 
 * @author cmg
 *
 */
public abstract class BigraphReader {
	/** configure - signature (normally already set by default) */
	protected BasicSignature signature;
	/** configure - Sorting - only required if validating */
	protected Sorting sorting;
	/** validating - false by default */
	protected boolean validating;
	/** charset - defaults to IOConstants.DEFAULT_CHARSET; not used if reading from Reader */
	protected String charset;
	/** format - fixed on creation/by implementation */
	protected String format;
	/** cons */
	protected BigraphReader(String format) {
		this.format = format;
	}
	/**
	 * @return the signature
	 */
	public BasicSignature getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(BasicSignature signature) {
		this.signature = signature;
	}
	/**
	 * @return the sorting
	 */
	public Sorting getSorting() {
		return sorting;
	}
	/**
	 * @param sorting the sorting to set
	 */
	public void setSorting(Sorting sorting) {
		this.sorting = sorting;
	}
	/**
	 * @return the validating
	 */
	public boolean isValidating() {
		return validating;
	}
	/**
	 * @param validating the validating to set
	 */
	public void setValidating(boolean validating) {
		this.validating = validating;
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
	/** read from string */
	public Bigraph read(String text) throws IOException, SortingException {
		return read(new StringReader(text));
	}
	/** read from IO stream */
	public Bigraph read(File file) throws IOException, SortingException {
		FileInputStream fis = new FileInputStream(file);
		Bigraph bigraph = read(fis);
		fis.close();
		return bigraph;
	}
	/** read from IO stream */
	public Bigraph read(InputStream is) throws IOException, SortingException {
		return read(new InputStreamReader(is, charset!=null ? charset : IOConstants.DEFAULT_CHARSET));
	}
	/** read from Reader*/
	public abstract Bigraph read(Reader reader) throws IOException, SortingException;
	/** useful method(s) - to validate if required */
	protected void validate(Bigraph bigraph) throws SortingException {
		if (!this.validating)
			return;
		if (signature!=null) {
			signature.validate(bigraph);
		}
		if (sorting!=null) {
			sorting.validate(bigraph);			
		}
	}
}
