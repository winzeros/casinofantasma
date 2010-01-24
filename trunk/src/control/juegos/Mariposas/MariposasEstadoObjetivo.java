package control.juegos.mariposas;

import aima.search.framework.GoalTest;

/**
 * Clase que re`resenta el estado objetivo del juego de las Mariposas.
 * @author jcarlos
 */
public class MariposasEstadoObjetivo implements GoalTest {

    /**
     * Representa el juego.
     */
    private MariposasJuego granja;


    /**
     * Constructor parametrizado
     * @param aThis Control del juego
     */
    public MariposasEstadoObjetivo(MariposasJuego aThis) {
        this.granja = aThis;
    }
    

    /**
     * Metodo que devuelve si el estado alcanzado es el estado objetivo.
     * @param estado
     * @return goal
     */
    public boolean isGoalState(Object estado) {
        boolean goal = false;
        if(((MariposasEstado)estado).generarHeuristica() == 0.0)
            goal = true;
        this.granja.setSolucion(goal);
        return goal;
    }

}
