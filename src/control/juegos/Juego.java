/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos;

import aima.search.framework.*;
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
public class Juego{

    protected String _nombre;
    protected SearchAgent _agente;
    protected Search _busqueda;
    protected Problem _problema;

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">

    public void setBusqueda(Search s) {
        this._busqueda = s;
    }

        public String getNombre() {
        return this._nombre;
    }

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="IMPRIMIR">

   public String imprimir(List eventos) {

        String impresion = "";
        for (int i = 0; i < eventos.size(); i++) {
            String action = (String) eventos.get(i);
            Logger.getLogger(Juego.class.getName()).log(Level.INFO, action);
            impresion += action + "\n";
        }
        return impresion;
    }

    public String imprimirApp(JTextArea textArea, List eventos) {

        String impresion = "";
        for (int i = 0; i < eventos.size(); i++) {
            String action = (String) eventos.get(i);
            textArea.append(action + "\n");
            impresion += action + "\n";
        }
        return impresion;
    }

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
