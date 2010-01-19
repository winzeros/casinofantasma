/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.regillaRojoAzul;

import aima.search.framework.GoalTest;

/**
 *
 * @author JOSECARLOS
 */
public class RejillaRojoAzulEstadoObjetivo implements GoalTest {

    public boolean isGoalState(Object state) {
        boolean solucion = false;
        RejillaRojoAzulEstado puzzle = (RejillaRojoAzulEstado) state;


        if (((puzzle.getCasilla(0, 0) == "A" && puzzle.getCasilla(0, 1) == "R" && puzzle.getCasilla(0, 2) == "A" &&
                puzzle.getCasilla(1, 0) == "R" && puzzle.getCasilla(1, 1) == "A" && puzzle.getCasilla(1, 2) == "R" &&
                puzzle.getCasilla(2, 0) == "A" && puzzle.getCasilla(2, 1) == "R" && puzzle.getCasilla(2, 2) == "A"))
                ||
                ((puzzle.getCasilla(0, 0) == "R" && puzzle.getCasilla(0, 1) == "A" && puzzle.getCasilla(0, 2) == "R" &&
                puzzle.getCasilla(1, 0) == "A" && puzzle.getCasilla(1, 1) == "R" && puzzle.getCasilla(1, 2) == "A" &&
                puzzle.getCasilla(2, 0) == "R" && puzzle.getCasilla(2, 1) == "A" && puzzle.getCasilla(2, 2) == "R"))) {
            solucion = true;
        }
        return solucion;
    }
}
