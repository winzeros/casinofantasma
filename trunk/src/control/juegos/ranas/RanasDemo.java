/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class RanasDemo {

    public final static Logger log = Logger.getLogger(RanasDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        IterativeDeepeningSearchDemo("SALA11");
    }

    public static void BreadthFirstDemo(String sala) {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthFirstSearchDemo(String sala) {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthLimitedSearchDemo(String sala) {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void UniformCostSearchDemo(String sala) {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void IterativeDeepeningSearchDemo(String sala) {

        RanasJuego juego;

        try {
            juego = new RanasJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
}
