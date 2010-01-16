package control.juegos.Garrafas;

import aima.search.framework.GoalTest;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.SuccessorFunction;

import aima.search.uninformed.BidirectionalSearch;
import control.juegos.Juego;
import java.util.Vector;

/**
 *
 * @author jcarlos
 */
public class GarrafasJuego extends Juego {

    /**
     * Constructor por defecto
     */
    public GarrafasJuego(Search busqueda) {
        this._busqueda = busqueda;
        this._nombre = "Garrafas de capacidades diferentes";
        this._problema=new Problem(new GarrafasEstado(), new GarrafasFuncionSucesor(),
                    new GarrafasEstadoObjetivo(this));        
    }
}
