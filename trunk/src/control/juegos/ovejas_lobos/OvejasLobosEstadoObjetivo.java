/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ovejas_lobos;

import aima.search.framework.GoalTest;
import control.juegos.IJuego;
import java.util.HashMap;

/**
 *
 * @author Alicia
 */
public class OvejasLobosEstadoObjetivo  implements GoalTest {

    private IJuego _juego;

    OvejasLobosEstadoObjetivo(OvejasLobosJuego juego) {
        _juego = juego;
    }

    public boolean isGoalState(Object arg0) {
        HashMap estado = new HashMap(3);
        boolean ok;

        estado.put(OvejasLobosEstado.LOBOS, 0);
        estado.put(OvejasLobosEstado.OVEJAS, 0);
        estado.put(OvejasLobosEstado.CANOA, 1);

        ok = arg0.equals(new OvejasLobosEstado(estado));

        if (ok) {
            this._juego.setSolucion(ok);
        }

        return arg0.equals(new OvejasLobosEstado(estado));
    }
}
