/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.solitario;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

enum Movimiento {

    IZQUIERDA, DERECHA, ARRIBA, ABAJO
}

/**
 *
 * @author Alicia
 */
public class SolitarioEstado {

    private ArrayList<ArrayList> _tablero;
    private ArrayList _recorrido;
    private boolean _controlCiclos;
    public static final String FICHA = "*";
    public static final String VACIO = " ";
    public static final String NO_POS = "#";

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public SolitarioEstado() {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = true;
    }

    public SolitarioEstado(boolean ciclos) {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = ciclos;
    }

    public SolitarioEstado(ArrayList<ArrayList> tablero) {
        _tablero = tablero;
    }

    public SolitarioEstado(SolitarioEstado estado) {
        _tablero = estado._tablero;
        _recorrido = estado._recorrido;
        _controlCiclos = estado._controlCiclos;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    private ArrayList<ArrayList> getEstadoInicial() {

        ArrayList<ArrayList> tablero = new ArrayList(7);
        ArrayList<String> fila3fichas = new ArrayList(7);
        ArrayList<String> fila7fichas = new ArrayList(7);
        ArrayList<String> filaCentral = new ArrayList(7);

        //Primera fila --> ##***##
        fila3fichas.add(NO_POS);
        fila3fichas.add(NO_POS);
        fila3fichas.add(FICHA);
        fila3fichas.add(FICHA);
        fila3fichas.add(FICHA);
        fila3fichas.add(NO_POS);
        fila3fichas.add(NO_POS);

        fila7fichas.add(FICHA);
        fila7fichas.add(FICHA);
        fila7fichas.add(FICHA);
        fila7fichas.add(FICHA);
        fila7fichas.add(FICHA);
        fila7fichas.add(FICHA);
        fila7fichas.add(FICHA);

        filaCentral.add(FICHA);
        filaCentral.add(FICHA);
        filaCentral.add(FICHA);
        filaCentral.add(VACIO);
        filaCentral.add(FICHA);
        filaCentral.add(FICHA);
        filaCentral.add(FICHA);

        tablero.add(fila3fichas);
        tablero.add(fila3fichas);
        tablero.add(fila7fichas);
        tablero.add(filaCentral);
        tablero.add(fila7fichas);
        tablero.add(fila3fichas);
        tablero.add(fila3fichas);

        return tablero;
    }

    public void setEstado(SolitarioEstado estado) {
        this._tablero = (ArrayList<ArrayList>) estado._tablero.clone();
    }

    public ArrayList<ArrayList> getTablero() {
        return this._tablero;
    }

    public void setTablero(ArrayList<ArrayList> tablero) {
        this._tablero = tablero;
    }

    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }

    private Point getPuntoIntervalo(Point origen, Movimiento movimiento) {

        Point intervalo = new Point();

        if (!origen.equals(new Point(-1, -1))) {
            switch (movimiento) {

                case ABAJO: {
                    if ((this._tablero.get(origen.x + 1).get(origen.y).equals(FICHA)) &&
                            this._tablero.get(origen.x + 2).get(origen.y).equals(VACIO)) {
                        intervalo = new Point(origen.x + 1, origen.y);
                    }
                    break;
                }
                case ARRIBA: {
                    if ((this._tablero.get(origen.x - 1).get(origen.y).equals(FICHA)) &&
                            this._tablero.get(origen.x - 2).get(origen.y).equals(VACIO)) {
                        intervalo = new Point(origen.x - 1, origen.y);
                    }
                    break;
                }
                case IZQUIERDA: {
                    if ((this._tablero.get(origen.x).get(origen.y - 1).equals(FICHA)) &&
                            this._tablero.get(origen.x).get(origen.y - 2).equals(VACIO)) {
                        intervalo = new Point(origen.x, origen.y - 1);
                    }
                    break;
                }
                case DERECHA: {
                    if ((this._tablero.get(origen.x).get(origen.y + 1).equals(FICHA)) &&
                            this._tablero.get(origen.x).get(origen.y + 2).equals(VACIO)) {
                        intervalo = new Point(origen.x, origen.y + 1);
                    }
                    break;
                }
            }

        }

        return intervalo;

    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    boolean controlCiclos(String[][] tablero) {
        return !((this._controlCiclos) && (this._recorrido.contains(tablero)));
    }

    private Point getSalto(Point origen, Movimiento movimiento) {

        Point destino = new Point(-1, -1);

        if ((this._tablero.get(origen.x).get(origen.y).equals(FICHA)) &&
                esPosibleSalto(origen, movimiento)) {

            switch (movimiento) {

                case ABAJO: {
                    if ((this._tablero.get(origen.x + 1).get(origen.y).equals(FICHA)) &&
                            this._tablero.get(origen.x + 2).get(origen.y).equals(VACIO)) {
                        destino = new Point(origen.x + 2, origen.y);
                    }
                    break;
                }
                case ARRIBA: {
                    if ((this._tablero.get(origen.x - 1).get(origen.y).equals(FICHA)) &&
                            this._tablero.get(origen.x - 2).get(origen.y).equals(VACIO)) {
                        destino = new Point(origen.x - 2, origen.y);
                    }
                    break;
                }
                case IZQUIERDA: {
                    if ((this._tablero.get(origen.x).get(origen.y - 1).equals(FICHA)) &&
                            this._tablero.get(origen.x).get(origen.y - 2).equals(VACIO)) {
                        destino = new Point(origen.x, origen.y - 2);
                    }
                    break;
                }
                case DERECHA: {
                    if ((this._tablero.get(origen.x).get(origen.y + 1).equals(FICHA)) &&
                            this._tablero.get(origen.x).get(origen.y + 2).equals(VACIO)) {
                        destino = new Point(origen.x, origen.y + 2);
                    }
                    break;
                }
            }
        }
        return destino;
    }

    private boolean esPosibleSalto(Point origen, Movimiento movimiento) {

        boolean ok = false;

        switch (movimiento) {

            case ABAJO: {
                ok = ((origen.x + 2) < 7);
                break;
            }
            case ARRIBA: {
                ok = ((origen.x - 2) >= 0);
                break;
            }
            case IZQUIERDA: {
                ok = ((origen.y - 2) >= 0);
                break;
            }
            case DERECHA: {
                ok = ((origen.y + 2) < 7);
                break;
            }
        }
        return ok;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="FUNCIONES">   
    public boolean ejecutarMovimiento(Point origen, Movimiento movimiento) {

        boolean ok = false;
        Point intervalo;
        Point destino = getSalto(origen, movimiento);

        if (!destino.equals(new Point(-1, -1))) {
            intervalo = getPuntoIntervalo(origen, movimiento);
            this._tablero.get(origen.x).set(intervalo.y, VACIO);
            this._tablero.get(intervalo.x).set(intervalo.y, VACIO);
            this._tablero.get(destino.x).set(destino.y, FICHA);
            this._recorrido.add(_tablero);
            ok = true;
        }

        return ok;
    }

    public boolean equals(Object o) {
        return this._tablero.equals(o);
    }

    public SolitarioEstado clone() {

        SolitarioEstado otro = new SolitarioEstado();

        otro._controlCiclos = _controlCiclos;
        otro._recorrido = (ArrayList) _recorrido.clone();
        otro._tablero = (ArrayList) _tablero.clone();

        return otro;

    }

    @Override
    public String toString() {

        String resultado = NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                resultado += this._tablero.get(i).get(j);
            }
            resultado += "\n";
        }

        resultado += NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS;

        return resultado;
    }
// </editor-fold>
}
