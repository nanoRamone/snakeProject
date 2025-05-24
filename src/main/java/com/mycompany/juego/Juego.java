
package com.mycompany.juego;

import java.util.Scanner;


public class Juego {
 public static void main(String[] args) {
        // Crear mapa y personaje Snake
        Mapa mapa = new Mapa(7, 7);
        Snake snake = new Snake("Snake", new Posicion(2, 2)); // FALTA hacer aleatorio

        // Colocar Snake en el mapa
        mapa.getCelda(2, 2).setContenido(snake);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mapa.imprimirMapa();
            System.out.println("Mover Snake: W (arriba), A (izq), S (abajo), D (der), Q (salir al menu)");
            String input = scanner.nextLine().toUpperCase();

            int dx = 0, dy = 0;

            switch (input) { // traduce los inputs en los movimientos en la grilla
                case "W": dx = -1; break;
                case "S": dx = 1; break;
                case "A": dy = -1; break;
                case "D": dy = 1; break;
                case "Q": System.out.println("Saliendo..."); return;
                default: System.out.println("Entrada no valida."); continue;
            }

            // Mueve al personaje en la dirección indicada
            snake.mover(dx, dy, mapa);
        }
    }
}