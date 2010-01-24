package control.juegos.mariposas;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;



import control.juegos.Juego;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * Clase que representa el juego de las Mariposas.
 * @author jcarlos
 */
public class MariposasJuego extends Juego{

    /**
     * Nombre del juego.
     */
    private String nombre;
    /**
     * Solucion del juego.
     */
    private boolean solucion;
    /**
     * Busqueda utilizada en la resolucion del juego.
     */
    private Search busqueda = null;
    /**
     * Agente utilizado en la resolucion del juego.
     */
    private SearchAgent agente = null;
    /**
     * Problema a resolver.
     */
    private Problem problema = null;
    /**
     * Estado objetivo del juego.
     */
    private MariposasEstadoObjetivo objetivo = null;
    /**
     * Instancia del estado del juego.
     */
    private MariposasEstado estado = null;
   

    /**
     * Constructor parametrizado.
     * @param busqueda
     */
    public MariposasJuego(Search busqueda){

        this.nombre = "Problema de las Mariposas";
        this.solucion = false;
        this.objetivo = new MariposasEstadoObjetivo(this);
        this.estado= new MariposasEstado();
        this.busqueda= busqueda;
        this.problema = new Problem(this.estado,new MariposasFuncionSucesora(),this.objetivo,new MariposasFuncionCoste(),new MariposasFuncionHeuristica());
    }

    /**
     * Metodo que devuelve el agente de busqueda.
     * @return agente
     */
    public SearchAgent getAgente() {
        return agente;
    }

    /**
     * Metodo que actualiza el valor del agente.
     * @param agente
     */
    public void setAgente(SearchAgent agente) {
        this.agente = agente;
    }

    /**
     * Metodo que devuelve la busqueda utilizada.
     * @return busqueda
     */
    public Search getBusqueda() {
        return busqueda;
    }

    /**
     * Metodo que actualiza el valor de la busqueda.
     * @param busqueda
     */
    public void setBusqueda(Search busqueda) {
        this.busqueda = busqueda;
    }

    /**
     * Metodo que devuelve el estado.
     * @return estado
     */
    public MariposasEstado getEstado() {
        return estado;
    }

    /**
     * Metodo que actualiza el estado.
     * @param estado
     */
    public void setEstado(MariposasEstado estado) {
        this.estado = estado;
    }

    /**
     * Metodo que devuelve el nombre del juego.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que actualiza el valor del nombre.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve el estado objetivo.
     * @return objetivo
     */
    public MariposasEstadoObjetivo getObjetivo() {
        return objetivo;
    }

    /**
     * Metodo que actualiza el estado objetivo.
     * @param objetivo
     */
    public void setObjetivo(MariposasEstadoObjetivo objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Metodo que devuelve el problema.
     * @return
     */
    public Problem getProblema() {
        return problema;
    }

    /**
     * Metodo que actualiza el valor del problema.
     * @param problema
     */
    public void setProblema(Problem problema) {
        this.problema = problema;
    }

    /**
     * Metodo que devuelve el valor de solucion.
     * @return solucion
     */
    public boolean getSolucion() {
        return solucion;
    }

    /**
     * Metodo que actualiza el valor de solucion.
     * @param solucion
     */
    public void setSolucion(boolean solucion) {
       this.solucion = solucion;
    }

                
   /**
    * Metodo que ejecuta el juego.
    * Heredado de la clase Juego.
    */
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
    

    /**
     * Metodo que escribe en el Log.
     * @param eventos
     * @return impresion
     */
    public String imprimir(List eventos) {
        String impresion = "";
          for (int i = 0; i < eventos.size(); i++) {
             String action = (String) eventos.get(i);
            Logger.getLogger(Juego.class.getName()).log(Level.INFO, action);
            impresion += action + "\n";

          }
        return impresion;
    }

    /**
     * Metodo que escribe por consola.
     * @param propiedades
     * @return ret
     */
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

