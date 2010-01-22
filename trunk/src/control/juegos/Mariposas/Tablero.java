package control.juegos.Mariposas;

/**
 *
 * @author JOSECARLOS
 */
public class Tablero {

    final int coordenadaX = 2;
    final int coordenadaY = 5;

    //Fases de transformacion Huevo->Larva->Gusano->Mariposa.
    public enum Fases {Mariposa,Gusano,Larva,Huevo}


    //array bidimensional donde se encontraran todos los pollitos---> es nuestro tablero
    private Fases [][] valor;
    
    /**
     * Constructor por defecto
     */
    public Tablero(){

        //inicializamos todos los pollitos.
        this.valor = new Fases[coordenadaX][coordenadaY];
        for(int i = 0; i < coordenadaX; i++)
            for(int j = 0; j < coordenadaY; j++)
                this.valor[i][j] = Fases.Huevo;
    }

    /**
    
     * Constructor parametrizado
     * @param padre Tablero anterior
     * @param x Nuevo valor de la coordenada X
     * @param y Nuevo valor de la coordenada Y
    */
    public Tablero(Tablero padre, int x, int y){
        this.valor = new Fases[coordenadaX][coordenadaY];
        for(int i = 0; i < coordenadaX; i++)
            for(int j = 0; j < coordenadaY; j++)
                this.valor[i][j] = padre.getValor(i, j);
        this.valor[x][y] = this.obtenerSucesor(padre.getValor(x,y));
        if(x - 1 >= 0)
            this.valor[x-1][y] = this.obtenerSucesor(padre.getValor(x - 1, y));
        if(x + 1 < coordenadaX)
            this.valor[x+1][y] = this.obtenerSucesor(padre.getValor(x + 1, y));
        if(y - 1 >= 0)
            this.valor[x][y-1] = this.obtenerSucesor(padre.getValor(x, y - 1));
        if(y + 1 < coordenadaY)
            this.valor[x][y+1] = this.obtenerSucesor(padre.getValor(x, y + 1));
    }


    public Fases[][] getValor() {
        return valor;
    }

    public void setValor(Fases[][] valor) {
        this.valor = valor;
    }
    
    public Fases getValor(int x, int y){
        return this.valor[x][y];
    }

    //{Huevo,Larva,Larva,Huevo}
    public String getForma(int x,int y){

        String forma="";
        Fases valor=getValor(x,y);
        Fases Huevo=valor.Huevo;
        Fases Larva=valor.Larva;
        Fases Gusano=valor.Gusano;
        Fases Mariposa=valor.Mariposa;

        switch (valor){

            case Huevo: forma = "   ()  ";
                        break;
            case Larva: forma = " Larva ";
                        break;
            case Gusano: forma = "Gusano ";
                        break;
            case Mariposa: forma = "  ƸӁƷ  ";
                        break;
        }
        return forma;

    }

    public String imprimirTablero(Object obj){

        String resultado="";
         //this.valor = new Fases[coordenadaX][coordenadaY];
        for(int i = 0; i < coordenadaX; i++){
            for(int j = 0; j < coordenadaY; j++)
                resultado+=((Tablero)obj).getForma(i, j);
            resultado+="\n";
        }
         return resultado;
        
    }


    @Override
    public boolean equals(Object obj) {
        boolean iguales = true;
        int i = 0, j = 0;
        while(iguales && (i < coordenadaX)){
            while(iguales && (j < coordenadaY)){
                if(this.getValor(i, j) != ((Tablero)obj).getValor(i, j))
                    iguales = false;
                j++;
            }
            i++;
            j = 0;
        }
        return iguales;
    }  
    
    /**
     * Genera el coste de ir desde el momento actual a otro pasado por parametro.
     * Se utiliza la distancia manhattan
     * @param instante Tablero destino
     * @return
     */

    //recorro todo el tablero y miro cuantas casillas son distintas.
    public double generarCoste(Tablero instante) {
        double coste = 0.0;
        for(int i = 0; i < coordenadaX; i++)
            for(int j = 0; j < coordenadaY; j++)
                if(this.getValor(i, j) != instante.getValor(i, j))
                    coste++;
        return coste;

    }

    /**
     * Devuelve el valor heuristico, segun la evolucion del huevo la heuristica aumenta
     * o disminuye. 
     * El orden de mayor a menor es: Huevo --> Larva --> Larva --> Huevo (0)
     * @return
     */
    public double generarHeuristica() {
        double heuristica = 0.0;
        for(int i = 0; i < coordenadaX; i++)
            for(int j = 0; j < coordenadaY; j++){
                if(this.getValor(i, j) == Fases.Gusano)
                    heuristica+=1;
                if(this.getValor(i, j) == Fases.Larva)
                    heuristica+=2;
                if(this.getValor(i, j) == Fases.Huevo)
                    heuristica+=3;
            }
        return heuristica;
    }


    //Siguiente evolucion del pollito
    public Fases obtenerSucesor(Fases valor) {
     Fases siguiente = null;
        if(valor == Fases.Huevo)
            siguiente = Fases.Larva;
        else{
            if(valor == Fases.Larva)
                siguiente = Fases.Gusano;
            else{
                if(valor == Fases.Gusano)
                    siguiente = Fases.Mariposa;
                else
                    siguiente = Fases.Huevo;
            }

        }
        return siguiente;
    }

    @Override
    public String toString() {
        String granja = "";
        for(int i = 0; i < coordenadaX; i++){
            for(int j = 0; j < coordenadaY; j++){
                switch(this.getValor(i, j)){
                    case Larva: granja+= "| L |"; break;
                    case Huevo: granja+= "| H |"; break;
                    case Gusano: granja+= "| G |"; break;
                    case Mariposa: granja+= "| M |"; break;
                }
            }
            granja+="\n";
        }            
        return granja;
    }

    
}
