package com.mycompany.juego;

import java.util.Random;
import java.util.Scanner;

public class MisionFinal extends Mision {
    //GUARDA EL RESULTADO DE VICTORIA
    private boolean resultadoFinal = false;

    public boolean iniciar() {
        System.out.println("FINAL BATLLE");

        int vidaSnake = 100;
        int vidaRex = 100;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        while (vidaSnake > 0 && vidaRex > 0) {
            System.out.println("\nTu vida: " + vidaSnake + " HP | Vida de REX: " + vidaRex + " HP");
            System.out.println("Turno de Snake:");
            System.out.println("1 - Disparar misil");
            System.out.println("2 - Esquivar");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    int danio = rand.nextInt(21) + 10; // 10 a 30
                    vidaRex -= danio;
                    System.out.println("Le diste a REX! (-" + danio + " HP)");
                }
                case "2" -> System.out.println("Esquiva");
                default -> System.out.println("Opcion inválida. Pierdes el turno.");
            }

            if (vidaRex <= 0) break;

            int ataqueRex = rand.nextInt(26) + 15; // 15 a 40
            boolean esquivando = opcion.equals("2");
            if (esquivando) {
                int reduccion = rand.nextInt(51) + 50; // 50% a 100%
                int danioReducido = ataqueRex * (100 - reduccion) / 100;
                vidaSnake -= danioReducido;
                System.out.println("Snake, el asesino que se divierte: " + danioReducido + " HP.");
            } else {
                vidaSnake -= ataqueRex;
                System.out.println("El sacrificio de Meryl sera tu perdicion (-" + ataqueRex + " HP)");
            }
        }

        if (vidaSnake <= 0) {
            System.out.println("El mundo no necesita soldados como tu. GAME OVER");
            resultadoFinal = false;
            return false;
        } else {
            System.out.println("VICTORIA. Felicitaciones, has derrotado a MetalGear");
            resultadoFinal = true;
            return true;
        }
    }

    @Override
           //EJECUTA LA BATALLA EN MAIN
    public void configurar() {
        iniciar();
    }
           // VERIFICA QUE MISION ESTE COMPLETADA
    @Override
    public boolean misionCompleta() {
        return resultadoFinal;
    }
}
