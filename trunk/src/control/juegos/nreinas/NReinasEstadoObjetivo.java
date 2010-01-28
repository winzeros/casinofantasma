/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.nreinas;

import aima.basic.XYLocation;
import aima.search.framework.GoalTest;
import java.util.List;

/**
 *
 * @author Alicia
 */
public class NReinasEstadoObjetivo  implements GoalTest {

	NReinasEstado tablero;
    NReinasJuego juego;

    public NReinasEstadoObjetivo(NReinasJuego nreinas){
        this.juego = nreinas;
    }

	public boolean isGoalState(Object state) {

		tablero = (NReinasEstado) state;
        if (estanTodasColocadas() && estanTodasSeguras(tablero
				.getPosiciones())) {
            juego.setSolucion(true);
        }
		return (estanTodasColocadas() && estanTodasSeguras(tablero
				.getPosiciones()));
	}

	private boolean estanTodasColocadas() {
		return tablero.getNumeroReinasColocadas() == tablero.getN();
	}

	private boolean estanTodasSeguras(List positions) {

		for (int i = 0; i < positions.size(); i++) {
			XYLocation location = (XYLocation) positions.get(i);
			if (tablero.getNumeroAtaques(location) != 0) {
				return false;
			}
		}
		return true;
	}
}