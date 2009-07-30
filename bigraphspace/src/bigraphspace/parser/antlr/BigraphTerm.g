grammar BigraphTerm;

options { output=AST; }

tokens {
	BIGRAPH = 'bigraph';
	RULE = 'rule';
	WHERE = 'where';
	AND = 'and';
	IN = 'in';
	NOT = 'not';
	LENGTH = 'length';
	MATCHES = 'matches';
	
	/* abstract */
	EMPTY = 'empty';
	PORTS = 'ports';
	CHILDREN = 'children';
	ROOT = 'root';
	UNNAMED = 'unnamed';
	CONTROL = 'control';
	NODE = 'node';
	ONEOF = 'oneof';
	NOTONEOF = 'notoneof';
//	VARIABLE = 'variable';
	CONSTRAINT = 'constraint';
	MINLENGTH = 'minlength';
	MAXLENGTH = 'maxlength';
	MINVALUE = 'minvalue';
	MAXVALUE = 'maxvalue';
	REGEXP = 'regexp';
}

@parser::header { package bigraphspace.parser.antlr; }
@lexer::header { package bigraphspace.parser.antlr; }

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

start 
: BIGRAPH^ wide where? EOF
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
| LSQUARE NUMBER? RSQUARE -> ^( UNDERSCORE NUMBER? )
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
/* | DOLLAR IDENTIFIER -> ^( VARIABLE IDENTIFIER ) */
index
: NUMBER 
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

where
: WHERE whereclause ( AND whereclause )* -> ^( WHERE whereclause+ )
;

whereclause
: IDENTIFIER COLON type -> ^( CONSTRAINT IDENTIFIER COLON type )
| IDENTIFIER NOT IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER NOTONEOF index* )
| IDENTIFIER IN LBRACE ( index ( COMMA index )* )? RBRACE -> ^( CONSTRAINT IDENTIFIER ONEOF index* )
| IDENTIFIER LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXVALUE NUMBER )
| IDENTIFIER GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINVALUE NUMBER )
| LENGTH LPAREN IDENTIFIER RPAREN LESSTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MAXLENGTH NUMBER )
| LENGTH LPAREN IDENTIFIER RPAREN GREATERTHANOREQUAL NUMBER -> ^( CONSTRAINT IDENTIFIER MINLENGTH NUMBER )
| IDENTIFIER MATCHES STRING -> ^( CONSTRAINT IDENTIFIER REGEXP STRING )
| i=IDENTIFIER EQUALS j=IDENTIFIER PLUS NUMBER -> ^( CONSTRAINT $i PLUS $j NUMBER )
| i=IDENTIFIER EQUALS j=IDENTIFIER MINUS NUMBER -> ^( CONSTRAINT $i MINUS $j NUMBER )
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
DOLLAR: '$';
LESSTHANOREQUAL: '<=';
GREATERTHANOREQUAL: '>=';
PLUS: '+';
MINUS: '-';

fragment NUMERAL	: '~'? (DIGIT)+ ;

NUMBER : NUMERAL ( '.' DIGIT+ )? ;

STRING : '"' ( ~('\\'|'"') | '\\' STRING_ESCAPE )* '"';

fragment STRING_ESCAPE: 'n' | 't' | '\\';

IDENTIFIER : DOLLAR? LETTER ( LETTER | DIGIT )* ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ 	{ $channel = HIDDEN; } ;

LINECOMMENT : ( '/' '/' | '#' ) ( ~'\n' )* { $channel = HIDDEN; } ;

fragment DIGIT	: '0'..'9' ;

fragment LETTER	: ( 'A'..'Z' | 'a'..'z' ) ;
