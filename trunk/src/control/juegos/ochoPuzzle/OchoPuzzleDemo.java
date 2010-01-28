package control.juegos.ochoPuzzle;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
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
        AStarSearch("SALA11");
        GreedyBestFirstSearch("SALA11");
        RecursiveBestFirstSearch("SALA11");
        SimulatedAnnealingSearch("SALA11");
        HillClimbingSearch("SALA11");
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

    public static boolean AStarSearch(String sala) {

        boolean ok = false;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new AStarSearch(new TreeSearch()),new OchoPuzzleFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO 8PUZZLE");
            log.info(" Busqueda A*");
            log.info("*******************************************\n\n");
            log.info(new OchoPuzzleEstados().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearch(String sala) {

        boolean ok = false;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new OchoPuzzleFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO 8PUZZLE");
            log.info(" Busqueda Greedy Best-First");
            log.info("*******************************************\n\n");
            log.info(new OchoPuzzleEstados().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala) {

        boolean ok = false;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()) ,new OchoPuzzleFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO 8PUZZLE");
            log.info(" Busqueda Mejor Recursiva");
            log.info("*******************************************\n\n");
            log.info(new OchoPuzzleEstados().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


    public static boolean SimulatedAnnealingSearch(String sala) {

        boolean ok = false;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new SimulatedAnnealingSearch() ,new OchoPuzzleFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO 8PUZZLE");
            log.info(" Simulated Annealing Search");
            log.info("*******************************************\n\n");
            log.info(new OchoPuzzleEstados().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala) {

        boolean ok = false;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new HillClimbingSearch() ,new OchoPuzzleFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO 8PUZZLE");
            log.info(" Escalada");
            log.info("*******************************************\n\n");
            log.info(new OchoPuzzleEstados().toString());

            ok = juego.ejecutarConsola();

        } catch (Exception ex) {
             Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}


