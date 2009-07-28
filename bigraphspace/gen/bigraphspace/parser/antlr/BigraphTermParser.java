// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/BigraphTerm.g 2009-07-28 14:18:01
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class BigraphTermParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGRAPH", "RULE", "EMPTY", "PORTS", "CHILDREN", "ROOT", "UNNAMED", "ARROW", "PIPE2", "UNDERSCORE", "NUMERAL", "PIPE", "IDENTIFIER", "LBRACE", "COMMA", "RBRACE", "EQUALS", "NUMBER", "STRING", "LPAREN", "RPAREN", "SLASH", "DIGIT", "STRING_ESCAPE", "LETTER", "WHITESPACE", "LINECOMMENT"
    };
    public static final int STRING_ESCAPE=27;
    public static final int RULE=5;
    public static final int RBRACE=19;
    public static final int CHILDREN=8;
    public static final int LETTER=28;
    public static final int LBRACE=17;
    public static final int NUMBER=21;
    public static final int WHITESPACE=29;
    public static final int UNDERSCORE=13;
    public static final int EQUALS=20;
    public static final int LINECOMMENT=30;
    public static final int BIGRAPH=4;
    public static final int EOF=-1;
    public static final int ROOT=9;
    public static final int LPAREN=23;
    public static final int EMPTY=6;
    public static final int RPAREN=24;
    public static final int SLASH=25;
    public static final int PORTS=7;
    public static final int COMMA=18;
    public static final int IDENTIFIER=16;
    public static final int UNNAMED=10;
    public static final int ARROW=11;
    public static final int NUMERAL=14;
    public static final int PIPE=15;
    public static final int DIGIT=26;
    public static final int PIPE2=12;
    public static final int STRING=22;

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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:23:1: start : ( BIGRAPH wide EOF | RULE wide ARROW wide EOF );
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:24:1: ( BIGRAPH wide EOF | RULE wide ARROW wide EOF )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:24:3: BIGRAPH wide EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    BIGRAPH1=(Token)match(input,BIGRAPH,FOLLOW_BIGRAPH_in_start105); 
                    BIGRAPH1_tree = (Object)adaptor.create(BIGRAPH1);
                    root_0 = (Object)adaptor.becomeRoot(BIGRAPH1_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start108);
                    wide2=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide2.getTree());
                    EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_start110); 
                    EOF3_tree = (Object)adaptor.create(EOF3);
                    adaptor.addChild(root_0, EOF3_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:25:3: RULE wide ARROW wide EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    RULE4=(Token)match(input,RULE,FOLLOW_RULE_in_start114); 
                    RULE4_tree = (Object)adaptor.create(RULE4);
                    root_0 = (Object)adaptor.becomeRoot(RULE4_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start117);
                    wide5=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide5.getTree());
                    ARROW6=(Token)match(input,ARROW,FOLLOW_ARROW_in_start119); 
                    pushFollow(FOLLOW_wide_in_start122);
                    wide7=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide7.getTree());
                    EOF8=(Token)match(input,EOF,FOLLOW_EOF_in_start124); 
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:28:1: wide : wide1 ( PIPE2 wide1 )* -> ( wide1 )+ ;
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:29:1: ( wide1 ( PIPE2 wide1 )* -> ( wide1 )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:29:3: wide1 ( PIPE2 wide1 )*
            {
            pushFollow(FOLLOW_wide1_in_wide137);
            wide19=wide1();

            state._fsp--;

            stream_wide1.add(wide19.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:29:9: ( PIPE2 wide1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PIPE2) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:29:11: PIPE2 wide1
            	    {
            	    PIPE210=(Token)match(input,PIPE2,FOLLOW_PIPE2_in_wide141);  
            	    stream_PIPE2.add(PIPE210);

            	    pushFollow(FOLLOW_wide1_in_wide143);
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
            // 29:26: -> ( wide1 )+
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:32:1: wide1 : prime -> ^( ROOT prime ) ;
    public final BigraphTermParser.wide1_return wide1() throws RecognitionException {
        BigraphTermParser.wide1_return retval = new BigraphTermParser.wide1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        BigraphTermParser.prime_return prime12 = null;


        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:33:1: ( prime -> ^( ROOT prime ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:33:3: prime
            {
            pushFollow(FOLLOW_prime_in_wide1160);
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
            // 33:9: -> ^( ROOT prime )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:33:12: ^( ROOT prime )
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:36:1: prime : ( -> ^( EMPTY ) | UNDERSCORE ( NUMERAL )? -> ^( UNDERSCORE ( NUMERAL )? ) | node ( PIPE node )* -> ( node )+ );
    public final BigraphTermParser.prime_return prime() throws RecognitionException {
        BigraphTermParser.prime_return retval = new BigraphTermParser.prime_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UNDERSCORE13=null;
        Token NUMERAL14=null;
        Token PIPE16=null;
        BigraphTermParser.node_return node15 = null;

        BigraphTermParser.node_return node17 = null;


        Object UNDERSCORE13_tree=null;
        Object NUMERAL14_tree=null;
        Object PIPE16_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleTokenStream stream_UNDERSCORE=new RewriteRuleTokenStream(adaptor,"token UNDERSCORE");
        RewriteRuleTokenStream stream_NUMERAL=new RewriteRuleTokenStream(adaptor,"token NUMERAL");
        RewriteRuleSubtreeStream stream_node=new RewriteRuleSubtreeStream(adaptor,"rule node");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:37:1: ( -> ^( EMPTY ) | UNDERSCORE ( NUMERAL )? -> ^( UNDERSCORE ( NUMERAL )? ) | node ( PIPE node )* -> ( node )+ )
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
            case UNDERSCORE:
                {
                alt5=2;
                }
                break;
            case IDENTIFIER:
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:37:3: 
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
                    // 37:3: -> ^( EMPTY )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:37:6: ^( EMPTY )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:38:3: UNDERSCORE ( NUMERAL )?
                    {
                    UNDERSCORE13=(Token)match(input,UNDERSCORE,FOLLOW_UNDERSCORE_in_prime189);  
                    stream_UNDERSCORE.add(UNDERSCORE13);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:38:14: ( NUMERAL )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==NUMERAL) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:38:14: NUMERAL
                            {
                            NUMERAL14=(Token)match(input,NUMERAL,FOLLOW_NUMERAL_in_prime191);  
                            stream_NUMERAL.add(NUMERAL14);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: UNDERSCORE, NUMERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 38:23: -> ^( UNDERSCORE ( NUMERAL )? )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:38:26: ^( UNDERSCORE ( NUMERAL )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_UNDERSCORE.nextNode(), root_1);

                        // src/bigraphspace/parser/antlr/BigraphTerm.g:38:40: ( NUMERAL )?
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:39:3: node ( PIPE node )*
                    {
                    pushFollow(FOLLOW_node_in_prime207);
                    node15=node();

                    state._fsp--;

                    stream_node.add(node15.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:39:8: ( PIPE node )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==PIPE) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:39:10: PIPE node
                    	    {
                    	    PIPE16=(Token)match(input,PIPE,FOLLOW_PIPE_in_prime211);  
                    	    stream_PIPE.add(PIPE16);

                    	    pushFollow(FOLLOW_node_in_prime213);
                    	    node17=node();

                    	    state._fsp--;

                    	    stream_node.add(node17.getTree());

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
                    // 39:23: -> ( node )+
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:43:1: node : IDENTIFIER ( ports )? ( children )? -> ^( IDENTIFIER ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) ;
    public final BigraphTermParser.node_return node() throws RecognitionException {
        BigraphTermParser.node_return retval = new BigraphTermParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER18=null;
        BigraphTermParser.ports_return ports19 = null;

        BigraphTermParser.children_return children20 = null;


        Object IDENTIFIER18_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_ports=new RewriteRuleSubtreeStream(adaptor,"rule ports");
        RewriteRuleSubtreeStream stream_children=new RewriteRuleSubtreeStream(adaptor,"rule children");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:44:1: ( IDENTIFIER ( ports )? ( children )? -> ^( IDENTIFIER ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:44:3: IDENTIFIER ( ports )? ( children )?
            {
            IDENTIFIER18=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_node233);  
            stream_IDENTIFIER.add(IDENTIFIER18);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:44:14: ( ports )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LBRACE) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:44:14: ports
                    {
                    pushFollow(FOLLOW_ports_in_node235);
                    ports19=ports();

                    state._fsp--;

                    stream_ports.add(ports19.getTree());

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:44:21: ( children )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LPAREN) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:44:21: children
                    {
                    pushFollow(FOLLOW_children_in_node238);
                    children20=children();

                    state._fsp--;

                    stream_children.add(children20.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: IDENTIFIER, ports, children
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 44:31: -> ^( IDENTIFIER ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:44:34: ^( IDENTIFIER ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_IDENTIFIER.nextNode(), root_1);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:44:48: ^( PORTS ( ports )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(PORTS, "PORTS"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:44:57: ( ports )?
                if ( stream_ports.hasNext() ) {
                    adaptor.addChild(root_2, stream_ports.nextTree());

                }
                stream_ports.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/bigraphspace/parser/antlr/BigraphTerm.g:44:66: ^( CHILDREN ( children )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CHILDREN, "CHILDREN"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:44:78: ( children )?
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

    public static class ports_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ports"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:47:1: ports : LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* ;
    public final BigraphTermParser.ports_return ports() throws RecognitionException {
        BigraphTermParser.ports_return retval = new BigraphTermParser.ports_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACE21=null;
        Token COMMA23=null;
        Token RBRACE25=null;
        BigraphTermParser.port_value_return port_value22 = null;

        BigraphTermParser.port_value_return port_value24 = null;


        Object LBRACE21_tree=null;
        Object COMMA23_tree=null;
        Object RBRACE25_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_port_value=new RewriteRuleSubtreeStream(adaptor,"rule port_value");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:48:1: ( LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:48:3: LBRACE ( port_value ( COMMA port_value )* )? RBRACE
            {
            LBRACE21=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_ports274);  
            stream_LBRACE.add(LBRACE21);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:48:10: ( port_value ( COMMA port_value )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER||(LA9_0>=NUMBER && LA9_0<=STRING)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:48:12: port_value ( COMMA port_value )*
                    {
                    pushFollow(FOLLOW_port_value_in_ports278);
                    port_value22=port_value();

                    state._fsp--;

                    stream_port_value.add(port_value22.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:48:23: ( COMMA port_value )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:48:25: COMMA port_value
                    	    {
                    	    COMMA23=(Token)match(input,COMMA,FOLLOW_COMMA_in_ports282);  
                    	    stream_COMMA.add(COMMA23);

                    	    pushFollow(FOLLOW_port_value_in_ports284);
                    	    port_value24=port_value();

                    	    state._fsp--;

                    	    stream_port_value.add(port_value24.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACE25=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_ports292);  
            stream_RBRACE.add(RBRACE25);



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
            // 48:55: -> ( port_value )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:48:58: ( port_value )*
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:51:1: port_value : ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) );
    public final BigraphTermParser.port_value_return port_value() throws RecognitionException {
        BigraphTermParser.port_value_return retval = new BigraphTermParser.port_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER26=null;
        Token EQUALS27=null;
        BigraphTermParser.link_name_return link_name28 = null;

        BigraphTermParser.link_name_return link_name29 = null;


        Object IDENTIFIER26_tree=null;
        Object EQUALS27_tree=null;
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:52:1: ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENTIFIER) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==EQUALS) ) {
                    alt10=1;
                }
                else if ( ((LA10_1>=COMMA && LA10_1<=RBRACE)) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA10_0>=NUMBER && LA10_0<=STRING)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:52:3: IDENTIFIER EQUALS link_name
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER26=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_port_value306); 
                    IDENTIFIER26_tree = (Object)adaptor.create(IDENTIFIER26);
                    root_0 = (Object)adaptor.becomeRoot(IDENTIFIER26_tree, root_0);

                    EQUALS27=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_port_value309); 
                    pushFollow(FOLLOW_link_name_in_port_value312);
                    link_name28=link_name();

                    state._fsp--;

                    adaptor.addChild(root_0, link_name28.getTree());

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:53:3: link_name
                    {
                    pushFollow(FOLLOW_link_name_in_port_value316);
                    link_name29=link_name();

                    state._fsp--;

                    stream_link_name.add(link_name29.getTree());


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
                    // 53:13: -> ^( UNNAMED link_name )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:53:16: ^( UNNAMED link_name )
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:56:1: link_name : ( IDENTIFIER | constant );
    public final BigraphTermParser.link_name_return link_name() throws RecognitionException {
        BigraphTermParser.link_name_return retval = new BigraphTermParser.link_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER30=null;
        BigraphTermParser.constant_return constant31 = null;


        Object IDENTIFIER30_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:57:1: ( IDENTIFIER | constant )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=NUMBER && LA11_0<=STRING)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:57:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER30=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_link_name335); 
                    IDENTIFIER30_tree = (Object)adaptor.create(IDENTIFIER30);
                    adaptor.addChild(root_0, IDENTIFIER30_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:58:3: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_link_name339);
                    constant31=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant31.getTree());

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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:61:1: constant : ( NUMBER | STRING );
    public final BigraphTermParser.constant_return constant() throws RecognitionException {
        BigraphTermParser.constant_return retval = new BigraphTermParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set32=null;

        Object set32_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:1: ( NUMBER | STRING )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set32=(Token)input.LT(1);
            if ( (input.LA(1)>=NUMBER && input.LA(1)<=STRING) ) {
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
    // $ANTLR end "constant"

    public static class children_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "children"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:66:1: children : LPAREN prime RPAREN -> prime ;
    public final BigraphTermParser.children_return children() throws RecognitionException {
        BigraphTermParser.children_return retval = new BigraphTermParser.children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN33=null;
        Token RPAREN35=null;
        BigraphTermParser.prime_return prime34 = null;


        Object LPAREN33_tree=null;
        Object RPAREN35_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:1: ( LPAREN prime RPAREN -> prime )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:3: LPAREN prime RPAREN
            {
            LPAREN33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_children361);  
            stream_LPAREN.add(LPAREN33);

            pushFollow(FOLLOW_prime_in_children363);
            prime34=prime();

            state._fsp--;

            stream_prime.add(prime34.getTree());
            RPAREN35=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_children365);  
            stream_RPAREN.add(RPAREN35);



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
            // 67:23: -> prime
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


 

    public static final BitSet FOLLOW_BIGRAPH_in_start105 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_wide_in_start108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_start114 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_wide_in_start117 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ARROW_in_start119 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_wide_in_start122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wide1_in_wide137 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_PIPE2_in_wide141 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_wide1_in_wide143 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_prime_in_wide1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDERSCORE_in_prime189 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_NUMERAL_in_prime191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_prime207 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_PIPE_in_prime211 = new BitSet(new long[]{0x000000000001A000L});
    public static final BitSet FOLLOW_node_in_prime213 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_node233 = new BitSet(new long[]{0x0000000000820002L});
    public static final BitSet FOLLOW_ports_in_node235 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_children_in_node238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_ports274 = new BitSet(new long[]{0x0000000000690000L});
    public static final BitSet FOLLOW_port_value_in_ports278 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_COMMA_in_ports282 = new BitSet(new long[]{0x0000000000610000L});
    public static final BitSet FOLLOW_port_value_in_ports284 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_RBRACE_in_ports292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_port_value306 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EQUALS_in_port_value309 = new BitSet(new long[]{0x0000000000610000L});
    public static final BitSet FOLLOW_link_name_in_port_value312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_link_name_in_port_value316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_link_name335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_link_name339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_children361 = new BitSet(new long[]{0x0000000001012000L});
    public static final BitSet FOLLOW_prime_in_children363 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_children365 = new BitSet(new long[]{0x0000000000000002L});

}