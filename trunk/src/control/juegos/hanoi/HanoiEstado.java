/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.hanoi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class HanoiEstado {

    private int[][] _tablero;
    private HashMap<Integer,Integer> _posible;
    private ArrayList _recorrido;
    private boolean _controlCiclos;

// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public HanoiEstado() {
        _tablero = getEstadoInicial();
        _posible = new HashMap();
        _posible.put(0,1);
        _posible.put(1,10);
        _posible.put(2,10);
        _recorrido = new ArrayList();
        _recorrido.add(_tablero);
        _controlCiclos = true;
    }

    public HanoiEstado(boolean controlCiclos) {
        _tablero = getEstadoInicial();
        _recorrido = new ArrayList();
        _posible = new HashMap();
        _posible.put(0,1);
        _posible.put(1,10);
        _posible.put(2,10);
        _recorrido.add(_tablero);
        _controlCiclos = controlCiclos;
    }

    public HanoiEstado(int[][] tablero) {
        _tablero = tablero;
    }

    public HanoiEstado(HanoiEstado estado) {
        _tablero = new int[][] {
            estado._tablero[0].clone(),
            estado._tablero[1].clone(),
            estado._tablero[2].clone(),
        };
        
        _posible = (HashMap<Integer, Integer>) estado._posible.clone();
        _recorrido = (ArrayList) estado._recorrido;
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

    HashMap<Integer,Integer> getPosibles() {
        return _posible;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }

    

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    private boolean puedeMoverse(int disco, int palo) {

        boolean enc = false;

        if (_posible.get(0) == disco) {
            if (palo == 0)
                enc = false;
            else if (disco < _posible.get(palo))//Muevo disco de 0 a palo
                enc = mueveDisco(disco, 0, palo);
        }
        else if (_posible.get(1) == disco) {
            if (palo == 1)
                enc = false;
            else if (disco < _posible.get(palo)) //Muevo disco de 0 a palo
                enc = mueveDisco(disco, 1, palo);
        }
        else if (_posible.get(2) == disco) {
            if (palo == 2)
                enc = false;
            else if (disco < _posible.get(palo)) //Muevo disco de 0 a palo
                enc = mueveDisco(disco, 2, palo);
        }
        return enc;
    }

    boolean esta (int[][] tablero) {
        //devuelve true si el tablero esta en recorrido
        for(int i = 0; i < _recorrido.size(); i++) {
            int[][] tableroAntiguo = (int[][]) _recorrido.get(i);
            boolean iguales = true;
            for(int f = 0; f < 3; f++)
                for(int c = 0; c < 3; c++)
                    if(tableroAntiguo[f][c] != _tablero[f][c])
                        iguales = false;
            if(iguales)
                return true;
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
        if (this._tablero != other._tablero && (this._tablero == null || !Arrays.deepEquals(_tablero, other._tablero) )) {
            return false;
        }
        /*if (this._posible != other._posible && (this._posible == null || !this._posible.equals(other._posible))) {
            return false;
        }*/
        return true;
    }

/*
    @Override
        public boolean equals(Object o) {
        if ((HanoiEstado) o == this) return true;
        if(o.getClass() == HanoiEstado.class){
            return Arrays.equals(((HanoiEstado)o)._tablero,this._tablero);
        } else return false;
        }
*/

// </editor-fold>

    public boolean mover(int disco, int palo) {
        boolean res = false;

        try {
            if (puedeMoverse(disco,palo)) {
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

    private boolean mueveDisco(int disco, int origen, int destino) {

        boolean res1 = false;
        boolean res2 = false;

        if (_tablero[origen][2] == disco){
            _tablero[origen][2] = 0;
            _posible.put(origen, _tablero[origen][1]);
            res1 = true;
        }else if (_tablero[origen][1] == disco) {
            _tablero[origen][1] = 0;
            _posible.put(origen, _tablero[origen][0]);
            res1 = true;
        } else {
            _tablero[origen][0] = 0;
            _posible.put(origen, 10);
            res1 = true;
        }

        if (_tablero[destino][0] == 0){
            _tablero[destino][0] = disco;
            res2 = true;
        }else if (_tablero[destino][1] == 0){
            _tablero[destino][1] = disco;
            res2 = true;
        }else {
            _tablero[destino][2] = disco;
            res2 = true;
        }

        _posible.put(destino, disco);

        return res1 && res2;
    }


    @Override
    public String toString() {
        String resultado = "·%%/(·!·$\n\n\n";
        
        return resultado;
    }



}