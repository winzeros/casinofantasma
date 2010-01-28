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
import control.laberintos.LaberintoEnvironment;
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

    public LaberintoFuncionSucesor(Map aMap) {
        this.map = aMap;
    }

    public List getSuccessors(Object currentState) {

        List<Successor> successors = new ArrayList<Successor>();

        LaberintoEstado estadoPadre = (LaberintoEstado) currentState;

        String location = currentState.toString();
        if (currentState instanceof Percept) {
            location = (String) ((Percept) currentState).getAttribute(DynAttributeNames.PERCEPT_IN);
        }

        List<String> linkedLocations = map.getLocationsLinkedTo(location);
        for (String linkLoc : linkedLocations) {
            LaberintoEstado estado = new LaberintoEstado(estadoPadre);

            if (estado.puedoMover(linkLoc)) {

                int juego = LaberintoSalas.lectorXML.getJuego(linkLoc);
                int estrategia = LaberintoSalas.lectorXML.getEstrategia(linkLoc);

                if (LaberintoEnvironment.ejecutarJuego(juego, estrategia, linkLoc)) {
                    successors.add(new Successor(linkLoc, estado));
                }
            }
        }

        return successors;
    }
}
