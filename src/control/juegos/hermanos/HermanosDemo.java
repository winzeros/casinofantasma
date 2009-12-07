/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hermanos;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class HermanosDemo {

    private final static Logger log = Logger.getLogger(HermanosDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo();
        DepthFirstSearchDemo();
        DepthLimitedSearchDemo();
        UniformCostSearchDemo();
        IterativeDeepeningSearchDemo();
    }

    private static void BreadthFirstDemo() {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("     BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void DepthFirstSearchDemo() {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void DepthLimitedSearchDemo() {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new DepthLimitedSearch(5));

            log.info("\n\n\n**************************************");
            log.info(" BÚSQUEDA EN PROFUNDIDAD LIMITADA A 5");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void UniformCostSearchDemo() {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA DE COSTE UNIFORME");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void IterativeDeepeningSearchDemo() {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n**************************************");
            log.info("           BÚSQUEDA ITERATIVA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
}