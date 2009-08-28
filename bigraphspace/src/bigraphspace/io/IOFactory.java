/**
 * 
 */
package bigraphspace.io;

/** IO Factory method interface, implemented by concrete Bigraph and ReactiveBigraph.
 * 
 * @author cmg
 *
 */
public interface IOFactory {
	/** IO - get compatible reader, default format */
	public BigraphReader getReader() throws UnsupportedFormatException;
	/** IO - get compatible reader, specified format - see bigraphspace.io.IOConstants */
	public BigraphReader getReader(String format) throws UnsupportedFormatException;
	/** IO - get compatible writer, default format */
	public BigraphWriter getWriter() throws UnsupportedFormatException;
	/** IO - get compatible writer, specified format - see bigraphspace.io.IOConstants */
	public BigraphWriter getWriter(String format) throws UnsupportedFormatException;
}
