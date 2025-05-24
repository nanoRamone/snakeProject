package com.mycompany.juego;

// Clase que representa una coordenada en el mapa (x, y)
public class Posicion {
    private int x;
    private int y;

    // Constructor que recibe coordenadas
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters para acceder a las coordenadas
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Método para mover la posición (suma desplazamientos)
    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Método para comparar dos posiciones (necesario para lógicas del juego)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion)) return false;
        Posicion p = (Posicion) o;
        return x == p.x && y == p.y;
    }
    
    // Método necesario cuando se usa Posicion en estructuras como HashSet
    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}