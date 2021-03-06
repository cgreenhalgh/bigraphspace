// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/BigraphTerm.g 2009-07-30 19:57:12
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BigraphTermLexer extends Lexer {
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
    public static final int AND=7;
    public static final int BIGRAPH=4;
    public static final int EOF=-1;
    public static final int LENGTH=10;
    public static final int LPAREN=49;
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
    public static final int RULE=5;
    public static final int CONTROL=17;
    public static final int RBRACE=47;
    public static final int NODE=18;
    public static final int MINLENGTH=22;
    public static final int NUMBER=39;
    public static final int AMPERSAND=57;
    public static final int WHITESPACE=62;
    public static final int UNDERSCORE=55;
    public static final int RSQUARE=40;
    public static final int MINUS=54;
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

    public BigraphTermLexer() {;} 
    public BigraphTermLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BigraphTermLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/bigraphspace/parser/antlr/BigraphTerm.g"; }

    // $ANTLR start "BIGRAPH"
    public final void mBIGRAPH() throws RecognitionException {
        try {
            int _type = BIGRAPH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:5:9: ( 'bigraph' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:5:11: 'bigraph'
            {
            match("bigraph"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BIGRAPH"

    // $ANTLR start "RULE"
    public final void mRULE() throws RecognitionException {
        try {
            int _type = RULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:6:6: ( 'rule' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:6:8: 'rule'
            {
            match("rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:7:7: ( 'where' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:7:9: 'where'
            {
            match("where"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:8:5: ( 'and' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:8:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:9:4: ( 'in' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:9:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:10:5: ( 'not' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:10:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "LENGTH"
    public final void mLENGTH() throws RecognitionException {
        try {
            int _type = LENGTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:11:8: ( 'length' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:11:10: 'length'
            {
            match("length"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LENGTH"

    // $ANTLR start "MATCHES"
    public final void mMATCHES() throws RecognitionException {
        try {
            int _type = MATCHES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:12:9: ( 'matches' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:12:11: 'matches'
            {
            match("matches"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MATCHES"

    // $ANTLR start "EMPTY"
    public final void mEMPTY() throws RecognitionException {
        try {
            int _type = EMPTY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:13:7: ( 'empty' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:13:9: 'empty'
            {
            match("empty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EMPTY"

    // $ANTLR start "PORTS"
    public final void mPORTS() throws RecognitionException {
        try {
            int _type = PORTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:14:7: ( 'ports' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:14:9: 'ports'
            {
            match("ports"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PORTS"

    // $ANTLR start "CHILDREN"
    public final void mCHILDREN() throws RecognitionException {
        try {
            int _type = CHILDREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:15:10: ( 'children' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:15:12: 'children'
            {
            match("children"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHILDREN"

    // $ANTLR start "ROOT"
    public final void mROOT() throws RecognitionException {
        try {
            int _type = ROOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:16:6: ( 'root' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:16:8: 'root'
            {
            match("root"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROOT"

    // $ANTLR start "UNNAMED"
    public final void mUNNAMED() throws RecognitionException {
        try {
            int _type = UNNAMED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:17:9: ( 'unnamed' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:17:11: 'unnamed'
            {
            match("unnamed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNNAMED"

    // $ANTLR start "CONTROL"
    public final void mCONTROL() throws RecognitionException {
        try {
            int _type = CONTROL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:18:9: ( 'control' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:18:11: 'control'
            {
            match("control"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTROL"

    // $ANTLR start "NODE"
    public final void mNODE() throws RecognitionException {
        try {
            int _type = NODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:19:6: ( 'node' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:19:8: 'node'
            {
            match("node"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NODE"

    // $ANTLR start "ONEOF"
    public final void mONEOF() throws RecognitionException {
        try {
            int _type = ONEOF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:20:7: ( 'oneof' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:20:9: 'oneof'
            {
            match("oneof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ONEOF"

    // $ANTLR start "NOTONEOF"
    public final void mNOTONEOF() throws RecognitionException {
        try {
            int _type = NOTONEOF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:21:10: ( 'notoneof' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:21:12: 'notoneof'
            {
            match("notoneof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTONEOF"

    // $ANTLR start "CONSTRAINT"
    public final void mCONSTRAINT() throws RecognitionException {
        try {
            int _type = CONSTRAINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:22:12: ( 'constraint' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:22:14: 'constraint'
            {
            match("constraint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSTRAINT"

    // $ANTLR start "MINLENGTH"
    public final void mMINLENGTH() throws RecognitionException {
        try {
            int _type = MINLENGTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:23:11: ( 'minlength' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:23:13: 'minlength'
            {
            match("minlength"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINLENGTH"

    // $ANTLR start "MAXLENGTH"
    public final void mMAXLENGTH() throws RecognitionException {
        try {
            int _type = MAXLENGTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:24:11: ( 'maxlength' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:24:13: 'maxlength'
            {
            match("maxlength"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAXLENGTH"

    // $ANTLR start "MINVALUE"
    public final void mMINVALUE() throws RecognitionException {
        try {
            int _type = MINVALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:25:10: ( 'minvalue' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:25:12: 'minvalue'
            {
            match("minvalue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINVALUE"

    // $ANTLR start "MAXVALUE"
    public final void mMAXVALUE() throws RecognitionException {
        try {
            int _type = MAXVALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:26:10: ( 'maxvalue' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:26:12: 'maxvalue'
            {
            match("maxvalue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAXVALUE"

    // $ANTLR start "REGEXP"
    public final void mREGEXP() throws RecognitionException {
        try {
            int _type = REGEXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:27:8: ( 'regexp' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:27:10: 'regexp'
            {
            match("regexp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REGEXP"

    // $ANTLR start "SUPPORT"
    public final void mSUPPORT() throws RecognitionException {
        try {
            int _type = SUPPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:28:9: ( 'support' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:28:11: 'support'
            {
            match("support"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUPPORT"

    // $ANTLR start "CLOSURES"
    public final void mCLOSURES() throws RecognitionException {
        try {
            int _type = CLOSURES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:29:10: ( 'closures' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:29:12: 'closures'
            {
            match("closures"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSURES"

    // $ANTLR start "SUBSTITUTIONS"
    public final void mSUBSTITUTIONS() throws RecognitionException {
        try {
            int _type = SUBSTITUTIONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:30:15: ( 'substitutions' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:30:17: 'substitutions'
            {
            match("substitutions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBSTITUTIONS"

    // $ANTLR start "PIPE2"
    public final void mPIPE2() throws RecognitionException {
        try {
            int _type = PIPE2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:164:7: ( '|' '|' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:164:9: '|' '|'
            {
            match('|'); 
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE2"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:165:6: ( '|' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:165:8: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:166:8: ( '(' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:166:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:167:8: ( ')' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:167:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:168:8: ( '{' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:168:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:169:8: ( '}' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:169:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "LANGLE"
    public final void mLANGLE() throws RecognitionException {
        try {
            int _type = LANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:170:8: ( '<' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:170:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LANGLE"

    // $ANTLR start "RANGLE"
    public final void mRANGLE() throws RecognitionException {
        try {
            int _type = RANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:171:8: ( '>' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:171:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGLE"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:172:12: ( '_' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:172:14: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:173:7: ( '/' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:173:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:174:7: ( ',' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:174:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:175:8: ( '=' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:175:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:176:7: ( '->' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:176:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARROW"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:177:7: ( ':' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:177:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:178:8: ( '[' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:178:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQUARE"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:179:8: ( ']' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:179:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQUARE"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:180:7: ( '$' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:180:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "LESSTHANOREQUAL"
    public final void mLESSTHANOREQUAL() throws RecognitionException {
        try {
            int _type = LESSTHANOREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:181:16: ( '<=' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:181:18: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESSTHANOREQUAL"

    // $ANTLR start "GREATERTHANOREQUAL"
    public final void mGREATERTHANOREQUAL() throws RecognitionException {
        try {
            int _type = GREATERTHANOREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:182:19: ( '>=' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:182:21: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATERTHANOREQUAL"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:183:5: ( '+' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:183:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:184:6: ( '-' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:184:8: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:185:3: ( '@' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:185:5: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:186:4: ( '.' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:186:6: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:187:10: ( '&' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:187:12: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:188:5: ( '*' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:188:7: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "NUMERAL"
    public final void mNUMERAL() throws RecognitionException {
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:190:18: ( ( '~' )? ( DIGIT )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:190:20: ( '~' )? ( DIGIT )+
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:190:20: ( '~' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='~') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:190:20: '~'
                    {
                    match('~'); 

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:190:25: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:190:26: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "NUMERAL"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:192:8: ( NUMERAL ( '.' ( DIGIT )+ )? )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:192:10: NUMERAL ( '.' ( DIGIT )+ )?
            {
            mNUMERAL(); 
            // src/bigraphspace/parser/antlr/BigraphTerm.g:192:18: ( '.' ( DIGIT )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:192:20: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:192:24: ( DIGIT )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:192:24: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:194:8: ( '\"' (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )* '\"' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:194:10: '\"' (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )* '\"'
            {
            match('\"'); 
            // src/bigraphspace/parser/antlr/BigraphTerm.g:194:14: (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }
                else if ( (LA5_0=='\\') ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:194:16: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:194:30: '\\\\' STRING_ESCAPE
            	    {
            	    match('\\'); 
            	    mSTRING_ESCAPE(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "STRING_ESCAPE"
    public final void mSTRING_ESCAPE() throws RecognitionException {
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:196:23: ( 'n' | 't' | '\\\\' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:
            {
            if ( input.LA(1)=='\\'||input.LA(1)=='n'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "STRING_ESCAPE"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:198:12: ( ( DOLLAR )? LETTER ( LETTER | DIGIT )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:198:14: ( DOLLAR )? LETTER ( LETTER | DIGIT )*
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:198:14: ( DOLLAR )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='$') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:198:14: DOLLAR
                    {
                    mDOLLAR(); 

                    }
                    break;

            }

            mLETTER(); 
            // src/bigraphspace/parser/antlr/BigraphTerm.g:198:29: ( LETTER | DIGIT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:200:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:200:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:200:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINECOMMENT"
    public final void mLINECOMMENT() throws RecognitionException {
        try {
            int _type = LINECOMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:202:13: ( ( '/' '/' | '#' ) (~ '\\n' )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:202:15: ( '/' '/' | '#' ) (~ '\\n' )*
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:202:15: ( '/' '/' | '#' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='/') ) {
                alt9=1;
            }
            else if ( (LA9_0=='#') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:202:17: '/' '/'
                    {
                    match('/'); 
                    match('/'); 

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:202:27: '#'
                    {
                    match('#'); 

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:202:33: (~ '\\n' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:202:35: ~ '\\n'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINECOMMENT"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:204:16: ( '0' .. '9' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:204:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:206:17: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:206:19: ( 'A' .. 'Z' | 'a' .. 'z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    public void mTokens() throws RecognitionException {
        // src/bigraphspace/parser/antlr/BigraphTerm.g:1:8: ( BIGRAPH | RULE | WHERE | AND | IN | NOT | LENGTH | MATCHES | EMPTY | PORTS | CHILDREN | ROOT | UNNAMED | CONTROL | NODE | ONEOF | NOTONEOF | CONSTRAINT | MINLENGTH | MAXLENGTH | MINVALUE | MAXVALUE | REGEXP | SUPPORT | CLOSURES | SUBSTITUTIONS | PIPE2 | PIPE | LPAREN | RPAREN | LBRACE | RBRACE | LANGLE | RANGLE | UNDERSCORE | SLASH | COMMA | EQUALS | ARROW | COLON | LSQUARE | RSQUARE | DOLLAR | LESSTHANOREQUAL | GREATERTHANOREQUAL | PLUS | MINUS | AT | DOT | AMPERSAND | STAR | NUMBER | STRING | IDENTIFIER | WHITESPACE | LINECOMMENT )
        int alt11=56;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:10: BIGRAPH
                {
                mBIGRAPH(); 

                }
                break;
            case 2 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:18: RULE
                {
                mRULE(); 

                }
                break;
            case 3 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:23: WHERE
                {
                mWHERE(); 

                }
                break;
            case 4 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:29: AND
                {
                mAND(); 

                }
                break;
            case 5 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:33: IN
                {
                mIN(); 

                }
                break;
            case 6 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:36: NOT
                {
                mNOT(); 

                }
                break;
            case 7 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:40: LENGTH
                {
                mLENGTH(); 

                }
                break;
            case 8 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:47: MATCHES
                {
                mMATCHES(); 

                }
                break;
            case 9 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:55: EMPTY
                {
                mEMPTY(); 

                }
                break;
            case 10 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:61: PORTS
                {
                mPORTS(); 

                }
                break;
            case 11 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:67: CHILDREN
                {
                mCHILDREN(); 

                }
                break;
            case 12 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:76: ROOT
                {
                mROOT(); 

                }
                break;
            case 13 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:81: UNNAMED
                {
                mUNNAMED(); 

                }
                break;
            case 14 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:89: CONTROL
                {
                mCONTROL(); 

                }
                break;
            case 15 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:97: NODE
                {
                mNODE(); 

                }
                break;
            case 16 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:102: ONEOF
                {
                mONEOF(); 

                }
                break;
            case 17 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:108: NOTONEOF
                {
                mNOTONEOF(); 

                }
                break;
            case 18 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:117: CONSTRAINT
                {
                mCONSTRAINT(); 

                }
                break;
            case 19 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:128: MINLENGTH
                {
                mMINLENGTH(); 

                }
                break;
            case 20 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:138: MAXLENGTH
                {
                mMAXLENGTH(); 

                }
                break;
            case 21 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:148: MINVALUE
                {
                mMINVALUE(); 

                }
                break;
            case 22 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:157: MAXVALUE
                {
                mMAXVALUE(); 

                }
                break;
            case 23 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:166: REGEXP
                {
                mREGEXP(); 

                }
                break;
            case 24 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:173: SUPPORT
                {
                mSUPPORT(); 

                }
                break;
            case 25 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:181: CLOSURES
                {
                mCLOSURES(); 

                }
                break;
            case 26 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:190: SUBSTITUTIONS
                {
                mSUBSTITUTIONS(); 

                }
                break;
            case 27 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:204: PIPE2
                {
                mPIPE2(); 

                }
                break;
            case 28 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:210: PIPE
                {
                mPIPE(); 

                }
                break;
            case 29 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:215: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 30 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:222: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 31 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:229: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 32 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:236: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 33 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:243: LANGLE
                {
                mLANGLE(); 

                }
                break;
            case 34 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:250: RANGLE
                {
                mRANGLE(); 

                }
                break;
            case 35 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:257: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 36 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:268: SLASH
                {
                mSLASH(); 

                }
                break;
            case 37 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:274: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 38 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:280: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 39 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:287: ARROW
                {
                mARROW(); 

                }
                break;
            case 40 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:293: COLON
                {
                mCOLON(); 

                }
                break;
            case 41 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:299: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 42 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:307: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 43 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:315: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 44 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:322: LESSTHANOREQUAL
                {
                mLESSTHANOREQUAL(); 

                }
                break;
            case 45 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:338: GREATERTHANOREQUAL
                {
                mGREATERTHANOREQUAL(); 

                }
                break;
            case 46 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:357: PLUS
                {
                mPLUS(); 

                }
                break;
            case 47 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:362: MINUS
                {
                mMINUS(); 

                }
                break;
            case 48 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:368: AT
                {
                mAT(); 

                }
                break;
            case 49 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:371: DOT
                {
                mDOT(); 

                }
                break;
            case 50 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:375: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 51 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:385: STAR
                {
                mSTAR(); 

                }
                break;
            case 52 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:390: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 53 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:397: STRING
                {
                mSTRING(); 

                }
                break;
            case 54 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:404: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 55 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:415: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 56 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:426: LINECOMMENT
                {
                mLINECOMMENT(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\16\46\1\75\4\uffff\1\77\1\101\1\uffff\1\102\2\uffff\1"+
        "\104\3\uffff\1\105\12\uffff\6\46\1\114\14\46\12\uffff\5\46\1\141"+
        "\1\uffff\1\143\17\46\1\166\1\167\2\46\1\uffff\1\46\1\uffff\1\173"+
        "\21\46\2\uffff\1\46\1\u008e\1\46\1\uffff\6\46\1\u0096\1\u0097\5"+
        "\46\1\u009d\3\46\1\u00a1\1\uffff\1\46\1\u00a3\5\46\2\uffff\5\46"+
        "\1\uffff\2\46\1\u00b0\1\uffff\1\46\1\uffff\1\u00b2\5\46\1\u00b8"+
        "\2\46\1\u00bb\1\u00bc\1\46\1\uffff\1\u00be\1\uffff\1\46\1\u00c0"+
        "\1\46\1\u00c2\1\u00c3\1\uffff\1\46\1\u00c5\2\uffff\1\46\1\uffff"+
        "\1\u00c7\1\uffff\1\u00c8\2\uffff\1\46\1\uffff\1\46\2\uffff\1\u00cb"+
        "\1\46\1\uffff\2\46\1\u00cf\1\uffff";
    static final String DFA11_eofS =
        "\u00d0\uffff";
    static final String DFA11_minS =
        "\1\11\1\151\1\145\1\150\2\156\1\157\1\145\1\141\1\155\1\157\1\150"+
        "\2\156\1\165\1\174\4\uffff\2\75\1\uffff\1\57\2\uffff\1\76\3\uffff"+
        "\1\101\12\uffff\1\147\1\154\1\157\1\147\1\145\1\144\1\60\1\144\1"+
        "\156\1\164\1\156\1\160\1\162\1\151\1\156\1\157\1\156\1\145\1\142"+
        "\12\uffff\1\162\1\145\1\164\1\145\1\162\1\60\1\uffff\1\60\1\145"+
        "\1\147\1\143\2\154\2\164\1\154\2\163\1\141\1\157\1\160\1\163\1\141"+
        "\2\60\1\170\1\145\1\uffff\1\156\1\uffff\1\60\1\164\1\150\1\145\1"+
        "\141\1\145\1\141\1\171\1\163\1\144\1\162\1\164\1\165\1\155\1\146"+
        "\1\157\1\164\1\160\2\uffff\1\160\1\60\1\145\1\uffff\1\150\1\145"+
        "\1\156\1\154\1\156\1\154\2\60\1\162\1\157\2\162\1\145\1\60\1\162"+
        "\1\151\1\150\1\60\1\uffff\1\157\1\60\1\163\1\147\1\165\1\147\1\165"+
        "\2\uffff\1\145\1\154\1\141\1\145\1\144\1\uffff\2\164\1\60\1\uffff"+
        "\1\146\1\uffff\1\60\1\164\1\145\1\164\1\145\1\156\1\60\1\151\1\163"+
        "\2\60\1\165\1\uffff\1\60\1\uffff\1\150\1\60\1\150\2\60\1\uffff\1"+
        "\156\1\60\2\uffff\1\164\1\uffff\1\60\1\uffff\1\60\2\uffff\1\164"+
        "\1\uffff\1\151\2\uffff\1\60\1\157\1\uffff\1\156\1\163\1\60\1\uffff";
    static final String DFA11_maxS =
        "\1\176\1\151\1\165\1\150\2\156\1\157\1\145\1\151\1\155\2\157\2"+
        "\156\1\165\1\174\4\uffff\2\75\1\uffff\1\57\2\uffff\1\76\3\uffff"+
        "\1\172\12\uffff\1\147\1\154\1\157\1\147\1\145\1\144\1\172\1\164"+
        "\1\156\1\170\1\156\1\160\1\162\1\151\1\156\1\157\1\156\1\145\1\160"+
        "\12\uffff\1\162\1\145\1\164\1\145\1\162\1\172\1\uffff\1\172\1\145"+
        "\1\147\1\143\2\166\2\164\1\154\1\164\1\163\1\141\1\157\1\160\1\163"+
        "\1\141\2\172\1\170\1\145\1\uffff\1\156\1\uffff\1\172\1\164\1\150"+
        "\1\145\1\141\1\145\1\141\1\171\1\163\1\144\1\162\1\164\1\165\1\155"+
        "\1\146\1\157\1\164\1\160\2\uffff\1\160\1\172\1\145\1\uffff\1\150"+
        "\1\145\1\156\1\154\1\156\1\154\2\172\1\162\1\157\2\162\1\145\1\172"+
        "\1\162\1\151\1\150\1\172\1\uffff\1\157\1\172\1\163\1\147\1\165\1"+
        "\147\1\165\2\uffff\1\145\1\154\1\141\1\145\1\144\1\uffff\2\164\1"+
        "\172\1\uffff\1\146\1\uffff\1\172\1\164\1\145\1\164\1\145\1\156\1"+
        "\172\1\151\1\163\2\172\1\165\1\uffff\1\172\1\uffff\1\150\1\172\1"+
        "\150\2\172\1\uffff\1\156\1\172\2\uffff\1\164\1\uffff\1\172\1\uffff"+
        "\1\172\2\uffff\1\164\1\uffff\1\151\2\uffff\1\172\1\157\1\uffff\1"+
        "\156\1\163\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\20\uffff\1\35\1\36\1\37\1\40\2\uffff\1\43\1\uffff\1\45\1\46\1"+
        "\uffff\1\50\1\51\1\52\1\uffff\1\56\1\60\1\61\1\62\1\63\1\64\1\65"+
        "\1\66\1\67\1\70\23\uffff\1\33\1\34\1\54\1\41\1\55\1\42\1\44\1\47"+
        "\1\57\1\53\6\uffff\1\5\24\uffff\1\4\1\uffff\1\6\22\uffff\1\2\1\14"+
        "\3\uffff\1\17\22\uffff\1\3\7\uffff\1\11\1\12\5\uffff\1\20\3\uffff"+
        "\1\27\1\uffff\1\7\14\uffff\1\1\1\uffff\1\10\5\uffff\1\16\2\uffff"+
        "\1\15\1\30\1\uffff\1\21\1\uffff\1\26\1\uffff\1\25\1\13\1\uffff\1"+
        "\31\1\uffff\1\24\1\23\2\uffff\1\22\3\uffff\1\32";
    static final String DFA11_specialS =
        "\u00d0\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\47\1\uffff\2\47\22\uffff\1\47\1\uffff\1\45\1\50\1\36\1\uffff"+
            "\1\42\1\uffff\1\20\1\21\1\43\1\37\1\30\1\32\1\41\1\27\12\44"+
            "\1\33\1\uffff\1\24\1\31\1\25\1\uffff\1\40\32\46\1\34\1\uffff"+
            "\1\35\1\uffff\1\26\1\uffff\1\4\1\1\1\13\1\46\1\11\3\46\1\5\2"+
            "\46\1\7\1\10\1\6\1\15\1\12\1\46\1\2\1\16\1\46\1\14\1\46\1\3"+
            "\3\46\1\22\1\17\1\23\1\44",
            "\1\51",
            "\1\54\11\uffff\1\53\5\uffff\1\52",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62\7\uffff\1\63",
            "\1\64",
            "\1\65",
            "\1\66\3\uffff\1\70\2\uffff\1\67",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "",
            "",
            "\1\76",
            "\1\100",
            "",
            "\1\50",
            "",
            "",
            "\1\103",
            "",
            "",
            "",
            "\32\46\6\uffff\32\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\116\17\uffff\1\115",
            "\1\117",
            "\1\120\3\uffff\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\133\15\uffff\1\132",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\6\uffff\16\46\1\142\13\46",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147\11\uffff\1\150",
            "\1\151\11\uffff\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\157\1\156",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\170",
            "\1\171",
            "",
            "\1\172",
            "",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "",
            "",
            "\1\u008d",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u008f",
            "",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\u00a2",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\1\u00af",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\u00b1",
            "",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00b9",
            "\1\u00ba",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00bd",
            "",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\u00bf",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00c1",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\u00c4",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "",
            "\1\u00c6",
            "",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "",
            "",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\12\46\7\uffff\32\46\6\uffff\32\46",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( BIGRAPH | RULE | WHERE | AND | IN | NOT | LENGTH | MATCHES | EMPTY | PORTS | CHILDREN | ROOT | UNNAMED | CONTROL | NODE | ONEOF | NOTONEOF | CONSTRAINT | MINLENGTH | MAXLENGTH | MINVALUE | MAXVALUE | REGEXP | SUPPORT | CLOSURES | SUBSTITUTIONS | PIPE2 | PIPE | LPAREN | RPAREN | LBRACE | RBRACE | LANGLE | RANGLE | UNDERSCORE | SLASH | COMMA | EQUALS | ARROW | COLON | LSQUARE | RSQUARE | DOLLAR | LESSTHANOREQUAL | GREATERTHANOREQUAL | PLUS | MINUS | AT | DOT | AMPERSAND | STAR | NUMBER | STRING | IDENTIFIER | WHITESPACE | LINECOMMENT );";
        }
    }
 

}