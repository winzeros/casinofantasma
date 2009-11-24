/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.games.wolfssheeps;

import aima.search.framework.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alicia
 */
public class WolfsSheepsSuccesorFunction implements SuccessorFunction {

    public List getSuccessors(Object arg0) {
        ArrayList result = new ArrayList();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                WolfsSheepsBoard state = new WolfsSheepsBoard();
                state.setBoard((WolfsSheepsBoard) arg0);
                if (state.hit(i, j)) {
                    result.add(new Successor("(" + i + "," + j + ")", state));
                }
            }
        }
        return result;
    }
}
