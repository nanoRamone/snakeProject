package com.mycompany.juego;

import java.util.List;
import java.util.Scanner;

public class Main {

    private int misionesCompletadas = 0;

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Iniciar mision");
            System.out.println("2) Guardar progreso");
            System.out.println("3) Cargar progreso");
            System.out.println("4) Salir");
            System.out.print("Opcion: ");
            String op = scanner.nextLine();

            switch (op) {
                case "1" -> jugarMisionActual(scanner);
                case "2" -> guardarProgreso();
                case "3" -> {
                    System.out.print("Código: ");
                    cargarProgreso(scanner.nextLine());
                }
                case "4" -> salir = true;
                default -> System.out.println("Inválido.");
            }
        }

        System.out.println("GOODBYE METALGEAR!");
        scanner.close();
    }

    private void jugarMisionActual(Scanner scanner) {
        // Bucle para avanzar automáticamente entre misiones si se completan
        while (misionesCompletadas < 3) {
            Mision m;
            switch (misionesCompletadas) {
                case 0 -> m = new MisionInicial();
                case 1 -> m = new MisionIntermedia();
                case 2 -> m = new MisionFinal();
                default -> { return; }
            }

            // Configura el escenario de la misión (mapa, Snake, enemigos, ítems, etc.)
            m.configurar();
            Mapa mapa = m.getMapa();
            Snake snake = m.getSnake();
            List<Guardia> guardias = m.getGuardias();

            // Loop de juego
            while (true) {
                // VERIFICAR MAPA, EN LA MISION FINAL NO LO REQUIERE
                if (mapa != null) {
                    mapa.imprimirMapa();
                    System.out.println("Mover Snake: W/A/S/D, Q para salir misión");
                }

                String in = scanner.nextLine().toUpperCase();
                if ("Q".equals(in)) {
                    System.out.println("Misión abortada.");
                    return;
                }

                // VERIFICAR MOVIMIENTOS DE PERSONAJES, EN LA MISION FINAL NO LO REQUIERE
                if (mapa != null && snake != null && guardias != null) {
                    int dx = 0, dy = 0;
                    if      ("W".equals(in)) dx = -1;
                    else if ("S".equals(in)) dx = 1;
                    else if ("A".equals(in)) dy = -1;
                    else if ("D".equals(in)) dy = 1;
                    else {
                        System.out.println("Invalido.");
                        continue;
                    }

                    // Mover jugador y enemigos
                    snake.mover(dx, dy, mapa);
                    for (Guardia g : guardias) g.moverAleatorio(mapa);

                    // Chequear derrota (si un guardia está junto a Snake)
                    boolean perdido = guardias.stream()
                        .anyMatch(g -> snake.getPosicion().distancia(g.getPosicion()) == 1);
                    if (perdido) {
                        System.out.println("Has sido descubierto. GAME OVER");
                        return;
                    }
                }

                // SE IMPLEMENTA METODO PARA VERIFICAR QUE LA MISION SE CUMPLIO1
                if (m.misionCompleta()) {
                    System.out.println("¡Has ganado la misión!");
                    misionesCompletadas++;
                    break; // pasa a la siguiente misión automáticamente
                    
                }
            }
        }

        System.out.println("¡FELICITACIONES! Has completado todas las misiones.");
    }

    private void guardarProgreso() {
        String codigo = "PBA25-" + misionesCompletadas;
        System.out.println("Tu código de guardado es: " + codigo);
    }

    private void cargarProgreso(String codigo) {
        if (codigo != null && codigo.startsWith("PBA25-")) {
            try {
                int valor = Integer.parseInt(codigo.substring(6));
                if (valor >= 0 && valor <= 3) {
                    misionesCompletadas = valor;
                    System.out.println("Progreso cargado. Misiones completadas: " + misionesCompletadas);
                } else {
                    System.out.println("Código inválido: número fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Código inválido: formato incorrecto.");
            }
        } else {
            System.out.println("Código inválido: debe comenzar con 'PBA25-'.");
        }
    }

    public static void main(String[] args) {
        new Main().iniciar();
    }
}
