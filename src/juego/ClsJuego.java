package juego;

import colas.ClsCola;
import excepciones.JuegoExcepcion;
import pilas.ClsPilas;

public class ClsJuego {

    private ClsPilas pila1, pila2, pila3;
    private ClsCola historial;
    private int cantidadDeDiscos, contador;

    public ClsJuego(int cantidadDeDiscos) throws JuegoExcepcion {
        this.setCantidadDeDiscos(cantidadDeDiscos);
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

    public void moverDisco(ClsPilas pilaOrigen, ClsPilas pilaDestino) {
        
    }

    public void cantidadMinimaDeMovimientos(int discos, int torre1, int torre2, int torre3) {
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

}
