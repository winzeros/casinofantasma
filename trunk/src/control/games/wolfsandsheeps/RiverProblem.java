/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.games.wolfsandsheeps;

import control.games.*;
import control.games.wolfsandsheeps.RiverBoard;
import java.util.List;
import aima.search.framework.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alicia
 */
class RiverProblem extends Problem {

    public RiverProblem(HashMap initialState) {
        super(initialState, new RiverSuccessors(), new RiverGoalTest());
    }
}

class RiverSuccessors implements SuccessorFunction {

    public List getSuccessors(Object arg0) {
        ArrayList result = new ArrayList();
        RiverBoard state = new RiverBoard();



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                state.setBoard((RiverBoard) arg0);
                state.hit(i, j);
                result.add(new Successor("(" + i + "," + j + ")", state));
            }
        }
        return result;
    }
}

class RiverGoalTest implements GoalTest {

    public boolean isGoalState(Object arg0) {
        HashMap board = new HashMap(3);

        board.put(RiverBoard.WOLFS, 0);
        board.put(RiverBoard.SHEEPS, 0);
        board.put(RiverBoard.BOAT, 1);

        return arg0.equals(new RiverBoard(board));
    }
}
