package control.juegos.Garrafas;

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
 * @author jcarlos
 */
public class GarrafasFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(GarrafasFuncionSucesor.class.getName());

    /**
     * Genera el siguiente estado, comprobando antes que sea valido y posible
     * @param actual Estado actual
     * @param g3 Posible siguiente valor de la garrafa 3
     * @param g4 Posible siguiente valor de la garrafa 4
     * @return Posible siguiente estado
     */
    public GarrafasEstado crearSiguienteEstado(GarrafasEstado actual, int g3, int g4) {
        GarrafasEstado next = null;
        if (actual.cambioAunNoRealizado(g3, g4)) {
            next = new GarrafasEstado(g3, g4, actual.getContenido());
        }
        return next;
    }

    /**
     * Metodo que almacena en una lista todos los sucesores de un nodo
     * @param arg0
     * @return siguientes
     */
    public List getSuccessors(Object state) {

        List<Successor> siguientes = new ArrayList<Successor>();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if (!GarrafasEstado.timeout) {
            if ((horaActual - GarrafasEstado.horaInicial) < 2000) {
                GarrafasEstado estado = (GarrafasEstado) state;
                GarrafasEstado generado = null;
                int aux3, aux4;
                /**
                 * Llenar la garrafa de 3 litros de capacidad
                 */
                if (estado.getGarrafa3() < 3) {
                    generado = crearSiguienteEstado(estado, 3, estado.getGarrafa4());
                }
                if (generado != null) {
                    siguientes.add(new Successor("Llenar Garrafa3 \n\n" + estado.toString(3, estado.getGarrafa4()), generado));
                }
                generado = null;
                /**
                 * LLenar la garrafa de 4 litros de capacidad
                 */
                if (estado.getGarrafa4() < 4) {
                    generado = crearSiguienteEstado(estado, estado.getGarrafa3(), 4);
                }
                if (generado != null) {
                    siguientes.add(new Successor("Llenar Garrafa4 \n\n" + estado.toString(estado.getGarrafa3(), 4), generado));
                }
                generado = null;
                /**
                 * Verter el contenido de la garrafa de 3 litros de capacidad en la garrafa de 4
                 */
                if ((0 < estado.getGarrafa3()) && (estado.getGarrafa4() < 4)) {
                    aux3 = 0;
                    aux4 = 0;
                    aux4 = estado.getGarrafa4() + estado.getGarrafa3();
                    if (aux4 > 4) {
                        aux4 = 4;
                    }
                    aux3 = estado.getGarrafa3() - (4 - estado.getGarrafa4());
                    if (aux3 < 0) {
                        aux3 = 0;
                    }
                    generado = crearSiguienteEstado(estado, aux3, aux4);
                    if (generado != null) {
                        siguientes.add(new Successor("Verter la garrafa3 en la garrafa4 \n\n" + estado.toString(aux3, aux4), generado));
                    }
                }
                generado = null;
                /**
                 * Verter el contenido de la garrafa de 4 litros de capacidad en la garrafa de 3
                 */
                if ((0 < estado.getGarrafa4()) && (estado.getGarrafa3() < 3)) {
                    aux3 = estado.getGarrafa3() + estado.getGarrafa4();
                    if (aux3 > 3) {
                        aux3 = 3;
                    }
                    aux4 = estado.getGarrafa4() - (3 - estado.getGarrafa3());
                    if (aux4 < 0) {
                        aux4 = 0;
                    }
                    generado = crearSiguienteEstado(estado, aux3, aux4);
                    if (generado != null) {
                        siguientes.add(new Successor("Verter la garrafa4 en la garrafa3 \n\n" + estado.toString(aux3, aux4), generado));
                    }
                }
                generado = null;
                /**
                 * Vaciar la garrafa de 3 litros de capacidad
                 */
                if (0 < estado.getGarrafa3()) {
                    generado = crearSiguienteEstado(estado, 0, estado.getGarrafa4());
                }
                if (generado != null) {
                    siguientes.add(new Successor("Vaciar Garrafa3 \n\n" + estado.toString(0, estado.getGarrafa4()), generado));
                }
                generado = null;
                /**
                 * Vaciar la garrafa de 4 litros de capacidad
                 */
                if (0 < estado.getGarrafa4()) {
                    generado = crearSiguienteEstado(estado, estado.getGarrafa3(), 0);
                }
                if (generado != null) {
                    siguientes.add(new Successor("Vaciar Garrafa4 \n\n" + estado.toString(estado.getGarrafa3(), 0), generado));
                }
                generado = null;
            } else {
                log.info("\nTIEMPO DE ESPERA SUPERADO\n");
                GarrafasEstado.timeout = true;
            }
        }
        return siguientes;
    }
}
