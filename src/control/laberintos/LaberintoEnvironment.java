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
import aima.search.informed.SimulatedAnnealingSearch;
import aima.search.map.DynAttributeNames;
import aima.search.map.ExtendableMap;
import aima.search.map.MapEnvironment;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;
import control.juegos.hermanos.HermanosDemo;
import control.laberintos.juego.LaberintoHeuristicaMasDias;
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
            LaberintoEjecucion.ejecutarJuego(juego, estrategia, act, true);
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
                juegoLab = new LaberintoJuego(
                        new DepthFirstSearch(new TreeSearch()), this.getMap());
            } else if (search instanceof BreadthFirstSearch) {
                juegoLab = new LaberintoJuego(new BreadthFirstSearch(new TreeSearch()),
                        this.getMap());
            } else if (search instanceof IterativeDeepeningSearch) {
                juegoLab = new LaberintoJuego(new IterativeDeepeningSearch(), 
                        this.getMap());
            } else if (search instanceof UniformCostSearch) {
                juegoLab = new LaberintoJuego(new UniformCostSearch(new TreeSearch()),
                        this.getMap());
            } else if (search instanceof GreedyBestFirstSearch) {
                juegoLab = new LaberintoJuego(new GreedyBestFirstSearch(new TreeSearch()),
                        this.getMap(),
                        new LaberintoHeuristicaMasDias());
            } else if (search instanceof AStarSearch) {
                juegoLab = new LaberintoJuego(new AStarSearch(new TreeSearch()), 
                        this.getMap(),
                        new LaberintoHeuristicaMasDias());
            } else if (search instanceof SimulatedAnnealingSearch) {
                juegoLab = new LaberintoJuego(new SimulatedAnnealingSearch(),
                        this.getMap(),
                        new LaberintoHeuristicaMasDias());
            } else if (search instanceof HillClimbingSearch) {
                juegoLab = new LaberintoJuego(new HillClimbingSearch(), this.getMap(),
                        new LaberintoHeuristicaMasDias());
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
            LaberintoEjecucion.ejecutarJuego(juego, estrategia, destino, true);
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


}
