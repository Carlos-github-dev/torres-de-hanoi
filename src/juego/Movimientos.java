/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author charl
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
