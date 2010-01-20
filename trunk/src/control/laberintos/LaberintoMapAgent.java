/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.laberintos;

import aima.basic.Percept;
import aima.search.framework.HeuristicFunction;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SimpleProblemSolvingAgent;
import aima.search.map.DynAttributeNames;
import aima.search.map.MapEnvironment;
import control.laberintos.juego.LaberintoEstado;
import control.laberintos.juego.LaberintoEstadoObjetivo;
import control.laberintos.juego.LaberintoFuncionSucesor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Alicia
 */
public class LaberintoMapAgent extends SimpleProblemSolvingAgent {
	private MapEnvironment mapEnvironment = null;

	private Search search = null;

	private String currentLocation = null;

	private String[] goalTests = null;

	private int goalTestPos = 0;

	private HeuristicFunction heuristicFunction = null;

	public LaberintoMapAgent(MapEnvironment mapEnvironment, Search search) {
		this.mapEnvironment = mapEnvironment;
		this.search = search;
	}

	public LaberintoMapAgent(MapEnvironment mapEnvironment, Search search,
			int maxGoalsToFormulate) {
		super(maxGoalsToFormulate);
		this.mapEnvironment = mapEnvironment;
		this.search = search;
	}

	public LaberintoMapAgent(MapEnvironment mapEnvironment, Search search,
			String[] goalTests) {
		super(goalTests.length);
		this.mapEnvironment = mapEnvironment;
		this.search = search;
		this.goalTests = new String[goalTests.length];
		System.arraycopy(goalTests, 0, this.goalTests, 0, goalTests.length);
	}

	public HeuristicFunction getHeuristicFunction() {
		return heuristicFunction;
	}

	public void setHeuristicFunction(HeuristicFunction heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}

	//
	// PROTECTED METHODS
	//
	@Override
	protected Object updateState(Percept p) {
		currentLocation = (String) p.getAttribute(DynAttributeNames.PERCEPT_IN);

		return currentLocation;
	}

	@Override
	protected Object formulateGoal() {
		Object goal = null;
		if (null == goalTests) {
			goal = mapEnvironment.getMap().randomlyGenerateDestination();
		} else {
			goal = goalTests[goalTestPos];
			goalTestPos++;
		}
		mapEnvironment.updateViews("CurrentLocation=In(" + currentLocation
				+ "), Goal=In(" + goal + ")");

		return goal;
	}

	@Override
	protected Problem formulateProblem(Object goal) {
		if (null == getHeuristicFunction()) {
			return new Problem(new LaberintoEstado("SALA0"), new LaberintoFuncionSucesor(mapEnvironment.getMap())
                                , new LaberintoEstadoObjetivo((String[]) goal));
		} else {
                    String[] goalState = new String[] {"SALA17", "SALA18", "SALA19"};
			return new Problem(new LaberintoEstado("SALA0"), new LaberintoFuncionSucesor(mapEnvironment.getMap())
                                , new LaberintoEstadoObjetivo(goalState), getHeuristicFunction());
		}
	}

	@Override
	protected List<String> search(Problem problem) {
		List<String> actions = new ArrayList<String>();
		try {
			List sactions = search.search(problem);
			for (Object action : sactions) {
				actions.add((String) action);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return actions;
	}

	@Override
	protected void notifyViewOfMetrics() {
		Set keys = search.getMetrics().keySet();
		for (Object key : keys) {
			mapEnvironment.updateViews("METRIC[" + key + "]="
					+ search.getMetrics().get((String) key));
		}
	}

}
