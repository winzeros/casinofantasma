/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.monoBanana;

import aima.search.framework.GoalTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa el Estado Objetivo del juego del Mono y la Banana.
 * @author laura
 */
public class MonoBananaEstadoObjetivo implements GoalTest {

    /**
     * Metodo que determina si el estado corresponde al estado ojetivo
     * del juego.
     * @param arg0
     * @return sol
     */
    public boolean isGoalState(Object arg0) {


        MonoBananaEstado estado = (MonoBananaEstado) arg0;
        boolean sol = false;

        try {
            sol = ((estado.getHabitacion()[3] == 0)&&(estado.getHabitacion()[2] == 1)&&
                    (estado.getHabitacion()[1] == 1)&&(estado.getHabitacion()[0] == 1));
            

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaEstadoObjetivo.class.getName()).log(Level.ERROR,
                    "Error al comparar el estado " + arg0.toString() + " con el estado final.", ex);
        }

        return sol;
    }
}
