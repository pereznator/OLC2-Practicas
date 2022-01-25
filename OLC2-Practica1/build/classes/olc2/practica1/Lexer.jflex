//Primera Parte
/*----------------------------------Codigo de Usuario-----------------------------------*/
package olc2.practica1;

import java.util.LinkedList;
import java_cup.runtime.Symbol;


//Segunda Parte
/*-----------------------------------Opciones y Declaraciones---------------------------*/

%%

%{
    public LinkedList<String> tkns = new LinkedList<String>();
%}

%public
%class LexerPractica
%cup
%type java_cup.runtime.Symbol
%column
%line
%char
%full
%ignorecase
%unicode

espacio=[ \n\t\r]+

%%

//Tercera Parte
/*-----------------------------------Reglas Lexicas-------------------------------------*/

<YYINITIAL> ([a-zA-Z]|[0-9])* {
                                    tkns.add(yytext());
                                    return new Symbol(sym.PALABRA, yycolumn, yyline, yytext());
                                }

<YYINITIAL> ","                 {
                                    return new Symbol(sym.COMA, yycolumn, yyline, yytext());
                                }

<YYINITIAL> {espacio} { /* IGNORAR */ }

<YYINITIAL> .                   {
                                    System.out.println("Error: " + yytext());
                                }

