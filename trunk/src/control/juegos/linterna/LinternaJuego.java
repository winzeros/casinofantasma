/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class LinternaJuego extends Juego {

    public LinternaJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "El juego de la linterna";
            this._problema = new Problem(new LinternaEstado(permiteControlCiclos()), new LinternaFuncionSucesor(),
                    new LinternaEstadoObjetivo());
        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }
}

