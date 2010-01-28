/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.*;
import aima.search.uninformed.*;
import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class RanasJuego extends Juego {

    RanasJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Movimiento de ranas";
            this._problema = new Problem(new RanasEstado(permiteControlCiclos()), new RanasFuncionSucesor(),
                    new RanasEstadoObjetivo());

        } catch (Exception ex) {
            Logger.getLogger(RanasJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }



    RanasJuego(Search busqueda, HeuristicFunction heuristica) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Movimiento de ranas";
            this._problema = new Problem(new RanasEstado(permiteControlCiclos()),
                    new RanasFuncionSucesor(),new RanasEstadoObjetivo(),
                    heuristica);
        } catch (Exception ex) {
            Logger.getLogger(RanasJuego.class.getName()).log(Level.ERROR,
                    "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }


}
