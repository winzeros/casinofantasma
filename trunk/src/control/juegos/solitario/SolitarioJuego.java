/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.solitario;

import aima.search.framework.*;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;

/**
 *
 * @author Alicia
 */
public class SolitarioJuego extends Juego{

    SolitarioJuego(Search busqueda) {

        try {
            this._busqueda = busqueda;
            this._nombre = "Solitario";
            this._problema = new Problem(new SolitarioEstado(permiteControlCiclos()),
                    new SolitarioFuncionSucesor(),
                    new SolitarioEstadoObjetivo(this));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   SolitarioJuego(Search busqueda, HeuristicFunction heuristica) {

        try {
            this._busqueda = busqueda;
            this._nombre = "Solitario";
            this._problema = new Problem(new SolitarioEstado(permiteControlCiclos()),
                    new SolitarioFuncionSucesor(),
                    new SolitarioEstadoObjetivo(this), heuristica);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }

}
