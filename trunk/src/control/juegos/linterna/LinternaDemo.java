/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase para ejecutar el juego de la Linterna.
 * @author Laura
 */
public class LinternaDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(LinternaDemo.class.getName());

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

        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static void DepthFirstSearchDemo(String sala) {

        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda con profuncidad limitada.
     * @param sala
     */
    public static void DepthLimitedSearchDemo(String sala) {

        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static void UniformCostSearchDemo(String sala) {

        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static void IterativeDeepeningSearchDemo(String sala) {

        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda voraz.
     * @param sala
     */
    public static void eightPuzzleGreedyBestFirstDemo(String sala) {

        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new GreedyBestFirstSearch(new GraphSearch()), new LinternaHeuristicaPersonas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda voraz");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda A*
     * @param sala
     */
    public static void eightPuzzleAStarDemo(String sala) {

        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new AStarSearch(new GraphSearch()), new LinternaHeuristicaRestante());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda A*");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

}
