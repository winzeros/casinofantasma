/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.monoBanana;

import aima.search.framework.HeuristicFunction;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * Clase que representa el juego del Mono y la Banana.
 * @author Laura
 */
public class MonoBananaJuego extends Juego {

    /**
     * Constructor del juego.
     * @param busqueda
     * @throws Exception
     */
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

    /**
     * Constructor del juego.
     * @param busqueda
     * @param heuristica
     * @throws Exception
     */
    public MonoBananaJuego(Search busqueda, HeuristicFunction heuristica)
            throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Torres de Hanoi";
            this._problema = new Problem(new MonoBananaEstado(permiteControlCiclos()),
                    new MonoBananaFuncionSucesor(),new MonoBananaEstadoObjetivo(),
                    heuristica);
        } catch (Exception ex) {
            Logger.getLogger(MonoBananaJuego.class.getName()).log(Level.ERROR,
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

