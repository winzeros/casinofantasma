/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.nreinas;

import aima.search.framework.HeuristicFunction;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class NReinasJuego extends Juego {

    NReinasJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "N Reinas";
            this._problema = new Problem(new NReinasEstado(8), new NReinasFuncionSucesor(),
                    new NReinasEstadoObjetivo());
        } catch (Exception ex) {
            Logger.getLogger(NReinasJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    NReinasJuego(Search busqueda, HeuristicFunction heuristica) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "N Reinas";
            this._problema = new Problem(new NReinasEstado(8), new NReinasFuncionSucesor(),
                    new NReinasEstadoObjetivo(), heuristica);
        } catch (Exception ex) {
            Logger.getLogger(NReinasJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }
}

