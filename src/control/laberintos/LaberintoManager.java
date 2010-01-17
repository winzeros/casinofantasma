/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.laberintos;

/**
 *
 * @author Alicia
 */
public class LaberintoManager {

    private int saldo;

    public LaberintoManager() {
        saldo = 0;
    }

    public int getSaldo() {
        return saldo;
    }

    public int apuesta(double cantidad) {
        saldo -= cantidad;
        return saldo;
    }

    public int recompensa(int cantidad) {
        saldo += cantidad;
        return saldo;
    }

}
