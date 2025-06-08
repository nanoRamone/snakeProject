package com.mycompany.juego;

// Personaje controlado por el jugador
public class Snake extends Personaje {

    private boolean tieneLlave = false;  // indica si Snake tiene la llave

    public Snake(String nombre, Posicion posicion) {
        super(nombre, posicion);
    }

    // Indica si Snake tiene la llave
    public boolean tieneLlave() {
        return tieneLlave;
    }

    // Marca que Snake ha obtenido la llave
    public void obtenerLlave() {
        tieneLlave = true;
    }

    // Movimiento básico: delega en el mapa si puede moverse
    @Override
    public void mover(int dx, int dy, Mapa mapa) {
    boolean pudoMover = mapa.moverPersonaje(this, dx, dy);
    if (pudoMover) {
        System.out.println(nombre + " se movió a (" + posicion.getX() + ", " + posicion.getY() + ")");
    } else {
        System.out.println("Movimiento inválido para " + nombre);
    }
}

    boolean tieneItem(Item c4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}