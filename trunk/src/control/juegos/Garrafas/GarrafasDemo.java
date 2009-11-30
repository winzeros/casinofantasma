package control.juegos.Garrafas;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;

/**
 *
 * @author Grupo C15
 */
public class GarrafasDemo {


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
        
        System.out.println("\n\n\n**************************************");
        System.out.println("           BÚSQUEDA BIDIRECCIONAL");
        System.out.println("**************************************\n");
        BidirectionalSearch();
        
    }

    private static void BreadthFirstDemo() {
        GarrafasJuego juego = new GarrafasJuego(new BreadthFirstSearch(new TreeSearch()));
        juego.ejecutar();

    }

    private static void DepthFirstSearchDemo() {
        GarrafasJuego juego = new GarrafasJuego(new DepthFirstSearch(new TreeSearch()));
        juego.ejecutar();
    }

   private static void DepthLimitedSearchDemo() {
        GarrafasJuego juego = new GarrafasJuego(new DepthLimitedSearch(11));
        juego.ejecutar();
    }

      private static void UniformCostSearchDemo() {
        GarrafasJuego juego = new GarrafasJuego(new UniformCostSearch(new TreeSearch()));
        juego.ejecutar();
    }

    private static void IterativeDeepeningSearchDemo() {
        GarrafasJuego juego = new GarrafasJuego(new IterativeDeepeningSearch());
        juego.ejecutar();
    }

    
    private static void BidirectionalSearch(){
        GarrafasJuego juego= new GarrafasJuego(new BidirectionalSearch());
        juego.ejecutar();
    }
    
}

