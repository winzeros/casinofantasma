package control.juegos.Mariposas;

import java.util.Vector;

/**
 *
 * @author JOSECARLOSE
 */
public class MariposasEstado {

    private Tablero instante;  
    private Vector<Tablero> contenido;  //Recorrido de la busqueda.
    /**
     * Constructor por defecto
     */
    public MariposasEstado(){
        this.instante = new Tablero();
        this.contenido = new Vector<Tablero>();
        this.contenido.add(this.instante);
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

    public Vector<Tablero> getContenido() {
        return contenido;
    }

    public void setContenido(Vector<Tablero> contenido) {
        this.contenido = contenido;
    }

    public Tablero getInstante() {
        return instante;
    }

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
