package juego;

import colas.ClsCola;
import excepciones.ColaExcepcion;
import excepciones.JuegoExcepcion;
import excepciones.PilaExcepcion;
import java.util.ArrayList;
import pilas.ClsPilas;

/**
 * 
 * @author Carlos Guevara Ramirez, B93564
 * @author Luis Antonio Arguello Cubero, B90619
 * @author Paulo Correa Coto, B92398
 */

public class ClsJuego {

    private ClsPilas pila1, pila2, pila3;
    private ClsCola historial;
    private int cantidadDeDiscos, contador, movimientosUsuarioCont;
    private ArrayList<Movimientos> historialMovimientosARealizar = new ArrayList<>();

    public ClsJuego() {
    }

    public void iniciarJuego(int cantidadDeDiscos) throws JuegoExcepcion {
        this.setCantidadDeDiscos(cantidadDeDiscos);
        this.setMovimientosUsuarioCont(0);
        contador = 0;
        try {
            pila1 = new ClsPilas(cantidadDeDiscos);
            pila2 = new ClsPilas(cantidadDeDiscos);
            pila3 = new ClsPilas(cantidadDeDiscos);
            historial = new ClsCola(0);
            for (int i = 0; i < cantidadDeDiscos; i++) {
                pila1.push(cantidadDeDiscos - i);
            }
        } catch (PilaExcepcion | ColaExcepcion ex) {
            System.out.println(ex.getMessage());
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

    public void setMovimientosUsuarioCont(int movimientosUsuarioCont) {
        this.movimientosUsuarioCont = movimientosUsuarioCont;
    }

    public int getMovimientosUsuarioCont() {
        return movimientosUsuarioCont;
    }
    
    /**
     * Retorna la pila que se desea utilizar
     * @param pila
     * @return 
     */
    public ClsPilas obtenerPila(int pila) {
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
    
    /**
     * Realiza un movimiento del elemento superior de una pila a otra
     * @param torreOrigen
     * @param torreDestino
     * @return
     * @throws JuegoExcepcion 
     */
    public boolean moverDisco(int torreOrigen, int torreDestino) throws JuegoExcepcion {
        if (obtenerPila(torreOrigen) == null || obtenerPila(torreDestino) == null) {
            throw new JuegoExcepcion("La pila de origen o destino no existe");
        }
        ClsPilas pilaOrigen = obtenerPila(torreOrigen);
        ClsPilas pilaDestino = obtenerPila(torreDestino);
        int temp = 0;
        try {
            temp = pilaOrigen.pop();
            //Comprobar que la torre de Destino no tengo un numero mas pequeno
            if (!pilaDestino.isEmpty() && temp > pilaDestino.top()) {
                pilaOrigen.push(temp);
                //Mensaje de error
                throw new JuegoExcepcion("El disco debe ser menor al disco superior de la torre de destino");
            } else {
                pilaDestino.push(temp);
                historial.enqueue(new Movimientos(torreOrigen, torreDestino));
                movimientosUsuarioCont++;
                return true;
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
        return false;
    }
    
    /**
     * Devulve true si el juego ya finalizo
     * @return 
     */
    public boolean comprobarSiJuegoTermina() {
        if (pila3.size() == cantidadDeDiscos) {
            return true;
        }
        return false;
    }
    
    /**
     * Llama al metodo recursivo privado que devuelve la cantidad minima de movimientos a realizar
     * @return 
     */
    public int cantidadMinimaDeMovimientos() {
        cantidadMinimaDeMovimientos(this.cantidadDeDiscos, 1, 2, 3);
        return contador;
    }
    /**
     * Calcula la cantidad minima de movimientos a realizar con una cantidad determinada de discos
     * @param discos tamano 
     * @param torre1
     * @param torre2
     * @param torre3 
     */
    private void cantidadMinimaDeMovimientos(int discos, int torre1, int torre2, int torre3) {
        // Caso Base
        if (discos == 1) {
            //System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
            contador++;
        } else {
            // Dominio
            // Llamamos a la función de tal forma que decrementamos
            // el número de discos, y seguimos el algoritmo
            // (origen, destino, auxiliar)
            cantidadMinimaDeMovimientos(discos - 1, torre1, torre3, torre2);
            //System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
            contador++;
            // En esta ocasión siguiendo el algoritmo hacemos lo siguiente
            // (auxiliar, origen, destino)
            cantidadMinimaDeMovimientos(discos - 1, torre2, torre1, torre3);
        }
    }
    /**
     * Metodo que implementa solucionadorDeJuego
     * @throws JuegoExcepcion 
     */
    public void solucionadorDeJuego() throws JuegoExcepcion {
        solucionadorDeJuego(this.cantidadDeDiscos, 1, 2, 3);
    }
    /**
     * Metodo recursivo que soluciona el juego de forma automatica
     * @param discos
     * @param torre1
     * @param torre2
     * @param torre3
     * @throws JuegoExcepcion 
     */
    private void solucionadorDeJuego(int discos, int torre1, int torre2, int torre3) throws JuegoExcepcion {
        try {
            // Caso Base
            if (discos == 1) {
                this.moverDisco(torre1, torre3);
                System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
            } else {
                // Dominio
                // Llamamos a la función de tal forma que decrementamos
                // el número de discos, y seguimos el algoritmo
                // (origen, destino, auxiliar)
                solucionadorDeJuego(discos - 1, torre1, torre3, torre2);
                this.moverDisco(torre1, torre3);
                System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
                // En esta ocasión siguiendo el algoritmo hacemos lo siguiente
                // (auxiliar, origen, destino)
                solucionadorDeJuego(discos - 1, torre2, torre1, torre3);
            }
        } catch (JuegoExcepcion ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Metodo que implementa simoladorDeJuego
     * @return
     * @throws JuegoExcepcion 
     */
    public ArrayList simuladorDeJuego() throws JuegoExcepcion {
        historialMovimientosARealizar = new ArrayList<>();
        simuladorDeJuego(this.cantidadDeDiscos, 1, 2, 3);
        return historialMovimientosARealizar;
    }
    /**
     * Metodo que guarda los movimientos que se deben hacer en un arrayList
     * @param discos
     * @param torre1
     * @param torre2
     * @param torre3
     * @throws JuegoExcepcion 
     */
    private void simuladorDeJuego(int discos, int torre1, int torre2, int torre3) throws JuegoExcepcion {
        try {
            // Caso Base
            if (discos == 1) {
                historialMovimientosARealizar.add(new Movimientos(torre1, torre3));
                //this.moverDisco(torre1, torre3);
                //System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
            } else {
                // Dominio
                // Llamamos a la función de tal forma que decrementamos
                // el número de discos, y seguimos el algoritmo
                // (origen, destino, auxiliar)
                simuladorDeJuego(discos - 1, torre1, torre3, torre2);
                historialMovimientosARealizar.add(new Movimientos(torre1, torre3));
                //this.moverDisco(torre1, torre3);
                //System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
                // En esta ocasión siguiendo el algoritmo hacemos lo siguiente
                // (auxiliar, origen, destino)
                simuladorDeJuego(discos - 1, torre2, torre1, torre3);
            }
        } catch (JuegoExcepcion ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Metodo que imprime una pila
     * @return 
     */
    public String imprimirPilas() {
        String txt = "Listas:\n";
        txt += pila1.toString() + "\n";
        txt += pila2.toString() + "\n";
        txt += pila3.toString();
        return txt;
    }
    /**
     * Metodo que imprime la cola que contiene el historial de movimientos
     * @return 
     */
    public String imprimirHistorial() {
        String txt = "Historial:\n";
        while (historial.size() > 0) {
            try {;
                txt += historial.dequeue().toString() + "\n";
            } catch (ColaExcepcion ex) {
                System.out.println(ex.getMessage());
            }
        }
        return txt;
    }
    /**
     * Metodo que obtiene el tamaño de la cola
     * @return 
     */
    public int obtenerTamanoHistorial() {
        return historial.size();
    }

}
