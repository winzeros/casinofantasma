/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.laberintos.juego;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.map.Map;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.IterativeDeepeningSearch;
import control.juegos.ranas.RanasJuego;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Alicia
 */
public class LaberintoJuego {

    protected SearchAgent _agente;
    protected Search _busqueda;
    protected Problem _problema;

    public LaberintoJuego(Search busqueda, Map map) {
        try {
            this._busqueda = busqueda;
            this._problema = new Problem(new LaberintoEstado("SALA0"),
                    new LaberintoFuncionSucesor(map),
                    new LaberintoEstadoObjetivo(new String[]{"SALA17", "SALA18", "SALA19"}));

        } catch (Exception ex) {
            Logger.getLogger(RanasJuego.class.getName()).log(Level.ERROR, "Crear el juego utilizando la búsqueda " + busqueda.toString(), ex);
        }
    }

    public void setBusqueda(Search s) {
        this._busqueda = s;
    }

    public boolean permiteControlCiclos() {
        return !(this._busqueda instanceof IterativeDeepeningSearch);
    }

    public List ejecutar() {

        List resultado = new ArrayList();
        try {

            this._agente = new SearchAgent(this._problema, this._busqueda);
            this._problema.getInitialState().toString();
            resultado = this._agente.getActions();
            //this.imprimirPropiedades(this._agente.getInstrumentation());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return resultado;
    }
}

