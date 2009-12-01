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
    }

    public HashMap<String, Integer> getOrilla() {
        return this._orilla;
    }

    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }*/

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    private boolean estadoValido(int pos) {

        boolean enc = false;

        try {

            if (_hojas.get(pos) == RANAS) {
                enc = ((_hojas.get(pos+1) == RANAS) || (_hojas.get(pos+1) == NADA));
            } else if (_hojas.get(pos) == SAPOS) {
                enc = ((_hojas.get(pos+1) == SAPOS) || (_hojas.get(pos+1) == NADA));
            }
        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.SEVERE, "Error al comprobar si es válido el movimiento desde la posicion" +
                    pos + " en el estado " + this.toString(), ex);
        }

        return enc;
    }

    

    /*boolean controlCiclos(HashMap<String, Integer> orilla) {
        return !((this._controlCiclos) && (this._recorrido.contains(orilla)));
    }*/

// </editor-fold>

    public boolean mover(int posicion) {
        int aux;
        boolean enc = false;
        
        try {
          /*  orilla = (HashMap<String, Integer>) _orilla.clone();

            if (estadoValido(lobos, ovejas) && !(estadoRiesgo(lobos, ovejas))) {

                if (orilla.get(CANOA) == 0) {

                    aux = _orilla.get(LOBOS) - lobos;
                    orilla.remove(LOBOS);
                    orilla.put(LOBOS, aux);

                    aux = orilla.get(OVEJAS) - ovejas;
                    orilla.remove(OVEJAS);
                    orilla.put(OVEJAS, aux);

                    orilla.remove(CANOA);
                    orilla.put(CANOA, 1);

                } else {

                    aux = orilla.get(LOBOS) + lobos;
                    orilla.remove(LOBOS);
                    orilla.put(LOBOS, aux);

                    aux = orilla.get(OVEJAS) + ovejas;
                    orilla.remove(OVEJAS);
                    orilla.put(OVEJAS, aux);

                    orilla.remove(CANOA);
                    orilla.put(CANOA, 0);
                }

                if (this.controlCiclos(orilla)) {
                    this._orilla = orilla;
                    this._recorrido.add(orilla);
                    ok = true;
                }
            }
*/
        } catch (Exception ex) {
            Logger.getLogger(RanasEstado.class.getName()).log(Level.SEVERE, "Error al mover " + _hojas.get(posicion).toString() + " en el estado " + this.toString(), ex);
        }

        return enc;
    }

    public boolean equals(Object o) {

        boolean enc = false;
        int i = 0;

        try {
            RanasEstado estado = (RanasEstado) o;
            while (!enc && i <_hojas.size())
                enc = (_hojas.get(i) == estado.getRecorrido().get(i));

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

    ArrayList getRecorrido() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setRecorrido(ArrayList recorrido) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
