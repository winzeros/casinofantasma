/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.hanoi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa las propiedades del juego.
 * @author Laura
 */
public class HanoiEstado {

    /**
     * Matriz bidimensional que representa el tablero del
     * juego que representa los palos.
     */
    private int[][] _tablero;
    /**
     * HashMap donde almaceno los discos que puedo mover de cada palo.
     */
    private HashMap<Integer, Integer> _posible;
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
    public HanoiEstado() {
        _tablero = getEstadoInicial();
        _posible = new HashMap();
        _posible.put(0, 1);
        _posible.put(1, 10);
        _posible.put(2, 10);
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = true;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    /**
     * Constructor parametrizado.
     * @param controlCiclos
     */
    public HanoiEstado(boolean controlCiclos) {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _posible = new HashMap();
        _posible.put(0, 1);
        _posible.put(1, 10);
        _posible.put(2, 10);
        _recorrido.add(_tablero);
        _controlCiclos = controlCiclos;
    }

    /**
     * Constructor parametrizado.
     * @param tablero
     */
    public HanoiEstado(int[][] tablero) {
        _tablero = tablero;
    }

    /**
     * Constructor de copia.
     * @param estado
     */
    public HanoiEstado(HanoiEstado estado) {
        _tablero = new int[][]{
                    estado._tablero[0].clone(),
                    estado._tablero[1].clone(),
                    estado._tablero[2].clone(),};

        _posible = (HashMap<Integer, Integer>) estado._posible.clone();
        _recorrido = (ArrayList) estado._recorrido;
        _controlCiclos = estado._controlCiclos;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">

    /**
     * Metodo que inicializa el tablero y los discos susceptibles
     * de movimiento.
     * @return
     */
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

    /**
     * Metodo que actualiza el estado del juego.
     * @param estado
     */
    public void setEstado(HanoiEstado estado) {
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    _tablero[i][j] = estado._tablero[i][j];
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HanoiEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

    /**
     * Metodo que devuelve la matriz que representa el tablero.
     * @return _tablero
     */
    public int[][] getTablero() {
        return this._tablero;
    }

    /**
     * Metodo que devuelve el ArrayList que representa el recorrido.
     * @return _recorrido
     */
    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    /**
     * Metodo que devuelve el HashMap que representa las posibilidades
     * de movimiento.
     * @return _posibles
     */
    HashMap<Integer, Integer> getPosibles() {
        return _posible;
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
     * Metodo que devuelve si el disco puede moverse al palo.
     * @param disco
     * @param palo
     * @return enc
     */
    private boolean puedeMoverse(int disco, int palo) {

        boolean enc = false;

        if (_posible.get(0) == disco) {
            if (palo == 0) {
                enc = false;
            } else if (disco < _posible.get(palo))//Muevo disco de 0 a palo
            {
                enc = mueveDisco(disco, 0, palo);
            }
        } else if (_posible.get(1) == disco) {
            if (palo == 1) {
                enc = false;
            } else if (disco < _posible.get(palo)) //Muevo disco de 0 a palo
            {
                enc = mueveDisco(disco, 1, palo);
            }
        } else if (_posible.get(2) == disco) {
            if (palo == 2) {
                enc = false;
            } else if (disco < _posible.get(palo)) //Muevo disco de 0 a palo
            {
                enc = mueveDisco(disco, 2, palo);
            }
        }
        return enc;
    }

    /**
     * Metodo que devuelve si el tablero esta en el recorrido.
     * @param tablero
     * @return
     */
    boolean esta(int[][] tablero) {
        for (int i = 0; i < _recorrido.size(); i++) {
            int[][] tableroAntiguo = (int[][]) _recorrido.get(i);
            boolean iguales = true;
            for (int f = 0; f < 3; f++) {
                for (int c = 0; c < 3; c++) {
                    if (tableroAntiguo[f][c] != _tablero[f][c]) {
                        iguales = false;
                    }
                }
            }
            if (iguales) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HanoiEstado other = (HanoiEstado) obj;
        if (this._tablero != other._tablero && (this._tablero == null || !Arrays.deepEquals(_tablero, other._tablero))) {
            return false;
        }
        return true;
    }

// </editor-fold>

    /**
     * Devuelve si el disco se ha movido al palo.
     * @param disco
     * @param palo
     * @return res
     */
    public boolean mover(int disco, int palo) {
        boolean res = false;

        try {
            if (puedeMoverse(disco, palo)) {
                if (!esta(_tablero)) {
                    _recorrido.add(_tablero);
                    res = true;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HanoiEstado.class.getName()).log(Level.ERROR, "Error al ejecutar la operacion " + disco, ex);
        }
        return res;
    }

    /**
     * Metodo que ejecuta el movimiento del disco entre el palo origen
     * y el palo destino.
     * @param disco
     * @param origen
     * @param destino
     * @return res1 && res2
     */
    private boolean mueveDisco(int disco, int origen, int destino) {

        boolean res1 = false;
        boolean res2 = false;

        if (_tablero[origen][2] == disco) {
            _tablero[origen][2] = 0;
            _posible.put(origen, _tablero[origen][1]);
            res1 = true;
        } else if (_tablero[origen][1] == disco) {
            _tablero[origen][1] = 0;
            _posible.put(origen, _tablero[origen][0]);
            res1 = true;
        } else {
            _tablero[origen][0] = 0;
            _posible.put(origen, 10);
            res1 = true;
        }

        if (_tablero[destino][0] == 0) {
            _tablero[destino][0] = disco;
            res2 = true;
        } else if (_tablero[destino][1] == 0) {
            _tablero[destino][1] = disco;
            res2 = true;
        } else {
            _tablero[destino][2] = disco;
            res2 = true;
        }

        _posible.put(destino, disco);

        return res1 && res2;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = _tablero.length - 1; i > -1; i--) {
            for (int j = 0; j < _tablero.length; j++) {
                switch (_tablero[j][i]) {
                    case 0:
                        resultado += "   |   ";
                        break;
                    case 1:
                        resultado += "   =   ";
                        break;
                    case 2:
                        resultado += "  ===  ";
                        break;
                    case 3:
                        resultado += " ===== ";
                        break;
                }
            }
            resultado += "\n";
        }
        return resultado += "----------------------";
    }
}
