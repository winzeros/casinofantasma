/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.monoBanana;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase para ejecutar el juego del Mono y la Banana.
 * @author laura
 */
public class MonoBananaDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(MonoBananaDemo.class.getName());

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
    public static boolean BreadthFirstDemo(String sala) {

        boolean ok = false;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DEL MONO Y LA BANANA");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new MonoBananaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala) {

        boolean ok = false;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DEL MONO Y LA BANANA");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new MonoBananaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala) {

        boolean ok = false;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new DepthLimitedSearch(5));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DEL MONO Y LA BANANA");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new MonoBananaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala) {

        boolean ok = false;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DEL MONO Y LA BANANA");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new MonoBananaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala) {

        boolean ok = false;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DEL MONO Y LA BANANA");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new MonoBananaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda voraz.
     * @param sala
     */
    public static boolean eightPuzzleGreedyBestFirstDemo(String sala) {

        boolean ok = false;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new GreedyBestFirstSearch(new GraphSearch()), new MonoBananaHeuristicaPotencias());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda voraz");
            log.info("*******************************************\n");
            log.info(new MonoBananaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda A*
     * @param sala
     */
    public static boolean eightPuzzleAStarDemo(String sala) {

        boolean ok = false;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new AStarSearch(new GraphSearch()), new MonoBananaHeuristicaPotencias());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda A*");
            log.info("*******************************************\n");
            log.info(new MonoBananaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

}
