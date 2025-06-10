package com.mycompany.juego;

public abstract class ItemMapa {
    private final String nombre;

    public ItemMapa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}