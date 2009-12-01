/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.juegos.solitario;

import aima.search.framework.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alicia
 */
public class SolitarioFuncionSucesor implements SuccessorFunction {

    private SolitarioEstado estadoPadre;

    public List getSuccessors(Object arg0) {
        ArrayList resultado = new ArrayList();
        estadoPadre = new SolitarioEstado((SolitarioEstado) arg0);
        ArrayList recorrido = estadoPadre.getRecorrido();
        SolitarioEstado estado;

        for (int i = 0; i < 7; i++) {

            if ((i == 0) || (i == 1) || (i == 5) || (i == 6)) {
                for (int j = 2; j < 5; j++) {
                    estado = new SolitarioEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    recorrido = ejecutarMovimientos(estado, resultado, i, j);
                }
            } else {
                for (int j = 0; j < 7; j++) {
                    estado = new SolitarioEstado(estadoPadre);
                    estado.setRecorrido(recorrido);
                    recorrido = ejecutarMovimientos(estado, resultado, i, j);
                }
            }
        }
        return resultado;
    }

    private ArrayList ejecutarMovimientos(SolitarioEstado estado, ArrayList resultado, int i, int j) {

        ArrayList recorrido = estado.getRecorrido();

        if (estado.ejecutarMovimiento(new Point(i, j), SolitarioEstado.Movimiento.ABAJO)) {
            recorrido = estado.getRecorrido();
            resultado.add(new Successor("                  (" + i + "," + j + ")" + estado.toString(),
                    estado));
        }

        if (estado.ejecutarMovimiento(new Point(i, j), SolitarioEstado.Movimiento.ARRIBA)) {
            recorrido = estado.getRecorrido();
            resultado.add(new Successor("                  (" + i + "," + j + ")" + estado.toString(),
                    estado));
        }

        if (estado.ejecutarMovimiento(new Point(i, j), SolitarioEstado.Movimiento.IZQUIERDA)) {
            recorrido = estado.getRecorrido();
            resultado.add(new Successor("                  (" + i + "," + j + ")" + estado.toString(),
                    estado));
        }

        if (estado.ejecutarMovimiento(new Point(i, j), SolitarioEstado.Movimiento.DERECHA)) {
            recorrido = estado.getRecorrido();
            resultado.add(new Successor("                  (" + i + "," + j + ")" + estado.toString(),
                    estado));
        }

        return recorrido;
    }
}
