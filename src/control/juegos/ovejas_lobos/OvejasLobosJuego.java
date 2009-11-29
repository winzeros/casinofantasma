/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejas_lobos;

import aima.search.framework.*;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;

/**
 *
 * @author Alicia
 */
public class OvejasLobosJuego extends Juego{

    public OvejasLobosJuego(Search busqueda) {

        try {
            this._busqueda = busqueda;
            this._nombre = "Ovejas vs. Lobos";
            this._solucion = false;
            this._problema = new Problem(new OvejasLobosEstado(permiteControlCiclos()), new OvejasLobosFuncionSucesor(),
                    new OvejasLobosEstadoObjetivo(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }
}
