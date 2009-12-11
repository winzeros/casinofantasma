/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.*;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alicia
 */
public class OvejasLobosJuego extends Juego {

    public OvejasLobosJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Ovejas vs. Lobos";
            this._problema = new Problem(new OvejasLobosEstado(permiteControlCiclos()), new OvejasLobosFuncionSucesor(),
                    new OvejasLobosEstadoObjetivo());
        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosJuego.class.getName()).log(Level.SEVERE, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

        public OvejasLobosJuego(Search busqueda, HeuristicFunction heuristica) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Ovejas vs. Lobos";
            this._problema = new Problem(new OvejasLobosEstado(permiteControlCiclos()), new OvejasLobosFuncionSucesor(),
                    new OvejasLobosEstadoObjetivo(), heuristica);
        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosJuego.class.getName()).log(Level.SEVERE, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }
}
