package com.mycompany.juego;

// Clase base para todos los personajes del juego (Snake, Guardia, MetalGear)
public abstract class Personaje {
    protected String nombre;
    protected Posicion posicion;
    //prueba de commit
    // Constructor con nombre y posición inicial
    public Personaje(String nombre, Posicion posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    // Método abstracto que cada personaje debe implementar con su forma de moverse
    public abstract void mover(int dx, int dy, Mapa mapa);
}