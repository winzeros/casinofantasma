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
        //Palo 1
        estadoInicial[0][0] = 3;// Disco abajo ESTA EL DISCO 3
        estadoInicial[0][1] = 2;// Disco medio ESTA EL DISCO 2
        estadoInicial[0][2] = 1;// Disco arriba ESTA EL DISCO 1
        //Palo 2
        estadoInicial[1][0] = 0;// Disco abajo NO HAY DISCO
        estadoInicial[1][1] = 0;// Disco medio NO HAY DISCO
        estadoInicial[1][2] = 0;// Disco arriba NO HAY DISCO
        //Palo 3
        estadoInicial[2][0] = 0;// Disco abajo NO HAY DISCO
        estadoInicial[2][1] = 0;// Disco medio NO HAY DISCO
        estadoInicial[2][2] = 0;// Disco arriba NO HAY DISCO
        return estadoInicial;
    }

    public void setEstado(HanoiEstado estado) {
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                _tablero[i][j] = estado._tablero[i][j];
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
                enc = mueve(0,3,1,2);
                break;
            case 1:
                enc = mueve(1,3,0,2);
                break;
            case 2:
                enc = mueve(2,3,0,1);
                break;
            case 3:
                enc = mueve(0,1,1,2);
                break;
            case 4:
                enc = mueve(1,1,0,2);
                break;
            case 5:
                enc = mueve(2,1,0,1);
                break;
            case 6:
                enc = mueve(0,2,1,2);
                break;
            case 7:
                enc = mueve(1,2,0,2);
                break;
            case 8:
                enc = mueve(2,2,0,1);
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
        String resultado = "·%%/(·!·$\n\n\n";
        
        return resultado;
    }

// <editor-fold defaultstate="collapsed" desc="MOVIMIENTOS">
    private boolean mueve(int paloFin, int disco, int paloA, int paloB) {
        if (_tablero[paloA][2] == disco){
            if (_tablero[paloFin][0] == 0){
                _tablero[paloFin][0] = disco;
                _tablero[paloA][2] = 0;
                return true;
            }else if (_tablero[paloFin][1] == 0 && _tablero[paloFin][0] > disco){
                _tablero[paloFin][1] = disco;
                _tablero[paloA][2] = 0;
                return true;
            }else if (_tablero[paloFin][2] == 0 && _tablero[paloFin][1] > disco){
                _tablero[paloFin][2] = disco;
                _tablero[paloA][2] = 0;
                return true;
        }
        }
        if (_tablero[paloB][2] == disco) {
            if (_tablero[paloFin][0] == 0){
                _tablero[paloFin][0] = disco;
                _tablero[paloB][2] = 0;
                return true;
            }else if (_tablero[paloFin][1] == 0 && _tablero[paloFin][0] > disco){
                _tablero[paloFin][1] = disco;
                _tablero[paloB][2] = 0;
                return true;
            }else if (_tablero[paloFin][2] == 0 && _tablero[paloFin][1] > disco){
                _tablero[paloFin][2] = disco;
                _tablero[paloB][2] = 0;
                return true;
            }
        }
        if (_tablero[paloA][2] == 0 && _tablero[paloA][1] == disco) {
            if (_tablero[paloFin][0] == 0){
                _tablero[paloFin][0] = disco;
                _tablero[paloA][1] = 0;
                return true;
            }else if (_tablero[paloFin][1] == 0 && _tablero[paloFin][0] > disco){
                _tablero[paloFin][1] = disco;
                _tablero[paloA][1] = 0;
                return true;
            }else if (_tablero[paloFin][2] == 0 && _tablero[paloFin][1] > disco){
                _tablero[paloFin][2] = disco;
                _tablero[paloA][1] = 0;
                return true;
            }
        }
        if (_tablero[paloB][2] == 0 && _tablero[paloB][1] == disco){
            if (_tablero[paloFin][0] == 0){
                _tablero[paloFin][0] = disco;
                _tablero[paloB][1] = 0;
                return true;
            }else if (_tablero[paloFin][1] == 0 && _tablero[paloFin][0] > disco){
                _tablero[paloFin][1] = disco;
                _tablero[paloB][1] = 0;
                return true;
            }else if (_tablero[paloFin][2] == 0 && _tablero[paloFin][1] > disco){
                _tablero[paloFin][2] = disco;
                _tablero[paloB][1] = 0;
                return true;
            }
        }
        if(_tablero[paloA][2] == 0 && _tablero[paloA][1] == 0 && _tablero[paloA][0] == disco) {
            if (_tablero[paloFin][0] == 0){
                _tablero[paloFin][0] = disco;
                _tablero[paloA][0] = 0;
                return true;
            }else if (_tablero[paloFin][1] == 0 && _tablero[paloFin][0] > disco){
                _tablero[paloFin][1] = disco;
                _tablero[paloA][0] = 0;
                return true;
                }else if (_tablero[paloFin][2] == 0 && _tablero[paloFin][1] > disco){
                _tablero[paloFin][2] = disco;
                _tablero[paloA][0] = 0;
                return true;
        }
        }
        if (_tablero[paloB][2] == 0 && _tablero[paloB][1] == 0 && _tablero[paloB][0] == disco){
            if (_tablero[paloFin][0] == 0){
                _tablero[paloFin][0] = disco;
                _tablero[paloB][0] = 0;
                return true;
            }else if (_tablero[paloFin][1] == 0 && _tablero[paloFin][0] > disco){
                _tablero[paloFin][1] = disco;
                _tablero[paloB][0] = 0;
                return true;
                }else if (_tablero[paloFin][2] == 0 && _tablero[paloFin][1] > disco){
                _tablero[paloFin][2] = disco;
                _tablero[paloB][0] = 0;
                return true;
            }
        }
        return false;
    }
/*
    private boolean mueveD1aP2() {
        if ((_tablero[0][0] != 2) && (_tablero[1][0] != 2) && (_tablero[2][0] != 2) &&
                ((_tablero[0][0]) != (_tablero[1][0])) && ((_tablero[0][0]) != (_tablero[2][0]))) {
            _tablero[0][0] = 2;
            _tablero[0][1] = 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD1aP3() {
        if ((_tablero[0][0] != 3) && (_tablero[1][0] != 3) && (_tablero[2][0] != 3) &&
                ((_tablero[0][0]) != (_tablero[1][0])) && ((_tablero[0][0]) != (_tablero[2][0]))) {
            _tablero[0][0] = 3;
            _tablero[0][1] = 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean mueveD2aP1() {
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

    private boolean mueveD2aP2() {
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

    private boolean mueveD2aP3() {
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

    private boolean mueveD3aP1() {
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

    private boolean mueveD3aP2() {
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

    private boolean mueveD3aP3() {
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
    }*/
    // </editor-fold>
    
}
