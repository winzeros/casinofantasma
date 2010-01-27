/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ochoPuzzle;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author JOSECARLOS
 *
 */

//f()=h2+h1; siendo h2=funcionDescolocados y h1=funcion Manhattan
public class OchoPuzzleFuncionHeuristica implements HeuristicFunction{
    public double getHeuristicValue(Object state) {
		
		double retVal = 0;

                retVal= new OchoPuzzleFuncionManhattan().getHeuristicValue(state);
                retVal+= new OchoPuzzleFuncionDescolocados().getHeuristicValue(state);

		return retVal;

	}
}
