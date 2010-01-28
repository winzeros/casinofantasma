/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.laberintos;

import control.juegos.Garrafas.GarrafasDemo;
import control.juegos.hanoi.HanoiDemo;
import control.juegos.hermanos.HermanosDemo;
import control.juegos.linterna.LinternaDemo;
import control.juegos.mariposas.MariposasDemo;
import control.juegos.monoBanana.MonoBananaDemo;
import control.juegos.nreinas.NReinasDemo;
import control.juegos.ochoPuzzle.OchoPuzzleDemo;
import control.juegos.ovejasLobos.OvejasLobosDemo;
import control.juegos.ranas.RanasDemo;
import control.juegos.rejillaRojoAzul.RejillaRojoAzulDemo;
import control.juegos.solitario.SolitarioDemo;

/**
 *
 * @author usuario_local
 */
public class LaberintoEjecucion {

    public static boolean ejecutarJuego(int juego, int estrategia, String sala, boolean consola) {

        boolean ok = true;

        switch (juego) {
            //Juego de las ovejas y lobos
            case 0:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = OvejasLobosDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = OvejasLobosDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = OvejasLobosDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = OvejasLobosDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = OvejasLobosDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego de las garrafas
            case 1:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = GarrafasDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = GarrafasDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = GarrafasDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = GarrafasDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = GarrafasDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego de los Hermanos a la greña
            case 2:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = HermanosDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = HermanosDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = HermanosDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = HermanosDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = HermanosDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego de las NReinas
            case 3:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = NReinasDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = NReinasDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = NReinasDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = NReinasDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = NReinasDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego de las Ranas
            case 4:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = RanasDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = RanasDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = RanasDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = RanasDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = RanasDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego de la linterna
            case 5:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = LinternaDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = LinternaDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = LinternaDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = LinternaDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = LinternaDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego de el mono y la banana
            case 6:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = MonoBananaDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = MonoBananaDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = MonoBananaDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = MonoBananaDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = MonoBananaDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;

            //Juego de la rejilla
            case 7:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = RejillaRojoAzulDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = RejillaRojoAzulDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = RejillaRojoAzulDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = RejillaRojoAzulDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = RejillaRojoAzulDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego del 8 puzzle
            case 8:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = OchoPuzzleDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = OchoPuzzleDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = OchoPuzzleDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = OchoPuzzleDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = OchoPuzzleDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego de las mariposas
            case 9:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = MariposasDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = MariposasDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = MariposasDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = MariposasDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = MariposasDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                }
                break;
            //Juego de las torres de Hanoi
            case 10:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = HanoiDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = HanoiDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = HanoiDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = HanoiDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = HanoiDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
            //Juego del solitario
            case 11:
                switch (estrategia) {
                    //Primero en anchura
                    case 0:
                        ok = SolitarioDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Primero en profundidad
                    case 1:
                        ok = SolitarioDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = SolitarioDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = SolitarioDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = SolitarioDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                }
                break;
        }
        return ok;
    }

    
}
