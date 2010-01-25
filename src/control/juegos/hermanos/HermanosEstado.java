/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.hermanos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa las propiedades del juego.
 * @author Alicia
 */
public class HermanosEstado {

    /**
     * Array que representa la mesa donde se sentaran los hermanos a comer.
     */
    private int[] _mesa;
    /**
     * ArrayList donde vamos a ir guardando el recorrido por el arbol
     * de busqueda.
     */
    private ArrayList _recorrido;
    /**
     * Booleano que usaremos para no permitir los ciclos.
     */
    private boolean _controlCiclos;
    /**
     * Hora inicial del juego.
     */
    public static long horaInicial;

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">

    /**
     * Constructor por defecto.
     */
    public HermanosEstado() {
        _mesa = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_mesa);
        _controlCiclos = true;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    /**
     * Constructor parametrizado.
     * @param controlCiclos
     */
    public HermanosEstado(boolean controlCiclos) {
        _mesa = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_mesa);
        _controlCiclos = controlCiclos;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    /**
     * Constructor parametrizado.
     * @param mesa
     * @throws Exception
     */
    public HermanosEstado(int[] mesa) throws Exception {

        if (mesa.length == 6) {
            _mesa = getEstadoInicial();
            try {
                for (int i = 0; i < mesa.length; i++) {
                    _mesa[i] = mesa[i];
                }
            } catch (Exception ex) {
                Logger.getLogger(HermanosEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
            }
        } else {
            throw new Exception("La mesa solo debe tener 6 asientos");
        }

    }

    /**
     * Constructor de copia.
     * @param estado
     */
    public HermanosEstado(HermanosEstado estado) {

        try {
            _mesa = getEstadoInicial();
            for (int i = 0; i < estado._mesa.length; i++) {
                _mesa[i] = estado._mesa[i];
            }
            _recorrido = estado._recorrido;
            _controlCiclos = estado._controlCiclos;
        } catch (Exception ex) {
            Logger.getLogger(HermanosEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">

    /**
     * Metodo que inicializa la mesa.
     * @return
     */
    public int[] getEstadoInicial() {
        int[] estadoInicial = new int[6];

        estadoInicial[0] = 1;
        estadoInicial[1] = 0;
        estadoInicial[2] = 0;
        estadoInicial[3] = 0;
        estadoInicial[4] = 0;
        estadoInicial[5] = 0;

        return estadoInicial;
    }

    /**
     * Metodo que actualiza el estado del juego.
     * @param estado
     */
    public void setEstado(HermanosEstado estado) {

        try {
            for (int i = 0; i < estado._mesa.length; i++) {
                _mesa[i] = estado._mesa[i];
            }
        } catch (Exception ex) {
            Logger.getLogger(HermanosEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

    /**
     * Metodo que devuelve el array que representa la mesa.
     * @return
     */
    public int[] getMesa() {
        return this._mesa;
    }

    /**
     * Metodo que devuelve el ArrayList que representa el recorrido.
     * @return _recorrido
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
     * MEtodo que devuelve si un hermano puede sentarse en esa posicion.
     * @param hermano
     * @param posicion
     * @return ok
     */
    public boolean estadoValido(int hermano, int posicion) {

        boolean ok = true;
        int posicionIzq, posicionDer;
        int i = 0;

        try {

            //Compruebo si ya está sentado
            while ((ok == true) && (i < 6)) {
                if (_mesa[i] == hermano) {
                    ok = false;
                }
                i++;
            }

            //Si no está sentado...
            if (ok) {
                ok = false;
                //Calculo la posición de los hermanos que se sientan al lado
                if (posicion == 0) {
                    posicionIzq = 5;
                    posicionDer = 1;
                } else if (posicion == 5) {
                    posicionIzq = 4;
                    posicionDer = 0;
                } else {
                    posicionIzq = posicion - 1;
                    posicionDer = posicion + 1;
                }
                //si no hay nadie sentado en ese sitio...
                if (_mesa[posicion] == 0) {
                    //si no tengo a un hermano inválido a los lados...
                    if ((_mesa[posicionIzq] != (hermano - 1)) && (_mesa[posicionDer] != (hermano - 1))
                            && (_mesa[posicionIzq] != (hermano + 1)) && (_mesa[posicionDer] != (hermano + 1))) {
                        if (!((hermano == 3) && ((_mesa[posicionIzq] == 5) || (_mesa[posicionDer] == 5)))
                                && !((hermano == 5) && ((_mesa[posicionIzq] == 3) || (_mesa[posicionDer] == 3)))) {
                            ok = true;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosEstado.class.getName()).log(Level.ERROR, "Error al comprobar si es válido sentar al hermano "
                    + hermano + " en la posicion " + posicion, ex);
        }

        return ok;
    }

    /**
     * Metodo que devuelve si la mesa esta en el recorrido.
     * @param mesa
     * @return
     */
    boolean controlCiclos(int[] mesa) {
        return !((this._controlCiclos) && (this._recorrido.contains(mesa)));
    }

// </editor-fold>

    /**
     * Devuelve si el hermano se ha sentado en la posicion.
     * @param hermano
     * @param posicion
     * @return ok
     */
    public boolean sentar(int hermano, int posicion) {

        boolean ok = false;

        try {
            if (estadoValido(hermano, posicion)) {
                _mesa[posicion] = hermano;
                if (this.controlCiclos(_mesa)) {
                    _recorrido.add(_mesa);
                    ok = true;
                } else {
                    _mesa[posicion] = 0;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(HermanosEstado.class.getName()).log(Level.ERROR, "Error al sentar al hermano " + hermano
                    + " en la posición " + posicion, ex);
        }

        return ok;
    }

    @Override
    public boolean equals(Object o) {
        return Arrays.equals((int[]) o, _mesa);
    }

    @Override
    public String toString() {

        String resultado;

        resultado = "    " + _mesa[0] + "\n";
        resultado += " " + _mesa[5] + " / \\ " + _mesa[1] + "\n";
        resultado += " " + _mesa[4] + " \\ / " + _mesa[2] + "\n";
        resultado += "    " + _mesa[3] + "\n";

        return resultado;
    }
}

