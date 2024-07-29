import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables basicas */

TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/" [^] ~"/" | "/" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^] | \+ [^/] )
ComentarioDeDocumentacion = "/" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
L = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
D = [0-9]
IDENTIFICADOR = {L}({L}|{D})*

/* Número */
NUMERO = 0|[+-]?([1-9][0-9]*)

/* Cadena */
Cadena = \"([^\\\"]|\\.)*\"

/* Definición de macros para caracteres válidos */
Igualdad = "=="
Desigualdad = "!="
MayorQue = ">"
MenorQue = "<"
MayorIgualQue = ">="
MenorIgualQue = "<="
AndLogico = "&&"
OrLogico = "||"
NotLogico = "!"
Asignacion = "="
Incremento = "\'+"
Decremento = "\'-"
Suma = "++"
Resta = "-"
Multiplicacion = "**"
Division = "//"
Modulo = "%%"
ParA = "("
ParC = ")"
CorA = "{"
CorC = "}"
ParCuaA = "["
ParCuaC = "]"
Decimal = "."
FinLinea = ";"
Separador = ","
Comilla = "\""
ComillaS = "'"
Dinero = "$"
ComillaD = "\""
Gbajo = "_"
Sep = "&"

/* Combinación de macros en CaracteresValidos */
CaracteresValidos = {Sep}|{Gbajo} |{Igualdad} | {Desigualdad} | {MayorQue} | {MenorQue} | {MayorIgualQue} | {MenorIgualQue} | {AndLogico} | {OrLogico} | {NotLogico} | {Asignacion} | {Incremento} | {Decremento} | {Suma} | {Resta} | {Multiplicacion} | {Division} | {Modulo} | {ParA} | {ParC} | {CorA} | {CorC} | {ParCuaA} | {ParCuaC} | {Decimal} | {FinLinea} | {Separador} | {Comilla} | {ComillaS} | {Dinero} | {ComillaD}

/* Palabras reservadas */
VARIABLES = "VARIABLES"
PROCESOS = "PROCESOS"
SI = "SI"
SINO = "SINO"
MIENTRAS = "MIENTRAS"
IMPRIMIR = "IMPRIMIR"
ENTERO = "ENTERO"
DECIMAL = "DECIMAL"
BOOLEANO = "BOOLEANO"
TEXTO = "TEXTO"
VERDADERO = "verdadero"
FALSO = "falso"
GENERAR_MAPA = "generar_mapa"

PalabrasReservadas = {GENERAR_MAPA}|{VARIABLES}|{PROCESOS}|{SI}|{SINO}|{MIENTRAS}|{IMPRIMIR}|{ENTERO}|{DECIMAL}|{BOOLEANO}|{TEXTO}|{VERDADERO}|{FALSO}

%%

{Comentario}|{EspacioEnBlanco} { /* Ignorar */ }

{CaracteresValidos} 
{
    switch (yytext()) {
        case "&" :return token(yytext(), "SEP", yyline, yycolumn);
        case "_" :return token(yytext(), "GBAJO", yyline, yycolumn);
        case "==": return token(yytext(), "IGUALDAD", yyline, yycolumn);
        case "!=": return token(yytext(), "DESIGUALDAD", yyline, yycolumn);
        case ">": return token(yytext(), "MAYOR", yyline, yycolumn);
        case "<": return token(yytext(), "MENOR", yyline, yycolumn);
        case ">=": return token(yytext(), "MAYORIGUALQUE", yyline, yycolumn);
        case "<=": return token(yytext(), "MENORIGUALQUE", yyline, yycolumn);
        case "&&": return token(yytext(), "ANDLOGICO", yyline, yycolumn);
        case "||": return token(yytext(), "ORLOGICO", yyline, yycolumn);
        case "!": return token(yytext(), "NOTLOGICO", yyline, yycolumn);
        case "=": return token(yytext(), "ASIGNACION", yyline, yycolumn);
        case "\'+": return token(yytext(), "INCREMENTO", yyline, yycolumn);
        case "\'-": return token(yytext(), "DECREMENTO", yyline, yycolumn);
        case "++": return token(yytext(), "SUMA", yyline, yycolumn);
        case "-": return token(yytext(), "RESTA", yyline, yycolumn);
        case "**": return token(yytext(), "MULTIPLICACION", yyline, yycolumn);
        case "//": return token(yytext(), "DIVISION", yyline, yycolumn);
        case "%%": return token(yytext(), "MODULO", yyline, yycolumn);
        case "(": return token(yytext(), "PARA", yyline, yycolumn);
        case ")": return token(yytext(), "PARC", yyline, yycolumn);
        case "{": return token(yytext(), "CORA", yyline, yycolumn);
        case "}": return token(yytext(), "CORC", yyline, yycolumn);
        case "[": return token(yytext(), "CORCHETE_ABIERTO", yyline, yycolumn);
        case "]": return token(yytext(), "CORCHETE_CERRADO", yyline, yycolumn);
        case ".": return token(yytext(), "PUNTO", yyline, yycolumn);
        case ";": return token(yytext(), "FINLINEA", yyline, yycolumn);
        case ",": return token(yytext(), "SEPARADOR", yyline, yycolumn);
        case "\"": return token(yytext(), "COMILLA", yyline, yycolumn);
        case "'": return token(yytext(), "COMILLASIMPLE", yyline, yycolumn);
        case "$": return token(yytext(), "DINERO", yyline, yycolumn);
    }
}

/* Switch para acceder a cada palabra reservada */
{PalabrasReservadas} {
    switch(yytext()) {
        case "VARIABLES": return token(yytext(), "VARIABLES", yyline, yycolumn);
        case "PROCESOS": return token(yytext(), "PROCESOS", yyline, yycolumn);
        /* Operaciones básicas */
        case "SI": return token(yytext(), "SI", yyline, yycolumn);
        case "SINO": return token(yytext(), "SINO", yyline, yycolumn);
        case "MIENTRAS": return token(yytext(), "MIENTRAS", yyline, yycolumn);
        case "IMPRIMIR": return token(yytext(), "IMPRIMIR", yyline, yycolumn);
        case "ENTERO": return token(yytext(), "ENTERO", yyline, yycolumn);
        /* Operaciones avanzadas */
        case "DECIMAL": return token(yytext(), "DECIMAL", yyline, yycolumn);
        case "BOOLEANO": return token(yytext(), "BOOLEANO", yyline, yycolumn);
        case "TEXTO": return token(yytext(), "TEXTO", yyline, yycolumn);
        case "VERDADERO ": return token(yytext(), "VERDADERO ", yyline, yycolumn);
        case "FALSO ": return token(yytext(), "FALSO", yyline, yycolumn);
        case "GENERAR_MAPA ": return token(yytext(), "GENERAR_MAPA ", yyline, yycolumn);
    }
}

{IDENTIFICADOR} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

{NUMERO} { return token(yytext(), "NUMERO", yyline, yycolumn); }
{NUMERO}{Decimal}{NUMERO} { return token(yytext(), "NDECIMAL", yyline, yycolumn); }

{Cadena} { return token(yytext(), "CADENA", yyline, yycolumn); }
"#" {Comilla}({IDENTIFICADOR}|{EspacioEnBlanco}|.|,|:|;)*{Comilla} { return token(yytext(), "CADENA", yyline, yycolumn); }

/* Regla para errores */
. { return token(yytext(), "ERROR", yyline, yycolumn); }