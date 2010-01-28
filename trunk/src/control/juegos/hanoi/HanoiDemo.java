/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *  Clase para ejecutar el juego de las Torres de Hanoi.
 * @author Laura
 */
public class HanoiDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(HanoiDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
        AStarSearchMalColocados("SALA11", true);
        GreedyBestFirstSearchMalColocados("SALA11", true);
        SimulatedAnnealingSearchMalColocados("SALA11", true);
        HillClimbingSearchMalColocados("SALA11", true);
        AStarSearchPosibles("SALA11", true);
        GreedyBestFirstSearchPosibles("SALA11", true);
        SimulatedAnnealingSearchPosibles("SALA11", true);

    }

    /**
     * Busqueda Primero en Anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new BreadthFirstSearch(new TreeSearch()));

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda primero en anchura");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new DepthFirstSearch(new TreeSearch()));

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda primero en profundidad");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new DepthLimitedSearch(11));

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda primero en profundidad limitada a  11");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new UniformCostSearch(new TreeSearch()));

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda de coste uniforme");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new IterativeDeepeningSearch());

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda iterativa");
            log.info("**************************************\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


    public static boolean AStarSearchMalColocados(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new AStarSearch(new TreeSearch()),new HanoiHeuristicaMalColocados());

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda AStarSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearchMalColocados(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new HanoiHeuristicaMalColocados());

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda GreedyBestFirstSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }



    public static boolean SimulatedAnnealingSearchMalColocados(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new SimulatedAnnealingSearch() ,new HanoiHeuristicaMalColocados());

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda SimulatedAnnealingSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearchMalColocados(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new HillClimbingSearch() ,new HanoiHeuristicaMalColocados());

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda HillClimbingSearch \n" +
                    " Heuristica Mal Colocados");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearchPosibles(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new AStarSearch(new TreeSearch()),new HanoiHeuristicaPosibles());

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda AStarSearch \n" +
                    " Heuristica Posibles");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }


     public static boolean GreedyBestFirstSearchPosibles(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new GreedyBestFirstSearch(new TreeSearch()) ,new HanoiHeuristicaPosibles());

            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda GreedyBestFirstSearch \n" +
                    " Heuristica Posibles");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }



    public static boolean SimulatedAnnealingSearchPosibles(String sala, boolean consola) {

        boolean ok = true;
        HanoiJuego juego;

        try {
            juego = new HanoiJuego(new SimulatedAnnealingSearch() ,new HanoiHeuristicaPosibles());

            if (consola) {
            log.info("\n\n\n*******************************************");
            if (sala != null)
                log.info(" " + sala);
            log.info(" JUEGO DE LAS TORRES DE HANOI");
            log.info(" Busqueda SimulatedAnnealingSearch \n" +
                    " Heuristica Posibles");
            log.info("*******************************************\n\n");
            log.info(new HanoiEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
             Logger.getLogger(HanoiDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }



}
