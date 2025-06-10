package com.mycompany.juego;

import java.util.List;

public abstract class Mision {
    protected Mapa mapa;
    protected Snake snake;
    protected List<Guardia> guardias;

    /**  
     * Monta el escenario: crea mapa, coloca Snake, guardias, items, puertas…
     */
    public abstract void configurar();

    /**  
     * Devuelve el mapa ya configurado.  
     * @return 
     */
    public Mapa getMapa() {
        return mapa;
    }

    /**  
     * Devuelve la instancia de Snake en este escenario.  
     * @return 
     */
    public Snake getSnake() {
        return snake;
    }

    /**  
     * Devuelve la lista de guardias en este escenario.  
     * @return 
     */
    public List<Guardia> getGuardias() {
        return guardias;
    }

    boolean misionCompleta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}