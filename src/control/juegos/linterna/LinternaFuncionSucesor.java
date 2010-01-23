/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.linterna;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class LinternaFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(LinternaFuncionSucesor.class.getName());

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if ((horaActual - LinternaEstado.horaInicial) < 5000) {
            LinternaEstado estadoPadre = (LinternaEstado) arg0;
            ArrayList recorrido = estadoPadre.getRecorrido();

            try {
                for (int i = 0; i < 15; i++) {
                    LinternaEstado estado = new LinternaEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    if (estado.pasar(i)) {
                        recorrido = estado.getRecorrido();
                        resultado.add(new Successor("                  (" + i + ")\n" + estado.toString(),
                                estado));
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(LinternaFuncionSucesor.class.getName()).log(Level.ERROR, "Error al obtener los sucesores de " + arg0.toString(), ex);
            }
        } else {
            log.info("\nTIEMPO DE ESPERA SUPERADO\n");
        }

        return resultado;
    }
}
