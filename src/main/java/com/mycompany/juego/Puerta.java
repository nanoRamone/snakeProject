package com.mycompany.juego;

public class Puerta extends ObjetoMapa {
    private boolean abierta = false;

    public Puerta(String nombre) {
        super(nombre);
    }

    public void abrir() {
        abierta = true;
    }

    public boolean estaAbierta() {
        return abierta;
    }
}