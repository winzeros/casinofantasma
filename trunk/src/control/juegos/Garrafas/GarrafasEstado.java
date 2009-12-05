package control.juegos.Garrafas;

import java.util.Vector;

/**
 * @author Grupo C15
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
    private Vector<Contenido> _contenido;
    /**
     * Constructor por defecto
     * Siendo el estado inicial, ambas garrafas vacías
     */
    public GarrafasEstado() {
        this._garrafa3 = 0;
        this._garrafa4 = 0;
        this._contenido = new Vector<Contenido>();
    }
    /**
     * Constructor parametrizado
     * @param garrafa3 Contenido de la garrafa de 3 litros de capacidad
     * @param garrafa4 Contenido de la garrafa de 4 litros de capacidad
     * @param contenido
     */
    public GarrafasEstado(int garrafa3, int garrafa4, Vector<Contenido> contenido) {
        this._garrafa3 = garrafa3;
        this._garrafa4 = garrafa4;
        this._contenido = contenido;
    }

    public Vector<Contenido> getContenido() {
        return _contenido;
    }

    public void setContenido(Vector<Contenido> contenido) {
        this._contenido = contenido;
    }

    public int getGarrafa3() {
        return _garrafa3;
    }

    public void setGarrafa3(int garrafa3) {
        this._garrafa3 = garrafa3;
    }

    public int getGarrafa4() {
        return _garrafa4;
    }

    public void setGarrafa4(int garrafa4) {
        this._garrafa4 = garrafa4;
    }

    /**
     * Indica si se ha alcanzado el estado objetivo
     * @return  TRUE en caso de ser el estado objetivo
     *          FALSE en cualquier otro caso
     */
    public boolean esObjetivo(){
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
    public boolean cambioAunNoRealizado(int posibleG3, int posibleG4){
        boolean posible = true;
        int i = 0;
        while (posible && (i < this.getContenido().size())){
            if((this.getContenido().get(i).getContG3() == posibleG3)&&
               (this.getContenido().get(i).getContG4() == posibleG4))
                posible = false;
            i++;
        }
        return posible;
    }
}
