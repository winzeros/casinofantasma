/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.nreinas;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author JOSECARLOS
 */
public class NReinasFuncionHeuristica  implements HeuristicFunction{

    public double getHeuristicValue(Object state) {

                NReinasEstado board = (NReinasEstado) state;
		return board.getTamanoTablero() - board.getNumeroReinas();
    }
}



