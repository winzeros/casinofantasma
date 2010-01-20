/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.rejillaRojoAzul;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author JOSECARLOS
 */
public class RejillaRojoAzulDemo {



public final static Logger log = Logger.getLogger(RejillaRojoAzulDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        RejillaRojoAzulGreedyBestFirstSearch("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        IterativeDeepeningSearchDemo("SALA11");
        
    }


    public static void RejillaRojoAzulGreedyBestFirstSearch(String sala) {

        try{

        RejillaRojoAzulJuego juego = new RejillaRojoAzulJuego(new GreedyBestFirstSearch(new GraphSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Manhattan");
            log.info("*******************************************\n");

        juego.ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }


    public static void BreadthFirstDemo(String sala) {
        try{
        RejillaRojoAzulJuego juego = new RejillaRojoAzulJuego(new BreadthFirstSearch(new TreeSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("*******************************************\n");
        juego.ejecutar();
        }
        catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }
        public static void DepthFirstSearchDemo(String sala) {

        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthLimitedSearchDemo(String sala) {

        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void UniformCostSearchDemo(String sala) {

        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void IterativeDeepeningSearchDemo(String sala) {

        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

 }

