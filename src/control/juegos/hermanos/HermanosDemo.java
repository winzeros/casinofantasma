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

        BreadthFirstDemo("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
    }

    /**
     * Busqueda Primero en Anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new BreadthFirstSearch(new TreeSearch()));
          if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());
  
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new DepthFirstSearch(new TreeSearch()));
            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new DepthLimitedSearch(11));
            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new UniformCostSearch(new TreeSearch()));
            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HermanosJuego juego;

        try {
            juego = new HermanosJuego(new IterativeDeepeningSearch());
            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LOS HERMANOS");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new HermanosEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}
