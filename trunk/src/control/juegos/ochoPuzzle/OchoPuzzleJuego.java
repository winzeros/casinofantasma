/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ochoPuzzle;

import aima.search.framework.HeuristicFunction;
import aima.search.framework.Problem;
import aima.search.framework.Search;

import control.juegos.Juego;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author JOSECARLOS
 */
public class OchoPuzzleJuego extends Juego {

 /*   private OchoPuzzleEstados estado = null;
    private OchoPuzzleFuncionObjetivo objetivo = null;*/

    OchoPuzzleJuego(Search busqueda) {
 
        try {
            this._busqueda = busqueda;
            this._nombre = "Problema 8Puzzle";
            this._problema = new Problem(new OchoPuzzleEstados(), new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo(this));
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }

    }

    OchoPuzzleJuego(Search busqueda, HeuristicFunction heuristica) {
         try {
            this._busqueda = busqueda;
            this._nombre = "Problema 8Puzzle";
            this._problema = new Problem(new OchoPuzzleEstados(), new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo(this), heuristica);
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    
    }



    
 /*   @Override
    public void ejecutar() {
        //busqueda profundidad limitada
        if (this.busqueda instanceof DepthLimitedSearch) {
            problema = new Problem(new OchoPuzzleEstados(),
                    new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo());
        } else if (this.busqueda instanceof IterativeDeepeningSearch) {
            problema = new Problem(new OchoPuzzleEstados(),
                    new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo());
        } else if (this.busqueda instanceof GreedyBestFirstSearch) {
            problema = new Problem(new OchoPuzzleEstados(),
                    new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo(),
                    new OchoPuzzleFuncionDescolocados());
                   
        } else if (this.busqueda instanceof AStarSearch) {
            problema = new Problem(new OchoPuzzleEstados(),
                    new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo(),
                    new OchoPuzzleFuncionManhattan());
        } else if (this.busqueda instanceof SimulatedAnnealingSearch) {
            problema = new Problem(new OchoPuzzleEstados(),
                    new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo(), new OchoPuzzleFuncionManhattan());
        }
        else if (this.busqueda instanceof BreadthFirstSearch) {
            problema = new Problem(new OchoPuzzleEstados(),
                    new OchoPuzzleFuncionSucesor(),
                    new OchoPuzzleFuncionObjetivo());

        }

        try {

            SearchAgent agent = new SearchAgent(problema, busqueda);
            this.imprimir(agent.getActions());
            this.imprimirPropiedades(agent.getInstrumentation());
            
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }*/

}






    




