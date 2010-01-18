/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.hanoi;

import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class HanoiEstado {

    private int[][] _tablero;
    private ArrayList _recorrido;
    private boolean _controlCiclos;

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public HanoiEstado() {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = true;
    }

    public HanoiEstado(boolean controlCiclos) {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = controlCiclos;
    }

    public HanoiEstado(int[][] tablero) {
        _tablero = tablero;
    }

    public HanoiEstado(HanoiEstado estado) {
        _tablero = estado._tablero;
        _recorrido = estado._recorrido;
        _controlCiclos = estado._controlCiclos;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    public int[][] getEstadoInicial() {

        int[][] estadoInicial = new int[3][3];
        estadoInicial[0][0] = 1;// B1
        estadoInicial[0][1] = 1;// P1
        estadoInicial[1][0] = 1;// B2
        estadoInicial[1][1] = 2;// P2
        estadoInicial[2][0] = 1;// B3
        estadoInicial[2][1] = 3;// P3
        return estadoInicial;
    }

    public void setEstado(HanoiEstado estado) {
        try {
            for (int i = 0; i < estado._tablero.length; i++) {
                _tablero[i] = estado._tablero[i];
            }
        } catch (Exception ex) {
            Logger.getLogger(HanoiEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

    public int[][] getTablero() {
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
    private boolean puedeMoverse(int operacion) {

        boolean enc = false;

        switch (operacion) {
            case 0:
                enc = mueveD3aB1();
                break;
            case 1:
                enc = mueveD3aB2();
                break;
            case 2:
                enc = mueveD3aB3();
                break;
            case 3:
                enc = mueveD1aB1();
                break;
            case 4:
                enc = mueveD1aB2();
                break;
            case 5:
                enc = mueveD1aB3();
                break;
            case 6:
                enc = mueveD2aB1();
                break;
            case 7:
                enc = mueveD2aB2();
                break;
            case 8:
                enc = mueveD2aB3();
                break;
        }

        return enc;
    }

    boolean controlCiclos(int[][] tablero) {
        return !((this._controlCiclos) && (this._recorrido.contains(tablero)));
    }

// </editor-fold>

    public boolean mover(int operacion) {
        boolean res = false;

        try {
            if (puedeMoverse(operacion)) {
                if (this.controlCiclos(_tablero)) {
                    _recorrido.add(_tablero);
                    res = true;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HanoiEstado.class.getName()).log(Level.ERROR, "Error al ejecutar la operacion " + operacion, ex);
        }
        return res;
    }



    @Override
    public String toString() {
        String resultado = "hola";
        
        return resultado;
    }

// <editor-fold defaultstate="collapsed" desc="OPERACIONES">
    private boolean mueveD1aB1() {
        if ((_tablero[0][0] != 1) && (_tablero[1][0] != 1) && (_tablero[2][0] != 1) &&
                ((_tablero[0][0]) != (_tablero[1][0])) && ((_tablero[0][0]) != (_tablero[2][0]))) {
            _tablero[0][0] = 1;
            _tablero[0][1] = 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD1aB2() {
        if ((_tablero[0][0] != 2) && (_tablero[1][0] != 2) && (_tablero[2][0] != 2) &&
                ((_tablero[0][0]) != (_tablero[1][0])) && ((_tablero[0][0]) != (_tablero[2][0]))) {
            _tablero[0][0] = 2;
            _tablero[0][1] = 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD1aB3() {
        if ((_tablero[0][0] != 3) && (_tablero[1][0] != 3) && (_tablero[2][0] != 3) &&
                ((_tablero[0][0]) != (_tablero[1][0])) && ((_tablero[0][0]) != (_tablero[2][0]))) {
            _tablero[0][0] = 3;
            _tablero[0][1] = 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD2aB1() {
        if ((_tablero[1][0] != 1) && (_tablero[2][0] != 1) && ((_tablero[2][0]) != (_tablero[1][0]))) {
            if (_tablero[0][0] == 1) {
                _tablero[1][0] = 1;
                _tablero[1][1] = 2;
            } else if (_tablero[0][0] != 1) {
                _tablero[1][0] = 1;
                _tablero[1][1] = 1;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD2aB2() {
        if ((_tablero[1][0] != 2) && (_tablero[2][0] != 2) && ((_tablero[2][0]) != (_tablero[1][0]))) {
            if (_tablero[0][0] == 2) {
                _tablero[1][0] = 2;
                _tablero[1][1] = 2;
            } else if (_tablero[0][0] != 2) {
                _tablero[1][0] = 2;
                _tablero[1][1] = 1;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD2aB3() {
        if ((_tablero[1][0] != 3) && (_tablero[2][0] != 3) && ((_tablero[2][0]) != (_tablero[1][0]))) {
            if (_tablero[0][0] == 3) {
                _tablero[1][0] = 3;
                _tablero[1][1] = 2;
            } else if (_tablero[0][0] != 3) {
                _tablero[1][0] = 3;
                _tablero[1][1] = 1;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD3aB1() {
        if (_tablero[2][0] != 1) {
            _tablero[2][0] = 1;
            if ((_tablero[0][0] == 1) && ((_tablero[0][0]) != (_tablero[1][0]))) {
                _tablero[2][1] = 2;
            } else {
                if ((_tablero[1][0] == 1) && ((_tablero[0][0]) != (_tablero[1][0]))) {
                    _tablero[2][1] = 2;
                } else {
                    if ((_tablero[1][0] == 1) && (_tablero[0][0] == 1)) {
                        _tablero[2][1] = 3;
                    } else {
                        _tablero[2][1] = 1;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean mueveD3aB2() {
        if (_tablero[2][0] != 2) {
            _tablero[2][0] = 2;
            if ((_tablero[0][0] == 2) && ((_tablero[0][0]) != (_tablero[1][0]))) {
                _tablero[2][1] = 2;
            } else {
                if ((_tablero[1][0] == 2) && ((_tablero[0][0]) != (_tablero[1][0]))) {
                    _tablero[2][1] = 2;
                } else {
                    if ((_tablero[1][0] == 2) && (_tablero[0][0] == 2)) {
                        _tablero[2][1] = 3;
                    } else {
                        _tablero[2][1] = 1;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean mueveD3aB3() {
        if (_tablero[2][0] != 3) {
            _tablero[2][0] = 3;
            if ((_tablero[0][0] == 3) && ((_tablero[0][0]) != (_tablero[1][0]))) {
                _tablero[2][1] = 2;
            } else {
                if ((_tablero[1][0] == 3) && ((_tablero[0][0]) != (_tablero[1][0]))) {
                    _tablero[2][1] = 2;
                } else {
                    if ((_tablero[1][0] == 3) && (_tablero[0][0] == 3)) {
                        _tablero[2][1] = 3;
                    } else {
                        _tablero[2][1] = 1;
                    }
                }
            }
            return true;
        }
        return false;
    }
    // </editor-fold>
    
}
