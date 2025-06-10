package com.mycompany.juego;

// Representa una casilla del mapa. Puede estar bloqueada y contener algo (personaje, item, etc.)
public class Celda {
    private boolean bloqueada;
    private Object contenido; // Puede ser Snake, Guardia, ítem, etc.

    // Constructor por defecto: celda vacía y desbloqueada
    public Celda() {
        this.bloqueada = false;
        this.contenido = null;
    }

    public boolean estaBloqueada() {
        return bloqueada;
    }

    public void bloquear() {
        this.bloqueada = true;
    }

    public void desbloquear() {
        this.bloqueada = false;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    // Verifica si hay algo o está vacía
    public boolean estaVacia() {
        return contenido == null;
    }
}