/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Alberto Perez
 */
import java.util.ArrayList;
import java.util.List;

public class GeneradorCuadruplos {
    public static List<String> generarCuadruplos() {
        List<String> cuadruplos = new ArrayList<>();

        // Declaraciones de variables
        cuadruplos.add("(=, 120, _, datosTerreno[0])");
        cuadruplos.add("(=, 140, _, datosTerreno[1])");
        cuadruplos.add("(=, 160, _, datosTerreno[2])");
        cuadruplos.add("(=, 180, _, datosTerreno[3])");
        cuadruplos.add("(=, 200, _, datosTerreno[4])");
        cuadruplos.add("(=, 1, _, i)");
        cuadruplos.add("(=, 0.5, _, x)");
        cuadruplos.add("(=, 1, _, flag)");
        cuadruplos.add("(=, 'Hola mundo', _, mensaje)");

        // Inicio del bucle MIENTRAS
        cuadruplos.add("(LABEL, inicio_mientras)");
        cuadruplos.add("(IF, i>0, _, continuar_mientras)");
        cuadruplos.add("(GOTO, fin_mientras)");
        cuadruplos.add("(LABEL, continuar_mientras)");

        // Condición SI
        cuadruplos.add("(IF, dato>150, _, si_verdadero)");
        cuadruplos.add("(GOTO, si_falso)");

        // Bloque SI
        cuadruplos.add("(LABEL, si_verdadero)");
        cuadruplos.add("(PRINT, 'Elevación alta: ', dato)");
        cuadruplos.add("(GOTO, fin_si)");

        // Bloque SINO
        cuadruplos.add("(LABEL, si_falso)");
        cuadruplos.add("(PRINT, 'Elevación baja: ', dato)");

        // Fin del SI
        cuadruplos.add("(LABEL, fin_si)");

        // Decrementar i
        cuadruplos.add("(RESTA, i, 1, i)");

        // Volver al inicio del bucle
        cuadruplos.add("(GOTO, inicio_mientras)");

        // Fin del bucle MIENTRAS
        cuadruplos.add("(LABEL, fin_mientras)");

        // Asignaciones finales
        cuadruplos.add("(=, generar_mapa(datosTerreno), _, mapa)");
        cuadruplos.add("(=, 3.14159, _, x)");
        cuadruplos.add("(=, 0, _, flag)");
        cuadruplos.add("(=, 'Análisis completado', _, mensaje)");

        return cuadruplos;
    }
}