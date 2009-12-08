package control.juegos.Garrafas;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.SuccessorFunction;

import control.juegos.Juego;
/**
 *
 * @author jcarlos
 */
public class Garrafas extends Juego{


    /**
     * Constructor por defecto
     */
    public Garrafas( Search busqueda ){
        this._busqueda=busqueda;
        this._nombre = "Garrafas de capacidades diferentes";
        this._problema = new Problem(new GarrafaEstado(),(SuccessorFunction) new GarrafaFuncionSucesor(),
                new GarrafaObjetivo(this));
    }
}
