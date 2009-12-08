/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.cambio;

import aima.search.framework.*;
import aima.search.uninformed.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class CambioDemo {

    private final static Logger log = Logger.getLogger(CambioDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo();
        DepthFirstSearchDemo();
        DepthLimitedSearchDemo();
        UniformCostSearchDemo();
        IterativeDeepeningSearchDemo();
        BidirectionalSearchDemo();
    }

    private static void BreadthFirstDemo() {

        CambioJuego juego;

        try {
            juego = new CambioJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("     BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CambioDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void DepthFirstSearchDemo() {

        CambioJuego juego;

        try {
            juego = new CambioJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CambioDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void DepthLimitedSearchDemo() {

        CambioJuego juego;

        try {
            juego = new CambioJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n**************************************");
            log.info(" BÚSQUEDA EN PROFUNDIDAD LIMITADA A 11");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CambioDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void UniformCostSearchDemo() {

        CambioJuego juego;

        try {
            juego = new CambioJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA DE COSTE UNIFORME");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CambioDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void IterativeDeepeningSearchDemo() {

        CambioJuego juego;

        try {
            juego = new CambioJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n**************************************");
            log.info("           BÚSQUEDA ITERATIVA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CambioDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void BidirectionalSearchDemo() {

        CambioJuego juego;

        try {
            juego = new CambioJuego(new BidirectionalSearch());

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA BIDIRECCIONAL");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CambioDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
