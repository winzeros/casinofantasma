/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.hermanos;

import aima.search.framework.GoalTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class HermanosEstadoObjetivo implements GoalTest {

    private HermanosJuego _juego;

    HermanosEstadoObjetivo(HermanosJuego juego) {
        _juego = juego;
    }

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
        
        if (i == 6) {
            _juego.setSolucion(true);
        }

        return _juego.getSolucion();
    }
}
