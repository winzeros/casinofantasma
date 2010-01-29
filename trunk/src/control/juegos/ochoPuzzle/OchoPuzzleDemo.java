package control.juegos.ochoPuzzle;

import aima.search.framework.GraphSearch;
import aima.search.framework.TreeSearch;
import aima.search.informed.*;
import aima.search.uninformed.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author JOSECARLOS
 * 
 */
public class OchoPuzzleDemo {

    public final static Logger log = Logger.getLogger(OchoPuzzleDemo.class.getName());

    public static void main(String[] args) {

        BreadthFirstDemo("SALA11", true);
        DepthLimitedSearchDemo("SALA11", true);
        IterativeDeepeningSearchDemo("SALA11", true);
        AStarSearch("SALA11", true);
        //GreedyBestFirstSearch("SALA11", true);
        //RecursiveBestFirstSearch("SALA11", true);
        SimulatedAnnealingSearch("SALA11", true);
        HillClimbingSearch("SALA11", true);
    }

    public static boolean eightPuzzleGreedyBestFirstManhattanDemo(String sala, boolean consola) {

        boolean ok = true;

        try {

            OchoPuzzleJuego juego = new OchoPuzzleJuego(new GreedyBestFirstSearch(new GraphSearch()), new OchoPuzzleFuncionManhattan());
            if (consola) {
                log.info("\n\n\n**********************************************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA eightPuzzleGreedyBestFirstSearch \n" +
                        " con Funcion Heuristica Manhattan");
                log.info("**********************************************************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthLimitedSearchDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new DepthLimitedSearch(9));
            if (consola) {
                log.info("\n\n\n*********************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA CON PROFUNDIDAD LIMITADA");
                log.info("*********************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean DepthFirstSearchDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new DepthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*********************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA EN PROFUNDIDAD");
                log.info("*********************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean UniformCostSearchDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new UniformCostSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*********************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA COSTE UNIFORME");
                log.info("*********************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean IterativeDeepeningSearchDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new IterativeDeepeningSearch());
            if (consola) {
                log.info("\n\n\n********************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA ITERATIVA");
                log.info("*********************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }



    public static boolean eightPuzzleAStarManhattanDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new AStarSearch(new GraphSearch()), new OchoPuzzleFuncionManhattan());
            if (consola) {
                log.info("\n\n\n*************************************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA A ESTRELLA CON FUNCION HEURISTICA DE MANHATTAN");
                log.info("**************************************************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean eightPuzzleSimulatedAnnealingDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new SimulatedAnnealingSearch(), new OchoPuzzleFuncionManhattan());
            if (consola) {
                log.info("\n\n\n************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA RECORRIDO SIMULADO CON HEURISTICA MANHATTAN");
                log.info("************************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean BreadthFirstDemo(String sala, boolean consola) {

        boolean ok = true;

        try {
            OchoPuzzleJuego juego = new OchoPuzzleJuego(new BreadthFirstSearch(new TreeSearch()));
            if (consola) {
                log.info("\n\n\n*****************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" BÚSQUEDA BÚSQUEDA PRIMERO EN ANCHURA");
                log.info("******************************************\n");
                log.info(new OchoPuzzleEstados().toString() + "\n\n");


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleJuego.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean AStarSearch(String sala, boolean consola) {

        boolean ok = true;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new AStarSearch(new TreeSearch()), new OchoPuzzleFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" Busqueda A*");
                log.info("*******************************************\n\n");
                log.info(new OchoPuzzleEstados().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean GreedyBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new GreedyBestFirstSearch(new TreeSearch()), new OchoPuzzleFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" Busqueda Greedy Best-First");
                log.info("*******************************************\n\n");
                log.info(new OchoPuzzleEstados().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean RecursiveBestFirstSearch(String sala, boolean consola) {

        boolean ok = true;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new RecursiveBestFirstSearch(new AStarEvaluationFunction()), new OchoPuzzleFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" Busqueda Mejor Recursiva");
                log.info("*******************************************\n\n");
                log.info(new OchoPuzzleEstados().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean SimulatedAnnealingSearch(String sala, boolean consola) {

        boolean ok = true;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new SimulatedAnnealingSearch(), new OchoPuzzleFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" Simulated Annealing Search");
                log.info("*******************************************\n\n");
                log.info(new OchoPuzzleEstados().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }

    public static boolean HillClimbingSearch(String sala, boolean consola) {

        boolean ok = true;
        OchoPuzzleJuego juego;

        try {
            juego = new OchoPuzzleJuego(new HillClimbingSearch(), new OchoPuzzleFuncionHeuristica());
            if (consola) {
                log.info("\n\n\n*******************************************");
                if (sala != null) {
                    log.info(" " + sala);
                }
                log.info(" JUEGO 8PUZZLE");
                log.info(" Escalada");
                log.info("*******************************************\n\n");
                log.info(new OchoPuzzleEstados().toString());


                juego.ejecutarConsola();
            } else {
                ok = juego.ejecutar();
            }

        } catch (Exception ex) {
            Logger.getLogger(OchoPuzzleDemo.class.getName()).log(Level.ERROR, null, ex);
        }
        return ok;
    }
}


