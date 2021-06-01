package colas;

import juego.Movimientos;
/**
 * 
 * @author Carlos Guevara Ramirez, B93564
 * @author Luis Antonio Arguello Cubero, B90619
 * @author Paulo Correa Coto, B92398
 */
public class Nodo {
    private Movimientos data;
    private Nodo next;
    

    public Nodo() {
    }
    
    public Nodo(Movimientos dato) {
        this.data = data;
    }

    public Movimientos getData() {
        return data;
    }

    public void setData(Movimientos data) {
        this.data = data;
    }


    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    
}
