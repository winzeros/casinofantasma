
package control.juegos.EightPuzzle;

import aima.search.framework.GoalTest;



/**
 * @author JOSECARLOS
 * 
 */

public class EightPuzzleGoalTest implements GoalTest {

        

	EightPuzzleEstados goal = new EightPuzzleEstados(new int[] { 0, 1, 2, 3, 4, 5,
			6, 7, 8 });

	public boolean isGoalState(Object state) {
		EightPuzzleEstados tablero = (EightPuzzleEstados) state;
		boolean ok=tablero.equals(goal);
          
                return ok;

	}

}