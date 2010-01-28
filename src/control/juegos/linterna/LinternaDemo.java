/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.linterna;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase para ejecutar el juego de la Linterna.
 * @author Laura
 */
public class LinternaDemo {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(LinternaDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
        DepthFirstSearchDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        UniformCostSearchDemo("SALA11", true);
        AStarSearchPersonas("SALA11", true);
        GreedyBestFirstSearchPersonas("SALA11", true);
        RecursiveBestFirstSearchPersonas("SALA11", true);
        SimulatedAnnealingSearchPersonas("SALA11", true);
        HillClimbingSearchPersonas("SALA11", true);
        AStarSearchRestante("SALA11", true);
        GreedyBestFirstSearchRestante("SALA11", true);
        RecursiveBestFirstSearchRestante("SALA11", true);
        SimulatedAnnealingSearchRestante("SALA11", true);
        HillClimbingSearchRestante("SALA11", true);

    }

    /**
     * Busqueda Primero en Anchura.
     * @param sala
     */
    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new BreadthFirstSearch(new TreeSearch()));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda primero en anchura");
                log.info("*******************************************\n");
                log.info(new LinternaEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda en profundidad.
     * @param sala
     */
    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new DepthFirstSearch(new TreeSearch()));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda en profundidad");
                log.info("*******************************************\n");
                log.info(new LinternaEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda con profuncidad limitada.
     * @param sala
     */
    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new DepthLimitedSearch(11));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda en profundidad limitada");
                log.info("*******************************************\n");
                log.info(new LinternaEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda de coste uniforme.
     * @param sala
     */
    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new UniformCostSearch(new TreeSearch()));

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda de coste uniforme");
                log.info("*******************************************\n");
                log.info(new LinternaEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda iterativa.
     * @param sala
     */
    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new IterativeDeepeningSearch());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda iterativa");
                log.info("*******************************************\n");
                log.info(new LinternaEstado().toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda A*.
     * @param sala
     */
    public static boolean AStarSearchPersonas(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new AStarSearch(new TreeSearch()), new LinternaHeuristicaPersonas());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda A* \n" +
                        " Heuristica Personas");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean RecursiveBestFirstSearchPersonas(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new LinternaHeuristicaPersonas());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda RecursiveBestFirstSearch \n" +
                        " Heuristica Personas");
                log.info("*******************************************\n");

                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean SimulatedAnnealingSearchPersonas(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new SimulatedAnnealingSearch(), new LinternaHeuristicaPersonas());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda SimulatedAnnealingSearch \n" +
                        " Heuristica Personas");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean HillClimbingSearchPersonas(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new HillClimbingSearch(), new LinternaHeuristicaPersonas());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda HillClimbingSearch \n" +
                        " Heuristica Personas");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda GreedyBestFirstSearch con Funcion Heuristica Manhattan.
     * @param sala
     */
    public static boolean GreedyBestFirstSearchPersonas(String sala, boolean consola) {

        boolean ok = true;

        try {

            LinternaJuego juego = new LinternaJuego(new GreedyBestFirstSearch(new GraphSearch()), new LinternaHeuristicaPersonas());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA \n" +
                        " Heuristica Personas");
                log.info(" BÚSQUEDA GreedyBestFirstSearch con Funcion Heuristica Personas");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;

    }

    /**
     * Busqueda A*.
     * @param sala
     */
    public static boolean AStarSearchRestante(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new AStarSearch(new TreeSearch()), new LinternaHeuristicaRestante());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda A* \n" +
                        " Heuristica Restante");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean RecursiveBestFirstSearchRestante(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new LinternaHeuristicaRestante());

            log.info("\n\n\n*******************************************");
            if (sala != null) {
                log.info(" " + sala);
            }
            log.info(" JUEGO DE LA LINTERNA");
            log.info(" Busqueda RecursiveBestFirstSearch \n" +
                    " Heuristica Restante");
            log.info("*******************************************\n");
            log.info(" \n\n" + (new LinternaEstado()).toString());

            if (consola) {
                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean SimulatedAnnealingSearchRestante(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new SimulatedAnnealingSearch(), new LinternaHeuristicaRestante());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda SimulatedAnnealingSearch \n" +
                        " Heuristica Restante");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    private static boolean HillClimbingSearchRestante(String sala, boolean consola) {

        boolean ok = true;
        LinternaJuego juego;

        try {
            juego = new LinternaJuego(new HillClimbingSearch(), new LinternaHeuristicaRestante());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda HillClimbingSearch \n" +
                        " Heuristica Restante");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    /**
     * Busqueda GreedyBestFirstSearch con Funcion Heuristica Manhattan.
     * @param sala
     */
    public static boolean GreedyBestFirstSearchRestante(String sala, boolean consola) {

        boolean ok = true;

        try {

            LinternaJuego juego = new LinternaJuego(new GreedyBestFirstSearch(new GraphSearch()), new LinternaHeuristicaRestante());

            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LA LINTERNA");
                log.info(" Busqueda GreedyBestFirstSearch \n" +
                        " Heuristica Restante");
                log.info("*******************************************\n");
                log.info(" \n\n" + (new LinternaEstado()).toString());

                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(LinternaJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;

    }
}
