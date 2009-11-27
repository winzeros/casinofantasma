/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejas_lobos;

import aima.search.framework.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alicia
 */

public class OvejasLobosFuncionSucesor implements SuccessorFunction {

    public List getSuccessors(Object arg0) {
        ArrayList resultado = new ArrayList();
        OvejasLobosEstado estadoPadre = (OvejasLobosEstado) arg0;
        ArrayList recorrido = estadoPadre.getRecorrido();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                OvejasLobosEstado estado = new OvejasLobosEstado(estadoPadre);
                estado.setRecorrido(recorrido);
                if (estado.mover(i, j)) {
                    recorrido = estado.getRecorrido();
                    resultado.add(new Successor("                  (" + i + "," + j + ")" + estado.toString(),
                                    estado));
                }
            }
        }
        return resultado;
    }

}
