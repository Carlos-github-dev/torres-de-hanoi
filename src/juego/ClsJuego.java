package juego;

import colas.ClsCola;
import excepciones.ColaExcepcion;
import excepciones.JuegoExcepcion;
import excepciones.PilaExcepcion;
import java.util.ArrayList;
import java.util.List;
import pilas.ClsPilas;

public class ClsJuego {

    private ClsPilas pila1, pila2, pila3;
    private ClsCola historial;
    private int cantidadDeDiscos, contador, movimientosUsuarioCont;

    public ClsJuego() {
    }

    public void iniciarJuego(int cantidadDeDiscos) throws JuegoExcepcion {
        this.setCantidadDeDiscos(cantidadDeDiscos);
        this.setMovimientosUsuarioCont(0);
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

    public void moverDisco(int torreOrigen, int torreDestino) throws JuegoExcepcion {
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
                historial.enqueue(torreOrigen);
                historial.enqueue(torreDestino);
                movimientosUsuarioCont++;
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

    public void solucionadorDeJuego() throws JuegoExcepcion {
        solucionadorDeJuego(this.cantidadDeDiscos, 1, 2, 3);
    }

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

    public ArrayList simuladorDeJuego() throws JuegoExcepcion {
        return simuladorDeJuego(this.cantidadDeDiscos, 1, 2, 3);
    }

    private ArrayList simuladorDeJuego(int discos, int torre1, int torre2, int torre3) throws JuegoExcepcion {
        ArrayList<Movimientos> historialSimulacion = new ArrayList<>();
        try {
            // Caso Base
            if (discos == 1) {
                historialSimulacion.add(new Movimientos(torre1, torre3));
                //this.moverDisco(torre1, torre3);
                //System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
            } else {
                // Dominio
                // Llamamos a la función de tal forma que decrementamos
                // el número de discos, y seguimos el algoritmo
                // (origen, destino, auxiliar)
                simuladorDeJuego(discos - 1, torre1, torre3, torre2);
                historialSimulacion.add(new Movimientos(torre1, torre3));
                //this.moverDisco(torre1, torre3);
                //System.out.println("Mover disco de Torre " + torre1 + " a Torre " + torre3);
                // En esta ocasión siguiendo el algoritmo hacemos lo siguiente
                // (auxiliar, origen, destino)
                simuladorDeJuego(discos - 1, torre2, torre1, torre3);
            }
        } catch (JuegoExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        return historialSimulacion;
    }

    public String imprimirPilas() {
        String txt = "Listas:\n";
        txt += pila1.toString() + "\n";
        txt += pila2.toString() + "\n";
        txt += pila3.toString();
        return txt;
    }

    public String imprimirHistorial() {
        String txt = "Historial:\n";
        while (historial.size() > 0) {
            try {
                txt += "Se movio de la torre ";
                txt += historial.dequeue();
                txt += " a la torre ";
                txt += historial.dequeue() + "\n";
            } catch (ColaExcepcion ex) {
                System.out.println(ex.getMessage());
            }
        }
        return txt;
    }

}
