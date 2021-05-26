package juego;

import colas.ClsCola;
import excepciones.ColaExcepcion;
import excepciones.JuegoExcepcion;
import excepciones.PilaExcepcion;
import pilas.ClsPilas;

public class ClsJuego {

    private ClsPilas pila1, pila2, pila3;
    private ClsCola historial;
    private int cantidadDeDiscos, contador;

    public ClsJuego(int cantidadDeDiscos) throws JuegoExcepcion {
        this.setCantidadDeDiscos(cantidadDeDiscos);
        try {
            pila1 = new ClsPilas(cantidadDeDiscos);
            pila2 = new ClsPilas(cantidadDeDiscos);
            pila3 = new ClsPilas(cantidadDeDiscos);
            historial = new ClsCola(0);
        } catch (PilaExcepcion ex) {
            System.out.println(ex.getMessage());
        } catch (ColaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i < cantidadDeDiscos; i++) {
            try {
                pila1.push(cantidadDeDiscos - i);
            } catch (PilaExcepcion ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public int getCantidadDeDiscos() {
        return cantidadDeDiscos;
    }

    public void setCantidadDeDiscos(int cantidadDeDiscos) throws JuegoExcepcion {
        if (cantidadDeDiscos > 10 || cantidadDeDiscos < 3) {
            throw new JuegoExcepcion("La cantidad de discos debe ser un numero 3 y 10");
        }
        this.cantidadDeDiscos = cantidadDeDiscos;
    }

    private ClsPilas obtenerPila(int pila) {
        if (pila == 1) {
            return pila1;
        }
        if (pila == 2) {
            return pila2;
        }
        if (pila == 3) {
            return pila3;
        }
        return null;
    }

    public void moverDisco(int torreOrigen, int torreDestino) throws JuegoExcepcion {
        if (obtenerPila(torreOrigen)==null || obtenerPila(torreDestino)==null){
            throw new JuegoExcepcion("La pila de origen no existe");
        }
        ClsPilas pilaOrigen = obtenerPila(torreOrigen);
        ClsPilas pilaDestino = obtenerPila(torreDestino);
        int temp = 0;
        try {
            temp = pilaOrigen.pop();
            //Comprobar que la torre de Destino no tengo un numero mas pequeno
            if(!pilaDestino.isEmpty()&&temp>pilaDestino.top()){
                pilaOrigen.push(temp);
                //Mensaje de error
                throw new JuegoExcepcion("El disco debe ser menor al disco superior de la torre de destino");
            }else{
                pilaDestino.push(temp);
                historial.enqueue(torreOrigen);
                historial.enqueue(torreDestino);
                //System.out.println("Se agrego torre origen: "+torreOrigen+" y torre destino"+torreDestino+" al historial");
            }
        } catch (PilaExcepcion ex) {
            System.out.println(ex.getMessage());
            try {
                pilaOrigen.push(temp);
            } catch (PilaExcepcion ex1) {
                System.out.println(ex1.getMessage());
            }
        } catch (ColaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int cantidadMinimaDeMovimientos() {
        cantidadMinimaDeMovimientos(this.cantidadDeDiscos, 1, 2, 3);
        return contador;
    }

    private void cantidadMinimaDeMovimientos(int discos, int torre1, int torre2, int torre3) {
        // Caso Base
        if (discos == 1) {
            System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
            contador++;
        } else {
            // Dominio
            // Llamamos a la función de tal forma que decrementamos
            // el número de discos, y seguimos el algoritmo
            // (origen, destino, auxiliar)
            cantidadMinimaDeMovimientos(discos - 1, torre1, torre3, torre2);
            System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
            contador++;
            // En esta ocasión siguiendo el algoritmo hacemos lo siguiente
            // (auxiliar, origen, destino)
            cantidadMinimaDeMovimientos(discos - 1, torre2, torre1, torre3);
        }
    }

    public String imprimirPilas() {
        String txt = "Listas:\n";
        txt += pila1.toString()+"\n";
        txt += pila2.toString()+"\n";
        txt += pila3.toString();
        return txt;
    }
    
    public String imprimirHistorial() {
        String txt = "Historial:\n";
        for (int i =0; i<historial.size()+1;i++){
            try {
                txt+="Se movio de la torre ";
                txt+= historial.dequeue();
                txt+=" a la torre ";
                txt+= historial.dequeue()+"\n";
            } catch (ColaExcepcion ex) {
                System.out.println(ex.getMessage());
            }
        }
        return txt;
    }

}
