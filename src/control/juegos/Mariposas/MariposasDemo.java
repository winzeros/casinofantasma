package control.juegos.mariposas;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;
import control.juegos.rejillaRojoAzul.RejillaRojoAzulDemo;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author JOSECARLOS
 */
public class MariposasDemo {

    public final static Logger log = Logger.getLogger(RejillaRojoAzulDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11");
        RejillaRojoAzulGreedyBestFirstSearch("SALA11");
        DepthFirstSearchDemo("SALA11");
        DepthLimitedSearchDemo("SALA11");
        UniformCostSearchDemo("SALA11");
        AStarSearch("SALA11");
    }

    public static void RejillaRojoAzulGreedyBestFirstSearch(String sala) {

        try {

            MariposasJuego juego = new MariposasJuego(new GreedyBestFirstSearch(new GraphSearch()));
            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO MARIPOSA");
            log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Manhattan");
            log.info("*******************************************\n");
            log.info(" \n\n***********************************\n"
                    + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante())
                    + "***********************************\n");

            juego.ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void BreadthFirstDemo(String sala) {
        try {
            MariposasJuego juego = new MariposasJuego(new BreadthFirstSearch(new TreeSearch()));
            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO MARIPOSA");
            log.info(" BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante())
                    + "***********************************\n");
            juego.ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthFirstSearchDemo(String sala) {



        try {
            MariposasJuego juego = new MariposasJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO MARIPOSA");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante())
                    + "***********************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void DepthLimitedSearchDemo(String sala) {

        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO MARIPOSA");
            log.info(" Busq en profundidad limitada");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante())
                    + "***********************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void UniformCostSearchDemo(String sala) {

        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO MARIPOSA");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante())
                    + "***********************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }

    public static void AStarSearch(String sala) {

        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new AStarSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO MARIPOSA");
            log.info(" Busqueda AEstrella");
            log.info("*******************************************\n");

            log.info(" \n\n***********************************\n"
                    + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante())
                    + "***********************************\n");

            juego.ejecutar();

        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
    }
}
