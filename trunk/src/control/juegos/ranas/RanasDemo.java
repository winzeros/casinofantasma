/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.TreeSearch;
import aima.search.uninformed.*;
import aima.search.informed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class RanasDemo {

    public final static Logger log = Logger.getLogger(RanasDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
        IterativeDeepeningSearchDemo("SALA11", true);
        AStarSearchRanas("SALA11", true);
        GreedyBestFirstSearchRanas("SALA11", true);
        RecursiveBestFirstSearchRanas("SALA11", true);
        SimulatedAnnealingSearchRanas("SALA11", true);
        HillClimbingSearchRanas("SALA11", true);
        AStarSearchDescolocadas("SALA11", true);
        GreedyBestFirstSearchDescolocadas("SALA11", true);
        RecursiveBestFirstSearchDescolocadas("SALA11", true);
        SimulatedAnnealingSearchDescolocadas("SALA11", true);
        HillClimbingSearchDescolocadas("SALA11", true);
    }

    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new BreadthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda primero en anchura");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());
           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new DepthFirstSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda en profundidad");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new DepthLimitedSearch(20));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda en profundidad limitada");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new UniformCostSearch(new TreeSearch()));

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda de coste uniforme");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new IterativeDeepeningSearch());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda iterativa");
            log.info("*******************************************\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearchRanas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new AStarSearch(new TreeSearch()),new RanasHeuristicaRanas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda A* \n" +
                    " Heuristica Ranas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearchRanas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new RanasHeuristicaRanas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda Greedy Best-First \n" +
                    " Heuristica Ranas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearchRanas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()) ,new RanasHeuristicaRanas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda Mejor Recursiva \n" +
                    " Heuristica Ranas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


    public static boolean SimulatedAnnealingSearchRanas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new SimulatedAnnealingSearch() ,new RanasHeuristicaRanas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Simulated Annealing Search \n" +
                    " Heuristica Ranas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearchRanas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new HillClimbingSearch() ,new RanasHeuristicaRanas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Escalada \n" +
                    " Heuristica Ranas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
    
    public static boolean AStarSearchDescolocadas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new AStarSearch(new TreeSearch()),new RanasHeuristicasDescolocadas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda A* \n" +
                    " Heuristica Descolocadas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearchDescolocadas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new RanasHeuristicasDescolocadas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda Greedy Best-First \n" +
                    " Heuristica Descolocadas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearchDescolocadas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()) ,new RanasHeuristicasDescolocadas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Busqueda Mejor Recursiva \n" +
                    " Heuristica Descolocadas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


    public static boolean SimulatedAnnealingSearchDescolocadas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new SimulatedAnnealingSearch() ,new RanasHeuristicasDescolocadas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Simulated Annealing Search \n" +
                    " Heuristica Descolocadas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearchDescolocadas(String sala, boolean consola) {

        boolean ok = true;
        RanasJuego juego;

        try {
            juego = new RanasJuego(new HillClimbingSearch() ,new RanasHeuristicasDescolocadas());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS RANAS");
            log.info(" Escalada \n" +
                    " Heuristica Descolocadas");
            log.info("*******************************************\n\n");
            log.info(new RanasEstado().toString());

           if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(RanasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

}
