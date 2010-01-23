package control.juegos.mariposas;

import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.StepCostFunction;
import aima.search.framework.TreeSearch;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import aima.search.uninformed.UniformCostSearch;
import aima.search.informed.*;



import control.juegos.Juego;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
//import control.juegos.Juego;

/**
 *
 * @author JOSECARLOSE
 */
public class MariposasJuego extends Juego{

    
    private String nombre;
    private boolean solucion;
    private Search busqueda = null;
    private SearchAgent agente = null;
    private Problem problema = null;
    private MariposasEstadoObjetivo objetivo = null;
    private MariposasEstado estado = null;
   


    

 

    public MariposasJuego(Search busqueda){

        this.nombre = "Problema de las Mariposas";
        this.solucion = false;
        this.objetivo = new MariposasEstadoObjetivo(this);
        this.estado= new MariposasEstado();
        this.busqueda= busqueda;
        this.problema = new Problem(this.estado,new MariposasFuncionSucesora(),this.objetivo,new MariposasFuncionCoste(),new MariposasFuncionHeuristica());
    }

   public SearchAgent getAgente() {
        return agente;
    }

    public void setAgente(SearchAgent agente) {
        this.agente = agente;
    }

    public Search getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(Search busqueda) {
        this.busqueda = busqueda;
    }

    public MariposasEstado getEstado() {
        return estado;
    }

    public void setEstado(MariposasEstado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MariposasEstadoObjetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(MariposasEstadoObjetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Problem getProblema() {
        return problema;
    }

    public void setProblema(Problem problema) {
        this.problema = problema;
    }

    public boolean getSolucion() {
        return solucion;
    }

    
    public void setSolucion(boolean solucion) {
       this.solucion = solucion;
    }

                
   
   
    public void ejecutar(){

        try{
            this.agente = new SearchAgent(this.problema,this.busqueda);
            this.imprimir(this.agente.getActions());
            System.out.print("\n");
            this.imprimirPropiedades(this.agente.getInstrumentation());
            if(this.getSolucion()){
                System.out.println("ES solución");
                this.estado.getInstante(); //---------------->MIRAR COMO HACER PARA IMPRIMER EL ESTADO. MIRAR IMPRIMIR TABLERO.
            }
            else
                System.out.println("NO es solucion");
        }catch(Exception ex){
            System.out.println(ex);
        }
       
    }
    

//    @Override
    public String imprimir(List eventos) {
        String impresion = "";
          for (int i = 0; i < eventos.size(); i++) {
             String action = (String) eventos.get(i);
            Logger.getLogger(Juego.class.getName()).log(Level.INFO, action);
            impresion += action + "\n";

          }
        return impresion;
    }
   
  //  @Override
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

