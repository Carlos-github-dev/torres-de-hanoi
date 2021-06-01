package colas;

import juego.Movimientos;

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
