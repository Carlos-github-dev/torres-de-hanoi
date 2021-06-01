package colas;

import excepciones.ColaExcepcion;
import juego.Movimientos;
/**
 * 
 * @author Carlos Guevara Ramirez, B93564
 * @author Luis Antonio Arguello Cubero, B90619
 * @author Paulo Correa Coto, B92398
 */
public class ClsCola {

    private Nodo front, rear;
    private final int maximumCapacity;
    private int currentSize;

    public ClsCola(int tamano) throws ColaExcepcion {
        if(tamano<0){
            throw new ColaExcepcion("La cantidad maxima de elementos debe ser igual o mayor a cero");
        }
        maximumCapacity = tamano;
        currentSize=0;
        front = rear = null;
    }

    public int size() {
        return currentSize;
    }

    public Movimientos enqueue(Movimientos character) throws ColaExcepcion {
        if (currentSize == maximumCapacity && maximumCapacity != 0) {
            throw new ColaExcepcion("La cola se encuentra llena");
        }
        Nodo newNode= new Nodo();
        newNode.setData(character);

        if (front == null) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        currentSize++;
        return rear.getData();
    }

    public Movimientos dequeue() throws ColaExcepcion {
        if (isEmpty()) {
            throw new ColaExcepcion("La cola se encuentra vacia");
        }
        Movimientos temp = front.getData();
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.getNext();
        }
        currentSize--;
        return temp;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Movimientos front() throws ColaExcepcion {
        if (isEmpty()) {
            throw new ColaExcepcion("La cola se encuentra vacia");
        }
        return front.getData();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "La pila esta vacia";
        }
        String txt = "";
        Nodo temp = front;
        while (temp != null) {
            txt += "->" + temp.getData();
            temp = temp.getNext();
        }
        return txt;
    }
}
