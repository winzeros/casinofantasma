/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.nreinas;

import aima.basic.XYLocation;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alicia
 */
public class NReinasFuncionSucesor  implements SuccessorFunction {

	public List getSuccessors(Object estado) {
		List<Successor> sucesores = new ArrayList<Successor>();
		NReinasEstado tablero = (NReinasEstado) estado;
		int numReinas = tablero.getNumeroReinasColocadas();
		int n = tablero.getN();
		for (int i = 0; i < n; i++) {
			if (!(tablero.estaAmenazada(new XYLocation(numReinas, i)))) {
				NReinasEstado hijo = colocarReina(numReinas, i, tablero);
				sucesores.add(new Successor(hijo.toString(), hijo));

			}

		}

		return sucesores;
	}

	private NReinasEstado colocarReina(int fila, int columna,
			NReinasEstado padre) {

		NReinasEstado nuevoEstado = new NReinasEstado(padre.getN());
		List<XYLocation> reinasColocadasEnPadre = padre
				.getPosiciones();
		reinasColocadasEnPadre.add(new XYLocation(fila, columna));
		nuevoEstado.setTablero(reinasColocadasEnPadre);
		return nuevoEstado;
	}

}
