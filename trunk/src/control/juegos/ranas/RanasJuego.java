/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.*;
import aima.search.uninformed.*;
import control.juegos.Juego;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class RanasJuego extends Juego {

    public RanasJuego(Search busqueda) throws Exception {

        try {
         /*   this._busqueda = busqueda;
            this._nombre = "El juego de las Ranas";
            this._solucion = false;
            if (this._busqueda instanceof BidirectionalSearch) {
                Problem originalProblem = new Problem(new RanasEstado(permiteControlCiclos()), new RanasFuncionSucesor(),
                        new RanasEstadoObjetivo(this));
                Problem destiny = new Problem(new RanasEstado(permiteControlCiclos()), new RanasFuncionSucesor(),
                        new RanasEstadoObjetivo(this));
            }
            this._problema = new Problem(new RanasEstado(permiteControlCiclos()), new RanasFuncionSucesor(),
                    new RanasEstadoObjetivo(this));*/
        } catch (Exception ex) {
            Logger.getLogger(RanasJuego.class.getName()).log(Level.SEVERE, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }


}
