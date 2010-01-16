package control.juegos.Garrafas;

import aima.search.framework.GoalTest;

/**
 *
 * @author jcarlos
 */
public class GarrafasEstadoObjetivo implements GoalTest {

    private GarrafasJuego garrafilla;
    
    /**
     * Constructor parametrizado
     */
    public GarrafasEstadoObjetivo(GarrafasJuego inicio) {
        this.garrafilla = inicio;
    }

    @Override
    public boolean isGoalState(Object state){
        ((GarrafasEstado)state).getContenido().add(new GarrafasContenido(((GarrafasEstado)state).getGarrafa3(),((GarrafasEstado)state).getGarrafa4()));
        return ((GarrafasEstado)state).esObjetivo();
    }
}
