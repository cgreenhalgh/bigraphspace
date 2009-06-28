// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/MiniML.g 2009-06-28 21:20:49
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MiniMLLexer extends Lexer {
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
    public static final int PIPE=15;
    public static final int NUMERAL=24;
    public static final int DIGIT=23;
    public static final int DOT=16;
    public static final int END=9;
    public static final int LET=8;
    public static final int STRING=21;

    // delegates
    // delegators

    public MiniMLLexer() {;} 
    public MiniMLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MiniMLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/bigraphspace/parser/antlr/MiniML.g"; }

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:5:11: ( ';' )
            // src/bigraphspace/parser/antlr/MiniML.g:5:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:6:8: ( '(' )
            // src/bigraphspace/parser/antlr/MiniML.g:6:10: '('
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
            // src/bigraphspace/parser/antlr/MiniML.g:7:8: ( ')' )
            // src/bigraphspace/parser/antlr/MiniML.g:7:10: ')'
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

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:8:7: ( ',' )
            // src/bigraphspace/parser/antlr/MiniML.g:8:9: ','
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

    // $ANTLR start "LET"
    public final void mLET() throws RecognitionException {
        try {
            int _type = LET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:9:5: ( 'let' )
            // src/bigraphspace/parser/antlr/MiniML.g:9:7: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LET"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:10:5: ( 'end' )
            // src/bigraphspace/parser/antlr/MiniML.g:10:7: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:11:4: ( 'in' )
            // src/bigraphspace/parser/antlr/MiniML.g:11:6: 'in'
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

    // $ANTLR start "FN"
    public final void mFN() throws RecognitionException {
        try {
            int _type = FN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:12:4: ( 'fn' )
            // src/bigraphspace/parser/antlr/MiniML.g:12:6: 'fn'
            {
            match("fn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FN"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:13:5: ( 'and' )
            // src/bigraphspace/parser/antlr/MiniML.g:13:7: 'and'
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

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:14:12: ( '_' )
            // src/bigraphspace/parser/antlr/MiniML.g:14:14: '_'
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

    // $ANTLR start "VAL"
    public final void mVAL() throws RecognitionException {
        try {
            int _type = VAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:15:5: ( 'val' )
            // src/bigraphspace/parser/antlr/MiniML.g:15:7: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAL"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:16:6: ( '|' )
            // src/bigraphspace/parser/antlr/MiniML.g:16:8: '|'
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

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:17:5: ( '.' )
            // src/bigraphspace/parser/antlr/MiniML.g:17:7: '.'
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

    // $ANTLR start "APPLY"
    public final void mAPPLY() throws RecognitionException {
        try {
            int _type = APPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:18:7: ( 'apply' )
            // src/bigraphspace/parser/antlr/MiniML.g:18:9: 'apply'
            {
            match("apply"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "APPLY"

    // $ANTLR start "IMPLIES"
    public final void mIMPLIES() throws RecognitionException {
        try {
            int _type = IMPLIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:99:9: ( '=' '>' )
            // src/bigraphspace/parser/antlr/MiniML.g:99:11: '=' '>'
            {
            match('='); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPLIES"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/MiniML.g:101:8: ( '=' )
            // src/bigraphspace/parser/antlr/MiniML.g:101:10: '='
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

    // $ANTLR start "NUMERAL"
    public final void mNUMERAL() throws RecognitionException {
        try {
            // src/bigraphspace/parser/antlr/MiniML.g:103:18: ( ( '~' )? ( DIGIT )+ )
            // src/bigraphspace/parser/antlr/MiniML.g:103:20: ( '~' )? ( DIGIT )+
            {
            // src/bigraphspace/parser/antlr/MiniML.g:103:20: ( '~' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='~') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:103:20: '~'
                    {
                    match('~'); 

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/MiniML.g:103:25: ( DIGIT )+
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
            	    // src/bigraphspace/parser/antlr/MiniML.g:103:26: DIGIT
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
            // src/bigraphspace/parser/antlr/MiniML.g:105:8: ( NUMERAL ( '.' ( DIGIT )+ )? ( 'E' NUMERAL )? )
            // src/bigraphspace/parser/antlr/MiniML.g:105:10: NUMERAL ( '.' ( DIGIT )+ )? ( 'E' NUMERAL )?
            {
            mNUMERAL(); 
            // src/bigraphspace/parser/antlr/MiniML.g:105:18: ( '.' ( DIGIT )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:105:20: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // src/bigraphspace/parser/antlr/MiniML.g:105:24: ( DIGIT )+
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
                    	    // src/bigraphspace/parser/antlr/MiniML.g:105:24: DIGIT
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

            // src/bigraphspace/parser/antlr/MiniML.g:105:34: ( 'E' NUMERAL )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='E') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/bigraphspace/parser/antlr/MiniML.g:105:36: 'E' NUMERAL
                    {
                    match('E'); 
                    mNUMERAL(); 

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
            // src/bigraphspace/parser/antlr/MiniML.g:107:8: ( '\"' (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )* '\"' )
            // src/bigraphspace/parser/antlr/MiniML.g:107:10: '\"' (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )* '\"'
            {
            match('\"'); 
            // src/bigraphspace/parser/antlr/MiniML.g:107:14: (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }
                else if ( (LA6_0=='\\') ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/MiniML.g:107:16: ~ ( '\\\\' | '\"' )
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
            	    // src/bigraphspace/parser/antlr/MiniML.g:107:30: '\\\\' STRING_ESCAPE
            	    {
            	    match('\\'); 
            	    mSTRING_ESCAPE(); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // src/bigraphspace/parser/antlr/MiniML.g:109:23: ( 'n' | 't' | '\\\\' )
            // src/bigraphspace/parser/antlr/MiniML.g:
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
            // src/bigraphspace/parser/antlr/MiniML.g:111:12: ( LETTER ( LETTER | DIGIT )* )
            // src/bigraphspace/parser/antlr/MiniML.g:111:14: LETTER ( LETTER | DIGIT )*
            {
            mLETTER(); 
            // src/bigraphspace/parser/antlr/MiniML.g:111:21: ( LETTER | DIGIT )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/MiniML.g:
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
            // src/bigraphspace/parser/antlr/MiniML.g:113:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // src/bigraphspace/parser/antlr/MiniML.g:113:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // src/bigraphspace/parser/antlr/MiniML.g:113:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
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
            	    // src/bigraphspace/parser/antlr/MiniML.g:
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

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // src/bigraphspace/parser/antlr/MiniML.g:115:16: ( '0' .. '9' )
            // src/bigraphspace/parser/antlr/MiniML.g:115:18: '0' .. '9'
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
            // src/bigraphspace/parser/antlr/MiniML.g:117:17: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // src/bigraphspace/parser/antlr/MiniML.g:117:19: ( 'A' .. 'Z' | 'a' .. 'z' )
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
        // src/bigraphspace/parser/antlr/MiniML.g:1:8: ( SEMICOLON | LPAREN | RPAREN | COMMA | LET | END | IN | FN | AND | UNDERSCORE | VAL | PIPE | DOT | APPLY | IMPLIES | EQUALS | NUMBER | STRING | IDENTIFIER | WHITESPACE )
        int alt9=20;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:10: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 2 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:20: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 3 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:27: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 4 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:34: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 5 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:40: LET
                {
                mLET(); 

                }
                break;
            case 6 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:44: END
                {
                mEND(); 

                }
                break;
            case 7 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:48: IN
                {
                mIN(); 

                }
                break;
            case 8 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:51: FN
                {
                mFN(); 

                }
                break;
            case 9 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:54: AND
                {
                mAND(); 

                }
                break;
            case 10 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:58: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 11 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:69: VAL
                {
                mVAL(); 

                }
                break;
            case 12 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:73: PIPE
                {
                mPIPE(); 

                }
                break;
            case 13 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:78: DOT
                {
                mDOT(); 

                }
                break;
            case 14 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:82: APPLY
                {
                mAPPLY(); 

                }
                break;
            case 15 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:88: IMPLIES
                {
                mIMPLIES(); 

                }
                break;
            case 16 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:96: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 17 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:103: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 18 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:110: STRING
                {
                mSTRING(); 

                }
                break;
            case 19 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:117: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 20 :
                // src/bigraphspace/parser/antlr/MiniML.g:1:128: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\5\uffff\5\21\1\uffff\1\21\2\uffff\1\33\4\uffff\2\21\1\36\1\37"+
        "\3\21\2\uffff\1\43\1\44\2\uffff\1\45\1\21\1\47\3\uffff\1\21\1\uffff"+
        "\1\51\1\uffff";
    static final String DFA9_eofS =
        "\52\uffff";
    static final String DFA9_minS =
        "\1\11\4\uffff\1\145\4\156\1\uffff\1\141\2\uffff\1\76\4\uffff\1"+
        "\164\1\144\2\60\1\144\1\160\1\154\2\uffff\2\60\2\uffff\1\60\1\154"+
        "\1\60\3\uffff\1\171\1\uffff\1\60\1\uffff";
    static final String DFA9_maxS =
        "\1\176\4\uffff\1\145\3\156\1\160\1\uffff\1\141\2\uffff\1\76\4\uffff"+
        "\1\164\1\144\2\172\1\144\1\160\1\154\2\uffff\2\172\2\uffff\1\172"+
        "\1\154\1\172\3\uffff\1\171\1\uffff\1\172\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\5\uffff\1\12\1\uffff\1\14\1\15\1\uffff"+
        "\1\21\1\22\1\23\1\24\7\uffff\1\17\1\20\2\uffff\1\7\1\10\3\uffff"+
        "\1\5\1\6\1\11\1\uffff\1\13\1\uffff\1\16";
    static final String DFA9_specialS =
        "\52\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\22\1\uffff\2\22\22\uffff\1\22\1\uffff\1\20\5\uffff\1\2\1"+
            "\3\2\uffff\1\4\1\uffff\1\15\1\uffff\12\17\1\uffff\1\1\1\uffff"+
            "\1\16\3\uffff\32\21\4\uffff\1\12\1\uffff\1\11\3\21\1\6\1\10"+
            "\2\21\1\7\2\21\1\5\11\21\1\13\4\21\1\uffff\1\14\1\uffff\1\17",
            "",
            "",
            "",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27\1\uffff\1\30",
            "",
            "\1\31",
            "",
            "",
            "\1\32",
            "",
            "",
            "",
            "",
            "\1\34",
            "\1\35",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\1\40",
            "\1\41",
            "\1\42",
            "",
            "",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "",
            "",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\1\46",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "",
            "",
            "",
            "\1\50",
            "",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SEMICOLON | LPAREN | RPAREN | COMMA | LET | END | IN | FN | AND | UNDERSCORE | VAL | PIPE | DOT | APPLY | IMPLIES | EQUALS | NUMBER | STRING | IDENTIFIER | WHITESPACE );";
        }
    }
 

}