/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.hermanos;

import aima.search.framework.GoalTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa el Estado Objetivo del juego de los Hermanos a la Greña.
 * @author Alicia
 */
public class HermanosEstadoObjetivo implements GoalTest {

    private HermanosJuego juego;

    public HermanosEstadoObjetivo(HermanosJuego hermanos) {
        this.juego = hermanos;
    }

    /**
     * Metodo que determina si el estado corresponde al estado ojetivo
     * del juego.
     * @param arg0
     * @return
     */
    public boolean isGoalState(Object arg0) {

        HermanosEstado estado = (HermanosEstado) arg0;
        int i = 0;

        try {
            while ((i < 6) && (estado.getMesa()[i] != 0)) {
                i++;
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosEstadoObjetivo.class.getName()).log(Level.ERROR,
                    "Error al comparar el estado " + arg0.toString() + " con el estado final.", ex);
        }

        if (i==6) {
            juego.setSolucion(true);
            return true;
        }else {
            return false;
        }

    }
}
