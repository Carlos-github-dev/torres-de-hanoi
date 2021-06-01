package pilas;
/**
 * 
 * @author Carlos Guevara Ramirez, B93564
 * @author Luis Antonio Arguello Cubero, B90619
 * @author Paulo Correa Coto, B92398
 */
public class Nodo {
    private int dato;
    private Nodo siguiente;

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
