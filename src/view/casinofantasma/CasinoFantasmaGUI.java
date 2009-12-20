/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view.casinofantasma;

import aima.gui.applications.search.map.AbstractMapAgentController;
import aima.gui.applications.search.map.MapAgentFrame;
import aima.gui.applications.search.map.MapAgentModel;
import aima.gui.framework.AgentAppController;
import aima.gui.framework.AgentAppFrame;
import aima.gui.framework.AgentAppFrame.SelectionState;
import aima.gui.framework.AgentAppModel;
import aima.gui.framework.SimpleAgentAppDemo;
import aima.search.framework.SearchFactory;
import aima.search.map.AdaptableHeuristicFunction;
import aima.search.map.ExtendableMap;
import aima.search.map.MapAgent;
import aima.search.map.MapEnvironment;
import aima.search.map.Point2D;
import aima.search.map.Scenario;
import java.util.ArrayList;
import model.laberintos.LaberintoSalas1;
import model.laberintos.LaberintoSalas2;

/**
 *
 * @author Alicia
 */
public class CasinoFantasmaGUI extends CasinoAppDemo {

	/** Creates a <code>MapAgentModel</code>. */
	@Override
	public AgentAppModel createModel() {
		return new MapAgentModel();
	}

	/** Creates and configures a <code>RoutePlanningAgentFrame</code>. */
	@Override
	public AgentAppFrame createFrame() {
		return new RoutePlanningAgentFrame();
	}

	/** Creates a <code>RoutePlanningAgentController</code>. */
	@Override
	public AgentAppController createController() {
		return new RoutePlanningAgentController();
	}

	// //////////////////////////////////////////////////////////
	// local classes

	/** Frame for a graphical route planning agent application. */
	protected static class RoutePlanningAgentFrame extends MapAgentFrame {
		public static enum MapType {
			LABERINTO1, LABERINTO2
		};

		private MapType usedMap = null;
		private static String[] LABERINTO1_DESTS = new String[] {"SALIDA1", "SALIDA2", "SALIDA3", "RANDOM"};
		private static String[] LABERINTO2_DESTS = new String[] {"SALIDA1", "SALIDA2", "SALIDA3", "RANDOM"};

		/** Creates a new frame. */
		public RoutePlanningAgentFrame() {
			setTitle("CASINO FANTASMA - the Route Planning Agent");
			setSelectorItems(SCENARIO_SEL, new String[] {
					"ENTRADA1- LABERINTO1", "ENTRADA2 - LABERINTO2" }, 0);
			setSelectorItems(SEARCH_MODE_SEL, SearchFactory.getInstance()
					.getSearchModeNames(), 1); // change the default!
			setSelectorItems(HEURISTIC_SEL, new String[] { "H1 (=0)",
					"H2 (sld to goal)" }, 1);
		}

		/**
		 * Changes the destination selector items depending on the scenario
		 * selection if necessary, and calls the super class implementation
		 * afterwards.
		 */
		@Override
		protected void selectionChanged() {
			SelectionState state = getSelection();
			int scenarioIdx = state.getValue(MapAgentFrame.SCENARIO_SEL);
			RoutePlanningAgentFrame.MapType mtype = (scenarioIdx < 3) ? MapType.LABERINTO1
					: MapType.LABERINTO2;
			if (mtype != usedMap) {
				usedMap = mtype;
				String[] items = null;
				switch (mtype) {
				case LABERINTO1:
					items = LABERINTO1_DESTS;
					break;
				case LABERINTO2:
					items = LABERINTO2_DESTS;
					break;
				}
				setSelectorItems(DESTINATION_SEL, items, 0);
			}
			super.selectionChanged();
		}
	}

	/** Controller for a graphical route planning agent application. */
	protected static class RoutePlanningAgentController extends
			AbstractMapAgentController {
		/**
		 * Configures a scenario and a list of destinations. Note that for route
		 * planning problems, the size of the list needs to be 1.
		 */
		@Override
		protected void selectScenarioAndDest(int scenarioIdx, int destIdx) {
			ExtendableMap map = new ExtendableMap();
			MapEnvironment env = new MapEnvironment(map);
			String agentLoc = null;
			switch (scenarioIdx) {
			case 0:
				LaberintoSalas1.initMap(map);
				agentLoc = LaberintoSalas1.SALA1;
				break;
			}
			scenario = new Scenario(env, map, agentLoc);

			destinations = new ArrayList<String>();
			if (scenarioIdx < 3) {
				switch (destIdx) {
				case 0:
					destinations.add(LaberintoSalas1.SALA98);
					break;
				case 1:
					destinations.add(LaberintoSalas1.SALA99);
					break;
				case 2:
					destinations.add(LaberintoSalas1.SALA100);
					break;
				case 3:
					destinations.add(map.randomlyGenerateDestination());
					break;
				}
			} else {
				switch (destIdx) {
				case 0:
					destinations.add(LaberintoSalas2.SALIDA1);
					break;
				case 1:
					destinations.add(LaberintoSalas2.SALIDA2);
					break;
				case 2:
					destinations.add(LaberintoSalas2.SALIDA3);
					break;
				case 3:
					destinations.add(map.randomlyGenerateDestination());
					break;
				}
			}
		}

		/**
		 * Prepares the model for the previously specified scenario and
		 * destinations.
		 */
		@Override
		protected void prepareModel() {
			((MapAgentModel) model).prepare(scenario, destinations);
		}

		/**
		 * Returns the trivial zero function or a simple heuristic which is
		 * based on straight-line distance computation.
		 */
		@Override
		protected AdaptableHeuristicFunction createHeuristic(int heuIdx) {
			switch (heuIdx) {
			case 0:
				return new H1();
			default:
				return new H2();
			}
		}

		/**
		 * Creates environment and agent, starts the agent and initiates some
		 * text outputs describing the state of the agent.
		 */
		@Override
		protected void startAgent() {
			if (destinations.size() != 1) {
				frame.logMessage("Error: This agent requires exact one destination.");
				return;
			}
			frame.logMessage("<route-planning-simulation-protocol>");
			frame.logMessage("search: " + search.getClass().getName());
			MapEnvironment env = scenario.getEnv();
			String goal = destinations.get(0);
			MapAgent agent = new MapAgent(env, search, new String[] { goal });
			if (heuristic != null) {
				frame.logMessage("heuristic: " + heuristic.getClass().getName());
				agent.setHeuristicFunction(heuristic.getAdaptation(goal, scenario.getAgentMap()));
			}
			env.addAgent(agent, scenario.getInitAgentLocation());
			env.stepUntilDone();
			frame.logMessage("</route-planning-simulation-protocol>\n");
		}
	}

	/**
	 * Returns always the heuristic value 0.
	 */
	static class H1 extends AdaptableHeuristicFunction {

		public double getHeuristicValue(Object state) {
			return 0.0;
		}
	}

	/**
	 * A simple heuristic which interprets <code>state</code> and
	 * {@link #goal} as location names and uses the straight-line distance
	 * between them as heuristic value.
	 */
	static class H2 extends AdaptableHeuristicFunction {

		public double getHeuristicValue(Object state) {
			double result = 0.0;
			Point2D pt1 = map.getPosition((String) state);
			Point2D pt2 = map.getPosition((String) goal);
			if (pt1 != null && pt2 != null)
				result = pt1.distance(pt2);
			return result;
		}
	}

	// //////////////////////////////////////////////////////////
	// starter method

	/** Application starter. */
	public static void main(String args[]) {
            CasinoFantasmaGUI gui = new CasinoFantasmaGUI();
		new CasinoFantasmaGUI().startApplication();
	}
}
