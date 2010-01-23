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

    public final static Logger log = Logger.getLogger(MonoBananaDemo.class.getName());

    public static void main(String[] args) {
        BreadthFirstDemo("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        IterativeDeepeningSearchDemo("SALA11");
    }

    public static void BreadthFirstDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthFirstSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthLimitedSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void UniformCostSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void IterativeDeepeningSearchDemo(String sala) {

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

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

}
