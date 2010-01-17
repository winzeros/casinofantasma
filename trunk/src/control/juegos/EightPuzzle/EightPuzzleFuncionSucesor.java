/*
 * Created on Sep 12, 2004
 *
 */
package control.juegos.EightPuzzle;

import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

/**
 * @author JOSECARLOS
 * 
 */

public class EightPuzzleFuncionSucesor implements SuccessorFunction {

	public List getSuccessors(Object state) {
		EightPuzzleEstados tablero = (EightPuzzleEstados) state;
		List<Successor> sucesores = new ArrayList<Successor>();
		if (tablero.puedoMoverHueco(EightPuzzleEstados.UP)) {
			EightPuzzleEstados nuevoTablero = copyOf(tablero);
			nuevoTablero.moverHuecoArriba();
			sucesores.add(new Successor(EightPuzzleEstados.UP, nuevoTablero));
		}
		if (tablero.puedoMoverHueco(EightPuzzleEstados.DOWN)) {
			EightPuzzleEstados nuevoTablero = copyOf(tablero);
			nuevoTablero.moverHuecoAbajo();
			sucesores.add(new Successor(EightPuzzleEstados.DOWN, nuevoTablero));
		}
		if (tablero.puedoMoverHueco(EightPuzzleEstados.LEFT)) {
			EightPuzzleEstados nuevoTablero = copyOf(tablero);
			nuevoTablero.moverHuecoIzq();
			sucesores.add(new Successor(EightPuzzleEstados.LEFT, nuevoTablero));
		}
		if (tablero.puedoMoverHueco(EightPuzzleEstados.RIGHT)) {
			EightPuzzleEstados nuevoTablero = copyOf(tablero);
			nuevoTablero.MoverHuecoDerch();
			sucesores.add(new Successor(EightPuzzleEstados.RIGHT, nuevoTablero));
		}
		return sucesores;
	}

	private EightPuzzleEstados copyOf(EightPuzzleEstados tablero) {
		EightPuzzleEstados nuevoTablero = new EightPuzzleEstados();
                nuevoTablero.setTablero(tablero.getPositions());
		return nuevoTablero;
	}

}