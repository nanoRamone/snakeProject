package com.mycompany.juego;

public abstract class ObjetoMapa {
    private String nombre;

    public ObjetoMapa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}