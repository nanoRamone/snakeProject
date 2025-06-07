package com.mycompany.juego;

import java.util.ArrayList;

public class MisionInicial extends Mision {

    private Puerta puerta;  //GENERA ATRIBUTO PARA PODER FINALIZAR MISION COMPLETA

    @Override
    public void configurar() {
        // 1) Mapa 7×7
        mapa = new Mapa(7, 7);

        // 2) Snake en posición aleatoria libre
        Posicion p;
        do { p = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(p.getX(), p.getY()).estaVacia());
        snake = new Snake("Snake", p);
        mapa.getCelda(p.getX(), p.getY()).setContenido(snake);

        // 3) Puerta fija y llave
        puerta = new Puerta("Puerta del Hangar");  // 🔧 se asigna al atributo de clase
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
        //  5)VERIFICA QUE LA MISION ESTE COMPELTA
    @Override
    public boolean misionCompleta() { 
        return puerta.estaDesbloqueada() &&
               snake.getPosicion().equals(new Posicion(0, 3));
    }
}
