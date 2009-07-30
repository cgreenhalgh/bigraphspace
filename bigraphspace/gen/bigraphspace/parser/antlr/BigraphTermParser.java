// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/BigraphTerm.g 2009-07-30 16:45:21
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class BigraphTermParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGRAPH", "RULE", "WHERE", "AND", "IN", "NOT", "LENGTH", "MATCHES", "EMPTY", "PORTS", "CHILDREN", "ROOT", "UNNAMED", "CONTROL", "NODE", "ONEOF", "NOTONEOF", "CONSTRAINT", "MINLENGTH", "MAXLENGTH", "MINVALUE", "MAXVALUE", "REGEXP", "SUPPORT", "CLOSURES", "SUBSTITUTIONS", "ARROW", "DOT", "SLASH", "IDENTIFIER", "COMMA", "PIPE2", "PIPE", "LSQUARE", "NUMBER", "RSQUARE", "COLON", "LANGLE", "RANGLE", "STRING", "AT", "LBRACE", "RBRACE", "EQUALS", "LPAREN", "RPAREN", "LESSTHANOREQUAL", "GREATERTHANOREQUAL", "PLUS", "MINUS", "UNDERSCORE", "DOLLAR", "DIGIT", "NUMERAL", "STRING_ESCAPE", "LETTER", "WHITESPACE", "LINECOMMENT"
    };
    public static final int DOLLAR=55;
    public static final int WHERE=6;
    public static final int LSQUARE=37;
    public static final int STRING_ESCAPE=58;
    public static final int CHILDREN=14;
    public static final int LETTER=59;
    public static final int LANGLE=41;
    public static final int LBRACE=45;
    public static final int EQUALS=47;
    public static final int NOT=9;
    public static final int LINECOMMENT=61;
    public static final int BIGRAPH=4;
    public static final int AND=7;
    public static final int EOF=-1;
    public static final int LPAREN=48;
    public static final int LENGTH=10;
    public static final int AT=44;
    public static final int RPAREN=49;
    public static final int SLASH=32;
    public static final int IN=8;
    public static final int CLOSURES=28;
    public static final int MINVALUE=24;
    public static final int MATCHES=11;
    public static final int MAXVALUE=25;
    public static final int COMMA=34;
    public static final int IDENTIFIER=33;
    public static final int LESSTHANOREQUAL=50;
    public static final int REGEXP=26;
    public static final int PLUS=52;
    public static final int SUPPORT=27;
    public static final int PIPE=36;
    public static final int NOTONEOF=20;
    public static final int DIGIT=56;
    public static final int PIPE2=35;
    public static final int RANGLE=42;
    public static final int DOT=31;
    public static final int GREATERTHANOREQUAL=51;
    public static final int SUBSTITUTIONS=29;
    public static final int RBRACE=46;
    public static final int NODE=18;
    public static final int CONTROL=17;
    public static final int RULE=5;
    public static final int MINLENGTH=22;
    public static final int NUMBER=38;
    public static final int WHITESPACE=60;
    public static final int UNDERSCORE=54;
    public static final int MINUS=53;
    public static final int RSQUARE=39;
    public static final int ROOT=15;
    public static final int ONEOF=19;
    public static final int EMPTY=12;
    public static final int COLON=40;
    public static final int PORTS=13;
    public static final int UNNAMED=16;
    public static final int MAXLENGTH=23;
    public static final int ARROW=30;
    public static final int NUMERAL=57;
    public static final int CONSTRAINT=21;
    public static final int STRING=43;

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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:44:1: start : ( BIGRAPH closures wide substitutions ( where )? EOF | RULE wide ARROW wide EOF );
    public final BigraphTermParser.start_return start() throws RecognitionException {
        BigraphTermParser.start_return retval = new BigraphTermParser.start_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BIGRAPH1=null;
        Token EOF6=null;
        Token RULE7=null;
        Token ARROW9=null;
        Token EOF11=null;
        BigraphTermParser.closures_return closures2 = null;

        BigraphTermParser.wide_return wide3 = null;

        BigraphTermParser.substitutions_return substitutions4 = null;

        BigraphTermParser.where_return where5 = null;

        BigraphTermParser.wide_return wide8 = null;

        BigraphTermParser.wide_return wide10 = null;


        Object BIGRAPH1_tree=null;
        Object EOF6_tree=null;
        Object RULE7_tree=null;
        Object ARROW9_tree=null;
        Object EOF11_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:45:1: ( BIGRAPH closures wide substitutions ( where )? EOF | RULE wide ARROW wide EOF )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:45:3: BIGRAPH closures wide substitutions ( where )? EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    BIGRAPH1=(Token)match(input,BIGRAPH,FOLLOW_BIGRAPH_in_start260); 
                    BIGRAPH1_tree = (Object)adaptor.create(BIGRAPH1);
                    root_0 = (Object)adaptor.becomeRoot(BIGRAPH1_tree, root_0);

                    pushFollow(FOLLOW_closures_in_start263);
                    closures2=closures();

                    state._fsp--;

                    adaptor.addChild(root_0, closures2.getTree());
                    pushFollow(FOLLOW_wide_in_start265);
                    wide3=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide3.getTree());
                    pushFollow(FOLLOW_substitutions_in_start267);
                    substitutions4=substitutions();

                    state._fsp--;

                    adaptor.addChild(root_0, substitutions4.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:45:40: ( where )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==WHERE) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:45:40: where
                            {
                            pushFollow(FOLLOW_where_in_start269);
                            where5=where();

                            state._fsp--;

                            adaptor.addChild(root_0, where5.getTree());

                            }
                            break;

                    }

                    EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_start272); 
                    EOF6_tree = (Object)adaptor.create(EOF6);
                    adaptor.addChild(root_0, EOF6_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:46:3: RULE wide ARROW wide EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    RULE7=(Token)match(input,RULE,FOLLOW_RULE_in_start276); 
                    RULE7_tree = (Object)adaptor.create(RULE7);
                    root_0 = (Object)adaptor.becomeRoot(RULE7_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start279);
                    wide8=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide8.getTree());
                    ARROW9=(Token)match(input,ARROW,FOLLOW_ARROW_in_start281); 
                    pushFollow(FOLLOW_wide_in_start284);
                    wide10=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide10.getTree());
                    EOF11=(Token)match(input,EOF,FOLLOW_EOF_in_start286); 
                    EOF11_tree = (Object)adaptor.create(EOF11);
                    adaptor.addChild(root_0, EOF11_tree);


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

    public static class closures_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "closures"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:49:1: closures : ( closure DOT )* -> ^( CLOSURES ( closure )* ) ;
    public final BigraphTermParser.closures_return closures() throws RecognitionException {
        BigraphTermParser.closures_return retval = new BigraphTermParser.closures_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOT13=null;
        BigraphTermParser.closure_return closure12 = null;


        Object DOT13_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_closure=new RewriteRuleSubtreeStream(adaptor,"rule closure");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:50:1: ( ( closure DOT )* -> ^( CLOSURES ( closure )* ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:50:3: ( closure DOT )*
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:50:3: ( closure DOT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==SLASH) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:50:5: closure DOT
            	    {
            	    pushFollow(FOLLOW_closure_in_closures301);
            	    closure12=closure();

            	    state._fsp--;

            	    stream_closure.add(closure12.getTree());
            	    DOT13=(Token)match(input,DOT,FOLLOW_DOT_in_closures303);  
            	    stream_DOT.add(DOT13);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);



            // AST REWRITE
            // elements: closure
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 50:20: -> ^( CLOSURES ( closure )* )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:50:23: ^( CLOSURES ( closure )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CLOSURES, "CLOSURES"), root_1);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:50:35: ( closure )*
                while ( stream_closure.hasNext() ) {
                    adaptor.addChild(root_1, stream_closure.nextTree());

                }
                stream_closure.reset();

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
    // $ANTLR end "closures"

    public static class substitutions_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "substitutions"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:53:1: substitutions : ( DOT substitution )* -> ^( SUBSTITUTIONS ( substitution )* ) ;
    public final BigraphTermParser.substitutions_return substitutions() throws RecognitionException {
        BigraphTermParser.substitutions_return retval = new BigraphTermParser.substitutions_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOT14=null;
        BigraphTermParser.substitution_return substitution15 = null;


        Object DOT14_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_substitution=new RewriteRuleSubtreeStream(adaptor,"rule substitution");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:54:1: ( ( DOT substitution )* -> ^( SUBSTITUTIONS ( substitution )* ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:54:3: ( DOT substitution )*
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:54:3: ( DOT substitution )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DOT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:54:5: DOT substitution
            	    {
            	    DOT14=(Token)match(input,DOT,FOLLOW_DOT_in_substitutions328);  
            	    stream_DOT.add(DOT14);

            	    pushFollow(FOLLOW_substitution_in_substitutions330);
            	    substitution15=substitution();

            	    state._fsp--;

            	    stream_substitution.add(substitution15.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);



            // AST REWRITE
            // elements: substitution
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 54:25: -> ^( SUBSTITUTIONS ( substitution )* )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:54:28: ^( SUBSTITUTIONS ( substitution )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SUBSTITUTIONS, "SUBSTITUTIONS"), root_1);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:54:45: ( substitution )*
                while ( stream_substitution.hasNext() ) {
                    adaptor.addChild(root_1, stream_substitution.nextTree());

                }
                stream_substitution.reset();

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
    // $ANTLR end "substitutions"

    public static class closure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "closure"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:57:1: closure : SLASH IDENTIFIER ( COMMA IDENTIFIER )* -> ^( SLASH UNDERSCORE ( IDENTIFIER )+ ) ;
    public final BigraphTermParser.closure_return closure() throws RecognitionException {
        BigraphTermParser.closure_return retval = new BigraphTermParser.closure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH16=null;
        Token IDENTIFIER17=null;
        Token COMMA18=null;
        Token IDENTIFIER19=null;

        Object SLASH16_tree=null;
        Object IDENTIFIER17_tree=null;
        Object COMMA18_tree=null;
        Object IDENTIFIER19_tree=null;
        RewriteRuleTokenStream stream_SLASH=new RewriteRuleTokenStream(adaptor,"token SLASH");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:58:1: ( SLASH IDENTIFIER ( COMMA IDENTIFIER )* -> ^( SLASH UNDERSCORE ( IDENTIFIER )+ ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:58:3: SLASH IDENTIFIER ( COMMA IDENTIFIER )*
            {
            SLASH16=(Token)match(input,SLASH,FOLLOW_SLASH_in_closure353);  
            stream_SLASH.add(SLASH16);

            IDENTIFIER17=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_closure355);  
            stream_IDENTIFIER.add(IDENTIFIER17);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:58:20: ( COMMA IDENTIFIER )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:58:22: COMMA IDENTIFIER
            	    {
            	    COMMA18=(Token)match(input,COMMA,FOLLOW_COMMA_in_closure359);  
            	    stream_COMMA.add(COMMA18);

            	    IDENTIFIER19=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_closure361);  
            	    stream_IDENTIFIER.add(IDENTIFIER19);


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



            // AST REWRITE
            // elements: SLASH, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 58:42: -> ^( SLASH UNDERSCORE ( IDENTIFIER )+ )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:58:45: ^( SLASH UNDERSCORE ( IDENTIFIER )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SLASH.nextNode(), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(UNDERSCORE, "UNDERSCORE"));
                if ( !(stream_IDENTIFIER.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_IDENTIFIER.hasNext() ) {
                    adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                }
                stream_IDENTIFIER.reset();

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
    // $ANTLR end "closure"

    public static class substitution_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "substitution"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:61:1: substitution : l= IDENTIFIER SLASH (r+= IDENTIFIER ( COMMA r+= IDENTIFIER )* )? -> ^( SLASH $l ( $r)* ) ;
    public final BigraphTermParser.substitution_return substitution() throws RecognitionException {
        BigraphTermParser.substitution_return retval = new BigraphTermParser.substitution_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token l=null;
        Token SLASH20=null;
        Token COMMA21=null;
        Token r=null;
        List list_r=null;

        Object l_tree=null;
        Object SLASH20_tree=null;
        Object COMMA21_tree=null;
        Object r_tree=null;
        RewriteRuleTokenStream stream_SLASH=new RewriteRuleTokenStream(adaptor,"token SLASH");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:1: (l= IDENTIFIER SLASH (r+= IDENTIFIER ( COMMA r+= IDENTIFIER )* )? -> ^( SLASH $l ( $r)* ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:3: l= IDENTIFIER SLASH (r+= IDENTIFIER ( COMMA r+= IDENTIFIER )* )?
            {
            l=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_substitution388);  
            stream_IDENTIFIER.add(l);

            SLASH20=(Token)match(input,SLASH,FOLLOW_SLASH_in_substitution390);  
            stream_SLASH.add(SLASH20);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:22: (r+= IDENTIFIER ( COMMA r+= IDENTIFIER )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDENTIFIER) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:24: r+= IDENTIFIER ( COMMA r+= IDENTIFIER )*
                    {
                    r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_substitution396);  
                    stream_IDENTIFIER.add(r);

                    if (list_r==null) list_r=new ArrayList();
                    list_r.add(r);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:38: ( COMMA r+= IDENTIFIER )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==COMMA) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:40: COMMA r+= IDENTIFIER
                    	    {
                    	    COMMA21=(Token)match(input,COMMA,FOLLOW_COMMA_in_substitution400);  
                    	    stream_COMMA.add(COMMA21);

                    	    r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_substitution404);  
                    	    stream_IDENTIFIER.add(r);

                    	    if (list_r==null) list_r=new ArrayList();
                    	    list_r.add(r);


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }



            // AST REWRITE
            // elements: l, SLASH, r
            // token labels: l
            // rule labels: retval
            // token list labels: r
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_l=new RewriteRuleTokenStream(adaptor,"token l",l);
            RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r", list_r);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 62:66: -> ^( SLASH $l ( $r)* )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:62:69: ^( SLASH $l ( $r)* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SLASH.nextNode(), root_1);

                adaptor.addChild(root_1, stream_l.nextNode());
                // src/bigraphspace/parser/antlr/BigraphTerm.g:62:81: ( $r)*
                while ( stream_r.hasNext() ) {
                    adaptor.addChild(root_1, stream_r.nextNode());

                }
                stream_r.reset();

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
    // $ANTLR end "substitution"

    public static class wide_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "wide"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:66:1: wide : wide1 ( PIPE2 wide1 )* -> ( wide1 )+ ;
    public final BigraphTermParser.wide_return wide() throws RecognitionException {
        BigraphTermParser.wide_return retval = new BigraphTermParser.wide_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PIPE223=null;
        BigraphTermParser.wide1_return wide122 = null;

        BigraphTermParser.wide1_return wide124 = null;


        Object PIPE223_tree=null;
        RewriteRuleTokenStream stream_PIPE2=new RewriteRuleTokenStream(adaptor,"token PIPE2");
        RewriteRuleSubtreeStream stream_wide1=new RewriteRuleSubtreeStream(adaptor,"rule wide1");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:1: ( wide1 ( PIPE2 wide1 )* -> ( wide1 )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:3: wide1 ( PIPE2 wide1 )*
            {
            pushFollow(FOLLOW_wide1_in_wide435);
            wide122=wide1();

            state._fsp--;

            stream_wide1.add(wide122.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:9: ( PIPE2 wide1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==PIPE2) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:67:11: PIPE2 wide1
            	    {
            	    PIPE223=(Token)match(input,PIPE2,FOLLOW_PIPE2_in_wide439);  
            	    stream_PIPE2.add(PIPE223);

            	    pushFollow(FOLLOW_wide1_in_wide441);
            	    wide124=wide1();

            	    state._fsp--;

            	    stream_wide1.add(wide124.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // 67:26: -> ( wide1 )+
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:70:1: wide1 : prime -> ^( ROOT prime ) ;
    public final BigraphTermParser.wide1_return wide1() throws RecognitionException {
        BigraphTermParser.wide1_return retval = new BigraphTermParser.wide1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        BigraphTermParser.prime_return prime25 = null;


        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:1: ( prime -> ^( ROOT prime ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:3: prime
            {
            pushFollow(FOLLOW_prime_in_wide1458);
            prime25=prime();

            state._fsp--;

            stream_prime.add(prime25.getTree());


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
            // 71:9: -> ^( ROOT prime )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:71:12: ^( ROOT prime )
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:74:1: prime : ( -> ^( EMPTY ) | prime1 ( PIPE prime1 )* -> ( prime1 )+ );
    public final BigraphTermParser.prime_return prime() throws RecognitionException {
        BigraphTermParser.prime_return retval = new BigraphTermParser.prime_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PIPE27=null;
        BigraphTermParser.prime1_return prime126 = null;

        BigraphTermParser.prime1_return prime128 = null;


        Object PIPE27_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleSubtreeStream stream_prime1=new RewriteRuleSubtreeStream(adaptor,"rule prime1");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:75:1: ( -> ^( EMPTY ) | prime1 ( PIPE prime1 )* -> ( prime1 )+ )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==EOF||LA10_0==WHERE||(LA10_0>=ARROW && LA10_0<=DOT)||LA10_0==PIPE2||LA10_0==RPAREN) ) {
                alt10=1;
            }
            else if ( (LA10_0==IDENTIFIER||(LA10_0>=LSQUARE && LA10_0<=NUMBER)||LA10_0==STRING) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:75:3: 
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
                    // 75:3: -> ^( EMPTY )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:75:6: ^( EMPTY )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:76:3: prime1 ( PIPE prime1 )*
                    {
                    pushFollow(FOLLOW_prime1_in_prime487);
                    prime126=prime1();

                    state._fsp--;

                    stream_prime1.add(prime126.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:76:10: ( PIPE prime1 )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==PIPE) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:76:12: PIPE prime1
                    	    {
                    	    PIPE27=(Token)match(input,PIPE,FOLLOW_PIPE_in_prime491);  
                    	    stream_PIPE.add(PIPE27);

                    	    pushFollow(FOLLOW_prime1_in_prime493);
                    	    prime128=prime1();

                    	    state._fsp--;

                    	    stream_prime1.add(prime128.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: prime1
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 76:27: -> ( prime1 )+
                    {
                        if ( !(stream_prime1.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_prime1.hasNext() ) {
                            adaptor.addChild(root_0, stream_prime1.nextTree());

                        }
                        stream_prime1.reset();

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

    public static class prime1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prime1"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:79:1: prime1 : ( LSQUARE ( NUMBER )? RSQUARE -> ^( UNDERSCORE ( NUMBER )? ) | node -> ( node )+ );
    public final BigraphTermParser.prime1_return prime1() throws RecognitionException {
        BigraphTermParser.prime1_return retval = new BigraphTermParser.prime1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LSQUARE29=null;
        Token NUMBER30=null;
        Token RSQUARE31=null;
        BigraphTermParser.node_return node32 = null;


        Object LSQUARE29_tree=null;
        Object NUMBER30_tree=null;
        Object RSQUARE31_tree=null;
        RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
        RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleSubtreeStream stream_node=new RewriteRuleSubtreeStream(adaptor,"rule node");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:80:1: ( LSQUARE ( NUMBER )? RSQUARE -> ^( UNDERSCORE ( NUMBER )? ) | node -> ( node )+ )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LSQUARE) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENTIFIER||LA12_0==NUMBER||LA12_0==STRING) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:80:3: LSQUARE ( NUMBER )? RSQUARE
                    {
                    LSQUARE29=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_prime1510);  
                    stream_LSQUARE.add(LSQUARE29);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:80:11: ( NUMBER )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==NUMBER) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:80:11: NUMBER
                            {
                            NUMBER30=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_prime1512);  
                            stream_NUMBER.add(NUMBER30);


                            }
                            break;

                    }

                    RSQUARE31=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_prime1515);  
                    stream_RSQUARE.add(RSQUARE31);



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
                    // 80:27: -> ^( UNDERSCORE ( NUMBER )? )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:80:30: ^( UNDERSCORE ( NUMBER )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNDERSCORE, "UNDERSCORE"), root_1);

                        // src/bigraphspace/parser/antlr/BigraphTerm.g:80:44: ( NUMBER )?
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
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:81:3: node
                    {
                    pushFollow(FOLLOW_node_in_prime1530);
                    node32=node();

                    state._fsp--;

                    stream_node.add(node32.getTree());


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
                    // 81:8: -> ( node )+
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
    // $ANTLR end "prime1"

    public static class node_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "node"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:85:1: node : control ( support )? ( ports )? ( children )? -> ^( NODE control ^( SUPPORT ( support )? ) ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) ;
    public final BigraphTermParser.node_return node() throws RecognitionException {
        BigraphTermParser.node_return retval = new BigraphTermParser.node_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        BigraphTermParser.control_return control33 = null;

        BigraphTermParser.support_return support34 = null;

        BigraphTermParser.ports_return ports35 = null;

        BigraphTermParser.children_return children36 = null;


        RewriteRuleSubtreeStream stream_control=new RewriteRuleSubtreeStream(adaptor,"rule control");
        RewriteRuleSubtreeStream stream_ports=new RewriteRuleSubtreeStream(adaptor,"rule ports");
        RewriteRuleSubtreeStream stream_support=new RewriteRuleSubtreeStream(adaptor,"rule support");
        RewriteRuleSubtreeStream stream_children=new RewriteRuleSubtreeStream(adaptor,"rule children");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:1: ( control ( support )? ( ports )? ( children )? -> ^( NODE control ^( SUPPORT ( support )? ) ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:3: control ( support )? ( ports )? ( children )?
            {
            pushFollow(FOLLOW_control_in_node547);
            control33=control();

            state._fsp--;

            stream_control.add(control33.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:11: ( support )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==AT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:86:11: support
                    {
                    pushFollow(FOLLOW_support_in_node549);
                    support34=support();

                    state._fsp--;

                    stream_support.add(support34.getTree());

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:20: ( ports )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LBRACE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:86:20: ports
                    {
                    pushFollow(FOLLOW_ports_in_node552);
                    ports35=ports();

                    state._fsp--;

                    stream_ports.add(ports35.getTree());

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:27: ( children )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LPAREN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:86:27: children
                    {
                    pushFollow(FOLLOW_children_in_node555);
                    children36=children();

                    state._fsp--;

                    stream_children.add(children36.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: children, control, ports, support
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 86:37: -> ^( NODE control ^( SUPPORT ( support )? ) ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:86:40: ^( NODE control ^( SUPPORT ( support )? ) ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NODE, "NODE"), root_1);

                adaptor.addChild(root_1, stream_control.nextTree());
                // src/bigraphspace/parser/antlr/BigraphTerm.g:86:56: ^( SUPPORT ( support )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(SUPPORT, "SUPPORT"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:86:67: ( support )?
                if ( stream_support.hasNext() ) {
                    adaptor.addChild(root_2, stream_support.nextTree());

                }
                stream_support.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/bigraphspace/parser/antlr/BigraphTerm.g:86:78: ^( PORTS ( ports )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(PORTS, "PORTS"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:86:87: ( ports )?
                if ( stream_ports.hasNext() ) {
                    adaptor.addChild(root_2, stream_ports.nextTree());

                }
                stream_ports.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/bigraphspace/parser/antlr/BigraphTerm.g:86:96: ^( CHILDREN ( children )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CHILDREN, "CHILDREN"), root_2);

                // src/bigraphspace/parser/antlr/BigraphTerm.g:86:108: ( children )?
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:89:1: control : ( tuple COLON type -> ^( CONTROL type tuple ) | IDENTIFIER ( indexes )? -> ^( CONTROL IDENTIFIER ( indexes )? ) );
    public final BigraphTermParser.control_return control() throws RecognitionException {
        BigraphTermParser.control_return retval = new BigraphTermParser.control_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON38=null;
        Token IDENTIFIER40=null;
        BigraphTermParser.tuple_return tuple37 = null;

        BigraphTermParser.type_return type39 = null;

        BigraphTermParser.indexes_return indexes41 = null;


        Object COLON38_tree=null;
        Object IDENTIFIER40_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_tuple=new RewriteRuleSubtreeStream(adaptor,"rule tuple");
        RewriteRuleSubtreeStream stream_indexes=new RewriteRuleSubtreeStream(adaptor,"rule indexes");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:90:1: ( tuple COLON type -> ^( CONTROL type tuple ) | IDENTIFIER ( indexes )? -> ^( CONTROL IDENTIFIER ( indexes )? ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENTIFIER) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==EOF||LA17_1==WHERE||(LA17_1>=ARROW && LA17_1<=DOT)||(LA17_1>=PIPE2 && LA17_1<=PIPE)||LA17_1==LANGLE||(LA17_1>=AT && LA17_1<=LBRACE)||(LA17_1>=LPAREN && LA17_1<=RPAREN)) ) {
                    alt17=2;
                }
                else if ( (LA17_1==COMMA||LA17_1==COLON) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA17_0==NUMBER||LA17_0==STRING) ) {
                alt17=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:90:3: tuple COLON type
                    {
                    pushFollow(FOLLOW_tuple_in_control602);
                    tuple37=tuple();

                    state._fsp--;

                    stream_tuple.add(tuple37.getTree());
                    COLON38=(Token)match(input,COLON,FOLLOW_COLON_in_control604);  
                    stream_COLON.add(COLON38);

                    pushFollow(FOLLOW_type_in_control606);
                    type39=type();

                    state._fsp--;

                    stream_type.add(type39.getTree());


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
                    // 90:20: -> ^( CONTROL type tuple )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:90:23: ^( CONTROL type tuple )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:91:3: IDENTIFIER ( indexes )?
                    {
                    IDENTIFIER40=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_control622);  
                    stream_IDENTIFIER.add(IDENTIFIER40);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:91:14: ( indexes )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LANGLE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:91:14: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_control624);
                            indexes41=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes41.getTree());

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
                    // 91:23: -> ^( CONTROL IDENTIFIER ( indexes )? )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:91:26: ^( CONTROL IDENTIFIER ( indexes )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTROL, "CONTROL"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:91:48: ( indexes )?
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:94:1: indexes : LANGLE ( index ( COMMA index )* )? RANGLE -> ( index )* ;
    public final BigraphTermParser.indexes_return indexes() throws RecognitionException {
        BigraphTermParser.indexes_return retval = new BigraphTermParser.indexes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LANGLE42=null;
        Token COMMA44=null;
        Token RANGLE46=null;
        BigraphTermParser.index_return index43 = null;

        BigraphTermParser.index_return index45 = null;


        Object LANGLE42_tree=null;
        Object COMMA44_tree=null;
        Object RANGLE46_tree=null;
        RewriteRuleTokenStream stream_RANGLE=new RewriteRuleTokenStream(adaptor,"token RANGLE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LANGLE=new RewriteRuleTokenStream(adaptor,"token LANGLE");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:1: ( LANGLE ( index ( COMMA index )* )? RANGLE -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:3: LANGLE ( index ( COMMA index )* )? RANGLE
            {
            LANGLE42=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_indexes647);  
            stream_LANGLE.add(LANGLE42);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:10: ( index ( COMMA index )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENTIFIER||LA19_0==NUMBER||LA19_0==STRING) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:95:12: index ( COMMA index )*
                    {
                    pushFollow(FOLLOW_index_in_indexes651);
                    index43=index();

                    state._fsp--;

                    stream_index.add(index43.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:95:18: ( COMMA index )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==COMMA) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:95:20: COMMA index
                    	    {
                    	    COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_indexes655);  
                    	    stream_COMMA.add(COMMA44);

                    	    pushFollow(FOLLOW_index_in_indexes657);
                    	    index45=index();

                    	    state._fsp--;

                    	    stream_index.add(index45.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            RANGLE46=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_indexes665);  
            stream_RANGLE.add(RANGLE46);



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
            // 95:45: -> ( index )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:95:48: ( index )*
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:100:1: index : ( NUMBER | STRING | IDENTIFIER );
    public final BigraphTermParser.index_return index() throws RecognitionException {
        BigraphTermParser.index_return retval = new BigraphTermParser.index_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set47=null;

        Object set47_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:101:1: ( NUMBER | STRING | IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set47=(Token)input.LT(1);
            if ( input.LA(1)==IDENTIFIER||input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set47));
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:106:1: tuple : index ( COMMA index )* -> ( index )* ;
    public final BigraphTermParser.tuple_return tuple() throws RecognitionException {
        BigraphTermParser.tuple_return retval = new BigraphTermParser.tuple_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA49=null;
        BigraphTermParser.index_return index48 = null;

        BigraphTermParser.index_return index50 = null;


        Object COMMA49_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:107:1: ( index ( COMMA index )* -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:107:3: index ( COMMA index )*
            {
            pushFollow(FOLLOW_index_in_tuple703);
            index48=index();

            state._fsp--;

            stream_index.add(index48.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:107:9: ( COMMA index )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:107:11: COMMA index
            	    {
            	    COMMA49=(Token)match(input,COMMA,FOLLOW_COMMA_in_tuple707);  
            	    stream_COMMA.add(COMMA49);

            	    pushFollow(FOLLOW_index_in_tuple709);
            	    index50=index();

            	    state._fsp--;

            	    stream_index.add(index50.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
            // 107:26: -> ( index )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:107:29: ( index )*
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:111:1: type : IDENTIFIER -> IDENTIFIER ;
    public final BigraphTermParser.type_return type() throws RecognitionException {
        BigraphTermParser.type_return retval = new BigraphTermParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER51=null;

        Object IDENTIFIER51_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:112:1: ( IDENTIFIER -> IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:112:3: IDENTIFIER
            {
            IDENTIFIER51=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type728);  
            stream_IDENTIFIER.add(IDENTIFIER51);



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
            // 112:14: -> IDENTIFIER
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

    public static class support_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "support"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:115:1: support : AT IDENTIFIER -> IDENTIFIER ;
    public final BigraphTermParser.support_return support() throws RecognitionException {
        BigraphTermParser.support_return retval = new BigraphTermParser.support_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AT52=null;
        Token IDENTIFIER53=null;

        Object AT52_tree=null;
        Object IDENTIFIER53_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:116:1: ( AT IDENTIFIER -> IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:116:3: AT IDENTIFIER
            {
            AT52=(Token)match(input,AT,FOLLOW_AT_in_support741);  
            stream_AT.add(AT52);

            IDENTIFIER53=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_support743);  
            stream_IDENTIFIER.add(IDENTIFIER53);



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
            // 116:17: -> IDENTIFIER
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
    // $ANTLR end "support"

    public static class ports_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ports"
    // src/bigraphspace/parser/antlr/BigraphTerm.g:119:1: ports : LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* ;
    public final BigraphTermParser.ports_return ports() throws RecognitionException {
        BigraphTermParser.ports_return retval = new BigraphTermParser.ports_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACE54=null;
        Token COMMA56=null;
        Token RBRACE58=null;
        BigraphTermParser.port_value_return port_value55 = null;

        BigraphTermParser.port_value_return port_value57 = null;


        Object LBRACE54_tree=null;
        Object COMMA56_tree=null;
        Object RBRACE58_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_port_value=new RewriteRuleSubtreeStream(adaptor,"rule port_value");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:1: ( LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:3: LBRACE ( port_value ( COMMA port_value )* )? RBRACE
            {
            LBRACE54=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_ports756);  
            stream_LBRACE.add(LBRACE54);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:10: ( port_value ( COMMA port_value )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDENTIFIER||LA22_0==NUMBER||LA22_0==STRING) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:12: port_value ( COMMA port_value )*
                    {
                    pushFollow(FOLLOW_port_value_in_ports760);
                    port_value55=port_value();

                    state._fsp--;

                    stream_port_value.add(port_value55.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:23: ( COMMA port_value )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==COMMA) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:25: COMMA port_value
                    	    {
                    	    COMMA56=(Token)match(input,COMMA,FOLLOW_COMMA_in_ports764);  
                    	    stream_COMMA.add(COMMA56);

                    	    pushFollow(FOLLOW_port_value_in_ports766);
                    	    port_value57=port_value();

                    	    state._fsp--;

                    	    stream_port_value.add(port_value57.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACE58=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_ports774);  
            stream_RBRACE.add(RBRACE58);



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
            // 120:55: -> ( port_value )*
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:120:58: ( port_value )*
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:123:1: port_value : ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) );
    public final BigraphTermParser.port_value_return port_value() throws RecognitionException {
        BigraphTermParser.port_value_return retval = new BigraphTermParser.port_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER59=null;
        Token EQUALS60=null;
        BigraphTermParser.link_name_return link_name61 = null;

        BigraphTermParser.link_name_return link_name62 = null;


        Object IDENTIFIER59_tree=null;
        Object EQUALS60_tree=null;
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:124:1: ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDENTIFIER) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==EQUALS) ) {
                    alt23=1;
                }
                else if ( (LA23_1==COMMA||LA23_1==RBRACE) ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==NUMBER||LA23_0==STRING) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:124:3: IDENTIFIER EQUALS link_name
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER59=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_port_value788); 
                    IDENTIFIER59_tree = (Object)adaptor.create(IDENTIFIER59);
                    root_0 = (Object)adaptor.becomeRoot(IDENTIFIER59_tree, root_0);

                    EQUALS60=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_port_value791); 
                    pushFollow(FOLLOW_link_name_in_port_value794);
                    link_name61=link_name();

                    state._fsp--;

                    adaptor.addChild(root_0, link_name61.getTree());

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:125:3: link_name
                    {
                    pushFollow(FOLLOW_link_name_in_port_value798);
                    link_name62=link_name();

                    state._fsp--;

                    stream_link_name.add(link_name62.getTree());


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
                    // 125:13: -> ^( UNNAMED link_name )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:125:16: ^( UNNAMED link_name )
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:128:1: link_name : ( IDENTIFIER | constant );
    public final BigraphTermParser.link_name_return link_name() throws RecognitionException {
        BigraphTermParser.link_name_return retval = new BigraphTermParser.link_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER63=null;
        BigraphTermParser.constant_return constant64 = null;


        Object IDENTIFIER63_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:129:1: ( IDENTIFIER | constant )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDENTIFIER) ) {
                alt24=1;
            }
            else if ( (LA24_0==NUMBER||LA24_0==STRING) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:129:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER63=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_link_name817); 
                    IDENTIFIER63_tree = (Object)adaptor.create(IDENTIFIER63);
                    adaptor.addChild(root_0, IDENTIFIER63_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:130:3: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_link_name821);
                    constant64=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant64.getTree());

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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:133:1: constant : ( NUMBER | STRING );
    public final BigraphTermParser.constant_return constant() throws RecognitionException {
        BigraphTermParser.constant_return retval = new BigraphTermParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set65=null;

        Object set65_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:134:1: ( NUMBER | STRING )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set65=(Token)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set65));
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:138:1: children : LPAREN prime RPAREN -> prime ;
    public final BigraphTermParser.children_return children() throws RecognitionException {
        BigraphTermParser.children_return retval = new BigraphTermParser.children_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN66=null;
        Token RPAREN68=null;
        BigraphTermParser.prime_return prime67 = null;


        Object LPAREN66_tree=null;
        Object RPAREN68_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:139:1: ( LPAREN prime RPAREN -> prime )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:139:3: LPAREN prime RPAREN
            {
            LPAREN66=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_children843);  
            stream_LPAREN.add(LPAREN66);

            pushFollow(FOLLOW_prime_in_children845);
            prime67=prime();

            state._fsp--;

            stream_prime.add(prime67.getTree());
            RPAREN68=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_children847);  
            stream_RPAREN.add(RPAREN68);



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
            // 139:23: -> prime
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:142:1: where : WHERE whereclause ( AND whereclause )* -> ^( WHERE ( whereclause )+ ) ;
    public final BigraphTermParser.where_return where() throws RecognitionException {
        BigraphTermParser.where_return retval = new BigraphTermParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE69=null;
        Token AND71=null;
        BigraphTermParser.whereclause_return whereclause70 = null;

        BigraphTermParser.whereclause_return whereclause72 = null;


        Object WHERE69_tree=null;
        Object AND71_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_whereclause=new RewriteRuleSubtreeStream(adaptor,"rule whereclause");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:143:1: ( WHERE whereclause ( AND whereclause )* -> ^( WHERE ( whereclause )+ ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:143:3: WHERE whereclause ( AND whereclause )*
            {
            WHERE69=(Token)match(input,WHERE,FOLLOW_WHERE_in_where860);  
            stream_WHERE.add(WHERE69);

            pushFollow(FOLLOW_whereclause_in_where862);
            whereclause70=whereclause();

            state._fsp--;

            stream_whereclause.add(whereclause70.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:143:21: ( AND whereclause )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==AND) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:143:23: AND whereclause
            	    {
            	    AND71=(Token)match(input,AND,FOLLOW_AND_in_where866);  
            	    stream_AND.add(AND71);

            	    pushFollow(FOLLOW_whereclause_in_where868);
            	    whereclause72=whereclause();

            	    state._fsp--;

            	    stream_whereclause.add(whereclause72.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);



            // AST REWRITE
            // elements: WHERE, whereclause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 143:42: -> ^( WHERE ( whereclause )+ )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:143:45: ^( WHERE ( whereclause )+ )
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:146:1: whereclause : ( IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type ) | IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* ) | IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* ) | IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER ) | IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER ) | IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING ) | i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER ) | i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER ) );
    public final BigraphTermParser.whereclause_return whereclause() throws RecognitionException {
        BigraphTermParser.whereclause_return retval = new BigraphTermParser.whereclause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token j=null;
        Token IDENTIFIER73=null;
        Token COLON74=null;
        Token IDENTIFIER76=null;
        Token NOT77=null;
        Token IN78=null;
        Token LBRACE79=null;
        Token COMMA81=null;
        Token RBRACE83=null;
        Token IDENTIFIER84=null;
        Token IN85=null;
        Token LBRACE86=null;
        Token COMMA88=null;
        Token RBRACE90=null;
        Token IDENTIFIER91=null;
        Token LESSTHANOREQUAL92=null;
        Token NUMBER93=null;
        Token IDENTIFIER94=null;
        Token GREATERTHANOREQUAL95=null;
        Token NUMBER96=null;
        Token LENGTH97=null;
        Token LPAREN98=null;
        Token IDENTIFIER99=null;
        Token RPAREN100=null;
        Token LESSTHANOREQUAL101=null;
        Token NUMBER102=null;
        Token LENGTH103=null;
        Token LPAREN104=null;
        Token IDENTIFIER105=null;
        Token RPAREN106=null;
        Token GREATERTHANOREQUAL107=null;
        Token NUMBER108=null;
        Token IDENTIFIER109=null;
        Token MATCHES110=null;
        Token STRING111=null;
        Token EQUALS112=null;
        Token PLUS113=null;
        Token NUMBER114=null;
        Token EQUALS115=null;
        Token MINUS116=null;
        Token NUMBER117=null;
        BigraphTermParser.type_return type75 = null;

        BigraphTermParser.index_return index80 = null;

        BigraphTermParser.index_return index82 = null;

        BigraphTermParser.index_return index87 = null;

        BigraphTermParser.index_return index89 = null;


        Object i_tree=null;
        Object j_tree=null;
        Object IDENTIFIER73_tree=null;
        Object COLON74_tree=null;
        Object IDENTIFIER76_tree=null;
        Object NOT77_tree=null;
        Object IN78_tree=null;
        Object LBRACE79_tree=null;
        Object COMMA81_tree=null;
        Object RBRACE83_tree=null;
        Object IDENTIFIER84_tree=null;
        Object IN85_tree=null;
        Object LBRACE86_tree=null;
        Object COMMA88_tree=null;
        Object RBRACE90_tree=null;
        Object IDENTIFIER91_tree=null;
        Object LESSTHANOREQUAL92_tree=null;
        Object NUMBER93_tree=null;
        Object IDENTIFIER94_tree=null;
        Object GREATERTHANOREQUAL95_tree=null;
        Object NUMBER96_tree=null;
        Object LENGTH97_tree=null;
        Object LPAREN98_tree=null;
        Object IDENTIFIER99_tree=null;
        Object RPAREN100_tree=null;
        Object LESSTHANOREQUAL101_tree=null;
        Object NUMBER102_tree=null;
        Object LENGTH103_tree=null;
        Object LPAREN104_tree=null;
        Object IDENTIFIER105_tree=null;
        Object RPAREN106_tree=null;
        Object GREATERTHANOREQUAL107_tree=null;
        Object NUMBER108_tree=null;
        Object IDENTIFIER109_tree=null;
        Object MATCHES110_tree=null;
        Object STRING111_tree=null;
        Object EQUALS112_tree=null;
        Object PLUS113_tree=null;
        Object NUMBER114_tree=null;
        Object EQUALS115_tree=null;
        Object MINUS116_tree=null;
        Object NUMBER117_tree=null;
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:147:1: ( IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type ) | IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* ) | IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* ) | IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER ) | IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER ) | IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING ) | i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER ) | i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER ) )
            int alt30=10;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:147:3: IDENTIFIER COLON type
                    {
                    IDENTIFIER73=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause891);  
                    stream_IDENTIFIER.add(IDENTIFIER73);

                    COLON74=(Token)match(input,COLON,FOLLOW_COLON_in_whereclause893);  
                    stream_COLON.add(COLON74);

                    pushFollow(FOLLOW_type_in_whereclause895);
                    type75=type();

                    state._fsp--;

                    stream_type.add(type75.getTree());


                    // AST REWRITE
                    // elements: COLON, IDENTIFIER, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 147:25: -> ^( CONSTRAINT IDENTIFIER COLON type )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:147:28: ^( CONSTRAINT IDENTIFIER COLON type )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:148:3: IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE
                    {
                    IDENTIFIER76=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause913);  
                    stream_IDENTIFIER.add(IDENTIFIER76);

                    NOT77=(Token)match(input,NOT,FOLLOW_NOT_in_whereclause915);  
                    stream_NOT.add(NOT77);

                    IN78=(Token)match(input,IN,FOLLOW_IN_in_whereclause917);  
                    stream_IN.add(IN78);

                    LBRACE79=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_whereclause919);  
                    stream_LBRACE.add(LBRACE79);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:148:28: ( index ( COMMA index )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==IDENTIFIER||LA27_0==NUMBER||LA27_0==STRING) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:148:30: index ( COMMA index )*
                            {
                            pushFollow(FOLLOW_index_in_whereclause923);
                            index80=index();

                            state._fsp--;

                            stream_index.add(index80.getTree());
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:148:36: ( COMMA index )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==COMMA) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:148:38: COMMA index
                            	    {
                            	    COMMA81=(Token)match(input,COMMA,FOLLOW_COMMA_in_whereclause927);  
                            	    stream_COMMA.add(COMMA81);

                            	    pushFollow(FOLLOW_index_in_whereclause929);
                            	    index82=index();

                            	    state._fsp--;

                            	    stream_index.add(index82.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop26;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RBRACE83=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_whereclause937);  
                    stream_RBRACE.add(RBRACE83);



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
                    // 148:63: -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:148:66: ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(NOTONEOF, "NOTONEOF"));
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:148:100: ( index )*
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:149:3: IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE
                    {
                    IDENTIFIER84=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause956);  
                    stream_IDENTIFIER.add(IDENTIFIER84);

                    IN85=(Token)match(input,IN,FOLLOW_IN_in_whereclause958);  
                    stream_IN.add(IN85);

                    LBRACE86=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_whereclause960);  
                    stream_LBRACE.add(LBRACE86);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:149:24: ( index ( COMMA index )* )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==IDENTIFIER||LA29_0==NUMBER||LA29_0==STRING) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:149:26: index ( COMMA index )*
                            {
                            pushFollow(FOLLOW_index_in_whereclause964);
                            index87=index();

                            state._fsp--;

                            stream_index.add(index87.getTree());
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:149:32: ( COMMA index )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==COMMA) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:149:34: COMMA index
                            	    {
                            	    COMMA88=(Token)match(input,COMMA,FOLLOW_COMMA_in_whereclause968);  
                            	    stream_COMMA.add(COMMA88);

                            	    pushFollow(FOLLOW_index_in_whereclause970);
                            	    index89=index();

                            	    state._fsp--;

                            	    stream_index.add(index89.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop28;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RBRACE90=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_whereclause978);  
                    stream_RBRACE.add(RBRACE90);



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
                    // 149:59: -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:149:62: ^( CONSTRAINT IDENTIFIER ONEOF ( index )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTRAINT, "CONSTRAINT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, (Object)adaptor.create(ONEOF, "ONEOF"));
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:149:93: ( index )*
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:150:3: IDENTIFIER LESSTHANOREQUAL NUMBER
                    {
                    IDENTIFIER91=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause997);  
                    stream_IDENTIFIER.add(IDENTIFIER91);

                    LESSTHANOREQUAL92=(Token)match(input,LESSTHANOREQUAL,FOLLOW_LESSTHANOREQUAL_in_whereclause999);  
                    stream_LESSTHANOREQUAL.add(LESSTHANOREQUAL92);

                    NUMBER93=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1001);  
                    stream_NUMBER.add(NUMBER93);



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
                    // 150:37: -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:150:40: ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:151:3: IDENTIFIER GREATERTHANOREQUAL NUMBER
                    {
                    IDENTIFIER94=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1019);  
                    stream_IDENTIFIER.add(IDENTIFIER94);

                    GREATERTHANOREQUAL95=(Token)match(input,GREATERTHANOREQUAL,FOLLOW_GREATERTHANOREQUAL_in_whereclause1021);  
                    stream_GREATERTHANOREQUAL.add(GREATERTHANOREQUAL95);

                    NUMBER96=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1023);  
                    stream_NUMBER.add(NUMBER96);



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
                    // 151:40: -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:151:43: ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:152:3: LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER
                    {
                    LENGTH97=(Token)match(input,LENGTH,FOLLOW_LENGTH_in_whereclause1041);  
                    stream_LENGTH.add(LENGTH97);

                    LPAREN98=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whereclause1043);  
                    stream_LPAREN.add(LPAREN98);

                    IDENTIFIER99=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1045);  
                    stream_IDENTIFIER.add(IDENTIFIER99);

                    RPAREN100=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whereclause1047);  
                    stream_RPAREN.add(RPAREN100);

                    LESSTHANOREQUAL101=(Token)match(input,LESSTHANOREQUAL,FOLLOW_LESSTHANOREQUAL_in_whereclause1049);  
                    stream_LESSTHANOREQUAL.add(LESSTHANOREQUAL101);

                    NUMBER102=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1051);  
                    stream_NUMBER.add(NUMBER102);



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
                    // 152:58: -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:152:61: ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:153:3: LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER
                    {
                    LENGTH103=(Token)match(input,LENGTH,FOLLOW_LENGTH_in_whereclause1069);  
                    stream_LENGTH.add(LENGTH103);

                    LPAREN104=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whereclause1071);  
                    stream_LPAREN.add(LPAREN104);

                    IDENTIFIER105=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1073);  
                    stream_IDENTIFIER.add(IDENTIFIER105);

                    RPAREN106=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whereclause1075);  
                    stream_RPAREN.add(RPAREN106);

                    GREATERTHANOREQUAL107=(Token)match(input,GREATERTHANOREQUAL,FOLLOW_GREATERTHANOREQUAL_in_whereclause1077);  
                    stream_GREATERTHANOREQUAL.add(GREATERTHANOREQUAL107);

                    NUMBER108=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1079);  
                    stream_NUMBER.add(NUMBER108);



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
                    // 153:61: -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:153:64: ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:154:3: IDENTIFIER MATCHES STRING
                    {
                    IDENTIFIER109=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1097);  
                    stream_IDENTIFIER.add(IDENTIFIER109);

                    MATCHES110=(Token)match(input,MATCHES,FOLLOW_MATCHES_in_whereclause1099);  
                    stream_MATCHES.add(MATCHES110);

                    STRING111=(Token)match(input,STRING,FOLLOW_STRING_in_whereclause1101);  
                    stream_STRING.add(STRING111);



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
                    // 154:29: -> ^( CONSTRAINT IDENTIFIER REGEXP STRING )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:154:32: ^( CONSTRAINT IDENTIFIER REGEXP STRING )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:155:3: i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER
                    {
                    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1121);  
                    stream_IDENTIFIER.add(i);

                    EQUALS112=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_whereclause1123);  
                    stream_EQUALS.add(EQUALS112);

                    j=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1127);  
                    stream_IDENTIFIER.add(j);

                    PLUS113=(Token)match(input,PLUS,FOLLOW_PLUS_in_whereclause1129);  
                    stream_PLUS.add(PLUS113);

                    NUMBER114=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1131);  
                    stream_NUMBER.add(NUMBER114);



                    // AST REWRITE
                    // elements: i, NUMBER, PLUS, j
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
                    // 155:48: -> ^( CONSTRAINT $i PLUS $j NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:155:51: ^( CONSTRAINT $i PLUS $j NUMBER )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:156:3: i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER
                    {
                    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1155);  
                    stream_IDENTIFIER.add(i);

                    EQUALS115=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_whereclause1157);  
                    stream_EQUALS.add(EQUALS115);

                    j=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1161);  
                    stream_IDENTIFIER.add(j);

                    MINUS116=(Token)match(input,MINUS,FOLLOW_MINUS_in_whereclause1163);  
                    stream_MINUS.add(MINUS116);

                    NUMBER117=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1165);  
                    stream_NUMBER.add(NUMBER117);



                    // AST REWRITE
                    // elements: NUMBER, j, MINUS, i
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
                    // 156:49: -> ^( CONSTRAINT $i MINUS $j NUMBER )
                    {
                        // src/bigraphspace/parser/antlr/BigraphTerm.g:156:52: ^( CONSTRAINT $i MINUS $j NUMBER )
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


    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA30_eotS =
        "\22\uffff";
    static final String DFA30_eofS =
        "\22\uffff";
    static final String DFA30_minS =
        "\1\12\1\10\1\60\6\uffff\2\41\1\64\1\61\2\uffff\1\62\2\uffff";
    static final String DFA30_maxS =
        "\1\41\1\63\1\60\6\uffff\2\41\1\65\1\61\2\uffff\1\63\2\uffff";
    static final String DFA30_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\10\4\uffff\1\11\1\12\1\uffff\1\6"+
        "\1\7";
    static final String DFA30_specialS =
        "\22\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\2\26\uffff\1\1",
            "\1\5\1\4\1\uffff\1\10\34\uffff\1\3\6\uffff\1\11\2\uffff\1"+
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

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "146:1: whereclause : ( IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type ) | IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* ) | IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* ) | IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER ) | IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER ) | IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING ) | i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER ) | i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER ) );";
        }
    }
 

    public static final BitSet FOLLOW_BIGRAPH_in_start260 = new BitSet(new long[]{0x0000086300000000L});
    public static final BitSet FOLLOW_closures_in_start263 = new BitSet(new long[]{0x0000086300000000L});
    public static final BitSet FOLLOW_wide_in_start265 = new BitSet(new long[]{0x0000000080000040L});
    public static final BitSet FOLLOW_substitutions_in_start267 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_in_start269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_start276 = new BitSet(new long[]{0x0000086300000000L});
    public static final BitSet FOLLOW_wide_in_start279 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ARROW_in_start281 = new BitSet(new long[]{0x0000086300000000L});
    public static final BitSet FOLLOW_wide_in_start284 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_closure_in_closures301 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_closures303 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_DOT_in_substitutions328 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_substitution_in_substitutions330 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_SLASH_in_closure353 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_closure355 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_COMMA_in_closure359 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_closure361 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_substitution388 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SLASH_in_substitution390 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_substitution396 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_COMMA_in_substitution400 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_substitution404 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_wide1_in_wide435 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_PIPE2_in_wide439 = new BitSet(new long[]{0x0000086300000000L});
    public static final BitSet FOLLOW_wide1_in_wide441 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_prime_in_wide1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prime1_in_prime487 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_PIPE_in_prime491 = new BitSet(new long[]{0x0000087200000000L});
    public static final BitSet FOLLOW_prime1_in_prime493 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_prime1510 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_NUMBER_in_prime1512 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RSQUARE_in_prime1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_prime1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_control_in_node547 = new BitSet(new long[]{0x0001300000000002L});
    public static final BitSet FOLLOW_support_in_node549 = new BitSet(new long[]{0x0001200000000002L});
    public static final BitSet FOLLOW_ports_in_node552 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_children_in_node555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_control602 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_COLON_in_control604 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_type_in_control606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_control622 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_indexes_in_control624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_indexes647 = new BitSet(new long[]{0x00000C4200000000L});
    public static final BitSet FOLLOW_index_in_indexes651 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_COMMA_in_indexes655 = new BitSet(new long[]{0x0000084200000000L});
    public static final BitSet FOLLOW_index_in_indexes657 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_RANGLE_in_indexes665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_index0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_index_in_tuple703 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_COMMA_in_tuple707 = new BitSet(new long[]{0x0000084200000000L});
    public static final BitSet FOLLOW_index_in_tuple709 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_support741 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_support743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_ports756 = new BitSet(new long[]{0x0000484200000000L});
    public static final BitSet FOLLOW_port_value_in_ports760 = new BitSet(new long[]{0x0000400400000000L});
    public static final BitSet FOLLOW_COMMA_in_ports764 = new BitSet(new long[]{0x0000084200000000L});
    public static final BitSet FOLLOW_port_value_in_ports766 = new BitSet(new long[]{0x0000400400000000L});
    public static final BitSet FOLLOW_RBRACE_in_ports774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_port_value788 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_EQUALS_in_port_value791 = new BitSet(new long[]{0x0000084200000000L});
    public static final BitSet FOLLOW_link_name_in_port_value794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_link_name_in_port_value798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_link_name817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_link_name821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_children843 = new BitSet(new long[]{0x0002086200000000L});
    public static final BitSet FOLLOW_prime_in_children845 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_children847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where860 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_whereclause_in_where862 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_AND_in_where866 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_whereclause_in_where868 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause891 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_COLON_in_whereclause893 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_type_in_whereclause895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause913 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NOT_in_whereclause915 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IN_in_whereclause917 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LBRACE_in_whereclause919 = new BitSet(new long[]{0x0000484200000000L});
    public static final BitSet FOLLOW_index_in_whereclause923 = new BitSet(new long[]{0x0000400400000000L});
    public static final BitSet FOLLOW_COMMA_in_whereclause927 = new BitSet(new long[]{0x0000084200000000L});
    public static final BitSet FOLLOW_index_in_whereclause929 = new BitSet(new long[]{0x0000400400000000L});
    public static final BitSet FOLLOW_RBRACE_in_whereclause937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause956 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IN_in_whereclause958 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LBRACE_in_whereclause960 = new BitSet(new long[]{0x0000484200000000L});
    public static final BitSet FOLLOW_index_in_whereclause964 = new BitSet(new long[]{0x0000400400000000L});
    public static final BitSet FOLLOW_COMMA_in_whereclause968 = new BitSet(new long[]{0x0000084200000000L});
    public static final BitSet FOLLOW_index_in_whereclause970 = new BitSet(new long[]{0x0000400400000000L});
    public static final BitSet FOLLOW_RBRACE_in_whereclause978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause997 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LESSTHANOREQUAL_in_whereclause999 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1019 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GREATERTHANOREQUAL_in_whereclause1021 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_in_whereclause1041 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_whereclause1043 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1045 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_whereclause1047 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LESSTHANOREQUAL_in_whereclause1049 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_in_whereclause1069 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_whereclause1071 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1073 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_whereclause1075 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GREATERTHANOREQUAL_in_whereclause1077 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1097 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_MATCHES_in_whereclause1099 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STRING_in_whereclause1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1121 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_EQUALS_in_whereclause1123 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1127 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_PLUS_in_whereclause1129 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1155 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_EQUALS_in_whereclause1157 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1161 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_MINUS_in_whereclause1163 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1165 = new BitSet(new long[]{0x0000000000000002L});

}