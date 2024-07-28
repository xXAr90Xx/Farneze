/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class VariableInfo {
    String tipo;
    boolean inicializada;
    boolean usada;
    boolean esLista;

    VariableInfo(String tipo, boolean inicializada, boolean usada) {
        this.tipo = tipo;
        this.inicializada = inicializada;
        this.usada = usada;
        this.esLista = tipo.equals("ENTERO") && inicializada;
    }
}