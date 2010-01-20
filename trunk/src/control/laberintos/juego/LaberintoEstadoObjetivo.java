/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.laberintos.juego;

import aima.basic.Percept;
import aima.search.framework.GoalTest;
import aima.search.map.DynAttributeNames;

/**
 *
 * @author Alicia
 */
public class LaberintoEstadoObjetivo implements GoalTest {
	private String[] goalState = null;

	public LaberintoEstadoObjetivo(String[] goalState) {
		this.goalState = goalState;
	}

	public boolean isGoalState(Object currentState) {

		String location = currentState.toString();
                boolean ok = false;

		if (currentState instanceof Percept) {
			location = (String) ((Percept) currentState)
					.getAttribute(DynAttributeNames.PERCEPT_IN);
		}

                for (int i = 0; i < goalState.length; i++) {
                    ok = ok || goalState[i].equals(location);
                }

                return ok;
	}
}
