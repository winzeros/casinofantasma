/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import aima.search.informed.*;
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
        AStarSearchMalColocados("SALA11");
        GreedyBestFirstSearchMalColocados("SALA11");
        SimulatedAnnealingSearchMalColocados("SALA11");
        HillClimbingSearchMalColocados("SALA11");
        AStarSearchPosibles("SALA11");
        GreedyBestFirstSearchPosibles("SALA11");
        SimulatedAnnealingSearchPosibles("SALA11");
      
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

    
    public static boolean AStarSearchMalColocados(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new AStarSearch(new TreeSearch()),new HanoiHeuristicaMalColocados());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda AStarSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearchMalColocados(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new HanoiHeuristicaMalColocados());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda GreedyBestFirstSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }



    public static boolean SimulatedAnnealingSearchMalColocados(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new SimulatedAnnealingSearch() ,new HanoiHeuristicaMalColocados());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda SimulatedAnnealingSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearchMalColocados(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new HillClimbingSearch() ,new HanoiHeuristicaMalColocados());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda HillClimbingSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearchPosibles(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new AStarSearch(new TreeSearch()),new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda AStarSearch \n" +
                    " Heuristica Posibles");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearchPosibles(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda GreedyBestFirstSearch \n" +
                    " Heuristica Posibles");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }



    public static boolean SimulatedAnnealingSearchPosibles(String sala) {

        boolean ok = false;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new SimulatedAnnealingSearch() ,new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda SimulatedAnnealingSearch \n" +
                    " Heuristica Posibles");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

   

}
