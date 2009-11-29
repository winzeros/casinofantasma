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

    public SolitarioJuego(Search busqueda) {

        try {
            this._busqueda = busqueda;
            this._nombre = "Solitario";
            this._solucion = false;
            this._problema = new Problem(new SolitarioEstado(permiteControlCiclos()),
                    new SolitarioFuncionSucesor(),
                    new SolitarioEstadoObjetivo(this));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }

}