/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import aima.search.framework.HeuristicFunction;

/**
 * Clase que representa la heuristica de las personas que aun no han
 * cruzado el puente del juego.
 * @author Laura
 */
public class LinternaHeuristicaPersonas implements HeuristicFunction {

    /**
     * Calculamos la heuristica en funcion del numero de personas que
     * quedan por pasar al otro lado del puente.
     * @return heuristica
     */
    public double getHeuristicValue(Object state) {

        LinternaEstado estado = (LinternaEstado) state;

        double heuristica = 0.0;
        int aux = 5;
        int[] actual = estado.getCalzada();
        for (int i = 0; i < 5; i++) {
            if (actual[i] == 1)
                aux--;
        }
        heuristica = (aux / 5) * 100; //lo dejo sin multiplicar¿¿¿
        return heuristica;
    }
}
