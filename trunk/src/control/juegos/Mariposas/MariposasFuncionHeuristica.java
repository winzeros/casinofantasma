package control.juegos.Mariposas;

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
