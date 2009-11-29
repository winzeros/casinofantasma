/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejas_lobos;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class OvejasLobosDemo {

    private final static Logger log = Logger.getLogger(OvejasLobosDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo();
        DepthFirstSearchDemo();
        DepthLimitedSearchDemo();
        UniformCostSearchDemo();
        IterativeDeepeningSearchDemo();
    }

    private static void BreadthFirstDemo() {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("     BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void DepthFirstSearchDemo() {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("    BÚSQUEDA PRIMERO EN PROFUNDIDAD");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void DepthLimitedSearchDemo() {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n**************************************");
            log.info(" BÚSQUEDA EN PROFUNDIDAD LIMITADA A 11");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void UniformCostSearchDemo() {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n**************************************");
            log.info("       BÚSQUEDA DE COSTE UNIFORME");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void IterativeDeepeningSearchDemo() {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n**************************************");
            log.info("           BÚSQUEDA ITERATIVA");
            log.info("**************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
