/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.rejillaRojoAzul;

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
 * @author JOSECARLOS
 */
public class RejillaRojoAzulFuncionSucesor implements SuccessorFunction {

    public final static Logger log = Logger.getLogger(RejillaRojoAzulFuncionSucesor.class.getName());

    public List<Successor> getSuccessors(Object state) {

        List sucesores = new ArrayList();
        Calendar calendario = new GregorianCalendar();
        long horaActual = calendario.getTimeInMillis();

        if (!RejillaRojoAzulEstado.timeout) {
            if ((horaActual - RejillaRojoAzulEstado.horaInicial) < 5000) {
                RejillaRojoAzulEstado puzzle = (RejillaRojoAzulEstado) state;
                String movimiento = "";
                int coste = 0;
                boolean generado = false;
                puzzle.AumentarNodosExpandidos();
                int x = 0, y = 0;
                String[][] mitablero = new String[3][3];
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        mitablero[i][j] = puzzle.getCasilla(i, j);
                    }
                }

                for (int operadores = 0; operadores <= 8; operadores++) {
                    generado = false;
                    String[][] newtablero = new String[3][3];
                    for (int i = 0; i <= 2; i++) {
                        for (int j = 0; j <= 2; j++) {
                            newtablero[i][j] = mitablero[i][j];
                        }
                    }

                    switch (operadores) {
                        case 0://Cambiar la primera casilla 00
                            x = 0;
                            y = 0;
                            movimiento = "Cambiar la primera casilla [0,0]";
                            generado = true;
                            coste = 1;
                            break;

                        case 1://Cambiar la segunda casilla 0,1
                            x = 0;
                            y = 1;
                            movimiento = "Cambiar la segunda casilla [0,1]";
                            generado = true;
                            coste = 1;
                            break;

                        case 2://Cambiar la tercera casilla 0,2
                            x = 0;
                            y = 2;
                            movimiento = "Cambiar la tercera casilla [0,2]";
                            generado = true;
                            coste = 1;
                            break;

                        case 3://Cambiar la cuarta casilla 1,0
                            x = 1;
                            y = 0;
                            movimiento = "Cambiar la cuarta casilla [1,0]";
                            generado = true;
                            coste = 1;
                            break;

                        case 4://Cambiar la quinta casilla 1,1
                            x = 1;
                            y = 1;
                            movimiento = "Cambiar la quinta casilla [1,1]";
                            generado = true;
                            coste = 1;
                            break;

                        case 5://Cambiar la sexta casilla 1,2
                            x = 1;
                            y = 2;
                            movimiento = "Cambiar la sexta casilla [1,2]";
                            generado = true;
                            coste = 1;
                            break;

                        case 6://Cambiar la septima casilla 2,0
                            x = 2;
                            y = 0;
                            movimiento = "Cambiar la septima casilla [2,0]";
                            generado = true;
                            coste = 1;
                            break;

                        case 7://Cambiar la octava casilla 2,1
                            x = 2;
                            y = 1;
                            movimiento = "Cambiar la octava casilla [2,1]";
                            generado = true;
                            coste = 1;
                            break;

                        case 8://Cambiar la novena casilla 2,2
                            x = 2;
                            y = 2;
                            movimiento = "Cambiar la novena casilla [2,2]";
                            generado = true;
                            coste = 1;
                            break;
                    }

                    if (generado) {
                        if (newtablero[x][y].compareTo("R") == 0) {
                            newtablero[x][y] = "A";
                        } else {
                            newtablero[x][y] = "R";
                        }
                    }

                    RejillaRojoAzulEstado nuevoEstado = new RejillaRojoAzulEstado(newtablero);

                    if (generado && nuevoEstado.valido()) {
                        String datos = movimiento + " ,COSTE:" + coste + "\n" + nuevoEstado;
                        sucesores.add(new Successor(datos, nuevoEstado));
                    }
                }
            } else {
                log.info("\nTIEMPO DE ESPERA SUPERADO\n");
                RejillaRojoAzulEstado.timeout = true;
            }
        }
        return sucesores;
    }
}
