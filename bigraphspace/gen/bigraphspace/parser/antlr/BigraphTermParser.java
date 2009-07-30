// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/BigraphTerm.g 2009-07-30 19:57:12
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class BigraphTermParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGRAPH", "RULE", "WHERE", "AND", "IN", "NOT", "LENGTH", "MATCHES", "EMPTY", "PORTS", "CHILDREN", "ROOT", "UNNAMED", "CONTROL", "NODE", "ONEOF", "NOTONEOF", "CONSTRAINT", "MINLENGTH", "MAXLENGTH", "MINVALUE", "MAXVALUE", "REGEXP", "SUPPORT", "CLOSURES", "SUBSTITUTIONS", "ARROW", "STAR", "DOT", "SLASH", "IDENTIFIER", "COMMA", "PIPE2", "PIPE", "LSQUARE", "NUMBER", "RSQUARE", "COLON", "LANGLE", "RANGLE", "STRING", "AT", "LBRACE", "RBRACE", "EQUALS", "LPAREN", "RPAREN", "LESSTHANOREQUAL", "GREATERTHANOREQUAL", "PLUS", "MINUS", "UNDERSCORE", "DOLLAR", "AMPERSAND", "DIGIT", "NUMERAL", "STRING_ESCAPE", "LETTER", "WHITESPACE", "LINECOMMENT"
    };
    public static final int DOLLAR=56;
    public static final int WHERE=6;
    public static final int STAR=31;
    public static final int LSQUARE=38;
    public static final int STRING_ESCAPE=60;
    public static final int CHILDREN=14;
    public static final int LETTER=61;
    public static final int LANGLE=42;
    public static final int LBRACE=46;
    public static final int EQUALS=48;
    public static final int NOT=9;
    public static final int LINECOMMENT=63;
    public static final int BIGRAPH=4;
    public static final int AND=7;
    public static final int EOF=-1;
    public static final int LPAREN=49;
    public static final int LENGTH=10;
    public static final int AT=45;
    public static final int RPAREN=50;
    public static final int SLASH=33;
    public static final int IN=8;
    public static final int CLOSURES=28;
    public static final int MINVALUE=24;
    public static final int MATCHES=11;
    public static final int MAXVALUE=25;
    public static final int COMMA=35;
    public static final int IDENTIFIER=34;
    public static final int LESSTHANOREQUAL=51;
    public static final int REGEXP=26;
    public static final int PLUS=53;
    public static final int SUPPORT=27;
    public static final int PIPE=37;
    public static final int NOTONEOF=20;
    public static final int DIGIT=58;
    public static final int PIPE2=36;
    public static final int RANGLE=43;
    public static final int DOT=32;
    public static final int GREATERTHANOREQUAL=52;
    public static final int SUBSTITUTIONS=29;
    public static final int RBRACE=47;
    public static final int NODE=18;
    public static final int CONTROL=17;
    public static final int RULE=5;
    public static final int MINLENGTH=22;
    public static final int NUMBER=39;
    public static final int AMPERSAND=57;
    public static final int WHITESPACE=62;
    public static final int UNDERSCORE=55;
    public static final int MINUS=54;
    public static final int RSQUARE=40;
    public static final int ROOT=15;
    public static final int ONEOF=19;
    public static final int EMPTY=12;
    public static final int COLON=41;
    public static final int PORTS=13;
    public static final int UNNAMED=16;
    public static final int MAXLENGTH=23;
    public static final int ARROW=30;
    public static final int NUMERAL=59;
    public static final int CONSTRAINT=21;
    public static final int STRING=44;

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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:44:1: start : ( BIGRAPH ( closures )? wide ( substitutions )? ( where )? EOF | RULE wide ARROW wide EOF );
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:45:1: ( BIGRAPH ( closures )? wide ( substitutions )? ( where )? EOF | RULE wide ARROW wide EOF )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==BIGRAPH) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:45:3: BIGRAPH ( closures )? wide ( substitutions )? ( where )? EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    BIGRAPH1=(Token)match(input,BIGRAPH,FOLLOW_BIGRAPH_in_start260); 
                    BIGRAPH1_tree = (Object)adaptor.create(BIGRAPH1);
                    root_0 = (Object)adaptor.becomeRoot(BIGRAPH1_tree, root_0);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:45:12: ( closures )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SLASH) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:45:12: closures
                            {
                            pushFollow(FOLLOW_closures_in_start263);
                            closures2=closures();

                            state._fsp--;

                            adaptor.addChild(root_0, closures2.getTree());

                            }
                            break;

                    }

                    pushFollow(FOLLOW_wide_in_start266);
                    wide3=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide3.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:45:27: ( substitutions )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==DOT) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:45:27: substitutions
                            {
                            pushFollow(FOLLOW_substitutions_in_start268);
                            substitutions4=substitutions();

                            state._fsp--;

                            adaptor.addChild(root_0, substitutions4.getTree());

                            }
                            break;

                    }

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:45:42: ( where )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==WHERE) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:45:42: where
                            {
                            pushFollow(FOLLOW_where_in_start271);
                            where5=where();

                            state._fsp--;

                            adaptor.addChild(root_0, where5.getTree());

                            }
                            break;

                    }

                    EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_start274); 
                    EOF6_tree = (Object)adaptor.create(EOF6);
                    adaptor.addChild(root_0, EOF6_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:46:3: RULE wide ARROW wide EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    RULE7=(Token)match(input,RULE,FOLLOW_RULE_in_start278); 
                    RULE7_tree = (Object)adaptor.create(RULE7);
                    root_0 = (Object)adaptor.becomeRoot(RULE7_tree, root_0);

                    pushFollow(FOLLOW_wide_in_start281);
                    wide8=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide8.getTree());
                    ARROW9=(Token)match(input,ARROW,FOLLOW_ARROW_in_start283); 
                    pushFollow(FOLLOW_wide_in_start286);
                    wide10=wide();

                    state._fsp--;

                    adaptor.addChild(root_0, wide10.getTree());
                    EOF11=(Token)match(input,EOF,FOLLOW_EOF_in_start288); 
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:49:1: closures : ( closure STAR )* closure DOT -> ^( CLOSURES ( closure )+ ) ;
    public final BigraphTermParser.closures_return closures() throws RecognitionException {
        BigraphTermParser.closures_return retval = new BigraphTermParser.closures_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STAR13=null;
        Token DOT15=null;
        BigraphTermParser.closure_return closure12 = null;

        BigraphTermParser.closure_return closure14 = null;


        Object STAR13_tree=null;
        Object DOT15_tree=null;
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_closure=new RewriteRuleSubtreeStream(adaptor,"rule closure");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:50:1: ( ( closure STAR )* closure DOT -> ^( CLOSURES ( closure )+ ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:50:3: ( closure STAR )* closure DOT
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:50:3: ( closure STAR )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:50:5: closure STAR
            	    {
            	    pushFollow(FOLLOW_closure_in_closures303);
            	    closure12=closure();

            	    state._fsp--;

            	    stream_closure.add(closure12.getTree());
            	    STAR13=(Token)match(input,STAR,FOLLOW_STAR_in_closures305);  
            	    stream_STAR.add(STAR13);


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            pushFollow(FOLLOW_closure_in_closures310);
            closure14=closure();

            state._fsp--;

            stream_closure.add(closure14.getTree());
            DOT15=(Token)match(input,DOT,FOLLOW_DOT_in_closures312);  
            stream_DOT.add(DOT15);



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
            // 50:33: -> ^( CLOSURES ( closure )+ )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:50:36: ^( CLOSURES ( closure )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CLOSURES, "CLOSURES"), root_1);

                if ( !(stream_closure.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
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
    // src/bigraphspace/parser/antlr/BigraphTerm.g:53:1: substitutions : DOT substitution ( STAR substitution )* -> ^( SUBSTITUTIONS ( substitution )+ ) ;
    public final BigraphTermParser.substitutions_return substitutions() throws RecognitionException {
        BigraphTermParser.substitutions_return retval = new BigraphTermParser.substitutions_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOT16=null;
        Token STAR18=null;
        BigraphTermParser.substitution_return substitution17 = null;

        BigraphTermParser.substitution_return substitution19 = null;


        Object DOT16_tree=null;
        Object STAR18_tree=null;
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_substitution=new RewriteRuleSubtreeStream(adaptor,"rule substitution");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:54:1: ( DOT substitution ( STAR substitution )* -> ^( SUBSTITUTIONS ( substitution )+ ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:54:3: DOT substitution ( STAR substitution )*
            {
            DOT16=(Token)match(input,DOT,FOLLOW_DOT_in_substitutions332);  
            stream_DOT.add(DOT16);

            pushFollow(FOLLOW_substitution_in_substitutions334);
            substitution17=substitution();

            state._fsp--;

            stream_substitution.add(substitution17.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:54:20: ( STAR substitution )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==STAR) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:54:22: STAR substitution
            	    {
            	    STAR18=(Token)match(input,STAR,FOLLOW_STAR_in_substitutions338);  
            	    stream_STAR.add(STAR18);

            	    pushFollow(FOLLOW_substitution_in_substitutions340);
            	    substitution19=substitution();

            	    state._fsp--;

            	    stream_substitution.add(substitution19.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // 54:43: -> ^( SUBSTITUTIONS ( substitution )+ )
            {
                // src/bigraphspace/parser/antlr/BigraphTerm.g:54:46: ^( SUBSTITUTIONS ( substitution )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SUBSTITUTIONS, "SUBSTITUTIONS"), root_1);

                if ( !(stream_substitution.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
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

        Token SLASH20=null;
        Token IDENTIFIER21=null;
        Token COMMA22=null;
        Token IDENTIFIER23=null;

        Object SLASH20_tree=null;
        Object IDENTIFIER21_tree=null;
        Object COMMA22_tree=null;
        Object IDENTIFIER23_tree=null;
        RewriteRuleTokenStream stream_SLASH=new RewriteRuleTokenStream(adaptor,"token SLASH");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:58:1: ( SLASH IDENTIFIER ( COMMA IDENTIFIER )* -> ^( SLASH UNDERSCORE ( IDENTIFIER )+ ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:58:3: SLASH IDENTIFIER ( COMMA IDENTIFIER )*
            {
            SLASH20=(Token)match(input,SLASH,FOLLOW_SLASH_in_closure363);  
            stream_SLASH.add(SLASH20);

            IDENTIFIER21=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_closure365);  
            stream_IDENTIFIER.add(IDENTIFIER21);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:58:20: ( COMMA IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==COMMA) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:58:22: COMMA IDENTIFIER
            	    {
            	    COMMA22=(Token)match(input,COMMA,FOLLOW_COMMA_in_closure369);  
            	    stream_COMMA.add(COMMA22);

            	    IDENTIFIER23=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_closure371);  
            	    stream_IDENTIFIER.add(IDENTIFIER23);


            	    }
            	    break;

            	default :
            	    break loop7;
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
        Token SLASH24=null;
        Token COMMA25=null;
        Token r=null;
        List list_r=null;

        Object l_tree=null;
        Object SLASH24_tree=null;
        Object COMMA25_tree=null;
        Object r_tree=null;
        RewriteRuleTokenStream stream_SLASH=new RewriteRuleTokenStream(adaptor,"token SLASH");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:1: (l= IDENTIFIER SLASH (r+= IDENTIFIER ( COMMA r+= IDENTIFIER )* )? -> ^( SLASH $l ( $r)* ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:3: l= IDENTIFIER SLASH (r+= IDENTIFIER ( COMMA r+= IDENTIFIER )* )?
            {
            l=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_substitution398);  
            stream_IDENTIFIER.add(l);

            SLASH24=(Token)match(input,SLASH,FOLLOW_SLASH_in_substitution400);  
            stream_SLASH.add(SLASH24);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:62:22: (r+= IDENTIFIER ( COMMA r+= IDENTIFIER )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:24: r+= IDENTIFIER ( COMMA r+= IDENTIFIER )*
                    {
                    r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_substitution406);  
                    stream_IDENTIFIER.add(r);

                    if (list_r==null) list_r=new ArrayList();
                    list_r.add(r);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:38: ( COMMA r+= IDENTIFIER )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:62:40: COMMA r+= IDENTIFIER
                    	    {
                    	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_substitution410);  
                    	    stream_COMMA.add(COMMA25);

                    	    r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_substitution414);  
                    	    stream_IDENTIFIER.add(r);

                    	    if (list_r==null) list_r=new ArrayList();
                    	    list_r.add(r);


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }



            // AST REWRITE
            // elements: r, l, SLASH
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

        Token PIPE227=null;
        BigraphTermParser.wide1_return wide126 = null;

        BigraphTermParser.wide1_return wide128 = null;


        Object PIPE227_tree=null;
        RewriteRuleTokenStream stream_PIPE2=new RewriteRuleTokenStream(adaptor,"token PIPE2");
        RewriteRuleSubtreeStream stream_wide1=new RewriteRuleSubtreeStream(adaptor,"rule wide1");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:1: ( wide1 ( PIPE2 wide1 )* -> ( wide1 )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:3: wide1 ( PIPE2 wide1 )*
            {
            pushFollow(FOLLOW_wide1_in_wide445);
            wide126=wide1();

            state._fsp--;

            stream_wide1.add(wide126.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:67:9: ( PIPE2 wide1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==PIPE2) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:67:11: PIPE2 wide1
            	    {
            	    PIPE227=(Token)match(input,PIPE2,FOLLOW_PIPE2_in_wide449);  
            	    stream_PIPE2.add(PIPE227);

            	    pushFollow(FOLLOW_wide1_in_wide451);
            	    wide128=wide1();

            	    state._fsp--;

            	    stream_wide1.add(wide128.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
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

        BigraphTermParser.prime_return prime29 = null;


        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:1: ( prime -> ^( ROOT prime ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:71:3: prime
            {
            pushFollow(FOLLOW_prime_in_wide1468);
            prime29=prime();

            state._fsp--;

            stream_prime.add(prime29.getTree());


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

        Token PIPE31=null;
        BigraphTermParser.prime1_return prime130 = null;

        BigraphTermParser.prime1_return prime132 = null;


        Object PIPE31_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleSubtreeStream stream_prime1=new RewriteRuleSubtreeStream(adaptor,"rule prime1");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:75:1: ( -> ^( EMPTY ) | prime1 ( PIPE prime1 )* -> ( prime1 )+ )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==EOF||LA12_0==WHERE||LA12_0==ARROW||LA12_0==DOT||LA12_0==PIPE2||LA12_0==RPAREN) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENTIFIER||(LA12_0>=LSQUARE && LA12_0<=NUMBER)||LA12_0==STRING) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
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
                    pushFollow(FOLLOW_prime1_in_prime497);
                    prime130=prime1();

                    state._fsp--;

                    stream_prime1.add(prime130.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:76:10: ( PIPE prime1 )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==PIPE) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:76:12: PIPE prime1
                    	    {
                    	    PIPE31=(Token)match(input,PIPE,FOLLOW_PIPE_in_prime501);  
                    	    stream_PIPE.add(PIPE31);

                    	    pushFollow(FOLLOW_prime1_in_prime503);
                    	    prime132=prime1();

                    	    state._fsp--;

                    	    stream_prime1.add(prime132.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
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

        Token LSQUARE33=null;
        Token NUMBER34=null;
        Token RSQUARE35=null;
        BigraphTermParser.node_return node36 = null;


        Object LSQUARE33_tree=null;
        Object NUMBER34_tree=null;
        Object RSQUARE35_tree=null;
        RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
        RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleSubtreeStream stream_node=new RewriteRuleSubtreeStream(adaptor,"rule node");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:80:1: ( LSQUARE ( NUMBER )? RSQUARE -> ^( UNDERSCORE ( NUMBER )? ) | node -> ( node )+ )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LSQUARE) ) {
                alt14=1;
            }
            else if ( (LA14_0==IDENTIFIER||LA14_0==NUMBER||LA14_0==STRING) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:80:3: LSQUARE ( NUMBER )? RSQUARE
                    {
                    LSQUARE33=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_prime1520);  
                    stream_LSQUARE.add(LSQUARE33);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:80:11: ( NUMBER )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==NUMBER) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:80:11: NUMBER
                            {
                            NUMBER34=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_prime1522);  
                            stream_NUMBER.add(NUMBER34);


                            }
                            break;

                    }

                    RSQUARE35=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_prime1525);  
                    stream_RSQUARE.add(RSQUARE35);



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
                    pushFollow(FOLLOW_node_in_prime1540);
                    node36=node();

                    state._fsp--;

                    stream_node.add(node36.getTree());


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

        BigraphTermParser.control_return control37 = null;

        BigraphTermParser.support_return support38 = null;

        BigraphTermParser.ports_return ports39 = null;

        BigraphTermParser.children_return children40 = null;


        RewriteRuleSubtreeStream stream_control=new RewriteRuleSubtreeStream(adaptor,"rule control");
        RewriteRuleSubtreeStream stream_ports=new RewriteRuleSubtreeStream(adaptor,"rule ports");
        RewriteRuleSubtreeStream stream_support=new RewriteRuleSubtreeStream(adaptor,"rule support");
        RewriteRuleSubtreeStream stream_children=new RewriteRuleSubtreeStream(adaptor,"rule children");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:1: ( control ( support )? ( ports )? ( children )? -> ^( NODE control ^( SUPPORT ( support )? ) ^( PORTS ( ports )? ) ^( CHILDREN ( children )? ) ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:3: control ( support )? ( ports )? ( children )?
            {
            pushFollow(FOLLOW_control_in_node557);
            control37=control();

            state._fsp--;

            stream_control.add(control37.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:11: ( support )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==AT) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:86:11: support
                    {
                    pushFollow(FOLLOW_support_in_node559);
                    support38=support();

                    state._fsp--;

                    stream_support.add(support38.getTree());

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:20: ( ports )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LBRACE) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:86:20: ports
                    {
                    pushFollow(FOLLOW_ports_in_node562);
                    ports39=ports();

                    state._fsp--;

                    stream_ports.add(ports39.getTree());

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:86:27: ( children )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LPAREN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:86:27: children
                    {
                    pushFollow(FOLLOW_children_in_node565);
                    children40=children();

                    state._fsp--;

                    stream_children.add(children40.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ports, children, control, support
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

        Token COLON42=null;
        Token IDENTIFIER44=null;
        BigraphTermParser.tuple_return tuple41 = null;

        BigraphTermParser.type_return type43 = null;

        BigraphTermParser.indexes_return indexes45 = null;


        Object COLON42_tree=null;
        Object IDENTIFIER44_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_tuple=new RewriteRuleSubtreeStream(adaptor,"rule tuple");
        RewriteRuleSubtreeStream stream_indexes=new RewriteRuleSubtreeStream(adaptor,"rule indexes");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:90:1: ( tuple COLON type -> ^( CONTROL type tuple ) | IDENTIFIER ( indexes )? -> ^( CONTROL IDENTIFIER ( indexes )? ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENTIFIER) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==COMMA||LA19_1==COLON) ) {
                    alt19=1;
                }
                else if ( (LA19_1==EOF||LA19_1==WHERE||LA19_1==ARROW||LA19_1==DOT||(LA19_1>=PIPE2 && LA19_1<=PIPE)||LA19_1==LANGLE||(LA19_1>=AT && LA19_1<=LBRACE)||(LA19_1>=LPAREN && LA19_1<=RPAREN)) ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA19_0==NUMBER||LA19_0==STRING) ) {
                alt19=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:90:3: tuple COLON type
                    {
                    pushFollow(FOLLOW_tuple_in_control612);
                    tuple41=tuple();

                    state._fsp--;

                    stream_tuple.add(tuple41.getTree());
                    COLON42=(Token)match(input,COLON,FOLLOW_COLON_in_control614);  
                    stream_COLON.add(COLON42);

                    pushFollow(FOLLOW_type_in_control616);
                    type43=type();

                    state._fsp--;

                    stream_type.add(type43.getTree());


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
                    IDENTIFIER44=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_control632);  
                    stream_IDENTIFIER.add(IDENTIFIER44);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:91:14: ( indexes )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LANGLE) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:91:14: indexes
                            {
                            pushFollow(FOLLOW_indexes_in_control634);
                            indexes45=indexes();

                            state._fsp--;

                            stream_indexes.add(indexes45.getTree());

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

        Token LANGLE46=null;
        Token COMMA48=null;
        Token RANGLE50=null;
        BigraphTermParser.index_return index47 = null;

        BigraphTermParser.index_return index49 = null;


        Object LANGLE46_tree=null;
        Object COMMA48_tree=null;
        Object RANGLE50_tree=null;
        RewriteRuleTokenStream stream_RANGLE=new RewriteRuleTokenStream(adaptor,"token RANGLE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LANGLE=new RewriteRuleTokenStream(adaptor,"token LANGLE");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:1: ( LANGLE ( index ( COMMA index )* )? RANGLE -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:3: LANGLE ( index ( COMMA index )* )? RANGLE
            {
            LANGLE46=(Token)match(input,LANGLE,FOLLOW_LANGLE_in_indexes657);  
            stream_LANGLE.add(LANGLE46);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:10: ( index ( COMMA index )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDENTIFIER||LA21_0==NUMBER||LA21_0==STRING) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:95:12: index ( COMMA index )*
                    {
                    pushFollow(FOLLOW_index_in_indexes661);
                    index47=index();

                    state._fsp--;

                    stream_index.add(index47.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:95:18: ( COMMA index )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==COMMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:95:20: COMMA index
                    	    {
                    	    COMMA48=(Token)match(input,COMMA,FOLLOW_COMMA_in_indexes665);  
                    	    stream_COMMA.add(COMMA48);

                    	    pushFollow(FOLLOW_index_in_indexes667);
                    	    index49=index();

                    	    state._fsp--;

                    	    stream_index.add(index49.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            RANGLE50=(Token)match(input,RANGLE,FOLLOW_RANGLE_in_indexes675);  
            stream_RANGLE.add(RANGLE50);



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

        Token set51=null;

        Object set51_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:101:1: ( NUMBER | STRING | IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set51=(Token)input.LT(1);
            if ( input.LA(1)==IDENTIFIER||input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set51));
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

        Token COMMA53=null;
        BigraphTermParser.index_return index52 = null;

        BigraphTermParser.index_return index54 = null;


        Object COMMA53_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_index=new RewriteRuleSubtreeStream(adaptor,"rule index");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:107:1: ( index ( COMMA index )* -> ( index )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:107:3: index ( COMMA index )*
            {
            pushFollow(FOLLOW_index_in_tuple713);
            index52=index();

            state._fsp--;

            stream_index.add(index52.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:107:9: ( COMMA index )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:107:11: COMMA index
            	    {
            	    COMMA53=(Token)match(input,COMMA,FOLLOW_COMMA_in_tuple717);  
            	    stream_COMMA.add(COMMA53);

            	    pushFollow(FOLLOW_index_in_tuple719);
            	    index54=index();

            	    state._fsp--;

            	    stream_index.add(index54.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
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

        Token IDENTIFIER55=null;

        Object IDENTIFIER55_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:112:1: ( IDENTIFIER -> IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:112:3: IDENTIFIER
            {
            IDENTIFIER55=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type738);  
            stream_IDENTIFIER.add(IDENTIFIER55);



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

        Token AT56=null;
        Token IDENTIFIER57=null;

        Object AT56_tree=null;
        Object IDENTIFIER57_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:116:1: ( AT IDENTIFIER -> IDENTIFIER )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:116:3: AT IDENTIFIER
            {
            AT56=(Token)match(input,AT,FOLLOW_AT_in_support751);  
            stream_AT.add(AT56);

            IDENTIFIER57=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_support753);  
            stream_IDENTIFIER.add(IDENTIFIER57);



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

        Token LBRACE58=null;
        Token COMMA60=null;
        Token RBRACE62=null;
        BigraphTermParser.port_value_return port_value59 = null;

        BigraphTermParser.port_value_return port_value61 = null;


        Object LBRACE58_tree=null;
        Object COMMA60_tree=null;
        Object RBRACE62_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_port_value=new RewriteRuleSubtreeStream(adaptor,"rule port_value");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:1: ( LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> ( port_value )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:3: LBRACE ( port_value ( COMMA port_value )* )? RBRACE
            {
            LBRACE58=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_ports766);  
            stream_LBRACE.add(LBRACE58);

            // src/bigraphspace/parser/antlr/BigraphTerm.g:120:10: ( port_value ( COMMA port_value )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDENTIFIER||LA24_0==NUMBER||LA24_0==STRING) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:12: port_value ( COMMA port_value )*
                    {
                    pushFollow(FOLLOW_port_value_in_ports770);
                    port_value59=port_value();

                    state._fsp--;

                    stream_port_value.add(port_value59.getTree());
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:23: ( COMMA port_value )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==COMMA) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:120:25: COMMA port_value
                    	    {
                    	    COMMA60=(Token)match(input,COMMA,FOLLOW_COMMA_in_ports774);  
                    	    stream_COMMA.add(COMMA60);

                    	    pushFollow(FOLLOW_port_value_in_ports776);
                    	    port_value61=port_value();

                    	    state._fsp--;

                    	    stream_port_value.add(port_value61.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACE62=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_ports784);  
            stream_RBRACE.add(RBRACE62);



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

        Token IDENTIFIER63=null;
        Token EQUALS64=null;
        BigraphTermParser.link_name_return link_name65 = null;

        BigraphTermParser.link_name_return link_name66 = null;


        Object IDENTIFIER63_tree=null;
        Object EQUALS64_tree=null;
        RewriteRuleSubtreeStream stream_link_name=new RewriteRuleSubtreeStream(adaptor,"rule link_name");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:124:1: ( IDENTIFIER EQUALS link_name | link_name -> ^( UNNAMED link_name ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDENTIFIER) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==EQUALS) ) {
                    alt25=1;
                }
                else if ( (LA25_1==COMMA||LA25_1==RBRACE) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA25_0==NUMBER||LA25_0==STRING) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:124:3: IDENTIFIER EQUALS link_name
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER63=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_port_value798); 
                    IDENTIFIER63_tree = (Object)adaptor.create(IDENTIFIER63);
                    root_0 = (Object)adaptor.becomeRoot(IDENTIFIER63_tree, root_0);

                    EQUALS64=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_port_value801); 
                    pushFollow(FOLLOW_link_name_in_port_value804);
                    link_name65=link_name();

                    state._fsp--;

                    adaptor.addChild(root_0, link_name65.getTree());

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:125:3: link_name
                    {
                    pushFollow(FOLLOW_link_name_in_port_value808);
                    link_name66=link_name();

                    state._fsp--;

                    stream_link_name.add(link_name66.getTree());


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

        Token IDENTIFIER67=null;
        BigraphTermParser.constant_return constant68 = null;


        Object IDENTIFIER67_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:129:1: ( IDENTIFIER | constant )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==IDENTIFIER) ) {
                alt26=1;
            }
            else if ( (LA26_0==NUMBER||LA26_0==STRING) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:129:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER67=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_link_name827); 
                    IDENTIFIER67_tree = (Object)adaptor.create(IDENTIFIER67);
                    adaptor.addChild(root_0, IDENTIFIER67_tree);


                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:130:3: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_link_name831);
                    constant68=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant68.getTree());

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

        Token set69=null;

        Object set69_tree=null;

        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:134:1: ( NUMBER | STRING )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            root_0 = (Object)adaptor.nil();

            set69=(Token)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set69));
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

        Token LPAREN70=null;
        Token RPAREN72=null;
        BigraphTermParser.prime_return prime71 = null;


        Object LPAREN70_tree=null;
        Object RPAREN72_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_prime=new RewriteRuleSubtreeStream(adaptor,"rule prime");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:139:1: ( LPAREN prime RPAREN -> prime )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:139:3: LPAREN prime RPAREN
            {
            LPAREN70=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_children853);  
            stream_LPAREN.add(LPAREN70);

            pushFollow(FOLLOW_prime_in_children855);
            prime71=prime();

            state._fsp--;

            stream_prime.add(prime71.getTree());
            RPAREN72=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_children857);  
            stream_RPAREN.add(RPAREN72);



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

        Token WHERE73=null;
        Token AND75=null;
        BigraphTermParser.whereclause_return whereclause74 = null;

        BigraphTermParser.whereclause_return whereclause76 = null;


        Object WHERE73_tree=null;
        Object AND75_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_whereclause=new RewriteRuleSubtreeStream(adaptor,"rule whereclause");
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:143:1: ( WHERE whereclause ( AND whereclause )* -> ^( WHERE ( whereclause )+ ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:143:3: WHERE whereclause ( AND whereclause )*
            {
            WHERE73=(Token)match(input,WHERE,FOLLOW_WHERE_in_where870);  
            stream_WHERE.add(WHERE73);

            pushFollow(FOLLOW_whereclause_in_where872);
            whereclause74=whereclause();

            state._fsp--;

            stream_whereclause.add(whereclause74.getTree());
            // src/bigraphspace/parser/antlr/BigraphTerm.g:143:21: ( AND whereclause )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==AND) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:143:23: AND whereclause
            	    {
            	    AND75=(Token)match(input,AND,FOLLOW_AND_in_where876);  
            	    stream_AND.add(AND75);

            	    pushFollow(FOLLOW_whereclause_in_where878);
            	    whereclause76=whereclause();

            	    state._fsp--;

            	    stream_whereclause.add(whereclause76.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
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
        Token IDENTIFIER77=null;
        Token COLON78=null;
        Token IDENTIFIER80=null;
        Token NOT81=null;
        Token IN82=null;
        Token LBRACE83=null;
        Token COMMA85=null;
        Token RBRACE87=null;
        Token IDENTIFIER88=null;
        Token IN89=null;
        Token LBRACE90=null;
        Token COMMA92=null;
        Token RBRACE94=null;
        Token IDENTIFIER95=null;
        Token LESSTHANOREQUAL96=null;
        Token NUMBER97=null;
        Token IDENTIFIER98=null;
        Token GREATERTHANOREQUAL99=null;
        Token NUMBER100=null;
        Token LENGTH101=null;
        Token LPAREN102=null;
        Token IDENTIFIER103=null;
        Token RPAREN104=null;
        Token LESSTHANOREQUAL105=null;
        Token NUMBER106=null;
        Token LENGTH107=null;
        Token LPAREN108=null;
        Token IDENTIFIER109=null;
        Token RPAREN110=null;
        Token GREATERTHANOREQUAL111=null;
        Token NUMBER112=null;
        Token IDENTIFIER113=null;
        Token MATCHES114=null;
        Token STRING115=null;
        Token EQUALS116=null;
        Token PLUS117=null;
        Token NUMBER118=null;
        Token EQUALS119=null;
        Token MINUS120=null;
        Token NUMBER121=null;
        BigraphTermParser.type_return type79 = null;

        BigraphTermParser.index_return index84 = null;

        BigraphTermParser.index_return index86 = null;

        BigraphTermParser.index_return index91 = null;

        BigraphTermParser.index_return index93 = null;


        Object i_tree=null;
        Object j_tree=null;
        Object IDENTIFIER77_tree=null;
        Object COLON78_tree=null;
        Object IDENTIFIER80_tree=null;
        Object NOT81_tree=null;
        Object IN82_tree=null;
        Object LBRACE83_tree=null;
        Object COMMA85_tree=null;
        Object RBRACE87_tree=null;
        Object IDENTIFIER88_tree=null;
        Object IN89_tree=null;
        Object LBRACE90_tree=null;
        Object COMMA92_tree=null;
        Object RBRACE94_tree=null;
        Object IDENTIFIER95_tree=null;
        Object LESSTHANOREQUAL96_tree=null;
        Object NUMBER97_tree=null;
        Object IDENTIFIER98_tree=null;
        Object GREATERTHANOREQUAL99_tree=null;
        Object NUMBER100_tree=null;
        Object LENGTH101_tree=null;
        Object LPAREN102_tree=null;
        Object IDENTIFIER103_tree=null;
        Object RPAREN104_tree=null;
        Object LESSTHANOREQUAL105_tree=null;
        Object NUMBER106_tree=null;
        Object LENGTH107_tree=null;
        Object LPAREN108_tree=null;
        Object IDENTIFIER109_tree=null;
        Object RPAREN110_tree=null;
        Object GREATERTHANOREQUAL111_tree=null;
        Object NUMBER112_tree=null;
        Object IDENTIFIER113_tree=null;
        Object MATCHES114_tree=null;
        Object STRING115_tree=null;
        Object EQUALS116_tree=null;
        Object PLUS117_tree=null;
        Object NUMBER118_tree=null;
        Object EQUALS119_tree=null;
        Object MINUS120_tree=null;
        Object NUMBER121_tree=null;
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
            int alt32=10;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:147:3: IDENTIFIER COLON type
                    {
                    IDENTIFIER77=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause901);  
                    stream_IDENTIFIER.add(IDENTIFIER77);

                    COLON78=(Token)match(input,COLON,FOLLOW_COLON_in_whereclause903);  
                    stream_COLON.add(COLON78);

                    pushFollow(FOLLOW_type_in_whereclause905);
                    type79=type();

                    state._fsp--;

                    stream_type.add(type79.getTree());


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
                    IDENTIFIER80=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause923);  
                    stream_IDENTIFIER.add(IDENTIFIER80);

                    NOT81=(Token)match(input,NOT,FOLLOW_NOT_in_whereclause925);  
                    stream_NOT.add(NOT81);

                    IN82=(Token)match(input,IN,FOLLOW_IN_in_whereclause927);  
                    stream_IN.add(IN82);

                    LBRACE83=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_whereclause929);  
                    stream_LBRACE.add(LBRACE83);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:148:28: ( index ( COMMA index )* )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==IDENTIFIER||LA29_0==NUMBER||LA29_0==STRING) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:148:30: index ( COMMA index )*
                            {
                            pushFollow(FOLLOW_index_in_whereclause933);
                            index84=index();

                            state._fsp--;

                            stream_index.add(index84.getTree());
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:148:36: ( COMMA index )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==COMMA) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:148:38: COMMA index
                            	    {
                            	    COMMA85=(Token)match(input,COMMA,FOLLOW_COMMA_in_whereclause937);  
                            	    stream_COMMA.add(COMMA85);

                            	    pushFollow(FOLLOW_index_in_whereclause939);
                            	    index86=index();

                            	    state._fsp--;

                            	    stream_index.add(index86.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop28;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RBRACE87=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_whereclause947);  
                    stream_RBRACE.add(RBRACE87);



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
                    IDENTIFIER88=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause966);  
                    stream_IDENTIFIER.add(IDENTIFIER88);

                    IN89=(Token)match(input,IN,FOLLOW_IN_in_whereclause968);  
                    stream_IN.add(IN89);

                    LBRACE90=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_whereclause970);  
                    stream_LBRACE.add(LBRACE90);

                    // src/bigraphspace/parser/antlr/BigraphTerm.g:149:24: ( index ( COMMA index )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==IDENTIFIER||LA31_0==NUMBER||LA31_0==STRING) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:149:26: index ( COMMA index )*
                            {
                            pushFollow(FOLLOW_index_in_whereclause974);
                            index91=index();

                            state._fsp--;

                            stream_index.add(index91.getTree());
                            // src/bigraphspace/parser/antlr/BigraphTerm.g:149:32: ( COMMA index )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:149:34: COMMA index
                            	    {
                            	    COMMA92=(Token)match(input,COMMA,FOLLOW_COMMA_in_whereclause978);  
                            	    stream_COMMA.add(COMMA92);

                            	    pushFollow(FOLLOW_index_in_whereclause980);
                            	    index93=index();

                            	    state._fsp--;

                            	    stream_index.add(index93.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop30;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RBRACE94=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_whereclause988);  
                    stream_RBRACE.add(RBRACE94);



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
                    IDENTIFIER95=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1007);  
                    stream_IDENTIFIER.add(IDENTIFIER95);

                    LESSTHANOREQUAL96=(Token)match(input,LESSTHANOREQUAL,FOLLOW_LESSTHANOREQUAL_in_whereclause1009);  
                    stream_LESSTHANOREQUAL.add(LESSTHANOREQUAL96);

                    NUMBER97=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1011);  
                    stream_NUMBER.add(NUMBER97);



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
                    IDENTIFIER98=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1029);  
                    stream_IDENTIFIER.add(IDENTIFIER98);

                    GREATERTHANOREQUAL99=(Token)match(input,GREATERTHANOREQUAL,FOLLOW_GREATERTHANOREQUAL_in_whereclause1031);  
                    stream_GREATERTHANOREQUAL.add(GREATERTHANOREQUAL99);

                    NUMBER100=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1033);  
                    stream_NUMBER.add(NUMBER100);



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
                    LENGTH101=(Token)match(input,LENGTH,FOLLOW_LENGTH_in_whereclause1051);  
                    stream_LENGTH.add(LENGTH101);

                    LPAREN102=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whereclause1053);  
                    stream_LPAREN.add(LPAREN102);

                    IDENTIFIER103=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1055);  
                    stream_IDENTIFIER.add(IDENTIFIER103);

                    RPAREN104=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whereclause1057);  
                    stream_RPAREN.add(RPAREN104);

                    LESSTHANOREQUAL105=(Token)match(input,LESSTHANOREQUAL,FOLLOW_LESSTHANOREQUAL_in_whereclause1059);  
                    stream_LESSTHANOREQUAL.add(LESSTHANOREQUAL105);

                    NUMBER106=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1061);  
                    stream_NUMBER.add(NUMBER106);



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
                    LENGTH107=(Token)match(input,LENGTH,FOLLOW_LENGTH_in_whereclause1079);  
                    stream_LENGTH.add(LENGTH107);

                    LPAREN108=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whereclause1081);  
                    stream_LPAREN.add(LPAREN108);

                    IDENTIFIER109=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1083);  
                    stream_IDENTIFIER.add(IDENTIFIER109);

                    RPAREN110=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whereclause1085);  
                    stream_RPAREN.add(RPAREN110);

                    GREATERTHANOREQUAL111=(Token)match(input,GREATERTHANOREQUAL,FOLLOW_GREATERTHANOREQUAL_in_whereclause1087);  
                    stream_GREATERTHANOREQUAL.add(GREATERTHANOREQUAL111);

                    NUMBER112=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1089);  
                    stream_NUMBER.add(NUMBER112);



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
                    IDENTIFIER113=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1107);  
                    stream_IDENTIFIER.add(IDENTIFIER113);

                    MATCHES114=(Token)match(input,MATCHES,FOLLOW_MATCHES_in_whereclause1109);  
                    stream_MATCHES.add(MATCHES114);

                    STRING115=(Token)match(input,STRING,FOLLOW_STRING_in_whereclause1111);  
                    stream_STRING.add(STRING115);



                    // AST REWRITE
                    // elements: STRING, IDENTIFIER
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
                    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1131);  
                    stream_IDENTIFIER.add(i);

                    EQUALS116=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_whereclause1133);  
                    stream_EQUALS.add(EQUALS116);

                    j=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1137);  
                    stream_IDENTIFIER.add(j);

                    PLUS117=(Token)match(input,PLUS,FOLLOW_PLUS_in_whereclause1139);  
                    stream_PLUS.add(PLUS117);

                    NUMBER118=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1141);  
                    stream_NUMBER.add(NUMBER118);



                    // AST REWRITE
                    // elements: NUMBER, j, i, PLUS
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
                    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1165);  
                    stream_IDENTIFIER.add(i);

                    EQUALS119=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_whereclause1167);  
                    stream_EQUALS.add(EQUALS119);

                    j=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_whereclause1171);  
                    stream_IDENTIFIER.add(j);

                    MINUS120=(Token)match(input,MINUS,FOLLOW_MINUS_in_whereclause1173);  
                    stream_MINUS.add(MINUS120);

                    NUMBER121=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whereclause1175);  
                    stream_NUMBER.add(NUMBER121);



                    // AST REWRITE
                    // elements: MINUS, NUMBER, j, i
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


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA5_eotS =
        "\7\uffff";
    static final String DFA5_eofS =
        "\7\uffff";
    static final String DFA5_minS =
        "\1\41\1\42\1\37\1\42\2\uffff\1\37";
    static final String DFA5_maxS =
        "\1\41\1\42\1\43\1\42\2\uffff\1\43";
    static final String DFA5_acceptS =
        "\4\uffff\1\2\1\1\1\uffff";
    static final String DFA5_specialS =
        "\7\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2",
            "\1\5\1\4\2\uffff\1\3",
            "\1\6",
            "",
            "",
            "\1\5\1\4\2\uffff\1\3"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 50:3: ( closure STAR )*";
        }
    }
    static final String DFA32_eotS =
        "\22\uffff";
    static final String DFA32_eofS =
        "\22\uffff";
    static final String DFA32_minS =
        "\1\12\1\10\1\61\6\uffff\2\42\1\65\1\62\2\uffff\1\63\2\uffff";
    static final String DFA32_maxS =
        "\1\42\1\64\1\61\6\uffff\2\42\1\66\1\62\2\uffff\1\64\2\uffff";
    static final String DFA32_acceptS =
        "\3\uffff\1\1\1\2\1\3\1\4\1\5\1\10\4\uffff\1\11\1\12\1\uffff\1\6"+
        "\1\7";
    static final String DFA32_specialS =
        "\22\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\2\27\uffff\1\1",
            "\1\5\1\4\1\uffff\1\10\35\uffff\1\3\6\uffff\1\11\2\uffff\1"+
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

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "146:1: whereclause : ( IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type ) | IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF ( index )* ) | IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF ( index )* ) | IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER ) | IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER ) | LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER ) | IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING ) | i= IDENTIFIER EQUALS j= IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER ) | i= IDENTIFIER EQUALS j= IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER ) );";
        }
    }
 

    public static final BitSet FOLLOW_BIGRAPH_in_start260 = new BitSet(new long[]{0x000010C600000000L});
    public static final BitSet FOLLOW_closures_in_start263 = new BitSet(new long[]{0x000010C600000000L});
    public static final BitSet FOLLOW_wide_in_start266 = new BitSet(new long[]{0x0000000100000040L});
    public static final BitSet FOLLOW_substitutions_in_start268 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_where_in_start271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_start278 = new BitSet(new long[]{0x000010C600000000L});
    public static final BitSet FOLLOW_wide_in_start281 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ARROW_in_start283 = new BitSet(new long[]{0x000010C600000000L});
    public static final BitSet FOLLOW_wide_in_start286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_closure_in_closures303 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_STAR_in_closures305 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_closure_in_closures310 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_DOT_in_closures312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_substitutions332 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_substitution_in_substitutions334 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_STAR_in_substitutions338 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_substitution_in_substitutions340 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_SLASH_in_closure363 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_closure365 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_closure369 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_closure371 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_substitution398 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_SLASH_in_substitution400 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_substitution406 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_substitution410 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_substitution414 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_wide1_in_wide445 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_PIPE2_in_wide449 = new BitSet(new long[]{0x000010C600000000L});
    public static final BitSet FOLLOW_wide1_in_wide451 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_prime_in_wide1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prime1_in_prime497 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_PIPE_in_prime501 = new BitSet(new long[]{0x000010E400000000L});
    public static final BitSet FOLLOW_prime1_in_prime503 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_prime1520 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_NUMBER_in_prime1522 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RSQUARE_in_prime1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_node_in_prime1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_control_in_node557 = new BitSet(new long[]{0x0002600000000002L});
    public static final BitSet FOLLOW_support_in_node559 = new BitSet(new long[]{0x0002400000000002L});
    public static final BitSet FOLLOW_ports_in_node562 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_children_in_node565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_control612 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_COLON_in_control614 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_type_in_control616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_control632 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_indexes_in_control634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_indexes657 = new BitSet(new long[]{0x0000188400000000L});
    public static final BitSet FOLLOW_index_in_indexes661 = new BitSet(new long[]{0x0000080800000000L});
    public static final BitSet FOLLOW_COMMA_in_indexes665 = new BitSet(new long[]{0x0000108400000000L});
    public static final BitSet FOLLOW_index_in_indexes667 = new BitSet(new long[]{0x0000080800000000L});
    public static final BitSet FOLLOW_RANGLE_in_indexes675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_index0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_index_in_tuple713 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_tuple717 = new BitSet(new long[]{0x0000108400000000L});
    public static final BitSet FOLLOW_index_in_tuple719 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_support751 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_support753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_ports766 = new BitSet(new long[]{0x0000908400000000L});
    public static final BitSet FOLLOW_port_value_in_ports770 = new BitSet(new long[]{0x0000800800000000L});
    public static final BitSet FOLLOW_COMMA_in_ports774 = new BitSet(new long[]{0x0000108400000000L});
    public static final BitSet FOLLOW_port_value_in_ports776 = new BitSet(new long[]{0x0000800800000000L});
    public static final BitSet FOLLOW_RBRACE_in_ports784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_port_value798 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_EQUALS_in_port_value801 = new BitSet(new long[]{0x0000108400000000L});
    public static final BitSet FOLLOW_link_name_in_port_value804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_link_name_in_port_value808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_link_name827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_link_name831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_children853 = new BitSet(new long[]{0x000410C400000000L});
    public static final BitSet FOLLOW_prime_in_children855 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_children857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where870 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_whereclause_in_where872 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_AND_in_where876 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_whereclause_in_where878 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause901 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_COLON_in_whereclause903 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_type_in_whereclause905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause923 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NOT_in_whereclause925 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IN_in_whereclause927 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_LBRACE_in_whereclause929 = new BitSet(new long[]{0x0000908400000000L});
    public static final BitSet FOLLOW_index_in_whereclause933 = new BitSet(new long[]{0x0000800800000000L});
    public static final BitSet FOLLOW_COMMA_in_whereclause937 = new BitSet(new long[]{0x0000108400000000L});
    public static final BitSet FOLLOW_index_in_whereclause939 = new BitSet(new long[]{0x0000800800000000L});
    public static final BitSet FOLLOW_RBRACE_in_whereclause947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause966 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IN_in_whereclause968 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_LBRACE_in_whereclause970 = new BitSet(new long[]{0x0000908400000000L});
    public static final BitSet FOLLOW_index_in_whereclause974 = new BitSet(new long[]{0x0000800800000000L});
    public static final BitSet FOLLOW_COMMA_in_whereclause978 = new BitSet(new long[]{0x0000108400000000L});
    public static final BitSet FOLLOW_index_in_whereclause980 = new BitSet(new long[]{0x0000800800000000L});
    public static final BitSet FOLLOW_RBRACE_in_whereclause988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1007 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LESSTHANOREQUAL_in_whereclause1009 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1029 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_GREATERTHANOREQUAL_in_whereclause1031 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_in_whereclause1051 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_whereclause1053 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1055 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_whereclause1057 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LESSTHANOREQUAL_in_whereclause1059 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_in_whereclause1079 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_whereclause1081 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1083 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_whereclause1085 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_GREATERTHANOREQUAL_in_whereclause1087 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1107 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_MATCHES_in_whereclause1109 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_STRING_in_whereclause1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1131 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_EQUALS_in_whereclause1133 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1137 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PLUS_in_whereclause1139 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1165 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_EQUALS_in_whereclause1167 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_whereclause1171 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_MINUS_in_whereclause1173 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_NUMBER_in_whereclause1175 = new BitSet(new long[]{0x0000000000000002L});

}