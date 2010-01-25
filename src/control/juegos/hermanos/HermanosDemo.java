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
 * Clase para ejecutar el juego los Hermanos a la Greña.
 * @author Alicia
 */
public class HermanosDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(HermanosDemo.class.getName());

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

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static void DepthFirstSearchDemo(String sala) {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static void DepthLimitedSearchDemo(String sala) {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static void UniformCostSearchDemo(String sala) {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static void IterativeDeepeningSearchDemo(String sala) {

        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
}
