/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejas_lobos;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;

/**
 *
 * @author Alicia
 */
public class OvejasLobosDemo {

    public static void main(String[] args) {
        System.out.println("\n\n\n**************************************");
        System.out.println("     BÚSQUEDA PRIMERO EN ANCHURA");
        System.out.println("**************************************\n");
        BreadthFirstDemo();
        System.out.println("\n\n\n**************************************");
        System.out.println("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
        System.out.println("**************************************\n");
        DepthFirstSearchDemo();
        System.out.println("\n\n\n**************************************");
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
        IterativeDeepeningSearchDemo();
    }

    private static void BreadthFirstDemo() {
        OvejasLobosJuego juego = new OvejasLobosJuego(new BreadthFirstSearch(new TreeSearch()));
        juego.ejecutar();
    }

    private static void DepthFirstSearchDemo() {
        OvejasLobosJuego juego = new OvejasLobosJuego(new DepthFirstSearch(new TreeSearch()));
        juego.ejecutar();
    }

   private static void DepthLimitedSearchDemo() {
        OvejasLobosJuego juego = new OvejasLobosJuego(new DepthLimitedSearch(11));
        juego.ejecutar();
    }

      private static void UniformCostSearchDemo() {
        OvejasLobosJuego juego = new OvejasLobosJuego(new UniformCostSearch(new TreeSearch()));
        juego.ejecutar();
    }

    private static void IterativeDeepeningSearchDemo() {
        OvejasLobosJuego juego = new OvejasLobosJuego(new IterativeDeepeningSearch());
        juego.ejecutar();
    }
}
