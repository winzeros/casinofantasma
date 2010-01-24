/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.HeuristicFunction;

/**
 * Clase que representa la heuristica de los discos que se encuentran
 * mal colocados en el juego.
 * @author Laura
 */
public class HanoiHeuristicaMalColocados implements HeuristicFunction {

    /**
     * Calculamos la heuristica en funcion de los discos que estan colocados
     * en su lugar correcto.
     * @return heuristica
     */
    public double getHeuristicValue(Object state) {

        HanoiEstado estado = (HanoiEstado) state;

        double heuristica = 0.0;
        int aux = 0;
        int[][] actual = estado.getTablero();
        if (actual[2][0] != 3)
            aux += 1;
        if (actual[2][1] != 2)
            aux += 1;
        if (actual[2][2] != 1)
            aux += 1;
        heuristica = (aux / 9)* 100;
        return heuristica;
    }
}

