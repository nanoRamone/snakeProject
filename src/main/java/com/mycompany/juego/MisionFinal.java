package com.mycompany.juego;

import java.util.Random;
import java.util.Scanner;

public class MisionFinal extends Mision {
    
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

            if (opcion.equals("1")) {
                int danio = rand.nextInt(21) + 10; // 10 a 30
                vidaRex -= danio;
                System.out.println("¡Le diste a REX! (-" + danio + " HP)");
            } else if (opcion.equals("2")) {
                System.out.println("¡Esquiva!");
            } else {
                System.out.println("Opción inválida. Pierdes el turno.");
            }

            if (vidaRex <= 0) break;

            int ataqueRex = rand.nextInt(26) + 15; // 15 a 40
            boolean esquivando = opcion.equals("2");
            if (esquivando) {
                int reduccion = rand.nextInt(51) + 50; // 50% a 100%
                int danioReducido = ataqueRex * (100 - reduccion) / 100;
                vidaSnake -= danioReducido;
                System.out.println("Snake, el asesino que se divierte" + danioReducido + " HP.");
            } else {
                vidaSnake -= ataqueRex;
                System.out.println("¡El sacrificio de Meryl sera tu perdicion! (-" + ataqueRex + " HP)");
            }
        }

        if (vidaSnake <= 0) {
            System.out.println("El mundo no necesita soldados como tu");
            return false;
        } else {
            System.out.println("Has vencido a MetalGear");
            return true;
        }
    }

    @Override
    public void configurar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
