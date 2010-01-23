/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.rejillaRojoAzul;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author JOSECARLOS
 */
public class RejillaRojoAzulEstado {

    private String[][] _tablero;
    static int _nodosExpandidos;
    public static long horaInicial;

    public RejillaRojoAzulEstado() {
        _tablero = new String[3][3];
        _nodosExpandidos = 0;
        _tablero[0][0] = "R";
        _tablero[0][1] = "R";
        _tablero[0][2] = "R";
        _tablero[1][0] = "A";
        _tablero[1][1] = "R";
        _tablero[1][2] = "R";
        _tablero[2][0] = "A";
        _tablero[2][1] = "A";
        _tablero[2][2] = "A";
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    public RejillaRojoAzulEstado(String[][] tablero) {
        _tablero = new String[3][3];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                _tablero[i][j] = tablero[i][j];
            }
        }
    }

    public boolean valido() {
        return (_nodosExpandidos < 5000);
    }

    public String getCasilla(int i, int j) {
        return _tablero[i][j];

    }

    public void AumentarNodosExpandidos() {
        _nodosExpandidos++;
    }

    public String toString() {
        String tabla = "\n\t(";
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                tabla += " " + _tablero[i][j] + " ";
                if (j == 2 && i != 2) {
                    tabla += ")" + "\n" + "\t(";
                }
                if (j == 2 && i == 2) {
                    tabla += ")" + "\n";
                }
            }
        }
        return tabla;
    }
}
