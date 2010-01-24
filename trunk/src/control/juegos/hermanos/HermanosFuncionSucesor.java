/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.hermanos;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que implementa la formacion de los sucesores a partir de un estado
 * del juego.
 * @author Alicia
 */
public class HermanosFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(HermanosFuncionSucesor.class.getName());

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if ((horaActual - HermanosEstado.horaInicial) < 5000) {
            HermanosEstado estadoPadre = (HermanosEstado) arg0;
            ArrayList recorrido = estadoPadre.getRecorrido();

            try {
                for (int i = 1; i <= 6; i++) { //Hermano
                    for (int j = 0; j < 6; j++) { //Posicion
                        HermanosEstado estado = new HermanosEstado(estadoPadre);
                        estado.setRecorrido(recorrido);
                        if (estado.sentar(i, j)) {
                            recorrido = estado.getRecorrido();
                            resultado.add(new Successor(estado.toString(), estado));
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(HermanosFuncionSucesor.class.getName()).log(Level.ERROR, "Error al obtener los sucesores de " + arg0.toString(), ex);
            }
        } else {
            log.info("\nTIEMPO DE ESPERA SUPERADO\n");
        }

        return resultado;
    }
}
