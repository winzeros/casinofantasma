/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.ranas;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class RanasFuncionSucesor implements SuccessorFunction{

    public List getSuccessors(Object arg0) {

        //revisar!!!!!!!!!!!!!!!!!!!!!!!!
        
        ArrayList resultado = new ArrayList();
        RanasEstado estadoPadre = (RanasEstado) arg0;
        ArrayList hojas = estadoPadre.getHojas();

        try {
            for (int i = 0; i < 7; i++) {
                RanasEstado estado = new RanasEstado(estadoPadre);
                char tipo = hojas.get(i).toString().substring(0, 1).charAt(1);
                /*switch(tipo) { // Eleige la opcion acorde al numero de mes
                    case 'r' : {hojas.set(pos, RANAS); break;}
                    case 's' : {hojas.set(pos, SAPOS); break;}
                }*/
                if (estado.mover(i,tipo)) {
                    hojas = estado.getHojas();
                    resultado.add(new Successor("                  " + estado.toString(),estado));
                    }
            }
        } catch (Exception ex) {
            Logger.getLogger(RanasFuncionSucesor.class.getName())
                    .log(Level.SEVERE, "Error al obtener los sucesores de " + arg0.toString(), ex);
        }

        return resultado;
    }

}
