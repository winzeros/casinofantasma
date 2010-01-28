/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.rejillaRojoAzul;

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
public class RejillaRojoAzulDemo {



public final static Logger log = Logger.getLogger(RejillaRojoAzulDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
        RejillaRojoAzulGreedyBestFirstSearch("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
        IterativeDeepeningSearchDemo("SALA11", true);
        AStarSearch("SALA11", true);
        GreedyBestFirstSearch("SALA11", true);
        RecursiveBestFirstSearch("SALA11", true);
        SimulatedAnnealingSearch("SALA11", true);
        HillClimbingSearch("SALA11", true);
        
    }


    public static boolean RejillaRojoAzulGreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = false;

        try{

        RejillaRojoAzulJuego juego = new RejillaRojoAzulJuego(new GreedyBestFirstSearch(new GraphSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Manhattan");
            log.info("*******************************************\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = false;

        try{
        RejillaRojoAzulJuego juego = new RejillaRojoAzulJuego(new BreadthFirstSearch(new TreeSearch()));
        log.info("\n\n\n*******************************************");
            if (sala != null)
            log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" BÚSQUEDA PRIMERO EN ANCHURA");
            log.info("*******************************************\n");
            log.info(new RejillaRojoAzulEstado().toString());
            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        }
        catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
        public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new DepthLimitedSearch(11));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RejillaRojoAzulJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearch(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new AStarSearch(new TreeSearch()),new RejillaRojoAzulFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda A*");
            log.info("*******************************************\n\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RejillaRojoAzulDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new RejillaRojoAzulFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda Greedy Best-First");
            log.info("*******************************************\n\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RejillaRojoAzulDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()) ,new RejillaRojoAzulFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Busqueda Mejor Recursiva");
            log.info("*******************************************\n\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RejillaRojoAzulDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


    public static boolean SimulatedAnnealingSearch(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new SimulatedAnnealingSearch() ,new RejillaRojoAzulFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Simulated Annealing Search");
            log.info("*******************************************\n\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RejillaRojoAzulDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala, boolean consola) {

        boolean ok = false;
        RejillaRojoAzulJuego juego;

        try {
            juego = new RejillaRojoAzulJuego(new HillClimbingSearch() ,new RejillaRojoAzulFuncionHeuristica());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO REJILLA ROJO AZUL");
            log.info(" Escalada");
            log.info("*******************************************\n\n");
            log.info(new RejillaRojoAzulEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RejillaRojoAzulDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

 }

