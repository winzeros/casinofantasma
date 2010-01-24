/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejasLobos;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa las propiedades del juego.
 * @author Alicia
 */
public class OvejasLobosEstado {

    /**
     * HashMap donde almacenaremos los lobos y ovejas que hay en la orilla
     * izquierda asi como el lugar donde se encuentra la canoa.
     */
    private HashMap<String, Integer> _orilla;
    /**
     * ArrayList donde vamos a ir guardando el recorrido por el arbol de busqueda.
     */
    private ArrayList _recorrido;
    /**
     * Booleano que usaremos para no permitir los ciclos.
     */
    private boolean _controlCiclos;
    /**
     * String que representa a los lobos.
     */
    public static final String LOBOS = "L";
    /**
     * String que representa las ovejas.
     */
    public static final String OVEJAS = "O";
    /**
     * String que representa a la canoa.
     */
    public static final String CANOA = "C";
    /**
     * Hora inicial del juego.
     */
    public static long horaInicial;

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">

    /**
     * Constructor por defecto.
     */
    public OvejasLobosEstado() {
        _orilla = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_orilla);
        _controlCiclos = true;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    /**
     * Constructor.
     * @param controlCiclos
     */
    public OvejasLobosEstado(boolean controlCiclos) {
        _orilla = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_orilla);
        _controlCiclos = controlCiclos;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    /**
     * Constructor.
     * @param orilla
     */
    public OvejasLobosEstado(HashMap<String, Integer> orilla) {
        _orilla = orilla;
    }

    /**
     * Constructor de copia.
     * @param estado
     */
    public OvejasLobosEstado(OvejasLobosEstado estado) {
        _orilla = estado._orilla;
        _recorrido = estado._recorrido;
        _controlCiclos = estado._controlCiclos;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">

    /**
     * Metodo que inicializa el HashMap.
     * @return estadoInicial
     */
    public HashMap getEstadoInicial() {
        HashMap estadoInicial = new HashMap(3);

        estadoInicial.put(LOBOS, 3);
        estadoInicial.put(OVEJAS, 3);
        estadoInicial.put(CANOA, 0);

        return estadoInicial;
    }

    /**
     * Metodo que actualiza el estado del juego.
     * @param estado
     */
    public void setEstado(OvejasLobosEstado estado) {
        _orilla.clear();
        _orilla.put(LOBOS, estado._orilla.get(LOBOS));
        _orilla.put(OVEJAS, estado._orilla.get(OVEJAS));
        _orilla.put(CANOA, estado._orilla.get(CANOA));
    }

    /**
     * Metodo que devuelve el HashMap que representa la orilla.
     * @return _orilla
     */
    public HashMap<String, Integer> getOrilla() {
        return this._orilla;
    }

    /**
     * Metodo que devuelve el ArrayList que representa el recorrido.
     * @return
     */
    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    /**
     * Metodo que actualiza el recorrido.
     * @param recorrido
     */
    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">

    /**
     * Metodo que devuelve si el estado alcanzado se corresonde con un estado
     * valido para el juego.
     * @param lobos
     * @param ovejas
     * @return ok
     */
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
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.ERROR, "Error al comprobar si es válido el movimiento "
                    + "(" + lobos + "," + ovejas + ") en el estado " + this.toString(), ex);
        }

        return ok;
    }

    /**
     * Metodo que devuelve si el estado alcanzado se corresonde con un estado
     * de riesgo para el juego.
     * @param lobos
     * @param ovejas
     * @return
     */
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
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.ERROR, "Error al comprobar si es un estado de riesgo el movimiento "
                    + "(" + lobos + "," + ovejas + ") en el estado " + this.toString(), ex);
        }
        return ok;
    }

    /**
     * Metodo utilizado para no permitir los ciclos en el juego.
     * @param orilla
     * @return
     */
    boolean controlCiclos(HashMap<String, Integer> orilla) {
        return !((this._controlCiclos) && (this._recorrido.contains(orilla)));
    }

// </editor-fold>

    /**
     * Metodo que devuelve si se ha podido ejecutar el movimiento entre
     * ambas orillas.
     * @param lobos
     * @param ovejas
     * @return
     */
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
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.ERROR,
                    "Error al mover (" + lobos + "," + ovejas + ") en el estado " + this.toString(), ex);
        }

        return ok;
    }

    @Override
    public boolean equals(Object o) {

        boolean ok = false;

        try {
            OvejasLobosEstado estado = (OvejasLobosEstado) o;
            ok = ((estado._orilla.get(LOBOS) == _orilla.get(LOBOS))
                    && (estado._orilla.get(OVEJAS) == _orilla.get(OVEJAS))
                    && (estado._orilla.get(CANOA) == _orilla.get(CANOA)));

        } catch (Exception ex) {
            Logger.getLogger(OvejasLobosEstado.class.getName()).log(Level.ERROR,
                    "Error al comparar " + this.toString() + " con " + o.toString(), ex);
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
