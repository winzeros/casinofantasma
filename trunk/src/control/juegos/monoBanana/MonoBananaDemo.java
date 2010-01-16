/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.monoBanana;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrador
 */
public class MonoBananaDemo {

    private final static Logger log = Logger.getLogger(MonoBananaDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo();
        DepthFirstSearchDemo();
        DepthLimitedSearchDemo();
        UniformCostSearchDemo();
        IterativeDeepeningSearchDemo();
    }

    private static void BreadthFirstDemo() {

        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("     BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void DepthFirstSearchDemo() {

        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void DepthLimitedSearchDemo() {

        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new DepthLimitedSearch(5));

            log.info("\n\n\n**************************************");
            log.info(" BÚSQUEDA EN PROFUNDIDAD LIMITADA A 5");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void UniformCostSearchDemo() {

        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA DE COSTE UNIFORME");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void IterativeDeepeningSearchDemo() {

        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n**************************************");
            log.info("           BÚSQUEDA ITERATIVA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

}
