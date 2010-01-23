/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.nreinas;

import aima.basic.XYLocation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Alicia
 */
public class NReinasEstado {

	/**
	 * X---> increases left to right with zero based index Y increases top to
	 * bottom with zero based index | | V
	 */
	int[][] tablero;

	int n;
    public static long horaInicial;

	public NReinasEstado(int n) {

		this.n = n;
		tablero = new int[this.n][this.n];
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				tablero[i][j] = 0;
			}
		}
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
	}

	public void añadirReina(XYLocation l) {

		if (!(existeReina(l)))
			tablero[l.getXCoOrdinate()][l.getYCoOrdinate()] = 1;
	}

	public void quitarReina(XYLocation l) {

		if (tablero[l.getXCoOrdinate()][l.getYCoOrdinate()] == 1) {
			tablero[l.getXCoOrdinate()][l.getYCoOrdinate()] = 0;
		}
	}

	private boolean existeReina(int x, int y) {

		return (tablero[x][y] == 1);
	}

	public boolean existeReina(XYLocation l) {

		return (existeReina(l.getXCoOrdinate(), l.getYCoOrdinate()));
	}

	public void moverReina(XYLocation from, XYLocation to) {

		if ((existeReina(from)) && (!(existeReina(to)))) {
			quitarReina(from);
			añadirReina(to);
		}
	}

	public void clear() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tablero[i][j] = 0;
			}
		}
	}

	public void setTablero(List<XYLocation> al) {

		clear();

		for (int i = 0; i < al.size(); i++) {
			añadirReina(al.get(i));
		}
	}

	public int getNumeroReinasColocadas() {

		int num = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tablero[i][j] == 1) {
					num++;
				}
			}
		}
		return num;
	}

	public List<XYLocation> getPosiciones() {

		ArrayList<XYLocation> result = new ArrayList<XYLocation>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (existeReina(i, j)) {
					result.add(new XYLocation(i, j));
				}
			}
		}
		return result;

	}

	private boolean tieneAmenazaHorizontal(int x, int y) {

		return ataquesHorizontales(x, y) > 0;
	}

	private boolean tieneAmenazaVertical(int x, int y) {
		return ataquesVerticales(x, y) > 0;
	}

	private boolean tieneAmenazaDiagonal(int x, int y) {
		return ataquesDiagonales(x, y) > 0;
	}

	public boolean estaAmenazada(XYLocation l) {

		int x = l.getXCoOrdinate();
		int y = l.getYCoOrdinate();
		return (tieneAmenazaHorizontal(x, y)
				|| tieneAmenazaVertical(x, y) || tieneAmenazaDiagonal(
				x, y));
	}

	public int getN() {

		return n;
	}

	public int getNumeroAtaques(XYLocation l) {

		int x = l.getXCoOrdinate();
		int y = l.getYCoOrdinate();
		return ataquesHorizontales(x, y)
				+ ataquesVerticales(x, y)
				+ ataquesDiagonales(x, y);
	}

	private int ataquesHorizontales(int x, int y) {

		int retVal = 0;
		for (int i = 0; i < n; i++) {
			if ((existeReina(i, y))) {
				if (i != x)
					retVal++;
			}
		}
		return retVal;
	}

	private int ataquesVerticales(int x, int y) {

		int retVal = 0;
		for (int j = 0; j < n; j++) {
			if ((existeReina(x, j))) {
				if (j != y)
					retVal++;
			}
		}
		return retVal;
	}

	private int ataquesDiagonales(int x, int y) {

		int retVal = 0;

		int i;
		int j;
		// forward up diagonal
		for (i = (x + 1), j = (y - 1); (i < n && (j > -1)); i++, j--) {
			if (existeReina(i, j)) {
				retVal++;
			}
		}
		// forward down diagonal
		for (i = (x + 1), j = (y + 1); ((i < n) && (j < n)); i++, j++) {
			if (existeReina(i, j)) {
				retVal++;
			}
		}
		// backward up diagonal
		for (i = (x - 1), j = (y - 1); ((i > -1) && (j > -1)); i--, j--) {
			if (existeReina(i, j)) {
				retVal++;
			}
		}

		// backward down diagonal
		for (i = (x - 1), j = (y + 1); ((i > -1) && (j < n)); i--, j++) {
			if (existeReina(i, j)) {
				retVal++;
			}
		}

		return retVal;
	}

	@Override
	public int hashCode() {
		List<XYLocation> locs = getPosiciones();

		int result = 17;
		for (XYLocation loc : locs) {
			result = 37 * loc.hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		NReinasEstado aBoard = (NReinasEstado) o;
		boolean retVal = true;
		List<XYLocation> locs = getPosiciones();

		for (XYLocation loc : locs) {
			if (!(aBoard.existeReina(loc))) {
				retVal = false;
			}
		}
		return retVal;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int row = 0; row < n; row++) { // rows
			for (int col = 0; col < n; col++) { // columns
				if (existeReina(col, row)) {
					buf.append(' ');
					buf.append('R');
				} else {
					buf.append(' ');
					buf.append('_');
				}
			}
			buf.append("\n");
		}
		return buf.toString();
	}

}