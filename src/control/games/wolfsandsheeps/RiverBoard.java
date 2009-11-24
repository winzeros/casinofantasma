/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.games.wolfsandsheeps;

import java.util.HashMap;

/**
 *
 * @author Alicia
 */
public class RiverBoard {

    private HashMap<String, Integer> _boardState;
    public static final String WOLFS = "Lobos";
    public static final String SHEEPS = "Ovejas";
    public static final String BOAT = "Canoa";

    public RiverBoard() {
        _boardState = getInitialState();
    }

    public RiverBoard(HashMap state) {
        _boardState = state;
    }

    public HashMap getInitialState() {
        HashMap initialState = new HashMap(3);

        initialState.put(WOLFS, 3);
        initialState.put(SHEEPS, 3);
        initialState.put(BOAT, 0);

        return initialState;
    }

    public boolean hit(int wolfs, int sheeps) {
        int aux;
        boolean ok = false;

        if (isValidState(wolfs, sheeps) && !(isRiskState(wolfs, sheeps)))
        {
            aux = _boardState.get(WOLFS) - wolfs;
            _boardState.remove(WOLFS);
            _boardState.put(WOLFS, aux);

            aux = _boardState.get(SHEEPS) - sheeps;
            _boardState.remove(SHEEPS);
            _boardState.put(SHEEPS, aux);

            if (_boardState.get(BOAT) == 0) {
                _boardState.remove(BOAT);
                _boardState.put(BOAT, 1);
            } else {
                _boardState.remove(BOAT);
                _boardState.put(BOAT, 0);
            }
            ok = true;
        }
        return ok;
    }

    public void setBoard(RiverBoard board) {
        _boardState.clear();
        _boardState.put(WOLFS, board._boardState.get(WOLFS));
        _boardState.put(SHEEPS, board._boardState.get(SHEEPS));
        _boardState.put(BOAT, board._boardState.get(BOAT));
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        return ((RiverBoard) o).hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this._boardState != null ? this._boardState.hashCode() : 0);
        return hash;
    }



    private boolean isValidState(int wolfs, int sheeps) {

        if (_boardState.get(BOAT) == 0) {
            return (((wolfs + sheeps) < 3) &&
                    ((wolfs + sheeps) > 0) &&
                    ((_boardState.get(WOLFS) - wolfs) > 0) &&
                    ((_boardState.get(SHEEPS) - sheeps) > 0));
        } else {
            return (((wolfs + sheeps) < 3) &&
                    ((wolfs + sheeps) > 0) &&
                    ((3 - _boardState.get(WOLFS) - wolfs) > 0) &&
                    ((3 - _boardState.get(SHEEPS) - sheeps) > 0));
        }
    }

    private boolean isRiskState(int wolfs, int sheeps) {
        return ((_boardState.get(WOLFS) - wolfs) > _boardState.get(SHEEPS) - sheeps) ||
                ((3 - _boardState.get(SHEEPS) - sheeps) < (3 - _boardState.get(WOLFS) - wolfs));
    }

    @Override
    public String toString() {
        String result = "";
        String boat = "";

        if (_boardState.get(BOAT) == 0) {
            boat = " | <__>          | ";
        } else {
            boat = " |          <__> | ";
        }

        result += "           ";
        result += " " + WOLFS + ":  " + _boardState.get(WOLFS) + boat + WOLFS + ":  " + (3 - _boardState.get(WOLFS)) + "\n";
        result += " " + SHEEPS + ":  " + _boardState.get(SHEEPS) + boat + SHEEPS + ":  " + (3 - _boardState.get(SHEEPS)) + "\n";
        result += "           ";

        return result;
    }
}
