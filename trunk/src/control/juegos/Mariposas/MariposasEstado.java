package control.juegos.mariposas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Clase que representa las propiedades del juego.
 * @author jcarlos
 */
public class MariposasEstado {

    /**
     * Tablero del juego.
     */
    private Tablero instante;
    /**
     * Recorrido de la busqueda.
     */
    private Vector<Tablero> contenido;
    /**
     * Hora de inicio del juego.
     */
    public static long horaInicial;
    /**
     * Indica si se ha alcanzado el timeout
     */
    public static boolean timeout;


    /**
     * Constructor por defecto
     */
    public MariposasEstado(){
        this.instante = new Tablero();
        this.contenido = new Vector<Tablero>();
        this.contenido.add(this.instante);
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
        timeout = false;
    }
    
    /**
     * Constructor parametrizado
     * @param padre MariposasEstado anterior
     * @param actual Tablero que forma el estado actual
     */
    public MariposasEstado(MariposasEstado padre, Tablero actual){
        this.instante = actual;
        this.contenido = padre.getContenido();
        this.contenido.add(actual);
    }

    /**
     * Metodo que devuelve el vector que represena el recorrido de la busqueda.
     * @return contenido
     */
    public Vector<Tablero> getContenido() {
        return contenido;
    }

    /**
     * Metodo que actualiza el recorrido de la busqueda.
     * @param contenido
     */
    public void setContenido(Vector<Tablero> contenido) {
        this.contenido = contenido;
    }

    /**
     * Metodo que devuelve el tablero.
     * @return instante
     */
    public Tablero getInstante() {
        return instante;
    }

    /**
     * Metodo que actualiza el valor del tablero.
     * @param instante
     */
    public void setInstante(Tablero instante) {
        this.instante = instante;
    }


    /**
     * Indica si un estado ya ha sido creado en algun otro momento del recorrido
     * del arbol de busqueda.
     * @param nuevo Siguiente posible momento
     * @return	True Si es posible
     * 			False En cualquier otro caso
     */ 
    public boolean movimientoPosible(Tablero nuevo){
        boolean posible = true;
        int i = 0;
        while(posible && (i < this.getContenido().size())){
            if(this.getContenido().get(i).equals(nuevo))
                posible = false;
            i++;
        }
        return posible;
    }
    
    /**
     * Devuelve el coste generado para ir hasta el MariposasEstado hijo
     * @param hijo MariposasEstado destino
     * @return
     */
    public double generarCoste(MariposasEstado hijo) { //miro todo el tablero y miro cuantos pollitos son diferentes.
        return this.getInstante().generarCoste(hijo.getInstante());
    }
    
    /**
     * Devuelve el valor heuristico de este estado
     * @return
     */
    public double generarHeuristica(){ //para cada pollito del tablero si es rojo +1, si es azul...+2...
        return this.getInstante().generarHeuristica();
    }
    
}
