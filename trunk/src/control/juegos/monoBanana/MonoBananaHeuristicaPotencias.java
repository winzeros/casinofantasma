/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.monoBanana;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author Laura
 */
public class MonoBananaHeuristicaPotencias implements HeuristicFunction {

    /**
     * Asignamos a cada estado el número correspondiente
     * a elevar 2 al primer elemento, 3 al segundo, 5 al tercero y 7 al cuarto
     * El hecho de elegir estos números y después multiplicarlos es que la
     * descomposición en factores primos de un número siempre es única
     * @return heuristica
     */
    public double getHeuristicValue(Object state) {

        MonoBananaEstado estado = (MonoBananaEstado) state;

        double heuristica = 0.0;
        int[] actual = estado.getHabitacion();
        heuristica = Math.pow(2, actual[0]) * Math.pow(3, actual[1]) *
                Math.pow(5, actual[2]) * Math.pow(7, actual[3]);
        return heuristica;
    }
}
