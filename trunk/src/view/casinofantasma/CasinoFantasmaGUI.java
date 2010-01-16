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
import aima.gui.framework.AgentAppModel;
import aima.search.framework.SearchFactory;
import aima.search.map.AdaptableHeuristicFunction;
import aima.search.map.ExtendableMap;
import aima.search.map.MapAgent;
import aima.search.map.MapEnvironment;
import aima.search.map.Point2D;
import aima.search.map.Scenario;
import java.util.ArrayList;
import model.laberintos.LaberintoEnvironment;
import model.laberintos.LaberintoSalas;

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

        private static String[] laberintos = LaberintoSalas.getLaberintos();
        private static String[] destinos = new String[]{"SALA50", "SALA1", "SALA99"};

        /** Creates a new frame. */
        public RoutePlanningAgentFrame() {
            setTitle("CASINO FANTASMA - the Route Planning Agent");
            setSelectorItems(SCENARIO_SEL, laberintos, 0);
            setSelectorItems(SEARCH_MODE_SEL, SearchFactory.getInstance().getSearchModeNames(), 1); // change the default!
            setSelectorItems(HEURISTIC_SEL, new String[]{"H1 (=0)",
                        "H2 (sld to goal)"}, 1);
            setSelectorItems(DESTINATION_SEL, destinos, 0);
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

     /*   @Override
       public void paint(java.awt.Graphics g) {
            super.paint(g);
            MapAgentModel maModel = (MapAgentModel) model;
            if (maModel != null && !maModel.isEmpty()) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
                adjustTransformation();
                paintMap(g2);
                paintTour(g2);
                for (String loc : maModel.getLocations()) {
                    paintLoc(g2, loc);
                }
            }
        }*/
    }

    /** Controller for a graphical route planning agent application. */
    protected static class RoutePlanningAgentController extends AbstractMapAgentController {

        /**
         * Configures a scenario and a list of destinations. Note that for route
         * planning problems, the size of the list needs to be 1.
         */
        @Override
        protected void selectScenarioAndDest(int scenarioIdx, int destIdx) {
            ExtendableMap map = new ExtendableMap();
            LaberintoEnvironment env = new LaberintoEnvironment(map);
            String agentLoc = null;
            LaberintoSalas.initMap(map, scenarioIdx + 1);
            agentLoc = LaberintoSalas.SALA0;
            scenario = new Scenario(env, map, agentLoc);

            destinations = new ArrayList<String>();
            destinations.add(RoutePlanningAgentFrame.destinos[destIdx]);

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
            MapAgent agent = new MapAgent(env, search, new String[]{goal});
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
            if (pt1 != null && pt2 != null) {
                result = pt1.distance(pt2);
            }
            return result;
        }
    }

    // //////////////////////////////////////////////////////////
    // starter method
    /** Application starter. */
    public static void main(String args[]) {
        new CasinoFantasmaGUI().startApplication();
    }
}
