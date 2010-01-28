/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase para ejecutar el juego de la Linterna.
 * @author Laura
 */
public class LinternaDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(LinternaDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        AStarSearchPersonas("SALA11");
        GreedyBestFirstSearchPersonas("SALA11");
        RecursiveBestFirstSearchPersonas("SALA11");
        SimulatedAnnealingSearchPersonas("SALA11");
        HillClimbingSearchPersonas("SALA11");
        AStarSearchRestante("SALA11");
        GreedyBestFirstSearchRestante("SALA11");
        RecursiveBestFirstSearchRestante("SALA11");
        SimulatedAnnealingSearchRestante("SALA11");
        HillClimbingSearchRestante("SALA11");

    }

    /**
     * Busqueda Primero en Anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profuncidad limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new LinternaEstado().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

 
     /**
     * Busqueda A*.
     * @param sala
     */
    public static boolean AStarSearchPersonas(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new AStarSearch(new TreeSearch()), new LinternaHeuristicaPersonas());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda A* \n" +
                    " Heuristica Personas");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean RecursiveBestFirstSearchPersonas(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new LinternaHeuristicaPersonas());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda RecursiveBestFirstSearch \n" +
                    " Heuristica Personas");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean SimulatedAnnealingSearchPersonas(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new SimulatedAnnealingSearch(), new LinternaHeuristicaPersonas());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda SimulatedAnnealingSearch \n" +
                    " Heuristica Personas");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

        private static boolean HillClimbingSearchPersonas(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new HillClimbingSearch(), new LinternaHeuristicaPersonas());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda HillClimbingSearch \n" +
                    " Heuristica Personas");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

     /**
     * Busqueda GreedyBestFirstSearch con Funcion Heuristica Manhattan.
     * @param sala
     */
    public static boolean GreedyBestFirstSearchPersonas(String sala) {

        boolean ok = false;

        try {

            LinternaJuego juego = new LinternaJuego(new GreedyBestFirstSearch(new GraphSearch()), new LinternaHeuristicaPersonas());
            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA \n" +
                    " Heuristica Personas");
            log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Personas");
            log.info("*******************************************\n");
            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;

    }


     /**
     * Busqueda A*.
     * @param sala
     */
    public static boolean AStarSearchRestante(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new AStarSearch(new TreeSearch()), new LinternaHeuristicaRestante());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda A* \n" +
                    " Heuristica Restante");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean RecursiveBestFirstSearchRestante(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new LinternaHeuristicaRestante());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda RecursiveBestFirstSearch \n" +
                    " Heuristica Restante");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean SimulatedAnnealingSearchRestante(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new SimulatedAnnealingSearch(), new LinternaHeuristicaRestante());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda SimulatedAnnealingSearch \n" +
                    " Heuristica Restante");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

        private static boolean HillClimbingSearchRestante(String sala) {

        boolean ok = false;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new HillClimbingSearch(), new LinternaHeuristicaRestante());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda HillClimbingSearch \n" +
                    " Heuristica Restante");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

     /**
     * Busqueda GreedyBestFirstSearch con Funcion Heuristica Manhattan.
     * @param sala
     */
    public static boolean GreedyBestFirstSearchRestante(String sala) {

        boolean ok = false;

        try {

            LinternaJuego juego = new LinternaJuego(new GreedyBestFirstSearch(new GraphSearch()), new LinternaHeuristicaRestante());
            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda GreedyBestFirstSearch \n" +
                    " Heuristica Restante");
            log.info("*******************************************\n");
            log.info(" \n\n***********************************\n"
                    + juego.toString()
                    + "***********************************\n");

            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;

    }
}
