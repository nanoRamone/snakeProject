package com.mycompany.juego;

<<<<<<< HEAD
public class Item extends ObjetoMapa {
=======
public class Item extends ItemMapa {
    private boolean recogido = false;
>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2

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
