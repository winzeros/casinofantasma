package control.juegos.Garrafas;

import aima.search.framework.Problem;
import aima.search.framework.Search;

import control.juegos.Juego;

/**
 * Clase que representa el juego de las Garrafas.
 * @author jcarlos
 */
public class GarrafasJuego extends Juego {

    /**
     * Constructor del juego.
     * @param busqueda
     * @throws Exception
     */
    GarrafasJuego(Search busqueda) {
        this._busqueda = busqueda;
        this._nombre = "Garrafas de capacidades diferentes";
        this._problema=new Problem(new GarrafasEstado(), new GarrafasFuncionSucesor(),
                    new GarrafasEstadoObjetivo(this));        
    }
}
