/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *  Clase para ejecutar el juego las Torres de Hanoi.
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
        IterativeDeepeningSearchDemo("SALA11");
    }

    /**
     * Busqueda Primero en Anchura.
     * @param sala
     */
    public static void BreadthFirstDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static void DepthFirstSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static void DepthLimitedSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static void UniformCostSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static void IterativeDeepeningSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda voraz.
     * @param sala
     */
    public static void eightPuzzleGreedyBestFirstDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda A*
     * @param sala
     */
    public static void eightPuzzleAStarDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

}
