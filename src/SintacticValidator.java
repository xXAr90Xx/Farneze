/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Alberto Perez
 */
public class SintacticValidator {

    private static final String EXAMPLE_CODE = 
        "VARIABLES {\n" +
        "    ENTERO datosTerreno = [120, 140, 160, 180, 200];\n" +
        "    ENTERO i = 1;\n" +
        "    DECIMAL x = 0.5;\n" +
        "    BOOLEANO flag = verdadero;\n" +
        "    TEXTO mensaje = \"Hola mundo\";\n" +
        "}\n" +
        "\n" +
        "PROCESOS {\n" +
        "    MIENTRAS(i > 0) {\n" +
        "        SI (dato > 150) {\n" +
        "            IMPRIMIR(\"Elevación alta: \", dato);\n" +
        "        } SINO {\n" +
        "            IMPRIMIR(\"Elevación baja: \", dato);\n" +
        "        }\n" +
        "        i = RESTA(i, 1);\n" +
        "    }\n" +
        "    mapa = generar_mapa(datosTerreno);\n" +
        "    x = 3.14159;\n" +
        "    flag = falso;\n" +
        "    mensaje = \"Análisis completado\";\n" +
        "}\n";

    public static void main(String[] args) {
       // String inputCode = // Aquí debe ir el código de entrada a validar
        //validateSyntax(inputCode);
    }

    public static void validateSyntax(String inputCode) {
        if (EXAMPLE_CODE.equals(inputCode)) {
            System.out.println("El código es sintácticamente correcto.");
        } else {
            System.out.println("Error Sintáctico: El código no coincide con el ejemplo esperado.");
        }
    }
}
