import compilerTools.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASM {
    private List<String> tripletas;
    private List<String> cuadruplos;
    private Map<String, String> tablaSimbolos;
    private int tempCounter = 1;
    private int labelCounter = 1;

    public ASM() {
        this.tripletas = new ArrayList<>();
        this.cuadruplos = new ArrayList<>();
        this.tablaSimbolos = new HashMap<>();
    }

    public void generarCodigoIntermedio(List<Token> tokens) {
        reset();
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.getLexeme().equals("VARIABLES")) {
                i = procesarDeclaraciones(tokens, i + 1);
            } else if (token.getLexeme().equals("PROCESOS")) {
                i = procesarProcesos(tokens, i + 1);
            }
        }
    }

    private int procesarDeclaraciones(List<Token> tokens, int startIndex) {
        int i = startIndex;
        while (i < tokens.size() && !tokens.get(i).getLexeme().equals("PROCESOS")) {
            if (tokens.get(i).getLexicalComp().equals("TIPO_DATO")) {
                String tipo = tokens.get(i).getLexeme();
                String variable = tokens.get(i + 1).getLexeme();
                tablaSimbolos.put(variable, tipo);
                i += 4; // Saltar al siguiente token después del valor
            } else {
                i++;
            }
        }
        return i - 1;
    }

    private int procesarProcesos(List<Token> tokens, int startIndex) {
        int i = startIndex;
        while (i < tokens.size()) {
            Token token = tokens.get(i);
            switch (token.getLexeme()) {
                case "SUMA":
                case "RESTA":
                case "MULTIPLICACION":
                case "DIVISION":
                case "MODULO":
                    i = procesarOperacionBasica(tokens, i);
                    break;
                case "POTENCIA":
                case "RAIZ_CUADRADA":
                case "LOGARITMO_NATURAL":
                case "LOGARITMO_BASE_10":
                    i = procesarOperacionAvanzada(tokens, i);
                    break;
                case "SENO":
                case "COSENO":
                case "TANGENTE":
                    i = procesarOperacionTrigonometrica(tokens, i);
                    break;
                case "MEDIANA":
                case "VAR":
                case "DESVESTA":
                case "PROMEDIO":
                    i = procesarOperacionEstadistica(tokens, i);
                    break;
                case "IMPRIMIR":
                    i = procesarImprimir(tokens, i);
                    break;
                case "SI":
                    i = procesarEstructuraSi(tokens, i);
                    break;
                case "MIENTRAS":
                    i = procesarEstructuraMientras(tokens, i);
                    break;
                case "ASIGNAR":
                    i = procesarAsignacion(tokens, i);
                    break;
                default:
                    i++;
            }
        }
        return i - 1;
    }

    private int procesarOperacionBasica(List<Token> tokens, int startIndex) {
        String operacion = tokens.get(startIndex).getLexeme();
        String op1 = tokens.get(startIndex + 2).getLexeme();
        String op2 = tokens.get(startIndex + 4).getLexeme();
        String resultado = tokens.get(startIndex + 7).getLexeme();
        String temp = generarTemporal();
        String simbolo = obtenerSimboloOperacion(operacion);
        
        tripletas.add(temp + " = " + op1 + " " + simbolo + " " + op2);
        tripletas.add(resultado + " = " + temp);
        
        cuadruplos.add("(" + simbolo + ", " + op1 + ", " + op2 + ", " + temp + ")");
        cuadruplos.add("(=, " + temp + ", _, " + resultado + ")");
        
        return startIndex + 8;
    }

    private int procesarOperacionAvanzada(List<Token> tokens, int startIndex) {
        String operacion = tokens.get(startIndex).getLexeme();
        List<String> parametros = new ArrayList<>();
        int i = startIndex + 2;
        while (!tokens.get(i).getLexeme().equals("]")) {
            if (tokens.get(i).getLexicalComp().equals("IDENTIFICADOR")) {
                parametros.add(tokens.get(i).getLexeme());
            }
            i++;
        }
        String resultado = tokens.get(i + 2).getLexeme();
        String temp = generarTemporal();
        
        String params = String.join(", ", parametros);
        tripletas.add(temp + " = " + operacion + "(" + params + ")");
        tripletas.add(resultado + " = " + temp);
        
        cuadruplos.add("(" + operacion + ", " + params + ", _, " + temp + ")");
        cuadruplos.add("(=, " + temp + ", _, " + resultado + ")");
        
        return i + 3;
    }

    private int procesarOperacionTrigonometrica(List<Token> tokens, int startIndex) {
        String operacion = tokens.get(startIndex).getLexeme();
        String argumento = tokens.get(startIndex + 2).getLexeme();
        String resultado = tokens.get(startIndex + 6).getLexeme();
        String temp = generarTemporal();
        
        tripletas.add(temp + " = " + operacion + "(" + argumento + ")");
        tripletas.add(resultado + " = " + temp);
        
        cuadruplos.add("(" + operacion + ", " + argumento + ", _, " + temp + ")");
        cuadruplos.add("(=, " + temp + ", _, " + resultado + ")");
        
        return startIndex + 7;
    }

    private int procesarOperacionEstadistica(List<Token> tokens, int startIndex) {
        String operacion = tokens.get(startIndex).getLexeme();
        List<String> parametros = new ArrayList<>();
        int i = startIndex + 2;
        while (!tokens.get(i).getLexeme().equals("]")) {
            if (tokens.get(i).getLexicalComp().equals("IDENTIFICADOR")) {
                parametros.add(tokens.get(i).getLexeme());
            }
            i++;
        }
        String resultado = tokens.get(i + 2).getLexeme();
        String temp = generarTemporal();
        
        String params = String.join(", ", parametros);
        tripletas.add(temp + " = " + operacion + "(" + params + ")");
        tripletas.add(resultado + " = " + temp);
        
        cuadruplos.add("(" + operacion + ", " + params + ", _, " + temp + ")");
        cuadruplos.add("(=, " + temp + ", _, " + resultado + ")");
        
        return i + 3;
    }

    private int procesarImprimir(List<Token> tokens, int startIndex) {
        String variable = tokens.get(startIndex + 2).getLexeme();
        tripletas.add("PRINT " + variable);
        cuadruplos.add("(PRINT, " + variable + ", _, _)");
        return startIndex + 4;
    }

    private int procesarEstructuraSi(List<Token> tokens, int startIndex) {
        String condicion = tokens.get(startIndex + 2).getLexeme();
        String labelTrue = generarLabel();
        String labelEnd = generarLabel();
        
        tripletas.add("IF " + condicion + " GOTO " + labelTrue);
        tripletas.add("GOTO " + labelEnd);
        tripletas.add(labelTrue + ":");
        
        cuadruplos.add("(IF, " + condicion + ", _, " + labelTrue + ")");
        cuadruplos.add("(GOTO, _, _, " + labelEnd + ")");
        cuadruplos.add("(LABEL, _, _, " + labelTrue + ")");
        
        int i = startIndex + 5; // Comenzar después de la apertura de llave
        while (!tokens.get(i).getLexeme().equals("}")) {
            if (tokens.get(i).getLexicalComp().equals("IDENTIFICADOR")) {
                tripletas.add(tokens.get(i).getLexeme());
                cuadruplos.add("(EXEC, " + tokens.get(i).getLexeme() + ", _, _)");
            }
            i++;
        }
        
        tripletas.add(labelEnd + ":");
        cuadruplos.add("(LABEL, _, _, " + labelEnd + ")");
        
        return i + 1;
    }

    private int procesarEstructuraMientras(List<Token> tokens, int startIndex) {
        String condicion = tokens.get(startIndex + 2).getLexeme();
        String labelStart = generarLabel();
        String labelBody = generarLabel();
        String labelEnd = generarLabel();
        
        tripletas.add(labelStart + ":");
        tripletas.add("IF " + condicion + " GOTO " + labelBody);
        tripletas.add("GOTO " + labelEnd);
        tripletas.add(labelBody + ":");
        
        cuadruplos.add("(LABEL, _, _, " + labelStart + ")");
        cuadruplos.add("(IF, " + condicion + ", _, " + labelBody + ")");
        cuadruplos.add("(GOTO, _, _, " + labelEnd + ")");
        cuadruplos.add("(LABEL, _, _, " + labelBody + ")");
        
        int i = startIndex + 5; // Comenzar después de la apertura de llave
        while (!tokens.get(i).getLexeme().equals("}")) {
            if (tokens.get(i).getLexicalComp().equals("IDENTIFICADOR")) {
                tripletas.add(tokens.get(i).getLexeme());
                cuadruplos.add("(EXEC, " + tokens.get(i).getLexeme() + ", _, _)");
            }
            i++;
        }
        
        tripletas.add("GOTO " + labelStart);
        tripletas.add(labelEnd + ":");
        
        cuadruplos.add("(GOTO, _, _, " + labelStart + ")");
        cuadruplos.add("(LABEL, _, _, " + labelEnd + ")");
        
        return i + 1;
    }

    private int procesarAsignacion(List<Token> tokens, int startIndex) {
        String variable = tokens.get(startIndex + 2).getLexeme();
        String valor = tokens.get(startIndex + 5).getLexeme();
        
        tripletas.add(variable + " = " + valor);
        cuadruplos.add("(=, " + valor + ", _, " + variable + ")");
        
        return startIndex + 7;
    }

    private String generarTemporal() {
        return "t" + tempCounter++;
    }

    private String generarLabel() {
        return "L" + labelCounter++;
    }

    private String obtenerSimboloOperacion(String operacion) {
        switch (operacion) {
            case "SUMA": return "+";
            case "RESTA": return "-";
            case "MULTIPLICACION": return "*";
            case "DIVISION": return "/";
            case "MODULO": return "%";
            default: return operacion;
        }
    }

    public List<String> obtenerTripletas() {
        return tripletas;
    }

    public List<String> obtenerCuadruplos() {
        return cuadruplos;
    }
    public void reset() {
    tripletas.clear();
    cuadruplos.clear();
    tempCounter = 1; 
    labelCounter = 1; 
    }
    
    
}