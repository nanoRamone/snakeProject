package com.mycompany.juego;

public class Item extends ObjetoMapa {
    private boolean recogido = false;

    public Item(String nombre) {
        super(nombre);
    }

    public void recoger() {
        if (!recogido) {
            recogido = true;
        }
    }

    public boolean fueRecogido() {
        return recogido;
    }
}