package com.mycompany.juego;

import java.util.Random;

public class Guardia extends Personaje {

    public Guardia(String nombre, Posicion posicion) {
        super(nombre, posicion);
    }

    @Override
    public void mover(int dx, int dy, Mapa mapa) {
        // Este método queda sin uso porque el movimiento lo hace moverAleatorio()
    }

    public void moverAleatorio(Mapa mapa) {
        Random rand = new Random();
        int[] direcciones = {-1, 0, 1};

        int intentos = 0;
        boolean seMovio = false;

        while (!seMovio && intentos < 10) {
            int dx = direcciones[rand.nextInt(3)];
            int dy = direcciones[rand.nextInt(3)];

            // Evita quedarse quieto
            if (dx == 0 && dy == 0) continue;

            int nuevoX = posicion.getX() + dx;
            int nuevoY = posicion.getY() + dy;

            // Si el movimiento es válido y la celda destino está vacía
            if (mapa.esPosicionValida(nuevoX, nuevoY) && mapa.getCelda(nuevoX, nuevoY).estaVacia()) {
                // Limpia la celda actual
                mapa.getCelda(posicion.getX(), posicion.getY()).setContenido(null);
                
                // Actualiza la posición y la celda nueva
                setPosicion(new Posicion(nuevoX, nuevoY));
                mapa.getCelda(nuevoX, nuevoY).setContenido(this);
                seMovio = true;
            }

            intentos++;
        }
    }
}