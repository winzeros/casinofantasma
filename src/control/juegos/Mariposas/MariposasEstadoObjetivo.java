package control.juegos.Mariposas;

import aima.search.framework.GoalTest;

/**
 *
 * @author JOSECARLOSE
 */
public class MariposasEstadoObjetivo implements GoalTest {

    private MariposasJuego granja;
    
    /**
     * Constructor parametrizado
     * @param aThis Control del juego
     */
    
    public MariposasEstadoObjetivo(MariposasJuego aThis) {
        this.granja = aThis;
    }
    

    @Override
    public boolean isGoalState(Object estado) {
        boolean goal = false;
        if(((MariposasEstado)estado).generarHeuristica() == 0.0)
            goal = true;
        this.granja.setSolucion(goal);
        return goal;
    }

}
