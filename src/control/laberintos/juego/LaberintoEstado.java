/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.laberintos.juego;

/**
 *
 * @author Alicia
 */
public class LaberintoEstado {

    private String sala;

    public LaberintoEstado(String sala) {
        this.sala = sala;
    }

    public String getSala() {
        return this.sala;
    }

    @Override
    public String toString() {
        return this.sala;
    }

}
