/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejas_lobos;

import aima.search.framework.GoalTest;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alicia
 */
public class OvejasLobosEstadoObjetivo implements GoalTest {

    private OvejasLobosJuego _juego;

    OvejasLobosEstadoObjetivo(OvejasLobosJuego juego) {
        _juego = juego;
    }

    public boolean isGoalState(Object arg0) {
        HashMap estado = new HashMap(3);
        boolean ok = false;

        try {
            estado.put(OvejasLobosEstado.LOBOS, 0);
            estado.put(OvejasLobosEstado.OVEJAS, 0);
            estado.put(OvejasLobosEstado.CANOA, 1);

            ok = arg0.equals(new OvejasLobosEstado(estado));

            if (ok) {
                this._juego.setSolucion(ok);
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosEstadoObjetivo.class.getName()).log(Level.SEVERE,
                    "Error al comparar el estado " + arg0.toString() + " con el estado final.", ex);
        }

        return ok;
    }
}
