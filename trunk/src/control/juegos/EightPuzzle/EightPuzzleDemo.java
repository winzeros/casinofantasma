
package control.juegos.EightPuzzle;



import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author JOSECARLOS
 * 
 */
public class EightPuzzleDemo {

    /*
    //proponemos tres tipos de estado inicial ya que hay algunas busquedas que tardarian mucho.
    static EightPuzzleBoard boardWithThreeMoveSolution = new EightPuzzleBoard(
    new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });;

    static EightPuzzleBoard random1 = new EightPuzzleBoard(new int[] { 1, 4, 2,
    7, 5, 8, 3, 0, 6 });

    static EightPuzzleBoard extreme = new EightPuzzleBoard(new int[] { 0, 8, 7,
    6, 5, 4, 3, 2, 1 });
     */

     public final static Logger log = Logger.getLogger(EightPuzzleDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        eightPuzzleDLSDemo("SALA11");
        eightPuzzleIDLSDemo("SALA11");
        eightPuzzleGreedyBestFirstDemo("SALA11");
        eightPuzzleGreedyBestFirstManhattanDemo("SALA11");
        eightPuzzleAStarManhattanDemo("SALA11");
        eightPuzzleSimulatedAnnealingDemo("SALA11");
    }


    private static void eightPuzzleGreedyBestFirstManhattanDemo(String sala) {

        try{

        EightPuzzleJuego juego = new EightPuzzleJuego(new GreedyBestFirstSearch(new GraphSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info("                          " + sala);
            log.info("      JUEGO 8PUZZLE");
            log.info("  BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Manhattan");
            log.info("*******************************************\n");

        juego.ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(EightPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void eightPuzzleDLSDemo(String sala) {
        try{
        EightPuzzleJuego juego = new EightPuzzleJuego(new DepthLimitedSearch(9));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info("                          " + sala);
            log.info("      JUEGO 8PUZZLE");
            log.info("  BÚSQUEDA RECURSIVA DLS");
            log.info("*******************************************\n");
        juego.ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(EightPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }


    private static void eightPuzzleIDLSDemo(String sala) {
        try{
        EightPuzzleJuego juego = new EightPuzzleJuego(new IterativeDeepeningSearch());
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info("                          " + sala);
            log.info("      JUEGO 8PUZZLE");
            log.info("  BÚSQUEDA ITERATIVA IDLS");
            log.info("*******************************************\n");

        juego.ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(EightPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }


     
    private static void eightPuzzleGreedyBestFirstDemo(String sala) {
        try{
        EightPuzzleJuego juego = new EightPuzzleJuego(new GreedyBestFirstSearch(new GraphSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info("                          " + sala);
            log.info("      JUEGO 8PUZZLE");
            log.info("BÚSQUEDA GreedyBestFirstSearch");
            log.info("*******************************************\n");
        juego.ejecutar();
        }catch (Exception ex) {
            Logger.getLogger(EightPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }

    }

    private static void eightPuzzleAStarManhattanDemo(String sala) {
        try{
        EightPuzzleJuego juego = new EightPuzzleJuego(new AStarSearch(new GraphSearch()));
         log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info("                          " + sala);
            log.info("      JUEGO 8PUZZLE");
            log.info("  BÚSQUEDA A ESTRELLA CON FUNCION HEURISTICA DE MANHATTAN");
            log.info("*******************************************\n");
        juego.ejecutar();
        }
        catch (Exception ex) {
            Logger.getLogger(EightPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void eightPuzzleSimulatedAnnealingDemo(String sala) {
        try{
        EightPuzzleJuego juego = new EightPuzzleJuego(new SimulatedAnnealingSearch());
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info("                          " + sala);
            log.info("      JUEGO 8PUZZLE");
            log.info("  BÚSQUEDA RECORRIDO SIMULADO ");
            log.info("*******************************************\n");
        juego.ejecutar();
         }
        catch (Exception ex) {
            Logger.getLogger(EightPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    private static void BreadthFirstDemo(String sala) {
        try{
        EightPuzzleJuego juego = new EightPuzzleJuego(new BreadthFirstSearch(new TreeSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info("                          " + sala);
            log.info("      JUEGO 8PUZZLE");
            log.info("  BÚSQUEDA BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("*******************************************\n");
        juego.ejecutar();
        }
        catch (Exception ex) {
            Logger.getLogger(EightPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

   
}


