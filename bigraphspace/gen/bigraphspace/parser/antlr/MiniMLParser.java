// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/MiniML.g 2009-07-28 14:18:01
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class MiniMLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMICOLON", "LPAREN", "RPAREN", "COMMA", "LET", "END", "IN", "FN", "AND", "UNDERSCORE", "VAL", "PIPE", "DOT", "APPLY", "IMPLIES", "IDENTIFIER", "NUMBER", "STRING", "EQUALS", "DIGIT", "NUMERAL", "STRING_ESCAPE", "LETTER", "WHITESPACE"
    };
    public static final int APPLY=17;
    public static final int IMPLIES=18;
    public static final int STRING_ESCAPE=25;
    public static final int LETTER=26;
    public static final int NUMBER=20;
    public static final int WHITESPACE=27;
    public static final int UNDERSCORE=13;
    public static final int EQUALS=22;
    public static final int SEMICOLON=4;
    public static final int FN=11;
    public static final int AND=12;
    public static final int EOF=-1;
    public static final int LPAREN=5;
    public static final int RPAREN=6;
    public static final int IN=10;
    public static final int COMMA=7;
    public static final int IDENTIFIER=19;
    public static final int VAL=14;
    public static final int NUMERAL=24;
    public static final int PIPE=15;
    public static final int DIGIT=23;
    public static final int END=9;
    public static final int DOT=16;
    public static final int LET=8;
    public static final int STRING=21;

    // delegates
    // delegators


        public MiniMLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MiniMLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MiniMLParser.tokenNames; }
    public String getGrammarFileName() { return "src/bigraphspace/parser/antlr/MiniML.g"; }


    public static class start_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // src/bigraphspace/parser/antlr/MiniML.g:30:1: start : p EOF ;
    public final MiniMLParser.start_return start() throws RecognitionException {
        MiniMLParser.start_return retval = new MiniMLParser.start_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF2=null;
        MiniMLParser.p_return p1 = null;


        Object EOF2_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:31:5: ( p EOF )
            // src/bigraphspace/parser/antlr/MiniML.g:31:7: p EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_p_in_start166);
            p1=p();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(p1.getTree(), root_0);
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_start169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF2_tree = (Object)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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

    public static class p_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "p"
    // src/bigraphspace/parser/antlr/MiniML.g:34:1: p : ( tld ( SEMICOLON tld )* SEMICOLON ) ;
    public final MiniMLParser.p_return p() throws RecognitionException {
        MiniMLParser.p_return retval = new MiniMLParser.p_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMICOLON4=null;
        Token SEMICOLON6=null;
        MiniMLParser.tld_return tld3 = null;

        MiniMLParser.tld_return tld5 = null;


        Object SEMICOLON4_tree=null;
        Object SEMICOLON6_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:34:4: ( ( tld ( SEMICOLON tld )* SEMICOLON ) )
            // src/bigraphspace/parser/antlr/MiniML.g:34:6: ( tld ( SEMICOLON tld )* SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            // src/bigraphspace/parser/antlr/MiniML.g:34:6: ( tld ( SEMICOLON tld )* SEMICOLON )
            // src/bigraphspace/parser/antlr/MiniML.g:34:8: tld ( SEMICOLON tld )* SEMICOLON
            {
            pushFollow(FOLLOW_tld_in_p190);
            tld3=tld();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tld3.getTree());
            // src/bigraphspace/parser/antlr/MiniML.g:34:12: ( SEMICOLON tld )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==SEMICOLON) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==LPAREN||LA1_1==LET||LA1_1==FN||(LA1_1>=IDENTIFIER && LA1_1<=STRING)) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/MiniML.g:34:13: SEMICOLON tld
            	    {
            	    SEMICOLON4=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_p193); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    SEMICOLON4_tree = (Object)adaptor.create(SEMICOLON4);
            	    root_0 = (Object)adaptor.becomeRoot(SEMICOLON4_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_tld_in_p196);
            	    tld5=tld();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tld5.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            SEMICOLON6=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_p200); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON6_tree = (Object)adaptor.create(SEMICOLON6);
            root_0 = (Object)adaptor.becomeRoot(SEMICOLON6_tree, root_0);
            }

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "p"

    public static class tld_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tld"
    // src/bigraphspace/parser/antlr/MiniML.g:37:1: tld : expression ;
    public final MiniMLParser.tld_return tld() throws RecognitionException {
        MiniMLParser.tld_return retval = new MiniMLParser.tld_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        MiniMLParser.expression_return expression7 = null;



        try {
            // src/bigraphspace/parser/antlr/MiniML.g:37:5: ( expression )
            // src/bigraphspace/parser/antlr/MiniML.g:37:7: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_tld215);
            expression7=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression7.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "tld"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // src/bigraphspace/parser/antlr/MiniML.g:40:1: expression : ( infix_expression | FN match );
    public final MiniMLParser.expression_return expression() throws RecognitionException {
        MiniMLParser.expression_return retval = new MiniMLParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FN9=null;
        MiniMLParser.infix_expression_return infix_expression8 = null;

        MiniMLParser.match_return match10 = null;


        Object FN9_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:41:4: ( infix_expression | FN match )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LPAREN||LA2_0==LET||(LA2_0>=IDENTIFIER && LA2_0<=STRING)) ) {
                alt2=1;
            }
            else if ( (LA2_0==FN) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:41:6: infix_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_infix_expression_in_expression230);
                    infix_expression8=infix_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, infix_expression8.getTree());

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/MiniML.g:42:7: FN match
                    {
                    root_0 = (Object)adaptor.nil();

                    FN9=(Token)match(input,FN,FOLLOW_FN_in_expression239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FN9_tree = (Object)adaptor.create(FN9);
                    root_0 = (Object)adaptor.becomeRoot(FN9_tree, root_0);
                    }
                    pushFollow(FOLLOW_match_in_expression242);
                    match10=match();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, match10.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "expression"

    public static class match_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "match"
    // src/bigraphspace/parser/antlr/MiniML.g:45:1: match : pattern IMPLIES expression ;
    public final MiniMLParser.match_return match() throws RecognitionException {
        MiniMLParser.match_return retval = new MiniMLParser.match_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IMPLIES12=null;
        MiniMLParser.pattern_return pattern11 = null;

        MiniMLParser.expression_return expression13 = null;


        Object IMPLIES12_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:46:5: ( pattern IMPLIES expression )
            // src/bigraphspace/parser/antlr/MiniML.g:46:7: pattern IMPLIES expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pattern_in_match261);
            pattern11=pattern();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pattern11.getTree());
            IMPLIES12=(Token)match(input,IMPLIES,FOLLOW_IMPLIES_in_match263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IMPLIES12_tree = (Object)adaptor.create(IMPLIES12);
            root_0 = (Object)adaptor.becomeRoot(IMPLIES12_tree, root_0);
            }
            pushFollow(FOLLOW_expression_in_match266);
            expression13=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression13.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "match"

    public static class infix_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "infix_expression"
    // src/bigraphspace/parser/antlr/MiniML.g:49:1: infix_expression options {backtrack=true; } : ( atomic_expression ( atomic_expression )+ -> ^( APPLY ( atomic_expression )* ) | atomic_expression );
    public final MiniMLParser.infix_expression_return infix_expression() throws RecognitionException {
        MiniMLParser.infix_expression_return retval = new MiniMLParser.infix_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        MiniMLParser.atomic_expression_return atomic_expression14 = null;

        MiniMLParser.atomic_expression_return atomic_expression15 = null;

        MiniMLParser.atomic_expression_return atomic_expression16 = null;


        RewriteRuleSubtreeStream stream_atomic_expression=new RewriteRuleSubtreeStream(adaptor,"rule atomic_expression");
        try {
            // src/bigraphspace/parser/antlr/MiniML.g:51:2: ( atomic_expression ( atomic_expression )+ -> ^( APPLY ( atomic_expression )* ) | atomic_expression )
            int alt4=2;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA4_1 = input.LA(2);

                if ( (synpred1_MiniML()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
                }
                break;
            case NUMBER:
                {
                int LA4_2 = input.LA(2);

                if ( (synpred1_MiniML()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case STRING:
                {
                int LA4_3 = input.LA(2);

                if ( (synpred1_MiniML()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            case LET:
                {
                int LA4_4 = input.LA(2);

                if ( (synpred1_MiniML()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 4, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                int LA4_5 = input.LA(2);

                if ( (synpred1_MiniML()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:51:4: atomic_expression ( atomic_expression )+
                    {
                    pushFollow(FOLLOW_atomic_expression_in_infix_expression293);
                    atomic_expression14=atomic_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomic_expression.add(atomic_expression14.getTree());
                    // src/bigraphspace/parser/antlr/MiniML.g:51:22: ( atomic_expression )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==LPAREN||LA3_0==LET||(LA3_0>=IDENTIFIER && LA3_0<=STRING)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/MiniML.g:51:22: atomic_expression
                    	    {
                    	    pushFollow(FOLLOW_atomic_expression_in_infix_expression295);
                    	    atomic_expression15=atomic_expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atomic_expression.add(atomic_expression15.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);



                    // AST REWRITE
                    // elements: atomic_expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 51:41: -> ^( APPLY ( atomic_expression )* )
                    {
                        // src/bigraphspace/parser/antlr/MiniML.g:51:44: ^( APPLY ( atomic_expression )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(APPLY, "APPLY"), root_1);

                        // src/bigraphspace/parser/antlr/MiniML.g:51:53: ( atomic_expression )*
                        while ( stream_atomic_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_atomic_expression.nextTree());

                        }
                        stream_atomic_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/MiniML.g:52:4: atomic_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atomic_expression_in_infix_expression312);
                    atomic_expression16=atomic_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic_expression16.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "infix_expression"

    public static class atomic_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atomic_expression"
    // src/bigraphspace/parser/antlr/MiniML.g:59:1: atomic_expression : ( IDENTIFIER | constant | LET declaration IN expression ( SEMICOLON expression )* END | LPAREN expression ( COMMA expression )* RPAREN );
    public final MiniMLParser.atomic_expression_return atomic_expression() throws RecognitionException {
        MiniMLParser.atomic_expression_return retval = new MiniMLParser.atomic_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER17=null;
        Token LET19=null;
        Token IN21=null;
        Token SEMICOLON23=null;
        Token END25=null;
        Token LPAREN26=null;
        Token COMMA28=null;
        Token RPAREN30=null;
        MiniMLParser.constant_return constant18 = null;

        MiniMLParser.declaration_return declaration20 = null;

        MiniMLParser.expression_return expression22 = null;

        MiniMLParser.expression_return expression24 = null;

        MiniMLParser.expression_return expression27 = null;

        MiniMLParser.expression_return expression29 = null;


        Object IDENTIFIER17_tree=null;
        Object LET19_tree=null;
        Object IN21_tree=null;
        Object SEMICOLON23_tree=null;
        Object END25_tree=null;
        Object LPAREN26_tree=null;
        Object COMMA28_tree=null;
        Object RPAREN30_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:60:5: ( IDENTIFIER | constant | LET declaration IN expression ( SEMICOLON expression )* END | LPAREN expression ( COMMA expression )* RPAREN )
            int alt7=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt7=1;
                }
                break;
            case NUMBER:
            case STRING:
                {
                alt7=2;
                }
                break;
            case LET:
                {
                alt7=3;
                }
                break;
            case LPAREN:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:60:7: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER17=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_atomic_expression328); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER17_tree = (Object)adaptor.create(IDENTIFIER17);
                    root_0 = (Object)adaptor.becomeRoot(IDENTIFIER17_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/MiniML.g:61:7: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_atomic_expression337);
                    constant18=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant18.getTree());

                    }
                    break;
                case 3 :
                    // src/bigraphspace/parser/antlr/MiniML.g:62:7: LET declaration IN expression ( SEMICOLON expression )* END
                    {
                    root_0 = (Object)adaptor.nil();

                    LET19=(Token)match(input,LET,FOLLOW_LET_in_atomic_expression346); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LET19_tree = (Object)adaptor.create(LET19);
                    root_0 = (Object)adaptor.becomeRoot(LET19_tree, root_0);
                    }
                    pushFollow(FOLLOW_declaration_in_atomic_expression349);
                    declaration20=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration20.getTree());
                    IN21=(Token)match(input,IN,FOLLOW_IN_in_atomic_expression351); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_atomic_expression354);
                    expression22=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression22.getTree());
                    // src/bigraphspace/parser/antlr/MiniML.g:62:39: ( SEMICOLON expression )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==SEMICOLON) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/MiniML.g:62:41: SEMICOLON expression
                    	    {
                    	    SEMICOLON23=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_atomic_expression358); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_expression_in_atomic_expression361);
                    	    expression24=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression24.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    END25=(Token)match(input,END,FOLLOW_END_in_atomic_expression366); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // src/bigraphspace/parser/antlr/MiniML.g:63:7: LPAREN expression ( COMMA expression )* RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN26=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atomic_expression375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN26_tree = (Object)adaptor.create(LPAREN26);
                    root_0 = (Object)adaptor.becomeRoot(LPAREN26_tree, root_0);
                    }
                    pushFollow(FOLLOW_expression_in_atomic_expression378);
                    expression27=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression27.getTree());
                    // src/bigraphspace/parser/antlr/MiniML.g:63:26: ( COMMA expression )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==COMMA) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/MiniML.g:63:28: COMMA expression
                    	    {
                    	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_atomic_expression382); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_expression_in_atomic_expression385);
                    	    expression29=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression29.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    RPAREN30=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atomic_expression390); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "atomic_expression"

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // src/bigraphspace/parser/antlr/MiniML.g:66:1: constant : ( NUMBER | STRING );
    public final MiniMLParser.constant_return constant() throws RecognitionException {
        MiniMLParser.constant_return retval = new MiniMLParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NUMBER31=null;
        Token STRING32=null;

        Object NUMBER31_tree=null;
        Object STRING32_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:67:5: ( NUMBER | STRING )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NUMBER) ) {
                alt8=1;
            }
            else if ( (LA8_0==STRING) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:67:7: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    NUMBER31=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_constant406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER31_tree = (Object)adaptor.create(NUMBER31);
                    root_0 = (Object)adaptor.becomeRoot(NUMBER31_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/MiniML.g:68:7: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING32=(Token)match(input,STRING,FOLLOW_STRING_in_constant416); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING32_tree = (Object)adaptor.create(STRING32);
                    root_0 = (Object)adaptor.becomeRoot(STRING32_tree, root_0);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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

    public static class declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration"
    // src/bigraphspace/parser/antlr/MiniML.g:71:1: declaration : ( | simple_declaration ( SEMICOLON simple_declaration )* );
    public final MiniMLParser.declaration_return declaration() throws RecognitionException {
        MiniMLParser.declaration_return retval = new MiniMLParser.declaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMICOLON34=null;
        MiniMLParser.simple_declaration_return simple_declaration33 = null;

        MiniMLParser.simple_declaration_return simple_declaration35 = null;


        Object SEMICOLON34_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:72:5: ( | simple_declaration ( SEMICOLON simple_declaration )* )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IN) ) {
                alt10=1;
            }
            else if ( (LA10_0==VAL) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:73:5: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/MiniML.g:73:7: simple_declaration ( SEMICOLON simple_declaration )*
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simple_declaration_in_declaration442);
                    simple_declaration33=simple_declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_declaration33.getTree());
                    // src/bigraphspace/parser/antlr/MiniML.g:73:26: ( SEMICOLON simple_declaration )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==SEMICOLON) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/MiniML.g:73:28: SEMICOLON simple_declaration
                    	    {
                    	    SEMICOLON34=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declaration446); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    SEMICOLON34_tree = (Object)adaptor.create(SEMICOLON34);
                    	    root_0 = (Object)adaptor.becomeRoot(SEMICOLON34_tree, root_0);
                    	    }
                    	    pushFollow(FOLLOW_simple_declaration_in_declaration449);
                    	    simple_declaration35=simple_declaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_declaration35.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "declaration"

    public static class simple_declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple_declaration"
    // src/bigraphspace/parser/antlr/MiniML.g:77:1: simple_declaration : value_declaration ;
    public final MiniMLParser.simple_declaration_return simple_declaration() throws RecognitionException {
        MiniMLParser.simple_declaration_return retval = new MiniMLParser.simple_declaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        MiniMLParser.value_declaration_return value_declaration36 = null;



        try {
            // src/bigraphspace/parser/antlr/MiniML.g:78:5: ( value_declaration )
            // src/bigraphspace/parser/antlr/MiniML.g:78:7: value_declaration
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_value_declaration_in_simple_declaration480);
            value_declaration36=value_declaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, value_declaration36.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "simple_declaration"

    public static class value_declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value_declaration"
    // src/bigraphspace/parser/antlr/MiniML.g:81:1: value_declaration : VAL pattern EQUALS expression ( AND pattern EQUALS expression )* ;
    public final MiniMLParser.value_declaration_return value_declaration() throws RecognitionException {
        MiniMLParser.value_declaration_return retval = new MiniMLParser.value_declaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAL37=null;
        Token EQUALS39=null;
        Token AND41=null;
        Token EQUALS43=null;
        MiniMLParser.pattern_return pattern38 = null;

        MiniMLParser.expression_return expression40 = null;

        MiniMLParser.pattern_return pattern42 = null;

        MiniMLParser.expression_return expression44 = null;


        Object VAL37_tree=null;
        Object EQUALS39_tree=null;
        Object AND41_tree=null;
        Object EQUALS43_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:82:5: ( VAL pattern EQUALS expression ( AND pattern EQUALS expression )* )
            // src/bigraphspace/parser/antlr/MiniML.g:82:7: VAL pattern EQUALS expression ( AND pattern EQUALS expression )*
            {
            root_0 = (Object)adaptor.nil();

            VAL37=(Token)match(input,VAL,FOLLOW_VAL_in_value_declaration501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            VAL37_tree = (Object)adaptor.create(VAL37);
            root_0 = (Object)adaptor.becomeRoot(VAL37_tree, root_0);
            }
            pushFollow(FOLLOW_pattern_in_value_declaration504);
            pattern38=pattern();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pattern38.getTree());
            EQUALS39=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_value_declaration506); if (state.failed) return retval;
            pushFollow(FOLLOW_expression_in_value_declaration509);
            expression40=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression40.getTree());
            // src/bigraphspace/parser/antlr/MiniML.g:82:39: ( AND pattern EQUALS expression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==AND) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/MiniML.g:82:41: AND pattern EQUALS expression
            	    {
            	    AND41=(Token)match(input,AND,FOLLOW_AND_in_value_declaration513); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND41_tree = (Object)adaptor.create(AND41);
            	    root_0 = (Object)adaptor.becomeRoot(AND41_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_pattern_in_value_declaration516);
            	    pattern42=pattern();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pattern42.getTree());
            	    EQUALS43=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_value_declaration518); if (state.failed) return retval;
            	    pushFollow(FOLLOW_expression_in_value_declaration521);
            	    expression44=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression44.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "value_declaration"

    public static class pattern_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pattern"
    // src/bigraphspace/parser/antlr/MiniML.g:84:1: pattern : atomic_pattern ;
    public final MiniMLParser.pattern_return pattern() throws RecognitionException {
        MiniMLParser.pattern_return retval = new MiniMLParser.pattern_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        MiniMLParser.atomic_pattern_return atomic_pattern45 = null;



        try {
            // src/bigraphspace/parser/antlr/MiniML.g:85:5: ( atomic_pattern )
            // src/bigraphspace/parser/antlr/MiniML.g:85:7: atomic_pattern
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atomic_pattern_in_pattern540);
            atomic_pattern45=atomic_pattern();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atomic_pattern45.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "pattern"

    public static class atomic_pattern_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atomic_pattern"
    // src/bigraphspace/parser/antlr/MiniML.g:87:1: atomic_pattern : ( UNDERSCORE | compound_name );
    public final MiniMLParser.atomic_pattern_return atomic_pattern() throws RecognitionException {
        MiniMLParser.atomic_pattern_return retval = new MiniMLParser.atomic_pattern_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UNDERSCORE46=null;
        MiniMLParser.compound_name_return compound_name47 = null;


        Object UNDERSCORE46_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:88:5: ( UNDERSCORE | compound_name )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==UNDERSCORE) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENTIFIER) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:88:7: UNDERSCORE
                    {
                    root_0 = (Object)adaptor.nil();

                    UNDERSCORE46=(Token)match(input,UNDERSCORE,FOLLOW_UNDERSCORE_in_atomic_pattern556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNDERSCORE46_tree = (Object)adaptor.create(UNDERSCORE46);
                    adaptor.addChild(root_0, UNDERSCORE46_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/MiniML.g:89:7: compound_name
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_compound_name_in_atomic_pattern564);
                    compound_name47=compound_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_name47.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "atomic_pattern"

    public static class compound_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compound_name"
    // src/bigraphspace/parser/antlr/MiniML.g:91:1: compound_name : IDENTIFIER ( DOT IDENTIFIER )* ;
    public final MiniMLParser.compound_name_return compound_name() throws RecognitionException {
        MiniMLParser.compound_name_return retval = new MiniMLParser.compound_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER48=null;
        Token DOT49=null;
        Token IDENTIFIER50=null;

        Object IDENTIFIER48_tree=null;
        Object DOT49_tree=null;
        Object IDENTIFIER50_tree=null;

        try {
            // src/bigraphspace/parser/antlr/MiniML.g:92:5: ( IDENTIFIER ( DOT IDENTIFIER )* )
            // src/bigraphspace/parser/antlr/MiniML.g:92:7: IDENTIFIER ( DOT IDENTIFIER )*
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER48=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_compound_name580); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER48_tree = (Object)adaptor.create(IDENTIFIER48);
            adaptor.addChild(root_0, IDENTIFIER48_tree);
            }
            // src/bigraphspace/parser/antlr/MiniML.g:92:18: ( DOT IDENTIFIER )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==DOT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/MiniML.g:92:20: DOT IDENTIFIER
            	    {
            	    DOT49=(Token)match(input,DOT,FOLLOW_DOT_in_compound_name584); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DOT49_tree = (Object)adaptor.create(DOT49);
            	    adaptor.addChild(root_0, DOT49_tree);
            	    }
            	    IDENTIFIER50=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_compound_name586); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER50_tree = (Object)adaptor.create(IDENTIFIER50);
            	    adaptor.addChild(root_0, IDENTIFIER50_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "compound_name"

    // $ANTLR start synpred1_MiniML
    public final void synpred1_MiniML_fragment() throws RecognitionException {   
        // src/bigraphspace/parser/antlr/MiniML.g:51:4: ( atomic_expression ( atomic_expression )+ )
        // src/bigraphspace/parser/antlr/MiniML.g:51:4: atomic_expression ( atomic_expression )+
        {
        pushFollow(FOLLOW_atomic_expression_in_synpred1_MiniML293);
        atomic_expression();

        state._fsp--;
        if (state.failed) return ;
        // src/bigraphspace/parser/antlr/MiniML.g:51:22: ( atomic_expression )+
        int cnt14=0;
        loop14:
        do {
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LPAREN||LA14_0==LET||(LA14_0>=IDENTIFIER && LA14_0<=STRING)) ) {
                alt14=1;
            }


            switch (alt14) {
        	case 1 :
        	    // src/bigraphspace/parser/antlr/MiniML.g:51:22: atomic_expression
        	    {
        	    pushFollow(FOLLOW_atomic_expression_in_synpred1_MiniML295);
        	    atomic_expression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt14 >= 1 ) break loop14;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(14, input);
                    throw eee;
            }
            cnt14++;
        } while (true);


        }
    }
    // $ANTLR end synpred1_MiniML

    // Delegated rules

    public final boolean synpred1_MiniML() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_MiniML_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_p_in_start166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tld_in_p190 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_p193 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_tld_in_p196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_p200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_tld215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infix_expression_in_expression230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FN_in_expression239 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_match_in_expression242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pattern_in_match261 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IMPLIES_in_match263 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_expression_in_match266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomic_expression_in_infix_expression293 = new BitSet(new long[]{0x0000000000380120L});
    public static final BitSet FOLLOW_atomic_expression_in_infix_expression295 = new BitSet(new long[]{0x0000000000380122L});
    public static final BitSet FOLLOW_atomic_expression_in_infix_expression312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_atomic_expression328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_atomic_expression337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LET_in_atomic_expression346 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_declaration_in_atomic_expression349 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IN_in_atomic_expression351 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_expression_in_atomic_expression354 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_SEMICOLON_in_atomic_expression358 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_expression_in_atomic_expression361 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_END_in_atomic_expression366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atomic_expression375 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_expression_in_atomic_expression378 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMMA_in_atomic_expression382 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_expression_in_atomic_expression385 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_RPAREN_in_atomic_expression390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_constant406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_declaration_in_declaration442 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_SEMICOLON_in_declaration446 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_simple_declaration_in_declaration449 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_value_declaration_in_simple_declaration480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAL_in_value_declaration501 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_pattern_in_value_declaration504 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUALS_in_value_declaration506 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_expression_in_value_declaration509 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_AND_in_value_declaration513 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_pattern_in_value_declaration516 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUALS_in_value_declaration518 = new BitSet(new long[]{0x0000000000380920L});
    public static final BitSet FOLLOW_expression_in_value_declaration521 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_atomic_pattern_in_pattern540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDERSCORE_in_atomic_pattern556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_name_in_atomic_pattern564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_compound_name580 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_DOT_in_compound_name584 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_compound_name586 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_atomic_expression_in_synpred1_MiniML293 = new BitSet(new long[]{0x0000000000380120L});
    public static final BitSet FOLLOW_atomic_expression_in_synpred1_MiniML295 = new BitSet(new long[]{0x0000000000380122L});

}