/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
            for (int i = 0; i < 7; i++) {
                RanasEstado estado = new RanasEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    if (estado.mover(i)) {
                        recorrido = estado.getRecorrido();
                        resultado.add(new Successor("Salta la " + (i + 1) + "\n" +
                                estado.toString(), estado));
                    }
            }
        } catch (Exception ex) {
            Logger.getLogger(RanasFuncionSucesor.class.getName())
                    .log(Level.ERROR, "Error al obtener los sucesores de "
                    + arg0.toString(), ex);
        }

        return resultado;
    }

}
