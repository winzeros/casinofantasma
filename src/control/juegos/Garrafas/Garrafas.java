package control.juegos.Garrafas;

import aima.search.framework.GoalTest;
import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.SuccessorFunction;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.uninformed.BidirectionalSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import control.juegos.IJuego;
/**
 *
 * @author GabiPC
 */
public class Garrafas implements IJuego{

    private String _nombre;
    private boolean _solucion;
    private SearchAgent _agente = null;
    private Search _busqueda = null;
    private Problem _problema = null;
    private GarrafaEstado _estado = null;
    private GarrafaObjetivo _objetivo = null;

    /**
     * Constructor por defecto
     */
    public Garrafas( Search busqueda ){
        this._busqueda=busqueda;
        this._nombre = "Garrafas de capacidades diferentes";
        this._solucion = false;
        this._estado = new GarrafaEstado();
        this._objetivo = new GarrafaObjetivo(this);
        this._problema = new Problem(this._estado,(SuccessorFunction) new GarrafaFuncionSucesor(),(GoalTest) this._objetivo);
    }

    public SearchAgent getAgente() {
        return _agente;
    }

    public Search getBusqueda() {
        return _busqueda;
    }

    public GarrafaEstado getEstado() {
        return _estado;
    }

    public GarrafaObjetivo getObjetivo() {
        return _objetivo;
    }

    public Problem getProblema() {
        return _problema;
    }

    public String getNombre() {
        return _nombre;
    }

    public boolean getSolucion() {
        return _solucion;
    }

    public void setBusqueda(Search busqueda) {
        this._busqueda = busqueda;
    }

    public void setEstado(GarrafaEstado estado) {
        this._estado = estado;
    }

    public void setAgente(SearchAgent agente) {
        this._agente = agente;
    }

    public void setObjetivo(GarrafaObjetivo objetivo) {
        this._objetivo = objetivo;
    }

    public void setProblema(Problem problema) {
        this._problema = problema;
    }

    public void setSolucion(boolean solucion) {
        this._solucion = solucion;
    }

    @Override
    public boolean ejecutar(){       
       // this.busqueda = new BreadthFirstSearch(new TreeSearch());
        //this.busqueda = new DepthFirstSearch(new TreeSearch());
        //this._busqueda= new DepthLimitedSearch(11);
    	try {
            System.out.println("Garrafa 3 : " + this._estado.getGarrafa3());
            this._agente = new SearchAgent(this._problema, this._busqueda);
            this.imprimir(this._agente.getActions());
            this.imprimirPropiedades(this._agente.getInstrumentation());
            if(this.getSolucion())
                System.out.println("ES solucion");
            else
                System.out.println("NO es solucion");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return this.getSolucion();
    }

    @Override
    public String imprimir(List eventos){
        String impresion = "";
        for(int i = 0; i < eventos.size(); i++){
            String aux = (String) eventos.get(i);
            System.out.println(aux);
            impresion = impresion + aux + "\n";
        }
        return impresion;
    }

    @Override
    public String imprimirPropiedades(Properties propiedades) {
		String ret = "";
		Iterator keys = propiedades.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = propiedades.getProperty(key);
			System.out.println(key + " : " + property);
			ret += key + " : " + property+"\n";
		}
		return ret;
    }

}
