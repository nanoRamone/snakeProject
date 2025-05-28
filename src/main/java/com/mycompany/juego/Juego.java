package com.mycompany.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        // Crear mapa y personaje Snake
        Mapa mapa = new Mapa(7, 7);

        // Colocar Snake en el mapa
        Posicion posicionSnake = mapa.generarPosicionAleatoria();
        Snake snake = new Snake("Snake", posicionSnake);
        mapa.getCelda(posicionSnake.getX(), posicionSnake.getY()).setContenido(snake);

        // Crear y colocar puerta en fila 0, columna 3 (centro superior)
        Puerta puertaHangar = new Puerta("Puerta del Hangar");
        mapa.getCelda(0, 3).setContenido(puertaHangar);

        // Crear y colocar llave en una posición aleatoria libre
        Posicion posLlave;
        do {
            posLlave = mapa.generarPosicionAleatoria();
        } while (!mapa.getCelda(posLlave.getX(), posLlave.getY()).estaVacia());

        Item llave = new Item("Llave del Hangar", puertaHangar);
        mapa.getCelda(posLlave.getX(), posLlave.getY()).setContenido(llave);

        // Lista para los guardias
        List<Guardia> guardias = new ArrayList<>();

        // Crear y colocar 3 guardias en posiciones aleatorias, al menos a 2 de distancia de Snake
        for (int i = 0; i < 3; i++) {
            Posicion posGuardia;
            do {
                posGuardia = mapa.generarPosicionAleatoria();
            } while (
                !mapa.getCelda(posGuardia.getX(), posGuardia.getY()).estaVacia() ||
                posGuardia.distancia(posicionSnake) < 2
            );

            Guardia guardia = new Guardia("Guardia" + (i + 1), posGuardia);
            mapa.getCelda(posGuardia.getX(), posGuardia.getY()).setContenido(guardia);
            guardias.add(guardia);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mapa.imprimirMapa();
            System.out.println("Mover Snake: W (arriba), A (izq), S (abajo), D (der), Q (salir al menu)");
            String input = scanner.nextLine().toUpperCase();

            int dx = 0, dy = 0;

            switch (input) {
                case "W": dx = -1; break;
                case "S": dx = 1; break;
                case "A": dy = -1; break;
                case "D": dy = 1; break;
                case "Q": System.out.println("Saliendo..."); return;
                default: System.out.println("Entrada no válida."); continue;
            }

            // Mover a Snake
            snake.mover(dx, dy, mapa);

            // Mover a cada guardia después de Snake
            for (Guardia guardia : guardias) {
                guardia.moverAleatorio(mapa);
            }
            
            // Comprobar distancia entre Snake y cada guardia
            for (Guardia guardia : guardias) {
                if (snake.getPosicion().distancia(guardia.getPosicion()) == 1) {
                    System.out.println("Has sido descubierto. GAME OVER");
                    //scanner.close();
                    //return; // Cierra la ejecución del juego
    }
}
            
            
        }
    }
}