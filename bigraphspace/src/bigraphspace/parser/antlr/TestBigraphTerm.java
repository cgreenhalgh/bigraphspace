/**
 * 
 */
package bigraphspace.parser.antlr;

import java.io.File;
import org.antlr.runtime.*; 
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.w3c.dom.Document;

import bigraphspace.model.BasicSignature;
import bigraphspace.parser.antlr.BigraphTermLexer;
import bigraphspace.parser.antlr.BigraphTermParser;
import bigraphspace.sorting.Sorting;

import bigraphspace.model.xml.DomBigraph;
import bigraphspace.model.signaturexml.SignatureFactory;
import bigraphspace.model.xml.XmlUtils;

/**
 * @author cmg
 *
 */
public class TestBigraphTerm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length!=1 && args.length!=2)
		{
			System.err.println("Usage: "+TestBigraphTerm.class.getName()+" <infile.btl> [<signature.xml>]");
			System.exit(0);
		}
		try {
			String btlfile = args[0];
			String sigfile = (args.length>1 ? args[1] : null);
			System.out.println("Read Bigraph Term language (btl) file "+btlfile);
			BigraphTermLexer lex = new BigraphTermLexer(new ANTLRFileStream(btlfile));
			CommonTokenStream tokens = new CommonTokenStream(lex);

			BigraphTermParser parser = new BigraphTermParser(tokens);
			BigraphTermParser.start_return val = parser.start();
			System.out.println("-> "+val);
			Object tree = val.getTree();
			System.out.println("tree = "+(tree!=null ? tree.getClass().getName() : "")+" "+tree);
			if (tree instanceof CommonTree) {
				dump((CommonTree)tree, 0);
				Document doc = BigraphTermUtils.toDocument((CommonTree)tree);
				System.out.println("=== XML internal form ===");
				XmlUtils.dump(System.out, doc);
				System.out.println("=== XML ===");
				XmlUtils.write(doc, new java.io.OutputStreamWriter(System.out));
				System.out.println();
				
				BasicSignature sig = null;
				Sorting sorting = null;
				if (sigfile!=null) {
 					System.out.println("=== Signature file "+sigfile+" ===");
 					sorting = Sorting.readSorting(new File(sigfile));
 					if (sorting!=null)
 						sig = sorting.getSignature();
 					else
 						sig = SignatureFactory.readSignature(new File(sigfile));
				}
				System.out.println("=== Bigraph Model ===");

				DomBigraph bigraph = new DomBigraph(sig, doc);
				bigraph.dump(System.out);

				if (sig!=null) {
					System.out.println("=== validate signature ===");
					sig.validate(bigraph);
					if (sorting!=null) {
						System.out.println("=== validate sorting ===");
						sorting.validate(bigraph);
					}
				}
			}
		} catch (Exception e)  {
			System.err.println("Error: "+e);
			e.printStackTrace(System.err);
		}
	}
	static void dump(Tree tree, int indent) {
		for (int i=0;i<indent;i++)
			System.out.print("  ");
		System.out.println("type="+tree.getType()+", text="+tree.getText());
		for (int i=0; i<tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);
			dump(child, indent+1);
		}
	}
}
