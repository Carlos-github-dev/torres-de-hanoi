
package juego;

/**
 * 
 * @author Carlos Guevara Ramirez, B93564
 * @author Luis Antonio Arguello Cubero, B90619
 * @author Paulo Correa Coto, B92398
 * Clase que almacena dos datos enteros para guardar los puntos de movimiento
 */
public class Movimientos {

    int origen;
    int destino;

    public Movimientos(int origen, int salida) {
        this.origen = origen;
        this.destino = salida;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Se movió un disco de la torre "+this.getOrigen()+" a la torre "+this.getDestino();
    }
    
    
}
