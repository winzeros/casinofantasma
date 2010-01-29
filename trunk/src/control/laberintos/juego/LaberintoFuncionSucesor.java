/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.laberintos.juego;

import aima.basic.Percept;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import aima.search.map.DynAttributeNames;
import aima.search.map.Map;
import control.laberintos.LaberintoEjecucion;
import control.laberintos.LaberintoSalas;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class LaberintoFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(LaberintoFuncionSucesor.class.getName());
    private Map map = null;
    private ArrayList recorrido;

    public LaberintoFuncionSucesor(Map aMap) {
        this.map = aMap;
        recorrido = new ArrayList();
    }

    public List getSuccessors(Object currentState) {

        List<Successor> successors = new ArrayList<Successor>();

        LaberintoEstado estadoPadre = (LaberintoEstado) currentState;
        recorrido.add(currentState.toString());


        String location = currentState.toString();
        if (currentState instanceof Percept) {
            location = (String) ((Percept) currentState).getAttribute(DynAttributeNames.PERCEPT_IN);
        }

        List<String> linkedLocations = map.getLocationsLinkedTo(location);
        for (String linkLoc : linkedLocations) {
            LaberintoEstado estado = new LaberintoEstado(estadoPadre);

            estado.setRecorridos(recorrido);

            if (estado.puedoMover(linkLoc)) {
                recorrido = estado.getRecorridos();

                int juego = LaberintoSalas.lectorXML.getJuego(linkLoc);
                int estrategia = LaberintoSalas.lectorXML.getEstrategia(linkLoc);
                int apuesta = LaberintoSalas.lectorXML.getDistancia(estadoPadre.toString(), linkLoc);
                int recompensa = LaberintoSalas.lectorXML.getRecompensa(linkLoc);

                estado.setApuesta(apuesta);
                estado.setRecompensa(recompensa);

                if (LaberintoEjecucion.ejecutarJuego(juego, estrategia, linkLoc, false)) {
                    successors.add(new Successor(linkLoc, estado));
                }
            }
        }

        return successors;
    }
}
