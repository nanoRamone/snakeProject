package com.mycompany.juego;

public class Puerta extends ObjetoMapa {

    private String nombre;
    public boolean abierta = false;

    // CONSTRUCTOR ORIGINAL (SE MANTIENE)
    public Puerta(String nombre) {
        super(nombre, 'H'); // ✅ SE ADAPTA A LA NUEVA FIRMA DEL CONSTRUCTOR (NOMBRE + SIMBOLO)
        this.nombre = nombre;
    }

    // NUEVO CONSTRUCTOR AGREGADO PARA PERMITIR SIMBOLO PERSONALIZADO
    public Puerta(String nombre, char simbolo) {
        super(nombre, simbolo); // ✅ CORREGIDO: SE LLAMA AL CONSTRUCTOR CORRECTO
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void abrir() {
        abierta = true;
    }

    public void alColisionar(Snake snake) {
        // Lógica de interacción con la puerta, si aplica
    }
}
