/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ranas;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author Laura
 */
public class RanasHeuristicasDescolocadas implements HeuristicFunction {

    /**
     * Numero de Ranas que estan descolocadas
     * @return
     */
    public double getHeuristicValue(Object state) {

        RanasEstado estado = (RanasEstado) state;

        double heuristica = 0.0;
        String[] actual = estado.getHojas();
        int p = 0;
        for (int i = 6; i >= 0; i--) {
            if (actual[i].equals(RanasEstado.RANA)) {
                p--;
            }
            if (actual[i].equals(RanasEstado.SAPO)) {
                heuristica = p;
            }
        }
        return heuristica;

    }
}
