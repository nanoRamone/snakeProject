package com.mycompany.juego;

// CLASE BASE PARA OBJETOS DEL MAPA (ITEMS, PUERTAS, ETC.)
public abstract class ObjetoMapa {

    protected String nombre;
    protected char simbolo; // CAMPO AGREGADO PARA ALMACENAR EL SIMBOLO

    // CONSTRUCTOR NECESARIO PARA PUERTA E ITEM
    public ObjetoMapa(String nombre, char simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo; // SE ASIGNA EL SIMBOLO
    }

    public String getNombre() {
        return nombre;
    }

    // CAMBIO REALIZADO: EL MÉTODO YA NO ES ABSTRACTO, DEVUELVE EL SIMBOLO DEFINIDO
    public char getSimbolo() {
        return simbolo;
    }
}
