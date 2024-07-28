/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import compilerTools.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kevin Alberto Perez
 */
public class FarnezeCompiler {

    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errores;
    private ArrayList<Production> identProd;
    private ArrayList<Production> mainProd;
    private ArrayList<Production> compProd;
    private ArrayList<Production> opProd;
    private ArrayList<Production> mientrasProd;
    private ArrayList<Production> imprimirProd;
    private HashMap<String, String> identificadores;
    private HashMap<String, String[]> tablaSimbolos;
    private Grammar gramatica;

    //Parte semantica 
    private HashMap<String, VariableInfo> symbolTable;
    private ArrayList<String> semanticErrors;

    public FarnezeCompiler() {
        init();
        symbolTable = new HashMap<>();
        semanticErrors = new ArrayList<>();
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<ErrorLSSL> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<ErrorLSSL> errores) {
        this.errores = errores;
    }

    public ArrayList<String> getSemanticErrors() {
        return semanticErrors;
    }

    public void setSemanticErrors(ArrayList<String> semanticErrors) {
        this.semanticErrors = semanticErrors;
    }
    

    private void init() {
        tokens = new ArrayList<>();
        errores = new ArrayList<>();
        identProd = new ArrayList<>();
        mainProd = new ArrayList<>();
        compProd = new ArrayList<>();
        opProd = new ArrayList<>();
        mientrasProd = new ArrayList<>();
        imprimirProd = new ArrayList<>();
        identificadores = new HashMap<>();
        tablaSimbolos = new HashMap<>();
    }
    
    public void syntacticAnalysis() {
        gramatica = new Grammar(tokens, errores);
        gramatica.delete(new String[]{"ERROR", "ERROR_1", "Error_2"}, 1);
        //Principal
        gramatica.group("programa", "bloque_variables bloque_procesos");
        /**
         * ***************************************************
         */
        // Producciones de error de principal
        gramatica.group("programa", "bloque_procesos", 1001, "Error Sintáctico: Falta el bloque de variables al inicio del programa [#,%]");
        gramatica.group("programa", "bloque_variables", 1002, "Error Sintáctico: Falta el bloque de procesos en el programa [#,%]");
        gramatica.group("programa", "bloque_procesos bloque_variables", 1003, "Error Sintáctico: El bloque de procesos debe ir después del bloque de variables [#,%]");
        gramatica.group("programa", "bloque_variables bloque_procesos (bloque_variables | bloque_procesos)+", 1004, "Error Sintáctico: Se encontraron bloques adicionales no permitidos después de los bloques principales [#,%]");
        gramatica.group("programa", "", 1005, "Error Sintáctico: El programa está vacío, se requieren los bloques de variables y procesos [#,%]");
        /**
         * ***************************************************
         */
        // Bloque de variables 
        //Produccion correcta bloque de variables
        gramatica.group("bloque_variables", "VARIABLES CORA (variable)* CORC");
        // Producciones de error
        gramatica.group("bloque_variables", "VARIABLES (variable)* CORC", 2001, "Error Sintáctico: Falta la llave de apertura '{' en el bloque de variables [#,%]");
        gramatica.group("bloque_variables", "VARIABLES CORA (variable)*", 2002, "Error Sintáctico: Falta la llave de cierre '}' en el bloque de variables [#,%]");
        gramatica.group("bloque_variables", "CORA (variable)* CORC", 2003, "Error Sintáctico: Falta la palabra clave 'VARIABLES' al inicio del bloque de variables [#,%]");

        /**
         * ***************************************************
         */
        //Declaracion de variables individuales:
        // Producción correcta
        gramatica.group("variable", "(ENTERO | DECIMAL | BOOLEANO | TEXTO) IDENTIFICADOR ASIGNACION (NUMERO | NDECIMAL | CADENA | VERDADERO | FALSO) FINLINEA ", identProd);
        // Producciones de error
        gramatica.group("variable", "IDENTIFICADOR ASIGNACION (NUMERO | NDECIMAL | CADENA | VERDADERO | FALSO) FINLINEA", 2101, "Error Sintáctico: Falta el tipo de dato en la declaración de la variable [#,%]");
        gramatica.group("variable", "(ENTERO | DECIMAL | BOOLEANO | TEXTO) ASIGNACION (NUMERO | NDECIMAL | CADENA | VERDADERO | FALSO) FINLINEA", 2102, "Error Sintáctico: Falta el identificador en la declaración de la variable [#,%]");
        gramatica.group("variable", "(ENTERO | DECIMAL | BOOLEANO | TEXTO) IDENTIFICADOR (NUMERO | NDECIMAL | CADENA | VERDADERO | FALSO) FINLINEA", 2103, "Error Sintáctico: Falta el operador de asignación '=' en la declaración de la variable [#,%]");
        gramatica.group("variable", "(ENTERO | DECIMAL | BOOLEANO | TEXTO) IDENTIFICADOR ASIGNACION FINLINEA", 2104, "Error Sintáctico: Falta el valor asignado a la variable [#,%]");
        gramatica.group("variable", "(ENTERO | DECIMAL | BOOLEANO | TEXTO) IDENTIFICADOR ASIGNACION (NUMERO | NDECIMAL | CADENA | VERDADERO | FALSO)", 2105, "Error Sintáctico: Falta el punto y coma ';' al final de la declaración de la variable [#,%]");

        //Error de variable que no coincide con el tipo de dato
        // Error de tipo de dato no coincidente
        gramatica.group("variable", "ENTERO IDENTIFICADOR ASIGNACION (NDECIMAL | CADENA) FINLINEA", 2106, "Error Sintáctico: Tipo de dato no coincidente. Se esperaba un NUMERO para ENTERO [#,%]");
        gramatica.group("variable", "DECIMAL IDENTIFICADOR ASIGNACION CADENA FINLINEA", 2107, "Error Sintáctico: Tipo de dato no coincidente. Se esperaba un NUMERO o NDECIMAL para DECIMAL [#,%]");
        gramatica.group("variable", "BOOLEANO IDENTIFICADOR ASIGNACION (NUMERO | NDECIMAL | CADENA) FINLINEA", 2108, "Error Sintáctico: Tipo de dato no coincidente. Se esperaba VERDADERO o FALSO para BOOLEANO [#,%]");
        gramatica.group("variable", "TEXTO IDENTIFICADOR ASIGNACION (NUMERO | NDECIMAL | VERDADERO | FALSO) FINLINEA", 2109, "Error Sintáctico: Tipo de dato no coincidente. Se esperaba una CADENA para TEXTO [#,%]");
        /**
         * ***************************************************
         */

// Producción correcta
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", mainProd);
// Producciones de error
        gramatica.group("bloque_procesos", "PROCESOS (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 3001, "Error Sintáctico: Falta la llave de apertura '{' en el bloque de procesos [#,%]");
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras | imprimir)*", 3002, "Error Sintáctico: Falta la llave de cierre '}' en el bloque de procesos [#,%]");
        gramatica.group("bloque_procesos", "CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 3003, "Error Sintáctico: Falta la palabra clave 'PROCESOS' al inicio del bloque de procesos [#,%]");
        gramatica.group("bloque_procesos", "PROCESOS CORA CORC", 3004, "Advertencia: El bloque de procesos está vacío [#,%]");
        gramatica.group("bloque_procesos", "PROCESOS CORA (IDENTIFICADOR | NUMERO | CADENA | VERDADERO | FALSO)+ CORC", 3005, "Error Sintáctico: Se encontraron elementos no válidos en el bloque de procesos. Se esperaban operaciones, estructuras de control o impresiones [#,%]");
        //Comprobar errores comunes al declarar variables dentro del bloque de procesos.
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras | imprimir)* (VARIABLES | ENTERO | DECIMAL | BOOLEANO | TEXTO) (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 3006, "Error Sintáctico: Se encontró una declaración de variable dentro del bloque de procesos. Las variables deben declararse en el bloque de variables [#,%]");
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras | imprimir)* FINLINEA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 3007, "Error Sintáctico: Se encontró un punto y coma ';' suelto dentro del bloque de procesos [#,%]");

        //operaciones Generales 
//Produccion Correcta
        gramatica.group("operaciones", "(operaciones_basicas | operaciones_avanzadas | operaciones_trigonometricas | operaciones_estadisticas | asignar)*", opProd);
//Produccion de error
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones_avanzadas", "(POTENCIA | RAIZ_CUADRADA | RAIZ_ENESIMA | LOGARITMO_NATURAL | LOGARITMO_BASE_10 | EXPONENCIAL | VALOR_ABSOLUTO | FACTORIAL | REDONDEO | REDONDEO_HACIA_ABAJO | MAXIMO_COMUN_DIVISOR | MINIMO_COMUN_MULTIPLO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)* PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones_trigonometricas", "(SENO | COSENO | TANGENTE) PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones_estadisticas", "(MEDIANA | VAR | DESVESTA | PROMEDIO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("asignar", "ASIGNAR PARCUAA IDENTIFICADOR PARCUAC ASIGNACION (IDENTIFICADOR | VERDADERO | FALSO) FINLINEA");

        //Estructuras de control
        // Producción correcta
        gramatica.group("estructura_si", "SI PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC");
// Producciones de error
        gramatica.group("estructura_si", "SI comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 4001, "Error Sintáctico: Falta el paréntesis de apertura '(' después de 'SI' [#,%]");
        gramatica.group("estructura_si", "SI PARA comparacion CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 4002, "Error Sintáctico: Falta el paréntesis de cierre ')' después de la condición [#,%]");
        gramatica.group("estructura_si", "SI PARA comparacion PARC (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 4003, "Error Sintáctico: Falta la llave de apertura '{' en la estructura SI [#,%]");
        gramatica.group("estructura_si", "SI PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)*", 4004, "Error Sintáctico: Falta la llave de cierre '}' en la estructura SI [#,%]");
        gramatica.group("estructura_si", "SI PARA PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 4005, "Error Sintáctico: Falta la condición en la estructura SI [#,%]");
        gramatica.group("estructura_si", "SI PARA comparacion PARC CORA CORC", 4006, "Advertencia: El cuerpo de la estructura SI está vacío [#,%]");
        gramatica.group("estructura_si", "PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 4007, "Error Sintáctico: Falta la palabra clave 'SI' al inicio de la estructura de control [#,%]");
        gramatica.group("estructura_si", "SI PARA (IDENTIFICADOR | NUMERO | CADENA | VERDADERO | FALSO) PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 4008, "Error Sintáctico: La condición en la estructura SI no es una comparación válida [#,%]");

        gramatica.group("estructura_si", "SI PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC SINO", 4009, "Error Sintáctico: La palabra clave 'SINO' debe ir seguida de un bloque de código [#,%]");
        gramatica.group("estructura_si", "SI PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC SINO CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 4010, "Advertencia: Se ha detectado una estructura SI-SINO. Considere usar 'SINO SI' para múltiples condiciones [#,%]");

        //While o mientras Correcto 
// Producción correcta
        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", mientrasProd);

// Producciones de error
        gramatica.group("estructura_mientras", "MIENTRAS comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5001, "Error Sintáctico: Falta el paréntesis de apertura '(' después de 'MIENTRAS' [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5002, "Error Sintáctico: Falta el paréntesis de cierre ')' después de la condición [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion PARC (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5003, "Error Sintáctico: Falta la llave de apertura '{' en la estructura MIENTRAS [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)*", 5004, "Error Sintáctico: Falta la llave de cierre '}' en la estructura MIENTRAS [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5005, "Error Sintáctico: Falta la condición en la estructura MIENTRAS [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion PARC CORA CORC", 5006, "Advertencia: El cuerpo de la estructura MIENTRAS está vacío [#,%]");
        gramatica.group("estructura_mientras", "PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5007, "Error Sintáctico: Falta la palabra clave 'MIENTRAS' al inicio de la estructura de control [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA (IDENTIFICADOR | NUMERO | CADENA | VERDADERO | FALSO) PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5008, "Error Sintáctico: La condición en la estructura MIENTRAS no es una comparación válida [#,%]");

        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* ROMPER (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5009, "Advertencia: Se ha detectado un 'ROMPER' en el bucle MIENTRAS. Asegúrese de que sea intencional [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA comparacion PARC CORA (operaciones | estructura_si | estructura_mientras | imprimir)* CONTINUAR (operaciones | estructura_si | estructura_mientras | imprimir)* CORC", 5010, "Advertencia: Se ha detectado un 'CONTINUAR' en el bucle MIENTRAS. Asegúrese de que sea intencional [#,%]");
        //Comparar  =! == <= => 
//Produccion correcta
        gramatica.group("comparacion", "expresion (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) expresion", compProd);//Para imprimir 

// Producciones de error
        gramatica.group("comparacion", "(IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) expresion", 6001, "Error Sintáctico: Falta la expresión del lado izquierdo de la comparación [#,%]");
        gramatica.group("comparacion", "expresion expresion", 6002, "Error Sintáctico: Falta el operador de comparación entre las expresiones [#,%]");
        gramatica.group("comparacion", "expresion (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO)", 6003, "Error Sintáctico: Falta la expresión del lado derecho de la comparación [#,%]");
        gramatica.group("comparacion", "expresion (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) expresion (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) expresion", 6004, "Error Sintáctico: Múltiples operadores de comparación detectados. Use paréntesis para agrupar comparaciones complejas [#,%]");

//Imprimir
        gramatica.group("imprimir", "IMPRIMIR PARCUAA (IDENTIFICADOR | CADENA | NUMERO | NDECIMAL)* PARCUAC FINLINEA", imprimirProd);
// Producciones de error
        gramatica.group("imprimir", "IMPRIMIR (IDENTIFICADOR | CADENA | NUMERO | NDECIMAL)* PARCUAC FINLINEA", 7001, "Error Sintáctico: Falta el paréntesis de apertura '(' después de IMPRIMIR [#,%]");
        gramatica.group("imprimir", "IMPRIMIR PARCUAA (IDENTIFICADOR | CADENA | NUMERO | NDECIMAL)* FINLINEA", 7002, "Error Sintáctico: Falta el paréntesis de cierre ')' en la instrucción IMPRIMIR [#,%]");
        gramatica.group("imprimir", "IMPRIMIR PARCUAA PARCUAC FINLINEA", 7003, "Error Sintáctico: No se especificó ningún argumento para imprimir [#,%]");
        gramatica.group("imprimir", "IMPRIMIR PARCUAA (IDENTIFICADOR | CADENA | NUMERO | NDECIMAL)* PARCUAC", 7004, "Error Sintáctico: Falta el punto y coma ';' al final de la instrucción IMPRIMIR [#,%]");
        gramatica.group("imprimir", "PARCUAA (IDENTIFICADOR | CADENA | NUMERO | NDECIMAL)* PARCUAC FINLINEA", 7005, "Error Sintáctico: Falta la palabra clave 'IMPRIMIR' al inicio de la instrucción [#,%]");
        gramatica.group("imprimir", "IMPRIMIR PARCUAA (IDENTIFICADOR | CADENA | NUMERO | NDECIMAL)* (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) (IDENTIFICADOR | CADENA | NUMERO | NDECIMAL)* PARCUAC FINLINEA", 7006, "Error Sintáctico: Se detectó un operador de comparación dentro de IMPRIMIR. Use paréntesis para evaluar la comparación antes de imprimir [#,%]");

        gramatica.group("expresion", "IDENTIFICADOR | NUMERO | NDECIMAL | CADENA | VERDADERO | FALSO");
        gramatica.group("expresion", "expresion OPERADOR_ARITMETICO expresion");
        gramatica.group("expresion", "PARA expresion PARC");
    }

    /**
     * ********************************************************************
     */
    //Analizador lexico apartir de aqui
    public void lexicalAnalysis(String codeText) {
        tokens.clear();
        errores.clear();

        try {
            byte[] bytesText = codeText.getBytes();

            // Crear un archivo temporal
            File codigo = File.createTempFile("codigo_temp", ".farneze");
            try (FileOutputStream output = new FileOutputStream(codigo)) {
                output.write(bytesText);
            }

            // Crear el Lexer
            Lexer lexer = new Lexer(new InputStreamReader(new FileInputStream(codigo), "UTF8"));

            // Obtener los tokens
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }

            // Eliminar el archivo temporal
            codigo.delete();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    /**
     * ***********************************************************************************
     */
    //analizador semantico apartir de aqui
    public void semanticAnalysis() {
        semanticErrors.clear();
        symbolTable.clear();

        analyzeVariableBlock();
        analyzeProcessBlock();
        checkUninitializedVariables();
    }

    private void analyzeVariableBlock() {
        for (Production p : identProd) {
            Token typeToken = p.getTokens().get(0);
            Token identToken = p.getTokens().get(1);
            Token valueToken = p.getTokens().get(3);

            String type = typeToken.getLexeme();
            String ident = identToken.getLexeme();
            String value = valueToken.getLexeme();

            if (symbolTable.containsKey(ident)) {
                semanticErrors.add("Error semántico: Variable '" + ident + "' ya declarada. Línea: " + identToken.getLine());
            } else {
                if (isTypeCompatible(type, value)) {
                    symbolTable.put(ident, new VariableInfo(type, value, identToken.getLine()));
                } else {
                    semanticErrors.add("Error semántico: Tipo incompatible para la variable '" + ident + "'. Se esperaba " + type + " pero se obtuvo " + inferType(value) + ". Línea: " + identToken.getLine());
                }
            }
        }
    }

    private void analyzeProcessBlock() {
    for (Production p : mainProd) {
        List<Token> tokens = p.getTokens();
        if (tokens.isEmpty()) {
            continue;
        }

        String firstToken = tokens.get(0).getLexeme();
        switch (firstToken) {
            case "IMPRIMIR":
                analyzeImprimir(tokens);
                break;
            case "SI":
                analyzeIfStructure(tokens);
                break;
            case "MIENTRAS":
                analyzeWhileStructure(tokens);
                break;
            case "ASIGNAR":
                analyzeAssignment(tokens);
                break;
            default:
                if (isArithmeticOperation(firstToken)) {
                    analyzeArithmeticOperation(tokens);
                    checkDivisionByZero(tokens);
                } else {
                    semanticErrors.add("Error semántico: Estructura no reconocida en el bloque de procesos. Línea: " + tokens.get(0).getLine());
                }
        }
    }
}

    private void analyzeImprimir(List<Token> tokens) {
    for (int i = 1; i < tokens.size() - 1; i++) {  // Ignoramos IMPRIMIR y el token final
        Token t = tokens.get(i);
        if (t.getLexicalComp().equals("IDENTIFICADOR")) {
            if (!symbolTable.containsKey(t.getLexeme())) {
                semanticErrors.add("Error semántico: Variable '" + t.getLexeme() + "' no declarada en IMPRIMIR. Línea: " + t.getLine());
            }
        }
    }
}

    private void analyzeIfStructure(List<Token> tokens) {
    int startIndex = tokens.indexOf(new Token("PARA", "(", 0, 0)) + 1;
    int endIndex = tokens.indexOf(new Token("PARC", ")", 0, 0));

    if (startIndex < endIndex) {
        List<Token> condition = tokens.subList(startIndex, endIndex);
        analyzeCondition(condition, "SI");
        analyzeCodeBlock(tokens.subList(endIndex + 1, tokens.size() - 1));
    } else {
        semanticErrors.add("Error semántico: Condición mal formada en estructura SI. Línea: " + tokens.get(0).getLine());
    }
}

    private void analyzeWhileStructure(List<Token> tokens) {
    int startIndex = tokens.indexOf(new Token("PARA", "(", 0, 0)) + 1;
    int endIndex = tokens.indexOf(new Token("PARC", ")", 0, 0));

    if (startIndex < endIndex) {
        List<Token> condition = tokens.subList(startIndex, endIndex);
        analyzeCondition(condition, "MIENTRAS");
        analyzeCodeBlock(tokens.subList(endIndex + 1, tokens.size() - 1));
    } else {
        semanticErrors.add("Error semántico: Condición mal formada en estructura MIENTRAS. Línea: " + tokens.get(0).getLine());
    }
}

    private void analyzeCodeBlock(List<Token> blockTokens) {
    for (int i = 0; i < blockTokens.size(); i++) {
        Token token = blockTokens.get(i);
        int endIndex = findEndOfInstruction(blockTokens, i);
        List<Token> instructionTokens = blockTokens.subList(i, endIndex);
        
        if (token.getLexeme().equals("IMPRIMIR")) {
            analyzeImprimir(instructionTokens);
        } else if (token.getLexeme().equals("ASIGNAR")) {
            analyzeAssignment(instructionTokens);
        } else if (isArithmeticOperation(token.getLexeme())) {
            analyzeArithmeticOperation(instructionTokens);
        }
        
        i = endIndex - 1; // Restamos 1 porque el bucle for incrementará i
    }
}

    private int findEndOfInstruction(List<Token> tokens, int start) {
        for (int i = start; i < tokens.size(); i++) {
            if (tokens.get(i).getLexeme().equals("FINLINEA")) {
                return i + 1;
            }
        }
        return tokens.size();
    }

    private void analyzeCondition(List<Token> condition, String structureType) {
        if (condition.size() < 3) {
            semanticErrors.add("Error semántico: Condición incompleta en estructura " + structureType + ". Línea: " + condition.get(0).getLine());
            return;
        }

        Token left = condition.get(0);
        Token operator = condition.get(1);
        Token right = condition.get(2);

        String leftType = getTokenType(left);
        String rightType = getTokenType(right);

        if (!leftType.equals(rightType)) {
            semanticErrors.add("Error semántico: Comparación de tipos incompatibles en estructura " + structureType + ". " + leftType + " vs " + rightType + ". Línea: " + left.getLine());
        }

        if (!isComparisonOperator(operator.getLexeme())) {
            semanticErrors.add("Error semántico: Operador de comparación inválido en estructura " + structureType + ". Línea: " + operator.getLine());
        }

        if (leftType.equals("BOOLEANO") && !operator.getLexeme().equals("==") && !operator.getLexeme().equals("!=")) {
            semanticErrors.add("Error semántico: Operador inválido para tipo booleano en estructura " + structureType + ". Línea: " + operator.getLine());
        }
        if ((leftType.equals("ENTERO") || leftType.equals("DECIMAL")) && (operator.getLexeme().equals("&&") || operator.getLexeme().equals("||"))) {
            semanticErrors.add("Error semántico: Operador lógico inválido para tipos numéricos en estructura " + structureType + ". Línea: " + operator.getLine());
        }
    }

    private void analyzeAssignment(List<Token> tokens) {
    if (tokens.size() < 5) {
        semanticErrors.add("Error semántico: Asignación mal formada. Línea: " + tokens.get(0).getLine());
        return;
    }

    String identifier = tokens.get(2).getLexeme();
    String value = tokens.get(4).getLexeme();

    if (!symbolTable.containsKey(identifier)) {
        semanticErrors.add("Error semántico: Variable '" + identifier + "' no declarada. Línea: " + tokens.get(2).getLine());
    } else {
        VariableInfo varInfo = symbolTable.get(identifier);
        if (!isTypeCompatible(varInfo.type, value)) {
            semanticErrors.add("Error semántico: Tipo incompatible en asignación. Se esperaba " + varInfo.type + " pero se obtuvo " + inferType(value) + ". Línea: " + tokens.get(2).getLine());
        }
    }
}

    private void analyzeArithmeticOperation(List<Token> tokens){
        String operation = tokens.get(0).getLexeme();
        List<Token> operands = tokens.subList(2, tokens.size()-2);
        for (Token operand : operands) {
            if (operand.getLexicalComp().equals("IDENTIFICADOR")) {
            if (!symbolTable.containsKey(operand.getLexeme())) {
                semanticErrors.add("Error semántico: Variable '" + operand.getLexeme() + "' no declarada en operación " + operation + ". Línea: " + operand.getLine());
            } else {
                VariableInfo varInfo = symbolTable.get(operand.getLexeme());
                if (!isNumericType(varInfo.type)) {
                    semanticErrors.add("Error semántico: Tipo no numérico en operación " + operation + ". Variable: " + operand.getLexeme() + ". Línea: " + operand.getLine());
                }
            }
        } else if (!isNumericType(inferType(operand.getLexeme()))) {
            semanticErrors.add("Error semántico: Tipo no numérico en operación " + operation + ". Valor: " + operand.getLexeme() + ". Línea: " + operand.getLine());
        }
    }
  }

    private void checkDivisionByZero(List<Token> tokens) {
    if (tokens.get(0).getLexeme().equals("DIVISION")) {
        Token divisor = tokens.get(4);
        if (divisor.getLexicalComp().equals("NUMERO") && divisor.getLexeme().equals("0")) {
            semanticErrors.add("Error semántico: División por cero detectada. Línea: " + divisor.getLine());
        } else if (divisor.getLexicalComp().equals("IDENTIFICADOR")) {
            semanticErrors.add("Advertencia: Posible división por cero si la variable '" + divisor.getLexeme() + "' es cero. Línea: " + divisor.getLine());
        }
    }
}

    private void checkUninitializedVariables() {
        for (Map.Entry<String, VariableInfo> entry : symbolTable.entrySet()) {
            if (entry.getValue().value == null || entry.getValue().value.isEmpty()) {
                semanticErrors.add("Advertencia: Variable '" + entry.getKey() + "' puede no estar inicializada antes de su uso. Línea de declaración: " + entry.getValue().declarationLine);
            }
        }
    }

    private boolean isTypeCompatible(String expectedType, String value) {
        String actualType = inferType(value);
        return expectedType.equals(actualType);
    }

    private String inferType(String value) {
        if (value.matches("-?\\d+")) {
            return "ENTERO";
        }
        if (value.matches("-?\\d+(\\.\\d+)?")) {
            return "DECIMAL";
        }
        if (value.equals("verdadero") || value.equals("falso")) {
            return "BOOLEANO";
        }
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return "TEXTO";
        }
        return "DESCONOCIDO";
    }

    private boolean isNumericType(String type) {
        return type.equals("ENTERO") || type.equals("DECIMAL");
    }

    private boolean isComparisonOperator(String operator) {
        return operator.equals("==") || operator.equals("!=") || operator.equals("<")
                || operator.equals(">") || operator.equals("<=") || operator.equals(">=");
    }

    private boolean isArithmeticOperation(String operation) {
        return operation.equals("SUMA") || operation.equals("RESTA") || operation.equals("MULTIPLICACION")
                || operation.equals("DIVISION") || operation.equals("MODULO");
    }

    private String getTokenType(Token token) {
        if (token.getLexicalComp().equals("IDENTIFICADOR")) {
            return symbolTable.containsKey(token.getLexeme()) ? symbolTable.get(token.getLexeme()).type : "DESCONOCIDO";
        } else {
            return inferType(token.getLexeme());
        }
    }

    private class VariableInfo {

        String type;
        String value;
        int declarationLine;

        VariableInfo(String type, String value, int declarationLine) {
            this.type = type;
            this.value = value;
            this.declarationLine = declarationLine;
        }
    }

}
