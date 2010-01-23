package control.juegos.mariposas;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author JOSECARLOSE
 */
public class MariposasFuncionHeuristica implements HeuristicFunction{

	@Override
    public double getHeuristicValue(Object estado) {
        return ((MariposasEstado)estado).generarHeuristica();
    }

}
