/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.Garrafas;

import aima.search.framework.BidirectionalProblem;
import aima.search.framework.Problem;

/**
 *
 * @author usuario_local
 */
public class GarrafasBidireccionalProblem implements BidirectionalProblem{

    private Problem _originalProblem;
    private Problem _reverseProblem;

    public GarrafasBidireccionalProblem(Problem original, Problem reverse){
        _originalProblem = original;
        _reverseProblem = reverse;
    }

    public Problem getOriginalProblem() {
        return _originalProblem;
    }

    public Problem getReverseProblem() {
        return _reverseProblem;
    }


}
