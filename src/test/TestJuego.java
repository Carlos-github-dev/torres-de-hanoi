package test;

import excepciones.JuegoExcepcion;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego.ClsJuego;

public class TestJuego {
    public static void main(String[] args) {
        try {
            ClsJuego juego1 = new ClsJuego(4);
            //System.out.println(juego1.cantidadMinimaDeMovimientos());
            System.out.println(juego1.imprimirPilas());
            System.out.println("Se movio de 1 a 3");
            juego1.moverDisco(1, 3);
            System.out.println("Se movio de 1 a 2");
            juego1.moverDisco(1, 2);
            System.out.println("Se movio de 3 a 2");
            juego1.moverDisco(3, 2);
            System.out.println("Se movio de 2 a 3");
            juego1.moverDisco(2, 3);
            System.out.println(juego1.imprimirPilas());  
            System.out.println(juego1.imprimirHistorial());
        } catch (JuegoExcepcion ex) {
            System.out.println(ex.getMessage());
        }
    }
}
