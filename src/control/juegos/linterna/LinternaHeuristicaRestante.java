/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import aima.search.framework.HeuristicFunction;

/**
 * Clase que representa la heuristica del tiempo restante del que
 * disponen las personas para cruzar el puente del juego.
 * @author Laura
 */
public class LinternaHeuristicaRestante implements HeuristicFunction {

    /**
     * Hallamos la heuristica en funcion del tiempo restante del que
     * disponen las personas para pasar al otro lado del puente.
     * @return heuristica
     */
    public double getHeuristicValue(Object state) {

        LinternaEstado estado = (LinternaEstado) state;

        double heuristica = 0.0;
        int[] actual = estado.getCalzada();
        int aux = 0;
        for (int i = 0; i < 5; i++) {
            if (actual[i] == 1)
                aux = aux + estado.getTiempo(i);
        }
        heuristica = (aux / actual[6]) * 100; //lo dejo sin multiplicar¿¿¿
        return heuristica;
    }
}
