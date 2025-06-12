package com.mycompany.juego;

import java.util.ArrayList;

public class MisionInicial extends Mision {

    private Puerta puerta;

    @Override
    public void configurar() {
        mapa = new Mapa(7, 7);

        // Snake en posición aleatoria libre
        Posicion p;
        do { p = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(p.getX(), p.getY()).estaVacia());
        snake = new Snake("Snake", p);
        mapa.getCelda(p.getX(), p.getY()).setContenido(snake);

        // Puerta fija
        puerta = new Puerta("Puerta del Hangar");
        mapa.getCelda(0, 3).setContenido(puerta);

        // Llave en posición aleatoria
        Posicion pl;
        do { pl = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(pl.getX(), pl.getY()).estaVacia());
        Item llave = new Item("Llave");
        mapa.getCelda(pl.getX(), pl.getY()).setContenido(llave);

        // Guardias a ≥2 de Snake
        guardias = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Posicion pg;
            do {
                pg = mapa.generarPosicionAleatoria();
            } while (!mapa.getCelda(pg.getX(), pg.getY()).estaVacia() ||
                     pg.distancia(p) < 2);
            Guardia g = new Guardia("Guardia" + (i+1), pg);
            mapa.getCelda(pg.getX(), pg.getY()).setContenido(g);
            guardias.add(g);
        }
    }

    @Override
    public boolean misionCompleta() {
        return puerta.abierta &&
               snake.getPosicion().equals(new Posicion(0, 3));
    }

    public boolean procesarInteracciones(Celda celdaDestino) {
        if (celdaDestino.getContenido() instanceof Item llave &&
            llave.getNombre().equals("Llave")) {
            snake.recogerLlave();
            puerta.abrir();
            System.out.println("Has recogido la llave y podras atravesar la puerta");
            celdaDestino.setContenido(null);
        }

        if (celdaDestino.getContenido() instanceof Puerta) {
            if (puerta.abierta) {
                return true;
            } else {
                System.out.println("La puerta está bloqueada. Necesitas una llave.");
            }
        }

        return false;
    }
}
