/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author Alicia
 */
public class OvejasLobosHeuristicaDescolocados implements HeuristicFunction {

    public double getHeuristicValue(Object state) {
        OvejasLobosEstado estado = (OvejasLobosEstado) state;
        return estado.getOrilla().get(OvejasLobosEstado.OVEJAS) + estado.getOrilla().get(OvejasLobosEstado.LOBOS);
    }
}
