// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 src/bigraphspace/parser/antlr/BigraphTerm.g 2009-06-28 21:20:50
 package bigraphspace.parser.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BigraphTermLexer extends Lexer {
    public static final int RBRACE=19;
    public static final int RULE=5;
    public static final int STRING_ESCAPE=27;
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
    public static final int PORTS=7;
    public static final int SLASH=25;
    public static final int COMMA=18;
    public static final int IDENTIFIER=16;
    public static final int UNNAMED=10;
    public static final int ARROW=11;
    public static final int PIPE=15;
    public static final int NUMERAL=14;
    public static final int DIGIT=26;
    public static final int PIPE2=12;
    public static final int STRING=22;

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

    // $ANTLR start "EMPTY"
    public final void mEMPTY() throws RecognitionException {
        try {
            int _type = EMPTY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:7:7: ( 'empty' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:7:9: 'empty'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:8:7: ( 'ports' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:8:9: 'ports'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:9:10: ( 'children' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:9:12: 'children'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:10:6: ( 'root' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:10:8: 'root'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:11:9: ( 'unnamed' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:11:11: 'unnamed'
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

    // $ANTLR start "PIPE2"
    public final void mPIPE2() throws RecognitionException {
        try {
            int _type = PIPE2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:75:7: ( '|' '|' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:75:9: '|' '|'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:76:6: ( '|' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:76:8: '|'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:77:8: ( '(' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:77:10: '('
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:78:8: ( ')' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:78:10: ')'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:79:8: ( '{' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:79:10: '{'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:80:8: ( '}' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:80:10: '}'
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

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:81:12: ( '_' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:81:14: '_'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:82:7: ( '/' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:82:9: '/'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:83:7: ( ',' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:83:9: ','
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:84:8: ( '=' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:84:10: '='
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:85:7: ( '->' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:85:9: '->'
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

    // $ANTLR start "NUMERAL"
    public final void mNUMERAL() throws RecognitionException {
        try {
            int _type = NUMERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/bigraphspace/parser/antlr/BigraphTerm.g:87:9: ( ( '~' )? ( DIGIT )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:87:11: ( '~' )? ( DIGIT )+
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:87:11: ( '~' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='~') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:87:11: '~'
                    {
                    match('~'); 

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:87:16: ( DIGIT )+
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
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:87:17: DIGIT
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

            state.type = _type;
            state.channel = _channel;
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:89:8: ( NUMERAL ( '.' ( DIGIT )+ )? ( 'E' NUMERAL )? )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:89:10: NUMERAL ( '.' ( DIGIT )+ )? ( 'E' NUMERAL )?
            {
            mNUMERAL(); 
            // src/bigraphspace/parser/antlr/BigraphTerm.g:89:18: ( '.' ( DIGIT )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:89:20: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:89:24: ( DIGIT )+
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
                    	    // src/bigraphspace/parser/antlr/BigraphTerm.g:89:24: DIGIT
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

            // src/bigraphspace/parser/antlr/BigraphTerm.g:89:34: ( 'E' NUMERAL )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='E') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:89:36: 'E' NUMERAL
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:91:8: ( '\"' (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )* '\"' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:91:10: '\"' (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )* '\"'
            {
            match('\"'); 
            // src/bigraphspace/parser/antlr/BigraphTerm.g:91:14: (~ ( '\\\\' | '\"' ) | '\\\\' STRING_ESCAPE )*
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
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:91:16: ~ ( '\\\\' | '\"' )
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
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:91:30: '\\\\' STRING_ESCAPE
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:93:23: ( 'n' | 't' | '\\\\' )
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:12: ( LETTER ( LETTER | DIGIT )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:14: LETTER ( LETTER | DIGIT )*
            {
            mLETTER(); 
            // src/bigraphspace/parser/antlr/BigraphTerm.g:95:21: ( LETTER | DIGIT )*
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:97:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:97:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:97:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:99:13: ( ( '/' '/' | '#' ) (~ '\\n' )* )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:99:15: ( '/' '/' | '#' ) (~ '\\n' )*
            {
            // src/bigraphspace/parser/antlr/BigraphTerm.g:99:15: ( '/' '/' | '#' )
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
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:99:17: '/' '/'
                    {
                    match('/'); 
                    match('/'); 

                    }
                    break;
                case 2 :
                    // src/bigraphspace/parser/antlr/BigraphTerm.g:99:27: '#'
                    {
                    match('#'); 

                    }
                    break;

            }

            // src/bigraphspace/parser/antlr/BigraphTerm.g:99:33: (~ '\\n' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/bigraphspace/parser/antlr/BigraphTerm.g:99:35: ~ '\\n'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:101:16: ( '0' .. '9' )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:101:18: '0' .. '9'
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
            // src/bigraphspace/parser/antlr/BigraphTerm.g:103:17: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // src/bigraphspace/parser/antlr/BigraphTerm.g:103:19: ( 'A' .. 'Z' | 'a' .. 'z' )
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
        // src/bigraphspace/parser/antlr/BigraphTerm.g:1:8: ( BIGRAPH | RULE | EMPTY | PORTS | CHILDREN | ROOT | UNNAMED | PIPE2 | PIPE | LPAREN | RPAREN | LBRACE | RBRACE | UNDERSCORE | SLASH | COMMA | EQUALS | ARROW | NUMERAL | NUMBER | STRING | IDENTIFIER | WHITESPACE | LINECOMMENT )
        int alt11=24;
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
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:23: EMPTY
                {
                mEMPTY(); 

                }
                break;
            case 4 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:29: PORTS
                {
                mPORTS(); 

                }
                break;
            case 5 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:35: CHILDREN
                {
                mCHILDREN(); 

                }
                break;
            case 6 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:44: ROOT
                {
                mROOT(); 

                }
                break;
            case 7 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:49: UNNAMED
                {
                mUNNAMED(); 

                }
                break;
            case 8 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:57: PIPE2
                {
                mPIPE2(); 

                }
                break;
            case 9 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:63: PIPE
                {
                mPIPE(); 

                }
                break;
            case 10 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:68: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 11 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:75: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 12 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:82: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 13 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:89: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 14 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:96: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 15 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:107: SLASH
                {
                mSLASH(); 

                }
                break;
            case 16 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:113: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 17 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:119: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 18 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:126: ARROW
                {
                mARROW(); 

                }
                break;
            case 19 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:132: NUMERAL
                {
                mNUMERAL(); 

                }
                break;
            case 20 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:140: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 21 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:147: STRING
                {
                mSTRING(); 

                }
                break;
            case 22 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:154: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 23 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:165: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 24 :
                // src/bigraphspace/parser/antlr/BigraphTerm.g:1:176: LINECOMMENT
                {
                mLINECOMMENT(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\6\24\1\37\5\uffff\1\40\4\uffff\1\41\4\uffff\7\24\5\uffff"+
        "\10\24\1\62\1\63\5\24\2\uffff\1\71\1\72\3\24\2\uffff\2\24\1\100"+
        "\1\24\1\102\1\uffff\1\103\2\uffff";
    static final String DFA11_eofS =
        "\104\uffff";
    static final String DFA11_minS =
        "\1\11\1\151\1\157\1\155\1\157\1\150\1\156\1\174\5\uffff\1\57\3"+
        "\uffff\1\60\1\56\4\uffff\1\147\1\154\1\157\1\160\1\162\1\151\1\156"+
        "\5\uffff\1\162\1\145\3\164\1\154\2\141\2\60\1\171\1\163\1\144\1"+
        "\155\1\160\2\uffff\2\60\1\162\1\145\1\150\2\uffff\1\145\1\144\1"+
        "\60\1\156\1\60\1\uffff\1\60\2\uffff";
    static final String DFA11_maxS =
        "\1\176\1\151\1\165\1\155\1\157\1\150\1\156\1\174\5\uffff\1\57\3"+
        "\uffff\1\71\1\105\4\uffff\1\147\1\154\1\157\1\160\1\162\1\151\1"+
        "\156\5\uffff\1\162\1\145\3\164\1\154\2\141\2\172\1\171\1\163\1\144"+
        "\1\155\1\160\2\uffff\2\172\1\162\1\145\1\150\2\uffff\1\145\1\144"+
        "\1\172\1\156\1\172\1\uffff\1\172\2\uffff";
    static final String DFA11_acceptS =
        "\10\uffff\1\12\1\13\1\14\1\15\1\16\1\uffff\1\20\1\21\1\22\2\uffff"+
        "\1\25\1\26\1\27\1\30\7\uffff\1\10\1\11\1\17\1\23\1\24\17\uffff\1"+
        "\2\1\6\5\uffff\1\3\1\4\5\uffff\1\1\1\uffff\1\7\1\5";
    static final String DFA11_specialS =
        "\104\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\25\1\uffff\2\25\22\uffff\1\25\1\uffff\1\23\1\26\4\uffff"+
            "\1\10\1\11\2\uffff\1\16\1\20\1\uffff\1\15\12\22\3\uffff\1\17"+
            "\3\uffff\32\24\4\uffff\1\14\1\uffff\1\24\1\1\1\5\1\24\1\3\12"+
            "\24\1\4\1\24\1\2\2\24\1\6\5\24\1\12\1\7\1\13\1\21",
            "\1\27",
            "\1\31\5\uffff\1\30",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "",
            "",
            "",
            "",
            "\1\26",
            "",
            "",
            "",
            "\12\22",
            "\1\42\1\uffff\12\22\13\uffff\1\42",
            "",
            "",
            "",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "",
            "",
            "",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\73",
            "\1\74",
            "\1\75",
            "",
            "",
            "\1\76",
            "\1\77",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\101",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
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
            return "1:1: Tokens : ( BIGRAPH | RULE | EMPTY | PORTS | CHILDREN | ROOT | UNNAMED | PIPE2 | PIPE | LPAREN | RPAREN | LBRACE | RBRACE | UNDERSCORE | SLASH | COMMA | EQUALS | ARROW | NUMERAL | NUMBER | STRING | IDENTIFIER | WHITESPACE | LINECOMMENT );";
        }
    }
 

}