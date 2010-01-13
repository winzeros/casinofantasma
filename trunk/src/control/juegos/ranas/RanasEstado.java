/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ranas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class RanasEstado {

    private ArrayList _hojas;
    private boolean _controlCiclos;
    public static final String RANAS = "$";
    public static final String SAPOS = "*";
    public static final String NADA = "_";

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public RanasEstado() {
        _hojas = new ArrayList(7);
        _controlCiclos = true;
        _hojas.add(0,RANAS);
        _hojas.add(1,RANAS);
        _hojas.add(2,RANAS);
        _hojas.add(3,NADA);
        _hojas.add(4,SAPOS);
        _hojas.add(5,SAPOS);
        _hojas.add(6,SAPOS);
    }

    public RanasEstado(boolean controlCiclos) {
        _hojas = new ArrayList(7);
        _controlCiclos = controlCiclos;
        _hojas.add(0,RANAS);
        _hojas.add(1,RANAS);
        _hojas.add(2,RANAS);
        _hojas.add(3,NADA);
        _hojas.add(4,SAPOS);
        _hojas.add(5,SAPOS);
        _hojas.add(6,SAPOS);
    }

    RanasEstado(ArrayList estadoFinal) {
        _hojas = estadoFinal;
    }

    RanasEstado(RanasEstado estadoPadre) {
        _hojas = estadoPadre._hojas;
        _controlCiclos = estadoPadre._controlCiclos;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    public ArrayList getEstadoInicial() {
        ArrayList estadoInicial = new ArrayList(7);

        estadoInicial.add(0,RANAS);
        estadoInicial.add(1,RANAS);
        estadoInicial.add(2,RANAS);
        estadoInicial.add(3,NADA);
        estadoInicial.add(4,SAPOS);
        estadoInicial.add(5,SAPOS);
        estadoInicial.add(6,SAPOS);

        return estadoInicial;
    }

    public void setEstado(RanasEstado estado) {
        _hojas.clear();
        _hojas.add(estado._hojas);

    }

    public ArrayList getHojas() {
        return this._hojas;
    }

    public void setHojas(ArrayList hojas) {
        this._hojas = hojas;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    private int estadoValido(int pos) {

        int res = -1;

        try {

            if (_hojas.get(pos) == RANAS) {
                if (_hojas.get(pos+1) == NADA)
                    res = pos + 1;
                else if (_hojas.get(pos+2) == NADA)
                    res =pos + 2;
            } else if (_hojas.get(pos) == SAPOS) {
                if (_hojas.get(pos-1) == NADA)
                    res = pos - 1;
                else if (_hojas.get(pos-2) == NADA)
                    res = pos - 2;
            }
        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.SEVERE, "Error al comprobar si es válido el movimiento desde la posicion" +
                    pos + " en el estado " + this.toString(), ex);
        }

        return res;
    }

    

    /*boolean controlCiclos(HashMap<String, Integer> orilla) {
        return !((this._controlCiclos) && (this._recorrido.contains(orilla)));
    }*/

// </editor-fold>

    public boolean mover(int pos,String tipo) {
        int aux;
        boolean enc = false;
        ArrayList hojas;
        
        try {
            hojas = (ArrayList) _hojas.clone();

            if (estadoValido(pos) != -1) {
                aux = estadoValido(pos);
                char tip = hojas.get(pos).toString().substring(0, 1).charAt(1);
                switch(tip) {
                    case 'r' : {hojas.set(aux, RANAS);
                                hojas.set(pos,NADA);
                                break;}
                    case 's' : {hojas.set(aux, SAPOS);
                                hojas.set(pos,NADA); 
                                break;}
                    default: //error
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.SEVERE, "Error al mover " + _hojas.get(pos).toString() + " en el estado " + this.toString(), ex);
        }

        return enc;
    }

    @Override
    public boolean equals(Object o) {

        boolean enc = false;
        int i = 0;

        try {
            RanasEstado estado = (RanasEstado) o;
            while (!enc && i <_hojas.size())
                enc = (_hojas.get(i) == estado.getHojas().get(i));

        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.SEVERE, "Error al comparar " + this.toString() + " con " + o.toString(), ex);
        }

        return enc;
    }

    @Override
    public String toString() {

        String resultado = "";
          
        for (int i=1;i<_hojas.size();i++) {
            resultado += " " + _hojas.get(i).toString() + " "; 
        }

        return resultado;
    }

}
