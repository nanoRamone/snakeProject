package com.mycompany.juego;

import java.util.ArrayList;

public class MisionIntermedia extends Mision {
    @Override
    public void configurar() {
            // 1) Mapa 9×9
        mapa = new Mapa(9, 9);

        // 2) Snake en posición aleatoria libre
        Posicion p;
        do { p = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(p.getX(), p.getY()).estaVacia());
        snake = new Snake("Snake", p);
        mapa.getCelda(p.getX(), p.getY()).setContenido(snake);

        // 3) Puerta fija y llave
        Puerta puerta = new Puerta("Puerta del Hangar");
        mapa.getCelda(0, 3).setContenido(puerta);

        Posicion pl;
        do { pl = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(pl.getX(), pl.getY()).estaVacia());
        Item llave = new Item("Llave", puerta);
        mapa.getCelda(pl.getX(), pl.getY()).setContenido(llave);

        // 4) Guardias a ≥2 de distancia
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
}