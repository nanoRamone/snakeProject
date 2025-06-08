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
        Item llave = new Item("Llave");
        mapa.getCelda(pl.getX(), pl.getY()).setContenido(llave);

        // 4) Guardias a ≥2 de distancia
        guardias = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
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
        return puerta.abierta &&
               snake.getPosicion().equals(new Posicion(0, 3));
    }


public boolean procesarInteracciones(Celda celdaDestino) {
    // Si hay una llave, la recoge y desbloquea la puerta
    if (celdaDestino.getContenido() instanceof Item llave) {
        if (llave.getNombre().equals("Llave")) {
            snake.obtenerLlave();
            puerta.abierta = true; // Desbloquea la puerta correctamente
            System.out.println("¡Has recogido la llave! La puerta está desbloqueada.");
            celdaDestino.setContenido(null); // Elimina la llave de la celda
        }
    }

    // Si hay una puerta, verifica si está desbloqueada
    if (celdaDestino.getContenido() instanceof Puerta) {
        if (puerta.abierta) {
            System.out.println("¡Has llegado a la puerta del hangar! Misión completa.");
            return true; // Indica que la misión debe terminar
        } else {
            System.out.println("La puerta está bloqueada. Necesitas una llave.");
        }
    }
    return false; // No terminó la misión
}

    

}


