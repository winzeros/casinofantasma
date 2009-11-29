/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos;

import aima.search.framework.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Alicia
 */
public class Juego{

    protected String _nombre;
    protected boolean _solucion;
    protected SearchAgent _agente;
    protected Search _busqueda;
    protected Problem _problema;

// <editor-fold defaultstate="collapsed" desc="GETS - SETS">

    public void setSolucion(boolean b) {
        this._solucion = b;
    }

    public boolean getSolucion() {
        return this._solucion;
    }

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
            System.out.println(action);
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
            System.out.println(key + " : " + property);
            impresion += key + " : " + property + "\n";
        }
        return impresion;
    }

// </editor-fold>

    public boolean ejecutar() {

        try {

            this._agente = new SearchAgent(this._problema, this._busqueda);
            this._problema.getInitialState().toString();
            this.imprimir(this._agente.getActions());
            this.imprimirPropiedades(this._agente.getInstrumentation());

            if (this.getSolucion()) {
                System.out.println("Es Solución");
            } else {
                System.out.println("NO es solución");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return this.getSolucion();
    }


}
