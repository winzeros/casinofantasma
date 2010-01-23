/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.laberintos.juego;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.util.ArrayList;

/**
 *
 * @author Alicia
 */
public class LaberintoEstado {

    private String sala;
    private ArrayList recorridos;

    public LaberintoEstado(String sala) {
        this.recorridos = new ArrayList();
        this.recorridos.add(sala);
        this.sala = sala;
    }

    public String getSala() {
        return this.sala;
    }

    public ArrayList getRecorridos() {
        return recorridos;
    }

    public ArrayList añadirARecorridos(String sala) {
        this.recorridos.add(sala);
        return recorridos;
    }

    public void setRecorridos(ArrayList rec) {
        this.recorridos.clear();
        for (int i = 0; i < rec.size(); i++) {
            this.recorridos.add(rec.get(i));
        }
    }

    @Override
    public String toString() {
        return this.sala;
    }

}
