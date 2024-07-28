
public class Nodo {

    // Atributos
    private String dato;
    private Nodo padre;
    private Nodo izquierdo;
    private Nodo derecho;

    // Uso posterior
    private String tipoDato;
    private String codigoIntermedio;
    private String lugar;

    //Constructors
    public Nodo(Nodo derecho, String dato, Nodo izquierdo) {
        this.derecho = derecho;
        this.dato = dato;
        this.izquierdo = izquierdo;
    }

    public Nodo(String dato) {
        this.dato = dato;
    }

    //Getters and setters
    public Nodo getPadre() {
        return this.padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public String getDato() {
        return this.dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getIzquierdo() {
        return this.izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return this.derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

}