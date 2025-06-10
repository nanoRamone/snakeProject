package com.mycompany.juego;

<<<<<<< HEAD
public abstract class ItemMapa {
    private final String nombre;

    public ItemMapa(String nombre) {
        this.nombre = nombre;
=======
<<<<<<<< HEAD:src/main/java/com/mycompany/juego/ObjetoMapa.java
// CLASE BASE PARA OBJETOS DEL MAPA (ITEMS, PUERTAS, ETC.)
public abstract class ObjetoMapa {

    protected String nombre;
    protected char simbolo; // CAMPO AGREGADO PARA ALMACENAR EL SIMBOLO

    // CONSTRUCTOR NECESARIO PARA PUERTA E ITEM
    public ObjetoMapa(String nombre, char simbolo) {
========
public abstract class ItemMapa {
    private String nombre;

    public ItemMapa(String nombre) {
>>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2:src/main/java/com/mycompany/juego/ItemMapa.java
        this.nombre = nombre;
        this.simbolo = simbolo; // SE ASIGNA EL SIMBOLO
>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2
    }

    public String getNombre() {
        return nombre;
    }
<<<<<<< HEAD
}
=======

    // CAMBIO REALIZADO: EL MÉTODO YA NO ES ABSTRACTO, DEVUELVE EL SIMBOLO DEFINIDO
    public char getSimbolo() {
        return simbolo;
    }
}
>>>>>>> a8fe8a7daac166e1f18029976a0066ae33fbecc2
