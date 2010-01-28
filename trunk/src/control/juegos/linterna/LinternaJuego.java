/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import aima.search.framework.HeuristicFunction;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa el juego de la Linterna.
 * @author Laura
 */
public class LinternaJuego extends Juego {

    /**
     * Constructor del juego.
     * @param busqueda
     * @throws Exception
     */
    LinternaJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "El juego de la linterna";
            this._problema = new Problem(new LinternaEstado(permiteControlCiclos()), new LinternaFuncionSucesor(),
                    new LinternaEstadoObjetivo(this));
        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    /**
     * Constructor del juego.
     * @param busqueda
     * @param heuristica
     * @throws Exception
     */
    LinternaJuego(Search busqueda, HeuristicFunction heuristica)
            throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Torres de Hanoi";
            this._problema = new Problem(new LinternaEstado(permiteControlCiclos()),
                    new LinternaFuncionSucesor(),new LinternaEstadoObjetivo(this),
                    heuristica);
        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR,
                    "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    /**
     * Metodo utilizado en la busqueda iterativa para no permitir la formacion
     * de ciclos en el arbol de busqueda del juego.
     * @return
     */
    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }
}

