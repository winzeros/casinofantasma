/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.GoalTest;
import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class RanasEstadoObjetivo implements GoalTest{

    public boolean isGoalState(Object arg0) {

        RanasEstado estadoFinal = new RanasEstado();
        boolean enc = false;

        try {
            estadoFinal.getHojas()[0] = "*";
            estadoFinal.getHojas()[1] = "*";
            estadoFinal.getHojas()[2] = "*";
            estadoFinal.getHojas()[3] = "_";
            estadoFinal.getHojas()[4] = "$";
            estadoFinal.getHojas()[5] = "$";
            estadoFinal.getHojas()[6] = "$";
            
            enc = arg0.equals(estadoFinal);

        } catch (Exception ex) {
            Logger.getLogger(RanasEstadoObjetivo.class.getName()).log(Level.ERROR,
                    "Error al comparar el estado " + arg0.toString() + " con el estado final.", ex);
        }

        return enc;
    }

}
