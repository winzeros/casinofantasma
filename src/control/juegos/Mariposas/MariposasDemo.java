package control.juegos.mariposas;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author JOSECARLOS
 */
public class MariposasDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(MariposasDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
        AStarSearch("SALA11", true);
        GreedyBestFirstSearch("SALA11", true);
        //RecursiveBestFirstSearch("SALA11", true);
        SimulatedAnnealingSearch("SALA11", true);
        HillClimbingSearch("SALA11", true);
    }

    /**
     * Busqueda GreedyBestFirstSearch con Funcion Heuristica Manhattan.
     * @param sala
     */
    public static boolean GreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;

        try {

            MariposasJuego juego = new MariposasJuego(new GreedyBestFirstSearch(new GraphSearch()), new MariposasFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Manhattan");
                log.info("*******************************************\n");
                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;

    }

    /**
     * Busqueda primero en anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            MariposasJuego juego = new MariposasJuego(new BreadthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" BÚSQUEDA PRIMERO EN ANCHURA");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            MariposasJuego juego = new MariposasJuego(new DepthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" Busqueda en profundidad");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profuncidad limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new DepthLimitedSearch(11));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" Busq con profundidad limitada");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new UniformCostSearch(new TreeSearch()));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" Busqueda de coste uniforme");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda A*.
     * @param sala
     */
    public static boolean AStarSearch(String sala, boolean consola) {

        boolean ok = true;
        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new AStarSearch(new TreeSearch()), new MariposasFuncionHeuristica());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" Busqueda A*");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new MariposasFuncionHeuristica());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" Busqueda RecursiveBestFirstSearch*");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean SimulatedAnnealingSearch(String sala, boolean consola) {

        boolean ok = true;
        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new SimulatedAnnealingSearch(), new MariposasFuncionHeuristica());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" Busqueda SimulatedAnnealingSearch");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala, boolean consola) {

        boolean ok = true;
        MariposasJuego juego;

        try {
            juego = new MariposasJuego(new HillClimbingSearch(), new MariposasFuncionHeuristica());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO MARIPOSA");
                log.info(" Busqueda HillClimbingSearch");
                log.info("*******************************************\n");

                log.info(" \n\n***********************************\n" + new MariposasEstado().getInstante().imprimirTablero(new MariposasEstado().getInstante()) + "***********************************\n");

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(MariposasJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}
