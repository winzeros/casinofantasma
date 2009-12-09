/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.coloreadoMapas;

import aima.search.csp.CSP;
import aima.search.csp.MapCSP;
import javax.swing.JTextArea;

/**
 *
 * @author usuario_local
 */
public class ColoreadoMapasJuego {

    public void ejecutarApp(JTextArea area){
		CSP csp = MapCSP.getMap();
		area.append("Map Coloring - Backtracking \n");
		area.append(csp.backTrackingSearch().toString() + "\n");
		area.append("Map Coloring - Minimum Conflicts \n");
		area.append(csp.mcSearch(100).toString() + "\n");
    }

}
