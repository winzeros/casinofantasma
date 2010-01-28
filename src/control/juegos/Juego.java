/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.swing.JTextArea;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */

/**
 * Clase que representa el juego.
 *
 */
public class Juego {

    /**
     * Nombre del juego a representar.
     */
    protected String _nombre;
    /**
     * Agente utilizado.
     */
    protected SearchAgent _agente;
    /**
     * Busqueda a utilizar para la resolucion del juego.
     */
    protected Search _busqueda;
    /**
     * Problema a resolver.
     */
    protected Problem _problema;

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">
    
    /**
     * Actualiza el valor de la busqueda.
     * @param s
     */
    public void setBusqueda(Search s) {
        this._busqueda = s;
    }

    /**
     * Metodo que devuelve el nombre del juego que se va a representar
     * @return _nombre
     */
    public String getNombre() {
        return this._nombre;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="IMPRIMIR">

    /**
     * Metodo que escribe los eventos del juego en el Log.
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
     * Metodo que escribe los eventos del juego en el area de texto.
     * @param textArea
     * @param eventos
     * @return impresion
     */
    public String imprimirApp(JTextArea textArea, List eventos) {

        String impresion = "";
        for (int i = 0; i < eventos.size(); i++) {
            String action = (String) eventos.get(i);
            textArea.append(action + "\n");
            impresion += action + "\n";
        }
        return impresion;
    }

    /**
     * Metodo que escribe las propiedades del juego el el Log.
     * @param propiedades
     * @return impresion
     */
    public String imprimirPropiedades(Properties propiedades) {

        String impresion = "";
        Iterator keys = propiedades.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = propiedades.getProperty(key);
            Logger.getLogger(Juego.class.getName()).log(Level.INFO, key + " : " + property);
            impresion += key + " : " + property + "\n";
        }
        return impresion;
    }

    /**
     * Metodo que escribe las propiedades del juego en el area de texto.
     * @param textArea
     * @param propiedades
     * @return impresion
     */
    public String imprimirPropiedadesApp(JTextArea textArea, Properties propiedades) {

        String impresion = "";
        textArea.append("\n");
        Iterator keys = propiedades.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = propiedades.getProperty(key);
            textArea.append(key + " : " + property + "\n");
            impresion += key + " : " + property + "\n";
        }
        return impresion;
    }

// </editor-fold>

    /**
     * Metodo que ejecuta el juego que luego se va a implementar en las
     * clases heredadas.
     */
    public boolean ejecutarConsola() {

        boolean salida = true;

        try {

            this._agente = new SearchAgent(this._problema, this._busqueda);
            this._problema.getInitialState().toString();
            this.imprimir(this._agente.getActions());
            this.imprimirPropiedades(this._agente.getInstrumentation());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return salida;
    }

        /**
     * Metodo que ejecuta el juego que luego se va a implementar en las
     * clases heredadas y lo muestra por la salida estandar.
     */
    public void ejecutar() {

        try {

            this._agente = new SearchAgent(this._problema, this._busqueda);
            this._problema.getInitialState().toString();
            this.imprimir(this._agente.getActions());
            this.imprimirPropiedades(this._agente.getInstrumentation());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Metodo que ejecuta el juego sobre el area de texto.
     * @param textArea
     */
    public void ejecutarApp(JTextArea textArea) {

        try {

            this._agente = new SearchAgent(this._problema, this._busqueda);
            this._problema.getInitialState().toString();
            this.imprimirApp(textArea, this._agente.getActions());
            this.imprimirPropiedadesApp(textArea, this._agente.getInstrumentation());

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
