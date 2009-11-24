/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.games.wolfssheeps;

import aima.search.framework.GoalTest;
import java.util.HashMap;

/**
 *
 * @author Alicia
 */
public class WolfsSheepsGoalTest  implements GoalTest {

    public boolean isGoalState(Object arg0) {
        HashMap board = new HashMap(3);

        board.put(WolfsSheepsBoard.WOLFS, 0);
        board.put(WolfsSheepsBoard.SHEEPS, 0);
        board.put(WolfsSheepsBoard.BOAT, 1);

        return arg0.equals(new WolfsSheepsBoard(board));
    }
}
