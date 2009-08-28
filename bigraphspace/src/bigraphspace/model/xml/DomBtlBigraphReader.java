/**
 * 
 */
package bigraphspace.model.xml;

import java.io.IOException;
import java.io.Reader;

import bigraphspace.io.BigraphReader;
import bigraphspace.io.IOConstants;
import bigraphspace.model.Bigraph;
import bigraphspace.model.BasicSignature;
import bigraphspace.sorting.SortingException;

import java.io.File;
import org.antlr.runtime.*; 
import org.antlr.runtime.tree.CommonTree;
import org.w3c.dom.Document;

import bigraphspace.model.BasicSignature;
import bigraphspace.parser.antlr.BigraphTermLexer;
import bigraphspace.parser.antlr.BigraphTermParser;
import bigraphspace.parser.antlr.BigraphTermUtils;
import bigraphspace.sorting.Sorting;

import bigraphspace.model.xml.DomBigraph;
import bigraphspace.model.signaturexml.SignatureFactory;


/**
 * @author cmg
 *
 */
public class DomBtlBigraphReader  extends BigraphReader {

	/** cons */
	DomBtlBigraphReader(BasicSignature signature) {
		super(IOConstants.FORMAT_BTL);
		this.setSignature(signature);
	}
	/* (non-Javadoc)
	 * @see bigraphspace.io.BigraphReader#read(java.io.Reader)
	 */
	//@Override
	public Bigraph read(Reader reader) throws IOException, SortingException {
		try {
			BigraphTermLexer lex = new BigraphTermLexer(new ANTLRReaderStream(reader));
			CommonTokenStream tokens = new CommonTokenStream(lex);

			BigraphTermParser parser = new BigraphTermParser(tokens);
			BigraphTermParser.start_return val = parser.start();
			//System.out.println("-> "+val);
			Object tree = val.getTree();
			//System.out.println("tree = "+(tree!=null ? tree.getClass().getName() : "")+" "+tree);
			if (tree instanceof CommonTree) {
				Document doc = BigraphTermUtils.toDocument((CommonTree)tree);
				//System.out.println("=== Bigraph Model ===");

				DomBigraph bigraph = new DomBigraph(signature, doc);
				//bigraph.dump(System.out);

				validate(bigraph);
				return bigraph;
			}
			throw new IOException("Did not parse to CommonTree: "+tree);
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (Exception e) {
			throw new IOException(e.getMessage(), e);
		}
	}

}
