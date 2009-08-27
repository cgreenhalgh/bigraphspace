package bluetoothex;

import equip.ect.components.bluetoothdiscover.BluetoothDiscover;
import org.apache.log4j.Logger;
import bigraphspace.model.Bigraph;
import bigraphspace.model.Place;
import bigraphspace.model.Match;
import bigraphspace.model.Control;
import bigraphspace.model.BasicSignature;
import bigraphspace.model.VariableDefinition;
import bigraphspace.model.VariableType;

import bigraphspace.api.BigraphFinder;
import bigraphspace.api.BigraphSession;
import bigraphspace.api.ReactiveBigraph;
import bigraphspace.api.ReactionRule;
import bigraphspace.api.RuleFiredEvent;
import bigraphspace.api.RuleFiredListener;
import bigraphspace.api.RuleCondition;
import bigraphspace.model.xml.DomReactiveBigraph;
import bigraphspace.model.xml.DomMatch;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import java.util.Date;
import java.util.StringTokenizer;

import java.io.IOException;

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

/** Main for bluetoother
 * 
 * * @author cmg
 */
public class Main
{
	/** logger 
	 */
	static Logger logger = Logger.getLogger(Main.class);
	/** app main
	 */
	public static void main(String args[])
	{
		try
		{
			String configFilename = "etc/initialcontent.btl";
			String sigFilename = "etc/signature.xml";
			if (args.length>0) 
				configFilename = args[0];
			if (args.length>1) 
				sigFilename = args[0];
			logger.info("Loading signature/sorting from "+sigFilename);
			final Sorting sorting = readSorting(sigFilename);
			final BasicSignature signature = sorting.getSignature();
			logger.info("Loading initial bigraph state from "+configFilename);
			final Bigraph initialValue = readBigraphTermLanguageFile(sorting, configFilename);
			
			final ReactiveBigraph bigraph = new DomReactiveBigraph(initialValue.getSignature());
			logger.info("Creating bigraphspace");
			BigraphFinder.setDefaultBigraph(bigraph);
			
			logger.info("creating behaviour reaction");
			ReactionRule behaviourRule = new ReactionRule();
			RuleCondition behaviourCondition = new RuleCondition();
			Bigraph behaviourRedex = readBigraphTermLanguageString(sorting,
					"bigraph"+
					// a detected bluetooth radio...
					"  BigraphSpaceBluetooth( "+
					"    [1] | DescriptionBluetooth ( BluetoothAddress ( $address:string ) ) "+
					"  ) "+
					// leave authoring unchanged
					"||BigraphSpaceAuthored( "+
					"    [2]"+
					"  | DescriptionRoom( "+
					"      DescriptionBluetooth ( BluetoothAddress ( $address:string ) )"+
					"    | DigitalDocument ( [3] )"+
					"    )"+
					"  )"+
					// a screen...
					"||BigraphSpaceScreen( [4] )"+
					"where $address:string");
			behaviourRedex.dump(System.out);
			behaviourCondition.setPattern(behaviourRedex);
			behaviourCondition.setMaxOccurs(RuleCondition.UNLIMITED);
			behaviourRule.setRedex(behaviourCondition);
			
			logger.info("Creating reactum");
			Bigraph behaviourReactum = readBigraphTermLanguageString(sorting,
					"bigraph"+
					// remove detected bluetooth radio...
					"  BigraphSpaceBluetooth( "+
					"    [1] "+
					"  ) "+
					// leave authoring unchanged
					"||BigraphSpaceAuthored( "+
					"    [2]"+
					"  | DescriptionRoom( "+
					"      DescriptionBluetooth ( BluetoothAddress ( $address:string ) )"+
					"    | DigitalDocument ( [3] )"+
					"    )"+
					"  )"+
					// update screen
					"||BigraphSpaceScreen( "+
					"    DigitalDocument ( [3] )"+
					"  )"+
					"where $address:string");
			behaviourReactum.dump(System.out);
			behaviourRule.setReactum(behaviourReactum);
			
			behaviourRule.addRuleFiredListener(new RuleFiredListener() {

				//@Override
				public void ruleFired(RuleFiredEvent rfe, BigraphSession session) {
					List<Match> matches = rfe.getRedexMatches();
					for (Match match : matches) {
						logger.info("Match for behaviour: "+match.getVariableValues());
						((DomMatch)match).dump(System.out);
					}
					// TODO Auto-generated method stub
					session.getAll().dump(System.out);
				}
				
			});
			bigraph.addReactionRule(behaviourRule);
			
			
			logger.info("Creating display reaction");
			ReactionRule displayRule = new ReactionRule();
			RuleCondition displayCondition = new RuleCondition();
			Bigraph displayRedex = readBigraphTermLanguageString(sorting,
					"bigraph"+
					// a screen with a document with a filename...
					"  BigraphSpaceScreen( "+
					"    [1] "+
					"  | DigitalDocument ( Filename ( $filename:string ) )"+
					"  )"+
					"where $filename:string");
			//displayRedex.dump(System.out);
			displayCondition.setPattern(displayRedex);
			displayCondition.setMaxOccurs(RuleCondition.UNLIMITED);
			displayRule.setRedex(displayCondition);
			Bigraph displayReactum = readBigraphTermLanguageString(sorting,
					"bigraph"+
					// a screen with a document with a filename...
					"  BigraphSpaceScreen( "+
					"    [1] "+
					"  )"+
					"where $filename:string");
			displayRule.setReactum(displayReactum);
			
			// leave in place? 
			final JFrame frame = new JFrame("Display");
			final JEditorPane page = new JEditorPane();
			final JTextField text = new JTextField();
			
			text.setEditable(false);
			page.setEditable(false);
			JScrollPane sp = new JScrollPane(text);
			sp.setPreferredSize(new Dimension(600,500));
			JPanel p = new JPanel();
			p.setLayout(new BorderLayout());
			p.add(sp, BorderLayout.CENTER);
			p.add(text, BorderLayout.NORTH);
			frame.getContentPane().add(p);
			frame.pack();
			frame.setVisible(true);
			
			displayRule.addRuleFiredListener(new RuleFiredListener() {

				//@Override
				public void ruleFired(RuleFiredEvent rfe, BigraphSession session) {
					List<Match> matches = rfe.getRedexMatches();
					for (Match match : matches) {
						logger.info("Match for display: "+match.getVariableValues());
						text.setText("Filename: "+match.getVariableValues().get("filename")+" at "+(new Date()));
						try {
							page.setPage(match.getVariableValues().get("filename").toString());
						}
						catch (Exception e) {
							logger.error("loading "+match.getVariableValues().get("filename"), e);
							page.setText(e.toString());
						}
					}
				}
				
			});
			bigraph.addReactionRule(displayRule);
			
			
			logger.info("initialising bigraph state");
			final BigraphSession session = bigraph.getSession();
			session.begin();
			session.setAll(initialValue);
			session.end();
			
			System.out.println("Running...");
			BluetoothDiscover bt = new BluetoothDiscover()
			{
				synchronized public void updateDevices(String newDevices)
				{
					session.begin();
					logger.info("update BT with initial state:");
					session.getAll().dump(System.out);
					try {
						logger.info("Update Devices: " + newDevices);
						logger.info("Creating redex");
						Bigraph redex = readBigraphTermLanguageString(sorting,
								"bigraph BigraphSpaceBluetooth ( [1] )");
						/*new DomBigraph(initialValue.getSignature());
						Place root = redex.createRoot();
						redex.addRoot(root);
						Control controlBigraphSpaceBluetooth = signature.getControl("BigraphSpaceBluetooth");
						Place node = redex.createNode(controlBigraphSpaceBluetooth);
						root.addChild(node);
						Place site = redex.createSite();
						node.addChild(site);*/
						redex.dump(System.out);
						
						List<Match> matches = session.match(redex, 1);
						if (matches.size()==0) {
							logger.error("Bluetooth publisher could not find redex");
							redex.dump(System.out);
							System.out.println("========IN=========");
							session.getAll().dump(System.out);
							return;
						}
						// make reactum
						logger.info("Creating reactum");
						StringBuffer reactumBuf = new StringBuffer();
						reactumBuf.append("bigraph BigraphSpaceBluetooth ( ");
						StringTokenizer toks = new StringTokenizer(newDevices,",");
						boolean first = true;
						while(toks.hasMoreElements()) {
							String tok = toks.nextToken();
							if (first)
								first = false;
							else
								reactumBuf.append(" | ");
							reactumBuf.append("DescriptionBluetooth( BluetoothAddress ( \""+tok+"\":string ))");
						}
						reactumBuf.append(")");
						logger.info("reactum BTL: "+reactumBuf);
						Bigraph reactum = readBigraphTermLanguageString(sorting,reactumBuf.toString());
						/*new DomBigraph(initialValue.getSignature());
						root = reactum.createRoot();
						reactum.addRoot(root);
						Control controlDescriptionBluetooth = signature.getControl("DescriptionBluetooth");
						Control controlBluetoothAddress = signature.getControl("BluetoothAddress");
						Control controlString  = signature.getControl("string");
						node = reactum.createNode(controlBigraphSpaceBluetooth);
						root.addChild(node);
						StringTokenizer toks = new StringTokenizer(newDevices,",");
						while(toks.hasMoreElements()) {
							String tok = toks.nextToken();
							Place btnode = reactum.createNode(controlDescriptionBluetooth);
							node.addChild(btnode);
							Place btaddress = reactum.createNode(controlBluetoothAddress);
							btnode.addChild(btaddress);
							Place value = reactum.createNode(controlString);
							value.addControlIndex(reactum.createIndexValue(tok));
							btaddress.addChild(value);
						}
						reactum.dump(System.out);
						*/
						// replace
						logger.info("replace...");
						session.update(matches.get(0), reactum);
						session.end();
						session.begin();
						session.getAll().dump(System.out);
						session.end();
					}
					catch (Exception e) {
						logger.error("in updateDevices("+newDevices+")", e);
						session.abort();
					}
				}
			};
			bt.setConfigPollinterval(15);
			bt.setConfigured(true);
		}
		catch (Exception e)
		{
			logger.error("Main", e);
		}
	}
	static Sorting readSorting(String sigfile) throws IOException {
		// term lang
		try {
			BasicSignature sig = null;
			Sorting sorting = null;

			sorting = Sorting.readSorting(new File(sigfile));
			if (sorting!=null)
				sig = sorting.getSignature();
			else
				sig = SignatureFactory.readSignature(new File(sigfile));
			return sorting;
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (Exception e) {
			throw new IOException(e.getMessage(), e);
		}
	}
	static Bigraph readBigraphTermLanguageFile(Sorting sorting, String btlfile) throws IOException {
		// term lang
		try {
			BigraphTermLexer lex = new BigraphTermLexer(new ANTLRFileStream(btlfile));
			return readBigraphTermLanguage(sorting, lex);
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (Exception e) {
			throw new IOException(e.getMessage(), e);
		}
	}
	static Bigraph readBigraphTermLanguage(Sorting sorting, BigraphTermLexer lex) throws IOException {
		// term lang
		try {
			CommonTokenStream tokens = new CommonTokenStream(lex);

			BigraphTermParser parser = new BigraphTermParser(tokens);
			BigraphTermParser.start_return val = parser.start();
			System.out.println("-> "+val);
			Object tree = val.getTree();
			System.out.println("tree = "+(tree!=null ? tree.getClass().getName() : "")+" "+tree);
			if (tree instanceof CommonTree) {
				Document doc = BigraphTermUtils.toDocument((CommonTree)tree);
				BasicSignature sig = null;
				sig = sorting.getSignature();
				System.out.println("=== Bigraph Model ===");

				DomBigraph bigraph = new DomBigraph(sig, doc);
				//bigraph.dump(System.out);

				System.out.println("=== validate signature ===");
				sig.validate(bigraph);
				System.out.println("=== validate sorting ===");
				sorting.validate(bigraph);
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
	static Bigraph readBigraphTermLanguageString(Sorting sorting, String btlstring) throws IOException {
		// term lang
		try {
			BigraphTermLexer lex = new BigraphTermLexer(new ANTLRStringStream(btlstring));
			return readBigraphTermLanguage(sorting, lex);
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (Exception e) {
			throw new IOException(e.getMessage(), e);
		}
	}
	/*
	 * 
	 new DomBigraph(initialValue.getSignature());
Place root = behaviourRedex.createRoot();
behaviourRedex.addRoot(root);
Control controlBigraphSpaceBluetooth = signature.getControl("BigraphSpaceBluetooth");
Control controlDescriptionBluetooth = signature.getControl("DescriptionBluetooth");
Control controlBluetoothAddress = signature.getControl("BluetoothAddress");
Control controlString  = signature.getControl("string");
Place node = behaviourRedex.createNode(controlBigraphSpaceBluetooth);
root.addChild(node);
Place site = behaviourRedex.createSite();
node.addChild(site);
Place btnode = behaviourRedex.createNode(controlDescriptionBluetooth);
node.addChild(btnode);
Place btaddress = behaviourRedex.createNode(controlBluetoothAddress);
btnode.addChild(btaddress);
Place value = behaviourRedex.createNode(controlString);
value.addControlIndex(behaviourRedex.createIndexVariable("address"));
btaddress.addChild(value);
VariableDefinition addressVariable = behaviourRedex.createVariableDefinition("address", VariableType.string);
behaviourRedex.addVariable("address", addressVariable);
*/
}
