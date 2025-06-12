package com.mycompany.juego;

public class Item extends ObjetoMapa {

    private String nombre;

    // 
    public Item(String nombre) {
        super(nombre, 'L'); // 
        this.nombre = nombre;
    }

    // 
    public Item(String nombre, char simbolo) {
        super(nombre, simbolo); // 
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void alColisionar(Snake snake) {
        // Puede implementarse lógica adicional si es necesario
    }
}
