package com.mycompany.juego;

public class Item extends ItemMapa {
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