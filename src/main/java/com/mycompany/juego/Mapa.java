package com.mycompany.juego;

import java.util.Random;

public class Mapa {
    private int filas;
    private int columnas;
    private Celda[][] celdas;
    private Puerta puerta;

    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        celdas = new Celda[filas][columnas];
        inicializarCeldas();
    }

    private void inicializarCeldas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    public Celda getCelda(int x, int y) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            return celdas[x][y];
        } else {
            return null;
        }
    }

public boolean moverPersonaje(Personaje personaje, int dx, int dy) {
    int nuevoX = personaje.getPosicion().getX() + dx;
    int nuevoY = personaje.getPosicion().getY() + dy;
    

    if (nuevoX < 0 || nuevoX >= filas || nuevoY < 0 || nuevoY >= columnas) {
        System.out.println("Movimiento fuera del mapa.");
        return false;
    }

    Celda destino = celdas[nuevoX][nuevoY];

    // Solo permite mover si la celda está vacía
    if (!destino.estaBloqueada()) { //&& destino.estaVacia()1
        // Limpia la celda actual
        Celda actual = celdas[personaje.getPosicion().getX()][personaje.getPosicion().getY()];
        actual.setContenido(null);

        // Mueve al personaje
        destino.setContenido(personaje);
        personaje.setPosicion(new Posicion(nuevoX, nuevoY));
        return true;
    } else {
        System.out.println("No puedes moverte allí, espacio ocupado o bloqueado.");
        return false;
        }
    }

    public void imprimirMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Object contenido = celdas[i][j].getContenido();

                if (contenido instanceof Snake) {
                    System.out.print("S ");
                } else if (contenido instanceof Guardia) {
                    System.out.print("G ");
                } else if (contenido instanceof MetalGear) {
                    System.out.print("M ");
                } else if (contenido instanceof Item) {
                    System.out.print("L "); // L de "Llave"
                } else if (contenido instanceof Puerta) {
                    System.out.print("H "); // H de "Hangar"
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public Posicion generarPosicionAleatoria() {
        Random random = new Random();
        int x = random.nextInt(filas);
        int y = random.nextInt(columnas);
        return new Posicion(x, y);
    }
    
    public boolean esPosicionValida(int x, int y) {
    return x >= 0 && x < filas && y >= 0 && y < columnas;
    }

}
