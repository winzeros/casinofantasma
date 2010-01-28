/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.laberintos;

import aima.basic.Agent;
import aima.search.framework.Search;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.map.DynAttributeNames;
import aima.search.map.ExtendableMap;
import aima.search.map.MapEnvironment;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;
import control.juegos.ochoPuzzle.OchoPuzzleDemo;
import control.juegos.Garrafas.GarrafasDemo;
import control.juegos.hanoi.HanoiDemo;
import control.juegos.mariposas.MariposasDemo;
import control.juegos.hermanos.HermanosDemo;
import control.juegos.linterna.LinternaDemo;
import control.juegos.monoBanana.MonoBananaDemo;
import control.juegos.nreinas.NReinasDemo;
import control.juegos.ovejasLobos.OvejasLobosDemo;
import control.juegos.ranas.RanasDemo;
import control.juegos.rejillaRojoAzul.RejillaRojoAzulDemo;
import control.juegos.solitario.SolitarioDemo;
import control.laberintos.juego.LaberintoJuego;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class LaberintoEnvironment extends MapEnvironment {

    public final static Logger log = Logger.getLogger(HermanosDemo.class.getName());
    public static List<String> historico;
    private LaberintoManager manager;
    private int saldo;
    private Agent agent;
    private Search search;

    public LaberintoEnvironment(ExtendableMap map) {
        super(map);
        manager = new LaberintoManager();
        updateViews("");
        historico = new ArrayList();
    }

    public void setSearch(Search selectSearch) {
        search = selectSearch;
    }

    @Override
    public void executeAction(Agent a, String act) {
        agent = a;
        String currLoc = (String) a.getAttribute(DynAttributeNames.AGENT_LOCATION);
        int distance = LaberintoSalas.lectorXML.getDistancia(currLoc, act);
        int juego = LaberintoSalas.lectorXML.getJuego(act);
        int estrategia = LaberintoSalas.lectorXML.getEstrategia(act);
        if (distance != 0) {
            saldo = manager.apuesta(distance);
            int recompensa = LaberintoSalas.lectorXML.getRecompensa(act);
            ejecutarJuego(juego, estrategia, act);
            saldo = manager.recompensa(recompensa);
            log.info("\n---------------APUESTA: " + (int) Math.floor(distance) + "--------------------");
            log.info("------------RECOMPENSA: " + (int) recompensa + "--------------------");
            if ((recompensa - distance) > 0) {
                log.info("---------------GANAS " + (int) Math.abs(Math.floor(recompensa - distance)) + "-----------------");
            } else {
                log.info("-------------PIERDES " + (int) Math.abs(Math.floor(recompensa - distance)) + "-----------------");
            }
            double currTD = (Double) a.getAttribute(DynAttributeNames.AGENT_TRAVEL_DISTANCE);
            a.setAttribute(DynAttributeNames.AGENT_TRAVEL_DISTANCE, currTD
                    + distance);
            a.setAttribute(DynAttributeNames.AGENT_LOCATION, act);
        }
    }

    @Override
    public void stepUntilDone() {

        LaberintoJuego juegoLab = null;
        List acciones = new ArrayList();

        try {
            if (search instanceof DepthFirstSearch) {
                juegoLab = new LaberintoJuego(new DepthFirstSearch(new TreeSearch()), this.getMap());
            } else if (search instanceof BreadthFirstSearch) {
                juegoLab = new LaberintoJuego(new BreadthFirstSearch(new TreeSearch()), this.getMap());
            } else if (search instanceof IterativeDeepeningSearch) {
                juegoLab = new LaberintoJuego(new IterativeDeepeningSearch(), this.getMap());
            } else if (search instanceof UniformCostSearch) {
                juegoLab = new LaberintoJuego(new UniformCostSearch(new TreeSearch()), this.getMap());
            } else if (search instanceof GreedyBestFirstSearch) {
                juegoLab = new LaberintoJuego(new GreedyBestFirstSearch(new TreeSearch()), this.getMap());
            } else if (search instanceof AStarSearch) {
                juegoLab = new LaberintoJuego(new AStarSearch(new TreeSearch()), this.getMap());
                     //   new H2());
           /* } else if (search instanceof RecursiveBestFirstSearch) {
                juegoLab = new LaberintoJuego(new RecursiveBestFirstSearch(new TreeSearch()),
                        this.getMap());*/
            } else if (search instanceof HillClimbingSearch) {
                juegoLab = new LaberintoJuego(new HillClimbingSearch(), this.getMap());
            }

            if (juegoLab != null) {
                acciones = juegoLab.ejecutar();
            }

            historico.add("SALA0");

            if (acciones.size() > 0) {
                step("SALA0", (String) acciones.get(0));
                historico.add(acciones.get(0).toString());
                updateViews((String) acciones.get(0));
            }

            for (int i = 1; i < acciones.size() - 1; i++) {
                step((String) acciones.get(i), (String) acciones.get(i + 1));
                historico.add(acciones.get(i + 1).toString());
                updateViews((String) acciones.get(i + 1));
            }

            /*while (!(this.isDone())) {
            step();
            }*/
            if (acciones.size() == 0) {
                JOptionPane.showMessageDialog(null, "¡¡ Has quedado atrapado en el casino !!");
            } else {
                if (saldo > 0) {
                    JOptionPane.showMessageDialog(null, "¡¡ Has rejuvenecido " + (int) Math.abs(Math.floor(saldo)) + " días !!");
                } else if (saldo < 0) {
                    JOptionPane.showMessageDialog(null, "¡¡ Has envejecido " + (int) Math.abs(Math.floor(saldo)) + " días !!");
                } else {
                    JOptionPane.showMessageDialog(null, "Sales con la misma edad que entraste");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void step(String origen, String destino) {
        int distance = LaberintoSalas.lectorXML.getDistancia(origen, destino);
        int juego = LaberintoSalas.lectorXML.getJuego(destino);
        int estrategia = LaberintoSalas.lectorXML.getEstrategia(destino);
        if (distance != 0) {
            saldo = manager.apuesta(distance);
            int recompensa = LaberintoSalas.lectorXML.getRecompensa(destino);
            ejecutarJuego(juego, estrategia, destino);
            saldo = manager.recompensa(recompensa);
            log.info("\n---------------APUESTA: " + (int) Math.floor(distance) + "--------------------");
            log.info("------------RECOMPENSA: " + (int) recompensa + "--------------------");
            if ((recompensa - distance) > 0) {
                log.info("---------------GANAS " + (int) Math.abs(Math.floor(recompensa - distance)) + "-----------------");
            } else {
                log.info("-------------PIERDES " + (int) Math.abs(Math.floor(recompensa - distance)) + "-----------------");
            }
        }
    }

    public static boolean ejecutarJuego(int juego, int estrategia, String sala) {

        boolean ok = true;

        switch (juego) {
            //Juego de las ovejas y lobos
            case 0:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = OvejasLobosDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = OvejasLobosDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = OvejasLobosDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = OvejasLobosDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = OvejasLobosDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de las garrafas
            case 1:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = GarrafasDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = GarrafasDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = GarrafasDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = GarrafasDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = GarrafasDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de los Hermanos a la greña
            case 2:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = HermanosDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = HermanosDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = HermanosDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = HermanosDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = HermanosDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de las NReinas
            case 3:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = NReinasDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = NReinasDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = NReinasDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = NReinasDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = NReinasDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de las Ranas
            case 4:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = RanasDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = RanasDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = RanasDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = RanasDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = RanasDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de la linterna
            case 5:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = LinternaDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = LinternaDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = LinternaDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = LinternaDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = LinternaDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de el mono y la banana
            case 6:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = MonoBananaDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = MonoBananaDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = MonoBananaDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = MonoBananaDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = MonoBananaDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;

            //Juego de la rejilla
            case 7:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = RejillaRojoAzulDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = RejillaRojoAzulDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = RejillaRojoAzulDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = RejillaRojoAzulDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = RejillaRojoAzulDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego del 8 puzzle
            case 8:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = OchoPuzzleDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = OchoPuzzleDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = OchoPuzzleDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = OchoPuzzleDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = OchoPuzzleDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de las mariposas
            case 9:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = MariposasDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = MariposasDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = MariposasDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = MariposasDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = MariposasDemo.RejillaRojoAzulGreedyBestFirstSearch(sala);
                        break;
                }
                break;
            //Juego de las torres de Hanoi
            case 10:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = HanoiDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = HanoiDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = HanoiDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = HanoiDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = HanoiDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego del solitario
            case 11:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = SolitarioDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = SolitarioDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = SolitarioDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = SolitarioDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = SolitarioDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
        }
        return ok;
    }
}
