package control.juegos.Garrafas;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;

/**
 *
 * @author Grupo C15
 */
public class Main {
/*
    public static void main(String[] args) {
        Garrafas nuevo = new Garrafas();
        nuevo.ejecutar();
    }

}
 * 
 */

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
        /*
        System.out.println("\n\n\n**************************************");
        System.out.println("           BÚSQUEDA BIDIRECCIONAL");
        System.out.println("**************************************\n");
        BidirectionalSearch();
         */
    }

    private static void BreadthFirstDemo() {
        Garrafas juego = new Garrafas(new BreadthFirstSearch(new TreeSearch()));
        juego.ejecutar();

    }

    private static void DepthFirstSearchDemo() {
        Garrafas juego = new Garrafas(new DepthFirstSearch(new TreeSearch()));
        juego.ejecutar();
    }

   private static void DepthLimitedSearchDemo() {
        Garrafas juego = new Garrafas(new DepthLimitedSearch(11));
        juego.ejecutar();
    }

      private static void UniformCostSearchDemo() {
        Garrafas juego = new Garrafas(new UniformCostSearch(new TreeSearch()));
        juego.ejecutar();
    }

    private static void IterativeDeepeningSearchDemo() {
        Garrafas juego = new Garrafas(new IterativeDeepeningSearch());
        juego.ejecutar();
    }

    /*
    private static void BidirectionalSearch(){
        Garrafas juego= new Garrafas(new BidirectionalSearch());
        juego.ejecutar();
    }
     */
}

