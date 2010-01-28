/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa el juego de las Torres de Hanoi.
 * @author Laura
 */
public class HanoiJuego extends Juego {

    /**
     * Constructor del juego.
     * @param busqueda
     * @throws Exception
     */
    HanoiJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Las torres de Hanoi";

            this._problema = new Problem(new HanoiEstado(permiteControlCiclos()), new HanoiFuncionSucesor(),
                    new HanoiEstadoObjetivo(this));
        } catch (Exception ex) {
            Logger.getLogger(HanoiJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    /**
     * Constructor del juego.
     * @param busqueda
     * @param heuristica
     * @throws Exception
     */
    HanoiJuego(Search busqueda, HeuristicFunction heuristica)
            throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Torres de Hanoi";
            this._problema = new Problem(new HanoiEstado(permiteControlCiclos()),
                    new HanoiFuncionSucesor(),new HanoiEstadoObjetivo(this),
                    heuristica);
        } catch (Exception ex) {
            Logger.getLogger(HanoiJuego.class.getName()).log(Level.ERROR,
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
