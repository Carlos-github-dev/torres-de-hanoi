package pilas;

import excepciones.PilaExcepcion;
/**
 * 
 * @author Carlos Guevara Ramirez, B93564
 * @author Luis Antonio Arguello Cubero, B90619
 * @author Paulo Correa Coto, B92398
 */
public class ClsPilas {
    private Nodo cima;
    private int capacidadMaxima;
    private int cantidadElementos;
    
    public ClsPilas(int capacidadMaxima) throws PilaExcepcion{
        if (capacidadMaxima<0){
            throw new PilaExcepcion("La capacidad maxima de la pila tiene que ser igual o mayor a 0");
        }
        this.capacidadMaxima=capacidadMaxima;
    }
    
    public int size(){
        return cantidadElementos;
    }
    
    public boolean isEmpty(){
        if (cantidadElementos==0){
            return true;
        }else{
            return false;
        }
    }
    
    public int top() throws PilaExcepcion{
        if (cima==null){
            throw new PilaExcepcion("La pila se encuentra vacia");
        }
        return cima.getDato();
    }
    
    public int push(int dato) throws PilaExcepcion{
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        
        if (capacidadMaxima==cantidadElementos && capacidadMaxima!=0){
            throw new PilaExcepcion("La pila se encuentra llena");
        }
        
        if(isEmpty()){
            cima=nuevo;
            cantidadElementos++;
            return dato;
        }
        
        nuevo.setSiguiente(cima);
        cima=nuevo;
        cantidadElementos++;
        return dato;
    }
    
    public int pop() throws PilaExcepcion{
        if (isEmpty()){
            throw new PilaExcepcion ("La pila esta vacia");
        }
        Nodo temp=cima;
        if(cantidadElementos==1){
            cima=null;
            cantidadElementos+=-1;
            return temp.getDato();
        }
        cima=cima.getSiguiente();
        cantidadElementos+=-1;
        return temp.getDato();
    }
    
    public int search(int dato){
        if (cima==null){
            return -1;
        }
        int contador=0;
        Nodo temp =cima;
        while(temp!=null){
            if(temp.getDato()==dato){
                return contador;
            }
            contador++;
            temp=temp.getSiguiente();
        }
        return -1;
    }
    
    public String[] imprimirPila(){
        String[] temp = new String[cantidadElementos];
        Nodo tempNodo = cima;
        temp[0] = tempNodo.getDato() + "";
        
        for(int i = 0;tempNodo != null;i++){
            temp[i] = tempNodo.getDato() + "";
            tempNodo = tempNodo.getSiguiente();
        }
        return temp;
    }

    @Override
    public String toString() {
        if (cima==null){
            return "La pila esta vacia";
        }
        String txt= "";
        Nodo temp =cima;
        while(temp!=null){
            txt += "->"+temp.getDato();
            temp=temp.getSiguiente();
        }
        return txt;
    }
    
    
}
