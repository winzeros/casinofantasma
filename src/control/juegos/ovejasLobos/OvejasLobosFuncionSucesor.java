/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alicia
 */
public class OvejasLobosFuncionSucesor implements SuccessorFunction {

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        OvejasLobosEstado estadoPadre = (OvejasLobosEstado) arg0;
        ArrayList recorrido = estadoPadre.getRecorrido();

        try {
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
        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosFuncionSucesor.class.getName())
                    .log(Level.SEVERE, "Error al obtener los sucesores de " + arg0.toString(), ex);
        }

        return resultado;
    }
}
