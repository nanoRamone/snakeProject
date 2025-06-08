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
            System.out.println(nombre + " se movio a (" + posicion.getX() + ", " + posicion.getY() + ")");

            // AL PASAR SOBRE EL ITEM LO LEVANTA
            Object contenido = mapa.getCelda(posicion.getX(), posicion.getY()).getContenido();
            if (contenido instanceof Item item) {
                item.recoger();
                System.out.println("¡Has recogido el ítem: " + item.getNombre() + "!");
            }

        } else {
            System.out.println("Movimiento invalido para " + nombre);
        }
    }

    boolean tieneItem(Item c4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}