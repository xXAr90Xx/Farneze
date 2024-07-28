
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * Cortez Salinas Arath de Jesús Cortez Salinas - 5B
 */
public class Arbol {

    Stack<Nodo> arbolNodo;
    Stack<String> caracter; //Identificar si es operador o operando
    final String espacios = "\t";
    final String aritmeticos = "+-*/";
    final String variables = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Obtener la fecha actual
    public LocalDate fechaActual = LocalDate.now();
    private Nodo raiz;
    //27 Jun
    HashMap<String, String> reglasSemanticas;
    HashMap<String, String> tablaSimbolos;
    HashMap<String, String> erroresSemanticos;
    public  ArrayList<String> valores;
    int paso;
    String[] temporal = {"T1", "T2"};

    //Constructors
    public Arbol() {
        tablaSimbolos = new HashMap<>();
        erroresSemanticos = new HashMap<>();
        arbolNodo = new Stack<Nodo>();
        caracter = new Stack<String>();
        valores = new ArrayList<String>();
        reglasSemanticas = new HashMap<>();
        agregarReglasSemanticas();
        getReglasSemanticas();
    }//Constructor
    //Avanxe 27/Jun/2024

    public void agregarReglasSemanticas() {
        reglasSemanticas.put("rs1", "E.nodo = new Nodo ('+' , E1.nodo. , T.nodo)");
        reglasSemanticas.put("rs2", "E.nodo = new Nodo ('-' , E.nodo , T.nodo)");
        reglasSemanticas.put("rs3", "E.nodo =  T.nodo");
        reglasSemanticas.put("rs4", "T.nodo =  E.nodo");
        reglasSemanticas.put("rs5", "T.nodo = new Hoja(id, id.entrada)");
        reglasSemanticas.put("rs3", "T.nodo = new Hoja(num ,num.id )");
    }//metodo de reglas semanticas

    public String getReglasSemanticas() {
        String cadena = "";
        for (String i : reglasSemanticas.keySet()) {
            cadena += "key: " + i + "regla semantica: " + reglasSemanticas.get(i) + "\n";
        }
        return cadena;
    }
    //--------------------------------------------------------------------//
    //Avance 24/06/2024

    public void agregaValex(String id, String valor) {
        this.tablaSimbolos.put(id, valor);
    }//agregaValex Léxico  

    public String regresaValex(String lexema) {
        return this.tablaSimbolos.get(lexema);
    }

    public void guardar() {//Permite construir el árbol
        Nodo izquierdo = (Nodo) arbolNodo.pop();
        Nodo derecho = (Nodo) arbolNodo.pop();
        System.out.println("Construyendo sub-arbol");
        System.out.println("Dato izquierdo---> " + izquierdo.getDato());
        System.out.println("Dato derecho-----> " + derecho.getDato());
        System.out.println("Caracter---------> " + caracter.peek());
        arbolNodo.push(new Nodo(derecho, caracter.pop(), izquierdo));
    }

    //El método "crear", permitira separar en tokens 
    //identificar entre OPERANDOS Y OPERADORES
    //Para construir el Árbol de Expresion(árbol binario).
    public Nodo crear(String expresion) {
        //1.Considerar la eexpresion como un conjunto de tokens
        StringTokenizer tokenizer;
        String token;
        //2.Separacion de tokens de la expresion 
        tokenizer = new StringTokenizer(expresion, espacios + aritmeticos, true);
        //3.Ciclo "mientras", condicion=>mientras existan tokens

        while (tokenizer.hasMoreTokens()) {

            token = tokenizer.nextToken();
            System.out.println("Token: " + token);
            //4.Omitir espacios en blanco
            if (!aritmeticos.contains(token) && !(espacios.contains(token))) {
                //5.Se trata de un identificador
                //NO ES UN OPERADOR ARITMETICO
                arbolNodo.push(new Nodo(token));
                //27 jun 2024
                //5
                valores.add("rs5");//agregar la llave perteneciente a el token a un arrayList para 
                System.out.println(reglasSemanticas.get("rs5"));
                System.out.println("Se trata de un identificador: " + token);
                //Practica1
                agregaValex(token, "0");
                System.out.println("Se ha agregado: " + token + " a la tabla de simbolos");
            } else if (token.equals(")")) {
                //6.Extraer de la pila los términos que estaban en parentesis
                while (!caracter.empty() && !caracter.peek().equals("(")) {
                    guardar();
                }//while
                caracter.pop();
            } else {
                //7.Tratar tokens que no son parentesis 
                if (!token.equals("(") && !caracter.empty()) {
                    String exa = (String) caracter.peek();
                    //26 Junio 20204
                    System.out.println("Valor tope de de la pila <examinar> " + exa);
                    System.out.println("Valor de <token> " + token);
                    System.out.println("Examinar IndexOf " + aritmeticos.indexOf(exa));
                    System.out.println("Token IndexOf " + aritmeticos.indexOf(token));
                    while (!exa.equals("(") && !caracter.empty() && aritmeticos.indexOf(exa) >= aritmeticos.indexOf(token)) {
                        guardar();
                        if (!caracter.empty()) {
                            exa = (String) caracter.peek();
                            
                        }//if
                    }//while    
                }//if
                caracter.push(token);//26 Junio 2024
                //identificar entre '+' y '-' 27 jun 2024
                            if (token.equals("+")) {
                                valores.add("rs1");
                                System.out.println(reglasSemanticas.get("rs1"));
                            } else if (token.equals("-")) {
                                valores.add("rs2");
                                System.out.println(reglasSemanticas.get("rs2"));
                            }
            }//if            
        }//while
        while (!caracter.empty()) {
            if (caracter.peek().equals("(")) {
                caracter.pop();
            } else {
                guardar();//AQUI SE INSERTAN LOS OPERADORES
                raiz = (Nodo) arbolNodo.peek();

                System.out.println("Insertando OPERADORES");
                System.out.println("Dato------> " + raiz.getDato());
            }//if
        }//while
        System.out.println(fechaActual);
        return raiz;
    }
}
