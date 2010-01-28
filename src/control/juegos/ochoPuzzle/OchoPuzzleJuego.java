/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ochoPuzzle;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.AStarSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;

import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.BreadthFirstSearch;
import control.juegos.Juego;

/**
 *
 * @author JOSECARLOS
 */
public class OchoPuzzleJuego extends Juego {

    private String nombre;
    private boolean solucion;
    private Search busqueda = null;
    private SearchAgent agente = null;
    private Problem problema = null;
    private OchoPuzzleEstados estado = null;
    private OchoPuzzleFuncionObjetivo objetivo = null;

    public OchoPuzzleJuego(Search busqueda) {
        this.busqueda = busqueda;
        this.nombre = "Problema 8Puzzle";
        this.solucion = false;
        this.estado = new OchoPuzzleEstados();
        this.objetivo = new OchoPuzzleFuncionObjetivo();


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






    




