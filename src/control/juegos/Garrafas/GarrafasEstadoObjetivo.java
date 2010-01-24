package control.juegos.Garrafas;

import aima.search.framework.GoalTest;

/**
 * Clase que representa el Estado Objetivo del juego de las Garrafas.
 * @author jcarlos
 */
public class GarrafasEstadoObjetivo implements GoalTest {

    /**
     * Represeta la garrafa objetivo
     */
    private GarrafasJuego garrafilla;
    
    /**
     * Constructor parametrizado
     */
    public GarrafasEstadoObjetivo(GarrafasJuego inicio) {
        this.garrafilla = inicio;
    }

    /**
     * Metodo que determina si el estado corresponde al estado ojetivo
     * del juego.
     * @param state
     * @return
     */
    public boolean isGoalState(Object state){
        ((GarrafasEstado)state).getContenido().add(new GarrafasContenido(((GarrafasEstado)state).getGarrafa3(),((GarrafasEstado)state).getGarrafa4()));
        return ((GarrafasEstado)state).esObjetivo();
    }
}
