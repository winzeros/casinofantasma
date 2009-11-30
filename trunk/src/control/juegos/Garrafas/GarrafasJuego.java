package control.juegos.Garrafas;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.SuccessorFunction;

import aima.search.uninformed.BidirectionalSearch;
import control.juegos.Juego;

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
        this._solucion = false;

        if (this._busqueda instanceof BidirectionalSearch) {
            Problem originalProblem = _problema;
           // Problem reverseProblem = new Problem(new GarrafasEstadoObjetivo(this), (SuccessorFunction) new GarrafaFuncionSucesor(),);
           // this._problema = new Problem(new GarrafasEstadoObjetivo(this), (SuccessorFunction) new GarrafaFuncionSucesor(),
             //   new GarrafasEstado());
        }
        
    }

    @Override
    public boolean ejecutar() {
        // this.busqueda = new BreadthFirstSearch(new TreeSearch());
        //this.busqueda = new DepthFirstSearch(new TreeSearch());
        //this._busqueda= new DepthLimitedSearch(11);
        try {
            System.out.println("Garrafa 3 : " + new GarrafasEstado().getGarrafa3());
            this._agente = new SearchAgent(this._problema, this._busqueda);
            this.imprimir(this._agente.getActions());
            this.imprimirPropiedades(this._agente.getInstrumentation());
            if (this.getSolucion()) {
                System.out.println("ES solucion");
            } else {
                System.out.println("NO es solucion");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return this.getSolucion();
    }
}
