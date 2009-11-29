/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.solitario;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

enum Movimiento {IZQUIERDA, DERECHA, ARRIBA, ABAJO}

/**
 *
 * @author Alicia
 */
public class SolitarioEstado {

    private String[][] _tablero;
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

    public SolitarioEstado(String[][] tablero) {
        _tablero = tablero;
    }

    public SolitarioEstado(SolitarioEstado estado) {
        _tablero = estado._tablero;
        _recorrido = estado._recorrido;
        _controlCiclos = estado._controlCiclos;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">

    private String[][] getEstadoInicial() {

        String[][] tablero = new String[7][7];

        //Primera fila --> ##***##
        tablero[0][0] = NO_POS;
        tablero[0][1] = NO_POS;
        tablero[0][2] = FICHA;
        tablero[0][3] = FICHA;
        tablero[0][4] = FICHA;
        tablero[0][5] = NO_POS;
        tablero[0][6] = NO_POS;

        //Segunda fila --> ##***##
        tablero[1][0] = NO_POS;
        tablero[1][1] = NO_POS;
        tablero[1][2] = FICHA;
        tablero[1][3] = FICHA;
        tablero[1][4] = FICHA;
        tablero[1][5] = NO_POS;
        tablero[1][6] = NO_POS;

        //Tercela fila --> *******
        tablero[2][0] = FICHA;
        tablero[2][1] = FICHA;
        tablero[2][2] = FICHA;
        tablero[2][3] = FICHA;
        tablero[2][4] = FICHA;
        tablero[2][5] = FICHA;
        tablero[2][6] = FICHA;

        //Cuarta fila --> *** ***
        tablero[3][0] = FICHA;
        tablero[3][1] = FICHA;
        tablero[3][2] = FICHA;
        tablero[3][3] = VACIO;
        tablero[3][4] = FICHA;
        tablero[3][5] = FICHA;
        tablero[3][6] = FICHA;

        //Quinta fila --> *******
        tablero[4][0] = FICHA;
        tablero[4][1] = FICHA;
        tablero[4][2] = FICHA;
        tablero[4][3] = FICHA;
        tablero[4][4] = FICHA;
        tablero[4][5] = FICHA;
        tablero[4][6] = FICHA;

        //Sexta fila --> ##***##
        tablero[5][0] = NO_POS;
        tablero[5][1] = NO_POS;
        tablero[5][2] = FICHA;
        tablero[5][3] = FICHA;
        tablero[5][4] = FICHA;
        tablero[5][5] = NO_POS;
        tablero[5][6] = NO_POS;

        //Septima fila --> ##***##
        tablero[6][0] = NO_POS;
        tablero[6][1] = NO_POS;
        tablero[6][2] = FICHA;
        tablero[6][3] = FICHA;
        tablero[6][4] = FICHA;
        tablero[6][5] = NO_POS;
        tablero[6][6] = NO_POS;

        return tablero;
    }

    public void setEstado(SolitarioEstado estado) {
        this._tablero = estado._tablero.clone();
    }

    public  String[][] getTablero() {
        return this._tablero;
    }

    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">

    boolean controlCiclos(String[][] tablero) {
        return !((this._controlCiclos) && (this._recorrido.contains(tablero)));
    }

    private Point getSalto(Point origen, Movimiento movimiento) {

        Point destino = new Point(-1, -1);

        if ((this._tablero[origen.x][origen.y].equals(FICHA)) &&
                esPosibleSalto(origen, movimiento)) {

            switch (movimiento) {

                case ABAJO: {
                    if ((this._tablero[origen.x + 1][origen.y].equals(FICHA)) &&
                         this._tablero[origen.x + 2][origen.y].equals(VACIO)) {
                        destino = new Point(origen.x + 2, origen.y);
                    }
                    break;
                }
                case ARRIBA: {
                    if ((this._tablero[origen.x - 1][origen.y].equals(FICHA)) &&
                         this._tablero[origen.x - 2][origen.y].equals(VACIO)) {
                        destino = new Point(origen.x - 2, origen.y);
                    }
                    break;
                }
                case IZQUIERDA: {
                    if ((this._tablero[origen.x][origen.y - 1].equals(FICHA)) &&
                         this._tablero[origen.x][origen.y - 2].equals(VACIO)) {
                        destino = new Point(origen.x, origen.y - 2);
                    }
                    break;
                }
                case DERECHA: {
                    if ((this._tablero[origen.x][origen.y + 1].equals(FICHA)) &&
                         this._tablero[origen.x][origen.y + 2].equals(VACIO)) {
                        destino = new Point(origen.x, origen.y + 2);
                    }
                    break;
                }
            }
        }
        return destino;
    }

    private boolean esPosibleSalto(Point origen, Movimiento movimiento){

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
        Point destino = getSalto(origen, movimiento);

        if (!destino.equals(new Point(-1, -1))){
            this._tablero[origen.x][origen.y] = VACIO;
            this._tablero[destino.x][destino.y] = FICHA;
            this._recorrido.add(_tablero);
            ok = true;
        }

        return ok;
    }

    public boolean equals(Object o) {
        return Arrays.equals(this._tablero, ((SolitarioEstado) o)._tablero);
    }

    @Override
    public String toString() {

        String resultado = NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                resultado += this._tablero[i][j];
            }
            resultado +="\n";
        }

        resultado += NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS;

        return resultado;
    }

// </editor-fold>

}
