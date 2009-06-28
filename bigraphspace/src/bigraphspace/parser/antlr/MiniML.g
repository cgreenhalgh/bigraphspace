grammar MiniML;

options { output=AST; }

tokens {
	SEMICOLON = ';';
	LPAREN = '(';
	RPAREN = ')';
	COMMA = ',';
	LET = 'let';
	END = 'end';
	IN 	= 'in';
	FN = 'fn';
	AND = 'and';
	UNDERSCORE = '_';
	VAL = 'val';
	PIPE = '|';
	DOT = '.';
	/* abstract */
	APPLY = 'apply';
}

@parser::header { package bigraphspace.parser.antlr; }
@lexer::header { package bigraphspace.parser.antlr; }

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

start 
    : p^ EOF 
    ;
    
p 	: ( tld (SEMICOLON^ tld)* SEMICOLON^)
    ;

tld : expression 
	;

expression 
  	: infix_expression 
    | FN^ match
  	;
  	
match
    : pattern IMPLIES^ expression 
  	;
  	/*( PIPE pattern IMPLIES expression )* */
infix_expression
options { backtrack=true; }
	: atomic_expression atomic_expression+ -> ^( APPLY atomic_expression* )
	| atomic_expression 
	;
/* 	| infix_expression infix_operator infix_expression 
 infix_operator
    : PLUS
    ;
 */
atomic_expression
    : IDENTIFIER^
    | constant 
    | LET^ declaration IN! expression ( SEMICOLON! expression )* END!
    | LPAREN^ expression ( COMMA! expression )* RPAREN!
	;
	
constant
    : NUMBER^ 
    | STRING^
    ;
	
declaration
    : 
    | simple_declaration ( SEMICOLON^ simple_declaration )* 
    ;
    /* -> ^( SEMICOLON simple_declaration* ) */
    
simple_declaration
    : value_declaration
    ;
    
value_declaration
    : VAL^ pattern EQUALS! expression ( AND^ pattern EQUALS! expression )*
    ;
pattern
    : atomic_pattern
    ;
atomic_pattern
    : UNDERSCORE
    | compound_name
    ;
compound_name
    : IDENTIFIER ( DOT IDENTIFIER )*
    ;
    
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

IMPLIES : '=' '>';

EQUALS : '=';

fragment NUMERAL	: '~'? (DIGIT)+ ;

NUMBER : NUMERAL ( '.' DIGIT+ )? ( 'E' NUMERAL )? ;

STRING : '"' ( ~('\\'|'"') | '\\' STRING_ESCAPE )* '"';

fragment STRING_ESCAPE: 'n' | 't' | '\\';

IDENTIFIER : LETTER ( LETTER | DIGIT )* ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ 	{ $channel = HIDDEN; } ;

fragment DIGIT	: '0'..'9' ;

fragment LETTER	: ( 'A'..'Z' | 'a'..'z' ) ;
