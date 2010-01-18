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
 *
 * @author Laura
 */
public class HanoiJuego extends Juego {

    public HanoiJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Las torres de Hanoi";

            this._problema = new Problem(new HanoiEstado(permiteControlCiclos()), new HanoiFuncionSucesor(),
                    new HanoiEstadoObjetivo());
        } catch (Exception ex) {
            Logger.getLogger(HanoiJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }

}
