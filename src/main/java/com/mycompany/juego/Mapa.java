package com.mycompany.juego;

import java.util.Random;

public class Mapa {
<<<<<<< HEAD
    private final int filas;
    private final int columnas;
    private final Celda[][] celdas;
=======
    private int filas;
    private int columnas;
    private Celda[][] celdas;
    private Puerta puerta;
>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2

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

<<<<<<< HEAD
    public boolean moverPersonaje(Personaje personaje, int dx, int dy) {
        int nuevoX = personaje.getPosicion().getX() + dx;
        int nuevoY = personaje.getPosicion().getY() + dy;
=======
public boolean moverPersonaje(Personaje personaje, int dx, int dy) {
    int nuevoX = personaje.getPosicion().getX() + dx;
    int nuevoY = personaje.getPosicion().getY() + dy;
    
>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2

        if (nuevoX < 0 || nuevoX >= filas || nuevoY < 0 || nuevoY >= columnas) {
            System.out.println("Movimiento fuera del mapa.");
            return false;
        }

        Celda destino = celdas[nuevoX][nuevoY];

        // Solo permite mover si la celda está vacía
        if (!destino.estaBloqueada()) { //&& destino.estaVacia()
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

<<<<<<< HEAD
=======
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

>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2
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
                } 
                // para usar simbolo que definimos en ObjetoMapa
                else if (contenido instanceof ObjetoMapa) {
                    System.out.print(((ObjetoMapa) contenido).getSimbolo() + " ");
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

<<<<<<< HEAD
    public boolean esPosicionValida(int x, int y) {
        return x >= 0 && x < filas && y >= 0 && y < columnas;
    }
=======
>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2
}
