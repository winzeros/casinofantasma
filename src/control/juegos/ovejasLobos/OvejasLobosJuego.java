/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.*;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa el juego OvejasLobos
 * @author Alicia
 */
public class OvejasLobosJuego extends Juego {

    /**
     * Constructor del juego.
     * @param busqueda
     * @throws Exception
     */
    public OvejasLobosJuego(Search busqueda) throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Ovejas vs. Lobos";
            this._problema = new Problem(new OvejasLobosEstado(permiteControlCiclos()),
                    new OvejasLobosFuncionSucesor(),new OvejasLobosEstadoObjetivo());
        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosJuego.class.getName()).log(Level.ERROR,
                    "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    /**
     * Constructor del juego.
     * @param busqueda
     * @param heuristica
     * @throws Exception
     */
    public OvejasLobosJuego(Search busqueda, HeuristicFunction heuristica)
            throws Exception {

        try {
            this._busqueda = busqueda;
            this._nombre = "Ovejas vs. Lobos";
            this._problema = new Problem(new OvejasLobosEstado(permiteControlCiclos()),
                    new OvejasLobosFuncionSucesor(),new OvejasLobosEstadoObjetivo(),
                    heuristica);
        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosJuego.class.getName()).log(Level.ERROR,
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
