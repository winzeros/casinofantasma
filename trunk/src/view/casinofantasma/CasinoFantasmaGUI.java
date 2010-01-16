/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.casinofantasma;

import aima.gui.applications.search.map.MapAgentModel;
import aima.gui.framework.AgentAppController;
import aima.gui.framework.AgentAppFrame;
import aima.gui.framework.AgentAppModel;
import view.casinofantasma.RoutePlanningAgent.RoutePlanningAgentController;
import view.casinofantasma.RoutePlanningAgent.RoutePlanningAgentFrame;

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
    // starter method
    /** Application starter. */
    public static void main(String args[]) {
        new CasinoFantasmaGUI().startApplication();
    }
}
