package control.juegos.ochoPuzzle;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author JOSECARLOS
 * 
 */
public class OchoPuzzleDemo {

    public final static Logger log = Logger.getLogger(OchoPuzzleDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        IterativeDeepeningSearchDemo("SALA11");
        // eightPuzzleGreedyBestFirstDemo("SALA11");
        // eightPuzzleGreedyBestFirstManhattanDemo("SALA11");
        //eightPuzzleAStarManhattanDemo("SALA11");
        eightPuzzleSimulatedAnnealingDemo("SALA11");
    }

    public static boolean eightPuzzleGreedyBestFirstManhattanDemo(String sala) {

        boolean ok = false;

        try {

            OchoPuzzleJuego juego = new OchoPuzzleJuego(new GreedyBestFirstSearch(new GraphSearch()));
            log.info("\n\n\n**********************************************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA GreedyBestFirstSearch \n" +
                    " con Funcion Heuristica Manhattan");
            log.info("**********************************************************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");

            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthLimitedSearchDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new DepthLimitedSearch(9));
            log.info("\n\n\n*********************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA RECURSIVA DLS");
            log.info("*********************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");
            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthFirstSearchDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new DepthFirstSearch(new TreeSearch()));
            log.info("\n\n\n*********************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA RECURSIVA DLS");
            log.info("*********************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");
            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean UniformCostSearchDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new UniformCostSearch(new TreeSearch()));
            log.info("\n\n\n*********************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA RECURSIVA DLS");
            log.info("*********************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");
            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean IterativeDeepeningSearchDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new IterativeDeepeningSearch());
            log.info("\n\n\n********************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA ITERATIVA IDLS");
            log.info("*********************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");

            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean eightPuzzleGreedyBestFirstDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new GreedyBestFirstSearch(new GraphSearch()));
            log.info("\n\n\n***************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA GreedyBestFirstSearch con función Descolocados");
            log.info("***************************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");
            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;

    }

    public static boolean eightPuzzleAStarManhattanDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new AStarSearch(new GraphSearch()));
            log.info("\n\n\n*************************************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA A ESTRELLA CON FUNCION HEURISTICA DE MANHATTAN");
            log.info("**************************************************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");
            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean eightPuzzleSimulatedAnnealingDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new SimulatedAnnealingSearch());
            log.info("\n\n\n************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA RECORRIDO SIMULADO ");
            log.info("************************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");
            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean BreadthFirstDemo(String sala) {

        boolean ok = false;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new BreadthFirstSearch(new TreeSearch()));
            log.info("\n\n\n*****************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO 8PUZZLE");
            log.info(" BÚSQUEDA BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("******************************************\n");
            log.info(new OchoPuzzleEstados().toString() + "\n\n");
            ok = juego.ejecutarConsola();
        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}


