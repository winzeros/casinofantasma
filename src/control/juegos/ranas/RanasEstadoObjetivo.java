/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.GoalTest;
import control.juegos.ovejas_lobos.OvejasLobosEstadoObjetivo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class RanasEstadoObjetivo implements GoalTest{

    private RanasJuego _juego;

    RanasEstadoObjetivo(RanasJuego juego) {
        _juego = juego;
    }

    public boolean isGoalState(Object arg0) {
        ArrayList estadoFinal = new ArrayList();
        boolean ok = false;

        try {
            estadoFinal.add(RanasEstado.SAPOS);
            estadoFinal.add(RanasEstado.SAPOS);
            estadoFinal.add(RanasEstado.SAPOS);
            estadoFinal.add(RanasEstado.NADA);
            estadoFinal.add(RanasEstado.RANAS);
            estadoFinal.add(RanasEstado.RANAS);
            estadoFinal.add(RanasEstado.RANAS);


            ok = arg0.equals(new RanasEstado(estadoFinal));

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
