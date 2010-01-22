package control.juegos.Mariposas;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author JOSECARLOSE
 */
public class MariposasFuncionSucesora implements SuccessorFunction{
    
    final int coordenadaX = 2;
    final int coordenadaY = 5;
    
	/**
	 * Genera el siguiente estado, comprobando antes que sea posible
	 * @param actual MariposasEstado actual
	 * @param posible Posible siguiente momento
	 * @return Nuevo estado
	 */
    public MariposasEstado crearSiguienteEstado(MariposasEstado actual,Tablero posible){
        MariposasEstado siguiente = null;
        if(actual.movimientoPosible(posible))
            siguiente = new MariposasEstado(actual,posible);
        return siguiente;
    }
    
    @Override
    public List getSuccessors(Object state) {
        List<Successor> siguientes = new ArrayList<Successor>();
        MariposasEstado estado = (MariposasEstado)state;
        MariposasEstado posible = null;

        for(int i = 0; i < coordenadaX; i++)
            for(int j = 0; j < coordenadaY; j++){
                posible = crearSiguienteEstado(estado,new Tablero(estado.getInstante(),i,j));
                if(posible != null)
                    siguientes.add(new Successor("Cambio en [ "+i+" , "+j+" ] : "+posible.getInstante().getValor(i, j).toString()+ 
                            " \n "+"\n"
                            + "***********************************\n"
                            + posible.getInstante().imprimirTablero(posible.getInstante())
                            + "***********************************\n",posible));

                posible = null;

            }


        return siguientes;
    }


}


