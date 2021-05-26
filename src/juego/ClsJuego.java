package juego;

import colas.ClsCola;
import excepciones.JuegoExcepcion;
import pilas.ClsPilas;

public class ClsJuego {
    ClsPilas pila1, pila2, pila3;
    ClsCola historial;
    private int cantidadDeDiscos;
    
    public ClsJuego(int cantidadDeDiscos) throws JuegoExcepcion{
        this.setCantidadDeDiscos(cantidadDeDiscos);
    }

    public int getCantidadDeDiscos() {
        return cantidadDeDiscos;
    }

    public void setCantidadDeDiscos(int cantidadDeDiscos) throws JuegoExcepcion {
        if (cantidadDeDiscos>10 || cantidadDeDiscos<3){
            throw new JuegoExcepcion("La cantidad de discos debe ser un numero 3 y 10");
        }
        this.cantidadDeDiscos = cantidadDeDiscos;
    }
    
    
}
