/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.HeuristicFunction;

/**
 * Clase que representa la heuristica de las ovejas y lobos que se encuentran
 * descolocados en el juego.
 * @author Alicia
 */

public class OvejasLobosHeuristicaDescolocados implements HeuristicFunction {

    /**
     * Metodo que devuelve el valor asociado a la heuristica implementada.
     * @param state
     * @return
     */
    public double getHeuristicValue(Object state) {
        OvejasLobosEstado estado = (OvejasLobosEstado) state;
        return estado.getOrilla().get(OvejasLobosEstado.OVEJAS)
                + estado.getOrilla().get(OvejasLobosEstado.LOBOS);
    }
}
