/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alicia
 */
public class OvejasLobosEstado {

    private HashMap<String, Integer> _orilla;
    private ArrayList _recorrido;
    private boolean _controlCiclos;
    public static final String LOBOS = "L";
    public static final String OVEJAS = "O";
    public static final String CANOA = "C";
    public static long horaInicial;

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public OvejasLobosEstado() {
        _orilla = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_orilla);
        _controlCiclos = true;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    public OvejasLobosEstado(boolean controlCiclos) {
        _orilla = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_orilla);
        _controlCiclos = controlCiclos;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    public OvejasLobosEstado(HashMap<String, Integer> orilla) {
        _orilla = orilla;
    }

    public OvejasLobosEstado(OvejasLobosEstado estado) {
        _orilla = estado._orilla;
        _recorrido = estado._recorrido;
        _controlCiclos = estado._controlCiclos;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    public HashMap getEstadoInicial() {
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
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    private boolean estadoValido(int lobos, int ovejas) {

        boolean ok = false;

        try {

            if (_orilla.get(CANOA) == 0) {
                ok = (((lobos + ovejas) < 3)
                        && ((lobos + ovejas) > 0)
                        && ((_orilla.get(LOBOS) - lobos) >= 0)
                        && ((_orilla.get(OVEJAS) - ovejas) >= 0));
            } else {
                ok = (((lobos + ovejas) < 3)
                        && ((lobos + ovejas) > 0)
                        && ((3 - _orilla.get(LOBOS) - lobos) >= 0)
                        && ((3 - _orilla.get(OVEJAS) - ovejas) >= 0));
            }
        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.SEVERE, "Error al comprobar si es válido el movimiento "
                    + "(" + lobos + "," + ovejas + ") en el estado " + this.toString(), ex);
        }

        return ok;
    }

    private boolean estadoRiesgo(int lobos, int ovejas) {

        boolean ok = false;

        try {

            if (_orilla.get(CANOA) == 0) {
                ok = ((((_orilla.get(LOBOS) - lobos) > (_orilla.get(OVEJAS) - ovejas)
                        && (_orilla.get(OVEJAS) - ovejas) != 0))
                        || ((_orilla.get(LOBOS) - lobos) < (_orilla.get(OVEJAS) - ovejas)
                        && ((_orilla.get(OVEJAS) - ovejas) != 0) && ((_orilla.get(OVEJAS) - ovejas) != 3)));
            } else {
                ok = ((((_orilla.get(LOBOS) + lobos) > (_orilla.get(OVEJAS) + ovejas)
                        && (_orilla.get(OVEJAS) - ovejas) != 0))
                        || ((_orilla.get(LOBOS) + lobos) < (_orilla.get(OVEJAS) + ovejas)
                        && ((_orilla.get(OVEJAS) + ovejas) != 0) && ((_orilla.get(OVEJAS) + ovejas) != 3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.SEVERE, "Error al comprobar si es un estado de riesgo el movimiento "
                    + "(" + lobos + "," + ovejas + ") en el estado " + this.toString(), ex);
        }
        return ok;
    }

    boolean controlCiclos(HashMap<String, Integer> orilla) {
        return !((this._controlCiclos) && (this._recorrido.contains(orilla)));
    }

// </editor-fold>
    public boolean mover(int lobos, int ovejas) {
        int aux;
        boolean ok = false;
        HashMap<String, Integer> orilla;

        try {
            orilla = (HashMap<String, Integer>) _orilla.clone();

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

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.SEVERE, "Error al mover (" + lobos + "," + ovejas + ") en el estado " + this.toString(), ex);
        }

        return ok;
    }

    public boolean equals(Object o) {

        boolean ok = false;

        try {
            OvejasLobosEstado estado = (OvejasLobosEstado) o;
            ok = ((estado._orilla.get(LOBOS) == _orilla.get(LOBOS))
                    && (estado._orilla.get(OVEJAS) == _orilla.get(OVEJAS))
                    && (estado._orilla.get(CANOA) == _orilla.get(CANOA)));

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.SEVERE, "Error al comparar " + this.toString() + " con " + o.toString(), ex);
        }

        return ok;
    }

    @Override
    public String toString() {
        String resultado = "";
        String canoa = "";
        String rio = " |         | ";

        if (_orilla.get(CANOA) == 0) {
            canoa = "       |<__>     |\n";
        } else {
            canoa = "       |     <__>|\n";
        }

        resultado += "\n";
        resultado += " " + LOBOS + ":  " + _orilla.get(LOBOS) + rio + LOBOS + ":  " + (3 - _orilla.get(LOBOS)) + "\n";
        resultado += canoa;
        resultado += " " + OVEJAS + ":  " + _orilla.get(OVEJAS) + rio + OVEJAS + ":  " + (3 - _orilla.get(OVEJAS)) + "\n";
        resultado += "\n";

        return resultado;
    }
}
