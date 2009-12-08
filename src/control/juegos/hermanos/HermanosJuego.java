/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hermanos;

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
public class HermanosJuego extends Juego {

    public HermanosJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Hermanos a la greña";
            this._problema = new Problem(new HermanosEstado(permiteControlCiclos()), new HermanosFuncionSucesor(),
                    new HermanosEstadoObjetivo());
        } catch (Exception ex) {
            Logger.getLogger(HermanosJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }
}
