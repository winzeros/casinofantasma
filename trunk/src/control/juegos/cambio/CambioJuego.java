/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.cambio;

import aima.search.framework.*;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class CambioJuego extends Juego {

    public CambioJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Problema del cambio";
            this._solucion = false;

            this._problema = new Problem(new CambioEstado(permiteControlCiclos()), new CambioFuncionSucesor(),
                    new CambioEstadoObjetivo(this));
        } catch (Exception ex) {
            Logger.getLogger(CambioJuego.class.getName()).log(Level.SEVERE, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }

}
