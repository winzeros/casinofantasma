/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.nreinas;

import aima.basic.XYLocation;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Clase que implementa la formacion de los sucesores a partir de un estado
 * del juego.
 * @author Alicia
 */
public class NReinasFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(NReinasFuncionSucesor.class.getName());

    public List getSuccessors(Object estado) {

        List<Successor> sucesores = new ArrayList<Successor>();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if (!NReinasEstado.timeout) {
            if ((horaActual - NReinasEstado.horaInicial) < 1000) {
                NReinasEstado tablero = (NReinasEstado) estado;
                int numReinas = tablero.getNumeroReinasColocadas();
                int n = tablero.getN();
                for (int i = 0; i < n; i++) {
                    if (!(tablero.estaAmenazada(new XYLocation(numReinas, i)))) {
                        NReinasEstado hijo = colocarReina(numReinas, i, tablero);
                        sucesores.add(new Successor(hijo.toString(), hijo));

                    }

                }
            } else {
                log.info("\nTIEMPO DE ESPERA SUPERADO\n");
                NReinasEstado.timeout = true;
            }
        }

        return sucesores;
    }

    private NReinasEstado colocarReina(int fila, int columna,
            NReinasEstado padre) {

        NReinasEstado nuevoEstado = new NReinasEstado(padre.getN());
        List<XYLocation> reinasColocadasEnPadre = padre.getPosiciones();
        reinasColocadasEnPadre.add(new XYLocation(fila, columna));
        nuevoEstado.setTablero(reinasColocadasEnPadre);
        return nuevoEstado;
    }
}
