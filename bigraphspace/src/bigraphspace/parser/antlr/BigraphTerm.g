grammar BigraphTerm;

options { output=AST; }

tokens {
	BIGRAPH = 'bigraph';
	RULE = 'rule';
	/* abstract */
	EMPTY = 'empty';
	PORTS = 'ports';
	CHILDREN = 'children';
	ROOT = 'root';
	UNNAMED = 'unnamed';
	CONTROL = 'control';
	NODE = 'node';
}

@parser::header { package bigraphspace.parser.antlr; }
@lexer::header { package bigraphspace.parser.antlr; }

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

start 
: BIGRAPH^ wide EOF
| RULE^ wide ARROW! wide EOF
;
    
wide
: wide1 ( PIPE2 wide1 )* -> wide1+
;

wide1
: prime -> ^( ROOT prime )
;

prime
: -> ^( EMPTY )
| LSQUARE NUMERAL? RSQUARE -> ^( UNDERSCORE NUMERAL? )
| node ( PIPE node )* -> node+ 
;

/*-> ^( PIPE node* )*/
node
: control ports? children? -> ^( NODE control ^( PORTS ports? ) ^( CHILDREN children? ) )
;

control
: tuple COLON type -> ^( CONTROL type tuple )
| IDENTIFIER indexes? -> ^( CONTROL IDENTIFIER indexes? )
;

indexes
: LANGLE ( index ( COMMA index )* )? RANGLE -> index*
;

/* can't seem to get number to work */
index
: NUMERAL 
| STRING 
| IDENTIFIER 
;

tuple
: index ( COMMA index )* -> index*
;

/* only simple for now */
type
: IDENTIFIER -> IDENTIFIER
;

ports
: LBRACE ( port_value ( COMMA port_value )* )? RBRACE -> port_value*
;

port_value
: IDENTIFIER^ EQUALS! link_name
| link_name -> ^( UNNAMED link_name )
;

link_name
: IDENTIFIER
| constant
;

constant
: NUMBER
| STRING
;

children
: LPAREN prime RPAREN -> prime
;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PIPE2 : '|' '|';
PIPE : '|';
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LANGLE : '<';
RANGLE : '>';
UNDERSCORE : '_';
SLASH : '/';
COMMA : ',';
EQUALS : '=';
ARROW : '->';
COLON : ':';
LSQUARE: '[';
RSQUARE: ']';

NUMERAL	: '~'? (DIGIT)+ ;

NUMBER : NUMERAL ( '.' DIGIT+ )? ( 'E' NUMERAL )? ;

STRING : '"' ( ~('\\'|'"') | '\\' STRING_ESCAPE )* '"';

fragment STRING_ESCAPE: 'n' | 't' | '\\';

IDENTIFIER : LETTER ( LETTER | DIGIT )* ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ 	{ $channel = HIDDEN; } ;

LINECOMMENT : ( '/' '/' | '#' ) ( ~'\n' )* { $channel = HIDDEN; } ;

fragment DIGIT	: '0'..'9' ;

fragment LETTER	: ( 'A'..'Z' | 'a'..'z' ) ;
