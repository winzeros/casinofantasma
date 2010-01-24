/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.laberintos.juego;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Alicia
 */
public class LaberintoEstado {

    private String sala;
    private ArrayList recorridos;
    public static long horaInicial;

    public LaberintoEstado(String sala) {
        this.recorridos = new ArrayList();
        this.recorridos.add(sala);
        this.sala = sala;
        Calendar calendario = new GregorianCalendar();
        horaInicial = calendario.getTimeInMillis();
    }

    public LaberintoEstado(LaberintoEstado estado) {
            sala = estado.getSala();
            recorridos = estado.getRecorridos();
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

    public boolean puedoMover(String destino) {
        boolean ok = true;
        int i = 0;
        while ((i < recorridos.size()) && (ok)) {
            ok = ok && !recorridos.get(i).equals(destino);
            i++;
        }
        if (ok) {
            recorridos.add(destino);
            sala = destino;
        }
        return ok;
    }

    @Override
    public String toString() {
        return this.sala;
    }

}
