/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.solitario;

import aima.search.framework.*;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.*;

/**
 *
 * @author Alicia
 */
public class SolitarioDemo {

    public static void main(String[] args) {
        /*System.out.println("\n\n\n**************************************");
        System.out.println("     BÚSQUEDA PRIMERO EN ANCHURA");
        System.out.println("**************************************\n");
        BreadthFirstDemo();*/
        /*System.out.println("\n\n\n**************************************");
        System.out.println("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
        System.out.println("**************************************\n");
        DepthFirstSearchDemo();
        /*System.out.println("\n\n\n**************************************");
        System.out.println(" BÚSQUEDA EN PROFUNDIDAD LIMITADA A 11");
        System.out.println("**************************************\n");
        DepthLimitedSearchDemo();
        System.out.println("\n\n\n**************************************");
        System.out.println("       BÚSQUEDA DE COSTE UNIFORME");
        System.out.println("**************************************\n");
        UniformCostSearchDemo();
        System.out.println("\n\n\n**************************************");
        System.out.println("           BÚSQUEDA ¿ITERATIVA?");
        System.out.println("**************************************\n");
        IterativeDeepeningSearchDemo();*/
        solitarioGreedyBestFirstDemo();
    }

        private static void solitarioGreedyBestFirstDemo() {

        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new GreedyBestFirstSearch(new GraphSearch()), new SolitarioHeuristicaEsquinas());

            System.out.println("\n\n\n**************************************");
            System.out.println("       BÚSQUEDA VORAZ");
            System.out.println("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void BreadthFirstDemo() {
        SolitarioJuego juego = new SolitarioJuego(new BreadthFirstSearch(new TreeSearch()));
        juego.ejecutar();
    }

    private static void DepthFirstSearchDemo() {
        SolitarioJuego juego = new SolitarioJuego(new DepthFirstSearch(new TreeSearch()));
        juego.ejecutar();
    }

   private static void DepthLimitedSearchDemo() {
        SolitarioJuego juego = new SolitarioJuego(new DepthLimitedSearch(11));
        juego.ejecutar();
    }

      private static void UniformCostSearchDemo() {
        SolitarioJuego juego = new SolitarioJuego(new UniformCostSearch(new TreeSearch()));
        juego.ejecutar();
    }

    private static void IterativeDeepeningSearchDemo() {
        SolitarioJuego juego = new SolitarioJuego(new IterativeDeepeningSearch());
        juego.ejecutar();
    }
}
