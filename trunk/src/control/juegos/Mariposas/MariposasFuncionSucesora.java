package control.juegos.mariposas;

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
public class MariposasFuncionSucesora implements SuccessorFunction {

    /**
     * Log del juego.
     */
    public final static Logger log = Logger.getLogger(MariposasFuncionSucesora.class.getName());
    /**
     * Coordenada X del tablero.
     */
    final int coordenadaX = 2;
    /**
     * Coordenada Y del tablero.
     */
    final int coordenadaY = 5;

    /**
     * Genera el siguiente estado, comprobando antes que sea posible
     * @param actual MariposasEstado actual
     * @param posible Posible siguiente momento
     * @return Nuevo estado
     */
    public MariposasEstado crearSiguienteEstado(MariposasEstado actual, Tablero posible) {
        MariposasEstado siguiente = null;
        if (actual.movimientoPosible(posible)) {
            siguiente = new MariposasEstado(actual, posible);
        }
        return siguiente;
    }

    /**
     * Metodo que devuelve una lista con los sucesores de un nodo.
     * @param state
     * @return siguientes
     */
    public List getSuccessors(Object state) {

        List<Successor> siguientes = new ArrayList<Successor>();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if (!MariposasEstado.timeout) {
            if (((horaActual - MariposasEstado.horaInicial) < 1000)) {
                MariposasEstado estado = (MariposasEstado) state;
                MariposasEstado posible = null;

                for (int i = 0; i < coordenadaX; i++) {
                    for (int j = 0; j < coordenadaY; j++) {
                        posible = crearSiguienteEstado(estado,
                                new Tablero(estado.getInstante(), i, j));
                        if (posible != null) {
                            siguientes.add(new Successor("Cambio en [ " + i + " , " +
                                    j + " ] : " + posible.getInstante().getValor(i, j).toString() +
                                    " \n " + "\n" + "***********************************\n" +
                                    posible.getInstante().imprimirTablero(posible.getInstante()) +
                                    "***********************************\n", posible));
                        }
                        posible = null;
                    }
                }
            } else {
               // log.info("\nTIEMPO DE ESPERA SUPERADO\n");
                MariposasEstado.timeout = true;
            }
        }
        return siguientes;
    }
}


