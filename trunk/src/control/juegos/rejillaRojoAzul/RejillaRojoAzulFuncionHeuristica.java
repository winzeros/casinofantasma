/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.rejillaRojoAzul;

import aima.search.framework.HeuristicFunction;

/**
 *
 * @author JOSECARLOS
 */

public class RejillaRojoAzulFuncionHeuristica implements HeuristicFunction{

	public double getHeuristicValue(Object state) {
		RejillaRojoAzulEstado puzzle=(RejillaRojoAzulEstado)state;
	        int valorHorizontal = 0;
	        int valorVertical = 0;
	        //cantidad de pares horizontales
	        for(int i =0;i<=2;i++){
	        	for(int j =0;j<=1;j++){
		        	if(puzzle.getCasilla(i,j)==puzzle.getCasilla(i,j+1)){
		        		valorHorizontal++;
		        	}
		        }
	        }
	        //cantidad de pares verticales
	        for(int i =0;i<=2;i++){
	        	for(int j =0;j<=1;j++){
		        	if(puzzle.getCasilla(i,j)==puzzle.getCasilla(j+1,i)){
		        		valorVertical++;
		        	}
		        }
	        }
	        return (valorHorizontal+valorVertical);
		}
	}

