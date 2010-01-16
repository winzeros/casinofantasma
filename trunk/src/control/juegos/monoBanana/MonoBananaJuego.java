/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.monoBanana;

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
public class MonoBananaJuego extends Juego {

    public MonoBananaJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "El juego del mono y la banana";
            this._problema = new Problem(new MonoBananaEstado(permiteControlCiclos()), new MonoBananaFuncionSucesor(),
                    new MonoBananaEstadoObjetivo());
        } catch (Exception ex) {
            Logger.getLogger(MonoBananaJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }
}

