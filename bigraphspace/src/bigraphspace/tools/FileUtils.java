/**
 * 
 */
package bigraphspace.tools;

import java.io.File;

import org.apache.log4j.Logger;

import bigraphspace.api.BigraphUtils;
import bigraphspace.api.ReactiveBigraph;
import bigraphspace.model.Bigraph;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.xml.DomReactiveBigraph;
import bigraphspace.model.xml.DomBigraph;
import bigraphspace.sorting.Sorting;
import bigraphspace.sorting.SortingException;
import bigraphspace.io.BigraphReader;
import bigraphspace.io.BigraphWriter;
import bigraphspace.io.IOConstants;
import bigraphspace.io.IOFactory;
import bigraphspace.io.UnsupportedFormatException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

/** common code for file-related tools.
 * 
 * @author cmg
 *
 */
public class FileUtils {
	/** logger */
	static Logger logger = Logger.getLogger(FileUtils.class);
	/** get default reactive bigraph with optional signature xml file */
	public static ReactiveBigraph getReactiveBigraph(File sigfile) {
		Sorting sorting = null;
		if (sigfile!=null) {
			try {
				sorting = BigraphUtils.readSignatureXml(sigfile);
			}
			catch (Exception e) {
				logger.error("Reading signature "+sigfile, e);
				System.exit(-2);
			}
		}
		BasicSignature signature = (sorting!=null) ? sorting.getSignature() : new BasicSignature();
		ReactiveBigraph reactiveBigraph = new DomReactiveBigraph(signature);
		return reactiveBigraph;
	}
	/** get default  bigraph with optional signature xml file */
	public static Bigraph getBigraph(File sigfile) throws ParserConfigurationException {
		Sorting sorting = null;
		if (sigfile!=null) {
			try {
				sorting = BigraphUtils.readSignatureXml(sigfile);
			}
			catch (Exception e) {
				logger.error("Reading signature "+sigfile, e);
				System.exit(-2);
			}
		}
		BasicSignature signature = (sorting!=null) ? sorting.getSignature() : new BasicSignature();
		Bigraph bigraph = new DomBigraph(signature);
		return bigraph;
	}
	/** convert file */
	public static void convertFile(IOFactory iofactory, File infile, String informat, File outfile, String outformat) throws IOException, UnsupportedFormatException, SortingException {
		BigraphReader reader = iofactory.getReader(informat);
		Bigraph bigraph = reader.read(infile);
		BigraphWriter writer = iofactory.getWriter(outformat);
		writer.write(bigraph, outfile);
	}
	/** convert file */
	public static void convertFile(File sigfile, File infile, String informat, File outfile, String outformat) throws IOException, UnsupportedFormatException, SortingException, ParserConfigurationException {
		Bigraph iofactory = getBigraph(sigfile);
		BigraphReader reader = iofactory.getReader(informat);
		Bigraph bigraph = reader.read(infile);
		BigraphWriter writer = iofactory.getWriter(outformat);
		writer.write(bigraph, outfile);
	}
}
