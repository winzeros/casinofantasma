/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view.casinofantasma;

import aima.gui.framework.AgentAppController;
import aima.gui.framework.AgentAppFrame;
import aima.gui.framework.AgentAppModel;
import aima.gui.framework.SimpleAgentAppDemo;
import javax.swing.JFrame;

/**
 *
 * @author Alicia
 */
public class CasinoAppDemo extends SimpleAgentAppDemo{

    @Override
    	public void startApplication() {
		AgentAppModel model = createModel();
		AgentAppFrame frame = createFrame();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		AgentAppController controller = createController();
		frame.setController(controller);
		frame.setModel(model);
		controller.setFrame(frame);
		controller.setModel(model);
		model.addModelChangedListener(frame);
		frame.setVisible(true);
		frame.setDefaultSelection();
	}

}
