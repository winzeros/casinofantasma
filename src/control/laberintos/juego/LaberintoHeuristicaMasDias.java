/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.laberintos.juego;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author Alicia
 */
public class LaberintoHeuristicaMasDias implements HeuristicFunction{

    public double getHeuristicValue(Object state) {
        LaberintoEstado estado = (LaberintoEstado) state;
        return estado.getRecompensa() - estado.getApuesta();
    }

}
