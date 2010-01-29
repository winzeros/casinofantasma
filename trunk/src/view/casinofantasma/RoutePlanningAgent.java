/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.casinofantasma;

import aima.gui.applications.search.map.AbstractMapAgentController;
import aima.gui.applications.search.map.MapAgentFrame;
import aima.gui.applications.search.map.MapAgentModel;
import aima.search.framework.SearchFactory;
import aima.search.map.AdaptableHeuristicFunction;
import aima.search.map.ExtendableMap;
import aima.search.map.MapAgent;
import aima.search.map.MapEnvironment;
import aima.search.map.Point2D;
import aima.search.map.Scenario;
import java.util.ArrayList;
import control.laberintos.LaberintoEnvironment;
import control.laberintos.LaberintoSalas;

/**
 *
 * @author Alicia
 */
public class RoutePlanningAgent {

    // //////////////////////////////////////////////////////////
    // local classes
    /** Frame for a graphical route planning agent application. */
    protected static class RoutePlanningAgentFrame extends MapAgentFrame {

        private static String[] laberintos = LaberintoSalas.getLaberintos();
        private static String[] destinos = new String[]{};

        /** Creates a new frame. */
        public RoutePlanningAgentFrame() {
            setTitle("CASINO FANTASMA - the Route Planning Agent");
            setSelectorItems(SCENARIO_SEL, laberintos, 0);
            setSelectorItems(SEARCH_MODE_SEL, SearchFactory.getInstance().getSearchModeNames(), 1); // change the default!
            setSelectorItems(HEURISTIC_SEL, new String[]{"Mejor recompensa-apuesta"}, 0);
            setSelectorItems(DESTINATION_SEL, destinos, 0);
            setAgentView(new LaberintoAgentView());
        }

        /**
         * Changes the destination selector items depending on the scenario
         * selection if necessary, and calls the super class implementation
         * afterwards.
         */
        @Override
        protected void selectionChanged() {
            super.selectionChanged();
        }
    }

    /** Controller for a graphical route planning agent application. */
    protected static class RoutePlanningAgentController extends AbstractMapAgentController {

        private LaberintoEnvironment env;

        /**
         * Configures a scenario and a list of destinations. Note that for route
         * planning problems, the size of the list needs to be 1.
         */
        @Override
        protected void selectScenarioAndDest(int scenarioIdx, int destIdx) {
            ExtendableMap map = new ExtendableMap();
            env = new LaberintoEnvironment(map);
            String agentLoc = null;
            LaberintoSalas.initMap(map, scenarioIdx + 1);
            agentLoc = LaberintoSalas.SALA0;
            scenario = new Scenario(env, map, agentLoc);

            destinations = new ArrayList<String>();
            destinations.add("SALA18");
            destinations.add("SALA19");
            destinations.add("SALA20");
            // destinations.add(RoutePlanningAgentFrame.destinos[destIdx]);

            // }
            //destinations = new ArrayList<String>();
            // destinations.add(RoutePlanningAgentFrame.destinos[destIdx]);

        }

        /**
         * Prepares the model for the previously specified scenario and
         * destinations.
         */
        @Override
        protected void prepareModel() {
            ((MapAgentModel) model).prepare(scenario, destinations);
        }

        @Override
        public void prepareAgent() {
            MapAgentFrame.SelectionState state = frame.getSelection();
            selectScenarioAndDest(state.getValue(MapAgentFrame.SCENARIO_SEL), state.getValue(MapAgentFrame.DESTINATION_SEL));
            prepareModel();
            search = SearchFactory.getInstance().createSearch(
                    state.getValue(MapAgentFrame.SEARCH_SEL),
                    state.getValue(MapAgentFrame.SEARCH_MODE_SEL));
            heuristic = createHeuristic(state.getValue(MapAgentFrame.HEURISTIC_SEL));
            scenario.getEnv().registerView(model);
            env.setSearch(search);
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
            /*if (destinations.size() != 1) {
            frame.logMessage("Error: This agent requires exact one destination.");
            return;
            }*/
            frame.logMessage("<route-planning-simulation-protocol>");
            frame.logMessage("search: " + search.getClass().getName());
            MapEnvironment env = scenario.getEnv();
            String[] goal = new String[destinations.size()];
            for (int i = 0; i < destinations.size(); i++) {
                goal[i] = destinations.get(i);
            }
            MapAgent agent = new MapAgent(env, search, goal);
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
            double result = 999999.9;
            double aux = 0.0;
            Point2D pt1;
            Point2D pt2;
            
            pt1 = map.getPosition((String) state);
            pt2 = map.getPosition("SALA18");
            aux = pt1.distance(pt2);
            if (aux < result) {
                result = aux;
            }
            pt1 = map.getPosition((String) state);
            pt2 = map.getPosition("SALA19");
            aux = pt1.distance(pt2);
            if (aux < result) {
                result = aux;
            }
            pt1 = map.getPosition((String) state);
            pt2 = map.getPosition("SALA20");
            aux = pt1.distance(pt2);
            if (aux < result) {
                result = aux;
            }
            return result;
        }
    }
}
