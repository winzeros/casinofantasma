/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import aima.search.framework.GoalTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class LinternaEstadoObjetivo implements GoalTest {

    public boolean isGoalState(Object arg0) {

        LinternaEstado estadoFinal =  (LinternaEstado) arg0;
        boolean enc = false;

        try {

            enc = ((estadoFinal.getCalzada()[0] == 0) &&
                   (estadoFinal.getCalzada()[1] == 0) &&
                   (estadoFinal.getCalzada()[2] == 0) &&
                   (estadoFinal.getCalzada()[3] == 0) &&
                   (estadoFinal.getCalzada()[4] == 0) &&
                   (estadoFinal.getCalzada()[6] >= 0));

        } catch (Exception ex) {
            Logger.getLogger(LinternaEstadoObjetivo.class.getName()).log(Level.ERROR,
                    "Error al comparar el estado " + arg0.toString() + " con el estado final.", ex);
        }

        return enc;
    }
}
