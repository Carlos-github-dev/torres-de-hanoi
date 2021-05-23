package colas;

import excepciones.QueueException;

public class QueueCls {

    private Node front, rear;
    private final int maximumCapacity;
    private int currentSize;

    public QueueCls(int tamano) throws QueueException {
        if(tamano<0){
            throw new QueueException("La cantiad maxima de elementos debe ser igual o mayor a cero");
        }
        maximumCapacity = tamano;
        currentSize=0;
        front = rear = null;
    }

    public int size() {
        return currentSize;
    }

    public char enqueue(char character) throws QueueException {
        if (currentSize == maximumCapacity && maximumCapacity != 0) {
            throw new QueueException("La cola se encuentra llena");
        }
        Node newNode= new Node();
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

    public char dequeue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("La cola se encuentra vacia");
        }
        char temp = front.getData();
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

    public char front() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("La cola se encuentra vacia");
        }
        return front.getData();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "La pila esta vacia";
        }
        String txt = "";
        Node temp = front;
        while (temp != null) {
            txt += "->" + temp.getData();
            temp = temp.getNext();
        }
        return txt;
    }
}
