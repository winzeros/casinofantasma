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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alicia
 */
public class LaberintoFuncionSucesor implements SuccessorFunction {

	private Map map = null;

	public LaberintoFuncionSucesor(Map aMap) {
		this.map = aMap;
	}

	public List getSuccessors(Object currentState) {
		List<Successor> successors = new ArrayList<Successor>();

		String location = currentState.toString();
		if (currentState instanceof Percept) {
			location = (String) ((Percept) currentState)
					.getAttribute(DynAttributeNames.PERCEPT_IN);
		}

		List<String> linkedLocations = map.getLocationsLinkedTo(location);
		for (String linkLoc : linkedLocations) {
			successors.add(new Successor(linkLoc, linkLoc));
		}

		return successors;
	}
}
