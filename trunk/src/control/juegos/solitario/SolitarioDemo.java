/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.solitario;

import aima.search.framework.*;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class SolitarioDemo {

    public final static Logger log = Logger.getLogger(SolitarioDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
        SolitarioGreedyBestFirstSearch("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
        IterativeDeepeningSearchDemo("SALA11", true);
        AStarSearch("SALA11", true);
        GreedyBestFirstSearch("SALA11", true);
        //RecursiveBestFirstSearch("SALA11", true);
        SimulatedAnnealingSearch("SALA11", true);
        HillClimbingSearch("SALA11", true);

    }

    public static boolean SolitarioGreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;

        try {

            SolitarioJuego juego = new SolitarioJuego(new GreedyBestFirstSearch(new GraphSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Manhattan");
                log.info("*******************************************\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            SolitarioJuego juego = new SolitarioJuego(new BreadthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" BÚSQUEDA PRIMERO EN ANCHURA");
                log.info("*******************************************\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }
        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;

        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new DepthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Busqueda en profundidad");
                log.info("*******************************************\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new DepthLimitedSearch(11));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Busqueda en profundidad limitada");
                log.info("*******************************************\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new UniformCostSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Busqueda de coste uniforme");
                log.info("*******************************************\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new IterativeDeepeningSearch());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Busqueda iterativa");
                log.info("*******************************************\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearch(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new AStarSearch(new TreeSearch()), new SolitarioHeuristicaEsquinas());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Busqueda A*");
                log.info("*******************************************\n\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean GreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new GreedyBestFirstSearch(new TreeSearch()), new SolitarioHeuristicaEsquinas());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Busqueda Greedy Best-First");
                log.info("*******************************************\n\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new SolitarioHeuristicaEsquinas());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Busqueda Mejor Recursiva");
                log.info("*******************************************\n\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean SimulatedAnnealingSearch(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new SimulatedAnnealingSearch(), new SolitarioHeuristicaEsquinas());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Simulated Annealing Search");
                log.info("*******************************************\n\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala, boolean consola) {

        boolean ok = true;
        SolitarioJuego juego;

        try {
            juego = new SolitarioJuego(new HillClimbingSearch(), new SolitarioHeuristicaEsquinas());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO SOLITARIO");
                log.info(" Escalada");
                log.info("*******************************************\n\n");
                log.info(new SolitarioEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(SolitarioDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}

