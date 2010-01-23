/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.solitario;

import aima.search.framework.*;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class SolitarioDemo {


public final static Logger log = Logger.getLogger(SolitarioDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
       // SolitarioGreedyBestFirstSearch("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        IterativeDeepeningSearchDemo("SALA11");

    }


    public static void SolitarioGreedyBestFirstSearch(String sala) {

        try{

        SolitarioJuego juego = new SolitarioJuego(new GreedyBestFirstSearch(new GraphSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info(" " + sala);
            log.info(" JUEGO SOLITARIO");
            log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Manhattan");
            log.info("*******************************************\n");
            log.info(new SolitarioEstado().toString());

        juego.ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }


    public static void BreadthFirstDemo(String sala) {
        try{
        SolitarioJuego juego = new SolitarioJuego(new BreadthFirstSearch(new TreeSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info(" " + sala);
            log.info(" JUEGO SOLITARIO");
            log.info(" BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("*******************************************\n");
            log.info(new SolitarioEstado().toString());
        juego.ejecutar();
        }
        catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }
        public static void DepthFirstSearchDemo(String sala) {

        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO SOLITARIO");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new SolitarioEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthLimitedSearchDemo(String sala) {

        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO SOLITARIO");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new SolitarioEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void UniformCostSearchDemo(String sala) {

        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO SOLITARIO");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new SolitarioEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void IterativeDeepeningSearchDemo(String sala) {

        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO SOLITARIO");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new SolitarioEstado().toString());

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

 }

