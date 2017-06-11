package com.mercado.libre.model;

/**
 *
 */
public interface Planetable {

    Punto getPunto();
    void setPunto(Punto punto);
    Integer getDistanciaAlSol();
    void setDistanciaAlSol(Integer distanciaAlSol);
    Integer getPosicionAngular();
    void setPosicionAngular(Integer posicionAngular);
    Integer getMovimientoAngular();
    void setMovimientoAngular(Integer movimientoAngular);
    void desplazate();

}
