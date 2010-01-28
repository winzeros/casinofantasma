/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import aima.search.informed.AStarEvaluationFunction;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.RecursiveBestFirstSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *  Clase para ejecutar el juego de las Torres de Hanoi.
 * @author Laura
 */
public class HanoiDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(HanoiDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        AStarSearch("SALA11");
        GreedyBestFirstSearch("SALA11");
        RecursiveBestFirstSearch("SALA11");
        SimulatedAnnealingSearch("SALA11");
        HillClimbingSearch("SALA11");
    }

    /**
     * Busqueda Primero en Anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda primero en anchura");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda primero en profundidad");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda primero en profundidad limitada a  11");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda de coste uniforme");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda iterativa");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda voraz.
     * @param sala
     */
    public static boolean eightPuzzleGreedyBestFirstDemo(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new GreedyBestFirstSearch(new GraphSearch()), new HanoiHeuristicaMalColocados());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda voraz");
            log.info("*******************************************\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda A*
     * @param sala
     */
    public static boolean eightPuzzleAStarDemo(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new AStarSearch(new GraphSearch()), new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda A*");
            log.info("*******************************************\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

     public static boolean AStarSearch(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new AStarSearch(new TreeSearch()),new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS HANOI ");
            log.info(" Busqueda A*");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearch(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS HANOI ");
            log.info(" Busqueda Greedy Best-First");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()) ,new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS HANOI ");
            log.info(" Busqueda Mejor Recursiva");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


    public static boolean SimulatedAnnealingSearch(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new SimulatedAnnealingSearch() ,new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS HANOI ");
            log.info(" Simulated Annealing Search");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new HillClimbingSearch() ,new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS HANOI ");
            log.info(" Escalada");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

}
