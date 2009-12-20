/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.solitario;

import aima.search.framework.HeuristicFunction;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class SolitarioHeuristicaEsquinas  implements HeuristicFunction {

    public double getHeuristicValue(Object state) {

        SolitarioEstado estado = (SolitarioEstado) state;
        double heuristica = 0;

        try{
            for (int i = 0; i < 6; i++) {
                for (int j = 2; j < 6; j++){
                    if (estado.getTablero()[i][j].equals(SolitarioEstado.FICHA)) {
                        if ((i == 0) || (j == 0) || (i == 6) || (j == 6)) {
                            heuristica = heuristica + 1;
                        } else if ((i == 1) || (j == 1) || (i == 5) || (j == 5)) {
                            heuristica = heuristica + 2;
                        } else if ((i == 2) || (j == 2) || (i == 4) || (j == 4)) {
                            heuristica = heuristica + 3;
                        } else if ((i == 3) || (j == 3)) {
                            heuristica = heuristica + 4;
                        }
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SolitarioHeuristicaEsquinas.class.getName()).log(Level.ERROR, "Error en la heuristica", ex);
        }

        return heuristica;

    }
}
