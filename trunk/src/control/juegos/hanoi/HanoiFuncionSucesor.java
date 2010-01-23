/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */

public class HanoiFuncionSucesor  implements SuccessorFunction {

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        HanoiEstado estadoPadre = (HanoiEstado) arg0;
        ArrayList recorrido = estadoPadre.getRecorrido();

        try {
            for (int i = 1; i <4; i++) { 
                for (int j = 0; j < 3; j++) {
                    HanoiEstado estado = new HanoiEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    if (estado.mover(i, j)) {
                        recorrido = estado.getRecorrido();
                        resultado.add(new Successor("disco = "+i+"; palo = "+j, estado));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HanoiFuncionSucesor.class.getName())
                    .log(Level.ERROR, "Error al obtener los sucesores de " + arg0.toString(), ex);
        }

        return resultado;
    }
}
