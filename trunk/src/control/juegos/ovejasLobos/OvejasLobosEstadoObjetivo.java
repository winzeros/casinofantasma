/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.GoalTest;
import java.util.HashMap;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa el Estado Objetivo del juego de OvejasLobos.
 * @author Alicia
 */
public class OvejasLobosEstadoObjetivo implements GoalTest {

    /**
     * Metodo que determina si el estado corresponde al estado ojetivo
     * del juego.
     * @param arg0
     * @return ok
     */
    public boolean isGoalState(Object arg0) {
        HashMap estado = new HashMap(3);
        boolean ok = false;

        try {
            estado.put(OvejasLobosEstado.LOBOS, 0);
            estado.put(OvejasLobosEstado.OVEJAS, 0);
            estado.put(OvejasLobosEstado.CANOA, 1);

            ok = arg0.equals(new OvejasLobosEstado(estado));

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosEstadoObjetivo.class.getName()).log(Level.ERROR,
                    "Error al comparar el estado " + arg0.toString() +
                    " con el estado final.", ex);
        }

        return ok;
    }
}
