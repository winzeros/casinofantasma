/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.nreinas;

import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class NReinasDemo {

    public final static Logger log = Logger.getLogger(NReinasDemo.class.getName());

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

    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new BreadthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda primero en anchura");
                log.info("*******************************************\n");
                log.info(new NReinasEstado(8).toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new DepthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda en profundidad");
                log.info("*******************************************\n");
                log.info(new NReinasEstado(8).toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new DepthLimitedSearch(11));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda en profundidad limitada");
                log.info("*******************************************\n");
                log.info(new NReinasEstado(8).toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new UniformCostSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda de coste uniforme");
                log.info("*******************************************\n");
                log.info(new NReinasEstado(8).toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new IterativeDeepeningSearch());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda iterativa");
                log.info("*******************************************\n\n");
                log.info(new NReinasEstado(8).toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearch(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new AStarSearch(new TreeSearch()), new NReinasFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda A*");
                log.info("*******************************************\n\n");
                log.info(new NReinasEstado(8).toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean GreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new GreedyBestFirstSearch(new TreeSearch()), new NReinasFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda GreedyBestFirstSearch");
                log.info("*******************************************\n\n");
                log.info(new NReinasEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new NReinasFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda RecursiveBestFirstSearch");
                log.info("*******************************************\n\n");
                log.info(new NReinasEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean SimulatedAnnealingSearch(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new SimulatedAnnealingSearch(), new NReinasFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda SimulatedAnnealingSearch");
                log.info("*******************************************\n\n");
                log.info(new NReinasEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala, boolean consola) {

        boolean ok = true;
        NReinasJuego juego;

        try {
            juego = new NReinasJuego(new HillClimbingSearch(), new NReinasFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO DE LAS 8 REINAS");
                log.info(" Busqueda HillClimbingSearch");
                log.info("*******************************************\n\n");
                log.info(new NReinasEstado().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(NReinasDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}
