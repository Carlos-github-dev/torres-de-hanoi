package colas;

import excepciones.ColaExcepcion;

public class ClsCola {

    private Nodo front, rear;
    private final int maximumCapacity;
    private int currentSize;

    public ClsCola(int tamano) throws ColaExcepcion {
        if(tamano<0){
            throw new ColaExcepcion("La cantiad maxima de elementos debe ser igual o mayor a cero");
        }
        maximumCapacity = tamano;
        currentSize=0;
        front = rear = null;
    }

    public int size() {
        return currentSize;
    }

    public int enqueue(int character) throws ColaExcepcion {
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

    public int dequeue() throws ColaExcepcion {
        if (isEmpty()) {
            throw new ColaExcepcion("La cola se encuentra vacia");
        }
        int temp = front.getData();
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

    public int front() throws ColaExcepcion {
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
