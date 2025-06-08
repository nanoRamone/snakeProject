package com.mycompany.juego;

import java.util.ArrayList;

public class MisionIntermedia extends Mision {

    private Puerta puerta;

    @Override
    public void configurar() {
        // Mapa 9x9
        mapa = new Mapa(9, 9);

        // Snake en posición aleatoria libre
        Posicion p;
        do { p = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(p.getX(), p.getY()).estaVacia());
        snake = new Snake("Snake", p);
        mapa.getCelda(p.getX(), p.getY()).setContenido(snake);

        // Puerta fija 
        puerta = new Puerta("Puerta Reforzada");
        mapa.getCelda(0, 4).setContenido(puerta);

        Posicion pc4;
        do { pc4 = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(pc4.getX(), pc4.getY()).estaVacia());
        Item c4 = new Item("C4", puerta);  // 🔧 Item especial para esta misión
        mapa.getCelda(pc4.getX(), pc4.getY()).setContenido(c4);

        // Guardias colocados a ≥2 de Snake
        guardias = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Posicion pg;
            do {
                pg = mapa.generarPosicionAleatoria();
            } while (
                !mapa.getCelda(pg.getX(), pg.getY()).estaVacia() ||
                pg.distancia(p) < 2
            );
            Guardia g = new Guardia("Guardia" + (i+1), pg);
            mapa.getCelda(pg.getX(), pg.getY()).setContenido(g);
            guardias.add(g);
        }
    }

    @Override
    public boolean misionCompleta() {
        // Condición: puerta destruida, Snake en la celda de la puerta y SIN guardias a 2 celdas
        if (!puerta.estaDesbloqueada()) return false;
        if (!snake.getPosicion().equals(new Posicion(0, 4))) return false;

        for (Guardia g : guardias) {
            if (g.getPosicion().distancia(snake.getPosicion()) <= 2) {
                return false;  // Hay un guardia demasiado cerca
            }
        }

        return true;
    }
}