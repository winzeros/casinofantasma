/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.cambio;

import aima.search.framework.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class CambioFuncionSucesor implements SuccessorFunction {

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        CambioEstado estadoPadre = (CambioEstado) arg0;
        ArrayList recorrido = estadoPadre.getRecorrido();

        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    CambioEstado estado = new CambioEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    if (estado.mover(i, j)) {
                        recorrido = estado.getRecorrido();
                        resultado.add(new Successor("                  (" + i + "," + j + ")" + estado.toString(),
                                estado));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CambioFuncionSucesor.class.getName())
                    .log(Level.SEVERE, "Error al obtener los sucesores de " + arg0.toString(), ex);
        }

        return resultado;
    }

}
