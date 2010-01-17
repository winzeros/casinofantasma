/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.linterna;

import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class LinternaEstado {
    private int[] _calzada;
    /*
     * POS 0 -> Persona 1 segundo
     * POS 1 -> Persona 3 segundos
     * POS 2 -> Persona 6 segundos
     * POS 3 -> Persona 8 segundos
     * POS 4 -> Persona 12 segundos
     * POS 5 -> Segundos transcurridos
     * POS 6 -> Segundos que me quedan
     */
    private ArrayList _recorrido;
    private boolean _controlCiclos;

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public LinternaEstado() {
        _calzada = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_calzada);
        _controlCiclos = true;
    }

    public LinternaEstado(boolean controlCiclos) {
        _calzada = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_calzada);
        _controlCiclos = controlCiclos;
    }

    public LinternaEstado(int[] linterna) throws Exception {

        if (linterna.length == 7) {
            _calzada = getEstadoInicial();
            try {
                for (int i = 0; i < linterna.length; i++) {
                    _calzada[i] = linterna[i];
                }
            } catch (Exception ex) {
                Logger.getLogger(LinternaEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
            }
        } else {
            throw new Exception("La mesa solo debe tener 6 asientos");
        }

    }

    public LinternaEstado(LinternaEstado estado) {

        try {
            _calzada = getEstadoInicial();
            for (int i = 0; i < estado._calzada.length; i++) {
                _calzada[i] = estado._calzada[i];
            }
            _recorrido = estado._recorrido;
            _controlCiclos = estado._controlCiclos;
        } catch (Exception ex) {
            Logger.getLogger(LinternaEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    public int[] getEstadoInicial() {
        int[] estadoInicial = new int[7];

        estadoInicial[0] = 1; // pos 0 - 4
        estadoInicial[1] = 1; // 0 -> dcha
        estadoInicial[2] = 1; // 1 -> izq
        estadoInicial[3] = 1; 
        estadoInicial[4] = 1;
        estadoInicial[5] = 0;
        estadoInicial[6] = 30;

        return estadoInicial;
    }

    public void setEstado(LinternaEstado estado) {

        try {
            for (int i = 0; i < estado._calzada.length; i++) {
                _calzada[i] = estado._calzada[i];
            }
        } catch (Exception ex) {
            Logger.getLogger(LinternaEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

    public int[] getCalzada() {
        return this._calzada;
    }

    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    public boolean estadoValido(int operacion, int[] calzada) {

        boolean res = true;

        try {

            switch (operacion) {
                case 0://"Pasar Persona de 1 seg"
                    P1();
                    break;
                case 1://"Pasar Persona de 3 seg"
                    P3();
                    break;
                case 2://"Pasar Persona de 6 seg"
                    P6();
                    break;
                case 3://"Pasar Persona de 8 seg"
                    P8();
                    break;
                case 4://"Pasar Persona de 12 seg"
                    P12();
                    break;
                case 5://"Pasar Persona de 1 seg y pasar Persona de 3 seg"
                    P1P3();
                    break;
                case 6://"Pasar Persona de 1 seg y pasar Pde ersona 6 seg"
                    P1P6();
                    break;
                case 7://"Pasar Persona de 1 seg y pasar Persona de 8 seg"
                    P1P8();
                    break;
                case 8://"Pasar Persona de 1 seg y pasar Persona de 12 seg"
                    P1P12();
                    break;
                case 9://"Pasar Persona de 3 seg y pasar Persona de 6 seg"
                    P3P6();
                    break;
                case 10://"Pasar Persona de 3 seg y pasar Persona de 8 seg"
                    P3P8();
                    break;
                case 11://"Pasar Persona de 3 seg y pasar Persona de 12 seg"
                    P3P12();
                    break;
                case 12://"Pasar Persona de 6 seg y pasar Persona de 8 seg"
                    P6P8();
                    break;
                case 13://"Pasar Persona de 6 seg y pasar Persona de 12 seg"
                    P6P12();
                    break;
                case 14://"Pasar Persona de 8 seg y pasar Persona de 12 seg"
                    P8P12();
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(LinternaEstado.class.getName()).log(Level.ERROR, 
                    "Error al comprobar si es válido mover la persona " +
                    operacion, ex);
        }
        return res;
    }

    boolean controlCiclos(int[] mesa) {
        return !((this._controlCiclos) && (this._recorrido.contains(mesa)));
    }

// </editor-fold>

    public boolean pasar(int operacion) {

        boolean res = false;

        try {
            if (estadoValido(operacion,_calzada))
                if (this.controlCiclos(_calzada)) {
                    _recorrido.add(_calzada);
                    res = true;
                } 
        } catch (Exception ex) {
            Logger.getLogger(LinternaEstado.class.getName()).log(Level.ERROR,
                    "Error al ejecutar " + operacion, ex);
        }

        return res;
    }


    @Override
    public String toString() {
/*
 * tengo q mirarlo
 *
 */
        String resultado;

        resultado = "   " + _calzada[0] + "\n";
        resultado += _calzada[5] + " / \\ " + _calzada[1] + "\n";
        resultado += _calzada[4] + " \\ / " + _calzada[2] + "\n";
        resultado += "   " + _calzada[3] + "\n";

        return resultado;
    }


    //Operadores
    public boolean P1() {
        if((_calzada[0] == 1)&&((_calzada[6]-1)>=0)){
            _calzada[0] = 0;
            _calzada[5] = _calzada[5] + 1;
            _calzada[6] = _calzada[6] - 1;
            return true;
        }
        return false;
    }
    
    public boolean P3() {
        if((_calzada[1] == 1)&&((_calzada[6]-3) >= 0)){
            _calzada[1] = 0;
            _calzada[5] = _calzada[5] + 3;
            _calzada[6] = _calzada[6] - 3;
            return true;
        }
        return false;
    }

    public boolean P6() {
        if((_calzada[2] == 1)&&((_calzada[6]-6) >= 0)){
            _calzada[2] = 0;
            _calzada[5] = _calzada[5] + 6;
            _calzada[6] = _calzada[6] - 6;
            return true;
        }
        return false;
    }

    public boolean P8() {
        if((_calzada[3] == 1)&&((_calzada[6]-8) >= 0)){
            _calzada[3] = 0;
            _calzada[5] = _calzada[5] + 8;
            _calzada[6] = _calzada[6] - 8;
            return true;
        }
        return false;
    }

    public boolean P12() {
        if((_calzada[4] == 1)&&((_calzada[6]-12) >= 0)){
            _calzada[4] = 0;
            _calzada[5] = _calzada[5] + 12;
            _calzada[6] = _calzada[6] - 12;
            return true;
        }
        return false;
    }

    public boolean P1P3() {
        if((_calzada[0] == 1) && (_calzada[1] == 1) && ((_calzada[6]-3) >= 0)){           
            _calzada[0] = 0;
            _calzada[1] = 0;
            _calzada[5] = _calzada[5] + 3;
            _calzada[6] = _calzada[6] - 3;
            return true;
        }
        return false;
    }

    public boolean P1P6() {
        if((_calzada[0] == 1) && (_calzada[2] == 1) && ((_calzada[6]-6) >= 0)){
            _calzada[0] = 0;
            _calzada[2] = 0;
            _calzada[5] = _calzada[5] + 6;
            _calzada[6] = _calzada[6] - 6;
            return true;
        }
        return false;
    }

    public boolean P1P8() {
        if((_calzada[0] == 1) && (_calzada[3] == 1) && ((_calzada[6]-8) >= 0)){
            _calzada[0] = 0;
            _calzada[3] = 0;
            _calzada[5] = _calzada[5] + 8;
            _calzada[6] = _calzada[6] - 8;
            return true;
        }
        return false;
    }

    public boolean P1P12() {
        if((_calzada[0] == 1) && (_calzada[4] == 1) && ((_calzada[6]-12) >= 0)){
            _calzada[0] = 0;
            _calzada[4] = 0;
            _calzada[5] = _calzada[5] + 12;
            _calzada[6] = _calzada[6] - 12;
            return true;
        }
        return false;
    }

    public boolean P3P6() {
        if((_calzada[1] == 1) && (_calzada[2] == 1) && ((_calzada[6]-6) >= 0)){
            _calzada[1] = 0;
            _calzada[2] = 0;
            _calzada[5] = _calzada[5] + 6;
            _calzada[6] = _calzada[6] - 6;
            return true;
        }
        return false;
    }

    public boolean P3P8() {
        if((_calzada[1] == 1) && (_calzada[3] == 1) && ((_calzada[6]-8) >= 0)){
            _calzada[1] = 0;
            _calzada[3] = 0;
            _calzada[5] = _calzada[5] + 8;
            _calzada[6] = _calzada[6] - 8;
            return true;
        }
        return false;
    }

    public boolean P3P12() {
        if((_calzada[1] == 1) && (_calzada[4] == 1) && ((_calzada[6]-12) >= 0)){
            _calzada[1] = 0;
            _calzada[4] = 0;
            _calzada[5] = _calzada[5] + 12;
            _calzada[6] = _calzada[6] - 12;
            return true;
        }
        return false;
    }

    public boolean P6P8() {
        if((_calzada[2] == 1) && (_calzada[3] == 1) && ((_calzada[6]-8) >= 0)){
            _calzada[2] = 0;
            _calzada[3] = 0;
            _calzada[5] = _calzada[5] + 8;
            _calzada[6] = _calzada[6] - 8;
            return true;
        }
        return false;
    }

    public boolean P6P12() {
        if((_calzada[2] == 1) && (_calzada[4] == 1) && ((_calzada[6]-12) >= 0)){
            _calzada[2] = 0;
            _calzada[4] = 0;
            _calzada[5] = _calzada[5] + 12;
            _calzada[6] = _calzada[6] - 12;
            return true;
        }
        return false;
    }

    public boolean P8P12() {
        if((_calzada[3] == 1) && (_calzada[4] == 1) && ((_calzada[6]-12) >= 0)){
            _calzada[3] = 0;
            _calzada[4] = 0;
            _calzada[5] = _calzada[5] + 12;
            _calzada[6] = _calzada[6] - 12;
            return true;
        }
        return false;
    }

}
