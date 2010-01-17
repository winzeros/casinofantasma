/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ranas;

import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class RanasEstado {

    private String[] _hojas;
    private ArrayList _recorrido;
    private boolean _controlCiclos;
    public static final String RANA = "$";
    public static final String SAPO = "*";
    public static final String NADA = "_";

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public RanasEstado() {
        _hojas = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_hojas);
        _controlCiclos = true;
    }

    public RanasEstado(boolean controlCiclos) {
        _hojas = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_hojas);
        _controlCiclos = controlCiclos;
    }

    public RanasEstado(String[] hojas) throws Exception {

        if (hojas.length == 7) {
            _hojas = getEstadoInicial();
            try {
                for (int i = 0; i < hojas.length; i++) {
                    _hojas[i] = hojas[i];
                }
            } catch (Exception ex) {
                Logger.getLogger(RanasEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
            }
        } else {
            throw new Exception("Solo hay 7 hojas");
        }
    }

    public RanasEstado(RanasEstado estado) {

        try {
            _hojas = getEstadoInicial();
            for (int i = 0; i < estado._hojas.length; i++) {
                _hojas[i] = estado._hojas[i];
            }
            _recorrido = estado._recorrido;
            _controlCiclos = estado._controlCiclos;
        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    public String[] getEstadoInicial() {
        String[] estadoInicial = new String[7];

        estadoInicial[0] = RANA;
        estadoInicial[1] = RANA;
        estadoInicial[2] = RANA;
        estadoInicial[3] = NADA;
        estadoInicial[4] = SAPO;
        estadoInicial[5] = SAPO;
        estadoInicial[6] = SAPO;

        return estadoInicial;
    }

    public void setEstado(RanasEstado estado) {
        try {
            for (int i = 0; i < estado._hojas.length; i++) {
                _hojas[i] = estado._hojas[i];
            }
        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

    public String[] getHojas() {
        return this._hojas;
    }

    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    private int estadoValido(int pos) {

        int res = -1;

        try {

            if (_hojas[pos] == RANA) {
                if (pos <= 5 && _hojas[pos + 1] == NADA) {
                    res = pos + 1;
                } else if (pos <= 4 && _hojas[pos + 2] == NADA) {
                    res = pos + 2;
                }
            } else if (_hojas[pos] == SAPO) {
                if (pos >= 1 && _hojas[pos - 1] == NADA) {
                    res = pos - 1;
                } else if (pos >= 2 && _hojas[pos - 2] == NADA) {
                    res = pos - 2;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.ERROR, "Error al comprobar si es válido el movimiento desde la posicion" +
                    pos + " en el estado " + this.toString(), ex);
        }

        return res;
    }

    boolean controlCiclos(String[] hojas) {
        return !((this._controlCiclos) && (this._recorrido.contains(hojas)));
    }
// </editor-fold>

    public boolean mover(int pos) {
        int aux;
        boolean enc = false;

        try {
           
            if (estadoValido(pos) != -1) {
                aux = estadoValido(pos);
                if (this.getHojas()[pos] == "$") {
                    this._hojas[aux] =RANA;
                    this._hojas[pos] = NADA;
                    enc = true;
                } else if (this.getHojas()[pos] == "*") {
                    this._hojas[aux] = SAPO;
                    this._hojas[pos] = NADA;
                    enc = true;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.ERROR, 
                    "Error al mover " + _hojas[pos].toString() + " en el estado " + this.toString(), ex);
        }

        return enc;
    }

    @Override
    public boolean equals(Object o) {
        
        boolean enc = true;
        int i = 0;

        try {
            RanasEstado estado = (RanasEstado) o;
            while (enc && i < 7) {
                enc = (_hojas[i] == estado.getHojas()[i]);
                i++;
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.ERROR, "Error al comparar " + this.toString() + " con " + o.toString(), ex);
        }

        return enc;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < 7; i++) {
            //resultado += " " + _hojas[i].toString() + " ";
            if (_hojas[i].equals(SAPO)) {
                resultado += " >o)";
            }
            else if (_hojas[i].equals(RANA)) {
                resultado += " (o<";
            } else {
                resultado += "    ";
            }
        }
        resultado += "\n --- --- --- --- --- --- --- \n";
        return resultado;
    }
}
