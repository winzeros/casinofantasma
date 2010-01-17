/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.monoBanana;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Laura
 */
public class MonoBananaEstado {

    private int[] _habitacion;
    /*
     * POSICION DEL MONO EN LA HABITACION
     *     0: puerta
     *     1: centro
     *     2: ventana
     * POSICION DEL MONO RESPECTO A LA CAJA
     *     0: suelo
     *     1: caja
     * POSICION DE LA CAJA EN LA HABITACION
     *     0: puerta
     *     1: centro
     *     2: ventana
     * POSESION DEL PLATANO
     *     0: lo_tiene
     *     1: no_lo_tiene
     */
    private ArrayList _recorrido;
    private boolean _controlCiclos;


// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public MonoBananaEstado() {
        _habitacion = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_habitacion);
        _controlCiclos = true;
    }

    public MonoBananaEstado(boolean controlCiclos) {
        _habitacion = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_habitacion);
        _controlCiclos = controlCiclos;
    }

    public MonoBananaEstado(int[] habitacion) throws Exception {

        if (habitacion.length == 4) {
            _habitacion = getEstadoInicial();
            try {
                for (int i = 0; i < habitacion.length; i++) {
                    _habitacion[i] = habitacion[i];
                }
            } catch (Exception ex) {
                Logger.getLogger(MonoBananaEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
            }
        } else {
            throw new Exception("Solo hay cuatro caracteristicas");
        }

    }

    public MonoBananaEstado(MonoBananaEstado estado) {

        try {
            _habitacion = getEstadoInicial();
            for (int i = 0; i < estado._habitacion.length; i++) {
                _habitacion[i] = estado._habitacion[i];
            }
            _recorrido = estado._recorrido;
            _controlCiclos = estado._controlCiclos;
        } catch (Exception ex) {
            Logger.getLogger(MonoBananaEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    public int[] getEstadoInicial() {
        int[] habitacion = new int[4];

        habitacion[0] = 0; //Mono en la puerta
        habitacion[1] = 0; //Caja en el suelo
        habitacion[2] = 2; //Caja en la ventana
        habitacion[3] = 1; //No tiene el platano

        return habitacion;
    }

    public void setEstado(MonoBananaEstado estado) {

        try {
            for (int i = 0; i < estado._habitacion.length; i++) {
                _habitacion[i] = estado._habitacion[i];
            }
        } catch (Exception ex) {
            Logger.getLogger(MonoBananaEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

    public int[] getHabitacion() {
        return this._habitacion;
    }

    public ArrayList getRecorrido() {
        return this._recorrido;
    }

    public void setRecorrido(ArrayList recorrido) {
        this._recorrido = recorrido;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="CONTROL DE ESTADOS">
    public boolean puedeMoverse(int operacion, int[] habitacion) {

        boolean res = true;

        try {
            switch (operacion) {
                case 1: //Andar
                    andar(habitacion);
                    break;
                case 2: //Empujar_caja
                    empujarCaja(habitacion);
                    break;
                case 3: //Subir_caja
                    SubirCaja(habitacion);
                    break;
                case 4: //Bajar_caja
                    BajarCaja(habitacion);
                    break;
                case 5: //Coger_platano
                    CogerPlatano(habitacion);
                    break;
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaEstado.class.getName()).log(Level.ERROR, 
                    "Error al comprobar si es válida la operacion " + operacion, ex);
        }

        return res;
    }

    boolean controlCiclos(int[] habitacion) {
        return !((this._controlCiclos) && (this._recorrido.contains(habitacion)));
    }

// </editor-fold>

    public boolean mover(int operacion) {
        boolean res = false;

        try {
            if (puedeMoverse(operacion, _habitacion)) {
                if (this.controlCiclos(_habitacion)) {
                    _recorrido.add(_habitacion);
                    res = true;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MonoBananaEstado.class.getName()).log(Level.ERROR, "Error al ejecutar la operacion " + operacion, ex);
        }
        return res;
    }


    /*
     * OPERACIONES DEL MONO
     */
    //Operacion 1, ANDAR
    public int[] andar(int[] estado) {
        //Si el mono esta en la puerta
        if (estado[0] == 0) {
            int[] respuesta = estado.clone();
            //Se mueve al centro
            respuesta[0] = 1;
            return respuesta;
        }
        //Si el mono esta en el centro
        if (estado[0] == 1) {
            int[] respuesta = estado.clone();
            //Se mueve a la ventana
            respuesta[0] = 2;
            return respuesta;
        }
        //Si el mono esta en la ventana
        if (estado[0] == 2) {
            int[] respuesta = estado.clone();
            //Se mueve al centro
            respuesta[0] = 1;
            return respuesta;
        }
        return null;
    }

    //Operacion 2, EMPUJAR CAJA
    public int[] empujarCaja(int[] estado) {
        //Si el mono y la caja estan en la puerta
        if ((estado[0] == 0) && (estado[2] == 0)) {
            int[] respuesta = estado.clone();
            //Al centro
            respuesta[0] = 1;
            respuesta[2] = 1;
            return respuesta;
        }
        //Si el mono y la caja estan en la ventana
        if ((estado[0] == 2) && (estado[2] == 2)) {
            int[] respuesta = estado.clone();
            //Al centro
            respuesta[0] = 1;
            respuesta[2] = 1;
            return respuesta;
        }
        //Si el mono y la caja estan en el centro
        if ((estado[0] == 1) && (estado[2] == 1)) {
            int[] respuesta = estado.clone();
            //A la ventana
            respuesta[0] = 2;
            respuesta[2] = 2;
            return respuesta;
        }
        return null;
    }

    //Operacion 3, SUBIR CAJA
    public int[] SubirCaja(int[] estado) {
        if ((estado[0] == estado[2]) && (estado[0] == 1)) {
            int[] respuesta = estado.clone();
            respuesta[1] = 1;//caja
            return respuesta;
        }
        return null;
    }

    //Operacion 3, BAJAR CAJA
    public int[] BajarCaja(int[] estado) {
        if ((estado[0] == estado[2])&& (estado[0] == 1)) {
            int[] respuesta = estado.clone();
            respuesta[1] = 0;//suelo
            return respuesta;
        }
        return null;
    }

    //Operacion 3, COGER PLANATANO
    public int[] CogerPlatano(int[] estado) {
        if ((estado[0] == estado[2]) && (estado[1] == 1)) {
            int[] respuesta = estado.clone();
            respuesta[0] = 1;
            respuesta[1] = 1;
            respuesta[2] = 1;
            respuesta[3] = 0;
            return respuesta;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return Arrays.equals((int[]) o, _habitacion);
    }

    @Override
    public String toString() {

        String resultado;
        
        resultado = "     -Puerta-          -Centro-          -Ventana-     \n";
        switch (_habitacion[0]){
            case 0:
                resultado += "      -MONO-\n";
                break;
            case 1:
                resultado += "                        -MONO-\n";
                break;
            case 2:
                resultado += "                                          -MONO-\n";
                break;
        }
        switch (_habitacion[2]){
            case 0:
                resultado += "      -CAJA-\n";
                break;
            case 1:
                resultado += "                        -CAJA-\n";
                break;
            case 2:
                resultado += "                                          -CAJA-\n";
                break;
        }
        switch (_habitacion[3]){
            case 0:
                resultado += "\n Tiene el platano";
                break;
            case 1:
                resultado += "\n No tiene el platano.";
                break;
        }
                
        return resultado;
    }
}
