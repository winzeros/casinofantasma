/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.Garrafas;

import aima.search.framework.BidirectionalProblem;
import aima.search.framework.Problem;

/**
 * Clase que representa la busqueda bidireccional.
 * @author jcarlos
 */
public class GarrafasBidireccionalProblem implements BidirectionalProblem{

    /**
     * Problema original.
     */
    private Problem _originalProblem;
    /**
     * Problema contrario.
     */
    private Problem _reverseProblem;

    /**
     * Constructor parametrizado.
     * @param original
     * @param reverse
     */
    public GarrafasBidireccionalProblem(Problem original, Problem reverse){
        _originalProblem = original;
        _reverseProblem = reverse;
    }

    /**
     * Metodo que devuelve el problema original.
     * @return
     */
    public Problem getOriginalProblem() {
        return _originalProblem;
    }

    /**
     * Metodo que devuelve el problema contrario.
     * @return
     */
    public Problem getReverseProblem() {
        return _reverseProblem;
    }


}
