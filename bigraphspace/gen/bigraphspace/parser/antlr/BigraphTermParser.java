// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/BigraphTerm.g 2009-07-30 11:06:31
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class BigraphTermParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGRAPH", "RULE", "WHERE", "AND", "IN", "NOT", "LENGTH", "MATCHES", "EMPTY", "PORTS", "CHILDREN", "ROOT", "UNNAMED", "CONTROL", "NODE", "ONEOF", "NOTONEOF", "CONSTRAINT", "MINLENGTH", "MAXLENGTH", "MINVALUE", "MAXVALUE", "REGEXP", "ARROW", "PIPE2", "LSQUARE", "NUMBER", "RSQUARE", "PIPE", "COLON", "IDENTIFIER", "LANGLE", "COMMA", "RANGLE", "STRING", "LBRACE", "RBRACE", "EQUALS", "LPAREN", "RPAREN", "LESSTHANOREQUAL", "GREATERTHANOREQUAL", "PLUS", "MINUS", "UNDERSCORE", "SLASH", "DOLLAR", "DIGIT", "NUMERAL", "STRING_ESCAPE", "LETTER", "WHITESPACE", "LINECOMMENT"
    };
    public static final int DOLLAR=50;
    public static final int WHERE=6;
    public static final int LSQUARE=29;
    public static final int STRING_ESCAPE=53;
    public static final int CHILDREN=14;
    public static final int LETTER=54;
    public static final int LANGLE=35;
    public static final int LBRACE=39;
    public static final int EQUALS=41;
    public static final int NOT=9;
    public static final int LINECOMMENT=56;
    public static final int BIGRAPH=4;
    public static final int AND=7;
    public static final int EOF=-1;
    public static final int LENGTH=10;
    public static final int LPAREN=42;
    public static final int RPAREN=43;
    public static final int SLASH=49;
    public static final int IN=8;
    public static final int MINVALUE=24;
    public static final int MATCHES=11;
    public static final int MAXVALUE=25;
    public static final int COMMA=36;
    public static final int IDENTIFIER=34;
    public static final int LESSTHANOREQUAL=44;
    public static final int REGEXP=26;
    public static final int PLUS=46;
    public static final int PIPE=32;
    public static final int NOTONEOF=20;
    public static final int DIGIT=51;
    public static final int PIPE2=28;
    public static final int RANGLE=37;
    public static final int GREATERTHANOREQUAL=45;
    public static final int NODE=18;
    public static final int CONTROL=17;
    public static final int RULE=5;
    public static final int RBRACE=40;
    public static final int MINLENGTH=22;
    public static final int NUMBER=30;
    public static final int WHITESPACE=55;
    public static final int UNDERSCORE=48;
    public static final int MINUS=47;
    public static final int RSQUARE=31;
    public static final int ROOT=15;
    public static final int ONEOF=19;
    public static final int EMPTY=12;
    public static final int COLON=33;
    public static final int PORTS=13;
    public static final int UNNAMED=16;
    public static final int MAXLENGTH=23;
    public static final int ARROW=27;
    public static final int NUMERAL=52;
    public static final int CONSTRAINT=21;
    public static final int STRING=38;

    // delegates
    // delegators


        public BigraphTermParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BigraphTermParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return BigraphTermParser.tokenNames; }
    public String getGrammarFileName() { return "src/bigraphspace/parser/antlr/BigraphTerm.g"; }


    public static class start_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:41:1: start : ( BIGRAPH wide ( where )? EOF | RULE wide ARROW wide EOF );
    public final BigraphTermParser.start_return start() throws RecognitionException {
        BigraphTermParser.start_return retval = new BigraphTermParser.start_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BIGRAPH1=null;
        Token EOF4=null;
        Token RULE5=null;
        Token ARROW7=null;
        Token EOF9=null;
        BigraphTermParser.wide_return wide2 = null;

        BigraphTermParser.where_return where3 = null;

        BigraphTermParser.wide_return wide6 = null;

        BigraphTermParser.wide_return wide8 = null;


        Object BIGRAPH1_tree=null;
        Object EOF4_tree=null;
        Object RULE5_tree=null;
        Object ARROW7_tree=null;
        Object EOF9_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:42:1: ( BIGRAPH wide ( where )? EOF | RULE wide ARROW wide EOF )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==BIGRAPH) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:42:3: BIGRAPH wide ( where )? EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    BIGRAPH1=(Token)match(input,BIGRAPH,FOLLOW_BIGRAPH_in_start236); 
                    BIGRAPH1_tree = (Object)adaptor.create(BIGRAPH1);
                    root_0 = (Object)adaptor.becomeRoot(BIGRAPH1_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start239);
                    wide2=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide2.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:42:17: ( where )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==WHERE) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:42:17: where
                            {
                            pushFollow(FOLLOW_where_in_start241);
                            where3=where();

                            state._fsp--;

                            adaptor.addChild(root_0, where3.getTree());

                            }
                            break;

                    }

                    EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_start244); 
                    EOF4_tree = (Object)adaptor.create(EOF4);
                    adaptor.addChild(root_0, EOF4_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:43:3: RULE wide ARROW wide EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    RULE5=(Token)match(input,RULE,FOLLOW_RULE_in_start248); 
                    RULE5_tree = (Object)adaptor.create(RULE5);
                    root_0 = (Object)adaptor.becomeRoot(RULE5_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start251);
                    wide6=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide6.getTree());
                    ARROW7=(Token)match(input,ARROW,FOLLOW_ARROW_in_start253); 
                    pushFollow(FOLLOW_wide_in_start256);
                    wide8=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide8.getTree());
                    EOF9=(Token)match(input,EOF,FOLLOW_EOF_in_start258); 
                    EOF9_tree = (Object)adaptor.create(EOF9);
                    adaptor.addChild(root_0, EOF9_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "start"

    public static class wide_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "wide"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:46:1: wide : wide1 ( PIPE2 wide1 )* -> ( wide1 )+ ;
    public final BigraphTermParser.wide_return wide() throws RecognitionException {
        BigraphTermParser.wide_return retval = new BigraphTermParser.wide_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PIPE211=null;
        BigraphTermParser.wide1_return wide110 = null;

        BigraphTermParser.wide1_return wide112 = null;


        Object PIPE211_tree=null;
        RewriteRuleTokenStream stream_PIPE2=new RewriteRuleTokenStream(adaptor,"token PIPE2");
        RewriteRuleSubtreeStream stream_wide1=new RewriteRuleSubtreeStream(adaptor,"rule wide1");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:47:1: ( wide1 ( PIPE2 wide1 )* -> ( wide1 )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:47:3: wide1 ( PIPE2 wide1 )*
            {
            pushFollow(FOLLOW_wide1_in_wide271);
            wide110=wide1();

            state._fsp--;

            stream_wide1.add(wide110.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:47:9: ( PIPE2 wide1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==PIPE2) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:47:11: PIPE2 wide1
            	    {
            	    PIPE211=(Token)match(input,PIPE2,FOLLOW_PIPE2_in_wide275);  
            	    stream_PIPE2.add(PIPE211);

            	    pushFollow(FOLLOW_wide1_in_wide277);
            	    wide112=wide1();

            	    state._fsp--;

            	    stream_wide1.add(wide112.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);



            // AST REWRITE
            // elements: wide1
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 47:26: -> ( wide1 )+
            {
                if ( !(stream_wide1.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_wide1.hasNext() ) {
                    adaptor.addChild(root_0, stream_wide1.nextTree());

                }
                stream_wide1.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "wide"

    public static class wide1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "wide1"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:50:1: wide1 : prime -> ^( ROOT prime ) ;
    public final BigraphTermParser.wide1_return wide1() throws RecognitionException {
        BigraphTermParser.wide1_return retval = new BigraphTermParser.wide1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        BigraphTermParser.prime_return prime13 = null;


        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:51:1: ( prime -> ^( ROOT prime ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:51:3: prime
            {
            pushFollow(FOLLOW_prime_in_wide1294);
            prime13=prime();

            state._fsp--;

            stream_prime.add(prime13.getTree());


            // AST REWRITE
            // elements: prime
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 51:9: -> ^( ROOT prime )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:51:12: ^( ROOT prime )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT, "ROOT"), root_1);

                adaptor.addChild(root_1, stream_prime.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "wide1"

    public static class prime_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prime"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:54:1: prime : ( -> ^( EMPTY ) | LSQUARE ( NUMBER )? RSQUARE -> ^( UNDERSCORE ( NUMBER )? ) | node ( PIPE node )* -> ( node )+ );
    public final BigraphTermParser.prime_return prime() throws RecognitionException {
        BigraphTermParser.prime_return retval = new BigraphTermParser.prime_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LSQUARE14=null;
        Token NUMBER15=null;
        Token RSQUARE16=null;
        Token PIPE18=null;
        BigraphTermParser.node_return node17 = null;

        BigraphTermParser.node_return node19 = null;


        Object LSQUARE14_tree=null;
        Object NUMBER15_tree=null;
        Object RSQUARE16_tree=null;
        Object PIPE18_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
        RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleSubtreeStream stream_node=new RewriteRuleSubtreeStream(adaptor,"rule node");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:55:1: ( -> ^( EMPTY ) | LSQUARE ( NUMBER )? RSQUARE -> ^( UNDERSCORE ( NUMBER )? ) | node ( PIPE node )* -> ( node )+ )
            int alt6=3;
            switch ( input.LA(1) ) {
            case EOF:
            case WHERE:
            case ARROW:
            case PIPE2:
            case RPAREN:
                {
                alt6=1;
                }
                break;
            case LSQUARE:
                {
                alt6=2;
                }
                break;
            case NUMBER:
            case IDENTIFIER:
            case STRING:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:55:3: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 55:3: -> ^( EMPTY )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:55:6: ^( EMPTY )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EMPTY, "EMPTY"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:56:3: LSQUARE ( NUMBER )? RSQUARE
                    {
                    LSQUARE14=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_prime323);  
                    stream_LSQUARE.add(LSQUARE14);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:56:11: ( NUMBER )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==NUMBER) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:56:11: NUMBER
                            {
                            NUMBER15=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_prime325);  
                            stream_NUMBER.add(NUMBER15);


                            }
                            break;

                    }

                    RSQUARE16=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_prime328);  
                    stream_RSQUARE.add(RSQUARE16);



                    // AST REWRITE
                    // elements: NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 56:27: -> ^( UNDERSCORE ( NUMBER )? )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:56:30: ^( UNDERSCORE ( NUMBER )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNDERSCORE, "UNDERSCORE"), root_1);

                        // src/bigraphspace/parser/antlr/BigraphTerm.g:56:44: ( NUMBER )?
                        if ( stream_NUMBER.hasNext() ) {
                            adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        }
                        stream_NUMBER.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:57:3: node ( PIPE node )*
                    {
                    pushFollow(FOLLOW_node_in_prime343);
                    node17=node();

                    state._fsp--;

                    stream_node.add(node17.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:57:8: ( PIPE node )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==PIPE) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:57:10: PIPE node
                    	    {
                    	    PIPE18=(Token)match(input,PIPE,FOLLOW_PIPE_in_prime347);  
                    	    stream_PIPE.add(PIPE18);

                    	    pushFollow(FOLLOW_node_in_prime349);
                    	    node19=node();

                    	    state._fsp--;

                    	    stream_node.add(node19.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: node
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 57:23: -> ( node )+
                    {
                        if ( !(stream_node.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_node.hasNext() ) {
                            adaptor.addChild(root_0, stream_node.nextTree());

                        }
                        stream_node.reset();

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prime"

    public static class node_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "node"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:61:1: node : control ( ports )? ( children )? -> ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) ;
    public final BigraphTermParser.node_return node() throws RecognitionException {
        BigraphTermParser.node_return retval = new BigraphTermParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        BigraphTermParser.control_return control20 = null;

        BigraphTermParser.ports_return ports21 = null;

        BigraphTermParser.children_return children22 = null;


        RewriteRuleSubtreeStream stream_control=new RewriteRuleSubtreeStream(adaptor,"rule control");
        RewriteRuleSubtreeStream stream_ports=new RewriteRuleSubtreeStream(adaptor,"rule ports");
        RewriteRuleSubtreeStream stream_children=new RewriteRuleSubtreeStream(adaptor,"rule children");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:1: ( control ( ports )? ( children )? -> ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:3: control ( ports )? ( children )?
            {
            pushFollow(FOLLOW_control_in_node369);
            control20=control();

            state._fsp--;

            stream_control.add(control20.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:11: ( ports )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBRACE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:11: ports
                    {
                    pushFollow(FOLLOW_ports_in_node371);
                    ports21=ports();

                    state._fsp--;

                    stream_ports.add(ports21.getTree());

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:18: ( children )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LPAREN) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:18: children
                    {
                    pushFollow(FOLLOW_children_in_node374);
                    children22=children();

                    state._fsp--;

                    stream_children.add(children22.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: control, ports, children
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 62:28: -> ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:62:31: ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NODE, "NODE"), root_1);

                adaptor.addChild(root_1, stream_control.nextTree());
                // src/bigraphspace/parser/antlr/BigraphTerm.g:62:47: ^( PORTS ( ports )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(PORTS, "PORTS"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:62:56: ( ports )?
                if ( stream_ports.hasNext() ) {
                    adaptor.addChild(root_2, stream_ports.nextTree());

                }
                stream_ports.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/bigraphspace/parser/antlr/BigraphTerm.g:62:65: ^( CHILDREN ( children )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CHILDREN, "CHILDREN"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:62:77: ( children )?
                if ( stream_children.hasNext() ) {
                    adaptor.addChild(root_2, stream_children.nextTree());

                }
                stream_children.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "node"

    public static class control_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "control"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:65:1: control : ( tuple COLON type -> ^( CONTROL type tuple ) | IDENTIFIER ( indexes )? -> ^( CONTROL IDENTIFIER ( indexes )? ) );
    public final BigraphTermParser.control_return control() throws RecognitionException {
        BigraphTermParser.control_return retval = new BigraphTermParser.control_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON24=null;
        Token IDENTIFIER26=null;
        BigraphTermParser.tuple_return tuple23 = null;

        BigraphTermParser.type_return type25 = null;

        BigraphTermParser.indexes_return indexes27 = null;


        Object COLON24_tree=null;
        Object IDENTIFIER26_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_tuple=new RewriteRuleSubtreeStream(adaptor,"rule tuple");
        RewriteRuleSubtreeStream stream_indexes=new RewriteRuleSubtreeStream(adaptor,"rule indexes");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:66:1: ( tuple COLON type -> ^( CONTROL type tuple ) | IDENTIFIER ( indexes )? -> ^( CONTROL IDENTIFIER ( indexes )? ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENTIFIER) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==COLON||LA10_1==COMMA) ) {
                    alt10=1;
                }
                else if ( (LA10_1==EOF||LA10_1==WHERE||(LA10_1>=ARROW && LA10_1<=PIPE2)||LA10_1==PIPE||LA10_1==LANGLE||LA10_1==LBRACE||(LA10_1>=LPAREN && LA10_1<=RPAREN)) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==NUMBER||LA10_0==STRING) ) {
                alt10=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:66:3: tuple COLON type
                    {
                    pushFollow(FOLLOW_tuple_in_control412);
                    tuple23=tuple();

                    state._fsp--;

                    stream_tuple.add(tuple23.getTree());
                    COLON24=(Token)match(input,COLON,FOLLOW_COLON_in_control414);  
                    stream_COLON.add(COLON24);

                    pushFollow(FOLLOW_type_in_control416);
                    type25=type();

                    state._fsp--;

                    stream_type.add(type25.getTree());


                    // AST REWRITE
                    // elements: tuple, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 66:20: -> ^( CONTROL type tuple )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:66:23: ^( CONTROL type tuple )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTROL, "CONTROL"), root_1);

                        adaptor.addChild(root_1, stream_type.nextTree());
                        adaptor.addChild(root_1, stream_tuple.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:67:3: IDENTIFIER ( indexes )?
                    {
                    IDENTIFIER26=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_control432);  
                    stream_IDENTIFIER.add(IDENTIFIER26);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:67:14: ( indexes )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==LANGLE) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:14: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_control434);
                            indexes27=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes27.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: IDENTIFIER, indexes
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 67:23: -> ^( CONTROL IDENTIFIER ( indexes )? )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:67:26: ^( CONTROL IDENTIFIER ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTROL, "CONTROL"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:67:48: ( indexes )?
                        if ( stream_indexes.hasNext() ) {
                            adaptor.addChild(root_1, stream_indexes.nextTree());

                        }
                        stream_indexes.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "control"

    public static class indexes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indexes"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:70:1: indexes : LANGLE ( index ( COMMA index )* )? RANGLE -> ( index )* ;
    public final BigraphTermParser.indexes_return indexes() throws RecognitionException {
        BigraphTermParser.indexes_return retval = new BigraphTermParser.indexes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LANGLE28=null;
        Token COMMA30=null;
        Token RANGLE32=null;
        BigraphTermParser.index_return index29 = null;

        BigraphTermParser.index_return index31 = null;


        Object LANGLE28_tree=null;
        Object COMMA30_tree=null;
        Object RANGLE32_tree=null;
        RewriteRuleTokenStream stream_RANGLE=new RewriteRuleTokenStream(adaptor,"token RANGLE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LANGLE=new RewriteRuleTokenStream(adaptor,"token LANGLE");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:1: ( LANGLE ( index ( COMMA index )* )? RANGLE -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:3: LANGLE ( index ( COMMA index )* )? RANGLE
            {
            LANGLE28=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_indexes457);  
            stream_LANGLE.add(LANGLE28);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:10: ( index ( COMMA index )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NUMBER||LA12_0==IDENTIFIER||LA12_0==STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:71:12: index ( COMMA index )*
                    {
                    pushFollow(FOLLOW_index_in_indexes461);
                    index29=index();

                    state._fsp--;

                    stream_index.add(index29.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:71:18: ( COMMA index )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==COMMA) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:71:20: COMMA index
                    	    {
                    	    COMMA30=(Token)match(input,COMMA,FOLLOW_COMMA_in_indexes465);  
                    	    stream_COMMA.add(COMMA30);

                    	    pushFollow(FOLLOW_index_in_indexes467);
                    	    index31=index();

                    	    state._fsp--;

                    	    stream_index.add(index31.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            RANGLE32=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_indexes475);  
            stream_RANGLE.add(RANGLE32);



            // AST REWRITE
            // elements: index
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 71:45: -> ( index )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:71:48: ( index )*
                while ( stream_index.hasNext() ) {
                    adaptor.addChild(root_0, stream_index.nextTree());

                }
                stream_index.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "indexes"

    public static class index_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "index"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:76:1: index : ( NUMBER | STRING | IDENTIFIER );
    public final BigraphTermParser.index_return index() throws RecognitionException {
        BigraphTermParser.index_return retval = new BigraphTermParser.index_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set33=null;

        Object set33_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:77:1: ( NUMBER | STRING | IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set33=(Token)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==IDENTIFIER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set33));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "index"

    public static class tuple_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tuple"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:82:1: tuple : index ( COMMA index )* -> ( index )* ;
    public final BigraphTermParser.tuple_return tuple() throws RecognitionException {
        BigraphTermParser.tuple_return retval = new BigraphTermParser.tuple_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA35=null;
        BigraphTermParser.index_return index34 = null;

        BigraphTermParser.index_return index36 = null;


        Object COMMA35_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:83:1: ( index ( COMMA index )* -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:83:3: index ( COMMA index )*
            {
            pushFollow(FOLLOW_index_in_tuple513);
            index34=index();

            state._fsp--;

            stream_index.add(index34.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:83:9: ( COMMA index )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:83:11: COMMA index
            	    {
            	    COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_tuple517);  
            	    stream_COMMA.add(COMMA35);

            	    pushFollow(FOLLOW_index_in_tuple519);
            	    index36=index();

            	    state._fsp--;

            	    stream_index.add(index36.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);



            // AST REWRITE
            // elements: index
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 83:26: -> ( index )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:83:29: ( index )*
                while ( stream_index.hasNext() ) {
                    adaptor.addChild(root_0, stream_index.nextTree());

                }
                stream_index.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tuple"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:87:1: type : IDENTIFIER -> IDENTIFIER ;
    public final BigraphTermParser.type_return type() throws RecognitionException {
        BigraphTermParser.type_return retval = new BigraphTermParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER37=null;

        Object IDENTIFIER37_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:88:1: ( IDENTIFIER -> IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:88:3: IDENTIFIER
            {
            IDENTIFIER37=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type538);  
            stream_IDENTIFIER.add(IDENTIFIER37);



            // AST REWRITE
            // elements: IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 88:14: -> IDENTIFIER
            {
                adaptor.addChild(root_0, stream_IDENTIFIER.nextNode());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class ports_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ports"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:91:1: ports : LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* ;
    public final BigraphTermParser.ports_return ports() throws RecognitionException {
        BigraphTermParser.ports_return retval = new BigraphTermParser.ports_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACE38=null;
        Token COMMA40=null;
        Token RBRACE42=null;
        BigraphTermParser.port_value_return port_value39 = null;

        BigraphTermParser.port_value_return port_value41 = null;


        Object LBRACE38_tree=null;
        Object COMMA40_tree=null;
        Object RBRACE42_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_port_value=new RewriteRuleSubtreeStream(adaptor,"rule port_value");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:92:1: ( LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:92:3: LBRACE ( port_value ( COMMA port_value )* )? RBRACE
            {
            LBRACE38=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_ports551);  
            stream_LBRACE.add(LBRACE38);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:92:10: ( port_value ( COMMA port_value )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NUMBER||LA15_0==IDENTIFIER||LA15_0==STRING) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:92:12: port_value ( COMMA port_value )*
                    {
                    pushFollow(FOLLOW_port_value_in_ports555);
                    port_value39=port_value();

                    state._fsp--;

                    stream_port_value.add(port_value39.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:92:23: ( COMMA port_value )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:92:25: COMMA port_value
                    	    {
                    	    COMMA40=(Token)match(input,COMMA,FOLLOW_COMMA_in_ports559);  
                    	    stream_COMMA.add(COMMA40);

                    	    pushFollow(FOLLOW_port_value_in_ports561);
                    	    port_value41=port_value();

                    	    state._fsp--;

                    	    stream_port_value.add(port_value41.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACE42=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_ports569);  
            stream_RBRACE.add(RBRACE42);



            // AST REWRITE
            // elements: port_value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 92:55: -> ( port_value )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:92:58: ( port_value )*
                while ( stream_port_value.hasNext() ) {
                    adaptor.addChild(root_0, stream_port_value.nextTree());

                }
                stream_port_value.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ports"

    public static class port_value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "port_value"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:95:1: port_value : ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) );
    public final BigraphTermParser.port_value_return port_value() throws RecognitionException {
        BigraphTermParser.port_value_return retval = new BigraphTermParser.port_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER43=null;
        Token EQUALS44=null;
        BigraphTermParser.link_name_return link_name45 = null;

        BigraphTermParser.link_name_return link_name46 = null;


        Object IDENTIFIER43_tree=null;
        Object EQUALS44_tree=null;
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:96:1: ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENTIFIER) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==EQUALS) ) {
                    alt16=1;
                }
                else if ( (LA16_1==COMMA||LA16_1==RBRACE) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA16_0==NUMBER||LA16_0==STRING) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:96:3: IDENTIFIER EQUALS link_name
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER43=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_port_value583); 
                    IDENTIFIER43_tree = (Object)adaptor.create(IDENTIFIER43);
                    root_0 = (Object)adaptor.becomeRoot(IDENTIFIER43_tree, root_0);

                    EQUALS44=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_port_value586); 
                    pushFollow(FOLLOW_link_name_in_port_value589);
                    link_name45=link_name();

                    state._fsp--;

                    adaptor.addChild(root_0, link_name45.getTree());

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:97:3: link_name
                    {
                    pushFollow(FOLLOW_link_name_in_port_value593);
                    link_name46=link_name();

                    state._fsp--;

                    stream_link_name.add(link_name46.getTree());


                    // AST REWRITE
                    // elements: link_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 97:13: -> ^( UNNAMED link_name )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:97:16: ^( UNNAMED link_name )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNNAMED, "UNNAMED"), root_1);

                        adaptor.addChild(root_1, stream_link_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "port_value"

    public static class link_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "link_name"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:100:1: link_name : ( IDENTIFIER | constant );
    public final BigraphTermParser.link_name_return link_name() throws RecognitionException {
        BigraphTermParser.link_name_return retval = new BigraphTermParser.link_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER47=null;
        BigraphTermParser.constant_return constant48 = null;


        Object IDENTIFIER47_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:101:1: ( IDENTIFIER | constant )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENTIFIER) ) {
                alt17=1;
            }
            else if ( (LA17_0==NUMBER||LA17_0==STRING) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:101:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER47=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_link_name612); 
                    IDENTIFIER47_tree = (Object)adaptor.create(IDENTIFIER47);
                    adaptor.addChild(root_0, IDENTIFIER47_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:102:3: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_link_name616);
                    constant48=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant48.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "link_name"

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:105:1: constant : ( NUMBER | STRING );
    public final BigraphTermParser.constant_return constant() throws RecognitionException {
        BigraphTermParser.constant_return retval = new BigraphTermParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set49=null;

        Object set49_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:106:1: ( NUMBER | STRING )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set49=(Token)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set49));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constant"

    public static class children_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "children"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:110:1: children : LPAREN prime RPAREN -> prime ;
    public final BigraphTermParser.children_return children() throws RecognitionException {
        BigraphTermParser.children_return retval = new BigraphTermParser.children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN50=null;
        Token RPAREN52=null;
        BigraphTermParser.prime_return prime51 = null;


        Object LPAREN50_tree=null;
        Object RPAREN52_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:111:1: ( LPAREN prime RPAREN -> prime )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:111:3: LPAREN prime RPAREN
            {
            LPAREN50=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_children638);  
            stream_LPAREN.add(LPAREN50);

            pushFollow(FOLLOW_prime_in_children640);
            prime51=prime();

            state._fsp--;

            stream_prime.add(prime51.getTree());
            RPAREN52=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_children642);  
            stream_RPAREN.add(RPAREN52);



            // AST REWRITE
            // elements: prime
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 111:23: -> prime
            {
                adaptor.addChild(root_0, stream_prime.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "children"

    public static class where_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:114:1: where : WHERE whereclause ( AND whereclause )* -> ^( WHERE ( whereclause )+ ) ;
    public final BigraphTermParser.where_return where() throws RecognitionException {
        BigraphTermParser.where_return retval = new BigraphTermParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE53=null;
        Token AND55=null;
        BigraphTermParser.whereclause_return whereclause54 = null;

        BigraphTermParser.whereclause_return whereclause56 = null;


        Object WHERE53_tree=null;
        Object AND55_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_whereclause=new RewriteRuleSubtreeStream(adaptor,"rule whereclause");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:115:1: ( WHERE whereclause ( AND whereclause )* -> ^( WHERE ( whereclause )+ ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:115:3: WHERE whereclause ( AND whereclause )*
            {
            WHERE53=(Token)match(input,WHERE,FOLLOW_WHERE_in_where655);  
            stream_WHERE.add(WHERE53);

            pushFollow(FOLLOW_whereclause_in_where657);
            whereclause54=whereclause();

            state._fsp--;

            stream_whereclause.add(whereclause54.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:115:21: ( AND whereclause )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==AND) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:115:23: AND whereclause
            	    {
            	    AND55=(Token)match(input,AND,FOLLOW_AND_in_where661);  
            	    stream_AND.add(AND55);

            	    pushFollow(FOLLOW_whereclause_in_where663);
            	    whereclause56=whereclause();

            	    state._fsp--;

            	    stream_whereclause.add(whereclause56.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);



            // AST REWRITE
            // elements: whereclause, WHERE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 115:42: -> ^( WHERE ( whereclause )+ )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:115:45: ^( WHERE ( whereclause )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_WHERE.nextNode(), root_1);

                if ( !(stream_whereclause.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_whereclause.hasNext() ) {
                    adaptor.addChild(root_1, stream_whereclause.nextTree());

                }
                stream_whereclause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "where"

    public static class whereclause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whereclause"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:118:1: whereclause : ( IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type ) | IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* ) | IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* ) | IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER ) | IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER ) | IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING ) | i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER ) | i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER ) );
    public final BigraphTermParser.whereclause_return whereclause() throws RecognitionException {
        BigraphTermParser.whereclause_return retval = new BigraphTermParser.whereclause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token j=null;
        Token IDENTIFIER57=null;
        Token COLON58=null;
        Token IDENTIFIER60=null;
        Token NOT61=null;
        Token IN62=null;
        Token LBRACE63=null;
        Token COMMA65=null;
        Token RBRACE67=null;
        Token IDENTIFIER68=null;
        Token IN69=null;
        Token LBRACE70=null;
        Token COMMA72=null;
        Token RBRACE74=null;
        Token IDENTIFIER75=null;
        Token LESSTHANOREQUAL76=null;
        Token NUMBER77=null;
        Token IDENTIFIER78=null;
        Token GREATERTHANOREQUAL79=null;
        Token NUMBER80=null;
        Token LENGTH81=null;
        Token LPAREN82=null;
        Token IDENTIFIER83=null;
        Token RPAREN84=null;
        Token LESSTHANOREQUAL85=null;
        Token NUMBER86=null;
        Token LENGTH87=null;
        Token LPAREN88=null;
        Token IDENTIFIER89=null;
        Token RPAREN90=null;
        Token GREATERTHANOREQUAL91=null;
        Token NUMBER92=null;
        Token IDENTIFIER93=null;
        Token MATCHES94=null;
        Token STRING95=null;
        Token EQUALS96=null;
        Token PLUS97=null;
        Token NUMBER98=null;
        Token EQUALS99=null;
        Token MINUS100=null;
        Token NUMBER101=null;
        BigraphTermParser.type_return type59 = null;

        BigraphTermParser.index_return index64 = null;

        BigraphTermParser.index_return index66 = null;

        BigraphTermParser.index_return index71 = null;

        BigraphTermParser.index_return index73 = null;


        Object i_tree=null;
        Object j_tree=null;
        Object IDENTIFIER57_tree=null;
        Object COLON58_tree=null;
        Object IDENTIFIER60_tree=null;
        Object NOT61_tree=null;
        Object IN62_tree=null;
        Object LBRACE63_tree=null;
        Object COMMA65_tree=null;
        Object RBRACE67_tree=null;
        Object IDENTIFIER68_tree=null;
        Object IN69_tree=null;
        Object LBRACE70_tree=null;
        Object COMMA72_tree=null;
        Object RBRACE74_tree=null;
        Object IDENTIFIER75_tree=null;
        Object LESSTHANOREQUAL76_tree=null;
        Object NUMBER77_tree=null;
        Object IDENTIFIER78_tree=null;
        Object GREATERTHANOREQUAL79_tree=null;
        Object NUMBER80_tree=null;
        Object LENGTH81_tree=null;
        Object LPAREN82_tree=null;
        Object IDENTIFIER83_tree=null;
        Object RPAREN84_tree=null;
        Object LESSTHANOREQUAL85_tree=null;
        Object NUMBER86_tree=null;
        Object LENGTH87_tree=null;
        Object LPAREN88_tree=null;
        Object IDENTIFIER89_tree=null;
        Object RPAREN90_tree=null;
        Object GREATERTHANOREQUAL91_tree=null;
        Object NUMBER92_tree=null;
        Object IDENTIFIER93_tree=null;
        Object MATCHES94_tree=null;
        Object STRING95_tree=null;
        Object EQUALS96_tree=null;
        Object PLUS97_tree=null;
        Object NUMBER98_tree=null;
        Object EQUALS99_tree=null;
        Object MINUS100_tree=null;
        Object NUMBER101_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_MATCHES=new RewriteRuleTokenStream(adaptor,"token MATCHES");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleTokenStream stream_LESSTHANOREQUAL=new RewriteRuleTokenStream(adaptor,"token LESSTHANOREQUAL");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_GREATERTHANOREQUAL=new RewriteRuleTokenStream(adaptor,"token GREATERTHANOREQUAL");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_LENGTH=new RewriteRuleTokenStream(adaptor,"token LENGTH");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:119:1: ( IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type ) | IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* ) | IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* ) | IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER ) | IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER ) | IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING ) | i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER ) | i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER ) )
            int alt23=10;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:119:3: IDENTIFIER COLON type
                    {
                    IDENTIFIER57=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause686);  
                    stream_IDENTIFIER.add(IDENTIFIER57);

                    COLON58=(Token)match(input,COLON,FOLLOW_COLON_in_whereclause688);  
                    stream_COLON.add(COLON58);

                    pushFollow(FOLLOW_type_in_whereclause690);
                    type59=type();

                    state._fsp--;

                    stream_type.add(type59.getTree());


                    // AST REWRITE
                    // elements: IDENTIFIER, type, COLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 119:25: -> ^( CONSTRAINT IDENTIFIER COLON type )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:119:28: ^( CONSTRAINT IDENTIFIER COLON type )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, stream_COLON.nextNode());
                        adaptor.addChild(root_1, stream_type.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:3: IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE
                    {
                    IDENTIFIER60=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause708);  
                    stream_IDENTIFIER.add(IDENTIFIER60);

                    NOT61=(Token)match(input,NOT,FOLLOW_NOT_in_whereclause710);  
                    stream_NOT.add(NOT61);

                    IN62=(Token)match(input,IN,FOLLOW_IN_in_whereclause712);  
                    stream_IN.add(IN62);

                    LBRACE63=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_whereclause714);  
                    stream_LBRACE.add(LBRACE63);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:28: ( index ( COMMA index )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==NUMBER||LA20_0==IDENTIFIER||LA20_0==STRING) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:30: index ( COMMA index )*
                            {
                            pushFollow(FOLLOW_index_in_whereclause718);
                            index64=index();

                            state._fsp--;

                            stream_index.add(index64.getTree());
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:36: ( COMMA index )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==COMMA) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:38: COMMA index
                            	    {
                            	    COMMA65=(Token)match(input,COMMA,FOLLOW_COMMA_in_whereclause722);  
                            	    stream_COMMA.add(COMMA65);

                            	    pushFollow(FOLLOW_index_in_whereclause724);
                            	    index66=index();

                            	    state._fsp--;

                            	    stream_index.add(index66.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RBRACE67=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_whereclause732);  
                    stream_RBRACE.add(RBRACE67);



                    // AST REWRITE
                    // elements: index, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 120:63: -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:120:66: ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(NOTONEOF, "NOTONEOF"));
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:120:100: ( index )*
                        while ( stream_index.hasNext() ) {
                            adaptor.addChild(root_1, stream_index.nextTree());

                        }
                        stream_index.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:121:3: IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE
                    {
                    IDENTIFIER68=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause751);  
                    stream_IDENTIFIER.add(IDENTIFIER68);

                    IN69=(Token)match(input,IN,FOLLOW_IN_in_whereclause753);  
                    stream_IN.add(IN69);

                    LBRACE70=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_whereclause755);  
                    stream_LBRACE.add(LBRACE70);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:121:24: ( index ( COMMA index )* )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==NUMBER||LA22_0==IDENTIFIER||LA22_0==STRING) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:121:26: index ( COMMA index )*
                            {
                            pushFollow(FOLLOW_index_in_whereclause759);
                            index71=index();

                            state._fsp--;

                            stream_index.add(index71.getTree());
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:121:32: ( COMMA index )*
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==COMMA) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:121:34: COMMA index
                            	    {
                            	    COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_whereclause763);  
                            	    stream_COMMA.add(COMMA72);

                            	    pushFollow(FOLLOW_index_in_whereclause765);
                            	    index73=index();

                            	    state._fsp--;

                            	    stream_index.add(index73.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop21;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RBRACE74=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_whereclause773);  
                    stream_RBRACE.add(RBRACE74);



                    // AST REWRITE
                    // elements: IDENTIFIER, index
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 121:59: -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:121:62: ^( CONSTRAINT IDENTIFIER ONEOF ( index )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(ONEOF, "ONEOF"));
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:121:93: ( index )*
                        while ( stream_index.hasNext() ) {
                            adaptor.addChild(root_1, stream_index.nextTree());

                        }
                        stream_index.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:122:3: IDENTIFIER LESSTHANOREQUAL NUMBER
                    {
                    IDENTIFIER75=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause792);  
                    stream_IDENTIFIER.add(IDENTIFIER75);

                    LESSTHANOREQUAL76=(Token)match(input,LESSTHANOREQUAL,FOLLOW_LESSTHANOREQUAL_in_whereclause794);  
                    stream_LESSTHANOREQUAL.add(LESSTHANOREQUAL76);

                    NUMBER77=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause796);  
                    stream_NUMBER.add(NUMBER77);



                    // AST REWRITE
                    // elements: IDENTIFIER, NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 122:37: -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:122:40: ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(MAXVALUE, "MAXVALUE"));
                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:123:3: IDENTIFIER GREATERTHANOREQUAL NUMBER
                    {
                    IDENTIFIER78=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause814);  
                    stream_IDENTIFIER.add(IDENTIFIER78);

                    GREATERTHANOREQUAL79=(Token)match(input,GREATERTHANOREQUAL,FOLLOW_GREATERTHANOREQUAL_in_whereclause816);  
                    stream_GREATERTHANOREQUAL.add(GREATERTHANOREQUAL79);

                    NUMBER80=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause818);  
                    stream_NUMBER.add(NUMBER80);



                    // AST REWRITE
                    // elements: NUMBER, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 123:40: -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:123:43: ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(MINVALUE, "MINVALUE"));
                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:124:3: LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER
                    {
                    LENGTH81=(Token)match(input,LENGTH,FOLLOW_LENGTH_in_whereclause836);  
                    stream_LENGTH.add(LENGTH81);

                    LPAREN82=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whereclause838);  
                    stream_LPAREN.add(LPAREN82);

                    IDENTIFIER83=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause840);  
                    stream_IDENTIFIER.add(IDENTIFIER83);

                    RPAREN84=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whereclause842);  
                    stream_RPAREN.add(RPAREN84);

                    LESSTHANOREQUAL85=(Token)match(input,LESSTHANOREQUAL,FOLLOW_LESSTHANOREQUAL_in_whereclause844);  
                    stream_LESSTHANOREQUAL.add(LESSTHANOREQUAL85);

                    NUMBER86=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause846);  
                    stream_NUMBER.add(NUMBER86);



                    // AST REWRITE
                    // elements: NUMBER, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 124:58: -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:124:61: ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(MAXLENGTH, "MAXLENGTH"));
                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:125:3: LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER
                    {
                    LENGTH87=(Token)match(input,LENGTH,FOLLOW_LENGTH_in_whereclause864);  
                    stream_LENGTH.add(LENGTH87);

                    LPAREN88=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whereclause866);  
                    stream_LPAREN.add(LPAREN88);

                    IDENTIFIER89=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause868);  
                    stream_IDENTIFIER.add(IDENTIFIER89);

                    RPAREN90=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whereclause870);  
                    stream_RPAREN.add(RPAREN90);

                    GREATERTHANOREQUAL91=(Token)match(input,GREATERTHANOREQUAL,FOLLOW_GREATERTHANOREQUAL_in_whereclause872);  
                    stream_GREATERTHANOREQUAL.add(GREATERTHANOREQUAL91);

                    NUMBER92=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause874);  
                    stream_NUMBER.add(NUMBER92);



                    // AST REWRITE
                    // elements: NUMBER, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 125:61: -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:125:64: ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(MINLENGTH, "MINLENGTH"));
                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 8 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:126:3: IDENTIFIER MATCHES STRING
                    {
                    IDENTIFIER93=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause892);  
                    stream_IDENTIFIER.add(IDENTIFIER93);

                    MATCHES94=(Token)match(input,MATCHES,FOLLOW_MATCHES_in_whereclause894);  
                    stream_MATCHES.add(MATCHES94);

                    STRING95=(Token)match(input,STRING,FOLLOW_STRING_in_whereclause896);  
                    stream_STRING.add(STRING95);



                    // AST REWRITE
                    // elements: IDENTIFIER, STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 126:29: -> ^( CONSTRAINT IDENTIFIER REGEXP STRING )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:126:32: ^( CONSTRAINT IDENTIFIER REGEXP STRING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(REGEXP, "REGEXP"));
                        adaptor.addChild(root_1, stream_STRING.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 9 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:127:3: i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER
                    {
                    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause916);  
                    stream_IDENTIFIER.add(i);

                    EQUALS96=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_whereclause918);  
                    stream_EQUALS.add(EQUALS96);

                    j=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause922);  
                    stream_IDENTIFIER.add(j);

                    PLUS97=(Token)match(input,PLUS,FOLLOW_PLUS_in_whereclause924);  
                    stream_PLUS.add(PLUS97);

                    NUMBER98=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause926);  
                    stream_NUMBER.add(NUMBER98);



                    // AST REWRITE
                    // elements: i, j, NUMBER, PLUS
                    // token labels: j, i
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_j=new RewriteRuleTokenStream(adaptor,"token j",j);
                    RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 127:48: -> ^( CONSTRAINT $i PLUS $j NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:127:51: ^( CONSTRAINT $i PLUS $j NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_i.nextNode());
                        adaptor.addChild(root_1, stream_PLUS.nextNode());
                        adaptor.addChild(root_1, stream_j.nextNode());
                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 10 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:128:3: i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER
                    {
                    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause950);  
                    stream_IDENTIFIER.add(i);

                    EQUALS99=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_whereclause952);  
                    stream_EQUALS.add(EQUALS99);

                    j=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause956);  
                    stream_IDENTIFIER.add(j);

                    MINUS100=(Token)match(input,MINUS,FOLLOW_MINUS_in_whereclause958);  
                    stream_MINUS.add(MINUS100);

                    NUMBER101=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause960);  
                    stream_NUMBER.add(NUMBER101);



                    // AST REWRITE
                    // elements: j, NUMBER, i, MINUS
                    // token labels: j, i
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_j=new RewriteRuleTokenStream(adaptor,"token j",j);
                    RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 128:49: -> ^( CONSTRAINT $i MINUS $j NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:128:52: ^( CONSTRAINT $i MINUS $j NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_i.nextNode());
                        adaptor.addChild(root_1, stream_MINUS.nextNode());
                        adaptor.addChild(root_1, stream_j.nextNode());
                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whereclause"

    // Delegated rules


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\22\uffff";
    static final String DFA23_eofS =
        "\22\uffff";
    static final String DFA23_minS =
        "\1\12\1\10\1\52\6\uffff\2\42\1\56\1\53\2\uffff\1\54\2\uffff";
    static final String DFA23_maxS =
        "\1\42\1\55\1\52\6\uffff\2\42\1\57\1\53\2\uffff\1\55\2\uffff";
    static final String DFA23_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\10\4\uffff\1\11\1\12\1\uffff\1\6"+
        "\1\7";
    static final String DFA23_specialS =
        "\22\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\2\27\uffff\1\1",
            "\1\5\1\4\1\uffff\1\10\25\uffff\1\3\7\uffff\1\11\2\uffff\1"+
            "\6\1\7",
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\14",
            "\1\15\1\16",
            "\1\17",
            "",
            "",
            "\1\20\1\21",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "118:1: whereclause : ( IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type ) | IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* ) | IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* ) | IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER ) | IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER ) | IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING ) | i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER ) | i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER ) );";
        }
    }
 

    public static final BitSet FOLLOW_BIGRAPH_in_start236 = new BitSet(new long[]{0x0000004460000000L});
    public static final BitSet FOLLOW_wide_in_start239 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_in_start241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_start248 = new BitSet(new long[]{0x0000004460000000L});
    public static final BitSet FOLLOW_wide_in_start251 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ARROW_in_start253 = new BitSet(new long[]{0x0000004460000000L});
    public static final BitSet FOLLOW_wide_in_start256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wide1_in_wide271 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_PIPE2_in_wide275 = new BitSet(new long[]{0x0000004460000000L});
    public static final BitSet FOLLOW_wide1_in_wide277 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_prime_in_wide1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_prime323 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_NUMBER_in_prime325 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RSQUARE_in_prime328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_prime343 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_PIPE_in_prime347 = new BitSet(new long[]{0x0000004560000000L});
    public static final BitSet FOLLOW_node_in_prime349 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_control_in_node369 = new BitSet(new long[]{0x0000048000000002L});
    public static final BitSet FOLLOW_ports_in_node371 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_children_in_node374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_control412 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_control414 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_type_in_control416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_control432 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_indexes_in_control434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_indexes457 = new BitSet(new long[]{0x0000006440000000L});
    public static final BitSet FOLLOW_index_in_indexes461 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_COMMA_in_indexes465 = new BitSet(new long[]{0x0000004440000000L});
    public static final BitSet FOLLOW_index_in_indexes467 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_RANGLE_in_indexes475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_index0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_index_in_tuple513 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_COMMA_in_tuple517 = new BitSet(new long[]{0x0000004440000000L});
    public static final BitSet FOLLOW_index_in_tuple519 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_ports551 = new BitSet(new long[]{0x0000014440000000L});
    public static final BitSet FOLLOW_port_value_in_ports555 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_COMMA_in_ports559 = new BitSet(new long[]{0x0000004440000000L});
    public static final BitSet FOLLOW_port_value_in_ports561 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_RBRACE_in_ports569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_port_value583 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_EQUALS_in_port_value586 = new BitSet(new long[]{0x0000004440000000L});
    public static final BitSet FOLLOW_link_name_in_port_value589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_link_name_in_port_value593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_link_name612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_link_name616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_children638 = new BitSet(new long[]{0x0000084460000000L});
    public static final BitSet FOLLOW_prime_in_children640 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_children642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where655 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_whereclause_in_where657 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_AND_in_where661 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_whereclause_in_where663 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause686 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_whereclause688 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_type_in_whereclause690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause708 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NOT_in_whereclause710 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IN_in_whereclause712 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LBRACE_in_whereclause714 = new BitSet(new long[]{0x0000014440000000L});
    public static final BitSet FOLLOW_index_in_whereclause718 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_COMMA_in_whereclause722 = new BitSet(new long[]{0x0000004440000000L});
    public static final BitSet FOLLOW_index_in_whereclause724 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_RBRACE_in_whereclause732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause751 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IN_in_whereclause753 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LBRACE_in_whereclause755 = new BitSet(new long[]{0x0000014440000000L});
    public static final BitSet FOLLOW_index_in_whereclause759 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_COMMA_in_whereclause763 = new BitSet(new long[]{0x0000004440000000L});
    public static final BitSet FOLLOW_index_in_whereclause765 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_RBRACE_in_whereclause773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause792 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_LESSTHANOREQUAL_in_whereclause794 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause814 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GREATERTHANOREQUAL_in_whereclause816 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_in_whereclause836 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LPAREN_in_whereclause838 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause840 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_whereclause842 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_LESSTHANOREQUAL_in_whereclause844 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_in_whereclause864 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LPAREN_in_whereclause866 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause868 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_whereclause870 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GREATERTHANOREQUAL_in_whereclause872 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause892 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_MATCHES_in_whereclause894 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_STRING_in_whereclause896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause916 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_EQUALS_in_whereclause918 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause922 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PLUS_in_whereclause924 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause950 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_EQUALS_in_whereclause952 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause956 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_MINUS_in_whereclause958 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause960 = new BitSet(new long[]{0x0000000000000002L});

}