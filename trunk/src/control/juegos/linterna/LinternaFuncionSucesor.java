/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

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
public class LinternaFuncionSucesor implements SuccessorFunction {

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        LinternaEstado estadoPadre = (LinternaEstado) arg0;
        ArrayList recorrido = estadoPadre.getRecorrido();

        try {
            for (int i = 1; i < 15; i++) { //Pensar bien el limite
                LinternaEstado estado = new LinternaEstado(estadoPadre);
                estado.setRecorrido(recorrido);
                if (estado.pasar(i)) {
                    recorrido = estado.getRecorrido();
                    resultado.add(new Successor("                  (" + i + "," + ")\n" + estado.toString(),
                                estado));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(LinternaFuncionSucesor.class.getName())
                    .log(Level.ERROR, "Error al obtener los sucesores de " + arg0.toString(), ex);
        }

        return resultado;
    }
}
