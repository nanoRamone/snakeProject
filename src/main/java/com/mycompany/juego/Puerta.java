package com.mycompany.juego;

public class Puerta extends ObjetoMapa {
    public boolean abierta = false;

    public Puerta(String nombre) {
        super(nombre);
    }

    public void abrir() {
        System.out.println("La puerta " + getNombre() + " se ha abierto.");
        abierta = true;
    }

}
