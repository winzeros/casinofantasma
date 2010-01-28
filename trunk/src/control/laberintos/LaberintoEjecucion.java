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
                    //Busqueda A*
                    case 5:
                        ok = OvejasLobosDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First
                    case 6:
                        ok = OvejasLobosDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva
                    case 7:
                        ok = OvejasLobosDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing
                    case 8:
                        ok = OvejasLobosDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada
                    case 9:
                        ok = OvejasLobosDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First
                    case 10:
                        ok = OvejasLobosDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Escalada
                    case 11:
                        ok = OvejasLobosDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda A*
                    case 12:
                        ok = OvejasLobosDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Primero en profundidad
                    case 13:
                        ok = OvejasLobosDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Coste uniforme
                    case 14:
                        ok = OvejasLobosDemo.UniformCostSearchDemo(sala, consola);
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
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = GarrafasDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = GarrafasDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = GarrafasDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = GarrafasDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = GarrafasDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = GarrafasDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = GarrafasDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = GarrafasDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = GarrafasDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
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
                        ok = HermanosDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = HermanosDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = HermanosDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = HermanosDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = HermanosDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = HermanosDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = HermanosDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = HermanosDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = HermanosDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = HermanosDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = HermanosDemo.UniformCostSearchDemo(sala, consola);
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
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = NReinasDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = NReinasDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = NReinasDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = NReinasDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = NReinasDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = NReinasDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = NReinasDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = NReinasDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = NReinasDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = NReinasDemo.BreadthFirstDemo(sala, consola);
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
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = RanasDemo.AStarSearchRanas(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = RanasDemo.GreedyBestFirstSearchRanas(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = RanasDemo.RecursiveBestFirstSearchRanas(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = RanasDemo.SimulatedAnnealingSearchRanas(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = RanasDemo.HillClimbingSearchRanas(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = RanasDemo.AStarSearchDescolocadas(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = RanasDemo.GreedyBestFirstSearchDescolocadas(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = RanasDemo.RecursiveBestFirstSearchDescolocadas(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = RanasDemo.SimulatedAnnealingSearchDescolocadas(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = RanasDemo.HillClimbingSearchDescolocadas(sala, consola);
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
                        ok = LinternaDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = LinternaDemo.AStarSearchPersonas(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = LinternaDemo.GreedyBestFirstSearchPersonas(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = LinternaDemo.DepthFirstSearchDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = LinternaDemo.AStarSearchRestante(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = LinternaDemo.GreedyBestFirstSearchRestante(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = LinternaDemo.AStarSearchRestante(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = LinternaDemo.GreedyBestFirstSearchRestante(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = LinternaDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = LinternaDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = LinternaDemo.UniformCostSearchDemo(sala, consola);
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
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = MonoBananaDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = MonoBananaDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = MonoBananaDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = MonoBananaDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = MonoBananaDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = MonoBananaDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = MonoBananaDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = MonoBananaDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = MonoBananaDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = MonoBananaDemo.HillClimbingSearch(sala, consola);
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
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = RejillaRojoAzulDemo.RejillaRojoAzulGreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = RejillaRojoAzulDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = RejillaRojoAzulDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = RejillaRojoAzulDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = RejillaRojoAzulDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = RejillaRojoAzulDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = RejillaRojoAzulDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = RejillaRojoAzulDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = RejillaRojoAzulDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = RejillaRojoAzulDemo.HillClimbingSearch(sala, consola);
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
                        ok = OchoPuzzleDemo.AStarSearch(sala, consola);
                        break;
                    //Primero en profundidad limitada
                    case 2:
                        ok = OchoPuzzleDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Coste uniforme
                    case 3:
                        ok = OchoPuzzleDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda iterativa
                    case 4:
                        ok = OchoPuzzleDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = OchoPuzzleDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = OchoPuzzleDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = OchoPuzzleDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = OchoPuzzleDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = OchoPuzzleDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = OchoPuzzleDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = OchoPuzzleDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = OchoPuzzleDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = OchoPuzzleDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = OchoPuzzleDemo.HillClimbingSearch(sala, consola);
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
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = MariposasDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = MariposasDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = MariposasDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = MariposasDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = MariposasDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = MariposasDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = MariposasDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = MariposasDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = MariposasDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = MariposasDemo.HillClimbingSearch(sala, consola);
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
                        ok = HanoiDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = HanoiDemo.AStarSearchMalColocados(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = HanoiDemo.GreedyBestFirstSearchMalColocados(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = HanoiDemo.GreedyBestFirstSearchPosibles(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = HanoiDemo.SimulatedAnnealingSearchMalColocados(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = HanoiDemo.HillClimbingSearchMalColocados(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = HanoiDemo.AStarSearchPosibles(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = HanoiDemo.GreedyBestFirstSearchPosibles(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = HanoiDemo.IterativeDeepeningSearchDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = HanoiDemo.SimulatedAnnealingSearchPosibles(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = HanoiDemo.HillClimbingSearchMalColocados(sala, consola);
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
                    //Busqueda Busqueda A* heuristica ranas
                    case 5:
                        ok = SolitarioDemo.BreadthFirstDemo(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica ranas
                    case 6:
                        ok = SolitarioDemo.HillClimbingSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica ranas
                    case 7:
                        ok = SolitarioDemo.DepthLimitedSearchDemo(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica ranas
                    case 8:
                        ok = SolitarioDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica ranas
                    case 9:
                        ok = SolitarioDemo.UniformCostSearchDemo(sala, consola);
                        break;
                    //Busqueda Busqueda A* heuristica descolocadas
                    case 10:
                        ok = SolitarioDemo.AStarSearch(sala, consola);
                        break;
                    //Busqueda Greedy Best-First heuristica descolocadas
                    case 11:
                        ok = SolitarioDemo.GreedyBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Mejor Recursiva heuristica descolocadas
                    case 12:
                        ok = SolitarioDemo.RecursiveBestFirstSearch(sala, consola);
                        break;
                    //Busqueda Simulated Annealing heuristica descolocadas
                    case 13:
                        ok = SolitarioDemo.SimulatedAnnealingSearch(sala, consola);
                        break;
                    //Busqueda Escalada heuristica descolocadas
                    case 14:
                        ok = SolitarioDemo.HillClimbingSearch(sala, consola);
                        break;
                }
                break;
        }
        return ok;
    }

    
}
