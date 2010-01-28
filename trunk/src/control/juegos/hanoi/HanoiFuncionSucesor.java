/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.hanoi;

import aima.search.framework.*;
import control.juegos.hermanos.HermanosEstado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que implementa la formacion de los sucesores a partir de un estado
 * del juego.
 * @author Laura
 */

public class HanoiFuncionSucesor  implements SuccessorFunction {

    /**
     * Log del juego
     */
    public final static Logger log = Logger.getLogger(HanoiFuncionSucesor.class.getName());

    /**
     * Metodo que devuelve una lista de los sucesores de un nodo.
     * @param arg0
     * @return resultado
     */
    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if (!HanoiEstado.timeout) {
        if ((horaActual - HanoiEstado.horaInicial) < 5000) {
        HanoiEstado estadoPadre = (HanoiEstado) arg0;
        ArrayList recorrido = estadoPadre.getRecorrido();

        try {
            for (int i = 1; i <4; i++) { 
                for (int j = 0; j < 3; j++) {
                    HanoiEstado estado = new HanoiEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    if (estado.mover(i, j)) {
                        recorrido = estado.getRecorrido();
                        resultado.add(new Successor("disco = "+i+"; palo = "+j + "\n" +
                                estado.toString(), estado));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HanoiFuncionSucesor.class.getName())
                    .log(Level.ERROR, "Error al obtener los sucesores de " + arg0.toString(), ex);
        }
        }
        }else {
            log.info("\nTIEMPO DE ESPERA SUPERADO\n");
            HanoiEstado.timeout = true;
        }

        return resultado;
    }
}
