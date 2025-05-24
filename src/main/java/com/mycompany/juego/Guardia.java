package com.mycompany.juego;

public class Guardia extends Personaje {

    public Guardia(String nombre, Posicion posicion) {
        super(nombre, posicion);
    }

    @Override
    public void mover(int dx, int dy, Mapa mapa) {
        // Por ahora no se mueve automáticamente
        boolean pudoMover = mapa.moverPersonaje(this, dx, dy);
        if (pudoMover) {
            System.out.println(nombre + " se movió a (" + posicion.getX() + ", " + posicion.getY() + ")");
        } else {
            System.out.println(nombre + " no pudo moverse");
        }
    }
}