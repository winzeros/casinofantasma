/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control.juegos.Garrafas;

/**
 * Clase que representa el contenido de las garrafas del juego de las Garrafas.
 * @author jcarlos
 */
public class GarrafasContenido {

    /**
     * Contenido de la garrafa de 3 litros.
     */
    private int contG3;
    /**
     * Contenido de la garrafa de 4 litros.
     */
    private int contG4;

    /**
     * Constructor parametrizado
     * @param contG3
     * @param contG4
     */
    public GarrafasContenido(int contG3, int contG4) {
        this.contG3 = contG3;
        this.contG4 = contG4;
    }

    /**
     * Metodo que devuelve el contenido de la garrafa de 3 litros.
     * @return contG3
     */
    public int getContG3() {
        return contG3;
    }

    /**
     * Metodo que actualiza el contenido de la garrafa de 3 litros.
     * @param contG3
     */
    public void setContG3(int contG3) {
        this.contG3 = contG3;
    }

    /**
     * Metodo que devuelve el contenido de la garrafa de 4 litros.
     * @return contG4
     */
    public int getContG4() {
        return contG4;
    }

    /**
     * Metodo que actualiza el contenido de la garrafa de 4 litros.
     * @param contG4
     */
    public void setContG4(int contG4) {
        this.contG4 = contG4;
    }  
    
}
