/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.monoBanana;

import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase para ejecutar el juego del Mono y la Banana.
 * @author laura
 */
public class MonoBananaDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(MonoBananaDemo.class.getName());

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
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new BreadthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda primero en anchura");
                log.info("*******************************************\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new DepthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda en profundidad");
                log.info("*******************************************\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profundida limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new DepthLimitedSearch(5));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda en profundidad limitada");
                log.info("*******************************************\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new UniformCostSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda de coste uniforme");
                log.info("*******************************************\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new IterativeDeepeningSearch());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda iterativa");
                log.info("*******************************************\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearch(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new AStarSearch(new TreeSearch()), new MonoBananaHeuristicaPotencias());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda A*");
                log.info("*******************************************\n\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean GreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new GreedyBestFirstSearch(new TreeSearch()), new MonoBananaHeuristicaPotencias());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda Greedy Best-First");
                log.info("*******************************************\n\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new MonoBananaHeuristicaPotencias());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Busqueda Mejor Recursiva");
                log.info("*******************************************\n\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean SimulatedAnnealingSearch(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new SimulatedAnnealingSearch(), new MonoBananaHeuristicaPotencias());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Simulated Annealing Search");
                log.info("*******************************************\n\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala, boolean consola) {

        boolean ok = true;
        MonoBananaJuego juego;

        try {
            juego = new MonoBananaJuego(new HillClimbingSearch(), new MonoBananaHeuristicaPotencias());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DEL MONO Y LA BANANA");
                log.info(" Escalada");
                log.info("*******************************************\n\n");
                log.info(new MonoBananaEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}
