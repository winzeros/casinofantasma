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

        LinternaEstado estado = (LinternaEstado) arg0;
        int i = 0;
//((estAux[0] == 0)&&(estAux[1] == 0)&&(estAux[2] == 0)&&(estAux[3] == 0)
 //               &&(estAux[4] == 0)&&(estAux[5] == 0)&&(estAux[6] >= 0));
        try {
            while ((i < 6) && (estado.getMesa()[i] != 0)) {
                i++;
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaEstadoObjetivo.class.getName()).log(Level.ERROR,
                    "Error al comparar el estado " + arg0.toString() + " con el estado final.", ex);
        }

        return i == 6;
    }
}
