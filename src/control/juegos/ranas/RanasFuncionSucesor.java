/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class RanasFuncionSucesor implements SuccessorFunction{

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        RanasEstado estadoPadre = (RanasEstado) arg0;
        ArrayList recorrido = estadoPadre.getRecorrido();

        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    RanasEstado estado = new RanasEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    if (estado.mover(i, j)) {
                        recorrido = estado.getRecorrido();
                        resultado.add(new Successor("                  (" + i + "," + j + ")" + estado.toString(),
                                estado));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RanasFuncionSucesor.class.getName())
                    .log(Level.SEVERE, "Error al obtener los sucesores de " + arg0.toString(), ex);
        }

        return resultado;
    }

}
