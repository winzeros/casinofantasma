/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.HeuristicFunction;
import java.util.HashMap;

/**
 * Clase que representa la heuristica de los discos que se pueden mover en
 * cada instante del juego.
 * @author Laura
 */
public class HanoiHeuristicaPosibles implements HeuristicFunction {

    /**
     * Calculamos la heuristica en funcion de los discos que tienen la
     * posibilidad de ejecutar un movimiento.
     * @return heuristica
     */
    public double getHeuristicValue(Object state) {

        HanoiEstado estado = (HanoiEstado) state;

        double heuristica = 0.0;
        int aux = 0;
        HashMap<Integer, Integer> actual = estado.getPosibles();
        for (int i = 0; i < 3; i++)
            if (actual.get(i) != 10)
                aux++;
        heuristica = (aux / 6)* 100;
        return heuristica;
    }
}

