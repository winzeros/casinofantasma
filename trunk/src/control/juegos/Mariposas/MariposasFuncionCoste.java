package control.juegos.mariposas;

import aima.search.framework.StepCostFunction;

/**
 *
 * @author JOSECARLOSE
 */
public class MariposasFuncionCoste implements StepCostFunction{

	@Override
    public Double calculateStepCost(Object origen, Object destino, String accion) {
        MariposasEstado padre = (MariposasEstado)origen;
        MariposasEstado hijo = (MariposasEstado)destino;
        return padre.generarCoste(hijo);
    }

}
