package com.mycompany.juego;

public class Puerta extends ObjetoMapa {
    private boolean abierta = false;

    public Puerta(String nombre) {
        super(nombre);
    }

    public void abrir() {
        abierta = true;
    }

    public boolean estaAbierta() {
        return abierta;
    }

    // Se agrega este método solo para compatibilidad con el resto del juego
    public boolean estaDesbloqueada() {
        return estaAbierta(); // usa la misma lógica interna
    }
}
