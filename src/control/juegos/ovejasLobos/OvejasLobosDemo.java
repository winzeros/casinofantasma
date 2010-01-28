/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase para ejecutar el juego OvejasLobos.
 * @author Alicia
 */
public class OvejasLobosDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(OvejasLobosDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
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

    /**
     * Busqueda Primero en Anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new BreadthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda primero en anchura");
                log.info("*******************************************\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new DepthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda en profundidad");
                log.info("*******************************************\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new DepthLimitedSearch(11));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda en profundidad limitada");
                log.info("*******************************************\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new UniformCostSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda de coste uniforme");
                log.info("*******************************************\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new IterativeDeepeningSearch());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda iterativa");
                log.info("*******************************************\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda voraz.
     * @param sala
     */
    public static boolean eightPuzzleGreedyBestFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new GreedyBestFirstSearch(new GraphSearch()), new OvejasLobosHeuristicaDescolocados());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda voraz");
                log.info("*******************************************\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda A*
     * @param sala
     */
    public static boolean eightPuzzleAStarDemo(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new AStarSearch(new GraphSearch()), new OvejasLobosHeuristicaDescolocados());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda A*");
                log.info("*******************************************\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearch(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new AStarSearch(new TreeSearch()), new OvejasLobosHeuristicaDescolocados());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda A*");
                log.info("*******************************************\n\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean GreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new GreedyBestFirstSearch(new TreeSearch()), new OvejasLobosHeuristicaDescolocados());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda Greedy Best-First");
                log.info("*******************************************\n\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new OvejasLobosHeuristicaDescolocados());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Busqueda Mejor Recursiva");
                log.info("*******************************************\n\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean SimulatedAnnealingSearch(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new SimulatedAnnealingSearch(), new OvejasLobosHeuristicaDescolocados());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Simulated Annealing Search");
                log.info("*******************************************\n\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala, boolean consola) {

        boolean ok = true;
        OvejasLobosJuego juego;

        try {
            juego = new OvejasLobosJuego(new HillClimbingSearch(), new OvejasLobosHeuristicaDescolocados());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS OVEJAS Y LOS LOBOS");
                log.info(" Escalada");
                log.info("*******************************************\n\n");
                log.info(new OvejasLobosEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}
