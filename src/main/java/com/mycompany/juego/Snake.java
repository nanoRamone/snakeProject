package com.mycompany.juego;

// Personaje controlado por el jugador
public class Snake extends Personaje {

    public Snake(String nombre, Posicion posicion) {
        super(nombre, posicion);
    }

    // Movimiento básico: delega en el mapa si puede moverse
    @Override
    public void mover(int dx, int dy, Mapa mapa) {
        boolean pudoMover = mapa.moverPersonaje(this, dx, dy);
        if (pudoMover) {
            System.out.println(nombre + " se movio a (" + posicion.getX() + ", " + posicion.getY() + ")");
        } else {
            System.out.println("Movimiento invalido para " + nombre);
        }
    }
}