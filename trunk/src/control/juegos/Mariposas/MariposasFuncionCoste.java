package control.juegos.mariposas;

import aima.search.framework.StepCostFunction;

/**
 * Clase que representa el coste del juego.
 * @author jcarlos
 */
public class MariposasFuncionCoste implements StepCostFunction{

    /**
     * Metodo que calcula el coste de pasar de un estado padre a un estado hijo.
     * @param origen
     * @param destino
     * @param accion
     * @return
     */
    public Double calculateStepCost(Object origen, Object destino, String accion) {
        MariposasEstado padre = (MariposasEstado)origen;
        MariposasEstado hijo = (MariposasEstado)destino;
        return padre.generarCoste(hijo);
    }

}
