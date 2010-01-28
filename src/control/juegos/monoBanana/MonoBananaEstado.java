/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.monoBanana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Clase que representa las propiedades del juego.
 * @author Laura
 */
public class MonoBananaEstado {

    /**
     * Array que representa las posiciones en la habitacion
     * y la posesion del platano.
     */
    private int[] _habitacion;
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
        /**
     * Indica si se ha alcanzado el timeout
     */
    public static boolean timeout;


// <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">

    /**
     * Constructor por defecto.
     */
    public MonoBananaEstado() {
        _habitacion = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_habitacion);
        _controlCiclos = true;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
        timeout = false;
    }

    /**
     * Constructor parametrizado.
     * @param controlCiclos
     */
    public MonoBananaEstado(boolean controlCiclos) {
        _habitacion = getEstadoInicial();
        _recorrido = new ArrayList();
        _recorrido.add(_habitacion);
        _controlCiclos = controlCiclos;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    /**
     * Constructor parametrizado.
     * @param habitacion
     * @throws Exception
     */
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

    /**
     * Constructor de copia.
     * @param estado
     */
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

    /**
     * Metodo que inicializa la habitacion.
     * @return
     */
    public int[] getEstadoInicial() {
        int[] habitacion = new int[4];
        habitacion[0] = 0; //Mono en la puerta
        habitacion[1] = 0; //Caja en el suelo
        habitacion[2] = 2; //Caja en la ventana
        habitacion[3] = 1; //No tiene el platano
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
        return habitacion;
    }

    /**
     * Metodo que actualiza el estado del juego.
     * @param estado
     */
    public void setEstado(MonoBananaEstado estado) {

        try {
            for (int i = 0; i < estado._habitacion.length; i++) {
                _habitacion[i] = estado._habitacion[i];
            }
        } catch (Exception ex) {
            Logger.getLogger(MonoBananaEstado.class.getName()).log(Level.ERROR, "Error al crear un nuevo estado", ex);
        }
    }

    /**
     * Metodo que devuelve el array que representa la habitacion.
     * @return _habitacion
     */
    public int[] getHabitacion() {
        return this._habitacion;
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
     * Metodo que devuelve si el mono puede realizar la operacion.
     * @param operacion
     * @return res
     */
    public boolean puedeMoverse(int operacion) {

        boolean res = false;

        try {
            switch (operacion) {
                case 1: //Andar
                    res = andar();
                    break;
                case 2: //Empujar_caja
                    res = empujarCaja();
                    break;
                case 3: //Subir_caja
                    res = SubirCaja();
                    break;
                case 4: //Bajar_caja
                    res = BajarCaja();
                    break;
                case 5: //Coger_platano
                    res = CogerPlatano();
                    break;
            }

        } catch (Exception ex) {
            Logger.getLogger(MonoBananaEstado.class.getName()).log(Level.ERROR, 
                    "Error al comprobar si es válida la operacion " + operacion, ex);
        }

        return res;
    }

    /**
     * Metodo que devuelve si la habitacion esta en el recorrido.
     * @param mesa
     * @return
     */
    boolean controlCiclos(int[] habitacion) {
        return !((this._controlCiclos) && (this._recorrido.contains(habitacion)));
    }

// </editor-fold>

    /**
     * Metodo que devuelve si el mono ha realizado la operacion.
     * @param operacion
     * @return res
     */
    public boolean mover(int operacion) {
        boolean res = false;

        try {
            if (puedeMoverse(operacion)) {
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



// <editor-fold defaultstate="collapsed" desc="OPERACIONES DEL MONO">

    /**
     * Metodo que ejecuta la operacion ANDAR.
     * @return
     */
    public boolean andar() {
        //Si el mono esta en la puerta
        if (_habitacion[0] == 0) {
            //Se mueve al centro
            _habitacion[0] = 1;
            return true;
        }
        //Si el mono esta en el centro
        if (_habitacion[0] == 1) {
            //Se mueve a la ventana
            _habitacion[0] = 2;
            return true;
        }
        //Si el mono esta en la ventana
        if (_habitacion[0] == 2) {
            //Se mueve al centro
            _habitacion[0] = 1;
            return true;
        }
        return false;
    }

    /**
     * Metodo que ejecuta la operacion EMPUJAR CAJA
     * @return
     */
    public boolean empujarCaja() {
        //Si el mono y la caja estan en la puerta
        if ((_habitacion[0] == 0) && (_habitacion[2] == 0)) {
            //Al centro
            _habitacion[0] = 1;
            _habitacion[2] = 1;
            return true;
        }
        //Si el mono y la caja estan en la ventana
        if ((_habitacion[0] == 2) && (_habitacion[2] == 2)) {
            //Al centro
            _habitacion[0] = 1;
            _habitacion[2] = 1;
            return true;
        }
        //Si el mono y la caja estan en el centro
        if ((_habitacion[0] == 1) && (_habitacion[2] == 1)) {
            //A la ventana
            _habitacion[0] = 2;
            _habitacion[2] = 2;
            return true;
        }
        return false;
    }

    /**
     * Metodo que ejecuta la operacion SUBIR CAJA
     * @return
     */
    public boolean SubirCaja() {
        if ((_habitacion[0] == _habitacion[2]) && (_habitacion[0] == 1)) {
            _habitacion[1] = 1;//caja
            return true;
        }
        return false;
    }

    /**
     * Metodo que ejecuta la operacion BAJAR CAJA
     * @return
     */
    public boolean BajarCaja() {
        if ((_habitacion[0] == _habitacion[2])&& (_habitacion[0] == 1)) {
            _habitacion[1] = 0;//suelo
            return true;
        }
        return false;
    }

    /**
     * Metodo que ejecuta la operacion COGER_PLATANO
     * @return
     */
    public boolean CogerPlatano() {
        if ((_habitacion[0] == _habitacion[2]) && (_habitacion[1] == 1)) {
            _habitacion[0] = 1;
            _habitacion[1] = 1;
            _habitacion[2] = 1;
            _habitacion[3] = 0;
            return true;
        }
        return false;
    }

 // </editor-fold>

    @Override
    public boolean equals(Object o) {
        return Arrays.equals((int[]) o, _habitacion);
    }

    @Override
    public String toString() {

        String resultado;
        
        resultado = "-Puerta-   -Centro-   -Ventana-\n";
        switch (_habitacion[0]){
            case 0:
                resultado += " -MONO-\n";
                break;
            case 1:
                resultado += "            -MONO-\n";
                break;
            case 2:
                resultado += "                       -MONO-\n";
                break;
        }
        switch (_habitacion[2]){
            case 0:
                resultado += " -CAJA-\n";
                break;
            case 1:
                resultado += "            -CAJA-\n";
                break;
            case 2:
                resultado += "                       -CAJA-\n";
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
