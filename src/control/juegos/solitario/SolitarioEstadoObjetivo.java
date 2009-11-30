/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.solitario;

import aima.search.framework.GoalTest;
import java.util.ArrayList;

/**
 *
 * @author Alicia
 */
public class SolitarioEstadoObjetivo implements GoalTest {

    private SolitarioJuego _juego;

    public SolitarioEstadoObjetivo(SolitarioJuego juego) {
        this._juego = juego;
    }

    public boolean isGoalState(Object state) {

        ArrayList<ArrayList> tablero = new ArrayList(7);
        boolean ok = false;
        ArrayList<String> fila3fichas = new ArrayList(7);
        ArrayList<String> fila7fichas = new ArrayList(7);
        ArrayList<String> filaCentral = new ArrayList(7);

        //Primera fila --> ##***##
        fila3fichas.add(SolitarioEstado.NO_POS);
        fila3fichas.add(SolitarioEstado.NO_POS);
        fila3fichas.add(SolitarioEstado.FICHA);
        fila3fichas.add(SolitarioEstado.FICHA);
        fila3fichas.add(SolitarioEstado.FICHA);
        fila3fichas.add(SolitarioEstado.NO_POS);
        fila3fichas.add(SolitarioEstado.NO_POS);

        fila7fichas.add(SolitarioEstado.FICHA);
        fila7fichas.add(SolitarioEstado.FICHA);
        fila7fichas.add(SolitarioEstado.FICHA);
        fila7fichas.add(SolitarioEstado.FICHA);
        fila7fichas.add(SolitarioEstado.FICHA);
        fila7fichas.add(SolitarioEstado.FICHA);
        fila7fichas.add(SolitarioEstado.FICHA);

        filaCentral.add(SolitarioEstado.FICHA);
        filaCentral.add(SolitarioEstado.FICHA);
        filaCentral.add(SolitarioEstado.FICHA);
        filaCentral.add(SolitarioEstado.VACIO);
        filaCentral.add(SolitarioEstado.FICHA);
        filaCentral.add(SolitarioEstado.FICHA);
        filaCentral.add(SolitarioEstado.FICHA);

        tablero.add(fila3fichas);
        tablero.add(fila3fichas);
        tablero.add(fila7fichas);
        tablero.add(filaCentral);
        tablero.add(fila7fichas);
        tablero.add(fila3fichas);
        tablero.add(fila3fichas);

        ok = tablero.equals(state);

        if (ok) {
            this._juego.setSolucion(ok);
        }

        return ok;
    }

}
