package control.juegos.Garrafas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Clase que representa las propiedades del juego.
 * @author jcarlos
 */
public class GarrafasEstado {

    /**
     * Numero de litros que se desean obtener en la garrafa cuya capacidad son 4 litros
     */
    final int NLITROS = 2;
    /**
     * Garrafa de 3 litros de capacidad, que indica la cantidad de litros que
     * contiene en un determinado estado
     */
    private int _garrafa3;
    /**
     * Garrafa de 4 litros de capacidad, que indica la cantidad de litros que
     * contiene en un determinado estado
     */
    private int _garrafa4;
    /**
     * Hashtable, donde la clave o key es el valor del contenido existente en la
     * garrafa de 3 de capacidad y el valor es el contenido de la garrafa de 4
     * litros de capacidad
     */
    private Vector<GarrafasContenido> _contenido;
    /**
     * Hora inicial del juego.
     */
    public static long horaInicial;
        /**
     * Indica si se ha alcanzado el timeout
     */
    public static boolean timeout;

    /**
     * Constructor por defecto
     * Siendo el estado inicial, ambas garrafas vacías
     */
    public GarrafasEstado() {
        this._garrafa3 = 0;
        this._garrafa4 = 0;
        this._contenido = new Vector<GarrafasContenido>();
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
        timeout = false;

    }

    /**
     * Constructor parametrizado
     * @param garrafa3 GarrafasContenido de la garrafa de 3 litros de capacidad
     * @param garrafa4 GarrafasContenido de la garrafa de 4 litros de capacidad
     * @param contenido
     */
    public GarrafasEstado(int garrafa3, int garrafa4, Vector<GarrafasContenido> contenido) {
        this._garrafa3 = garrafa3;
        this._garrafa4 = garrafa4;
        this._contenido = contenido;
    }

    /**
     * Metodo que devuelve el vector del contenido de las garrafas.
     * @return _contenido
     */
    public Vector<GarrafasContenido> getContenido() {
        return _contenido;
    }

    /**
     * Metodo que actualiza el vector del contenido de las garrafas.
     * @param contenido
     */
    public void setContenido(Vector<GarrafasContenido> contenido) {
        this._contenido = contenido;
    }

    /**
     * Metodo que devuelve el contenido de la garrafa de 3 litros.
     * @return _garrafa3
     */
    public int getGarrafa3() {
        return _garrafa3;
    }

    /**
     * Metodo que actualiza el contenido de la garrafa de 3 litros.
     * @param garrafa3
     */
    public void setGarrafa3(int garrafa3) {
        this._garrafa3 = garrafa3;
    }

    /**
     * Metodo que devuelve el contenido de la garrafa de 4 litros.
     * @return
     */
    public int getGarrafa4() {
        return _garrafa4;
    }

    /**
     * Metodo que actualiza el contenido de la garrafa de 4 litros.
     * @param garrafa4
     */
    public void setGarrafa4(int garrafa4) {
        this._garrafa4 = garrafa4;
    }

    /**
     * Indica si se ha alcanzado el estado objetivo
     * @return  TRUE en caso de ser el estado objetivo
     *          FALSE en cualquier otro caso
     */
    public boolean esObjetivo() {
        return this.getGarrafa3() == NLITROS;
    }

    /**
     * Revisamos cada uno de los movimientos que se han realizado entre las 2
     * garrafas, si ya se ha realizado no tiene sentido volver a ejecutarlo, por
     * lo que se descarta
     * @param posibleG3 Posible modificación del contenido de la garrafa3
     * @param posibleG4 Posible modificación del contenido de la garrafa4
     * @return Indica si dicha modificación ya se ha realizado o no
     */
    public boolean cambioAunNoRealizado(int posibleG3, int posibleG4) {
        boolean posible = true;
        int i = 0;
        while (posible && (i < this.getContenido().size())) {
            if ((this.getContenido().get(i).getContG3() == posibleG3)
                    && (this.getContenido().get(i).getContG4() == posibleG4)) {
                posible = false;
            }
            i++;
        }
        return posible;
    }

    /**
     * Metodo que dibuja el estado de las garrafas.
     * @param g3
     * @param g4
     * @return
     */
    public String toString(int g3, int g4) {
        String resultado = "";
        switch (g4) {
            case 0:
                switch (g3) {
                    case 0:
                        resultado += "             |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 1:
                        resultado += "             |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 2:
                        resultado += "             |    |\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 3:
                        resultado += "  ____       |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                }
                break;
            case 1:
                switch (g3) {
                    case 0:
                        resultado += "             |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |____|\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 1:
                        resultado += "             |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 2:
                        resultado += "             |    |\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |    |      |____|\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 3:
                        resultado += "  ____       |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |____|\n";
                        resultado += " |____|      |____|\n";
                        break;
                }
                break;
            case 2:
                switch (g3) {
                    case 0:
                        resultado += "             |    |\n";
                        resultado += " |    |      |____|\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 1:
                        resultado += "             |    |\n";
                        resultado += " |    |      |____|\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 2:
                        resultado += "             |    |\n";
                        resultado += " |____|      |____|\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 3:
                        resultado += "  ____       |    |\n";
                        resultado += " |    |      |____|\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                }
                break;
            case 3:
                switch (g3) {
                    case 0:
                        resultado += "             |____|\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 1:
                        resultado += "             |____|\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 2:
                        resultado += "             |____|\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 3:
                        resultado += "  ____       |____|\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                }
                break;
            case 4:
                switch (g3) {
                    case 0:
                        resultado += "              ____\n";
                        resultado += "             |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 1:
                        resultado += "              ____\n";
                        resultado += "             |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 2:
                        resultado += "              ____\n";
                        resultado += "             |    |\n";
                        resultado += " |____|      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                    case 3:
                        resultado += "              ____\n";
                        resultado += "  ____       |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |    |      |    |\n";
                        resultado += " |____|      |____|\n";
                        break;
                }
                break;
        }

        resultado += "\n";

        return resultado;
    }
}
