/*
 * Created on Sep 12, 2004
 *
 */
package control.juegos.ochoPuzzle;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.log4j.Logger;

/**
 * Clase que implementa la formacion de los sucesores a partir de un estado
 * del juego.
 * @author jcarlos
 */
public class OchoPuzzleFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(OchoPuzzleFuncionSucesor.class.getName());

    public List getSuccessors(Object state) {

        List<Successor> sucesores = new ArrayList<Successor>();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if (!OchoPuzzleEstados.timeout) {
            if ((horaActual - OchoPuzzleEstados.horaInicial) < 5000) {
                OchoPuzzleEstados tablero = (OchoPuzzleEstados) state;
                if (tablero.puedoMoverHueco(OchoPuzzleEstados.UP)) {
                    OchoPuzzleEstados nuevoTablero = copyOf(tablero);
                    nuevoTablero.moverHuecoArriba();
                    sucesores.add(new Successor(OchoPuzzleEstados.UP + "\n" + nuevoTablero.toString() + "\n\n", nuevoTablero));
                }
                if (tablero.puedoMoverHueco(OchoPuzzleEstados.DOWN)) {
                    OchoPuzzleEstados nuevoTablero = copyOf(tablero);
                    nuevoTablero.moverHuecoAbajo();
                    sucesores.add(new Successor(OchoPuzzleEstados.DOWN + "\n" + nuevoTablero.toString() + "\n\n", nuevoTablero));
                }
                if (tablero.puedoMoverHueco(OchoPuzzleEstados.LEFT)) {
                    OchoPuzzleEstados nuevoTablero = copyOf(tablero);
                    nuevoTablero.moverHuecoIzq();
                    sucesores.add(new Successor(OchoPuzzleEstados.LEFT + "\n" + nuevoTablero.toString() + "\n\n", nuevoTablero));
                }
                if (tablero.puedoMoverHueco(OchoPuzzleEstados.RIGHT)) {
                    OchoPuzzleEstados nuevoTablero = copyOf(tablero);
                    nuevoTablero.MoverHuecoDerch();
                    sucesores.add(new Successor(OchoPuzzleEstados.RIGHT + "\n" + nuevoTablero.toString() + "\n\n", nuevoTablero));
                }
            } else {
                log.info("\nTIEMPO DE ESPERA SUPERADO\n");
                OchoPuzzleEstados.timeout = true;
            }
        }
        return sucesores;
    }

    private OchoPuzzleEstados copyOf(OchoPuzzleEstados tablero) {
        OchoPuzzleEstados nuevoTablero = new OchoPuzzleEstados();
        nuevoTablero.setTablero(tablero.getPositions());
        return nuevoTablero;
    }
}
