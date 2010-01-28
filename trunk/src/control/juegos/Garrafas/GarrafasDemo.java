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

        BreadthFirstDemo("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
    }

    /**
     * Busqueda primero en anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new BreadthFirstSearch(new TreeSearch()));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS GARRAFAS");
                log.info(" Busqueda primero en anchura");
                log.info("*******************************************\n");
                log.info(new GarrafasEstado().toString(0, 0));

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
            log.info(ok);

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new DepthFirstSearch(new TreeSearch()));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS GARRAFAS");
                log.info(" Busqueda en profundidad");
                log.info("*******************************************\n");
                log.info(new GarrafasEstado().toString(0, 0));
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
            log.info(ok);

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profundidad limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new DepthLimitedSearch(11));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS GARRAFAS");
                log.info(" Busqueda en profundidad limitada");
                log.info("*******************************************\n");
                log.info(new GarrafasEstado().toString(0, 0));
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
            log.info(ok);

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new UniformCostSearch(new TreeSearch()));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS GARRAFAS");
                log.info(" Busqueda de coste uniforme");
                log.info("*******************************************\n");
                log.info(new GarrafasEstado().toString(0, 0));
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
            log.info(ok);

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        GarrafasJuego juego;

        try {
            juego = new GarrafasJuego(new IterativeDeepeningSearch());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS GARRAFAS");
                log.info(" Busqueda iterativa");
                log.info("*******************************************\n");
                log.info(new GarrafasEstado().toString(0, 0));
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
            log.info(ok);

        } catch (Exception ex) {
            Logger.getLogger(GarrafasDemo.class.getName()).log(Level.ERROR, null, ex);
        }

        return ok;
    }
}

