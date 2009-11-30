package control.juegos.Garrafas;

import aima.search.framework.GoalTest;

/**
 *
 * @author GabiPC
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
        if(((GarrafasEstado)state).esObjetivo())
            this.garrafilla.setSolucion(true);
        ((GarrafasEstado)state).getContenido().add(new Contenido(((GarrafasEstado)state).getGarrafa3(),((GarrafasEstado)state).getGarrafa4()));
        return this.garrafilla.getSolucion();
    }
}
