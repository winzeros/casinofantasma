/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class RanasDemo {

    private final static Logger log = Logger.getLogger(RanasDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo();
        DepthFirstSearchDemo();
        DepthLimitedSearchDemo();
        UniformCostSearchDemo();
        IterativeDeepeningSearchDemo();
        BidirectionalSearchDemo();
    }

    private static void BreadthFirstDemo() {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("     BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RanasDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void DepthFirstSearchDemo() {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RanasDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void DepthLimitedSearchDemo() {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n**************************************");
            log.info(" BÚSQUEDA EN PROFUNDIDAD LIMITADA A 11");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RanasDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void UniformCostSearchDemo() {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA DE COSTE UNIFORME");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RanasDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void IterativeDeepeningSearchDemo() {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n**************************************");
            log.info("           BÚSQUEDA ITERATIVA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RanasDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void BidirectionalSearchDemo() {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new BidirectionalSearch());

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA BIDIRECCIONAL");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RanasDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
