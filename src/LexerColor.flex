import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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
Identificador = {L}({L}|{D})*
/*Cadena*/
L=[A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
D=[0-9]
Cadena= ({L}{D})+
/* Número */
Numero = 0|[+-]?([1-9][0-9]*)
/* Decimal */
Ndecimal = [+-]?([0-9].[0-9]*)


/* Definición de macros para caracteres válidos */
Igualdad = "=="
Desigualdad = "!="
MayorQue = ">>"
MenorQue = "<<"
MayorIgualQue = ">="
MenorIgualQue = "<="
AndLogico = "&&"
OrLogico = "||"
NotLogico = "!"
Asignacion = "="
Incremento = "\'+"
Decremento = "\'-"
Suma = "++"
Resta = "--"
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

/* Combinación de macros en CaracteresValidos */
CaracteresValidos = {Igualdad} | {Desigualdad} | {MayorQue} | {MenorQue} | {MayorIgualQue} | {MenorIgualQue} | {AndLogico} | {OrLogico} | {NotLogico} | {Asignacion} | {Incremento} | {Decremento} | {Suma} | {Resta} | {Multiplicacion} | {Division} | {Modulo} | {ParA} | {ParC} | {CorA} | {CorC} | {ParCuaA} | {ParCuaC} | {Decimal} | {FinLinea} | {Separador} | {Comilla} | {ComillaS} | {Dinero} | {ComillaD}
%%
/* Palabras reservadas */
"categoria" | "concatenar"| "sumar" | "fecha" | "cuenta" | "si" | "sino" | "cambio" | "caso" | "mientras" | "para" | "sumar" | "restar" | "dividir" | "promedio" | "maximo" | "minimo" | "desviacionE" | "imprimir" | "leer" | "mostrar" | "exportar" | "importar" | "eliminar" | "actualizar" | "guardar" | "buscar" | "ordenar" | "INICIO" | "FIN" | "FUNCION" | "retorno" | "CLASE" | "hacer" | "intentar" | "VAR" | "asc" | "desc" | "entero" | "decimal" | "texto" | "enteroL" | "logico" | "corto" | "redondear" | "Pi" | "Eu" | "raiz" | "raiz2" { return textColor(yychar, yylength(), new Color(73, 255, 0)); }
{CaracteresValidos} {
    switch (yytext()) {
        case "==": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "!=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case ">>": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "<<": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case ">=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "<=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "&&": return textColor (yychar, yylength(), new Color( 224, 33, 163));
        case "||": return textColor (yychar, yylength(), new Color( 224, 33, 163));
        case "!": return textColor (yychar, yylength(), new Color( 224, 33, 163));
        case "=": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "\'+": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "\'-": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "++": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "--": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "**": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "//": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "%%": return textColor (yychar, yylength(), new Color(224, 224, 33));
        case "(": return textColor (yychar, yylength(), new Color(   200, 227, 0 ));
        case ")": return textColor (yychar, yylength(), new Color(   200, 227, 0 ));
        case "{": return textColor (yychar, yylength(), new Color(   220, 227, 0  ));
        case "}": return textColor (yychar, yylength(), new Color(   220, 227, 0  ));
        case "[": return textColor (yychar, yylength(), new Color(  300, 227, 0 ));
        case "]": return textColor (yychar, yylength(), new Color(  300, 227, 0 ));
        case ".": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case ";": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case ",": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case "\"": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case "'": return textColor (yychar, yylength(), new Color(255, 0, 100));
        case "$": return textColor (yychar, yylength(), new Color(255, 0, 100));
    }
}
/* Identificador */
"#" {Identificador}  { return textColor(yychar, yylength(), new Color(  100, 227, 191 )); }
/*Tipo de Datos*/
Entero { return textColor(yychar, yylength(), new Color(  216, 37, 208  )); }
Booleano { return textColor(yychar, yylength(), new Color(  216, 37, 208  )); }
Flotante { return textColor(yychar, yylength(), new Color(  216, 37, 208  )); }
Cadena { return textColor(yychar, yylength(), new Color(  216, 37, 208  )); }
Caracter { return textColor(yychar, yylength(), new Color(  216, 37, 208  )); }

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(  142,142,142  )); }
{Numero}|{Ndecimal}  { return textColor(yychar, yylength(), new Color(0, 112, 255));}
/* Regla para errores */
   . |{Identificador}  {return textColor(yychar, yylength(), new Color( 255, 0, 0 ));}
   . {return textColor(yychar, yylength(), new Color( 255, 0, 0 ));}
