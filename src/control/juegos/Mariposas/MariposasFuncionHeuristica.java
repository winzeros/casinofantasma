package control.juegos.mariposas;

import aima.search.framework.HeuristicFunction;

/**
 * Clase que representa las heuristicas del juego.
 * @author jcarlos
 */
public class MariposasFuncionHeuristica implements HeuristicFunction{

    /**
     * Metodo que devuelve un valor asociado a utilizar una heuristica
     * para la resolucion del juego.
     * @param estado
     * @return
     */
    public double getHeuristicValue(Object estado) {
        return ((MariposasEstado)estado).generarHeuristica();
    }

}
