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


 public RejillaRojoAzulJuego(Search busqueda) {
        _nombre="Rejilla Rojo y Azul";
    	_nodosExpandidos=0;
        _busqueda=busqueda;
        _problema = new Problem(new RejillaRojoAzulEstado(), 
                new RejillaRojoAzulFuncionSucesor(), new RejillaRojoAzulEstadoObjetivo(this));
    
   }


   public  RejillaRojoAzulJuego(Search busqueda, HeuristicFunction heuristica) {
        _nombre="Rejilla Rojo y Azul";
    	_nodosExpandidos=0;
        _busqueda=busqueda;
        _problema = new Problem(new RejillaRojoAzulEstado(),
                new RejillaRojoAzulFuncionSucesor(), new RejillaRojoAzulEstadoObjetivo(this),
                heuristica);
    }
}
