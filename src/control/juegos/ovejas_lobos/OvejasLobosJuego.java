/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.ovejas_lobos;

import aima.search.framework.*;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.IJuego;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Alicia
 */
public class OvejasLobosJuego implements IJuego {

    private String      _nombre     = null;
    private boolean     _solucion   = false;
    private SearchAgent _agente     = null;
    private Search      _busqueda   = null;
    private Problem     _problema   = null;

    public OvejasLobosJuego(Search busqueda) {

        try {
            this._busqueda = busqueda;
            this._nombre = "Ovejas vs. Lobos";
            this._solucion = false;
            this._problema = new Problem(new OvejasLobosEstado(permiteControlCiclos()), new OvejasLobosFuncionSucesor(),
                    new OvejasLobosEstadoObjetivo(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSolucion(boolean b) {
        this._solucion = b;
    }

    public boolean getSolucion() {
        return this._solucion;
    }

    public void setBusqueda(Search s) {
        this._busqueda = s;
    }

    public boolean ejecutar() {

    	try{

            this._agente = new SearchAgent(this._problema, this._busqueda);
            System.out.println("Estado inicial\n");
            System.out.println("  Lobos:  3 |               | Lobos:  0");
            System.out.println("            |<__>           |");
            System.out.println(" Ovejas:  3 |               | Ovejas:  0\n\n");
            this.imprimir(this._agente.getActions());
            this.imprimirPropiedades(this._agente.getInstrumentation());

            if(this.getSolucion())
                System.out.println("Es Solución");
            else
                System.out.println("NO es solución");

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return this.getSolucion();
    }

    public String getNombre() {
        return this._nombre;
    }

    public String imprimir(List eventos) {
		String impresion = "";
		for (int i = 0; i < eventos.size(); i++) {
			String action = (String) eventos.get(i);
			System.out.println(action);
			impresion+=action+"\n";
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
			impresion += key + " : " + property+"\n";
		}
		return impresion;
    }

    public boolean permiteControlCiclos() {
		return !(this._busqueda instanceof IterativeDeepeningSearch);
	}
}
