package control.juegos.ochoPuzzle;

import aima.search.framework.GoalTest;

/**
 * @author JOSECARLOS
 * 
 */
public class OchoPuzzleFuncionObjetivo implements GoalTest {

    private OchoPuzzleJuego juego;

    public OchoPuzzleFuncionObjetivo(OchoPuzzleJuego ochoPuzzle) {
        juego = ochoPuzzle;
    }
    OchoPuzzleEstados goal = new OchoPuzzleEstados(new int[]{0, 1, 2, 3, 4, 5,
                6, 7, 8});

    public boolean isGoalState(Object state) {
        OchoPuzzleEstados tablero = (OchoPuzzleEstados) state;
        boolean ok = tablero.equals(goal);

        if (ok) {
            juego.setSolucion(ok);
        }

        return ok;

    }
}