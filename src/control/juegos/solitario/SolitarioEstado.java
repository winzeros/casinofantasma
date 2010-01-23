/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.solitario;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Alicia
 */
public class SolitarioEstado {

    private String[][] _tablero;
    private ArrayList<String[][]> _recorrido;
    private boolean _controlCiclos;
    public static final String FICHA = "*";
    public static final String VACIO = "_";
    public static final String NO_POS = "#";
    public static long horaInicial;


    public static enum Movimiento {

        IZQUIERDA, DERECHA, ARRIBA, ABAJO
    }

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public SolitarioEstado() {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = true;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();


    }

    public SolitarioEstado(boolean ciclos) {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = ciclos;
    }

    public SolitarioEstado(String[][] tablero) {
        _tablero = new String[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                _tablero[i][j] = tablero[i][j];
            }
        }
    }

    public SolitarioEstado(SolitarioEstado estado) {
        _tablero = new String[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                _tablero[i][j] = estado._tablero[i][j];
            }
        }
        _recorrido = (ArrayList) estado._recorrido.clone();
        _controlCiclos = estado._controlCiclos;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    private String[][] getEstadoInicial() {

        String[][] tablero = new String[7][7];

        tablero[0][0] = SolitarioEstado.NO_POS;
        tablero[0][1] = SolitarioEstado.NO_POS;
        tablero[0][2] = SolitarioEstado.FICHA;
        tablero[0][3] = SolitarioEstado.FICHA;
        tablero[0][4] = SolitarioEstado.FICHA;
        tablero[0][5] = SolitarioEstado.NO_POS;
        tablero[0][6] = SolitarioEstado.NO_POS;

        tablero[1][0] = SolitarioEstado.NO_POS;
        tablero[1][1] = SolitarioEstado.NO_POS;
        tablero[1][2] = SolitarioEstado.FICHA;
        tablero[1][3] = SolitarioEstado.FICHA;
        tablero[1][4] = SolitarioEstado.FICHA;
        tablero[1][5] = SolitarioEstado.NO_POS;
        tablero[1][6] = SolitarioEstado.NO_POS;

        tablero[2][0] = SolitarioEstado.FICHA;
        tablero[2][1] = SolitarioEstado.FICHA;
        tablero[2][2] = SolitarioEstado.FICHA;
        tablero[2][3] = SolitarioEstado.FICHA;
        tablero[2][4] = SolitarioEstado.FICHA;
        tablero[2][5] = SolitarioEstado.FICHA;
        tablero[2][6] = SolitarioEstado.FICHA;

        tablero[3][0] = SolitarioEstado.FICHA;
        tablero[3][1] = SolitarioEstado.FICHA;
        tablero[3][2] = SolitarioEstado.FICHA;
        tablero[3][3] = SolitarioEstado.VACIO;
        tablero[3][4] = SolitarioEstado.FICHA;
        tablero[3][5] = SolitarioEstado.FICHA;
        tablero[3][6] = SolitarioEstado.FICHA;

        tablero[4][0] = SolitarioEstado.FICHA;
        tablero[4][1] = SolitarioEstado.FICHA;
        tablero[4][2] = SolitarioEstado.FICHA;
        tablero[4][3] = SolitarioEstado.FICHA;
        tablero[4][4] = SolitarioEstado.FICHA;
        tablero[4][5] = SolitarioEstado.FICHA;
        tablero[4][6] = SolitarioEstado.FICHA;

        tablero[5][0] = SolitarioEstado.NO_POS;
        tablero[5][1] = SolitarioEstado.NO_POS;
        tablero[5][2] = SolitarioEstado.FICHA;
        tablero[5][3] = SolitarioEstado.FICHA;
        tablero[5][4] = SolitarioEstado.FICHA;
        tablero[5][5] = SolitarioEstado.NO_POS;
        tablero[5][6] = SolitarioEstado.NO_POS;

        tablero[6][0] = SolitarioEstado.NO_POS;
        tablero[6][1] = SolitarioEstado.NO_POS;
        tablero[6][2] = SolitarioEstado.FICHA;
        tablero[6][3] = SolitarioEstado.FICHA;
        tablero[6][4] = SolitarioEstado.FICHA;
        tablero[6][5] = SolitarioEstado.NO_POS;
        tablero[6][6] = SolitarioEstado.NO_POS;

        return tablero;
    }

    public void setEstado(SolitarioEstado estado) {
        this._tablero = (String[][]) estado._tablero.clone();
    }

    public String[][] getTablero() {
        return this._tablero;
    }

    public void setTablero(String[][] tablero) {
        this._tablero = tablero;
    }

    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = (ArrayList) recorrido.clone();
    }

    private Point getPuntoIntervalo(Point origen, Movimiento movimiento) {

        Point intervalo = new Point();

        if (!origen.equals(new Point(-1, -1))) {
            switch (movimiento) {

                case ABAJO: {
                    if ((this._tablero[origen.x + 1][origen.y].equals(FICHA)) &&
                            this._tablero[origen.x + 2][origen.y].equals(VACIO)) {
                        intervalo = new Point(origen.x + 1, origen.y);
                    }
                    break;
                }
                case ARRIBA: {
                    if ((this._tablero[origen.x - 1][origen.y].equals(FICHA)) &&
                            this._tablero[origen.x - 2][origen.y].equals(VACIO)) {
                        intervalo = new Point(origen.x - 1, origen.y);
                    }
                    break;
                }
                case IZQUIERDA: {
                    if ((this._tablero[origen.x][origen.y - 1].equals(FICHA)) &&
                            this._tablero[origen.x][origen.y - 2].equals(VACIO)) {
                        intervalo = new Point(origen.x, origen.y - 1);
                    }
                    break;
                }
                case DERECHA: {
                    if ((this._tablero[origen.x][origen.y + 1].equals(FICHA)) &&
                            this._tablero[origen.x][origen.y + 2].equals(VACIO)) {
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
        
        boolean ok = true;
        boolean iguales;

        if (this._controlCiclos) {

            for (int i = 0; i < this._recorrido.size(); i++) {
                iguales = true;
                for (int j = 0; j < 7; j++) {
                    for (int k = 0; k < 7; k++) {
                        iguales = iguales && (this._recorrido.get(i)[j][k].equals(tablero[j][k]));
                    }
                }
                if (iguales) {
                    ok = false;
                    break;
                }
            }
        }
        return ok;
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
            this._tablero[origen.x][origen.y] = VACIO;
            this._tablero[intervalo.x][intervalo.y] = VACIO;
            this._tablero[destino.x][destino.y] = FICHA;
            if (this.controlCiclos(_tablero)) {
                this._recorrido.add(_tablero);
                this.rotarTablero();
                ok = true;
            }

        }

        return ok;
    }

    public void rotarTablero() {

        String[][] tableroAux;

        tableroAux = new String[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tableroAux[i][j] = _tablero[j][i];
            }
        }
        this._recorrido.add(tableroAux);

        tableroAux = new String[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tableroAux[i][j] = _tablero[6 - i][6 - j];
            }
        }
        this._recorrido.add(tableroAux);

        tableroAux = new String[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tableroAux[i][j] = _tablero[6 - j][6 - i];
            }
        }
        this._recorrido.add(tableroAux);

    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return Arrays.equals(this._tablero, (String[][]) o);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Arrays.deepHashCode(this._tablero);
        hash = 83 * hash + (this._controlCiclos ? 1 : 0);
        return hash;
    }

    @Override
    public SolitarioEstado clone() {

        SolitarioEstado otro = new SolitarioEstado();

        otro._controlCiclos = _controlCiclos;
        otro._recorrido = (ArrayList) _recorrido.clone();
        otro._tablero = new String[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                otro._tablero[i][j] = _tablero[i][j];
            }
        }

        return otro;

    }

    @Override
    public String toString() {

        String resultado = NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + "\n";

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                resultado += this._tablero[i][j];
            }
            resultado += "\n";
        }

        resultado += NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS + NO_POS;

        return resultado;
    }
// </editor-fold>
}
