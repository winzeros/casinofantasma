package control.juegos.ochoPuzzle;

import java.util.ArrayList;
import java.util.List;

import aima.basic.XYLocation;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author JOSECARLOS
 * 
 */
public class OchoPuzzleEstados {

    public static String LEFT = "Izquierda";
    public static String RIGHT = "Derecha";
    public static String UP = "Arriba";
    public static String DOWN = "Abajo";
    public static long horaInicial;
    int[] tablero;
        /**
     * Indica si se ha alcanzado el timeout
     */
    public static boolean timeout;

    public int[] getTablero() {
        return tablero;
    }

    public OchoPuzzleEstados() {
        tablero = new int[]{1, 4, 2, 7, 5, 8, 3, 0, 6};
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
        timeout = false;

    }

    public OchoPuzzleEstados(int[] aBoard) {
        tablero = aBoard;
    }

    private int[] PosXYtablero(int x) {
        int[] posXY = null;
        switch (x) {
            case 0:
                posXY = new int[]{0, 0};
                break;
            case 1:
                posXY = new int[]{0, 1};
                break;
            case 2:
                posXY = new int[]{0, 2};
                break;
            case 3:
                posXY = new int[]{1, 0};
                break;
            case 4:
                posXY = new int[]{1, 1};
                break;
            case 5:
                posXY = new int[]{1, 2};
                break;
            case 6:
                posXY = new int[]{2, 0};
                break;
            case 7:
                posXY = new int[]{2, 1};
                break;
            case 8:
                posXY = new int[]{2, 2};
                break;

        }
        return posXY;
    }

    private int posTablero(int x, int y) {
        return x * 3 + y;
    }

    //devuelve el elemento en la posicion x y
    private int getValorAt(int x, int y) {
        return tablero[posTablero(x, y)];
    }

    private int getPosicionDe(int val) {
        int retVal = -1;
        for (int i = 0; i < 9; i++) {
            if (tablero[i] == val) {
                retVal = i;
            }
        }
        return retVal;
    }

    public XYLocation getLocationOf(int val) {
        int abspos = getPosicionDe(val);
        int xpos = PosXYtablero(abspos)[0];
        int ypos = PosXYtablero(abspos)[1];
        return new XYLocation(xpos, ypos);
    }

    private void setValor(int xPos, int yPos, int val) {
        int i = posTablero(xPos, yPos);
        tablero[i] = val;

    }

    public int getValorAt(XYLocation loc) {
        return getValorAt(loc.getXCoOrdinate(), loc.getYCoOrdinate());
    }

    public void MoverHuecoDerch() {
        int PosicionHueco = getPosicionDe(0);
        int xpos = PosXYtablero(PosicionHueco)[0];
        int ypos = PosXYtablero(PosicionHueco)[1];
        if (!(ypos == 2)) {
            int valueOnRight = getValorAt(xpos, ypos + 1);
            setValor(xpos, ypos, valueOnRight);
            setValor(xpos, ypos + 1, 0);
        }

    }

    public void moverHuecoIzq() {
        int PosicionHueco = getPosicionDe(0);
        int xpos = PosXYtablero(PosicionHueco)[0];
        int ypos = PosXYtablero(getPosicionDe(0))[1];
        if (!(ypos == 0)) {
            int valueOnLeft = getValorAt(xpos, ypos - 1);
            setValor(xpos, ypos, valueOnLeft);
            setValor(xpos, ypos - 1, 0);
        }

    }

    public void moverHuecoAbajo() {
        int gapPosition = getPosicionDe(0);
        int xpos = PosXYtablero(gapPosition)[0];
        int ypos = PosXYtablero(gapPosition)[1];
        if (!(xpos == 2)) {
            int valueOnBottom = getValorAt(xpos + 1, ypos);
            setValor(xpos, ypos, valueOnBottom);
            setValor(xpos + 1, ypos, 0);
        }

    }

    public void moverHuecoArriba() {
        int gapPosition = getPosicionDe(0);
        int xpos = PosXYtablero(gapPosition)[0];
        int ypos = PosXYtablero(gapPosition)[1];
        if (!(xpos == 0)) {
            int valueOnTop = getValorAt(xpos - 1, ypos);
            setValor(xpos, ypos, valueOnTop);
            setValor(xpos - 1, ypos, 0);
        }

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        OchoPuzzleEstados aBoard = (OchoPuzzleEstados) o;

        for (int i = 0; i < 8; i++) {
            if (this.getPosicionDe(i) != aBoard.getPosicionDe(i)) {
                return false;
            }
        }
        return true;
    }

    public List<XYLocation> getPositions() {
        ArrayList<XYLocation> retVal = new ArrayList<XYLocation>();
        for (int i = 0; i < 9; i++) {
            int[] res = PosXYtablero(getPosicionDe(i));
            XYLocation loc = new XYLocation(res[0], res[1]);
            retVal.add(loc);

        }
        return retVal;
    }

    public void setTablero(List<XYLocation> locs) {

        int count = 0;

        for (int i = 0; i < locs.size(); i++) {
            XYLocation loc = locs.get(i);
            this.setValor(loc.getXCoOrdinate(), loc.getYCoOrdinate(), count);
            count = count + 1;
        }
    }

    public boolean puedoMoverHueco(String where) {
        boolean sol = true;
        int PosHueco = getPosicionDe(0);
        if (where.equals(LEFT)) {
            if ((PosHueco == 0) || (PosHueco == 3) || (PosHueco == 6)) {
                sol = false;
            }
        }
        if (where.equals(RIGHT)) {
            if ((PosHueco == 2) || (PosHueco == 5) || (PosHueco == 8)) {
                sol = false;
            }
        }
        if (where.equals(UP)) {
            if ((PosHueco == 0) || (PosHueco == 1) || (PosHueco == 2)) {
                sol = false;
            }
        }
        if (where.equals(DOWN)) {
            if ((PosHueco == 6) || (PosHueco == 7) || (PosHueco == 8)) {
                sol = false;
            }
        }

        return sol;
    }

    @Override
    public String toString() {
        String retVal = tablero[0] + " " + tablero[1] + " " + tablero[2] + "\n"
                + tablero[3] + " " + tablero[4] + " " + tablero[5] + " " + "\n"
                + tablero[6] + " " + tablero[7] + " " + tablero[8];
        return retVal;
    }
}
