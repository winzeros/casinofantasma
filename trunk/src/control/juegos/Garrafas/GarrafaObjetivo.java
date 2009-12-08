package control.juegos.Garrafas;

import aima.search.framework.GoalTest;

/**
 *
 * @author GabiPC
 */
public class GarrafaObjetivo implements GoalTest {

    private Garrafas garrafilla;
    
    /**
     * Constructor parametrizado
     */
    public GarrafaObjetivo(Garrafas inicio) {
        this.garrafilla = inicio;
    }

    @Override
    public boolean isGoalState(Object state){
        ((GarrafaEstado)state).getContenido().add(new Contenido(((GarrafaEstado)state).getGarrafa3(),((GarrafaEstado)state).getGarrafa4()));
        return ((GarrafaEstado)state).esObjetivo();
    }
}
