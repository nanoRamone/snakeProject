package com.mycompany.juego;

// Personaje controlado por el jugador
public class Snake extends Personaje {

    private boolean tieneLlave = false;  // indica si Snake tiene la llave
    private boolean tieneC4 = false; // indica si Snake tiene el C4

    public Snake(String nombre, Posicion posicion) {
        super(nombre, posicion);
    }

    // Indica si Snake tiene la llave
    public boolean tieneLlave() {
        return tieneLlave;
    }

    // Marca que Snake ha obten1ido la llave
    public void recogerLlave() {
        tieneLlave = true;
    }

    public boolean tieneC4() {
        return tieneC4;
    }   

    public void recogerC4() {
        tieneC4 = true;
    }

    // Movimiento básico: delega en el mapa si puede moverse
    @Override
    public void mover(int dx, int dy, Mapa mapa) {
        mapa.moverPersonaje(this, dx, dy);
    }
}
