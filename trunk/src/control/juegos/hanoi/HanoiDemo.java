/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class HanoiDemo {

    private final static Logger log = Logger.getLogger(HanoiDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo();
        DepthFirstSearchDemo();
        DepthLimitedSearchDemo();
        UniformCostSearchDemo();
        //IterativeDeepeningSearchDemo();
        BidirectionalSearchDemo();
    }

    private static void BreadthFirstDemo() {

        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("     BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void DepthFirstSearchDemo() {

        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void DepthLimitedSearchDemo() {

        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n**************************************");
            log.info(" BÚSQUEDA EN PROFUNDIDAD LIMITADA A 11");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void UniformCostSearchDemo() {

        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA DE COSTE UNIFORME");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void IterativeDeepeningSearchDemo() {

        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n**************************************");
            log.info("           BÚSQUEDA ITERATIVA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void BidirectionalSearchDemo() {

        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new BidirectionalSearch());

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA BIDIRECCIONAL");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
}
