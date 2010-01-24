package control.juegos.Garrafas;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase para ejecutar el juego Garrafas.
 * @author jcarlos
 */
public class GarrafasDemo {

    public final static Logger log = Logger.getLogger(GarrafasDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        IterativeDeepeningSearchDemo("SALA11");
    }

    /**
     * Busqueda primero en anchura.
     * @param sala
     */
    public static void BreadthFirstDemo(String sala) {

        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS GARRAFAS");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new GarrafasEstado().toString(0, 0));

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static void DepthFirstSearchDemo(String sala) {

        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS GARRAFAS");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new GarrafasEstado().toString(0, 0));

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda con profundidad limitada.
     * @param sala
     */
    public static void DepthLimitedSearchDemo(String sala) {

        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS GARRAFAS");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new GarrafasEstado().toString(0, 0));

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static void UniformCostSearchDemo(String sala) {

        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS GARRAFAS");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new GarrafasEstado().toString(0, 0));

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static void IterativeDeepeningSearchDemo(String sala) {

        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS GARRAFAS");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new GarrafasEstado().toString(0, 0));

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
}
