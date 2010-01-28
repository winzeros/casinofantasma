/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.solitario;

import aima.search.framework.GoalTest;
import java.util.Arrays;

/**
 *
 * @author Alicia
 */
public class SolitarioEstadoObjetivo implements GoalTest {

    private SolitarioJuego juego;

    public SolitarioEstadoObjetivo(SolitarioJuego solitario) {
        juego = solitario;
    }

    public boolean isGoalState(Object state) {

        boolean ok = false;
        String[][] tablero = new String[7][7];

        tablero[0][0] = SolitarioEstado.NO_POS;
        tablero[0][1] = SolitarioEstado.NO_POS;
        tablero[0][2] = SolitarioEstado.VACIO;
        tablero[0][3] = SolitarioEstado.VACIO;
        tablero[0][4] = SolitarioEstado.VACIO;
        tablero[0][5] = SolitarioEstado.NO_POS;
        tablero[0][6] = SolitarioEstado.NO_POS;

        tablero[1][0] = SolitarioEstado.NO_POS;
        tablero[1][1] = SolitarioEstado.NO_POS;
        tablero[1][2] = SolitarioEstado.VACIO;
        tablero[1][3] = SolitarioEstado.VACIO;
        tablero[1][4] = SolitarioEstado.VACIO;
        tablero[1][5] = SolitarioEstado.NO_POS;
        tablero[1][6] = SolitarioEstado.NO_POS;

        tablero[2][0] = SolitarioEstado.VACIO;
        tablero[2][1] = SolitarioEstado.VACIO;
        tablero[2][2] = SolitarioEstado.VACIO;
        tablero[2][3] = SolitarioEstado.VACIO;
        tablero[2][4] = SolitarioEstado.VACIO;
        tablero[2][5] = SolitarioEstado.VACIO;
        tablero[2][6] = SolitarioEstado.VACIO;

        tablero[3][0] = SolitarioEstado.VACIO;
        tablero[3][1] = SolitarioEstado.VACIO;
        tablero[3][2] = SolitarioEstado.VACIO;
        tablero[3][3] = SolitarioEstado.FICHA;
        tablero[3][4] = SolitarioEstado.VACIO;
        tablero[3][5] = SolitarioEstado.VACIO;
        tablero[3][6] = SolitarioEstado.VACIO;

        tablero[4][0] = SolitarioEstado.VACIO;
        tablero[4][1] = SolitarioEstado.VACIO;
        tablero[4][2] = SolitarioEstado.VACIO;
        tablero[4][3] = SolitarioEstado.VACIO;
        tablero[4][4] = SolitarioEstado.VACIO;
        tablero[4][5] = SolitarioEstado.VACIO;
        tablero[4][6] = SolitarioEstado.VACIO;

        tablero[5][0] = SolitarioEstado.NO_POS;
        tablero[5][1] = SolitarioEstado.NO_POS;
        tablero[5][2] = SolitarioEstado.VACIO;
        tablero[5][3] = SolitarioEstado.VACIO;
        tablero[5][4] = SolitarioEstado.VACIO;
        tablero[5][5] = SolitarioEstado.NO_POS;
        tablero[5][6] = SolitarioEstado.NO_POS;

        tablero[6][0] = SolitarioEstado.NO_POS;
        tablero[6][1] = SolitarioEstado.NO_POS;
        tablero[6][2] = SolitarioEstado.VACIO;
        tablero[6][3] = SolitarioEstado.VACIO;
        tablero[6][4] = SolitarioEstado.VACIO;
        tablero[6][5] = SolitarioEstado.NO_POS;
        tablero[6][6] = SolitarioEstado.NO_POS;

        ok = Arrays.equals(tablero, ((SolitarioEstado) state).getTablero());

        if (ok) {
            juego.setSolucion(ok);
        }

        return ok;
    }

}
