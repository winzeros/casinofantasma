/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.laberintos;

import aima.basic.Agent;
import aima.search.map.DynAttributeNames;
import aima.search.map.Map;
import aima.search.map.MapEnvironment;
import control.juegos.Garrafas.GarrafasDemo;
import control.juegos.hermanos.HermanosDemo;
import control.juegos.nreinas.NReinasDemo;
import control.juegos.ovejasLobos.OvejasLobosDemo;
import control.juegos.ranas.RanasDemo;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class LaberintoEnvironment extends MapEnvironment {

    public final static Logger log = Logger.getLogger(HermanosDemo.class.getName());
    private LaberintoManager manager;
    private int saldo;

    public LaberintoEnvironment(Map aMap) {
        super(aMap);
        manager = new LaberintoManager();
    }

    @Override
    public void executeAction(Agent a, String act) {
        String currLoc = (String) a.getAttribute(DynAttributeNames.AGENT_LOCATION);
        Double distance = super.getMap().getDistance(currLoc, act);
        int juego = LaberintoSalas.lectorXML.getJuego(act);
        int estrategia = LaberintoSalas.lectorXML.getEstrategia(act);
        if (distance != null) {
            saldo = manager.apuesta(distance);
            int recompensa = LaberintoSalas.lectorXML.getRecompensa(act);
            ejecutarJuego(juego, estrategia, act);
            saldo = manager.recompensa(recompensa);
            log.info("\n---------------APUESTA: " + (int) Math.floor(distance) + "--------------------");
            log.info("------------RECOMPENSA: " + (int) recompensa + "--------------------");
            if ((recompensa - distance) > 0) {
                log.info("---------------GANAS " +  (int) Math.abs(Math.floor(recompensa - distance)) + "-----------------");
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
        while (!(this.isDone())) {
            step();
        }
        if (saldo > 0) {
            JOptionPane.showMessageDialog(null, "¡¡ Has rejuvenecido " + (int) Math.abs(Math.floor(saldo)) + " días !!");
        } else if (saldo < 0) {
            JOptionPane.showMessageDialog(null, "¡¡ Has envejecido " + (int) Math.abs(Math.floor(saldo)) + " días !!");
        } else {
            JOptionPane.showMessageDialog(null, "Sales con la misma edad que entraste");
        }
    }

    private void ejecutarJuego(int juego, int estrategia, String sala) {
        switch (juego) {
            //Juego de las ovejas y lobos
            case 0:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        OvejasLobosDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        OvejasLobosDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        OvejasLobosDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        OvejasLobosDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        OvejasLobosDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de las garrafas
            case 1:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        GarrafasDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        GarrafasDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        GarrafasDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        GarrafasDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        GarrafasDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de los Hermanos a la greña
            case 2:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        HermanosDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        HermanosDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        HermanosDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        HermanosDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        HermanosDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de las NReinas
            case 3:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        NReinasDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        NReinasDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        NReinasDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        NReinasDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        NReinasDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
            //Juego de las Ranas
            case 4:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        RanasDemo.BreadthFirstDemo(sala);
                        break;
                    //Primero en profundidad
                    case 1:
                        RanasDemo.DepthFirstSearchDemo(sala);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        RanasDemo.DepthLimitedSearchDemo(sala);
                        break;
                    //Coste uniforme
                    case 3:
                        RanasDemo.UniformCostSearchDemo(sala);
                        break;
                    //Busqueda iterativa
                    case 4:
                        RanasDemo.IterativeDeepeningSearchDemo(sala);
                        break;
                }
                break;
        }
    }
}
