// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/BigraphTerm.g 2009-07-29 22:59:18
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class BigraphTermParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGRAPH", "RULE", "EMPTY", "PORTS", "CHILDREN", "ROOT", "UNNAMED", "CONTROL", "NODE", "ARROW", "PIPE2", "LSQUARE", "NUMERAL", "RSQUARE", "PIPE", "COLON", "IDENTIFIER", "LANGLE", "COMMA", "RANGLE", "STRING", "LBRACE", "RBRACE", "EQUALS", "NUMBER", "LPAREN", "RPAREN", "UNDERSCORE", "SLASH", "DIGIT", "STRING_ESCAPE", "LETTER", "WHITESPACE", "LINECOMMENT"
    };
    public static final int LSQUARE=15;
    public static final int STRING_ESCAPE=34;
    public static final int RBRACE=26;
    public static final int RULE=5;
    public static final int CONTROL=11;
    public static final int NODE=12;
    public static final int CHILDREN=8;
    public static final int LETTER=35;
    public static final int LANGLE=21;
    public static final int LBRACE=25;
    public static final int NUMBER=28;
    public static final int WHITESPACE=36;
    public static final int UNDERSCORE=31;
    public static final int EQUALS=27;
    public static final int LINECOMMENT=37;
    public static final int RSQUARE=17;
    public static final int BIGRAPH=4;
    public static final int EOF=-1;
    public static final int ROOT=9;
    public static final int LPAREN=29;
    public static final int EMPTY=6;
    public static final int COLON=19;
    public static final int RPAREN=30;
    public static final int SLASH=32;
    public static final int PORTS=7;
    public static final int COMMA=22;
    public static final int IDENTIFIER=20;
    public static final int UNNAMED=10;
    public static final int ARROW=13;
    public static final int NUMERAL=16;
    public static final int PIPE=18;
    public static final int DIGIT=33;
    public static final int RANGLE=23;
    public static final int PIPE2=14;
    public static final int STRING=24;

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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:25:1: start : ( BIGRAPH wide EOF | RULE wide ARROW wide EOF );
    public final BigraphTermParser.start_return start() throws RecognitionException {
        BigraphTermParser.start_return retval = new BigraphTermParser.start_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BIGRAPH1=null;
        Token EOF3=null;
        Token RULE4=null;
        Token ARROW6=null;
        Token EOF8=null;
        BigraphTermParser.wide_return wide2 = null;

        BigraphTermParser.wide_return wide5 = null;

        BigraphTermParser.wide_return wide7 = null;


        Object BIGRAPH1_tree=null;
        Object EOF3_tree=null;
        Object RULE4_tree=null;
        Object ARROW6_tree=null;
        Object EOF8_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:26:1: ( BIGRAPH wide EOF | RULE wide ARROW wide EOF )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==BIGRAPH) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:26:3: BIGRAPH wide EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    BIGRAPH1=(Token)match(input,BIGRAPH,FOLLOW_BIGRAPH_in_start121); 
                    BIGRAPH1_tree = (Object)adaptor.create(BIGRAPH1);
                    root_0 = (Object)adaptor.becomeRoot(BIGRAPH1_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start124);
                    wide2=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide2.getTree());
                    EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_start126); 
                    EOF3_tree = (Object)adaptor.create(EOF3);
                    adaptor.addChild(root_0, EOF3_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:27:3: RULE wide ARROW wide EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    RULE4=(Token)match(input,RULE,FOLLOW_RULE_in_start130); 
                    RULE4_tree = (Object)adaptor.create(RULE4);
                    root_0 = (Object)adaptor.becomeRoot(RULE4_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start133);
                    wide5=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide5.getTree());
                    ARROW6=(Token)match(input,ARROW,FOLLOW_ARROW_in_start135); 
                    pushFollow(FOLLOW_wide_in_start138);
                    wide7=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide7.getTree());
                    EOF8=(Token)match(input,EOF,FOLLOW_EOF_in_start140); 
                    EOF8_tree = (Object)adaptor.create(EOF8);
                    adaptor.addChild(root_0, EOF8_tree);


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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:30:1: wide : wide1 ( PIPE2 wide1 )* -> ( wide1 )+ ;
    public final BigraphTermParser.wide_return wide() throws RecognitionException {
        BigraphTermParser.wide_return retval = new BigraphTermParser.wide_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PIPE210=null;
        BigraphTermParser.wide1_return wide19 = null;

        BigraphTermParser.wide1_return wide111 = null;


        Object PIPE210_tree=null;
        RewriteRuleTokenStream stream_PIPE2=new RewriteRuleTokenStream(adaptor,"token PIPE2");
        RewriteRuleSubtreeStream stream_wide1=new RewriteRuleSubtreeStream(adaptor,"rule wide1");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:31:1: ( wide1 ( PIPE2 wide1 )* -> ( wide1 )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:31:3: wide1 ( PIPE2 wide1 )*
            {
            pushFollow(FOLLOW_wide1_in_wide153);
            wide19=wide1();

            state._fsp--;

            stream_wide1.add(wide19.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:31:9: ( PIPE2 wide1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PIPE2) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:31:11: PIPE2 wide1
            	    {
            	    PIPE210=(Token)match(input,PIPE2,FOLLOW_PIPE2_in_wide157);  
            	    stream_PIPE2.add(PIPE210);

            	    pushFollow(FOLLOW_wide1_in_wide159);
            	    wide111=wide1();

            	    state._fsp--;

            	    stream_wide1.add(wide111.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
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
            // 31:26: -> ( wide1 )+
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:34:1: wide1 : prime -> ^( ROOT prime ) ;
    public final BigraphTermParser.wide1_return wide1() throws RecognitionException {
        BigraphTermParser.wide1_return retval = new BigraphTermParser.wide1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        BigraphTermParser.prime_return prime12 = null;


        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:35:1: ( prime -> ^( ROOT prime ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:35:3: prime
            {
            pushFollow(FOLLOW_prime_in_wide1176);
            prime12=prime();

            state._fsp--;

            stream_prime.add(prime12.getTree());


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
            // 35:9: -> ^( ROOT prime )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:35:12: ^( ROOT prime )
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:38:1: prime : ( -> ^( EMPTY ) | LSQUARE ( NUMERAL )? RSQUARE -> ^( UNDERSCORE ( NUMERAL )? ) | node ( PIPE node )* -> ( node )+ );
    public final BigraphTermParser.prime_return prime() throws RecognitionException {
        BigraphTermParser.prime_return retval = new BigraphTermParser.prime_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LSQUARE13=null;
        Token NUMERAL14=null;
        Token RSQUARE15=null;
        Token PIPE17=null;
        BigraphTermParser.node_return node16 = null;

        BigraphTermParser.node_return node18 = null;


        Object LSQUARE13_tree=null;
        Object NUMERAL14_tree=null;
        Object RSQUARE15_tree=null;
        Object PIPE17_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleTokenStream stream_NUMERAL=new RewriteRuleTokenStream(adaptor,"token NUMERAL");
        RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
        RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
        RewriteRuleSubtreeStream stream_node=new RewriteRuleSubtreeStream(adaptor,"rule node");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:39:1: ( -> ^( EMPTY ) | LSQUARE ( NUMERAL )? RSQUARE -> ^( UNDERSCORE ( NUMERAL )? ) | node ( PIPE node )* -> ( node )+ )
            int alt5=3;
            switch ( input.LA(1) ) {
            case EOF:
            case ARROW:
            case PIPE2:
            case RPAREN:
                {
                alt5=1;
                }
                break;
            case LSQUARE:
                {
                alt5=2;
                }
                break;
            case NUMERAL:
            case IDENTIFIER:
            case STRING:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:39:3: 
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
                    // 39:3: -> ^( EMPTY )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:39:6: ^( EMPTY )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:40:3: LSQUARE ( NUMERAL )? RSQUARE
                    {
                    LSQUARE13=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_prime205);  
                    stream_LSQUARE.add(LSQUARE13);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:40:11: ( NUMERAL )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==NUMERAL) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:40:11: NUMERAL
                            {
                            NUMERAL14=(Token)match(input,NUMERAL,FOLLOW_NUMERAL_in_prime207);  
                            stream_NUMERAL.add(NUMERAL14);


                            }
                            break;

                    }

                    RSQUARE15=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_prime210);  
                    stream_RSQUARE.add(RSQUARE15);



                    // AST REWRITE
                    // elements: NUMERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 40:28: -> ^( UNDERSCORE ( NUMERAL )? )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:40:31: ^( UNDERSCORE ( NUMERAL )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNDERSCORE, "UNDERSCORE"), root_1);

                        // src/bigraphspace/parser/antlr/BigraphTerm.g:40:45: ( NUMERAL )?
                        if ( stream_NUMERAL.hasNext() ) {
                            adaptor.addChild(root_1, stream_NUMERAL.nextNode());

                        }
                        stream_NUMERAL.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:41:3: node ( PIPE node )*
                    {
                    pushFollow(FOLLOW_node_in_prime225);
                    node16=node();

                    state._fsp--;

                    stream_node.add(node16.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:41:8: ( PIPE node )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==PIPE) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:41:10: PIPE node
                    	    {
                    	    PIPE17=(Token)match(input,PIPE,FOLLOW_PIPE_in_prime229);  
                    	    stream_PIPE.add(PIPE17);

                    	    pushFollow(FOLLOW_node_in_prime231);
                    	    node18=node();

                    	    state._fsp--;

                    	    stream_node.add(node18.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
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
                    // 41:23: -> ( node )+
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:45:1: node : control ( ports )? ( children )? -> ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) ;
    public final BigraphTermParser.node_return node() throws RecognitionException {
        BigraphTermParser.node_return retval = new BigraphTermParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        BigraphTermParser.control_return control19 = null;

        BigraphTermParser.ports_return ports20 = null;

        BigraphTermParser.children_return children21 = null;


        RewriteRuleSubtreeStream stream_control=new RewriteRuleSubtreeStream(adaptor,"rule control");
        RewriteRuleSubtreeStream stream_ports=new RewriteRuleSubtreeStream(adaptor,"rule ports");
        RewriteRuleSubtreeStream stream_children=new RewriteRuleSubtreeStream(adaptor,"rule children");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:46:1: ( control ( ports )? ( children )? -> ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:46:3: control ( ports )? ( children )?
            {
            pushFollow(FOLLOW_control_in_node251);
            control19=control();

            state._fsp--;

            stream_control.add(control19.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:46:11: ( ports )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LBRACE) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:46:11: ports
                    {
                    pushFollow(FOLLOW_ports_in_node253);
                    ports20=ports();

                    state._fsp--;

                    stream_ports.add(ports20.getTree());

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:46:18: ( children )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LPAREN) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:46:18: children
                    {
                    pushFollow(FOLLOW_children_in_node256);
                    children21=children();

                    state._fsp--;

                    stream_children.add(children21.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ports, control, children
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 46:28: -> ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:46:31: ^( NODE control ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NODE, "NODE"), root_1);

                adaptor.addChild(root_1, stream_control.nextTree());
                // src/bigraphspace/parser/antlr/BigraphTerm.g:46:47: ^( PORTS ( ports )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(PORTS, "PORTS"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:46:56: ( ports )?
                if ( stream_ports.hasNext() ) {
                    adaptor.addChild(root_2, stream_ports.nextTree());

                }
                stream_ports.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/bigraphspace/parser/antlr/BigraphTerm.g:46:65: ^( CHILDREN ( children )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CHILDREN, "CHILDREN"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:46:77: ( children )?
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:49:1: control : ( tuple COLON type -> ^( CONTROL type tuple ) | IDENTIFIER ( indexes )? -> ^( CONTROL IDENTIFIER ( indexes )? ) );
    public final BigraphTermParser.control_return control() throws RecognitionException {
        BigraphTermParser.control_return retval = new BigraphTermParser.control_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON23=null;
        Token IDENTIFIER25=null;
        BigraphTermParser.tuple_return tuple22 = null;

        BigraphTermParser.type_return type24 = null;

        BigraphTermParser.indexes_return indexes26 = null;


        Object COLON23_tree=null;
        Object IDENTIFIER25_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_tuple=new RewriteRuleSubtreeStream(adaptor,"rule tuple");
        RewriteRuleSubtreeStream stream_indexes=new RewriteRuleSubtreeStream(adaptor,"rule indexes");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:50:1: ( tuple COLON type -> ^( CONTROL type tuple ) | IDENTIFIER ( indexes )? -> ^( CONTROL IDENTIFIER ( indexes )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==EOF||(LA9_1>=ARROW && LA9_1<=PIPE2)||LA9_1==PIPE||LA9_1==LANGLE||LA9_1==LBRACE||(LA9_1>=LPAREN && LA9_1<=RPAREN)) ) {
                    alt9=2;
                }
                else if ( (LA9_1==COLON||LA9_1==COMMA) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==NUMERAL||LA9_0==STRING) ) {
                alt9=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:50:3: tuple COLON type
                    {
                    pushFollow(FOLLOW_tuple_in_control294);
                    tuple22=tuple();

                    state._fsp--;

                    stream_tuple.add(tuple22.getTree());
                    COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_control296);  
                    stream_COLON.add(COLON23);

                    pushFollow(FOLLOW_type_in_control298);
                    type24=type();

                    state._fsp--;

                    stream_type.add(type24.getTree());


                    // AST REWRITE
                    // elements: type, tuple
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 50:20: -> ^( CONTROL type tuple )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:50:23: ^( CONTROL type tuple )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:51:3: IDENTIFIER ( indexes )?
                    {
                    IDENTIFIER25=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_control314);  
                    stream_IDENTIFIER.add(IDENTIFIER25);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:51:14: ( indexes )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==LANGLE) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:51:14: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_control316);
                            indexes26=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes26.getTree());

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
                    // 51:23: -> ^( CONTROL IDENTIFIER ( indexes )? )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:51:26: ^( CONTROL IDENTIFIER ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTROL, "CONTROL"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:51:48: ( indexes )?
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:54:1: indexes : LANGLE ( index ( COMMA index )* )? RANGLE -> ( index )* ;
    public final BigraphTermParser.indexes_return indexes() throws RecognitionException {
        BigraphTermParser.indexes_return retval = new BigraphTermParser.indexes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LANGLE27=null;
        Token COMMA29=null;
        Token RANGLE31=null;
        BigraphTermParser.index_return index28 = null;

        BigraphTermParser.index_return index30 = null;


        Object LANGLE27_tree=null;
        Object COMMA29_tree=null;
        Object RANGLE31_tree=null;
        RewriteRuleTokenStream stream_RANGLE=new RewriteRuleTokenStream(adaptor,"token RANGLE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LANGLE=new RewriteRuleTokenStream(adaptor,"token LANGLE");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:55:1: ( LANGLE ( index ( COMMA index )* )? RANGLE -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:55:3: LANGLE ( index ( COMMA index )* )? RANGLE
            {
            LANGLE27=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_indexes339);  
            stream_LANGLE.add(LANGLE27);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:55:10: ( index ( COMMA index )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NUMERAL||LA11_0==IDENTIFIER||LA11_0==STRING) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:55:12: index ( COMMA index )*
                    {
                    pushFollow(FOLLOW_index_in_indexes343);
                    index28=index();

                    state._fsp--;

                    stream_index.add(index28.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:55:18: ( COMMA index )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:55:20: COMMA index
                    	    {
                    	    COMMA29=(Token)match(input,COMMA,FOLLOW_COMMA_in_indexes347);  
                    	    stream_COMMA.add(COMMA29);

                    	    pushFollow(FOLLOW_index_in_indexes349);
                    	    index30=index();

                    	    state._fsp--;

                    	    stream_index.add(index30.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            RANGLE31=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_indexes357);  
            stream_RANGLE.add(RANGLE31);



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
            // 55:45: -> ( index )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:55:48: ( index )*
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:59:1: index : ( NUMERAL | STRING | IDENTIFIER );
    public final BigraphTermParser.index_return index() throws RecognitionException {
        BigraphTermParser.index_return retval = new BigraphTermParser.index_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set32=null;

        Object set32_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:60:1: ( NUMERAL | STRING | IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set32=(Token)input.LT(1);
            if ( input.LA(1)==NUMERAL||input.LA(1)==IDENTIFIER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set32));
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:65:1: tuple : index ( COMMA index )* -> ( index )* ;
    public final BigraphTermParser.tuple_return tuple() throws RecognitionException {
        BigraphTermParser.tuple_return retval = new BigraphTermParser.tuple_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA34=null;
        BigraphTermParser.index_return index33 = null;

        BigraphTermParser.index_return index35 = null;


        Object COMMA34_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:66:1: ( index ( COMMA index )* -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:66:3: index ( COMMA index )*
            {
            pushFollow(FOLLOW_index_in_tuple393);
            index33=index();

            state._fsp--;

            stream_index.add(index33.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:66:9: ( COMMA index )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:66:11: COMMA index
            	    {
            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_tuple397);  
            	    stream_COMMA.add(COMMA34);

            	    pushFollow(FOLLOW_index_in_tuple399);
            	    index35=index();

            	    state._fsp--;

            	    stream_index.add(index35.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
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
            // 66:26: -> ( index )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:66:29: ( index )*
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:70:1: type : IDENTIFIER -> IDENTIFIER ;
    public final BigraphTermParser.type_return type() throws RecognitionException {
        BigraphTermParser.type_return retval = new BigraphTermParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER36=null;

        Object IDENTIFIER36_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:1: ( IDENTIFIER -> IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:3: IDENTIFIER
            {
            IDENTIFIER36=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type418);  
            stream_IDENTIFIER.add(IDENTIFIER36);



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
            // 71:14: -> IDENTIFIER
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:74:1: ports : LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* ;
    public final BigraphTermParser.ports_return ports() throws RecognitionException {
        BigraphTermParser.ports_return retval = new BigraphTermParser.ports_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACE37=null;
        Token COMMA39=null;
        Token RBRACE41=null;
        BigraphTermParser.port_value_return port_value38 = null;

        BigraphTermParser.port_value_return port_value40 = null;


        Object LBRACE37_tree=null;
        Object COMMA39_tree=null;
        Object RBRACE41_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_port_value=new RewriteRuleSubtreeStream(adaptor,"rule port_value");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:75:1: ( LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:75:3: LBRACE ( port_value ( COMMA port_value )* )? RBRACE
            {
            LBRACE37=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_ports431);  
            stream_LBRACE.add(LBRACE37);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:75:10: ( port_value ( COMMA port_value )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER||LA14_0==STRING||LA14_0==NUMBER) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:75:12: port_value ( COMMA port_value )*
                    {
                    pushFollow(FOLLOW_port_value_in_ports435);
                    port_value38=port_value();

                    state._fsp--;

                    stream_port_value.add(port_value38.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:75:23: ( COMMA port_value )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:75:25: COMMA port_value
                    	    {
                    	    COMMA39=(Token)match(input,COMMA,FOLLOW_COMMA_in_ports439);  
                    	    stream_COMMA.add(COMMA39);

                    	    pushFollow(FOLLOW_port_value_in_ports441);
                    	    port_value40=port_value();

                    	    state._fsp--;

                    	    stream_port_value.add(port_value40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACE41=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_ports449);  
            stream_RBRACE.add(RBRACE41);



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
            // 75:55: -> ( port_value )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:75:58: ( port_value )*
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:78:1: port_value : ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) );
    public final BigraphTermParser.port_value_return port_value() throws RecognitionException {
        BigraphTermParser.port_value_return retval = new BigraphTermParser.port_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER42=null;
        Token EQUALS43=null;
        BigraphTermParser.link_name_return link_name44 = null;

        BigraphTermParser.link_name_return link_name45 = null;


        Object IDENTIFIER42_tree=null;
        Object EQUALS43_tree=null;
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:79:1: ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==EQUALS) ) {
                    alt15=1;
                }
                else if ( (LA15_1==COMMA||LA15_1==RBRACE) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA15_0==STRING||LA15_0==NUMBER) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:79:3: IDENTIFIER EQUALS link_name
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER42=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_port_value463); 
                    IDENTIFIER42_tree = (Object)adaptor.create(IDENTIFIER42);
                    root_0 = (Object)adaptor.becomeRoot(IDENTIFIER42_tree, root_0);

                    EQUALS43=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_port_value466); 
                    pushFollow(FOLLOW_link_name_in_port_value469);
                    link_name44=link_name();

                    state._fsp--;

                    adaptor.addChild(root_0, link_name44.getTree());

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:80:3: link_name
                    {
                    pushFollow(FOLLOW_link_name_in_port_value473);
                    link_name45=link_name();

                    state._fsp--;

                    stream_link_name.add(link_name45.getTree());


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
                    // 80:13: -> ^( UNNAMED link_name )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:80:16: ^( UNNAMED link_name )
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:83:1: link_name : ( IDENTIFIER | constant );
    public final BigraphTermParser.link_name_return link_name() throws RecognitionException {
        BigraphTermParser.link_name_return retval = new BigraphTermParser.link_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER46=null;
        BigraphTermParser.constant_return constant47 = null;


        Object IDENTIFIER46_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:84:1: ( IDENTIFIER | constant )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENTIFIER) ) {
                alt16=1;
            }
            else if ( (LA16_0==STRING||LA16_0==NUMBER) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:84:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER46=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_link_name492); 
                    IDENTIFIER46_tree = (Object)adaptor.create(IDENTIFIER46);
                    adaptor.addChild(root_0, IDENTIFIER46_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:85:3: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_link_name496);
                    constant47=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant47.getTree());

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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:88:1: constant : ( NUMBER | STRING );
    public final BigraphTermParser.constant_return constant() throws RecognitionException {
        BigraphTermParser.constant_return retval = new BigraphTermParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set48=null;

        Object set48_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:89:1: ( NUMBER | STRING )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set48=(Token)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==NUMBER ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set48));
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:93:1: children : LPAREN prime RPAREN -> prime ;
    public final BigraphTermParser.children_return children() throws RecognitionException {
        BigraphTermParser.children_return retval = new BigraphTermParser.children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN49=null;
        Token RPAREN51=null;
        BigraphTermParser.prime_return prime50 = null;


        Object LPAREN49_tree=null;
        Object RPAREN51_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:94:1: ( LPAREN prime RPAREN -> prime )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:94:3: LPAREN prime RPAREN
            {
            LPAREN49=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_children518);  
            stream_LPAREN.add(LPAREN49);

            pushFollow(FOLLOW_prime_in_children520);
            prime50=prime();

            state._fsp--;

            stream_prime.add(prime50.getTree());
            RPAREN51=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_children522);  
            stream_RPAREN.add(RPAREN51);



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
            // 94:23: -> prime
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

    // Delegated rules


 

    public static final BitSet FOLLOW_BIGRAPH_in_start121 = new BitSet(new long[]{0x0000000001118000L});
    public static final BitSet FOLLOW_wide_in_start124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_start130 = new BitSet(new long[]{0x0000000001118000L});
    public static final BitSet FOLLOW_wide_in_start133 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ARROW_in_start135 = new BitSet(new long[]{0x0000000001118000L});
    public static final BitSet FOLLOW_wide_in_start138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wide1_in_wide153 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_PIPE2_in_wide157 = new BitSet(new long[]{0x0000000001118000L});
    public static final BitSet FOLLOW_wide1_in_wide159 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_prime_in_wide1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_prime205 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_NUMERAL_in_prime207 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RSQUARE_in_prime210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_prime225 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_PIPE_in_prime229 = new BitSet(new long[]{0x0000000001158000L});
    public static final BitSet FOLLOW_node_in_prime231 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_control_in_node251 = new BitSet(new long[]{0x0000000022000002L});
    public static final BitSet FOLLOW_ports_in_node253 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_children_in_node256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_control294 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COLON_in_control296 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_type_in_control298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_control314 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_indexes_in_control316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_indexes339 = new BitSet(new long[]{0x0000000001910000L});
    public static final BitSet FOLLOW_index_in_indexes343 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_COMMA_in_indexes347 = new BitSet(new long[]{0x0000000001110000L});
    public static final BitSet FOLLOW_index_in_indexes349 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RANGLE_in_indexes357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_index0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_index_in_tuple393 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_tuple397 = new BitSet(new long[]{0x0000000001110000L});
    public static final BitSet FOLLOW_index_in_tuple399 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_ports431 = new BitSet(new long[]{0x0000000015100000L});
    public static final BitSet FOLLOW_port_value_in_ports435 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_COMMA_in_ports439 = new BitSet(new long[]{0x0000000011100000L});
    public static final BitSet FOLLOW_port_value_in_ports441 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_RBRACE_in_ports449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_port_value463 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EQUALS_in_port_value466 = new BitSet(new long[]{0x0000000011100000L});
    public static final BitSet FOLLOW_link_name_in_port_value469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_link_name_in_port_value473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_link_name492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_link_name496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_children518 = new BitSet(new long[]{0x0000000041118000L});
    public static final BitSet FOLLOW_prime_in_children520 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RPAREN_in_children522 = new BitSet(new long[]{0x0000000000000002L});

}