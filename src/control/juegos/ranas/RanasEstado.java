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
        _hojas = new ArrayList();
        _controlCiclos = true;
    }

    public RanasEstado(boolean controlCiclos) {
        //Inicializar el arraylist
        _hojas = new ArrayList();
        _controlCiclos = controlCiclos;
    }

    RanasEstado(ArrayList estadoFinal) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    RanasEstado(RanasEstado estadoPadre) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*public OvejasLobosEstado(HashMap<String, Integer> orilla) {
        _orilla = orilla;
    }

    public OvejasLobosEstado(OvejasLobosEstado estado) {
        _orilla = estado._orilla;
        _recorrido = estado._recorrido;
        _controlCiclos = estado._controlCiclos;
    }*/
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
/*    public HashMap getEstadoInicial() {
        HashMap estadoInicial = new HashMap(3);

        estadoInicial.put(LOBOS, 3);
        estadoInicial.put(OVEJAS, 3);
        estadoInicial.put(CANOA, 0);

        return estadoInicial;
    }

    public void setEstado(OvejasLobosEstado estado) {
        _orilla.clear();
        _orilla.put(LOBOS, estado._orilla.get(LOBOS));
        _orilla.put(OVEJAS, estado._orilla.get(OVEJAS));
        _orilla.put(CANOA, estado._orilla.get(CANOA));
    }*/

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

    public boolean mover(int pos) {
        int aux;
        boolean enc = false;
        ArrayList hojas;
        
        try {
            hojas = (ArrayList) _hojas.clone();

            if (estadoValido(pos) != -1) {
                /*Tengo que quitar la rana/sapao de la posicion antigua
                y ponerla en la nueva */

                //control de ciclos
            }

        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.SEVERE, "Error al mover " + _hojas.get(pos).toString() + " en el estado " + this.toString(), ex);
        }

        return enc;
    }

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
