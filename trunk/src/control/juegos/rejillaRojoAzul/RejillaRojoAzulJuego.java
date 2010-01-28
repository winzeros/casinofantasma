/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.rejillaRojoAzul;

import aima.search.framework.HeuristicFunction;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import control.juegos.Juego;

/**
 *
 * @author JOSECARLOS
 */

public class RejillaRojoAzulJuego extends Juego{

static int _nodosExpandidos;


RejillaRojoAzulJuego(Search busqueda) {
        _nombre="Tenemos un tablero con las casillas pintadas de color rojo o azul y queremos que el numero de pares del mismo color sea minimo.";
    	_nodosExpandidos=0;
        _busqueda=busqueda;
        _problema = new Problem(new RejillaRojoAzulEstado(), new RejillaRojoAzulFuncionSucesor(), new RejillaRojoAzulEstadoObjetivo(), new RejillaRojoAzulFuncionHeuristica());
    
   }

    RejillaRojoAzulJuego(Search busqueda, HeuristicFunction heuristica) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
