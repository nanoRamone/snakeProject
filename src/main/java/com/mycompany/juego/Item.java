package com.mycompany.juego;

public class Item extends ObjetoMapa {
    private boolean recogido = false;
    private Puerta puertaAsociada;

    public Item(String nombre, Puerta puertaAsociada) {
        super(nombre);
        this.puertaAsociada = puertaAsociada;
    }

    public void recoger() {
        if (!recogido) {
            recogido = true;
            puertaAsociada.abrir();
        }
    }

    public boolean fueRecogido() {
        return recogido;
    }
}