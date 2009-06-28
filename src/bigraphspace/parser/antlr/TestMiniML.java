/**
 * 
 */
package bigraphspace.parser.antlr;

import org.antlr.runtime.*; 
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import bigraphspace.parser.antlr.MiniMLLexer;
import bigraphspace.parser.antlr.MiniMLParser;


/**
 * @author cmg
 *
 */
public class TestMiniML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length==0)
		{
			System.err.println("Usage: "+TestMiniML.class.getName()+" <infile> ...");
			System.exit(0);
		}
		try {
			for (int i=0; i<args.length; i++) {
				System.out.println("Read "+args[i]);
				MiniMLLexer lex = new MiniMLLexer(new ANTLRFileStream(args[i]));
				CommonTokenStream tokens = new CommonTokenStream(lex);

				MiniMLParser parser = new MiniMLParser(tokens);
				MiniMLParser.start_return val = parser.start();
				System.out.println("-> "+val);
				Object tree = val.getTree();
				System.out.println("tree = "+(tree!=null ? tree.getClass().getName() : "")+" "+tree);
				if (tree instanceof CommonTree) {
					dump((CommonTree)tree, 0);
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
