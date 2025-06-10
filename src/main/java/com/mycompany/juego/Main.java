package com.mycompany.juego;

import java.util.List;
import java.util.Scanner;

public class Main {

    private int misionesCompletadas = 0;

    public void iniciar() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;

            while (!salir) {
                System.out.println("\n--- MENU ---");
                if (misionesCompletadas == 0)
                    System.out.println("1) Iniciar mision");
                else
                    System.out.println("1) Siguiente mision");
                System.out.println("2) Guardar progreso");
                System.out.println("3) Cargar progreso");
                System.out.println("4) Salir");
                System.out.print("Opcion: ");
                String op = scanner.nextLine();

                switch (op) {
                    case "1" -> jugarMisionActual(scanner);
                    case "2" -> guardarProgreso();
                    case "3" -> {
                        System.out.print("Codigo: ");
                        cargarProgreso(scanner.nextLine());
                    }
                    case "4" -> salir = true;
                    default -> System.out.println("Invalido.");
                }
            }

            System.out.println("GOODBYE METALGEAR!");
        }
    }

    private void jugarMisionActual(Scanner scanner) {
        Mision m;
        switch (misionesCompletadas) {
            case 0 -> m = new MisionInicial();
            case 1 -> m = new MisionIntermedia();
            case 2 -> m = new MisionFinal();
            default -> { return; }
        }

        m.configurar();
        Mapa mapa = m.getMapa();
        Snake snake = m.getSnake();
        List<Guardia> guardias = m.getGuardias();

        while (true) {
            if (mapa != null) {
                mapa.imprimirMapa();
                System.out.println("Mover Snake: W/A/S/D, Q para salir mision");
            }

            String in = scanner.nextLine().toUpperCase();
            if ("Q".equals(in)) {
                System.out.println("Mision abortada.");
                return;
            }

            if (mapa != null && snake != null && guardias != null) {
                int dx = 0, dy = 0;
                switch (in) {
                    case "W" -> dx = -1;
                    case "S" -> dx = 1;
                    case "A" -> dy = -1;
                    case "D" -> dy = 1;
                    default -> {
                        System.out.println("Invalido.");
                        continue;
                    }
                }

                //Misión Inicial
                if (m instanceof MisionInicial mi) {
                    int nuevoX = snake.getPosicion().getX() + dx;
                    int nuevoY = snake.getPosicion().getY() + dy;

                    if (mapa.esPosicionValida(nuevoX, nuevoY)) {
                        Celda celdaDestino = mapa.getCelda(nuevoX, nuevoY);

                        if (celdaDestino.getContenido() instanceof Puerta && !snake.tieneLlave()) {
                            System.out.println("La puerta esta bloqueada. Necesitas una llave.");
                            continue;
                        }

                        mi.procesarInteracciones(celdaDestino);
                        mapa.moverPersonaje(snake, dx, dy);
                    }

                    for (Guardia g : guardias) g.moverAleatorio(mapa);

                    boolean perdido = guardias.stream()
                            .anyMatch(g -> snake.getPosicion().distancia(g.getPosicion()) == 1);
                    if (perdido) {
                        System.out.println("Has sido descubierto. GAME OVER");
                        return;
                    }

                    if (mi.misionCompleta()) {
                        System.out.println("Has ganado la primer mision");
                        misionesCompletadas++;
                        break;
                    }
                }

                //Misión Intermedia
                else if (m instanceof MisionIntermedia mi) {
                    int nuevoX = snake.getPosicion().getX() + dx;
                    int nuevoY = snake.getPosicion().getY() + dy;

                    if (mapa.esPosicionValida(nuevoX, nuevoY)) {
                        Celda celdaDestino = mapa.getCelda(nuevoX, nuevoY);

                        boolean finaliza = mi.procesarInteracciones(celdaDestino);

                        if (celdaDestino.estaVacia() || (celdaDestino.getContenido() instanceof Puerta && snake.tieneC4())|| celdaDestino.getContenido() instanceof Item) {
                            mapa.moverPersonaje(snake, dx, dy);
                        }

                        for (Guardia g : guardias) g.moverAleatorio(mapa);

                        boolean perdido = guardias.stream()
                                .anyMatch(g -> snake.getPosicion().distancia(g.getPosicion()) == 1);
                        if (perdido) {
                            System.out.println("Has sido descubierto. GAME OVER");
                            return;
                        }

                        if (finaliza || mi.misionCompleta()) {
                            System.out.println("Has ganado la segunda mision");
                            misionesCompletadas++;
                            break;
                        }
                    }
                }

                else {
               
                    return;
                }
            }
        }
    }

    private void guardarProgreso() {
        String codigo = "PBA25-" + misionesCompletadas;
        System.out.println("Tu codigo de guardado es: " + codigo);
    }

    private void cargarProgreso(String codigo) {
        if (codigo != null && codigo.startsWith("PBA25-")) {
            try {
                int valor = Integer.parseInt(codigo.substring(6));
                if (valor >= 0 && valor <= 3) {
                    misionesCompletadas = valor;
                    System.out.println("Progreso cargado. Misiones completadas: " + misionesCompletadas);
                } else {
                    System.out.println("Codigo inválido: número fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Codigo invalido: formato incorrecto.");
            }
        } else {
            System.out.println("Codigo invalido: debe comenzar con 'PBA25-'.");
        }
    }

    public static void main(String[] args) {
        new Main().iniciar();
    }
}
