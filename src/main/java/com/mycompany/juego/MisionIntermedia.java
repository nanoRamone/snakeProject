package com.mycompany.juego;

import java.util.ArrayList;

public class MisionIntermedia extends Mision {

    private Puerta puerta;
    private boolean misionCompleta;
    private boolean misionFallida;

    @Override
    public void configurar() {
        mapa = new Mapa(9, 9);

        // Snake en posición aleatoria libre
        Posicion p;
        do { p = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(p.getX(), p.getY()).estaVacia());
        snake = new Snake("Snake", p);
        mapa.getCelda(p.getX(), p.getY()).setContenido(snake);

        // Colocar el simbolo P en mapa
        puerta = new Puerta("Puerta Reforzada", 'P');
        mapa.getCelda(0, 4).setContenido(puerta);

        // Colocar C4 en mapa
        Posicion pc4;
        do { pc4 = mapa.generarPosicionAleatoria(); }
        while (!mapa.getCelda(pc4.getX(), pc4.getY()).estaVacia());
        Item c4 = new Item("C4", 'C'); 
        mapa.getCelda(pc4.getX(), pc4.getY()).setContenido(c4);

        // Guardias colocados a ≥2 de Snake
        guardias = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
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

        return this.misionCompleta;
    }

    public boolean misionFallida() {
        return this.misionFallida;
    }   

    public boolean procesarInteracciones(Celda celdaDestino) {
        if (celdaDestino.getContenido() instanceof Item item &&
            item.getNombre().equals("C4")) {
            snake.recogerC4();
            puerta.abrir();
            System.out.println("Snake recogio el C4 y ahora puede detonar la puerta");
            celdaDestino.setContenido(null);
            return true; // Indica que se recogió el C4
        }

        if (celdaDestino.getContenido() instanceof Puerta) {
            if (!snake.tieneC4()) {
                System.out.println("Necesitas el C4 para detonar la puerta");
                return false;
            } else {
                //Verificar si algún guardia está cerca
                for (Guardia g : guardias) {
                    if (g.getPosicion().distancia(snake.getPosicion()) < 3) {
                        System.out.println("Los guardias te han descubierto. Has perdido.");
                        this.misionFallida = true; // Si hay un guardia cerca, la misión falla
                        return false; 
                    }
                }
                this.misionCompleta = true; // Si no hay guardias cerca, se puede detonar la puerta
                return true; 
            }
        }
        //Si no salgo por la positiva en ninguna condicion, retorno false
        return false;
    }
}
