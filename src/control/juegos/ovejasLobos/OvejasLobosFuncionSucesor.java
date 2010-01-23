/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import aima.search.framework.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class OvejasLobosFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(OvejasLobosFuncionSucesor.class.getName());

    public List getSuccessors(Object arg0) {

        ArrayList resultado = new ArrayList();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if ((horaActual - OvejasLobosEstado.horaInicial) < 5000) {
            OvejasLobosEstado estadoPadre = (OvejasLobosEstado) arg0;
            ArrayList recorrido = estadoPadre.getRecorrido();

            try {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        OvejasLobosEstado estado = new OvejasLobosEstado(estadoPadre);
                        estado.setRecorrido(recorrido);
                        if (estado.mover(i, j)) {
                            recorrido = estado.getRecorrido();
                            resultado.add(new Successor("          (" + i + "," + j + ")" + estado.toString(),
                                    estado));
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(OvejasLobosFuncionSucesor.class.getName()).log(Level.ERROR, "Error al obtener los sucesores de " + arg0.toString(), ex);
            }
        } else {
            log.info("\nTIEMPO DE ESPERA SUPERADO\n");
        }

        return resultado;
    }
}
