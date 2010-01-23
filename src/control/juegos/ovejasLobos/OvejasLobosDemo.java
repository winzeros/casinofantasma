/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class OvejasLobosDemo {

    public final static Logger log = Logger.getLogger(OvejasLobosDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        IterativeDeepeningSearchDemo("SALA11");
        eightPuzzleGreedyBestFirstDemo("SALA11");
        eightPuzzleAStarDemo("SALA11");
    }

    public static void BreadthFirstDemo(String sala) {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new OvejasLobosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthFirstSearchDemo(String sala) {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new OvejasLobosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthLimitedSearchDemo(String sala) {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new OvejasLobosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void UniformCostSearchDemo(String sala) {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new OvejasLobosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void IterativeDeepeningSearchDemo(String sala) {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new OvejasLobosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void eightPuzzleGreedyBestFirstDemo(String sala) {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new GreedyBestFirstSearch(new GraphSearch()), new OvejasLobosHeuristicaDescolocados());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
            log.info(" Busqueda voraz");
            log.info("*******************************************\n");
            log.info(new OvejasLobosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void eightPuzzleAStarDemo(String sala) {

        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new AStarSearch(new GraphSearch()), new OvejasLobosHeuristicaDescolocados());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
            log.info(" Busqueda A*");
            log.info("*******************************************\n");
            log.info(new OvejasLobosEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
}
