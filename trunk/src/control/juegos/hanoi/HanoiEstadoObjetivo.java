/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.GoalTest;
import java.util.HashMap;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class HanoiEstadoObjetivo implements GoalTest {


    public boolean isGoalState(Object arg0) {

        HanoiEstado estado = (HanoiEstado) arg0;
        boolean sol = false;

        try {
            sol = ((estado.getTablero()[0][0] == 3)&&(estado.getTablero()[0][1] == 1)&&
                    (estado.getTablero()[1][0] == 3)&&(estado.getTablero()[1][1] == 2) &&
                    (estado.getTablero()[2][0] == 3)&&(estado.getTablero()[2][1] == 3));


        } catch (Exception ex) {
            Logger.getLogger(HanoiEstadoObjetivo.class.getName()).log(Level.ERROR,
                    "Error al comparar el estado " + arg0.toString() + " con el estado final.", ex);
        }

        return sol;
    }

}